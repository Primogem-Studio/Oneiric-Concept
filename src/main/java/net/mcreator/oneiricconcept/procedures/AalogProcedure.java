package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;

import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

public class AalogProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		BlockState bloc = Blocks.AIR.defaultBlockState();
		bloc = (RandomProcedure.execute(world, 0.1) ? OneiricconceptModBlocks.AMBROSIAL_ARBOR_LEAVE.get().defaultBlockState() : OneiricconceptModBlocks.AMBROSIAL_ARBOR_LOG.get().defaultBlockState());
		ExplosionplasseProcedure.execute(world, x, y, z, bloc, 0.8);
	}
}