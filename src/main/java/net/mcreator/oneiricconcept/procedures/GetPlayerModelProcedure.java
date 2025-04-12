package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import java.util.UUID;

public class GetPlayerModelProcedure {
	public static Entity execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return null;
		String UUID = "";
		UUID = GetPlayerUUIDProcedure.execute(world, entity);
		if (isStringUUIDValid(UUID)) {
			return entityFromStringUUID(UUID, (Level) world);
		}
		return world instanceof Level _level ? new Creeper(EntityType.CREEPER, _level) : null;
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
