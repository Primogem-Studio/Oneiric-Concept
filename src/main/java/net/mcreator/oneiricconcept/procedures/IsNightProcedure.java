package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;

public class IsNightProcedure {
	public static boolean execute(LevelAccessor world) {
		return 13800 <= GetTimeTodayProcedure.execute(world);
	}
}