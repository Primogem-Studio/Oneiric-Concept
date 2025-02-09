package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class SweetFlowerclimateProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return 0 < world.getBiome(BlockPos.containing(x, y, z)).value().getBaseTemperature() * 100f;
	}
}
