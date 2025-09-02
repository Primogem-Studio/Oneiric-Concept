package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class TestDeleteProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FALLING_ANVIL)), 2147483647);
		if (entity instanceof LivingEntity _entity)
			_entity.setHealth(0);
		entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("oneiricconcept:b_2")))), 2147483647);
		if (!entity.level().isClientSide())
			entity.discard();
		{
			Entity _ent = entity;
			_ent.teleportTo(x, (-66), z);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(x, (-66), z, _ent.getYRot(), _ent.getXRot());
		}
		OneiricconceptMod.LOGGER.warn((sourceentity + "\u5728x:" + x + "y:" + y + "z:" + z + "\u79FB\u9664\u4E86" + entity));
	}
}