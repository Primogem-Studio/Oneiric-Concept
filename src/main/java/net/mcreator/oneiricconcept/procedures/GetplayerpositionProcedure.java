package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class GetplayerpositionProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		Entity ent = null;
		ent = GetPlayerEntityProcedure.execute(world, entity);
		return "x\uFF1A" + Math.round(Math.pow(10, 2) * (ent.getX())) / Math.pow(10, 2) + "\n" + "y\uFF1A" + Math.round(Math.pow(10, 2) * (ent.getY())) / Math.pow(10, 2) + "\n" + "z\uFF1A"
				+ Math.round(Math.pow(10, 2) * (ent.getZ())) / Math.pow(10, 2);
	}
}