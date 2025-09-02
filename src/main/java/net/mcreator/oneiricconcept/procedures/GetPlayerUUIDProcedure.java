package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.StringTag;

import net.mcreator.oneiricconcept.network.OneiricconceptModVariables;

public class GetPlayerUUIDProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		return (OneiricconceptModVariables.MapVariables.get(world).PlayerUUID.get((int) entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES).ListOrder)) instanceof StringTag _stringTag ? _stringTag.getAsString() : "";
	}
}