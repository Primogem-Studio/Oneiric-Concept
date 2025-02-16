package net.mcreator.oneiricconcept.procedures;

import org.checkerframework.checker.units.qual.min;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class RandomintProcedure {
	public static double execute(LevelAccessor world, double max, double min) {
		double nu = 0;
		if (!world.isClientSide()) {
			nu = Mth.nextInt(RandomSource.create(), (int) min, (int) max);
		}
		return nu;
	}
}
