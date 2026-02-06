package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.network.OneiricconceptModVariables;

public class GetLantarnBackGrandProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return 0;
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "edited")) {
			return getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BG");
		}
		return entity.getData(OneiricconceptModVariables.PLAYER_VARIABLES).ListOrder;
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}