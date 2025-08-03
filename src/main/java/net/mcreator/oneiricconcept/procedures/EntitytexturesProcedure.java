package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.oneiricconcept.entity.BaryonEntity;

public class EntitytexturesProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return 1 < (entity instanceof BaryonEntity _datEntI ? _datEntI.getEntityData().get(BaryonEntity.DATA_mode) : 0);
	}
}