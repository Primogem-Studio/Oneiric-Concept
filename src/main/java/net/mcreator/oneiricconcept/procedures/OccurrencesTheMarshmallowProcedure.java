package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.network.OneiricconceptModVariables;

public class OccurrencesTheMarshmallowProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double enx = 0;
		double enz = 0;
		double time = 0;
		enx = entity.getX();
		enz = entity.getZ();
		if (world.canSeeSkyFromBelowWater(BlockPos.containing(enx, entity.getY(), enz))) {
			entity.setDeltaMovement(new Vec3(0, 10, 0));
		} else {
			{
				Entity _ent = entity;
				_ent.teleportTo(enx, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) enx, (int) enz) + 60), enz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(enx, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) enx, (int) enz) + 60), enz, _ent.getYRot(), _ent.getXRot());
			}
		}
		{
			OneiricconceptModVariables.PlayerVariables _vars = entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES);
			_vars.PlayerLife = true;
			_vars.syncPlayerVariables(entity);
		}
		time = world.dayTime();
		while (!entity.onGround() && entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES).PlayerLife) {
			if (entity.onGround() && entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES).PlayerLife) {
				net.mcreator.ceshi.procedures.EventGroupProcedure.execute(world, entity, 1);
			}
		}
	}
}