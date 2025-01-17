package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class ExplosionplasexyzProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState block, double nu) {
		double x1 = 0;
		double y1 = 0;
		double z1 = 0;
		x1 = x + Mth.nextInt(RandomSource.create(), -1, 1);
		y1 = y + Mth.nextInt(RandomSource.create(), -1, 1);
		z1 = z + Mth.nextInt(RandomSource.create(), -1, 1);
		if (!(world.getBlockState(BlockPos.containing(x1, y1, z1))).is(BlockTags.create(ResourceLocation.parse("c:ambrosialarbor"))) && RandomProcedure.execute(world, nu * 0.5)) {
			world.setBlock(BlockPos.containing(x1, y1, z1), block, 3);
		}
	}
}
