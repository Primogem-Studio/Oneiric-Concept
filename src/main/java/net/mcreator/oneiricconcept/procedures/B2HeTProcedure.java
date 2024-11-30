package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class B2HeTProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 200, 0, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 0, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 100, 0, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 200, 0, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 200, 0, false, false));
		OneiricconceptMod.queueServerWork(20, () -> {
			entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("oneiricconcept:b_2")))), 2);
			OneiricconceptMod.queueServerWork(20, () -> {
				entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("oneiricconcept:b_2")))), 2);
				OneiricconceptMod.queueServerWork(20, () -> {
					entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("oneiricconcept:b_2")))), 2);
					OneiricconceptMod.queueServerWork(20, () -> {
						entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("oneiricconcept:b_2")))), 2);
						OneiricconceptMod.queueServerWork(20, () -> {
							entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("oneiricconcept:b_2")))), 2);
							OneiricconceptMod.queueServerWork(20, () -> {
								entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("oneiricconcept:b_2")))), 2);
								OneiricconceptMod.queueServerWork(20, () -> {
									entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("oneiricconcept:b_2")))), 2);
									OneiricconceptMod.queueServerWork(20, () -> {
										entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("oneiricconcept:b_2")))), 2);
										OneiricconceptMod.queueServerWork(20, () -> {
											entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("oneiricconcept:b_2")))), 2);
											OneiricconceptMod.queueServerWork(20, () -> {
												entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("oneiricconcept:b_2")))), 2);
												OneiricconceptMod.queueServerWork(20, () -> {
													entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("oneiricconcept:b_2")))), 2);
													OneiricconceptMod.queueServerWork(20, () -> {
														entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("oneiricconcept:b_2")))), 2);
													});
												});
											});
										});
									});
								});
							});
						});
					});
				});
			});
		});
	}
}
