package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.oneiricconcept.init.OneiricconceptModMobEffects;
import net.mcreator.oneiricconcept.OneiricconceptMod;

public class TargetcoolingProcedure {
	public static void execute(LevelAccessor world, Entity entity, double level, double time) {
		if (entity == null)
			return;
		OneiricconceptMod.queueServerWork(1, () -> {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(OneiricconceptModMobEffects.TARGETOFFSET, (int) time, (int) level, false, false));
		});
	}
}
