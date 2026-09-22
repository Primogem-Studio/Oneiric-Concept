package net.mcreator.oneiricconcept.procedures;

import net.neoforged.fml.ModList;

import net.minecraft.world.entity.Entity;

public class DelightProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (ModList.get().isLoaded("farmersdelight")) {
		}
		BlbgBuffProcedure.execute(entity);
		Health100Procedure.execute(entity, 0.1);
	}
}