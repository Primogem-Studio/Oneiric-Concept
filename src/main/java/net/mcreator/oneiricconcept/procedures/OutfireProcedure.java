package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;

public class OutfireProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (RandomProcedure.execute(world, 0.5)) {
			OfffireProcedure.execute(world, x, y, z, x + 1, y + 0, z + 0);
			OfffireProcedure.execute(world, x, y, z, x + 0, y + 1, z + 0);
			OfffireProcedure.execute(world, x, y, z, x + 0, y + 0, z + 1);
			OfffireProcedure.execute(world, x, y, z, x + -1, y + 0, z + 0);
			OfffireProcedure.execute(world, x, y, z, x + 0, y + -1, z + 0);
			OfffireProcedure.execute(world, x, y, z, x + 0, y + 0, z + -1);
		}
	}
}
