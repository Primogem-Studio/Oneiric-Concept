package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;

public class GetwetherProcedure {
	public static double execute(LevelAccessor world) {
		if (world.getLevelData().isThundering()) {
			return 15;
		} else if (world.getLevelData().isRaining()) {
			return 7;
		}
		return 0;
	}
}
