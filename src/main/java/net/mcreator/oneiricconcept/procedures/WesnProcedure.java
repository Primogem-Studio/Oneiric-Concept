package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class WesnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double y2) {
		OneiricconceptMod.queueServerWork(201, () -> {
			WensProcedure.execute(world, x, y, z, y2);
		});
	}
}