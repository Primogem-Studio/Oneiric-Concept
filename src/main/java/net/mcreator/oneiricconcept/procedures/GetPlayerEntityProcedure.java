package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import java.util.ArrayList;

public class GetPlayerEntityProcedure {
	public static Entity execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return null;
		Entity ent = null;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if ((entityiterator.getStringUUID()).equals(GetPlayerUUIDProcedure.execute(world, entity))) {
				ent = entityiterator;
			}
		}
		return ent;
	}
}