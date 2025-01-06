package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;

public class WaterplaceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Direction direction) {
		if (direction == null)
			return;
		double x1 = 0;
		double y1 = 0;
		double z1 = 0;
		BlockplaceProcedure.execute(world, x, y, z, Blocks.WATER.defaultBlockState(), direction);
	}
}
