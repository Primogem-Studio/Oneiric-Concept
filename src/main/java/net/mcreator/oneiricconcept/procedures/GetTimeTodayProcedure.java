package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;

public class GetTimeTodayProcedure {
	public static double execute(LevelAccessor world) {
		return world.dayTime() % 24000;
	}
}