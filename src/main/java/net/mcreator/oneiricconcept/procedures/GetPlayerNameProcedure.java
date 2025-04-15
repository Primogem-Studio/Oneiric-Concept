package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.StringTag;

import net.mcreator.oneiricconcept.network.OneiricconceptModVariables;

public class GetPlayerNameProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		String name = "";
		Entity ent = null;
		name = (OneiricconceptModVariables.MapVariables.get(world).playername.get((int) entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES).ListOrder)) instanceof StringTag _stringTag ? _stringTag.getAsString() : "";
		ent = GetPlayerEntityProcedure.execute(world, entity);
		if (!(ent == null)) {
			name = name + "\uFF08" + ent.getDisplayName().getString() + "\uFF09";
		} else {
			name = name + "\uFF08" + Component.translatable("gui.oneiricconcept.lib_gui.label_player_not_connected").getString() + "\uFF09";
		}
		return name;
	}
}
