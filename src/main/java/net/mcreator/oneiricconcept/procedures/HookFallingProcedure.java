package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;
import net.mcreator.oneiricconcept.OneiricconceptMod;

import java.util.Calendar;

public class HookFallingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity HookEntity, Entity entity, double EnchantLevel, double LoadingTime) {
		if (HookEntity == null || entity == null)
			return;
		Entity hookent = null;
		hookent = HookEntity;
		if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u94A9\u5B50\u4E0B\u843D" + Calendar.getInstance().getTime().toString())), false);
		}
		var hook = (FishingHook) hookent;
		if (hook.getHookedIn() != null || hookent.isInWaterOrBubble() || hookent.isInWall() || hookent.onGround()) {
			if (hook.getHookedIn() != null) {
				HookHitProcedure.execute(world, x, y, z, hook.getOwner(), entity, EnchantLevel);
				if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A74\u8C03\u7528\u4F24\u5BB3\uFF0C\u76EE\u6807\uFF1A" + hook.getOwner() + Calendar.getInstance().getTime().toString())), false);
				}
			}
		} else {
			if (LoadingTime <= 10) {
				OneiricconceptMod.queueServerWork(20, () -> {
					HookFallingProcedure.execute(world, x, y, z, HookEntity, entity, EnchantLevel, LoadingTime + 1);
				});
			} else {
				if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u4E0B\u843D\u8D85\u65F6" + Calendar.getInstance().getTime().toString())), false);
				}
			}
		}
	}
}
