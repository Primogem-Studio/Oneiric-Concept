package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.oneiricconcept.entity.BaryonEntity;

public class BaryonmodeProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (RandomProcedure.execute(world, 0.5)) {
			if (entity instanceof BaryonEntity _datEntSetI)
				_datEntSetI.getEntityData().set(BaryonEntity.DATA_mode, 1);
		} else {
			if (entity instanceof BaryonEntity _datEntSetI)
				_datEntSetI.getEntityData().set(BaryonEntity.DATA_mode, 2);
		}
	}
}