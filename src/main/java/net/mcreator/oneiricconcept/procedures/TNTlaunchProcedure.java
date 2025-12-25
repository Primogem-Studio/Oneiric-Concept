package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class TNTlaunchProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		double xx = 0;
		double yy = 0;
		double zz = 0;
		xx = (getDirectionFromBlockState(blockstate)).getStepX() + x;
		yy = (getDirectionFromBlockState(blockstate)).getStepY() + y;
		zz = (getDirectionFromBlockState(blockstate)).getStepZ() + z;
		if (!world.getBlockState(BlockPos.containing(xx, yy, zz)).canOcclude()) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = EntityType.TNT.spawn(_level, BlockPos.containing(xx, yy, zz), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
		}
	}

	private static Direction getDirectionFromBlockState(BlockState blockState) {
		Property<?> prop = blockState.getBlock().getStateDefinition().getProperty("facing");
		if (prop instanceof DirectionProperty dp)
			return blockState.getValue(dp);
		prop = blockState.getBlock().getStateDefinition().getProperty("axis");
		return prop instanceof EnumProperty ep && ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) blockState.getValue(ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
	}
}