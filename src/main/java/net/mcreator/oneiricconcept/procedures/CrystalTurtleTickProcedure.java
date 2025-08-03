package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.entity.Entity;

public class CrystalTurtleTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ShrinkingShellSuoKeProcedure.execute(entity);
		UnShrinkingShellProcedure.execute(entity);
		TurtleCrystalProcedure.execute(entity);
	}
}