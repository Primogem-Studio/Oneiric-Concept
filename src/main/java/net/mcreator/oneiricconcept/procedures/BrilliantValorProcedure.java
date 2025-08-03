package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;

public class BrilliantValorProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level) {
			new ItemStack(OneiricconceptModItems.SWORD_OF_BRILLIANT_VALOR.get()).hurtAndBreak(30, _level, null, _stkprov -> {
			});
		}
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(OneiricconceptModItems.SWORD_OF_BRILLIANT_VALOR.get(), 1200);
		entity.fallDistance = 0;
		entity.clearFire();
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.BLINDNESS);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.DARKNESS);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.UNLUCK);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.WITHER);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.CONFUSION);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.HUNGER);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.DIG_SLOWDOWN);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.WEAKNESS);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.POISON);
		entity.setAirSupply(20);
		entity.setTicksFrozen(0);
	}
}