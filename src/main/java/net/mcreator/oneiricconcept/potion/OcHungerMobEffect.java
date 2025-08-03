package net.mcreator.oneiricconcept.potion;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientMobEffectExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.oneiricconcept.procedures.HungereffectProcedure;
import net.mcreator.oneiricconcept.init.OneiricconceptModMobEffects;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class OcHungerMobEffect extends MobEffect {
	public OcHungerMobEffect() {
		super(MobEffectCategory.NEUTRAL, -256);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		HungereffectProcedure.execute(entity);
		return super.applyEffectTick(entity, amplifier);
	}

	@SubscribeEvent
	public static void registerMobEffectExtensions(RegisterClientExtensionsEvent event) {
		event.registerMobEffect(new IClientMobEffectExtensions() {
			@Override
			public boolean isVisibleInGui(MobEffectInstance effect) {
				return false;
			}
		}, OneiricconceptModMobEffects.OC_HUNGER.get());
	}
}