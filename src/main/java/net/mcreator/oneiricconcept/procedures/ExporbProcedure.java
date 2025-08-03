package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.server.level.ServerLevel;

public class ExporbProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double xp) {
		if (world instanceof ServerLevel _level)
			_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, (int) xp));
	}
}