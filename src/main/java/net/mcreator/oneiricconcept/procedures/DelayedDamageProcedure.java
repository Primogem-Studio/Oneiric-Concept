package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class DelayedDamageProcedure {
	public static void execute(LevelAccessor world, DamageSource damagetype, Entity Damageentity, double damagee, double timee) {
		if (damagetype == null || Damageentity == null)
			return;
		OneiricconceptMod.queueServerWork((int) timee, () -> {
			Damageentity.hurt(damagetype, (float) damagee);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SWEEP_ATTACK, (Damageentity.getX()), (Damageentity.getY() + 1), (Damageentity.getZ()), 3, 0.1, 0.1, 0.1, 0.1);
		});
	}
}