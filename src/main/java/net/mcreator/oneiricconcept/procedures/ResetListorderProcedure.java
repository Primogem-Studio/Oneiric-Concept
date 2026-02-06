package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.oneiricconcept.network.OneiricconceptModVariables;

public class ResetListorderProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double listoder = 0;
		{
			OneiricconceptModVariables.PlayerVariables _vars = entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES);
			_vars.ListOrder = 0;
			_vars.syncPlayerVariables(entity);
		}
	}
}