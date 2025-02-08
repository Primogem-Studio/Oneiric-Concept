package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;
import net.mcreator.oneiricconcept.OneiricconceptMod;

import java.util.Calendar;

public class HookFallingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity HookEntity, Entity entity, double EnchantLevel) {
		if (HookEntity == null || entity == null)
			return;
		Entity hookent = null;
		hookent = HookEntity;
		if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u94A9\u5B50\u4E0B\u843D" + Calendar.getInstance().getTime().toString())), false);
			OneiricconceptMod.LOGGER.debug(("\u94A9\u5B50\u4E0B\u843D" + Calendar.getInstance().getTime().toString()));
		}
		if (hook.getHookedIn() || hookent.isInWaterOrBubble() || hookent.isInWall() || hookent.onGround()) {
			if (hookent.isPassenger()) {
				HookHitProcedure.execute(world, x, y, z, hook.getOwner(), entity, EnchantLevel);
			}
		} else {
			OneiricconceptMod.queueServerWork(20, () -> {
				HookFallingProcedure.execute(world, x, y, z, HookEntity, entity, EnchantLevel);
			});
		}
	}
}
