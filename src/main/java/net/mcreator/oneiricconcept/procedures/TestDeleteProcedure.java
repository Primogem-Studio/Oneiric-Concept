package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;

public class TestDeleteProcedure {
	public static void execute(LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return;
		entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.FALLING_ANVIL)), 2147483647);
		if (entity instanceof LivingEntity _entity)
			_entity.setHealth(0);
		if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
			_livingEntity3.getAttribute(Attributes.MAX_HEALTH).setBaseValue(0);
		if (!entity.level().isClientSide())
			entity.discard();
		{
			Entity _ent = entity;
			_ent.teleportTo(x, (-66), z);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(x, (-66), z, _ent.getYRot(), _ent.getXRot());
		}
	}
}
