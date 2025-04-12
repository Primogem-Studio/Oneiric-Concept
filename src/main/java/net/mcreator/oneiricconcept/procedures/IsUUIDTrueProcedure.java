package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import java.util.UUID;

public class IsUUIDTrueProcedure {
	public static boolean execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return false;
		String UUID = "";
		String name = "";
		return isStringUUIDValid(GetPlayerUUIDProcedure.execute(world, entity));
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
}
