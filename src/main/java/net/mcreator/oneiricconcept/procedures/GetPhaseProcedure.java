package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;

public class GetPhaseProcedure {
	public static double execute(LevelAccessor world) {
		double phase = 0;
		phase = world.dimensionType().moonPhase(world.dayTime());
		if (phase == 4) {
			phase = 0;
		} else if (phase == 3 || phase == 5) {
			phase = 1;
		} else if (phase == 2 || phase == 6) {
			phase = 2;
		} else if (phase == 1 || phase == 7) {
			phase = 3;
		} else if (phase == 0) {
			phase = 4;
		}
		return phase + 1;
	}
}
