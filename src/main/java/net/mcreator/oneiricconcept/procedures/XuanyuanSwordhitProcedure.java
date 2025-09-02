package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class XuanyuanSwordhitProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity, Entity sourceentity) {
		if (immediatesourceentity == null || sourceentity == null)
			return;
		XuanyuanBoomProcedure.execute(world, x, y, z, sourceentity, immediatesourceentity);
	}
}