package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class SustenanceanchorParticleProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double a = 0;
		double b = 0;
		for (int index0 = 0; index0 < 10; index0++) {
			a = a + 2;
			OneiricconceptMod.queueServerWork((int) a, () -> {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (x + 0.5), (y + 0.45), (z + 0.5), 1, 0.05, 0.05, 0.05, 0.1);
			});
		}
		for (int index1 = 0; index1 < 2; index1++) {
			b = b + 10;
			OneiricconceptMod.queueServerWork((int) b, () -> {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.END_ROD, (x + 0.5), (y - 0.7), (z + 0.5), 1, 0.2, 0.05, 0.2, 0.01);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FIREWORK, (x + 0.5), (y - 0.5), (z + 0.5), 1, 0.2, 0.2, 0.2, 0.01);
			});
		}
	}
}
