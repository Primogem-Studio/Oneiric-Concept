package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;

public class SupportupProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return SupportProcedure.execute(world, x, y, z, Direction.UP, x, y + 1, z);
	}
}