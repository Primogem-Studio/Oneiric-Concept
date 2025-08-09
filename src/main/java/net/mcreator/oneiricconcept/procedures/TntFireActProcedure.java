package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class TntFireActProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double x2, double y2, double z2) {
		if (Blocks.FIRE == (world.getBlockState(BlockPos.containing(x2 + 0.5, y2 + 0.5, z2 + 0.5))).getBlock()) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			TntActProcedure.execute(world, x, y, z);
		}
	}
}
