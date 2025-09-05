package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.entity.Entity;

public class PGCcounterProcedure {
	public static boolean execute(Entity entity, boolean zhi_xing, double zhi, String ss1) {
		if (entity == null || ss1 == null)
			return false;
		String s1 = "";
		double z1 = 0;
		Entity e1 = null;
		e1 = entity;
		z1 = zhi;
		s1 = "oc_" + ss1;
		if (zhi_xing) {
			net.hackermdch.pgc.Timer.set(entity, s1, (int) z1);
		}
		return net.hackermdch.pgc.Timer.isDone(entity, s1);
	}
}