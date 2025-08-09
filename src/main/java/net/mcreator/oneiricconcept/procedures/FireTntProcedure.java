package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;

public class FireTntProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		TntFireActProcedure.execute(world, x, y, z, x + 1, y + 0, z + 0);
		TntFireActProcedure.execute(world, x, y, z, x + 0, y + 1, z + 0);
		TntFireActProcedure.execute(world, x, y, z, x + 0, y + 0, z + 1);
		TntFireActProcedure.execute(world, x, y, z, x + -1, y + 0, z + 0);
		TntFireActProcedure.execute(world, x, y, z, x + 0, y + -1, z + 0);
		TntFireActProcedure.execute(world, x, y, z, x + 0, y + 0, z + -1);
	}
}
