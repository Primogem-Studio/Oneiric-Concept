package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.oneiricconcept.entity.CrystalTurtleEntity;

public class TurtleCrystalProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		double Times = 0;
		boolean logis = false;
		Times = entity instanceof CrystalTurtleEntity _datEntI ? _datEntI.getEntityData().get(CrystalTurtleEntity.DATA_crystal) : 0;
		logis = Times <= 0;
		if (!logis) {
			if (entity instanceof CrystalTurtleEntity _datEntSetI)
				_datEntSetI.getEntityData().set(CrystalTurtleEntity.DATA_crystal, (int) (Times - 1));
		}
		return logis;
	}
}
