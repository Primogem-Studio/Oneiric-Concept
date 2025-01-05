package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;
import net.mcreator.oneiricconcept.OneiricconceptMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SetwaterProcedure {
	@SubscribeEvent
	public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getState());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		execute(null, world, x, y, z, blockstate);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (blockstate.getBlock() == OneiricconceptModBlocks.HEARTOFTHEVASTSEA.get()) {
			if (event instanceof ICancellableEvent _cancellable) {
				_cancellable.setCanceled(true);
			}
			OneiricconceptMod.queueServerWork(1, () -> {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.WATER.defaultBlockState(), 3);
			});
		}
	}
}
