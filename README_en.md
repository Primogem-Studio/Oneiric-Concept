[中文](README.md) | English

## Development with MCreator

Open `oneiricconcept.mcreator` in **MCreator 2026.2**, wait for workspace setup,
then use its run-client or export-mod action. No terminal or IDE setup is needed.
Keep the complete repository, including `libs` and `gradle`.
Keep the tracked `.mcreator/setupInfo` too: without it, first-open setup overwrites the
custom build files. It identifies the MCreator 2026.2 generator (21.1.232), while the
project builds against NeoForge 21.1.250. Generator upgrades/build-script resets need migration.
Close the workspace in MCreator before pulling updates, then reopen it to avoid stale in-memory writes.
Do not commit reset build scripts. CI explicitly invokes export and language checks, so a missing custom script entry point fails the build.
PrimogemCraftNeo 1.0.5 is included in `libs` while its Modrinth approval is pending.
GenshinCraft 3.1.3 is downloaded from Modrinth; REI 16.0.799 uses its official Maven repository.

MCreator exports `build/libs/modid-1.0.jar`; do not change that build filename.
The internal mod version follows the workspace settings (currently 26.9).
The `build` task checks this exact artifact for version, dependencies, and legacy API references.
Keep migrated elements code-locked and edit their Java code until their visual definitions are migrated.

For a game installation, use Minecraft 1.21.1, NeoForge 21.1.250 or a newer 21.1 release,
and install both the exported mod and `libs/primogemcraftneo-1.0.5.jar`.
Remove older OneiricConcept and PrimogemCraft jars first. Neo is required without a version
restriction (`[0,)`). Builds default to the bundled 1.0.5; see `libs/README.md` to select
another JAR. API and runtime compatibility with other versions must be verified separately.
GenshinCraft and REI are optional for players.

# Introduction
Additional mods for Primogem Craft Found the early exotic world tree of the Primogem Craft

Additional Primogem Craft ore generation has been added: 
* Agnidus Agate Ore underground in snowy plains, Varunada Lazurite Ore on beaches and shallow seas, Vayuda Turquoise Ore in the sky, Vajrada Amethyst Ore in clay, Nagadus Emerald Ore in moss, Shivada Jade Ore in snow layers, and Prithva Topaz Ore in caves.
* Elemental metal ingots and primogems that can be stacked in the world.

Expanded the functionality of Masterless Stardust in Primogem Craft, allowing it to synthesize some resources. Added some items from miHoYo game Such as DreamdiveCan at night instead of the bed, the Xuan Yuan Sword that can be launched, etc

Some foods can restore health by percentage. Also added some paintings and records.
### Links
[modrinth](https://modrinth.com/mod/oneiricconcept)
[mcmod](https://www.mcmod.cn/class/17477.html)
