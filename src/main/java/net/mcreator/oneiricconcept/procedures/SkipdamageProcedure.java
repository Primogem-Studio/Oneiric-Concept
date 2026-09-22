package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;
import net.mcreator.oneiricconcept.OneiricconceptMod;

public class SkipdamageProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack, boolean db, double indexx) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG) && db) {
			if (world instanceof ServerLevel _level) {
				_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u63A5\u6536\u5230\u8DF3\u8FC7\u503C" + indexx)), false);
			}
		}
		if (0 < indexx) {
			if (0 < (entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0)) {
				if (entity instanceof Player _player)
					_player.getFoodData().setSaturation((float) ((entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) - 1));
			} else if (0 < (entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0)) {
				if (entity instanceof Player _player)
					_player.getFoodData().setFoodLevel((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - 1);
			} else if (entity.isAlive()) {
			}
			OneiricconceptMod.queueServerWork(1, () -> {
				SkipdamageProcedure.execute(world, entity, itemstack, false, indexx - 1);
			});
		} else {
		}
	}
}