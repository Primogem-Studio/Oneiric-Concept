package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;

public class OrexpProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ExporbProcedure.execute(world, x, y, z, 4);
	}
}
