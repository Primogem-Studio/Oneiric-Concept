package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class BlockplaceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState placeblock, Direction direction) {
		if (direction == null)
			return;
		double x1 = 0;
		double y1 = 0;
		double z1 = 0;
		x1 = x;
		y1 = y;
		z1 = z;
		if (direction == Direction.DOWN) {
			y1 = y - 1;
		} else if (direction == Direction.UP) {
			y1 = y + 1;
		} else if (direction == Direction.NORTH) {
			z1 = z - 1;
		} else if (direction == Direction.SOUTH) {
			z1 = z + 1;
		} else if (direction == Direction.WEST) {
			x1 = x - 1;
		} else {
			x1 = x + 1;
		}
		world.setBlock(BlockPos.containing(x1, y1, z1), placeblock, 3);
	}
}