
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oneiricconcept.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

import net.mcreator.oneiricconcept.procedures.VastmodeProcedure;
import net.mcreator.oneiricconcept.procedures.TexturesProcedure;
import net.mcreator.oneiricconcept.procedures.BowPullProcedure;
import net.mcreator.oneiricconcept.item.XuanyuanSwordItem;
import net.mcreator.oneiricconcept.item.XuanyuanArrowItem;
import net.mcreator.oneiricconcept.item.WildernessRodItem;
import net.mcreator.oneiricconcept.item.WayfareCakeSlicesItem;
import net.mcreator.oneiricconcept.item.WaffleItem;
import net.mcreator.oneiricconcept.item.VirtualParticleItem;
import net.mcreator.oneiricconcept.item.UsurperSSchemeItem;
import net.mcreator.oneiricconcept.item.TreeBarkofEruditionItem;
import net.mcreator.oneiricconcept.item.TotemlootItem;
import net.mcreator.oneiricconcept.item.ThiefSInstinctItem;
import net.mcreator.oneiricconcept.item.TesttoolItem;
import net.mcreator.oneiricconcept.item.TAWWoodLootItem;
import net.mcreator.oneiricconcept.item.TAWWoodBoxItem;
import net.mcreator.oneiricconcept.item.SwordOfBrilliantValorItem;
import net.mcreator.oneiricconcept.item.SweetflowermedakaItem;
import net.mcreator.oneiricconcept.item.SweetSesameFillingYuanXiaoItem;
import net.mcreator.oneiricconcept.item.SustenanceanchoritemItem;
import net.mcreator.oneiricconcept.item.SurpriseboxforgoodorbadItem;
import net.mcreator.oneiricconcept.item.SunStartCanItem;
import net.mcreator.oneiricconcept.item.StuffingItem;
import net.mcreator.oneiricconcept.item.StardustBaseballerItem;
import net.mcreator.oneiricconcept.item.SolidWaterItem;
import net.mcreator.oneiricconcept.item.SmokeSausageItem;
import net.mcreator.oneiricconcept.item.SmallHertaCoreItem;
import net.mcreator.oneiricconcept.item.SkyWaffleItem;
import net.mcreator.oneiricconcept.item.SkipToolItem;
import net.mcreator.oneiricconcept.item.SausageItem;
import net.mcreator.oneiricconcept.item.SaltItem;
import net.mcreator.oneiricconcept.item.SaltDustItem;
import net.mcreator.oneiricconcept.item.S2tuffingItem;
import net.mcreator.oneiricconcept.item.S2mokeSausageItem;
import net.mcreator.oneiricconcept.item.S2ausageItem;
import net.mcreator.oneiricconcept.item.ResurrectionPelletItem;
import net.mcreator.oneiricconcept.item.RedBeanSoupFillingYuanXiaoItem;
import net.mcreator.oneiricconcept.item.PunitiveEnergyItem;
import net.mcreator.oneiricconcept.item.PublicClamorItem;
import net.mcreator.oneiricconcept.item.PropagandaArmyItem;
import net.mcreator.oneiricconcept.item.PrimogemsSausageItem;
import net.mcreator.oneiricconcept.item.PrimogemfruitItem;
import net.mcreator.oneiricconcept.item.PrimogemcraftwikiItem;
import net.mcreator.oneiricconcept.item.PrimogemWaffleItem;
import net.mcreator.oneiricconcept.item.PlumpFishItem;
import net.mcreator.oneiricconcept.item.PhlogistonWingItem;
import net.mcreator.oneiricconcept.item.PhlogistonItem;
import net.mcreator.oneiricconcept.item.PhlogistonCrystalItem;
import net.mcreator.oneiricconcept.item.PhlogistonCoreItem;
import net.mcreator.oneiricconcept.item.PhlogistonControllerItem;
import net.mcreator.oneiricconcept.item.OyStuffingItem;
import net.mcreator.oneiricconcept.item.OyDumplingItem;
import net.mcreator.oneiricconcept.item.OneiricShardItem;
import net.mcreator.oneiricconcept.item.MoraSausageItem;
import net.mcreator.oneiricconcept.item.MoraMagazineItem;
import net.mcreator.oneiricconcept.item.MoraMagazineE1Item;
import net.mcreator.oneiricconcept.item.MoraBowItem;
import net.mcreator.oneiricconcept.item.MoltenMetalItem;
import net.mcreator.oneiricconcept.item.MmmhitItem;
import net.mcreator.oneiricconcept.item.MilkItem;
import net.mcreator.oneiricconcept.item.MemoryBubbleItem;
import net.mcreator.oneiricconcept.item.MemoriaPieceItem;
import net.mcreator.oneiricconcept.item.MemoriaLootItem;
import net.mcreator.oneiricconcept.item.MemoriaItem;
import net.mcreator.oneiricconcept.item.MedakaItem;
import net.mcreator.oneiricconcept.item.LegionPseudoSliverItem;
import net.mcreator.oneiricconcept.item.LegionPseudoCoreItem;
import net.mcreator.oneiricconcept.item.IgnisAureliaeItem;
import net.mcreator.oneiricconcept.item.IceFreshRawFrostweaveSalmonSlicesItem;
import net.mcreator.oneiricconcept.item.HungerItem;
import net.mcreator.oneiricconcept.item.HonkaiSliverItem;
import net.mcreator.oneiricconcept.item.HonkaiShardItem;
import net.mcreator.oneiricconcept.item.HiltwoodFromTheArborItem;
import net.mcreator.oneiricconcept.item.HeartofthewarmseaItem;
import net.mcreator.oneiricconcept.item.HeartofthevastseaItem;
import net.mcreator.oneiricconcept.item.HeartoftheskyseaItem;
import net.mcreator.oneiricconcept.item.HeartofthefrozenseaItem;
import net.mcreator.oneiricconcept.item.HeartofthefishItem;
import net.mcreator.oneiricconcept.item.GrilledOyDumplingItem;
import net.mcreator.oneiricconcept.item.GrilledDumplingItem;
import net.mcreator.oneiricconcept.item.GlazemedakaItem;
import net.mcreator.oneiricconcept.item.FruitpastebaitItem;
import net.mcreator.oneiricconcept.item.FishcakeItem;
import net.mcreator.oneiricconcept.item.ExampleItem;
import net.mcreator.oneiricconcept.item.EnergyDrinkSugarFreeItem;
import net.mcreator.oneiricconcept.item.EnergyDrinkPrimogemItem;
import net.mcreator.oneiricconcept.item.EnergyDrinkItem;
import net.mcreator.oneiricconcept.item.DumplingItem;
import net.mcreator.oneiricconcept.item.DreamyConeItem;
import net.mcreator.oneiricconcept.item.DreamdiveCanItem;
import net.mcreator.oneiricconcept.item.DivineArrowEmbersItem;
import net.mcreator.oneiricconcept.item.DeepMarrowRockSaltItem;
import net.mcreator.oneiricconcept.item.DarkXuanyuanSwordItem;
import net.mcreator.oneiricconcept.item.DXuanyuanItem;
import net.mcreator.oneiricconcept.item.CullinanItem;
import net.mcreator.oneiricconcept.item.ConquerorSWillItem;
import net.mcreator.oneiricconcept.item.CondensedMemoriaPieceItem;
import net.mcreator.oneiricconcept.item.CompressTotemlootItem;
import net.mcreator.oneiricconcept.item.CloudBottleItem;
import net.mcreator.oneiricconcept.item.CamoPaintItem;
import net.mcreator.oneiricconcept.item.BossStoneCoinGunPlusItem;
import net.mcreator.oneiricconcept.item.BossStoneCoinGunItem;
import net.mcreator.oneiricconcept.item.BelobogSausageItem;
import net.mcreator.oneiricconcept.item.B2elobogSausageItem;
import net.mcreator.oneiricconcept.item.AureliaeSwordItem;
import net.mcreator.oneiricconcept.item.AureliaeShovelItem;
import net.mcreator.oneiricconcept.item.AureliaePickaxeItem;
import net.mcreator.oneiricconcept.item.AureliaeHoeItem;
import net.mcreator.oneiricconcept.item.AureliaeAxeItem;
import net.mcreator.oneiricconcept.item.AmbergrisCheeseSliverItem;
import net.mcreator.oneiricconcept.item.AizenmedakaItem;
import net.mcreator.oneiricconcept.item.AdeptusGunItem;
import net.mcreator.oneiricconcept.item.APropagandaArmyItem;
import net.mcreator.oneiricconcept.OneiricconceptMod;

