
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oneiricconcept.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.BlockItem;

import net.mcreator.oneiricconcept.item.XuanyuanSwordItem;
import net.mcreator.oneiricconcept.item.WaffleItem;
import net.mcreator.oneiricconcept.item.TotemlootItem;
import net.mcreator.oneiricconcept.item.TAWWoodLootItem;
import net.mcreator.oneiricconcept.item.TAWWoodBoxItem;
import net.mcreator.oneiricconcept.item.SwordOfBrilliantValorItem;
import net.mcreator.oneiricconcept.item.SurpriseboxforgoodorbadItem;
import net.mcreator.oneiricconcept.item.SunStartCanItem;
import net.mcreator.oneiricconcept.item.StuffingItem;
import net.mcreator.oneiricconcept.item.SmokeSausageItem;
import net.mcreator.oneiricconcept.item.SmallHertaCoreItem;
import net.mcreator.oneiricconcept.item.SkyWaffleItem;
import net.mcreator.oneiricconcept.item.SausageItem;
import net.mcreator.oneiricconcept.item.S2tuffingItem;
import net.mcreator.oneiricconcept.item.S2mokeSausageItem;
import net.mcreator.oneiricconcept.item.S2ausageItem;
import net.mcreator.oneiricconcept.item.ResurrectionPelletItem;
import net.mcreator.oneiricconcept.item.PrimogemsSausageItem;
import net.mcreator.oneiricconcept.item.PrimogemWaffleItem;
import net.mcreator.oneiricconcept.item.OyStuffingItem;
import net.mcreator.oneiricconcept.item.OyDumplingItem;
import net.mcreator.oneiricconcept.item.OneiricShardItem;
import net.mcreator.oneiricconcept.item.MoraSausageItem;
import net.mcreator.oneiricconcept.item.MmmhitItem;
import net.mcreator.oneiricconcept.item.MemoryBubbleItem;
import net.mcreator.oneiricconcept.item.MemoriaPieceItem;
import net.mcreator.oneiricconcept.item.MemoriaLootItem;
import net.mcreator.oneiricconcept.item.MemoriaItem;
import net.mcreator.oneiricconcept.item.LegionPseudoSliverItem;
import net.mcreator.oneiricconcept.item.LegionPseudoCoreItem;
import net.mcreator.oneiricconcept.item.HonkaiSliverItem;
import net.mcreator.oneiricconcept.item.HonkaiShardItem;
import net.mcreator.oneiricconcept.item.ExampleItem;
import net.mcreator.oneiricconcept.item.DumplingItem;
import net.mcreator.oneiricconcept.item.DreamdiveCanItem;
import net.mcreator.oneiricconcept.item.DarkXuanyuanSwordItem;
import net.mcreator.oneiricconcept.item.DXuanyuanItem;
import net.mcreator.oneiricconcept.item.CondensedMemoriaPieceItem;
import net.mcreator.oneiricconcept.item.CompressTotemlootItem;
import net.mcreator.oneiricconcept.item.CloudBottleItem;
import net.mcreator.oneiricconcept.item.BossStoneCoinGunItem;
import net.mcreator.oneiricconcept.item.BelobogSausageItem;
import net.mcreator.oneiricconcept.item.B2elobogSausageItem;
import net.mcreator.oneiricconcept.item.AdeptusGunItem;
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
	public static final DeferredItem<Item> CRYSTAL_TURTLE_SPAWN_EGG = REGISTRY.register("crystal_turtle_spawn_egg", () -> new DeferredSpawnEggItem(OneiricconceptModEntities.CRYSTAL_TURTLE, -1, -1, new Item.Properties()));
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

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	private static DeferredItem<Item> doubleBlock(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Item.Properties()));
	}
}
