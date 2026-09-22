package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

public class JanusHiddenPassageProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState JanusBlock = Blocks.AIR.defaultBlockState();
		double stx = 0;
		double stz = 0;
		stx = getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tx");
		stz = getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tz");
		{
			Entity _ent = entity;
			_ent.teleportTo(Mth.clamp((stx + Math.min(1, Math.max(stx - x, -1))), (x - 160), (x + 160)), (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ty")), Mth.clamp((stz + Math.min(1, Math.max(stz - z, -1))), (z - 160), (z + 160)));
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(Mth.clamp((stx + Math.min(1, Math.max(stx - x, -1))), (x - 160), (x + 160)), (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ty")),
						Mth.clamp((stz + Math.min(1, Math.max(stz - z, -1))), (z - 160), (z + 160)), _ent.getYRot(), _ent.getXRot());
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}