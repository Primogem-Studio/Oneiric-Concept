package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.oneiricconcept.network.OneiricconceptModVariables;

public class BackUIDListorderProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double listoder = 0;
		if (!world.isClientSide()) {
			listoder = entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES).ListOrder;
			if (listoder < OneiricconceptModVariables.MapVariables.get(world).playername.size() - 1) {
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
