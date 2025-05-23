
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oneiricconcept.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.oneiricconcept.block.entity.SustenanceanchoroffBlockEntity;
import net.mcreator.oneiricconcept.block.entity.SustenanceanchorBlockEntity;
import net.mcreator.oneiricconcept.block.entity.PropagandaArmyBlockBlockEntity;
import net.mcreator.oneiricconcept.block.entity.PrimogemstormglassBlockEntity;
import net.mcreator.oneiricconcept.block.entity.PhlogistontankBlockEntity;
import net.mcreator.oneiricconcept.block.entity.PgcPresentBlockEntity;
import net.mcreator.oneiricconcept.block.entity.NestBlockEntity;
import net.mcreator.oneiricconcept.block.entity.Geooo1BlockEntity;
import net.mcreator.oneiricconcept.block.entity.CrystalgeneratorBlockEntity;
import net.mcreator.oneiricconcept.OneiricconceptMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class OneiricconceptModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, OneiricconceptMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> PROPAGANDA_ARMY_BLOCK = register("propaganda_army_block", OneiricconceptModBlocks.PROPAGANDA_ARMY_BLOCK, PropagandaArmyBlockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> PGC_PRESENT = register("pgc_present", OneiricconceptModBlocks.PGC_PRESENT, PgcPresentBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> SUSTENANCEANCHOROFF = register("sustenanceanchoroff", OneiricconceptModBlocks.SUSTENANCEANCHOROFF, SustenanceanchoroffBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> SUSTENANCEANCHOR = register("sustenanceanchor", OneiricconceptModBlocks.SUSTENANCEANCHOR, SustenanceanchorBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> GEO_METAL = register("geo_metal", OneiricconceptModBlocks.GEO_METAL, Geooo1BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> PHLOGISTONTANK = register("phlogistontank", OneiricconceptModBlocks.PHLOGISTONTANK, PhlogistontankBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> PRIMOGEMSTORMGLASS = register("primogemstormglass", OneiricconceptModBlocks.PRIMOGEMSTORMGLASS, PrimogemstormglassBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> CRYSTALGENERATOR = register("crystalgenerator", OneiricconceptModBlocks.CRYSTALGENERATOR, CrystalgeneratorBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> NEST = register("nest", OneiricconceptModBlocks.NEST, NestBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PROPAGANDA_ARMY_BLOCK.get(), (blockEntity, side) -> ((PropagandaArmyBlockBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PGC_PRESENT.get(), (blockEntity, side) -> ((PgcPresentBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SUSTENANCEANCHOROFF.get(), (blockEntity, side) -> ((SustenanceanchoroffBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SUSTENANCEANCHOR.get(), (blockEntity, side) -> ((SustenanceanchorBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GEO_METAL.get(), (blockEntity, side) -> ((Geooo1BlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PHLOGISTONTANK.get(), (blockEntity, side) -> ((PhlogistontankBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.FluidHandler.BLOCK, PHLOGISTONTANK.get(), (blockEntity, side) -> ((PhlogistontankBlockEntity) blockEntity).getFluidTank());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PRIMOGEMSTORMGLASS.get(), (blockEntity, side) -> ((PrimogemstormglassBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CRYSTALGENERATOR.get(), (blockEntity, side) -> ((CrystalgeneratorBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, CRYSTALGENERATOR.get(), (blockEntity, side) -> ((CrystalgeneratorBlockEntity) blockEntity).getEnergyStorage());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, NEST.get(), (blockEntity, side) -> ((NestBlockEntity) blockEntity).getItemHandler());
	}
}