public class OneiricconceptModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(OneiricconceptMod.MODID);
	public static final DeferredItem<Item> SAUSAGE = REGISTRY.register("sausage", SausageItem::new);
	public static final DeferredItem<Item> SMOKE_SAUSAGE = REGISTRY.register("smoke_sausage", SmokeSausageItem::new);
	public static final DeferredItem<Item> BELOBOG_SAUSAGE = REGISTRY.register("belobog_sausage", BelobogSausageItem::new);
	public static final DeferredItem<Item> S_2AUSAGE = REGISTRY.register("s_2ausage", S2ausageItem::new);
	public static final DeferredItem<Item> S_2MOKE_SAUSAGE = REGISTRY.register("s_2moke_sausage", S2mokeSausageItem::new);
	public static final DeferredItem<Item> B_2ELOBOG_SAUSAGE = REGISTRY.register("b_2elobog_sausage", B2elobogSausageItem::new);
	public static final DeferredItem<Item> STUFFING = REGISTRY.register("stuffing", StuffingItem::new);
	public static final DeferredItem<Item> S_2TUFFING = REGISTRY.register("s_2tuffing", S2tuffingItem::new);
	public static final DeferredItem<Item> GEOMARROW_RADIATOR = block(OneiricconceptModBlocks.GEOMARROW_RADIATOR);
	public static final DeferredItem<Item> ONEIRIC_SHARD = REGISTRY.register("oneiric_shard", OneiricShardItem::new);
	public static final DeferredItem<Item> MORA_SAUSAGE = REGISTRY.register("mora_sausage", MoraSausageItem::new);
	public static final DeferredItem<Item> PRIMOGEMS_SAUSAGE = REGISTRY.register("primogems_sausage", PrimogemsSausageItem::new);
	public static final DeferredItem<Item> BOOM_BLOSSOMS_PYRO = block(OneiricconceptModBlocks.BOOM_BLOSSOMS_PYRO);
	public static final DeferredItem<Item> BANANA_MUSHROOM = block(OneiricconceptModBlocks.BANANA_MUSHROOM);
	public static final DeferredItem<Item> BANANA_MUSHROOM_BOCK = block(OneiricconceptModBlocks.BANANA_MUSHROOM_BOCK);
	public static final DeferredItem<Item> ELEMENTS_CRYSTAL_ORE = block(OneiricconceptModBlocks.ELEMENTS_CRYSTAL_ORE);
	public static final DeferredItem<Item> NAGADUS_EMERALD_ORE = block(OneiricconceptModBlocks.NAGADUS_EMERALD_ORE);
	public static final DeferredItem<Item> SHIVADA_JADE_ORE = block(OneiricconceptModBlocks.SHIVADA_JADE_ORE);
	public static final DeferredItem<Item> VAJRADA_AMETHYST_ORE = block(OneiricconceptModBlocks.VAJRADA_AMETHYST_ORE);
	public static final DeferredItem<Item> VARUNADA_LAZURITE_ORE = block(OneiricconceptModBlocks.VARUNADA_LAZURITE_ORE);
	public static final DeferredItem<Item> CLOUD = block(OneiricconceptModBlocks.CLOUD);
	public static final DeferredItem<Item> PRITHIVA_TOPAZ_ORE = block(OneiricconceptModBlocks.PRITHIVA_TOPAZ_ORE);
	public static final DeferredItem<Item> VAYUDA_TURQUOISE_ORE = block(OneiricconceptModBlocks.VAYUDA_TURQUOISE_ORE);
	public static final DeferredItem<Item> AGNIDUS_AGATE_ORE = block(OneiricconceptModBlocks.AGNIDUS_AGATE_ORE);
	public static final DeferredItem<Item> CLOUD_BOTTLE = REGISTRY.register("cloud_bottle", CloudBottleItem::new);
	public static final DeferredItem<Item> DREAMDIVE_CAN = REGISTRY.register("dreamdive_can", DreamdiveCanItem::new);
	public static final DeferredItem<Item> SUN_START_CAN = REGISTRY.register("sun_start_can", SunStartCanItem::new);
	public static final DeferredItem<Item> MEMORIA_BUCKET = REGISTRY.register("memoria_bucket", MemoriaItem::new);
	public static final DeferredItem<Item> MEMORY_BUBBLE = REGISTRY.register("memory_bubble", MemoryBubbleItem::new);
	public static final DeferredItem<Item> MEMORIA_PIECE = REGISTRY.register("memoria_piece", MemoriaPieceItem::new);
	public static final DeferredItem<Item> XUANYUAN_SWORD = REGISTRY.register("xuanyuan_sword", XuanyuanSwordItem::new);
	public static final DeferredItem<Item> ADEPTUS_GUN = REGISTRY.register("adeptus_gun", AdeptusGunItem::new);
	public static final DeferredItem<Item> BIG_STONE = block(OneiricconceptModBlocks.BIG_STONE);
	public static final DeferredItem<Item> BIG_ROCK = block(OneiricconceptModBlocks.BIG_ROCK);
	public static final DeferredItem<Item> HONKAI_SHARD = REGISTRY.register("honkai_shard", HonkaiShardItem::new);
	public static final DeferredItem<Item> LEGION_PSEUDO_CORE = REGISTRY.register("legion_pseudo_core", LegionPseudoCoreItem::new);
	public static final DeferredItem<Item> LEGION_PSEUDO_SLIVER = REGISTRY.register("legion_pseudo_sliver", LegionPseudoSliverItem::new);
	public static final DeferredItem<Item> HONKAI_SLIVER = REGISTRY.register("honkai_sliver", HonkaiSliverItem::new);
	public static final DeferredItem<Item> OY_DUMPLING = REGISTRY.register("oy_dumpling", OyDumplingItem::new);
	public static final DeferredItem<Item> DUMPLING = REGISTRY.register("dumpling", DumplingItem::new);
	public static final DeferredItem<Item> OY_STUFFING = REGISTRY.register("oy_stuffing", OyStuffingItem::new);
	public static final DeferredItem<Item> THE_ANOTHER_WORLD_LOG = block(OneiricconceptModBlocks.THE_ANOTHER_WORLD_LOG);
	public static final DeferredItem<Item> STRIPPED_THE_ANOTHER_WORLD_LOG = block(OneiricconceptModBlocks.STRIPPED_THE_ANOTHER_WORLD_LOG);
	public static final DeferredItem<Item> THE_ANOTHER_WORLD_SAPLING = block(OneiricconceptModBlocks.THE_ANOTHER_WORLD_SAPLING);
	public static final DeferredItem<Item> DARK_XUANYUAN_SWORD = REGISTRY.register("dark_xuanyuan_sword", DarkXuanyuanSwordItem::new);
	public static final DeferredItem<Item> THE_ANOTHER_WORLD_WOOD = block(OneiricconceptModBlocks.THE_ANOTHER_WORLD_WOOD);
	public static final DeferredItem<Item> CONDENSED_MEMORIA_PIECE = REGISTRY.register("condensed_memoria_piece", CondensedMemoriaPieceItem::new);
	public static final DeferredItem<Item> TAW_WOOD_BOX = REGISTRY.register("taw_wood_box", TAWWoodBoxItem::new);
	public static final DeferredItem<Item> TAW_WOOD_LOOT = REGISTRY.register("taw_wood_loot", TAWWoodLootItem::new);
	public static final DeferredItem<Item> MEMORIA_LOOT = REGISTRY.register("memoria_loot", MemoriaLootItem::new);
	public static final DeferredItem<Item> MM_MUSHROOM = doubleBlock(OneiricconceptModBlocks.MM_MUSHROOM);
	public static final DeferredItem<Item> MMMHIT = REGISTRY.register("mmmhit", MmmhitItem::new);
	public static final DeferredItem<Item> BACTUS = block(OneiricconceptModBlocks.BACTUS);
	public static final DeferredItem<Item> C_CACTUS = block(OneiricconceptModBlocks.C_CACTUS);
	public static final DeferredItem<Item> GACTUS = block(OneiricconceptModBlocks.GACTUS);
	public static final DeferredItem<Item> MACTUS = block(OneiricconceptModBlocks.MACTUS);
	public static final DeferredItem<Item> RACTUS = block(OneiricconceptModBlocks.RACTUS);
	public static final DeferredItem<Item> YACTUS = block(OneiricconceptModBlocks.YACTUS);
	public static final DeferredItem<Item> SWORD_OF_BRILLIANT_VALOR = REGISTRY.register("sword_of_brilliant_valor", SwordOfBrilliantValorItem::new);
	public static final DeferredItem<Item> THE_ANOTHER_WORLD_LEAVE = block(OneiricconceptModBlocks.THE_ANOTHER_WORLD_LEAVE);
	public static final DeferredItem<Item> CRYSTAL_TURTLE_SPAWN_EGG = REGISTRY.register("crystal_turtle_spawn_egg", () -> new DeferredSpawnEggItem(OneiricconceptModEntities.CRYSTAL_TURTLE, -3342337, -16737844, new Item.Properties()));
	public static final DeferredItem<Item> TNT_DISPENSER = block(OneiricconceptModBlocks.TNT_DISPENSER);
	public static final DeferredItem<Item> WAFFLE = REGISTRY.register("waffle", WaffleItem::new);
	public static final DeferredItem<Item> PRIMOGEM_WAFFLE = REGISTRY.register("primogem_waffle", PrimogemWaffleItem::new);
	public static final DeferredItem<Item> D_XUANYUAN = REGISTRY.register("d_xuanyuan", DXuanyuanItem::new);
	public static final DeferredItem<Item> SMALL_HERTA_CORE = REGISTRY.register("small_herta_core", SmallHertaCoreItem::new);
	public static final DeferredItem<Item> SKY_WAFFLE = REGISTRY.register("sky_waffle", SkyWaffleItem::new);
	public static final DeferredItem<Item> RESURRECTION_PELLET = REGISTRY.register("resurrection_pellet", ResurrectionPelletItem::new);
	public static final DeferredItem<Item> SURPRISEBOXFORGOODORBAD = REGISTRY.register("surpriseboxforgoodorbad", SurpriseboxforgoodorbadItem::new);
	public static final DeferredItem<Item> EXAMPLE = REGISTRY.register("example", ExampleItem::new);
	public static final DeferredItem<Item> TOTEMLOOT = REGISTRY.register("totemloot", TotemlootItem::new);
	public static final DeferredItem<Item> COMPRESS_TOTEMLOOT = REGISTRY.register("compress_totemloot", CompressTotemlootItem::new);
	public static final DeferredItem<Item> BOSS_STONE_COIN_GUN = REGISTRY.register("boss_stone_coin_gun", BossStoneCoinGunItem::new);
	public static final DeferredItem<Item> MORA_MAGAZINE = REGISTRY.register("mora_magazine", MoraMagazineItem::new);
	public static final DeferredItem<Item> MORA_MAGAZINE_E_1 = REGISTRY.register("mora_magazine_e_1", MoraMagazineE1Item::new);
	public static final DeferredItem<Item> BOSS_STONE_COIN_GUN_PLUS = REGISTRY.register("boss_stone_coin_gun_plus", BossStoneCoinGunPlusItem::new);
	public static final DeferredItem<Item> PUBLIC_CLAMOR = REGISTRY.register("public_clamor", PublicClamorItem::new);
	public static final DeferredItem<Item> PROPAGANDA_ARMY = REGISTRY.register("propaganda_army", PropagandaArmyItem::new);
	public static final DeferredItem<Item> PROPAGANDA_ARMY_BLOCK = block(OneiricconceptModBlocks.PROPAGANDA_ARMY_BLOCK);
	public static final DeferredItem<Item> A_PROPAGANDA_ARMY = REGISTRY.register("a_propaganda_army", APropagandaArmyItem::new);
	public static final DeferredItem<Item> THUNDER_SWORD = block(OneiricconceptModBlocks.THUNDER_SWORD);
	public static final DeferredItem<Item> PGC_PRESENT = block(OneiricconceptModBlocks.PGC_PRESENT);
	public static final DeferredItem<Item> PRIMOGEM = block(OneiricconceptModBlocks.PRIMOGEM);
	public static final DeferredItem<Item> PYRO_METAL = block(OneiricconceptModBlocks.PYRO_METAL);
	public static final DeferredItem<Item> CAMERA = block(OneiricconceptModBlocks.CAMERA);
	public static final DeferredItem<Item> SUSTENANCEANCHORITEM = REGISTRY.register("sustenanceanchoritem", SustenanceanchoritemItem::new);
	public static final DeferredItem<Item> SUSTENANCEANCHOROFF = block(OneiricconceptModBlocks.SUSTENANCEANCHOROFF);
	public static final DeferredItem<Item> SUSTENANCEANCHOR = block(OneiricconceptModBlocks.SUSTENANCEANCHOR);
	public static final DeferredItem<Item> CRESCENT_METAL = block(OneiricconceptModBlocks.CRESCENT_METAL);
	public static final DeferredItem<Item> REDMOON_METAL = block(OneiricconceptModBlocks.REDMOON_METAL);
	public static final DeferredItem<Item> FULLMOON_METAL = block(OneiricconceptModBlocks.FULLMOON_METAL);
	public static final DeferredItem<Item> TRASHMETAL = block(OneiricconceptModBlocks.TRASHMETAL);
	public static final DeferredItem<Item> ELECTRO_METAL = block(OneiricconceptModBlocks.ELECTRO_METAL);
	public static final DeferredItem<Item> HYDRO_METAL = block(OneiricconceptModBlocks.HYDRO_METAL);
	public static final DeferredItem<Item> CRYO_METAL = block(OneiricconceptModBlocks.CRYO_METAL);
	public static final DeferredItem<Item> DENDRO_METAL = block(OneiricconceptModBlocks.DENDRO_METAL);
	public static final DeferredItem<Item> ANEMO_METAL = block(OneiricconceptModBlocks.ANEMO_METAL);
	public static final DeferredItem<Item> GEO_METAL = block(OneiricconceptModBlocks.GEO_METAL);
	public static final DeferredItem<Item> SUPERIMPOSER_CUSTOMMADE = block(OneiricconceptModBlocks.SUPERIMPOSER_CUSTOMMADE);
	public static final DeferredItem<Item> HERTABOND = block(OneiricconceptModBlocks.HERTABOND);
	public static final DeferredItem<Item> PYROSEALINGWAX = block(OneiricconceptModBlocks.PYROSEALINGWAX);
	public static final DeferredItem<Item> ELECTROSEALINGWAX = block(OneiricconceptModBlocks.ELECTROSEALINGWAX);
	public static final DeferredItem<Item> HYDROSEALINGWAX = block(OneiricconceptModBlocks.HYDROSEALINGWAX);
	public static final DeferredItem<Item> CRYOSEALINGWAX = block(OneiricconceptModBlocks.CRYOSEALINGWAX);
	public static final DeferredItem<Item> DENDROSEALINGWAX = block(OneiricconceptModBlocks.DENDROSEALINGWAX);
	public static final DeferredItem<Item> ANEMO_SEALINGWAX = block(OneiricconceptModBlocks.ANEMO_SEALINGWAX);
	public static final DeferredItem<Item> GEOSEALINGWAX = block(OneiricconceptModBlocks.GEOSEALINGWAX);
	public static final DeferredItem<Item> AMBROSIAL_ARBOR_LOG = block(OneiricconceptModBlocks.AMBROSIAL_ARBOR_LOG);
	public static final DeferredItem<Item> AMBROSIAL_ARBOR_LEAVE = block(OneiricconceptModBlocks.AMBROSIAL_ARBOR_LEAVE);
	public static final DeferredItem<Item> IGNIS_AURELIAE = REGISTRY.register("ignis_aureliae", IgnisAureliaeItem::new);
	public static final DeferredItem<Item> AURELIAE_PICKAXE = REGISTRY.register("aureliae_pickaxe", AureliaePickaxeItem::new);
	public static final DeferredItem<Item> AURELIAE_AXE = REGISTRY.register("aureliae_axe", AureliaeAxeItem::new);
	public static final DeferredItem<Item> AURELIAE_SWORD = REGISTRY.register("aureliae_sword", AureliaeSwordItem::new);
	public static final DeferredItem<Item> AURELIAE_SHOVEL = REGISTRY.register("aureliae_shovel", AureliaeShovelItem::new);
	public static final DeferredItem<Item> AURELIAE_HOE = REGISTRY.register("aureliae_hoe", AureliaeHoeItem::new);
	public static final DeferredItem<Item> MOLTEN_METAL = REGISTRY.register("molten_metal", MoltenMetalItem::new);
	public static final DeferredItem<Item> MOLTEN_METAL_BLOCK = block(OneiricconceptModBlocks.MOLTEN_METAL_BLOCK);
	public static final DeferredItem<Item> PRIMOGEMFRUITBLOCK = block(OneiricconceptModBlocks.PRIMOGEMFRUITBLOCK);
	public static final DeferredItem<Item> PRIMOGEMFRUIT = REGISTRY.register("primogemfruit", PrimogemfruitItem::new);
	public static final DeferredItem<Item> AMBROSIAL_ARBOR_SAPLING = block(OneiricconceptModBlocks.AMBROSIAL_ARBOR_SAPLING);
	public static final DeferredItem<Item> AMBROSIAL_ARBOR_PLANK = block(OneiricconceptModBlocks.AMBROSIAL_ARBOR_PLANK);
	public static final DeferredItem<Item> HILTWOOD_FROM_THE_ARBOR = REGISTRY.register("hiltwood_from_the_arbor", HiltwoodFromTheArborItem::new);
	public static final DeferredItem<Item> WAYFAREBLESSING = block(OneiricconceptModBlocks.WAYFAREBLESSING);
	public static final DeferredItem<Item> HEARTOFTHEFROZENSEA = REGISTRY.register("heartofthefrozensea", HeartofthefrozenseaItem::new);
	public static final DeferredItem<Item> HEARTOFTHESKYSEA = REGISTRY.register("heartoftheskysea", HeartoftheskyseaItem::new);
	public static final DeferredItem<Item> HEARTOFTHEWARMSEA = REGISTRY.register("heartofthewarmsea", HeartofthewarmseaItem::new);
	public static final DeferredItem<Item> HEARTOFTHEVASTSEA = REGISTRY.register("heartofthevastsea", HeartofthevastseaItem::new);
	public static final DeferredItem<Item> FLOATING_CLOUD = block(OneiricconceptModBlocks.FLOATING_CLOUD);
	public static final DeferredItem<Item> SALT = REGISTRY.register("salt", SaltItem::new);
	public static final DeferredItem<Item> MILK = REGISTRY.register("milk", MilkItem::new);
	public static final DeferredItem<Item> RED_BEAN_SOUP_FILLING_YUAN_XIAO = REGISTRY.register("red_bean_soup_filling_yuan_xiao", RedBeanSoupFillingYuanXiaoItem::new);
	public static final DeferredItem<Item> SWEET_SESAME_FILLING_YUAN_XIAO = REGISTRY.register("sweet_sesame_filling_yuan_xiao", SweetSesameFillingYuanXiaoItem::new);
	public static final DeferredItem<Item> GRILLED_OY_DUMPLING = REGISTRY.register("grilled_oy_dumpling", GrilledOyDumplingItem::new);
	public static final DeferredItem<Item> GRILLED_DUMPLING = REGISTRY.register("grilled_dumpling", GrilledDumplingItem::new);
	public static final DeferredItem<Item> SALT_DUST = REGISTRY.register("salt_dust", SaltDustItem::new);
	public static final DeferredItem<Item> HUNGER = REGISTRY.register("hunger", HungerItem::new);
	public static final DeferredItem<Item> AMBROSIAL_ARBOR_WOOD = block(OneiricconceptModBlocks.AMBROSIAL_ARBOR_WOOD);
	public static final DeferredItem<Item> AMBERGRIS_CHEESE_SLIVER = REGISTRY.register("ambergris_cheese_sliver", AmbergrisCheeseSliverItem::new);
	public static final DeferredItem<Item> DIVINE_ARROW_EMBERS = REGISTRY.register("divine_arrow_embers", DivineArrowEmbersItem::new);
	public static final DeferredItem<Item> DEEP_MARROW_ROCK_SALT = REGISTRY.register("deep_marrow_rock_salt", DeepMarrowRockSaltItem::new);
	public static final DeferredItem<Item> FRESH_SEEDOF_DAWN = block(OneiricconceptModBlocks.FRESH_SEEDOF_DAWN);
	public static final DeferredItem<Item> DAWNLEAVES = block(OneiricconceptModBlocks.DAWNLEAVES);
	public static final DeferredItem<Item> XIAO_LANTERN_RECYCLER = block(OneiricconceptModBlocks.XIAO_LANTERN_RECYCLER);
	public static final DeferredItem<Item> HEARTOFTHEFISH = REGISTRY.register("heartofthefish", HeartofthefishItem::new);
	public static final DeferredItem<Item> PHLOGISTONTANK = block(OneiricconceptModBlocks.PHLOGISTONTANK);
	public static final DeferredItem<Item> PHLOGISTON_CRYSTAL = REGISTRY.register("phlogiston_crystal", PhlogistonCrystalItem::new);
	public static final DeferredItem<Item> PHLOGISTON_CORE = REGISTRY.register("phlogiston_core", PhlogistonCoreItem::new);
	public static final DeferredItem<Item> PHLOGISTON_WING_CHESTPLATE = REGISTRY.register("phlogiston_wing_chestplate", PhlogistonWingItem.Chestplate::new);
	public static final DeferredItem<Item> PHLOGISTON_CONTROLLER = REGISTRY.register("phlogiston_controller", PhlogistonControllerItem::new);
	public static final DeferredItem<Item> PHLOGISTON = REGISTRY.register("phlogiston", PhlogistonItem::new);
	public static final DeferredItem<Item> FISHCAKE = REGISTRY.register("fishcake", FishcakeItem::new);
	public static final DeferredItem<Item> WAYFARE_CAKE_SLICES = REGISTRY.register("wayfare_cake_slices", WayfareCakeSlicesItem::new);
	public static final DeferredItem<Item> PRIMOGEMCRAFTWIKI = REGISTRY.register("primogemcraftwiki", PrimogemcraftwikiItem::new);
	public static final DeferredItem<Item> WILDERNESS_ROD = REGISTRY.register("wilderness_rod", WildernessRodItem::new);
	public static final DeferredItem<Item> CAMERAPINK = block(OneiricconceptModBlocks.CAMERAPINK);
	public static final DeferredItem<Item> SWEETFLOWER = block(OneiricconceptModBlocks.SWEETFLOWER);
	public static final DeferredItem<Item> ICE_FRESH_RAW_FROSTWEAVE_SALMON_SLICES = REGISTRY.register("ice_fresh_raw_frostweave_salmon_slices", IceFreshRawFrostweaveSalmonSlicesItem::new);
	public static final DeferredItem<Item> XUANYUAN_ARROW = REGISTRY.register("xuanyuan_arrow", XuanyuanArrowItem::new);
	public static final DeferredItem<Item> FRUITPASTEBAIT = REGISTRY.register("fruitpastebait", FruitpastebaitItem::new);
	public static final DeferredItem<Item> SWEETFLOWERMEDAKA = REGISTRY.register("sweetflowermedaka", SweetflowermedakaItem::new);
	public static final DeferredItem<Item> FISH = REGISTRY.register("fish", PlumpFishItem::new);
	public static final DeferredItem<Item> MEDAKA = REGISTRY.register("medaka", MedakaItem::new);
	public static final DeferredItem<Item> GLAZEMEDAKA = REGISTRY.register("glazemedaka", GlazemedakaItem::new);
	public static final DeferredItem<Item> AIZENMEDAKA = REGISTRY.register("aizenmedaka", AizenmedakaItem::new);
	public static final DeferredItem<Item> VIRTUAL_PARTICLE = REGISTRY.register("virtual_particle", VirtualParticleItem::new);
	public static final DeferredItem<Item> SOLID_WATER = REGISTRY.register("solid_water", SolidWaterItem::new);
	public static final DeferredItem<Item> CAMO_PAINT = REGISTRY.register("camo_paint", CamoPaintItem::new);
	public static final DeferredItem<Item> ENERGY_DRINK = REGISTRY.register("energy_drink", EnergyDrinkItem::new);
	public static final DeferredItem<Item> ENERGY_DRINK_PRIMOGEM = REGISTRY.register("energy_drink_primogem", EnergyDrinkPrimogemItem::new);
	public static final DeferredItem<Item> ENERGY_DRINK_SUGAR_FREE = REGISTRY.register("energy_drink_sugar_free", EnergyDrinkSugarFreeItem::new);
	public static final DeferredItem<Item> TREE_BARKOF_ERUDITION = REGISTRY.register("tree_barkof_erudition", TreeBarkofEruditionItem::new);
	public static final DeferredItem<Item> PUNITIVE_ENERGY = REGISTRY.register("punitive_energy", PunitiveEnergyItem::new);
	public static final DeferredItem<Item> MORA_BOW = REGISTRY.register("mora_bow", MoraBowItem::new);
	public static final DeferredItem<Item> THIEF_S_INSTINCT = REGISTRY.register("thief_s_instinct", ThiefSInstinctItem::new);
	public static final DeferredItem<Item> USURPER_S_SCHEME = REGISTRY.register("usurper_s_scheme", UsurperSSchemeItem::new);
	public static final DeferredItem<Item> CONQUEROR_S_WILL = REGISTRY.register("conqueror_s_will", ConquerorSWillItem::new);
	public static final DeferredItem<Item> BARYON_SPAWN_EGG = REGISTRY.register("baryon_spawn_egg", () -> new DeferredSpawnEggItem(OneiricconceptModEntities.BARYON, -3355444, -16777114, new Item.Properties()));
	public static final DeferredItem<Item> ADEPTUSTOOL = REGISTRY.register("adeptustool", TesttoolItem::new);
	public static final DeferredItem<Item> RAINBOW_CACTUS_BALL = block(OneiricconceptModBlocks.RAINBOW_CACTUS_BALL);
	public static final DeferredItem<Item> SKIP_TOOL = REGISTRY.register("skip_tool", SkipToolItem::new);
	public static final DeferredItem<Item> DREAMY_CONE = REGISTRY.register("dreamy_cone", DreamyConeItem::new);
	public static final DeferredItem<Item> EXHAUSTEDPRIMOGEM = block(OneiricconceptModBlocks.EXHAUSTEDPRIMOGEM);
	public static final DeferredItem<Item> PRIMOGEMSTORMGLASS = block(OneiricconceptModBlocks.PRIMOGEMSTORMGLASS);
	public static final DeferredItem<Item> STARDUST_BASEBALLER = REGISTRY.register("stardust_baseballer", StardustBaseballerItem::new);
	public static final DeferredItem<Item> CRYSTALGENERATOR = block(OneiricconceptModBlocks.CRYSTALGENERATOR);
	public static final DeferredItem<Item> CULLINAN = REGISTRY.register("cullinan", CullinanItem::new);
	public static final DeferredItem<Item> NEST = block(OneiricconceptModBlocks.NEST);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	private static DeferredItem<Item> doubleBlock(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Item.Properties()));
	}

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ItemsClientSideHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public static void clientLoad(FMLClientSetupEvent event) {
			event.enqueueWork(() -> {
				ItemProperties.register(ADEPTUS_GUN.get(), ResourceLocation.parse("oneiricconcept:adeptus_gun_mode"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) VastmodeProcedure.execute(itemStackToRender));
				ItemProperties.register(MORA_MAGAZINE.get(), ResourceLocation.parse("oneiricconcept:mora_magazine_textures"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) TexturesProcedure.execute(itemStackToRender));
				ItemProperties.register(MORA_MAGAZINE_E_1.get(), ResourceLocation.parse("oneiricconcept:mora_magazine_e_1_textures"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) TexturesProcedure.execute(itemStackToRender));
				ItemProperties.register(HEARTOFTHEVASTSEA.get(), ResourceLocation.parse("oneiricconcept:heartofthevastsea_itemmode"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) VastmodeProcedure.execute(itemStackToRender));
				ItemProperties.register(MORA_BOW.get(), ResourceLocation.parse("oneiricconcept:mora_bow_pull"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) BowPullProcedure.execute(entity, itemStackToRender));
				ItemProperties.register(ADEPTUSTOOL.get(), ResourceLocation.parse("oneiricconcept:adeptustool_test"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) TexturesProcedure.execute(itemStackToRender));
				ItemProperties.register(STARDUST_BASEBALLER.get(), ResourceLocation.parse("oneiricconcept:stardust_baseballer_textures"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) TexturesProcedure.execute(itemStackToRender));
			});
		}
	}
}
