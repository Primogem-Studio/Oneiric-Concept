package net.mcreator.oneiricconcept.potion;

import net.neoforged.neoforge.common.EffectCures;
import net.neoforged.neoforge.common.EffectCure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.oneiricconcept.procedures.BebuffplusProcedure;
import net.mcreator.oneiricconcept.procedures.B2effectProcedure;

import java.util.Set;

public class B2sausageMobEffect extends MobEffect {
	public B2sausageMobEffect() {
		super(MobEffectCategory.HARMFUL, -1);
	}

	@Override
	public void fillEffectCures(Set<EffectCure> cures, MobEffectInstance effectInstance) {
		cures.add(EffectCures.MILK);
		cures.add(EffectCures.PROTECTED_BY_TOTEM);
		cures.add(EffectCures.HONEY);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		BebuffplusProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		B2effectProcedure.execute(entity.level(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}