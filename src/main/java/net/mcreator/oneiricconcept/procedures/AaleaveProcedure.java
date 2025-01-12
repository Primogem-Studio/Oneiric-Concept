package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

public class AaleaveProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ExplosionplasseProcedure.execute(world, x, y, z, OneiricconceptModBlocks.AMBROSIAL_ARBOR_LEAVE.get().defaultBlockState(), 0.9);
	}
}
