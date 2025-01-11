package net.mcreator.oneiricconcept.procedures;

import org.checkerframework.checker.units.qual.Time;

import net.minecraft.world.entity.Entity;

import net.mcreator.oneiricconcept.entity.CrystalTurtleEntity;

public class ShrinkingShellSuoKeProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		boolean Time = false;
		double Timenu = 0;
		Timenu = entity instanceof CrystalTurtleEntity _datEntI ? _datEntI.getEntityData().get(CrystalTurtleEntity.DATA_ShrinkingShellTime) : 0;
		Time = Timenu > 0;
		if (Time) {
			if (entity instanceof CrystalTurtleEntity _datEntSetI)
				_datEntSetI.getEntityData().set(CrystalTurtleEntity.DATA_ShrinkingShellTime, (int) (Timenu - 1));
		}
		return Time;
	}
}
