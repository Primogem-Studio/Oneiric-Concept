package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class HealthLoseTickProcedure {
	public static void execute(LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 200));
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 200 + 1) {
			if (!entity.level().isClientSide())
				entity.discard();
			OneiricconceptMod.queueServerWork(1, () -> {
				BlockClearStartProcedure.execute(world, x, z);
			});
		}
	}
}
