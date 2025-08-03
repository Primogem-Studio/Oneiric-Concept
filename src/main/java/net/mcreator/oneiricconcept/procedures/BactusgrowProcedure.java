package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class BactusgrowProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return world.isEmptyBlock(BlockPos.containing(x, y, z - 1)) && world.isEmptyBlock(BlockPos.containing(x, y, z + 1)) && world.isEmptyBlock(BlockPos.containing(x - 1, y, z)) && world.isEmptyBlock(BlockPos.containing(x + 1, y, z));
	}
}