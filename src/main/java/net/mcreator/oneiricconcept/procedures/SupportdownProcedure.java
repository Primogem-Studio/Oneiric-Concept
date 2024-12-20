package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;

public class SupportdownProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		SupportProcedure.execute(world, x, y, z, Direction.DOWN);
	}
}
