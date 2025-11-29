package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
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
		DispellingNegativityProcedure.execute(entity);
	}
}