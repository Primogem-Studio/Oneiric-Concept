package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class ExamplexsProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean o = false;
		Entity e = null;
		o = world.getLevelData().isRaining();
		e = entity;
		net.mcreator.ceshi.procedures.EventGroupProcedure.execute(world, entity, (int) (1001));
	}
}