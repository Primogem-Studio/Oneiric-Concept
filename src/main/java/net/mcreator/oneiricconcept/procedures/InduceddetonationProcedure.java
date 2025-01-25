package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;

public class InduceddetonationProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		OverlimitExplosionProcedure.execute(world, x, y, z, 3);
	}
}
