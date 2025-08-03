package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

public class ResurrectionProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.clearFire();
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.BLINDNESS);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.DARKNESS);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.UNLUCK);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.WITHER);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.CONFUSION);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.HUNGER);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.DIG_SLOWDOWN);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.WEAKNESS);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.POISON);
		entity.setAirSupply(100);
		entity.setTicksFrozen(0);
		entity.fallDistance = 0;
		if (entity instanceof LivingEntity _entity)
			_entity.setHealth((float) (0.3 * (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) + (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)));
	}
}