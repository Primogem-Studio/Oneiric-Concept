package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

public class XSaplingNagadusProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		if (world instanceof ServerLevel _level)
			_level.holderOrThrow(ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.parse("oneiricconcept:the_another_world_tree"))).value().place(_level, _level.getChunkSource().getGenerator(), _level.getRandom(),
					BlockPos.containing(x, y, z));
		if (!world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
			world.setBlock(BlockPos.containing(x, y, z), OneiricconceptModBlocks.THE_ANOTHER_WORLD_SAPLING.get().defaultBlockState(), 3);
		}
	}
}
