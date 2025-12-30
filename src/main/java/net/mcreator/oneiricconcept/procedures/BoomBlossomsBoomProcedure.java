package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

public class BoomBlossomsBoomProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.getBlockFloorHeight(BlockPos.containing(x, y - 1, z)) > 0) {
			world.setBlock(BlockPos.containing(x, y, z), OneiricconceptModBlocks.BOOM_BLOSSOMS_PYRO.get().defaultBlockState(), 3);
			BoomBlossomsPyroBoomProcedure.execute(world, x, y, z);
		} else {
			OverlimitExplosionProcedure.execute(world, x, y, z, 3);
		}
	}
}