package net.mcreator.oneiricconcept.procedures;

import net.neoforged.fml.ModList;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class LaserhurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity tgt, double dmg) {
		if (entity == null || tgt == null)
			return;
		Entity target = null;
		double dx = 0;
		double dy = 0;
		double dz = 0;
		double total_distance = 0;
		double steps = 0;
		double ratio = 0;
		double x2 = 0;
		double y2 = 0;
		double z2 = 0;
		double x1 = 0;
		double y1 = 0;
		double z1 = 0;
		boolean isGc = false;
		target = tgt;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.FLASH, x, y, z, 1, 0, 0, 0, 0);
		x2 = target.getX();
		y2 = target.getY() + target.getBbHeight() / 2;
		z2 = target.getZ();
		dx = x2 - x;
		dy = y2 - y;
		dz = z2 - z;
		total_distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
		steps = total_distance / 0.1;
		for (int index0 = 0; index0 < (int) steps; index0++) {
			ratio = (index0 * 0.1) / total_distance;
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.WAX_OFF, (x + ratio * dx), (y + ratio * dy), (z + ratio * dz), 1, 0, 0, 0, 0);
		}
		isGc = ModList.get().isLoaded("genshincraft");
		target.hurt(TypeDamageProcedure.execute(new DamageSource(world.holderOrThrow(DamageTypes.FALLING_ANVIL), entity), false, true, false, 1), (float) dmg);
	}
}