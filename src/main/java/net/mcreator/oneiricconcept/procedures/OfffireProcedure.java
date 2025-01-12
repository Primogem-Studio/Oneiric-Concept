package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class OfffireProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double x2, double y2, double z2) {
		double x1 = 0;
		double y1 = 0;
		double z1 = 0;
		x1 = x2;
		y1 = y2;
		z1 = z2;
		if ((world.getBlockState(BlockPos.containing(x1, y1, z1))).getBlock() == Blocks.FIRE) {
			world.setBlock(BlockPos.containing(x1, y1, z1), (world.getBlockState(BlockPos.containing(x, y, z))), 3);
			SummonzombieProcedure.execute(world, x1, y1, z1);
		}
	}
}
