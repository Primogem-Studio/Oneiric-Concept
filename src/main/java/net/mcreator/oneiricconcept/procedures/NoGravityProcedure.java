package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.entity.Entity;

public class NoGravityProcedure {
	public static void execute(Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		immediatesourceentity.setNoGravity(true);
	}
}