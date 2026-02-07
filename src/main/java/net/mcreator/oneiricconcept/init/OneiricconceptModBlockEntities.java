/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oneiricconcept.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.oneiricconcept.block.entity.WhiteMoonlightAbsorberBlockEntity;
import net.mcreator.oneiricconcept.block.entity.SustenanceanchoroffBlockEntity;
import net.mcreator.oneiricconcept.block.entity.SustenanceanchorBlockEntity;
import net.mcreator.oneiricconcept.block.entity.PropagandaArmyBlockBlockEntity;
import net.mcreator.oneiricconcept.block.entity.PrimogemstormglassBlockEntity;
import net.mcreator.oneiricconcept.block.entity.PhlogistontankBlockEntity;
import net.mcreator.oneiricconcept.block.entity.PgcPresentBlockEntity;
import net.mcreator.oneiricconcept.block.entity.NestBlockEntity;
import net.mcreator.oneiricconcept.block.entity.Geooo1BlockEntity;
import net.mcreator.oneiricconcept.block.entity.CrystalgeneratorBlockEntity;
import net.mcreator.oneiricconcept.block.entity.CelebratoryXiaoLanternBlockEntity;
import net.mcreator.oneiricconcept.block.entity.BoomBlossomsPyroBlockEntity;
import net.mcreator.oneiricconcept.block.entity.BoomBlossomsHydroBlockEntity;
import net.mcreator.oneiricconcept.block.entity.BoomBlossomsElectroBlockEntity;
import net.mcreator.oneiricconcept.block.entity.BoomBlossomsDendroBlockEntity;
import net.mcreator.oneiricconcept.block.entity.BoomBlossomsCryoBlockEntity;
import net.mcreator.oneiricconcept.OneiricconceptMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class OneiricconceptModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, OneiricconceptMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BoomBlossomsPyroBlockEntity>> BOOM_BLOSSOMS_PYRO = register("boom_blossoms_pyro", OneiricconceptModBlocks.BOOM_BLOSSOMS_PYRO, BoomBlossomsPyroBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PropagandaArmyBlockBlockEntity>> PROPAGANDA_ARMY_BLOCK = register("propaganda_army_block", OneiricconceptModBlocks.PROPAGANDA_ARMY_BLOCK, PropagandaArmyBlockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PgcPresentBlockEntity>> PGC_PRESENT = register("pgc_present", OneiricconceptModBlocks.PGC_PRESENT, PgcPresentBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SustenanceanchoroffBlockEntity>> SUSTENANCEANCHOROFF = register("sustenanceanchoroff", OneiricconceptModBlocks.SUSTENANCEANCHOROFF, SustenanceanchoroffBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SustenanceanchorBlockEntity>> SUSTENANCEANCHOR = register("sustenanceanchor", OneiricconceptModBlocks.SUSTENANCEANCHOR, SustenanceanchorBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Geooo1BlockEntity>> GEO_METAL = register("geo_metal", OneiricconceptModBlocks.GEO_METAL, Geooo1BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PhlogistontankBlockEntity>> PHLOGISTONTANK = register("phlogistontank", OneiricconceptModBlocks.PHLOGISTONTANK, PhlogistontankBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PrimogemstormglassBlockEntity>> PRIMOGEMSTORMGLASS = register("primogemstormglass", OneiricconceptModBlocks.PRIMOGEMSTORMGLASS, PrimogemstormglassBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CrystalgeneratorBlockEntity>> CRYSTALGENERATOR = register("crystalgenerator", OneiricconceptModBlocks.CRYSTALGENERATOR, CrystalgeneratorBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<NestBlockEntity>> NEST = register("nest", OneiricconceptModBlocks.NEST, NestBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WhiteMoonlightAbsorberBlockEntity>> WHITE_MOONLIGHT_ABSORBER = register("white_moonlight_absorber", OneiricconceptModBlocks.WHITE_MOONLIGHT_ABSORBER,
			WhiteMoonlightAbsorberBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CelebratoryXiaoLanternBlockEntity>> CELEBRATORY_XIAO_LANTERN = register("celebratory_xiao_lantern", OneiricconceptModBlocks.CELEBRATORY_XIAO_LANTERN,
			CelebratoryXiaoLanternBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BoomBlossomsCryoBlockEntity>> BOOM_BLOSSOMS_CRYO = register("boom_blossoms_cryo", OneiricconceptModBlocks.BOOM_BLOSSOMS_CRYO, BoomBlossomsCryoBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BoomBlossomsDendroBlockEntity>> BOOM_BLOSSOMS_DENDRO = register("boom_blossoms_dendro", OneiricconceptModBlocks.BOOM_BLOSSOMS_DENDRO, BoomBlossomsDendroBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BoomBlossomsElectroBlockEntity>> BOOM_BLOSSOMS_ELECTRO = register("boom_blossoms_electro", OneiricconceptModBlocks.BOOM_BLOSSOMS_ELECTRO, BoomBlossomsElectroBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BoomBlossomsHydroBlockEntity>> BOOM_BLOSSOMS_HYDRO = register("boom_blossoms_hydro", OneiricconceptModBlocks.BOOM_BLOSSOMS_HYDRO, BoomBlossomsHydroBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BOOM_BLOSSOMS_PYRO.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PROPAGANDA_ARMY_BLOCK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PGC_PRESENT.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SUSTENANCEANCHOROFF.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SUSTENANCEANCHOR.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GEO_METAL.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PHLOGISTONTANK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.FluidHandler.BLOCK, PHLOGISTONTANK.get(), (blockEntity, side) -> blockEntity.getFluidTank());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PRIMOGEMSTORMGLASS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CRYSTALGENERATOR.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, CRYSTALGENERATOR.get(), (blockEntity, side) -> blockEntity.getEnergyStorage());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, NEST.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, WHITE_MOONLIGHT_ABSORBER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CELEBRATORY_XIAO_LANTERN.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BOOM_BLOSSOMS_CRYO.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BOOM_BLOSSOMS_DENDRO.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BOOM_BLOSSOMS_ELECTRO.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, BOOM_BLOSSOMS_HYDRO.get(), SidedInvWrapper::new);
	}
}