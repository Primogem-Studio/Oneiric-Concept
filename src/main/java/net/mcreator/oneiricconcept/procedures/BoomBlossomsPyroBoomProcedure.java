package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;
import net.mcreator.oneiricconcept.OneiricconceptMod;

public class BoomBlossomsPyroBoomProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		OneiricconceptMod.queueServerWork(60, () -> {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == OneiricconceptModBlocks.BOOM_BLOSSOMS_PYRO.get()) {
				OverlimitExplosionProcedure.execute(world, x, y + 2, z, 9);
			}
		});
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putBoolean("isin", true);
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}
}