package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class ExplosionplasseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState block, double nu) {
		if (Math.random() < nu) {
			OneiricconceptMod.queueServerWork((int) Mth.nextDouble(RandomSource.create(), 20, 80), () -> {
				world.setBlock(BlockPos.containing(x, y, z), block, 3);
			});
		}
	}
}
