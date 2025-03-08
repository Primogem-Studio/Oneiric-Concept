package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.oneiricconcept.network.OneiricconceptModVariables;

public class QueryUIDProcedure {
	public static void execute(Entity entity, Entity playeruid) {
		if (entity == null || playeruid == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(
					Component.literal(
							("\u00A7e" + playeruid.getDisplayName().getString() + "\u00A7r" + Component.translatable("translation.oneiricconcept.uid").getString() + "\u00A7b" + playeruid.getData(OneiricconceptModVariables.PLAYER_VARIABLES).UID)),
					false);
	}
}
