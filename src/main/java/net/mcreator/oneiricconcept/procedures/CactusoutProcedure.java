package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class CactusoutProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!(world.isEmptyBlock(BlockPos.containing(x, y, z - 1)) && world.isEmptyBlock(BlockPos.containing(x, y, z + 1)) && world.isEmptyBlock(BlockPos.containing(x - 1, y, z)) && world.isEmptyBlock(BlockPos.containing(x + 1, y, z)))) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
				world.destroyBlock(_pos, false);
			}
		}
	}
}