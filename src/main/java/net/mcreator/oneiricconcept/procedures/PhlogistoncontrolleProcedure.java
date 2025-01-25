package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.entity.Entity;

public class PhlogistoncontrolleProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		boolean flylgc = false;
		entity.getPersistentData().putBoolean("ocflyon", (!entity.getPersistentData().getBoolean("ocflyon")));
	}
}
