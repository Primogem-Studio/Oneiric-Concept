package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameRules;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class FallingSunProcedure {
	public static void execute(LevelAccessor world) {
		double daytime = 0;
		daytime = world.dayTime() % 24000;
		if (daytime >= 6000 && daytime <= 17980) {
			if (world instanceof ServerLevel _level)
				_level.setDayTime((int) (world.dayTime() + 10));
			OneiricconceptMod.queueServerWork(5, () -> {
				FallingSunProcedure.execute(world);
			});
		} else if (daytime < 6000 || daytime >= 18020) {
			if (world instanceof ServerLevel _level)
				_level.setDayTime((int) (world.dayTime() - 15));
			OneiricconceptMod.queueServerWork(5, () -> {
				FallingSunProcedure.execute(world);
			});
		} else {
			world.getLevelData().getGameRules().getRule(GameRules.RULE_DAYLIGHT).set(false, world.getServer());
		}
	}
}
