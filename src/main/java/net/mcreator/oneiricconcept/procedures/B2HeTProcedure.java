package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.oneiricconcept.init.OneiricconceptModMobEffects;

public class B2HeTProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(OneiricconceptModMobEffects.B_2SAUSAGE, 200, 2, false, false));
	}
}