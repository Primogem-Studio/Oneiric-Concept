
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
				tabData.accept(OneiricconceptModItems.XUANYUAN_ARROW.get());
				tabData.accept(OneiricconceptModItems.DARK_XUANYUAN_SWORD.get());
				tabData.accept(OneiricconceptModItems.D_XUANYUAN.get());
				tabData.accept(OneiricconceptModItems.HONKAI_SHARD.get());
				tabData.accept(OneiricconceptModItems.HONKAI_SLIVER.get());
				tabData.accept(OneiricconceptModItems.LEGION_PSEUDO_CORE.get());
				tabData.accept(OneiricconceptModItems.LEGION_PSEUDO_SLIVER.get());
				tabData.accept(OneiricconceptModBlocks.THE_ANOTHER_WORLD_SAPLING.get().asItem());
				tabData.accept(OneiricconceptModBlocks.THE_ANOTHER_WORLD_LEAVE.get().asItem());
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
				tabData.accept(OneiricconceptModBlocks.THUNDER_SWORD.get().asItem());
				tabData.accept(OneiricconceptModBlocks.TNT_DISPENSER.get().asItem());
				tabData.accept(OneiricconceptModBlocks.XIAO_LANTERN_RECYCLER.get().asItem());
				tabData.accept(OneiricconceptModItems.SMALL_HERTA_CORE.get());
				tabData.accept(OneiricconceptModItems.TOTEMLOOT.get());
				tabData.accept(OneiricconceptModItems.COMPRESS_TOTEMLOOT.get());
				tabData.accept(OneiricconceptModItems.BOSS_STONE_COIN_GUN.get());
				tabData.accept(OneiricconceptModItems.BOSS_STONE_COIN_GUN_PLUS.get());
				tabData.accept(OneiricconceptModItems.MORA_MAGAZINE.get());
				tabData.accept(OneiricconceptModItems.MORA_MAGAZINE_E_1.get());
				tabData.accept(OneiricconceptModItems.PUBLIC_CLAMOR.get());
				tabData.accept(OneiricconceptModBlocks.PROPAGANDA_ARMY_BLOCK.get().asItem());
				tabData.accept(OneiricconceptModItems.PROPAGANDA_ARMY.get());
				tabData.accept(OneiricconceptModItems.A_PROPAGANDA_ARMY.get());
				tabData.accept(OneiricconceptModItems.SUSTENANCEANCHORITEM.get());
				tabData.accept(OneiricconceptModBlocks.AMBROSIAL_ARBOR_SAPLING.get().asItem());
				tabData.accept(OneiricconceptModBlocks.AMBROSIAL_ARBOR_LEAVE.get().asItem());
				tabData.accept(OneiricconceptModBlocks.AMBROSIAL_ARBOR_PLANK.get().asItem());
				tabData.accept(OneiricconceptModBlocks.AMBROSIAL_ARBOR_LOG.get().asItem());
				tabData.accept(OneiricconceptModBlocks.AMBROSIAL_ARBOR_WOOD.get().asItem());
				tabData.accept(OneiricconceptModItems.HILTWOOD_FROM_THE_ARBOR.get());
				tabData.accept(OneiricconceptModItems.IGNIS_AURELIAE.get());
				tabData.accept(OneiricconceptModItems.AURELIAE_PICKAXE.get());
				tabData.accept(OneiricconceptModItems.AURELIAE_AXE.get());
				tabData.accept(OneiricconceptModItems.AURELIAE_SWORD.get());
				tabData.accept(OneiricconceptModItems.AURELIAE_SHOVEL.get());
				tabData.accept(OneiricconceptModItems.AURELIAE_HOE.get());
				tabData.accept(OneiricconceptModItems.DIVINE_ARROW_EMBERS.get());
				tabData.accept(OneiricconceptModItems.MOLTEN_METAL.get());
				tabData.accept(OneiricconceptModBlocks.MOLTEN_METAL_BLOCK.get().asItem());
				tabData.accept(OneiricconceptModItems.HEARTOFTHEFROZENSEA.get());
				tabData.accept(OneiricconceptModItems.HEARTOFTHESKYSEA.get());
				tabData.accept(OneiricconceptModItems.HEARTOFTHEWARMSEA.get());
				tabData.accept(OneiricconceptModItems.HEARTOFTHEFISH.get());
				tabData.accept(OneiricconceptModItems.HEARTOFTHEVASTSEA.get());
				tabData.accept(OneiricconceptModBlocks.FRESH_SEEDOF_DAWN.get().asItem());
				tabData.accept(OneiricconceptModBlocks.DAWNLEAVES.get().asItem());
				tabData.accept(OneiricconceptModBlocks.PHLOGISTONTANK.get().asItem());
				tabData.accept(OneiricconceptModItems.PHLOGISTON_CRYSTAL.get());
				tabData.accept(OneiricconceptModItems.PHLOGISTON_CONTROLLER.get());
				tabData.accept(OneiricconceptModItems.PHLOGISTON_WING_CHESTPLATE.get());
				tabData.accept(OneiricconceptModItems.PHLOGISTON.get());
				tabData.accept(OneiricconceptModItems.WILDERNESS_ROD.get());
				tabData.accept(OneiricconceptModItems.MORA_BOW.get());
				tabData.accept(OneiricconceptModItems.CONQUEROR_S_WILL.get());
				tabData.accept(OneiricconceptModItems.USURPER_S_SCHEME.get());
				tabData.accept(OneiricconceptModItems.THIEF_S_INSTINCT.get());
				tabData.accept(OneiricconceptModItems.SKIP_TOOL.get());
				tabData.accept(OneiricconceptModBlocks.EXHAUSTEDPRIMOGEM.get().asItem());
				tabData.accept(OneiricconceptModItems.STARDUST_BASEBALLER.get());
				tabData.accept(OneiricconceptModBlocks.CRYSTALGENERATOR.get().asItem());
			}).build());
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
				tabData.accept(OneiricconceptModItems.GRILLED_DUMPLING.get());
				tabData.accept(OneiricconceptModItems.GRILLED_OY_DUMPLING.get());
				tabData.accept(OneiricconceptModItems.WAFFLE.get());
				tabData.accept(OneiricconceptModItems.PRIMOGEM_WAFFLE.get());
				tabData.accept(OneiricconceptModItems.SKY_WAFFLE.get());
				tabData.accept(OneiricconceptModItems.RESURRECTION_PELLET.get());
				tabData.accept(OneiricconceptModBlocks.WAYFAREBLESSING.get().asItem());
				tabData.accept(OneiricconceptModItems.WAYFARE_CAKE_SLICES.get());
				tabData.accept(OneiricconceptModItems.PRIMOGEMFRUIT.get());
				tabData.accept(OneiricconceptModItems.RED_BEAN_SOUP_FILLING_YUAN_XIAO.get());
				tabData.accept(OneiricconceptModItems.SWEET_SESAME_FILLING_YUAN_XIAO.get());
				tabData.accept(OneiricconceptModItems.HUNGER.get());
				tabData.accept(OneiricconceptModItems.MILK.get());
				tabData.accept(OneiricconceptModItems.SALT.get());
				tabData.accept(OneiricconceptModItems.DEEP_MARROW_ROCK_SALT.get());
				tabData.accept(OneiricconceptModItems.SALT_DUST.get());
				tabData.accept(OneiricconceptModItems.AMBERGRIS_CHEESE_SLIVER.get());
				tabData.accept(OneiricconceptModItems.FISHCAKE.get());
				tabData.accept(OneiricconceptModBlocks.SWEETFLOWER.get().asItem());
				tabData.accept(OneiricconceptModItems.ICE_FRESH_RAW_FROSTWEAVE_SALMON_SLICES.get());
				tabData.accept(OneiricconceptModItems.FISH.get());
				tabData.accept(OneiricconceptModItems.FRUITPASTEBAIT.get());
				tabData.accept(OneiricconceptModItems.MEDAKA.get());
				tabData.accept(OneiricconceptModItems.AIZENMEDAKA.get());
				tabData.accept(OneiricconceptModItems.SWEETFLOWERMEDAKA.get());
				tabData.accept(OneiricconceptModItems.GLAZEMEDAKA.get());
				tabData.accept(OneiricconceptModItems.SOLID_WATER.get());
				tabData.accept(OneiricconceptModItems.TREE_BARKOF_ERUDITION.get());
				tabData.accept(OneiricconceptModItems.VIRTUAL_PARTICLE.get());
				tabData.accept(OneiricconceptModItems.CAMO_PAINT.get());
				tabData.accept(OneiricconceptModItems.ENERGY_DRINK.get());
				tabData.accept(OneiricconceptModItems.PUNITIVE_ENERGY.get());
				tabData.accept(OneiricconceptModItems.ENERGY_DRINK_SUGAR_FREE.get());
				tabData.accept(OneiricconceptModItems.ENERGY_DRINK_PRIMOGEM.get());
				tabData.accept(OneiricconceptModItems.DREAMY_CONE.get());
			}).withTabsBefore(ONEIRIC_CONCEPT.getId()).build());
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ONEIRIC_CONCEPT_DECORATION = REGISTRY.register("oneiric_concept_decoration",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.oneiricconcept.oneiric_concept_decoration")).icon(() -> new ItemStack(OneiricconceptModBlocks.HERTABOND.get())).displayItems((parameters, tabData) -> {
				tabData.accept(OneiricconceptModBlocks.PGC_PRESENT.get().asItem());
				tabData.accept(OneiricconceptModBlocks.SUPERIMPOSER_CUSTOMMADE.get().asItem());
				tabData.accept(OneiricconceptModBlocks.HERTABOND.get().asItem());
				tabData.accept(OneiricconceptModBlocks.PRIMOGEM.get().asItem());
				tabData.accept(OneiricconceptModBlocks.PYROSEALINGWAX.get().asItem());
				tabData.accept(OneiricconceptModBlocks.HYDROSEALINGWAX.get().asItem());
				tabData.accept(OneiricconceptModBlocks.ANEMO_SEALINGWAX.get().asItem());
				tabData.accept(OneiricconceptModBlocks.ELECTROSEALINGWAX.get().asItem());
				tabData.accept(OneiricconceptModBlocks.DENDROSEALINGWAX.get().asItem());
				tabData.accept(OneiricconceptModBlocks.CRYOSEALINGWAX.get().asItem());
				tabData.accept(OneiricconceptModBlocks.GEOSEALINGWAX.get().asItem());
				tabData.accept(OneiricconceptModBlocks.CAMERAPINK.get().asItem());
				tabData.accept(OneiricconceptModBlocks.CAMERA.get().asItem());
				tabData.accept(OneiricconceptModBlocks.PYRO_METAL.get().asItem());
				tabData.accept(OneiricconceptModBlocks.HYDRO_METAL.get().asItem());
				tabData.accept(OneiricconceptModBlocks.ANEMO_METAL.get().asItem());
				tabData.accept(OneiricconceptModBlocks.ELECTRO_METAL.get().asItem());
				tabData.accept(OneiricconceptModBlocks.DENDRO_METAL.get().asItem());
				tabData.accept(OneiricconceptModBlocks.CRYO_METAL.get().asItem());
				tabData.accept(OneiricconceptModBlocks.GEO_METAL.get().asItem());
				tabData.accept(OneiricconceptModBlocks.TRASHMETAL.get().asItem());
				tabData.accept(OneiricconceptModBlocks.CRESCENT_METAL.get().asItem());
				tabData.accept(OneiricconceptModBlocks.REDMOON_METAL.get().asItem());
				tabData.accept(OneiricconceptModBlocks.FULLMOON_METAL.get().asItem());
				tabData.accept(OneiricconceptModBlocks.RAINBOW_CACTUS_BALL.get().asItem());
				tabData.accept(OneiricconceptModBlocks.PRIMOGEMSTORMGLASS.get().asItem());
			}).withTabsBefore(ONEIRIC_CONCEPTFOOD.getId()).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.OP_BLOCKS) {
			if (tabData.hasPermissions()) {
				tabData.accept(OneiricconceptModItems.ADEPTUS_GUN.get());
				tabData.accept(OneiricconceptModItems.EXAMPLE.get());
				tabData.accept(OneiricconceptModBlocks.FLOATING_CLOUD.get().asItem());
				tabData.accept(OneiricconceptModItems.PHLOGISTON_CORE.get());
				tabData.accept(OneiricconceptModItems.PRIMOGEMCRAFTWIKI.get());
				tabData.accept(OneiricconceptModItems.ADEPTUSTOOL.get());
			}
		} else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(OneiricconceptModItems.CRYSTAL_TURTLE_SPAWN_EGG.get());
			tabData.accept(OneiricconceptModItems.BARYON_SPAWN_EGG.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(OneiricconceptModItems.EXAMPLE.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(OneiricconceptModItems.PHLOGISTON_CORE.get());
		}
	}
}
