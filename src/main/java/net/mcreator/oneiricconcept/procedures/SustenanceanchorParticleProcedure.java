package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class SustenanceanchorParticleProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double a = 0;
		double on = 0;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.TOTEM_OF_UNDYING, (x + 0.5), y, (z + 0.5), 2, 0.05, 0.05, 0.05, 0.01);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.END_ROD, (x + 0.5), (y - 0.5), (z + 0.5), 2, 0.2, 0.2, 0.2, 0.01);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.WAX_OFF, (x + 0.5), (y - 0.5), (z + 0.5), 2, 0.2, 0.2, 0.2, 0.01);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.FIREWORK, (x + 0.5), (y - 0.5), (z + 0.5), 2, 0.2, 0.2, 0.2, 0.01);
	}
}
