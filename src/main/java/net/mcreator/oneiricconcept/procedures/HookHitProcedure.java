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
					OneiricconceptMod.LOGGER.debug(("\u94A9\u5B50\u4F24\u5BB3" + Calendar.getInstance().getTime().toString()));
					if (!world.isClientSide() && world.getServer() != null)
						world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u94A9\u5B50\u4F24\u5BB3" + Calendar.getInstance().getTime().toString())), false);
				}
			}
		}
	}
}
