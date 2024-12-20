package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class SupportProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Direction wesn) {
		if (wesn == null)
			return;
		Direction wens = Direction.NORTH;
		double mode = 0;
		if (!world.getBlockState(BlockPos.containing(x, y, z)).isFaceSturdy(world, BlockPos.containing(x, y, z), wesn)) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
				world.destroyBlock(_pos, false);
			}
		}
	}
}
