package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

public class BananaMushroomboneProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return 1 == Mth.nextInt(RandomSource.create(), 1, 5) && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z));
	}
}
