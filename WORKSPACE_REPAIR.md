# 工作区修复与重置版迁移

## 2026-09-29 MCreator 覆盖检查

当前成品保留 PrimogemCraftNeo 必装声明，版本范围为 `[0,)`；下文历史记录中的
精确版本限制已取消。默认编译包仍为仓库自带的 1.0.5。

核对本机 MCreator 2026.2 的生成器模板及 `WorkspaceGeneratorSetup` 字节码：
`shouldSetupBeRan` 在 `.mcreator/setupInfo` 的 `buildFileVersion` 与生成器完整版本
一致时跳过基础设置；本仓库的 21.1.232 与该生成器匹配。缺失标记、版本不匹配
或主动重置会重新写入基础文件，丢失自定义脚本入口并将 NeoForge 还原为 21.1.232。
普通依赖生成通过 `WorkspaceSettings.getVersionRange` 获取范围，未由 Mod API 插件
指定版本时使用 `[0,)`。自定义脚本不放在 MCreator 重写的 `mcreator.gradle` 中。

CI 显式执行 `build prepareClientRun verifyExport verifyWeaponLocalization`，即使
脚本入口及其挂载的检查同时丢失，也会因检查任务不存在失败，停止产物上传。
使用本机生成器的原始 `build.gradle` 模板在临时副本模拟覆盖，确认该命令被拒绝。

仅复制 Git 跟踪文件的当前内容（含待提交修改和 setupInfo）到全新临时目录，
使用 MCreator 自带 JDK、禁用外部 JDK 探测和 Gradle 构建缓存执行
`clean build prepareClientRun verifyExport verifyWeaponLocalization --no-build-cache`
成功，导出检查覆盖 869 个类，三种语言加载检查通过。仍复用了全局依赖下载和
NeoForm 缓存；未操作 MCreator 图形界面的首次打开、重新生成及导出按钮。

成员拉取前应关闭工作区，拉取后重新打开；不要主动重置构建文件。
此验证针对 MCreator 2026.2 的当前生成器，不保证其他版本或第三方插件组合。
CI 能阻止失败产物上传，但不能阻止本地编辑器覆盖文件，也不能替代分支保护规则。

## 使用

成员使用 **MCreator 2026.2** 打开仓库中的 `oneiricconcept.mcreator`，等待首次
工作区设置完成，然后使用 MCreator 的运行客户端按钮或导出模组功能。
不需要控制台、IDE 或手动配置依赖。MCreator 自带运行环境，项目自动获取 Java 21 工具链。
MCreator 导出源文件：`build/libs/modid-1.0.jar`；内部版本跟随工作区设置。

依赖定义位于独立的 `gradle/oneiricconcept.gradle`，由 `build.gradle` 引入。重置版使用
`libs/primogemcraftneo-1.0.5.jar`；GenshinCraft 3.1.3 从 Modrinth 获取，REI 为 16.0.799。
来源与校验值见 `libs/README.md`。首次构建仍可能下载 Minecraft、NeoForge、
GenshinCraft、REI 等依赖；这不代表所有依赖完全离线。

## 修复内容

- 从 `df519490` 的 `src` 恢复 409 个仍被工作区元数据引用的文件，以及
  8 个工具/树叶标签文件。没有回退整个提交，保留用户已有的 LYAAA 格式调整。
- 修复缺失 import、未定义循环索引、LYAAA 距离计算表达式、SakuraTree 调用
  参数不一致；修正四个掉落表元数据中的失效路径。
- 迁移计时器、均衡等级、精炼读取、武器描述和事件 API。
  Neo 精炼从 1 开始，OC 的现有过程使用零基加成，适配器保留这一约定。
- 事件组 1000–1006 保留为 OC 逻辑编号，映射到 Neo 动态分配的事件组。
  附魔奖励改用 Neo LOW/MEDIUM 选择接口；重子挑战采用 Neo 的挑战时限和奖励
  接口。这部分不是旧事件数字编号的直接等价替换。
- 根据注册名称和上游源码迁移物品、实体和效果引用；祈愿掉落条件迁移至
  `wish/blue`、`wish/purple`、`wish/gold`。对照表见
  `docs/primogemcraftneo-id-map.json`。
