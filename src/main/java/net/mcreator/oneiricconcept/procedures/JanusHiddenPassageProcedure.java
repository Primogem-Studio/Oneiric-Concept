package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

public class JanusHiddenPassageProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState JanusBlock = Blocks.AIR.defaultBlockState();
		double stx = 0;
		double stz = 0;
		JanusBlock = (world.getBlockState(BlockPos.containing(x, y, z)));
		stx = JanusBlock.getBlock().getStateDefinition().getProperty("tx") instanceof IntegerProperty _getip1 ? JanusBlock.getValue(_getip1) : -1;
		stz = JanusBlock.getBlock().getStateDefinition().getProperty("tz") instanceof IntegerProperty _getip2 ? JanusBlock.getValue(_getip2) : -1;
		{
			Entity _ent = entity;
			_ent.teleportTo((stx + Math.min(1, Math.max(stx - x, -1))), (JanusBlock.getBlock().getStateDefinition().getProperty("ty") instanceof IntegerProperty _getip4 ? JanusBlock.getValue(_getip4) : -1),
					(stz + Math.min(1, Math.max(stz - z, -1))));
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport((stx + Math.min(1, Math.max(stx - x, -1))), (JanusBlock.getBlock().getStateDefinition().getProperty("ty") instanceof IntegerProperty _getip4 ? JanusBlock.getValue(_getip4) : -1),
						(stz + Math.min(1, Math.max(stz - z, -1))), _ent.getYRot(), _ent.getXRot());
		}
	}
}