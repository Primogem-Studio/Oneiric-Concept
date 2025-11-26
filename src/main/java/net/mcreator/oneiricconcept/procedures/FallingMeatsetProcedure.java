package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;

public class FallingMeatsetProcedure {
	public static void execute(LevelAccessor world, boolean zhi) {
		world.getLevelData().getGameRules().getRule(OneiricconceptModGameRules.FALLING_MEAT).set(zhi, world.getServer());
	}
}