- 两条带组件配方的 `source` 改为 Ingredient 对象；移除调试函数中失效的
  ocfly 命令，修正草元素发射器的模型父级。

## MCreator

生成器、975 个模组元素和文件结构均保留，全部元素登记的 `src` 文件已检查存在。
必要的修改元素保持代码锁定，避免旧图形过程和元素定义覆盖修复。
`elements` 目录未修改。解除代码锁定前，需要先迁移对应的图形过程/元素定义。

以下配置由仓库维护者负责，成员日常打开、启动、导出时不需要修改：
MCreator 会重写 `mcreator.gradle`，依赖因此放在 `gradle/oneiricconcept.gradle`。
`build.gradle` 使用 NeoForge **21.1.250** 并引入该脚本。维护者升级生成器或
重新生成基础文件时，需保留这两项自定义配置并通过 CI 后再交付成员。
重置版仍以 `primogemcraft` 注册，保留在 MCreator 的 Required mods 中。
该字段会生成 `[0,)`，成品保留此范围，不限制重置版版本。
`gradle/oneiricconcept.gradle` 仅在 `processResources` 阶段将 NeoForge 最低版本设为 21.1.250。不要在用户代码块重复声明。

## 验证和边界

早期迁移时完整 `build` 成功；当时尚未添加自动测试源码。
成员交付验证使用从 Git 跟踪文件导出的全新副本，不复制项目 `.gradle`、`.mcreator`
或 `run` 目录；使用 MCreator 2026.2 自带 Java、禁用本机 JDK 自动探测后，
`build prepareClientRun` 成功。全局 Gradle 下载缓存仍可使用，本验证不代表离线安装。
这项早期验证仅覆盖 Gradle，未覆盖首次在 MCreator 中打开时的基础文件重生成；
2026-09-26 已补充下面所述的 `setupInfo` 交付修复。
CI 同样使用仓库自带 Gradle Wrapper 执行构建和客户端启动配置检查。
客户端实际加载 Neo 1.0.3 和 OC 26.88，并进入单人游戏。
迁移后的 236 处数据物品引用均核对过所选 Neo JAR 的物品模型。
配方格式和调试函数错误是在首次进世界日志中发现后修复的；最终修改再次通过
构建，尚未对所有玩法逐项回归。

早期迁移未读取或清理缓存目录；本次另外核对了 `.mcreator/setupInfo`，构建工具仍正常使用缓存。
未修改已有存档。旧 `primogemcraft:player_variables` 附件和旧物品 ID 不会自动转换；
本次依赖替换不保证旧存档兼容。

旧 Patchouli 百科中找不到 Neo 等价物的已删除内容仍保留原文。旧礼盒分支、
旧标签及全部武器强化交互尚未逐项验证。Neo 自身 `zipline.json` 的非法旋转角度、
ExParticle 缺少 JavaCV 的可选视频功能提示不在本项目源码修复范围内。

## 祈愿武器描述与渲染

星尘球棒、真律之灵枝的物品类直接实现 PGC 的 `WishWeapon` 接口，
使用 `WeaponDescription`、`WishWeaponTooltips` 和 `WishReports.number`。
Shift 展开技能详情，Ctrl 展开强化教程；等级、精炼星级和额外精炼由 PGC
自己的监听器和渲染器处理，不再保留本模组的星级渲染监听器。
PGC 的强化台和等级属性系统也会识别这两把武器。背包 tick 调用原生
`WeaponAttributes.refreshPassive`；技能仍由现有过程执行，`passives()` 返回空列表，
避免重复添加技能效果。真律之灵枝的管理员说明仍仅对 OP4 显示。

物品元素路径、模型、注册和 `elements` 定义保留。两把武器的接口实现需要代码锁定保护；
解除锁定前，需保留或迁移接口方法及原生 API 调用。

武器描述译文位于 `src/main/resources/assets/oneiricconcept_weapons/lang/`。
这是同一模组内的独立资源命名空间，Minecraft 会按标准资源加载流程合并它的语言键；
物品 ID 和描述键仍是 `oneiricconcept`，无需新增模组或自定义本地化代码。
MCreator 会根据内存中的工作区重写 `assets/oneiricconcept/lang/` 和 `language_map`，
因此这些手写描述不再依赖它们；不要将译文移回生成的语言文件中。

