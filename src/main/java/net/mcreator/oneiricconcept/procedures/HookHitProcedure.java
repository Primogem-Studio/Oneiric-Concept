package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;
import net.mcreator.oneiricconcept.OneiricconceptMod;

import java.util.Calendar;

public class HookHitProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity HookEntity, Entity TargetEntity, Entity entity, double EnchantLevel, double LoadingTime) {
		if (HookEntity == null || TargetEntity == null || entity == null)
			return;
		Entity Damageent = null;
		Damageent = TargetEntity;
		if (Damageent.isInWaterOrBubble()) {
			if (Damageent instanceof ItemEntity) {
				{
					Entity _ent = Damageent;
					_ent.teleportTo((entity.getX()), (entity.getY()), (entity.getZ()));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((entity.getX()), (entity.getY()), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
				}
				if (!HookEntity.level().isClientSide())
					HookEntity.discard();
			} else {
				if ((Damageent.getType().is(EntityTypeTags.UNDEAD) || Damageent.getType().is(EntityTypeTags.AQUATIC)) && Damageent.isAlive()) {
					if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
						if (!world.isClientSide() && world.getServer() != null)
							world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u94A9\u5B50\u4F24\u5BB3" + Calendar.getInstance().getTime().toString())), false);
					}
					Damageent.hurt(new DamageSource(world.holderOrThrow(DamageTypes.PLAYER_ATTACK), entity), (float) (5 * (world.getLevelData().getGameRules().getInt(OneiricconceptModGameRules.OC_HEALTHMULTIPLIER)) * EnchantLevel));
					if (LoadingTime <= 10) {
						OneiricconceptMod.queueServerWork(20, () -> {
							HookHitProcedure.execute(world, x, y, z, HookEntity, TargetEntity, entity, EnchantLevel, LoadingTime + 1);
						});
					}
				}
			}
		}
	}
}