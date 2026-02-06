package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.oneiricconcept.network.OneiricconceptModVariables;

public class MinusLIstorderProcedure {
	public static void execute(Entity entity, double max) {
		if (entity == null)
			return;
		double listoder = 0;
		listoder = entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES).ListOrder;
		if (listoder <= 0) {
			{
				OneiricconceptModVariables.PlayerVariables _vars = entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES);
				_vars.ListOrder = max - 1;
				_vars.syncPlayerVariables(entity);
			}
		} else {
			{
				OneiricconceptModVariables.PlayerVariables _vars = entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES);
				_vars.ListOrder = listoder - 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}