`build` / `check` 会运行 `verifyWeaponLocalization`，使用 Minecraft 的
`ClientLanguage` 从成品 JAR 自动发现资源命名空间，检查两把武器的全部描述、
中文与英文以及日语环境的英文回退，并检查占位符和百分号。此检查不启动游戏窗口。

## 2026-09-26 导出旧包修复

日志中的 `Event_item_sxRProcedure$EventContext` 属于迁移前的 API。
出错的 `oneiricconcept-26.9-neoforge-1.21.1.jar` 与工作区残留的
`build/libs/modid-1.0.jar` SHA-256 相同：
`434F1F9BB54C59430DF30E88DA5083C4F322F5C5062D1947A3970CAC291F4A43`。
MCreator 2026.2 生成器的 `export_file` 固定指向后者；此前自定义 archivesName/version
把新代码写到另一个文件，所以开发运行正常而导出的是旧包，干净工作区则缺少导出文件。

现已固定 `jar.archiveFileName` 为生成器要求的 `modid-1.0.jar`，版本读取工作区设置，
CI 也只上传这个经过检查的文件。不要靠重命名历史 JAR 升级版本。
`verifyExport` 检查实际导出路径、内部版本、精确 Neo 依赖，以及全部编译类中的旧 API 引用；
它与语言检查一起由 `build` / `check` 执行。真实环境需另外安装仓库提供的 Neo 1.0.5，
日志中的 1.0.2 不受支持。修改 Neo 版本时同步更新 libs、Gradle 资源处理及此检查。

后续 MCreator 实际构建发现，运行中的编辑器会把内存中的 Required mods 写回工作区，
与之前手写的精确依赖产生重复。现已移除重复的用户代码块声明，保留正常生成的依赖，
在打包资源时收紧版本；不再依靠修改编辑器内存中的工作区设置。

另一个独立原因是 `.mcreator/setupInfo` 先前被 Git 忽略。已核对 MCreator 2026.2 的
`shouldSetupBeRan` / `setupWorkspaceBase`：标记缺失会触发基础文件覆盖，丢失
`build.gradle` 的自定义脚本入口和 NeoForge 21.1.250。现在仅将这个单行标记纳入 Git，
其余 `.mcreator` 内容继续忽略。`buildFileVersion=21.1.232` 是生成器版本，不能改成
运行用的 21.1.250。不要删除这个标记或让成员重置构建文件；升级生成器时由维护者
重新适配构建文件和标记。`verifyExport` 同时检查这个标记。

最终交付副本只使用 Git 跟踪文件及本次待提交文件（包含上述标记），用 MCreator 自带 Java、
禁用本机 JDK 自动探测，执行 `clean build prepareClientRun --no-build-cache` 成功。
全局下载/NeoForm 缓存仍复用。导出检查覆盖 869 个类，语言检查覆盖中英及日语英文回退；
原崩溃 JAR 作为负例被检查拒绝。本次未直接操作 MCreator 图形界面的首次打开/导出按钮。

本次成品冒烟验证在独立临时工程中只加载 OC 导出 JAR 和 Neo 1.0.3，未加入 OC 源码目录、
GenshinCraft 或 REI。NeoForge 21.1.250 服务端成功报告两者版本并创建世界，到达 `Done`，
随后停止测试进程。该检查使用 ModDev 启动器，不等于原整合包客户端及全部玩法回归。

## 2026-09-26 Neo 1.0.5 与依赖交付

已将 Neo 更新到 1.0.5；因尚未通过 Modrinth 审核，只有 Neo 随仓库提供。
GenshinCraft 3.1.3 继续由 Modrinth Maven 下载。
旧 Neo 1.0.3 JAR 已移除，避免误装两个相同 mod ID 的版本。提交时必须包含新的 Neo JAR。
仅复制 Git 已跟踪及待提交文件的新目录通过 `clean build prepareClientRun --no-build-cache`；
未复制工作区 build、run 和 .gradle，但复用了全局下载缓存。
独立 ModDev 服务端只加载导出 JAR 和 Neo 1.0.5，成功创建世界并到达 Done。
上文 Neo 1.0.3 客户端记录是历史验证；此次没有完成 1.0.5 客户端全部玩法回归。
