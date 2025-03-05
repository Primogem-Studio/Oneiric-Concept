package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.oneiricconcept.network.OneiricconceptModVariables;

public class EightCharactersofBirthBackProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal((Component.translatable("translation.oneiricconcept.eight").getString() + "" + entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES).EightCharactersofBirth)), false);
	}
}
