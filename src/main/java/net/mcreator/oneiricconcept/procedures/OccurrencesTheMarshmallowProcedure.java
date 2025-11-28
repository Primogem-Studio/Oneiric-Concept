package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class OccurrencesTheMarshmallowProcedure {
	public static void execute(LevelAccessor world, Entity entity, double Life) {
		if (entity == null)
			return;
		double enx = 0;
		double enz = 0;
		enx = entity.getX();
		enz = entity.getZ();
		if (world.canSeeSkyFromBelowWater(BlockPos.containing(enx, entity.getY(), enz))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, (int) (Life * 90), 50, false, false));
		} else {
			{
				Entity _ent = entity;
				_ent.teleportTo(enx, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) enx, (int) enz) + Life * 60), enz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(enx, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) enx, (int) enz) + Life * 60), enz, _ent.getYRot(), _ent.getXRot());
			}
		}
		entity.getPersistentData().putDouble("PlayerLife", Life);
		OneiricconceptMod.queueServerWork(5, () -> {
			OccurrencesTheMarshmallowIterationProcedure.execute(world, entity);
		});
	}
}