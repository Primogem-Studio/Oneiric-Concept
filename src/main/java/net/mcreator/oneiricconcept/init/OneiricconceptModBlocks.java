
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oneiricconcept.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.oneiricconcept.block.YactusBlock;
import net.mcreator.oneiricconcept.block.XiaoLanternRecyclerBlock;
import net.mcreator.oneiricconcept.block.VayudaTurquoiseOreBlock;
import net.mcreator.oneiricconcept.block.VarunadaLazuriteOreBlock;
import net.mcreator.oneiricconcept.block.VajradaAmethystOreBlock;
import net.mcreator.oneiricconcept.block.ThunderSwordBlock;
import net.mcreator.oneiricconcept.block.TheAnotherWorldWoodBlock;
import net.mcreator.oneiricconcept.block.TheAnotherWorldSaplingBlock;
import net.mcreator.oneiricconcept.block.TheAnotherWorldLogBlock;
import net.mcreator.oneiricconcept.block.TheAnotherWorldLeaveBlock;
import net.mcreator.oneiricconcept.block.TexturewayfareblessingBlock;
import net.mcreator.oneiricconcept.block.TNTDispenserBlock;
import net.mcreator.oneiricconcept.block.SweetflowerBlock;
import net.mcreator.oneiricconcept.block.SustenanceanchoroffBlock;
import net.mcreator.oneiricconcept.block.SustenanceanchorBlock;
import net.mcreator.oneiricconcept.block.SuperimposerCustommadeBlock;
import net.mcreator.oneiricconcept.block.StrippedTheAnotherWorldLogBlock;
import net.mcreator.oneiricconcept.block.ShivadaJadeOreBlock;
import net.mcreator.oneiricconcept.block.Redmo1Block;
import net.mcreator.oneiricconcept.block.RainbowCactusBallBlock;
import net.mcreator.oneiricconcept.block.RactusBlock;
import net.mcreator.oneiricconcept.block.PyrosealingwaxBlock;
import net.mcreator.oneiricconcept.block.PropagandaArmyBlockBlock;
import net.mcreator.oneiricconcept.block.PrithivaTopazOreBlock;
import net.mcreator.oneiricconcept.block.PrimogemstormglassBlock;
import net.mcreator.oneiricconcept.block.PrimogemfruitblockBlock;
import net.mcreator.oneiricconcept.block.PhlogistontankBlock;
import net.mcreator.oneiricconcept.block.PgcPresentBlock;
import net.mcreator.oneiricconcept.block.PgcPgBlock;
import net.mcreator.oneiricconcept.block.Newmo1Block;
import net.mcreator.oneiricconcept.block.NestBlock;
import net.mcreator.oneiricconcept.block.NagadusEmeraldOreBlock;
import net.mcreator.oneiricconcept.block.MoltenMetalBlockBlock;
import net.mcreator.oneiricconcept.block.MmMushroomBlock;
import net.mcreator.oneiricconcept.block.MemoriaBlock;
import net.mcreator.oneiricconcept.block.MactusBlock;
import net.mcreator.oneiricconcept.block.Liron1Block;
import net.mcreator.oneiricconcept.block.HydrosealingwaxBlock;
import net.mcreator.oneiricconcept.block.Hydro1Block;
import net.mcreator.oneiricconcept.block.HertabondBlock;
import net.mcreator.oneiricconcept.block.GeosealingwaxBlock;
import net.mcreator.oneiricconcept.block.Geooo1Block;
import net.mcreator.oneiricconcept.block.GeomarrowRadiatorBlock;
import net.mcreator.oneiricconcept.block.GactusBlock;
import net.mcreator.oneiricconcept.block.Fulmo1Block;
import net.mcreator.oneiricconcept.block.FreshSeedofDawnBlock;
import net.mcreator.oneiricconcept.block.FloatingCloudBlock;
import net.mcreator.oneiricconcept.block.ExhaustedprimogemBlock;
import net.mcreator.oneiricconcept.block.EngineeringantimatterbombblockBlock;
import net.mcreator.oneiricconcept.block.ElementsCrystalOreBlock;
import net.mcreator.oneiricconcept.block.ElectrosealingwaxBlock;
import net.mcreator.oneiricconcept.block.Elect1Block;
import net.mcreator.oneiricconcept.block.DendrosealingwaxBlock;
import net.mcreator.oneiricconcept.block.Dendr1Block;
import net.mcreator.oneiricconcept.block.DawnleavesBlock;
import net.mcreator.oneiricconcept.block.CrystalgeneratorBlock;
import net.mcreator.oneiricconcept.block.CryosealingwaxBlock;
import net.mcreator.oneiricconcept.block.Cryoo1Block;
import net.mcreator.oneiricconcept.block.CloudBlock;
import net.mcreator.oneiricconcept.block.CamerapinkBlock;
import net.mcreator.oneiricconcept.block.CameraBlock;
import net.mcreator.oneiricconcept.block.CCactusBlock;
import net.mcreator.oneiricconcept.block.BoomBlossomsPyroBlock;
import net.mcreator.oneiricconcept.block.BigStoneBlock;
import net.mcreator.oneiricconcept.block.BigRockBlock;
import net.mcreator.oneiricconcept.block.BananaMushroomBockBlock;
import net.mcreator.oneiricconcept.block.BananaMushroomBlock;
import net.mcreator.oneiricconcept.block.BactusBlock;
import net.mcreator.oneiricconcept.block.AnemoSealingwaxBlock;
import net.mcreator.oneiricconcept.block.Anemo1Block;
import net.mcreator.oneiricconcept.block.AmbrosialArborWoodBlock;
import net.mcreator.oneiricconcept.block.AmbrosialArborSaplingBlock;
import net.mcreator.oneiricconcept.block.AmbrosialArborPlankBlock;
import net.mcreator.oneiricconcept.block.AmbrosialArborLogBlock;
import net.mcreator.oneiricconcept.block.AmbrosialArborLeaveBlock;
import net.mcreator.oneiricconcept.block.AgnidusAgateOreBlock;
import net.mcreator.oneiricconcept.block.Agnid1Block;
import net.mcreator.oneiricconcept.OneiricconceptMod;

