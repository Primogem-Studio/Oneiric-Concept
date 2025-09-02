package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;

public class IfTime5Procedure {
	public static boolean execute(LevelAccessor world) {
		return world.getLevelData().getGameTime() % 10 < 4;
	}
}