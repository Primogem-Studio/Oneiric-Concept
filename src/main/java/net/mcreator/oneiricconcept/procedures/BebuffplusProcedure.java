package net.mcreator.oneiricconcept.procedures;

import org.checkerframework.checker.units.qual.C;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class BebuffplusProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double C = 0;
		double timemax = 0;
		double timemin = 0;
		double LVmax = 0;
		C = 0.3;
		timemax = 80;
		timemin = 40;
		LVmax = 4;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 200, (int) RandomintProcedure.execute(world, LVmax, 1)));
		if (RandomProcedure.execute(world, C)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, (int) RandomintProcedure.execute(world, timemax, timemin), (int) RandomintProcedure.execute(world, LVmax, 0)));
		}
		if (RandomProcedure.execute(world, C)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, (int) RandomintProcedure.execute(world, timemax, timemin), (int) RandomintProcedure.execute(world, LVmax, 0)));
		}
		if (RandomProcedure.execute(world, C)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int) RandomintProcedure.execute(world, timemax, timemin), (int) RandomintProcedure.execute(world, LVmax, 0)));
		}
		if (RandomProcedure.execute(world, C)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, (int) RandomintProcedure.execute(world, timemax, timemin), (int) RandomintProcedure.execute(world, LVmax, 0)));
		}
		if (RandomProcedure.execute(world, C)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, (int) RandomintProcedure.execute(world, timemax, timemin), (int) RandomintProcedure.execute(world, LVmax, 0)));
		}
		if (RandomProcedure.execute(world, C)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.UNLUCK, (int) RandomintProcedure.execute(world, timemax, timemin), (int) RandomintProcedure.execute(world, LVmax, 0)));
		}
		if (RandomProcedure.execute(world, C)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, (int) RandomintProcedure.execute(world, timemax, timemin), (int) RandomintProcedure.execute(world, LVmax, 0)));
		}
		if (RandomProcedure.execute(world, C)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (int) RandomintProcedure.execute(world, timemax, timemin), (int) RandomintProcedure.execute(world, LVmax, 0)));
		}
		if (RandomProcedure.execute(world, C)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, (int) RandomintProcedure.execute(world, timemax, timemin), (int) RandomintProcedure.execute(world, LVmax, 0)));
		}
		if (RandomProcedure.execute(world, C)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, (int) RandomintProcedure.execute(world, timemax, timemin), (int) RandomintProcedure.execute(world, LVmax, 0)));
		}
	}
}