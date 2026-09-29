# PrimogemCraftNeo 本地依赖

默认使用 `libs/primogemcraftneo-1.0.5.jar`，原样复制自
`D:/Amcmozuchengp/aPGCZ/build/libs/primogemcraft-1.0.5.jar`。

- 上游：https://github.com/Primogem-Studio/PrimogemCraftNeo
- 包内名称：PrimogemCraftNeo；模组 ID：`primogemcraft`
- Minecraft 1.21.1；最低 NeoForge 21.1.250
- SHA-256：`21EDE321589933E1645019241961C3A4E6BD4D6E6E57BE3669325C2715DAA47D`
- MIT 许可见 `PrimogemCraftNeo-LICENSE.txt`。

不需要 Maven/JitPack 发布即可使用此包。`implementation files(...)` 将它加入
编译和开发运行环境，不会将它打进梦华构想的发布 JAR。发布运行时需另外安装
重置版，不能同时安装旧版原石工艺。

临时指定其他包：

```powershell
.\gradlew.bat build "-PprimogemcraftNeoJar=D:/path/to/primogemcraftneo.jar"
```

成品仍要求安装 PrimogemCraftNeo，但不限制其版本（`[0,)`）。切换版本后需重新核对 API、注册 ID 与最低 NeoForge 版本。

仅 PrimogemCraftNeo 因 Modrinth 审核尚未通过而随仓库提供。
GenshinCraft 3.1.3 由 Gradle 从 Modrinth 下载；REI 从其官方 Maven 仓库获取。
