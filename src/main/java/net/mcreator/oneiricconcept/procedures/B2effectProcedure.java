package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.oneiricconcept.init.OneiricconceptModMobEffects;
import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;

public class B2effectProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("oneiricconcept:b_2")))),
				(float) (((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(OneiricconceptModMobEffects.B_2SAUSAGE) ? _livEnt.getEffect(OneiricconceptModMobEffects.B_2SAUSAGE).getAmplifier() : 0) + 1)
						* (world.getLevelData().getGameRules().getInt(OneiricconceptModGameRules.OC_HEALTHMULTIPLIER)) * 0.8));
	}
}