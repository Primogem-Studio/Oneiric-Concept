package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.oneiricconcept.init.OneiricconceptModMobEffects;
import net.mcreator.oneiricconcept.init.OneiricconceptModItems;

public class SpeedJumpProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		String txt = "";
		double maxlevel = 0;
		double speedlvl = 0;
		maxlevel = 4;
		if (itemstack.getItem() == OneiricconceptModItems.ENERGY_DRINK_PRIMOGEM.get()) {
			maxlevel = 12;
		} else if (itemstack.getItem() == OneiricconceptModItems.ENERGY_DRINK_SUGAR_FREE.get()) {
			maxlevel = 6;
		} else if (itemstack.getItem() == OneiricconceptModItems.PUNITIVE_ENERGY.get()) {
			entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("oneiricconcept:b_2")))), (float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.15));
		}
		speedlvl = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(OneiricconceptModMobEffects.ENERGY) ? _livEnt.getEffect(OneiricconceptModMobEffects.ENERGY).getAmplifier() : 0;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(OneiricconceptModMobEffects.ENERGY,
					(int) (1200 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(OneiricconceptModMobEffects.ENERGY) ? _livEnt.getEffect(OneiricconceptModMobEffects.ENERGY).getDuration() : 0)),
					(int) Math.min(maxlevel, (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(OneiricconceptModMobEffects.ENERGY) ? _livEnt.getEffect(OneiricconceptModMobEffects.ENERGY).getAmplifier() : 0) + 1)));
		if ((entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(Attributes.FALL_DAMAGE_MULTIPLIER) ? _livingEntity13.getAttribute(Attributes.FALL_DAMAGE_MULTIPLIER).getValue() : 0) <= 0) {
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("oneiricconcept:fall_king"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		txt = Component.translatable("translation.oneiricconcept.effectlevel").getString() + ""
				+ ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(OneiricconceptModMobEffects.ENERGY) ? _livEnt.getEffect(OneiricconceptModMobEffects.ENERGY).getAmplifier() : 0) + 1);
		if (speedlvl >= maxlevel) {
			txt = txt + "\u00A7c\uFF08" + Component.translatable("translation.oneiricconcept.effectlevelmax").getString() + "\uFF09";
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(txt), true);
	}
}
