package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class LYProjToItemEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity target) {
		if (target == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SONIC_BOOM, x, y, z, 1, 0, 0, 0, 1);
		target.setDeltaMovement(new Vec3(0, 0, 0));
		target.getPersistentData().putBoolean("sTrident", true);
	}
}