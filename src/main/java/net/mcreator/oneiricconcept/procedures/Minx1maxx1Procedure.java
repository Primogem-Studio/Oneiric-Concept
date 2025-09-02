package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class Minx1maxx1Procedure {
	@SubscribeEvent
	public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getState(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		execute(null, world, x, y, z, blockstate, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if (blockstate.getBlock() == OneiricconceptModBlocks.FLOATING_CLOUD.get()) {
			if (PlaceconflictProcedure.execute(world, x, y, z, 1, 0, 0, -1, 0, 0, entity.getYRot())) {
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
			}
		}
	}
}