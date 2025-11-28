package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.oneiricconcept.network.OneiricconceptModVariables;
import net.mcreator.oneiricconcept.OneiricconceptMod;

public class OccurrencesTheMarshmallowIterationProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.onGround() && entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES).PlayerLife) {
			net.mcreator.ceshi.procedures.EventGroupProcedure.execute(world, entity, 1);
		} else if (!entity.onGround() && entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES).PlayerLife) {
			OneiricconceptMod.queueServerWork(2, () -> {
				OccurrencesTheMarshmallowIterationProcedure.execute(world, entity);
			});
		}
	}
}