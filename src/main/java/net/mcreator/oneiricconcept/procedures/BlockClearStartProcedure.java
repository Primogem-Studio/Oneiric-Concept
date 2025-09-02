package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;

public class BlockClearStartProcedure {
	public static void execute(LevelAccessor world, double x, double z) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double maxy = 0;
		double xx = 0;
		double zz = 0;
		xx = Math.floor(x / 16) * 16;
		zz = Math.floor(z / 16) * 16;
		for (int index0 = 0; index0 < 16; index0++) {
			sz = 0;
			for (int index1 = 0; index1 < 16; index1++) {
				maxy = Math.max(world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) (xx + sx), (int) (zz + sz)), maxy);
				sz = sz + 1;
			}
			sx = sx + 1;
		}
		sy = sy - 1;
		BlockClearProcedure.execute(world, xx, maxy, zz);
	}
}