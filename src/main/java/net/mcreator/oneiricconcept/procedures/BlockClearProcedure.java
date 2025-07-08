package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.OneiricconceptMod;

public class BlockClearProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sz = 0;
		for (int index0 = 0; index0 < 16; index0++) {
			sz = 0;
			for (int index1 = 0; index1 < 16; index1++) {
				if (-1 != world.getBlockState(BlockPos.containing(x + sx, y, z + sz)).getDestroySpeed(world, BlockPos.containing(x + sx, y, z + sz))) {
					world.setBlock(BlockPos.containing(x + sx, y, z + sz), Blocks.AIR.defaultBlockState(), 3);
				}
				sz = sz + 1;
			}
			sx = sx + 1;
		}
		if ((world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:is_overworld"))) ? -63 : 0) < y) {
			OneiricconceptMod.queueServerWork(1, () -> {
				BlockClearProcedure.execute(world, x, y - 1, z);
			});
		}
	}
}
