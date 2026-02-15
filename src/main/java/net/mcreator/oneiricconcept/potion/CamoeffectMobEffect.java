package net.mcreator.oneiricconcept.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.oneiricconcept.procedures.CamoProcedure;

public class CamoeffectMobEffect extends MobEffect {
	public CamoeffectMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10066177);
		this.withSoundOnAdded(BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.bucket.empty")));
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		CamoProcedure.execute(entity.level(), entity);
	}
}