package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;
import net.mcreator.oneiricconcept.OneiricconceptMod;

public class EntrestartfollowProcedure {
	public static void execute(LevelAccessor world, Entity entity, double folrange) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((entity + "\u7B49\u5F85\u56DE\u590D\u6570\u503C")), false);
		}
		OneiricconceptMod.queueServerWork(19, () -> {
			if (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.FOLLOW_RANGE))
				_livingEntity2.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(folrange);
			if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u00A7e" + entity + "\u5DF2\u7ECF\u56DE\u590D\u6570\u503C\u00A7a" + folrange)), false);
			}
		});
	}
}