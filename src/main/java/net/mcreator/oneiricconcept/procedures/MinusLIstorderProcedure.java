package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.oneiricconcept.network.OneiricconceptModVariables;
import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;

public class MinusLIstorderProcedure {
	public static void execute(LevelAccessor world, Entity entity, double max) {
		if (entity == null)
			return;
		double listoder = 0;
		if (!world.isClientSide()) {
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
			if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("" + listoder)), false);
			}
		}
	}
}