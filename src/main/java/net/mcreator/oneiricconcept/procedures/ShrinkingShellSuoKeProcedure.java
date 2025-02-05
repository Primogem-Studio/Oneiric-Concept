package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.oneiricconcept.entity.CrystalTurtleEntity;

public class ShrinkingShellSuoKeProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		double Timenu = 0;
		Timenu = entity instanceof CrystalTurtleEntity _datEntI ? _datEntI.getEntityData().get(CrystalTurtleEntity.DATA_ShrinkingShellTime) : 0;
		if (entity instanceof CrystalTurtleEntity _datEntL1 && _datEntL1.getEntityData().get(CrystalTurtleEntity.DATA_IsShrinking) && Timenu > 0) {
			Timenu = Timenu - 1;
			if (entity instanceof CrystalTurtleEntity _datEntSetI)
				_datEntSetI.getEntityData().set(CrystalTurtleEntity.DATA_ShrinkingShellTime, (int) Timenu);
			if (Timenu <= 0) {
				if (entity instanceof CrystalTurtleEntity _datEntSetL)
					_datEntSetL.getEntityData().set(CrystalTurtleEntity.DATA_IsShrinking, false);
				if (entity instanceof CrystalTurtleEntity _datEntSetL)
					_datEntSetL.getEntityData().set(CrystalTurtleEntity.DATA_IsUnShrinking, true);
			}
			return true;
		}
		return false;
	}
}
