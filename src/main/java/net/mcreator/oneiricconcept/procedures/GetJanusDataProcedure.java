package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class GetJanusDataProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		BlockState JanusBlock = Blocks.AIR.defaultBlockState();
		return "X:" + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tx") + " Y:" + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "ty") + " Z:" + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "tz");
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}