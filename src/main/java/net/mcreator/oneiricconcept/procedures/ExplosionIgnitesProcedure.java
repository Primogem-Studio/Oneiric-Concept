package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

public class ExplosionIgnitesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double rang) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double xyz = 0;
		double range = 0;
		double probability = 0;
		range = rang;
		xyz = Math.round(0 - (range - 1) / 2);
		sx = xyz;
		for (int index0 = 0; index0 < (int) range; index0++) {
			sy = xyz;
			for (int index1 = 0; index1 < (int) range; index1++) {
				sz = xyz;
				for (int index2 = 0; index2 < (int) range; index2++) {
					if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.AIR) {
						if (RandomProcedure.execute(world, 0.5)) {
							probability = Mth.clamp(((range / 2) / new Vec3(x, y, z).distanceTo(new Vec3((x + sx), (y + sy), (z + sz))) - 1), 0, 1);
							if (RandomProcedure.execute(world, probability)) {
								world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), Blocks.FIRE.defaultBlockState(), 3);
							}
						}
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
	}
}