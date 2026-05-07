package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;

public class IsBoomBlossomsGenerateProcedure {
	public static boolean execute(LevelAccessor world) {
		return 0 < (world.getLevelData().getGameRules().getInt(OneiricconceptModGameRules.OC_BOOMBLOSSOMS));
	}
}