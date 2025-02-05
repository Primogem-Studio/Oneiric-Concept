package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.oneiricconcept.entity.CrystalTurtleEntity;

public class TurtleCrystalProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		double Times = 0;
		Times = entity instanceof CrystalTurtleEntity _datEntI ? _datEntI.getEntityData().get(CrystalTurtleEntity.DATA_crystal) : 0;
		if (entity instanceof CrystalTurtleEntity _datEntL1 && _datEntL1.getEntityData().get(CrystalTurtleEntity.DATA_IsCrystallized) && Times > 0) {
			Times = Times - 1;
			if (entity instanceof CrystalTurtleEntity _datEntSetI)
				_datEntSetI.getEntityData().set(CrystalTurtleEntity.DATA_crystal, (int) Times);
			if (Times <= 0) {
				if (entity instanceof CrystalTurtleEntity _datEntSetL)
					_datEntSetL.getEntityData().set(CrystalTurtleEntity.DATA_IsCrystallized, false);
			}
		}
		return Times <= 0;
	}
}
