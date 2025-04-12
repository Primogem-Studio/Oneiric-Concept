package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.StringTag;

import net.mcreator.oneiricconcept.network.OneiricconceptModVariables;

import java.util.UUID;

public class GetPlayerNameProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		String UUID = "";
		String name = "";
		UUID = GetPlayerUUIDProcedure.execute(world, entity);
		name = (OneiricconceptModVariables.MapVariables.get(world).playername.get((int) entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES).ListOrder)) instanceof StringTag _stringTag ? _stringTag.getAsString() : "";
		if (isStringUUIDValid(UUID)) {
			name = name + "\uFF08" + entityFromStringUUID(UUID, (Level) world).getDisplayName().getString() + "\uFF09";
		}
		return name;
	}

	public static boolean isStringUUIDValid(String uuid) {
		boolean valid;
		try {
			UUID.fromString(uuid);
			valid = true;
		} catch (Exception e) {
			valid = false;
		}
		return valid;
	}

	public static Entity entityFromStringUUID(String uuid, Level world) {
		Entity _uuidentity = null;
		if (world instanceof ServerLevel _server) {
			try {
				_uuidentity = _server.getEntity(UUID.fromString(uuid));
			} catch (Exception e) {
			}
		}
		return _uuidentity;
	}
}
