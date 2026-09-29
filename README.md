中文 | [English](README_en.md)

## 成员开发：直接使用 MCreator

1. 拉取或下载完整仓库，使用 **MCreator 2026.2** 打开 `oneiricconcept.mcreator`。
2. 等待首次工作区设置及依赖下载完成。
3. 点击 MCreator 的运行客户端按钮进行调试，使用导出模组功能构建发布包。

无需控制台、IDE、单独安装 JDK，或从其他成员的电脑复制依赖。
原石重置版 **PrimogemCraftNeo 1.0.5** 尚未通过 Modrinth 审核，已随仓库放在 `libs` 中；
**GenshinCraft 3.1.3** 从 Modrinth 自动下载，**REI 16.0.799** 从其官方 Maven 仓库获取并加入开发环境。
完整拉取仓库时请保留 `libs` 和 `gradle` 目录，不要只复制 `src`。
也请保留 Git 中的 `.mcreator/setupInfo`：它保护仓库定制的构建配置，避免首次打开时
被生成器默认文件覆盖。这个标记对应 MCreator 2026.2 的生成器版本 21.1.232，
实际构建的 NeoForge 版本仍为 21.1.250。升级 MCreator 或重置构建脚本时需重新适配。
拉取更新前先关闭 MCreator 中的工作区，拉取后重新打开，避免编辑器用旧内存状态覆盖文件。
不要提交 MCreator 重置后的构建脚本；CI 会显式调用导出和语言检查，脚本入口丢失时直接失败。

MCreator 实际导出源文件固定为 `build/libs/modid-1.0.jar`，请勿修改此构建文件名；
它的内部版本来自工作区设置（当前为 26.9），MCreator 导出时可选择发布文件名。
`build` 会校验此文件的版本、Neo 依赖和旧 API 残留，防止导出历史包。
已锁定的迁移元素请使用代码编辑；解除锁定会让旧的图形定义覆盖已迁移代码。

## 游戏安装

使用 Minecraft 1.21.1、NeoForge 21.1.250 或更新的 21.1 版本，同时安装本次导出的
梦华构想和仓库 `libs/primogemcraftneo-1.0.5.jar`。原石工艺不会内嵌在梦华构想 JAR 中。
移除旧梦华构想、PrimogemCraftNeo 1.0.2 和旧版原石工艺，避免重复 mod ID。
Neo 仍为必装依赖，但不限制版本（`[0,)`）；默认构建使用仓库自带的 1.0.5，也可按 `libs/README.md` 指定其他包。其他版本的 API 与运行兼容性需另行验证。
GenshinCraft 为可选联动，REI 为开发辅助，普通玩家不必为了本模组安装它们。

维护配置与迁移记录见 [WORKSPACE_REPAIR.md](WORKSPACE_REPAIR.md)。

# 介绍
这是一个原石工艺的附属模组，找回了原石工艺早期的异世界树。

添加了额外的 Primogem Craft 的矿石生成和一些原石工艺中物品的装饰方块：
* 在雪原地下的燃愿玛瑙，沙滩和浅海的涤净青金，在天空中的自在松石，在粘土中的最胜紫晶，在苔藓中的生长碧翡，在雪层中的哀叙冰玉，在溶洞中的坚牢黄玉；
* 可以堆在世界中的元素金属锭和原石等。

扩展了 Primogem Craft 中的星尘的功能，使其可以合成一些资源。

额外添加了一些米哈游游戏中的功能物品。如代替床跳过夜晚的入梦罐、可以发射造成伤害和爆炸的轩辕剑等，一些食物，可以按百分比回复生命值。

还添加了一些画和唱片。
### 链接
[mcmod](https://www.mcmod.cn/class/17477.html)
[modrinth](https://modrinth.com/mod/oneiricconcept)
