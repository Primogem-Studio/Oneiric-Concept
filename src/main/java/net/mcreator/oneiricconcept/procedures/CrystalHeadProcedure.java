package net.mcreator.oneiricconcept.procedures;

import org.checkerframework.checker.units.qual.Time;

import net.minecraft.world.entity.Entity;

public class CrystalHeadProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		boolean Time = false;
		double Timenu = 0;
		return TurtleCrystalProcedure.execute(entity) && UnShrinkingShellProcedure.execute(entity);
	}
}
