package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;

public class RandomProcedure {
	public static boolean execute(LevelAccessor world, double C11) {
		boolean logc = false;
		if (!world.isClientSide()) {
			logc = Math.random() < C11;
		}
		return logc;
	}
}
