
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
import net.mcreator.oneiricconcept.block.entity.PgcPresentBlockEntity;
import net.mcreator.oneiricconcept.block.entity.Geooo1BlockEntity;
import net.mcreator.oneiricconcept.block.entity.AmbrosialArborLogBlockEntity;
import net.mcreator.oneiricconcept.OneiricconceptMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class OneiricconceptModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, OneiricconceptMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> PGC_PRESENT = register("pgc_present", OneiricconceptModBlocks.PGC_PRESENT, PgcPresentBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> SUSTENANCEANCHOROFF = register("sustenanceanchoroff", OneiricconceptModBlocks.SUSTENANCEANCHOROFF, SustenanceanchoroffBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> SUSTENANCEANCHOR = register("sustenanceanchor", OneiricconceptModBlocks.SUSTENANCEANCHOR, SustenanceanchorBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> GEOOO_1 = register("geooo_1", OneiricconceptModBlocks.GEOOO_1, Geooo1BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> AMBROSIAL_ARBOR_LOG = register("ambrosial_arbor_log", OneiricconceptModBlocks.AMBROSIAL_ARBOR_LOG, AmbrosialArborLogBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PGC_PRESENT.get(), (blockEntity, side) -> ((PgcPresentBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SUSTENANCEANCHOROFF.get(), (blockEntity, side) -> ((SustenanceanchoroffBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SUSTENANCEANCHOR.get(), (blockEntity, side) -> ((SustenanceanchorBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GEOOO_1.get(), (blockEntity, side) -> ((Geooo1BlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, AMBROSIAL_ARBOR_LOG.get(), (blockEntity, side) -> ((AmbrosialArborLogBlockEntity) blockEntity).getItemHandler());
	}
}
