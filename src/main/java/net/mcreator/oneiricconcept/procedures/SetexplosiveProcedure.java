package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;
import net.mcreator.oneiricconcept.entity.ExplosiveHydroEntity;
import net.mcreator.oneiricconcept.entity.ExplosiveEntity;
import net.mcreator.oneiricconcept.entity.ExplosiveElectroEntity;
import net.mcreator.oneiricconcept.entity.ExplosiveDendroEntity;
import net.mcreator.oneiricconcept.entity.ExplosiveCryoEntity;

public class SetexplosiveProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double xyz = 0;
		double range = 0;
		double rx = 0;
		double ry = 0;
		double rz = 0;
		BlockState block = Blocks.AIR.defaultBlockState();
		range = 13;
		xyz = Math.round(0 - (range - 1) / 2);
		sx = xyz;
		for (int index0 = 0; index0 < (int) range; index0++) {
			sy = xyz;
			for (int index1 = 0; index1 < (int) range; index1++) {
				sz = xyz;
				for (int index2 = 0; index2 < (int) range; index2++) {
					rx = x + sx;
					ry = y + sy;
					rz = z + sz;
					if (immediatesourceentity instanceof ExplosiveEntity) {
						block = OneiricconceptModBlocks.BOOM_BLOSSOMS_PYRO.get().defaultBlockState();
					} else if (immediatesourceentity instanceof ExplosiveCryoEntity) {
						block = OneiricconceptModBlocks.BOOM_BLOSSOMS_CRYO.get().defaultBlockState();
					} else if (immediatesourceentity instanceof ExplosiveDendroEntity) {
						block = OneiricconceptModBlocks.BOOM_BLOSSOMS_DENDRO.get().defaultBlockState();
					} else if (immediatesourceentity instanceof ExplosiveElectroEntity) {
						block = OneiricconceptModBlocks.BOOM_BLOSSOMS_ELECTRO.get().defaultBlockState();
					} else if (immediatesourceentity instanceof ExplosiveHydroEntity) {
						block = OneiricconceptModBlocks.BOOM_BLOSSOMS_HYDRO.get().defaultBlockState();
					}
					if ((world.getBlockState(BlockPos.containing(rx, ry, rz))).canBeReplaced() && world.getBlockFloorHeight(BlockPos.containing(rx, ry - 1, rz)) > 0) {
						if (RandomProcedure.execute(world, Mth.clamp(((range / 2) / new Vec3(x, y, z).distanceTo(new Vec3(rx, ry, rz)) - 1), 0, 1) * 0.2)) {
							world.setBlock(BlockPos.containing(rx, ry, rz), block, 3);
							ExplodeBoomBlossomsProcedure.execute(world, rx, ry, rz, block);
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