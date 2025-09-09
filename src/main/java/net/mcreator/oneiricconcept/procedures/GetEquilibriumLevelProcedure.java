package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.oneiricconcept.network.OneiricconceptModVariables;

public class GetEquilibriumLevelProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			OneiricconceptModVariables.PlayerVariables _vars = entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES);
			_vars.ListOrder = JunHengDengJiProcedure.execute(entity) / 5 - 1;
			_vars.syncPlayerVariables(entity);
		}
	}
}