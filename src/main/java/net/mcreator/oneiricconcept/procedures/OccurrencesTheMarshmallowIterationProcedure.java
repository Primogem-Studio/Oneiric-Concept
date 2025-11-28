package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class OccurrencesTheMarshmallowIterationProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean L = false;
		double a = 0;
		a = entity.getPersistentData().getDouble("PlayerLife");
		L = a > 0;
		if (entity.onGround() && L) {
			net.mcreator.ceshi.procedures.EventGroupProcedure.execute(world, entity, (int) (1001 + a));
		} else if (!entity.onGround() && L) {
			OneiricconceptMod.queueServerWork(2, () -> {
				OccurrencesTheMarshmallowIterationProcedure.execute(world, entity);
			});
		}
	}
}