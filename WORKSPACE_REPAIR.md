# 工作区修复与重置版迁移

## 使用

使用 Java 21，在项目目录执行：

```powershell
.\gradlew.bat build
.\gradlew.bat runClient
```

产物：`build/libs/oneiricconcept-26.88.jar`。
使用 **MCreator 2026.2 / NeoForge 1.21.1** 打开 `oneiricconcept.mcreator`。
已实际打开此工作区，并在打开后通过完整 Gradle 构建。

依赖定义位于独立的 `gradle/oneiricconcept.gradle`，由 `build.gradle` 引入。重置版使用
`libs/primogemcraftneo-1.0.3.jar`；GenshinCraft 为 3.1.3，REI 为 16.0.799。
来源与校验值见 `libs/README.md`。首次构建仍可能下载 Minecraft、NeoForge、
GenshinCraft、REI 等依赖，本地原石包不代表所有依赖完全离线。

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

MCreator 会重写 `mcreator.gradle`，因此不要把自定义依赖写在那里。
执行“重建工作区基础文件”后，应恢复 `build.gradle` 的 NeoForge **21.1.250**
以及末尾的 `apply from: 'gradle/oneiricconcept.gradle'`。正常打开/关闭工作区
不会清空独立脚本中的依赖。
不要把 `requiredMods` 改为 `primogemcraftneo`，重置版仍以 `primogemcraft` 注册。

## 验证和边界

完整 `build` 成功；项目没有自动测试源码，因此未声称执行了单元测试。
客户端实际加载 Neo 1.0.3 和 OC 26.88，并进入单人游戏。
迁移后的 236 处数据物品引用均核对过所选 Neo JAR 的物品模型。
配方格式和调试函数错误是在首次进世界日志中发现后修复的；最终修改再次通过
构建，尚未对所有玩法逐项回归。

未读取或清理 `.gradle`、`.mcreator` 等缓存目录内容，构建工具自身仍正常使用缓存。
未修改已有存档。旧 `primogemcraft:player_variables` 附件和旧物品 ID 不会自动转换；
本次依赖替换不保证旧存档兼容。

旧 Patchouli 百科中找不到 Neo 等价物的已删除内容仍保留原文。旧礼盒分支、
旧标签及全部武器强化交互尚未逐项验证。Neo 自身 `zipline.json` 的非法旋转角度、
ExParticle 缺少 JavaCV 的可选视频功能提示不在本项目源码修复范围内。
