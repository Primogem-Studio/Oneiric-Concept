package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;
import net.mcreator.oneiricconcept.OneiricconceptMod;

public class SetexplosiveProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 2, 5); index0++) {
			OneiricconceptMod.queueServerWork((int) Mth.nextDouble(RandomSource.create(), 1, 40), () -> {
				if (world instanceof ServerLevel _level)
					FallingBlockEntity.fall(_level, BlockPos.containing(x + Mth.nextInt(RandomSource.create(), -4, 4), y + 7, z + Mth.nextInt(RandomSource.create(), -4, 4)), OneiricconceptModBlocks.BOOM_BLOSSOMS_PYRO.get().defaultBlockState());
			});
		}
	}
}