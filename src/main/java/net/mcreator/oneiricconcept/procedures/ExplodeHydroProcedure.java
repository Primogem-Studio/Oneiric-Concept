package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

public class ExplodeHydroProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ExplodeBoomBlossomsNoLoadProcedure.execute(world, x, y, z, OneiricconceptModBlocks.BOOM_BLOSSOMS_HYDRO.get().defaultBlockState());
	}
}