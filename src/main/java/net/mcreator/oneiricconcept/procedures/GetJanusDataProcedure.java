package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class GetJanusDataProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		BlockState JanusBlock = Blocks.AIR.defaultBlockState();
		JanusBlock = (world.getFluidState(BlockPos.containing(x, y, z)).createLegacyBlock());
		return "X:" + (JanusBlock.getBlock().getStateDefinition().getProperty("tx") instanceof IntegerProperty _getip1 ? JanusBlock.getValue(_getip1) : -1) + " Y:"
				+ (JanusBlock.getBlock().getStateDefinition().getProperty("ty") instanceof IntegerProperty _getip2 ? JanusBlock.getValue(_getip2) : -1) + " Z:"
				+ (JanusBlock.getBlock().getStateDefinition().getProperty("tz") instanceof IntegerProperty _getip3 ? JanusBlock.getValue(_getip3) : -1);
	}
}