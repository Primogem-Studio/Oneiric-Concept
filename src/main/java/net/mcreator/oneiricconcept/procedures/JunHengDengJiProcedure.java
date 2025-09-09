package net.mcreator.oneiricconcept.procedures;

import net.mcreator.ceshi.network.PrimogemcraftModVariables;
import net.minecraft.world.entity.Entity;

public class JunHengDengJiProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		Entity entity0 = null;
		entity0 = entity;
		return entity.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).jun_heng;
	}
}