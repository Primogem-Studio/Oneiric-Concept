package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class ExplosionplasseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState block, double nu) {
		double x1 = 0;
		double y1 = 0;
		double z1 = 0;
		if (RandomProcedure.execute(nu)) {
			OneiricconceptMod.queueServerWork((int) Mth.nextDouble(RandomSource.create(), 20, 80), () -> {
				world.setBlock(BlockPos.containing(x, y, z), block, 3);
			});
			OneiricconceptMod.queueServerWork((int) Mth.nextDouble(RandomSource.create(), 20, 80), () -> {
				if (RandomProcedure.execute(nu * 0.5)) {
					world.setBlock(BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -1, 1), y + Mth.nextInt(RandomSource.create(), -1, 1), z + Mth.nextInt(RandomSource.create(), -1, 1)), block, 3);
				}
			});
		}
	}
}
