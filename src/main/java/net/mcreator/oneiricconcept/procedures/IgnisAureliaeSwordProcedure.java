package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.entity.Entity;

public class IgnisAureliaeSwordProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		MaraStruckClearProcedure.execute(entity);
	}
}