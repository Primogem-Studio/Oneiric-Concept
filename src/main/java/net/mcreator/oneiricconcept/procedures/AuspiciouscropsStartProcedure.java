package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;

public class AuspiciouscropsStartProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		for (Direction directioniterator : Direction.Plane.HORIZONTAL) {
			AuspiciouscropsProcedure.execute(world, x, y, z, directioniterator, true, 42);
		}
		AuspiciouscropsProcedure.execute(world, x, y, z, Direction.UP, false, 42);
	}
}