public class OneiricconceptModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(OneiricconceptMod.MODID);
	public static final DeferredBlock<Block> GEOMARROW_RADIATOR = REGISTRY.register("geomarrow_radiator", GeomarrowRadiatorBlock::new);
	public static final DeferredBlock<Block> BOOM_BLOSSOMS_PYRO = REGISTRY.register("boom_blossoms_pyro", BoomBlossomsPyroBlock::new);
	public static final DeferredBlock<Block> BANANA_MUSHROOM = REGISTRY.register("banana_mushroom", BananaMushroomBlock::new);
	public static final DeferredBlock<Block> BANANA_MUSHROOM_BOCK = REGISTRY.register("banana_mushroom_bock", BananaMushroomBockBlock::new);
	public static final DeferredBlock<Block> ELEMENTS_CRYSTAL_ORE = REGISTRY.register("elements_crystal_ore", ElementsCrystalOreBlock::new);
	public static final DeferredBlock<Block> NAGADUS_EMERALD_ORE = REGISTRY.register("nagadus_emerald_ore", NagadusEmeraldOreBlock::new);
	public static final DeferredBlock<Block> SHIVADA_JADE_ORE = REGISTRY.register("shivada_jade_ore", ShivadaJadeOreBlock::new);
	public static final DeferredBlock<Block> VAJRADA_AMETHYST_ORE = REGISTRY.register("vajrada_amethyst_ore", VajradaAmethystOreBlock::new);
	public static final DeferredBlock<Block> VARUNADA_LAZURITE_ORE = REGISTRY.register("varunada_lazurite_ore", VarunadaLazuriteOreBlock::new);
	public static final DeferredBlock<Block> CLOUD = REGISTRY.register("cloud", CloudBlock::new);
	public static final DeferredBlock<Block> PRITHIVA_TOPAZ_ORE = REGISTRY.register("prithiva_topaz_ore", PrithivaTopazOreBlock::new);
	public static final DeferredBlock<Block> VAYUDA_TURQUOISE_ORE = REGISTRY.register("vayuda_turquoise_ore", VayudaTurquoiseOreBlock::new);
	public static final DeferredBlock<Block> AGNIDUS_AGATE_ORE = REGISTRY.register("agnidus_agate_ore", AgnidusAgateOreBlock::new);
	public static final DeferredBlock<Block> MEMORIA = REGISTRY.register("memoria", MemoriaBlock::new);
	public static final DeferredBlock<Block> BIG_STONE = REGISTRY.register("big_stone", BigStoneBlock::new);
	public static final DeferredBlock<Block> BIG_ROCK = REGISTRY.register("big_rock", BigRockBlock::new);
	public static final DeferredBlock<Block> THE_ANOTHER_WORLD_LOG = REGISTRY.register("the_another_world_log", TheAnotherWorldLogBlock::new);
	public static final DeferredBlock<Block> STRIPPED_THE_ANOTHER_WORLD_LOG = REGISTRY.register("stripped_the_another_world_log", StrippedTheAnotherWorldLogBlock::new);
	public static final DeferredBlock<Block> THE_ANOTHER_WORLD_SAPLING = REGISTRY.register("the_another_world_sapling", TheAnotherWorldSaplingBlock::new);
	public static final DeferredBlock<Block> THE_ANOTHER_WORLD_WOOD = REGISTRY.register("the_another_world_wood", TheAnotherWorldWoodBlock::new);
	public static final DeferredBlock<Block> MM_MUSHROOM = REGISTRY.register("mm_mushroom", MmMushroomBlock::new);
	public static final DeferredBlock<Block> BACTUS = REGISTRY.register("bactus", BactusBlock::new);
	public static final DeferredBlock<Block> C_CACTUS = REGISTRY.register("c_cactus", CCactusBlock::new);
	public static final DeferredBlock<Block> GACTUS = REGISTRY.register("gactus", GactusBlock::new);
	public static final DeferredBlock<Block> MACTUS = REGISTRY.register("mactus", MactusBlock::new);
	public static final DeferredBlock<Block> RACTUS = REGISTRY.register("ractus", RactusBlock::new);
	public static final DeferredBlock<Block> YACTUS = REGISTRY.register("yactus", YactusBlock::new);
	public static final DeferredBlock<Block> THE_ANOTHER_WORLD_LEAVE = REGISTRY.register("the_another_world_leave", TheAnotherWorldLeaveBlock::new);
	public static final DeferredBlock<Block> TNT_DISPENSER = REGISTRY.register("tnt_dispenser", TNTDispenserBlock::new);
	public static final DeferredBlock<Block> PROPAGANDA_ARMY_BLOCK = REGISTRY.register("propaganda_army_block", PropagandaArmyBlockBlock::new);
	public static final DeferredBlock<Block> THUNDER_SWORD = REGISTRY.register("thunder_sword", ThunderSwordBlock::new);
	public static final DeferredBlock<Block> PGC_PRESENT = REGISTRY.register("pgc_present", PgcPresentBlock::new);
	public static final DeferredBlock<Block> PRIMOGEM = REGISTRY.register("primogem", PgcPgBlock::new);
	public static final DeferredBlock<Block> PYRO_METAL = REGISTRY.register("pyro_metal", Agnid1Block::new);
	public static final DeferredBlock<Block> CAMERA = REGISTRY.register("camera", CameraBlock::new);
	public static final DeferredBlock<Block> SUSTENANCEANCHOROFF = REGISTRY.register("sustenanceanchoroff", SustenanceanchoroffBlock::new);
	public static final DeferredBlock<Block> SUSTENANCEANCHOR = REGISTRY.register("sustenanceanchor", SustenanceanchorBlock::new);
	public static final DeferredBlock<Block> CRESCENT_METAL = REGISTRY.register("crescent_metal", Newmo1Block::new);
	public static final DeferredBlock<Block> REDMOON_METAL = REGISTRY.register("redmoon_metal", Redmo1Block::new);
	public static final DeferredBlock<Block> FULLMOON_METAL = REGISTRY.register("fullmoon_metal", Fulmo1Block::new);
	public static final DeferredBlock<Block> TRASHMETAL = REGISTRY.register("trashmetal", Liron1Block::new);
	public static final DeferredBlock<Block> ELECTRO_METAL = REGISTRY.register("electro_metal", Elect1Block::new);
	public static final DeferredBlock<Block> HYDRO_METAL = REGISTRY.register("hydro_metal", Hydro1Block::new);
	public static final DeferredBlock<Block> CRYO_METAL = REGISTRY.register("cryo_metal", Cryoo1Block::new);
	public static final DeferredBlock<Block> DENDRO_METAL = REGISTRY.register("dendro_metal", Dendr1Block::new);
	public static final DeferredBlock<Block> ANEMO_METAL = REGISTRY.register("anemo_metal", Anemo1Block::new);
	public static final DeferredBlock<Block> GEO_METAL = REGISTRY.register("geo_metal", Geooo1Block::new);
	public static final DeferredBlock<Block> SUPERIMPOSER_CUSTOMMADE = REGISTRY.register("superimposer_custommade", SuperimposerCustommadeBlock::new);
	public static final DeferredBlock<Block> HERTABOND = REGISTRY.register("hertabond", HertabondBlock::new);
	public static final DeferredBlock<Block> PYROSEALINGWAX = REGISTRY.register("pyrosealingwax", PyrosealingwaxBlock::new);
	public static final DeferredBlock<Block> ELECTROSEALINGWAX = REGISTRY.register("electrosealingwax", ElectrosealingwaxBlock::new);
	public static final DeferredBlock<Block> HYDROSEALINGWAX = REGISTRY.register("hydrosealingwax", HydrosealingwaxBlock::new);
	public static final DeferredBlock<Block> CRYOSEALINGWAX = REGISTRY.register("cryosealingwax", CryosealingwaxBlock::new);
	public static final DeferredBlock<Block> DENDROSEALINGWAX = REGISTRY.register("dendrosealingwax", DendrosealingwaxBlock::new);
	public static final DeferredBlock<Block> ANEMO_SEALINGWAX = REGISTRY.register("anemo_sealingwax", AnemoSealingwaxBlock::new);
	public static final DeferredBlock<Block> GEOSEALINGWAX = REGISTRY.register("geosealingwax", GeosealingwaxBlock::new);
	public static final DeferredBlock<Block> AMBROSIAL_ARBOR_LOG = REGISTRY.register("ambrosial_arbor_log", AmbrosialArborLogBlock::new);
	public static final DeferredBlock<Block> AMBROSIAL_ARBOR_LEAVE = REGISTRY.register("ambrosial_arbor_leave", AmbrosialArborLeaveBlock::new);
	public static final DeferredBlock<Block> MOLTEN_METAL_BLOCK = REGISTRY.register("molten_metal_block", MoltenMetalBlockBlock::new);
	public static final DeferredBlock<Block> PRIMOGEMFRUITBLOCK = REGISTRY.register("primogemfruitblock", PrimogemfruitblockBlock::new);
	public static final DeferredBlock<Block> AMBROSIAL_ARBOR_SAPLING = REGISTRY.register("ambrosial_arbor_sapling", AmbrosialArborSaplingBlock::new);
	public static final DeferredBlock<Block> AMBROSIAL_ARBOR_PLANK = REGISTRY.register("ambrosial_arbor_plank", AmbrosialArborPlankBlock::new);
	public static final DeferredBlock<Block> WAYFAREBLESSING = REGISTRY.register("wayfareblessing", TexturewayfareblessingBlock::new);
	public static final DeferredBlock<Block> FLOATING_CLOUD = REGISTRY.register("floating_cloud", FloatingCloudBlock::new);
	public static final DeferredBlock<Block> AMBROSIAL_ARBOR_WOOD = REGISTRY.register("ambrosial_arbor_wood", AmbrosialArborWoodBlock::new);
	public static final DeferredBlock<Block> FRESH_SEEDOF_DAWN = REGISTRY.register("fresh_seedof_dawn", FreshSeedofDawnBlock::new);
	public static final DeferredBlock<Block> DAWNLEAVES = REGISTRY.register("dawnleaves", DawnleavesBlock::new);
	public static final DeferredBlock<Block> XIAO_LANTERN_RECYCLER = REGISTRY.register("xiao_lantern_recycler", XiaoLanternRecyclerBlock::new);
	public static final DeferredBlock<Block> PHLOGISTONTANK = REGISTRY.register("phlogistontank", PhlogistontankBlock::new);
	public static final DeferredBlock<Block> CAMERAPINK = REGISTRY.register("camerapink", CamerapinkBlock::new);
	public static final DeferredBlock<Block> SWEETFLOWER = REGISTRY.register("sweetflower", SweetflowerBlock::new);
	public static final DeferredBlock<Block> RAINBOW_CACTUS_BALL = REGISTRY.register("rainbow_cactus_ball", RainbowCactusBallBlock::new);
	public static final DeferredBlock<Block> EXHAUSTEDPRIMOGEM = REGISTRY.register("exhaustedprimogem", ExhaustedprimogemBlock::new);
	public static final DeferredBlock<Block> PRIMOGEMSTORMGLASS = REGISTRY.register("primogemstormglass", PrimogemstormglassBlock::new);
	public static final DeferredBlock<Block> CRYSTALGENERATOR = REGISTRY.register("crystalgenerator", CrystalgeneratorBlock::new);
	public static final DeferredBlock<Block> NEST = REGISTRY.register("nest", NestBlock::new);
	public static final DeferredBlock<Block> ENGINEERINGANTIMATTERBOMBBLOCK = REGISTRY.register("engineeringantimatterbombblock", EngineeringantimatterbombblockBlock::new);

	// Start of user code block custom blocks
	// End of user code block custom blocks
	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class BlocksClientSideHandler {
		@SubscribeEvent
		public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
			Hydro1Block.blockColorLoad(event);
			Dendr1Block.blockColorLoad(event);
			Anemo1Block.blockColorLoad(event);
			HydrosealingwaxBlock.blockColorLoad(event);
			DendrosealingwaxBlock.blockColorLoad(event);
			FreshSeedofDawnBlock.blockColorLoad(event);
		}
	}
}
