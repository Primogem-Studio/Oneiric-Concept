package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.StringTag;

import net.mcreator.oneiricconcept.network.OneiricconceptModVariables;

public class QueryUIDProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(
					("\u00A7e" + ((OneiricconceptModVariables.MapVariables.get(world).playername.get((int) entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES).ListOrder)) instanceof StringTag _stringTag ? _stringTag.getAsString() : "")
							+ "\u00A7r" + Component.translatable("translation.oneiricconcept.uid").getString() + "\u00A7b"
							+ ((OneiricconceptModVariables.MapVariables.get(world).playerUID.get((int) entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES).ListOrder)) instanceof StringTag _stringTag ? _stringTag.getAsString() : ""))),
					false);
	}
}