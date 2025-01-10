package net.mcreator.oneiricconcept.procedures;

import org.checkerframework.checker.units.qual.min;

import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class RandomintProcedure {
	public static double execute(double max, double min) {
		return Mth.nextInt(RandomSource.create(), (int) min, (int) max);
	}
}
