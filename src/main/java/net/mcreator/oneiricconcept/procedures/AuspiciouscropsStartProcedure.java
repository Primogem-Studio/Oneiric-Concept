package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;

public class AuspiciouscropsStartProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		AuspiciouscropsProcedure.execute(world, x, y, z, Direction.NORTH, true, 13);
		AuspiciouscropsProcedure.execute(world, x, y, z, Direction.SOUTH, true, 13);
		AuspiciouscropsProcedure.execute(world, x, y, z, Direction.WEST, true, 13);
		AuspiciouscropsProcedure.execute(world, x, y, z, Direction.EAST, true, 13);
		AuspiciouscropsProcedure.execute(world, x, y, z, Direction.UP, false, 13);
	}
}