package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;

public class TntPlaceProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Direction direction) {
		if (direction == null)
			return false;
		TntActProcedure.execute(world, x + direction.getStepX(), y + direction.getStepY(), z + direction.getStepZ());
		return true;
	}
}
