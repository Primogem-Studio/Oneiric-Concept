package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

public class DivineArrowProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double xyz = 0;
		double range = 0;
		double rx = 0;
		double rz = 0;
		boolean found = false;
		boolean isAx = false;
		boolean isAz = false;
		range = 33;
		xyz = Math.round(0 - (range - 1) / 2);
		sx = xyz;
		found = false;
		for (int index0 = 0; index0 < (int) range; index0++) {
			if (found) {
				break;
			}
			sy = xyz;
			for (int index1 = 0; index1 < (int) range; index1++) {
				if (found) {
					break;
				}
				sz = xyz;
				for (int index2 = 0; index2 < (int) range; index2++) {
					if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == OneiricconceptModBlocks.AMBROSIAL_ARBOR_LEAVE.get()
							|| (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == OneiricconceptModBlocks.AMBROSIAL_ARBOR_LOG.get()) {
						found = true;
						rx = sx;
						rz = sz;
						break;
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		isAx = rx < x;
		isAz = rz < z;
		sx = isAx ? 0 - xyz : xyz;
		if (found) {
			for (int index3 = 0; index3 < (int) range; index3++) {
				sz = isAz ? 0 - xyz : xyz;
				for (int index4 = 0; index4 < (int) range; index4++) {
					if (index4 % 2 == 0 && index3 % 2 == 0) {
						SkyArrowProcedure.execute(world, x + sx, z + sz, entity, 2 * (index4 + index3));
					}
					sz = sz + (isAz ? -1 : 1);
				}
				sx = sx + (isAx ? -1 : 1);
			}
		}
	}
}