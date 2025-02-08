package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.network.chat.Component;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;
import net.mcreator.oneiricconcept.OneiricconceptMod;

import java.util.Calendar;

public class HookHitProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity TargetEntity, Entity entity, double EnchantLevel) {
		if (TargetEntity == null || entity == null)
			return;
		Entity Damageent = null;
		Damageent = TargetEntity;
		if ((Damageent.getType().is(EntityTypeTags.UNDEAD) || Damageent.getType().is(EntityTypeTags.AQUATIC)) && Damageent.isInWaterOrBubble()) {
			if (Damageent.isAlive()) {
				Damageent.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK), entity), (float) (5 * (world.getLevelData().getGameRules().getInt(OneiricconceptModGameRules.OC_HEALTHMULTIPLIER)) * EnchantLevel));
				OneiricconceptMod.queueServerWork(20, () -> {
					HookHitProcedure.execute(world, x, y, z, TargetEntity, entity, EnchantLevel);
				});
				if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u94A9\u5B50\u4F24\u5BB3" + Calendar.getInstance().getTime().toString())), false);
				}
			} else {
				if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u5B9E\u4F53\u6CA1\u6D3B\u7740" + Calendar.getInstance().getTime().toString())), false);
				}
			}
		} else {
			if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((Calendar.getInstance().getTime().toString() + "\u5B9E\u4F53\u7C7B\u578B\u4E3A\u6C34\uFF1A" + Damageent.getType().is(EntityTypeTags.AQUATIC)
							+ "\u5B9E\u4F53\u7C7B\u578B\u4E3A\u4EA1\u7075\uFF1A" + Damageent.getType().is(EntityTypeTags.UNDEAD) + "\u5728\u6C34\u4E2D\uFF1A" + Damageent.isInWaterOrBubble())), false);
			}
		}
	}
}
