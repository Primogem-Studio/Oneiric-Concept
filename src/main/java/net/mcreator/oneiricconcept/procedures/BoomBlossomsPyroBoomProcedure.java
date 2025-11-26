package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;
import net.mcreator.oneiricconcept.OneiricconceptMod;

public class BoomBlossomsPyroBoomProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		OneiricconceptMod.queueServerWork(60, () -> {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == OneiricconceptModBlocks.BOOM_BLOSSOMS_PYRO.get()) {
				ExplosionIgnitesProcedure.execute(world, x, y + 2, z, 9);
			}
		});
		return true;
	}
}