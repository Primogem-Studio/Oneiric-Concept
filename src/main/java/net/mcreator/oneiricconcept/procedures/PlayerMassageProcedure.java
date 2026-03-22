package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.event.ServerChatEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import net.mcreator.oneiricconcept.network.OneiricconceptModVariables;
import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlayerMassageProcedure {
	@SubscribeEvent
	public static void onChat(ServerChatEvent event) {
		execute(event, event.getPlayer().level(), event.getPlayer(), event.getRawText());
	}

	public static void execute(LevelAccessor world, Entity entity, String text) {
		execute(null, world, entity, text);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, String text) {
		if (entity == null || text == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
			if (world instanceof ServerLevel _level) {
				_level.getServer().getPlayerList().broadcastSystemMessage(
						Component.literal((text + "=" + entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES).orderMassage + (text).equals(entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES).orderMassage))).withColor(0xffff00), false);
			}
		}
		if ((text).equals(entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES).orderMassage)) {
			{
				OneiricconceptModVariables.PlayerVariables _vars = entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES);
				_vars.OrderNu = entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES).OrderNu + 1;
				_vars.markSyncDirty();
			}
		}
	}
}