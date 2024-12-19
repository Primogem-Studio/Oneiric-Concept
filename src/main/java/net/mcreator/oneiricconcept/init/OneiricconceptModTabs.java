
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oneiricconcept.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.oneiricconcept.OneiricconceptMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class OneiricconceptModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OneiricconceptMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ONEIRIC_CONCEPTFOOD = REGISTRY.register("oneiric_conceptfood",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.oneiricconcept.oneiric_conceptfood")).icon(() -> new ItemStack(OneiricconceptModItems.BELOBOG_SAUSAGE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(OneiricconceptModItems.STUFFING.get());
				tabData.accept(OneiricconceptModItems.S_2TUFFING.get());
				tabData.accept(OneiricconceptModItems.OY_STUFFING.get());
				tabData.accept(OneiricconceptModItems.SAUSAGE.get());
				tabData.accept(OneiricconceptModItems.SMOKE_SAUSAGE.get());
				tabData.accept(OneiricconceptModItems.BELOBOG_SAUSAGE.get());
				tabData.accept(OneiricconceptModItems.S_2AUSAGE.get());
				tabData.accept(OneiricconceptModItems.S_2MOKE_SAUSAGE.get());
				tabData.accept(OneiricconceptModItems.B_2ELOBOG_SAUSAGE.get());
				tabData.accept(OneiricconceptModItems.MORA_SAUSAGE.get());
				tabData.accept(OneiricconceptModItems.PRIMOGEMS_SAUSAGE.get());
				tabData.accept(OneiricconceptModItems.DUMPLING.get());
				tabData.accept(OneiricconceptModItems.OY_DUMPLING.get());
				tabData.accept(OneiricconceptModItems.WAFFLE.get());
				tabData.accept(OneiricconceptModItems.PRIMOGEM_WAFFLE.get());
				tabData.accept(OneiricconceptModItems.SKY_WAFFLE.get());
				tabData.accept(OneiricconceptModItems.RESURRECTION_PELLET.get());
			}).build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ONEIRIC_CONCEPT = REGISTRY.register("oneiric_concept",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.oneiricconcept.oneiric_concept")).icon(() -> new ItemStack(OneiricconceptModItems.ONEIRIC_SHARD.get())).displayItems((parameters, tabData) -> {
				tabData.accept(OneiricconceptModItems.ONEIRIC_SHARD.get());
				tabData.accept(OneiricconceptModBlocks.GEOMARROW_RADIATOR.get().asItem());
				tabData.accept(OneiricconceptModBlocks.BANANA_MUSHROOM.get().asItem());
				tabData.accept(OneiricconceptModBlocks.BANANA_MUSHROOM_BOCK.get().asItem());
				tabData.accept(OneiricconceptModItems.CLOUD_BOTTLE.get());
				tabData.accept(OneiricconceptModBlocks.CLOUD.get().asItem());
				tabData.accept(OneiricconceptModBlocks.AGNIDUS_AGATE_ORE.get().asItem());
				tabData.accept(OneiricconceptModBlocks.VARUNADA_LAZURITE_ORE.get().asItem());
				tabData.accept(OneiricconceptModBlocks.VAYUDA_TURQUOISE_ORE.get().asItem());
				tabData.accept(OneiricconceptModBlocks.VAJRADA_AMETHYST_ORE.get().asItem());
				tabData.accept(OneiricconceptModBlocks.NAGADUS_EMERALD_ORE.get().asItem());
				tabData.accept(OneiricconceptModBlocks.SHIVADA_JADE_ORE.get().asItem());
				tabData.accept(OneiricconceptModBlocks.PRITHIVA_TOPAZ_ORE.get().asItem());
				tabData.accept(OneiricconceptModBlocks.ELEMENTS_CRYSTAL_ORE.get().asItem());
				tabData.accept(OneiricconceptModItems.DREAMDIVE_CAN.get());
				tabData.accept(OneiricconceptModItems.SUN_START_CAN.get());
				tabData.accept(OneiricconceptModItems.MEMORY_BUBBLE.get());
				tabData.accept(OneiricconceptModItems.MEMORIA_PIECE.get());
				tabData.accept(OneiricconceptModItems.CONDENSED_MEMORIA_PIECE.get());
				tabData.accept(OneiricconceptModItems.MEMORIA_LOOT.get());
				tabData.accept(OneiricconceptModItems.MEMORIA_BUCKET.get());
				tabData.accept(OneiricconceptModItems.XUANYUAN_SWORD.get());
				tabData.accept(OneiricconceptModItems.DARK_XUANYUAN_SWORD.get());
				tabData.accept(OneiricconceptModItems.D_XUANYUAN.get());
				tabData.accept(OneiricconceptModItems.HONKAI_SHARD.get());
				tabData.accept(OneiricconceptModItems.HONKAI_SLIVER.get());
				tabData.accept(OneiricconceptModItems.LEGION_PSEUDO_CORE.get());
				tabData.accept(OneiricconceptModItems.LEGION_PSEUDO_SLIVER.get());
				tabData.accept(OneiricconceptModBlocks.THE_ANOTHER_WORLD_SAPLING.get().asItem());
				tabData.accept(OneiricconceptModBlocks.THE_ANOTHER_WORLD_LOG.get().asItem());
				tabData.accept(OneiricconceptModBlocks.THE_ANOTHER_WORLD_WOOD.get().asItem());
				tabData.accept(OneiricconceptModBlocks.STRIPPED_THE_ANOTHER_WORLD_LOG.get().asItem());
				tabData.accept(OneiricconceptModItems.TAW_WOOD_BOX.get());
				tabData.accept(OneiricconceptModItems.TAW_WOOD_LOOT.get());
				tabData.accept(OneiricconceptModBlocks.BIG_STONE.get().asItem());
				tabData.accept(OneiricconceptModBlocks.BIG_ROCK.get().asItem());
				tabData.accept(OneiricconceptModItems.SURPRISEBOXFORGOODORBAD.get());
				tabData.accept(OneiricconceptModBlocks.MM_MUSHROOM.get().asItem());
				tabData.accept(OneiricconceptModItems.SWORD_OF_BRILLIANT_VALOR.get());
				tabData.accept(OneiricconceptModBlocks.THE_ANOTHER_WORLD_LEAVE.get().asItem());
				tabData.accept(OneiricconceptModBlocks.TNT_DISPENSER.get().asItem());
				tabData.accept(OneiricconceptModItems.SMALL_HERTA_CORE.get());
				tabData.accept(OneiricconceptModItems.TOTEMLOOT.get());
				tabData.accept(OneiricconceptModItems.COMPRESS_TOTEMLOOT.get());
				tabData.accept(OneiricconceptModItems.BOSS_STONE_COIN_GUN.get());
				tabData.accept(OneiricconceptModItems.BOSS_STONE_COIN_GUN_PLUS.get());
				tabData.accept(OneiricconceptModItems.MORA_MAGAZINE.get());
				tabData.accept(OneiricconceptModItems.MORA_MAGAZINE_E_1.get());
				tabData.accept(OneiricconceptModItems.MORA_MAGAZINE_N_2.get());
				tabData.accept(OneiricconceptModItems.MORA_MAGAZINE_E_2.get());
				tabData.accept(OneiricconceptModItems.MORA_MAGAZINE_N_3.get());
				tabData.accept(OneiricconceptModItems.MORA_MAGAZINE_E_3.get());
				tabData.accept(OneiricconceptModItems.PUBLIC_CLAMOR.get());
				tabData.accept(OneiricconceptModBlocks.PROPAGANDA_ARMY_BLOCK.get().asItem());
				tabData.accept(OneiricconceptModItems.PROPAGANDA_ARMY.get());
				tabData.accept(OneiricconceptModItems.A_PROPAGANDA_ARMY.get());
				tabData.accept(OneiricconceptModItems.LESS_REDSTONE_POWDER.get());
				tabData.accept(OneiricconceptModBlocks.THUNDER_SWORD.get().asItem());
				tabData.accept(OneiricconceptModBlocks.CAMERA.get().asItem());
				tabData.accept(OneiricconceptModItems.SUSTENANCEANCHORITEM.get());
			}).withTabsBefore(ONEIRIC_CONCEPTFOOD.getId()).build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ONEIRIC_CONCEPT_DECORATION = REGISTRY.register("oneiric_concept_decoration",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.oneiricconcept.oneiric_concept_decoration")).icon(() -> new ItemStack(OneiricconceptModBlocks.PGC_PG1.get())).displayItems((parameters, tabData) -> {
				tabData.accept(OneiricconceptModBlocks.PGC_PG1.get().asItem());
				tabData.accept(OneiricconceptModBlocks.NEWMO_1.get().asItem());
				tabData.accept(OneiricconceptModBlocks.REDMO_1.get().asItem());
				tabData.accept(OneiricconceptModBlocks.FULMO_1.get().asItem());
				tabData.accept(OneiricconceptModBlocks.AGNID_1.get().asItem());
				tabData.accept(OneiricconceptModBlocks.ELECT_1.get().asItem());
				tabData.accept(OneiricconceptModBlocks.HYDRO_1.get().asItem());
				tabData.accept(OneiricconceptModBlocks.CRYOO_1.get().asItem());
				tabData.accept(OneiricconceptModBlocks.DENDR_1.get().asItem());
				tabData.accept(OneiricconceptModBlocks.ANEMO_1.get().asItem());
				tabData.accept(OneiricconceptModBlocks.GEOOO_1.get().asItem());
				tabData.accept(OneiricconceptModBlocks.LIRON_1.get().asItem());
				tabData.accept(OneiricconceptModBlocks.PGC_PRESENT.get().asItem());
				tabData.accept(OneiricconceptModBlocks.SUPERIMPOSER_CUSTOMMADE.get().asItem());
				tabData.accept(OneiricconceptModBlocks.HBOND_0.get().asItem());
			}).withTabsBefore(ONEIRIC_CONCEPT.getId()).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(OneiricconceptModItems.CRYSTAL_TURTLE_SPAWN_EGG.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(OneiricconceptModItems.EXAMPLE.get());
		}
	}
}
