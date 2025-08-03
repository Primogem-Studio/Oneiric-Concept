package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;
import net.mcreator.oneiricconcept.OneiricconceptMod;

public class StormGlassParticleProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double cycle) {
		BlockState blockstates = Blocks.AIR.defaultBlockState();
		double currents = 0;
		boolean isDirectionN_S = false;
		blockstates = (world.getBlockState(BlockPos.containing(x, y, z)));
		if (0 < cycle && blockstates.getBlock() == OneiricconceptModBlocks.PRIMOGEMSTORMGLASS.get()) {
			currents = blockstates.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip2 ? blockstates.getValue(_getip2) : -1;
			if (1 == currents) {
				isDirectionN_S = (getDirectionFromBlockState(blockstates)).getAxis() == Direction.Axis.Z;
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.DRIPPING_WATER, (x + 0.5), (y + 0.54), (z + 0.5), 2, (isDirectionN_S ? 0.05 : 0), 0, (isDirectionN_S ? 0 : 0.05), 1);
				OneiricconceptMod.queueServerWork(1, () -> {
					StormGlassParticleProcedure.execute(world, x, y, z, cycle - 1);
				});
			} else {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SMALL_FLAME, (x + 0.5), (y + 0.6), (z + 0.5), 1, (isDirectionN_S ? 0.05 : 0), 0.05, (isDirectionN_S ? 0 : 0.05), 0.01);
				OneiricconceptMod.queueServerWork(10, () -> {
					StormGlassParticleProcedure.execute(world, x, y, z, cycle - 10);
				});
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