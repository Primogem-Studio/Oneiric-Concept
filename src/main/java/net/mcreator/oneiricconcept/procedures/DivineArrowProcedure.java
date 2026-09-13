package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

public class DivineArrowProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double xyz = 0;
		double range = 0;
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
						break;
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
		if (found) {
			for (int index3 = 0; index3 < (int) range; index3++) {
				sz = xyz;
				for (int index4 = 0; index4 < (int) range; index4++) {
					if (index4 % 2 == 0 && index3 % 2 == 0) {
						SkyArrowProcedure.execute(world, x + sx, z + sz, entity, 2 * (index4 + index3));
					}
					sz = sz + 1;
				}
				sx = sx + 1;
			}
		}
	}
}