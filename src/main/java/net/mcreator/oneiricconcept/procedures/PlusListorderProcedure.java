package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.oneiricconcept.network.OneiricconceptModVariables;

public class PlusListorderProcedure {
	public static void execute(LevelAccessor world, Entity entity, double max) {
		if (entity == null)
			return;
		double listoder = 0;
		if (!world.isClientSide()) {
			listoder = entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES).ListOrder;
			if (listoder < max - 1) {
				{
					OneiricconceptModVariables.PlayerVariables _vars = entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES);
					_vars.ListOrder = listoder + 1;
					_vars.syncPlayerVariables(entity);
				}
			} else {
				{
					OneiricconceptModVariables.PlayerVariables _vars = entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES);
					_vars.ListOrder = 0;
					_vars.syncPlayerVariables(entity);
				}
			}
		}
	}
}