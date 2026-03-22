package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import net.mcreator.oneiricconcept.network.OneiricconceptModVariables;
import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;
import net.mcreator.oneiricconcept.OneiricconceptMod;

public class PropagandaArmyOrderProcedure {
	public static void execute(LevelAccessor world, Entity entity, boolean is1, double exp, double nu, double sec) {
		if (entity == null)
			return;
		String txt = "";
		String message = "";
		double Nu = 0;
		double NuE = 0;
		if (!world.isClientSide()) {
			txt = "<\u809A\u76AE\u9971\u9971\u5FC3\u60C5\u597D\uFF0C\u770B\u706B\u82B1\u82B1\u770B\u5230\u8001\uFF01><\u4E00\u751F\u53EA\u7231\u706B\u82B1\u82B1\uFF0C\u53D8\u5FC3\u4E00\u5B9A\u906D\u96F7\u5288\uFF01><\u706B\u82B1\u82B1\uFF01\u706B\u82B1\u82B1\uFF01><\u706B\u82B1\u82B1\u597D\u597D\u597D><\u72C2\u6B22\u76F4\u5230\u4E16\u754C\u5C3D\u5934\uFF01>";
			Nu = nu;
			if (is1) {
				{
					OneiricconceptModVariables.PlayerVariables _vars = entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES);
					_vars.OrderNu = 0;
					_vars.markSyncDirty();
				}
			}
			NuE = entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES).OrderNu;
			if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
				if (world instanceof ServerLevel _level) {
					_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal((NuE + "/Nu" + Nu + "/Sec" + sec + "/is1" + is1)), false);
				}
			}
			if (0 < sec) {
				if (Nu < NuE) {
					Nu = NuE;
					if (world instanceof ServerLevel _level) {
						_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("/Nu" + Nu)), false);
					}
					message = txt.substring((int) txt.indexOf("<") + "<".length(), (int) txt.indexOf(">"));
					{
						OneiricconceptModVariables.PlayerVariables _vars = entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES);
						_vars.orderMassage = message;
						_vars.markSyncDirty();
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(message), false);
					OneiricconceptMod.queueServerWork(20, () -> {
						PropagandaArmyOrderProcedure.execute(world, entity, false, exp, nu + 1, sec - 1);
					});
				} else {
					OneiricconceptMod.queueServerWork(20, () -> {
						PropagandaArmyOrderProcedure.execute(world, entity, false, exp, nu, sec - 1);
					});
				}
			} else {
				if (entity instanceof Player _player)
					_player.giveExperiencePoints((int) (NuE * exp));
			}
		}
	}
}