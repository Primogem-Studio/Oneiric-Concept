
package net.mcreator.oneiricconcept.potion;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientMobEffectExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.oneiricconcept.procedures.CamoProcedure;
import net.mcreator.oneiricconcept.init.OneiricconceptModMobEffects;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class CamoeffectMobEffect extends MobEffect {
	public CamoeffectMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10066177);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		CamoProcedure.execute(entity.level(), entity);
	}

	@SubscribeEvent
	public static void registerMobEffectExtensions(RegisterClientExtensionsEvent event) {
		event.registerMobEffect(new IClientMobEffectExtensions() {
			@Override
			public boolean isVisibleInGui(MobEffectInstance effect) {
				return false;
			}
		}, OneiricconceptModMobEffects.CAMO.get());
	}
}
