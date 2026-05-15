package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

public class SakuraTreeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		Entity e1 = null;
		ItemStack i1 = ItemStack.EMPTY;
		boolean gz = false;
		double yy = 0;
		if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
			yy = world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z);
			if (Blocks.CHERRY_SAPLING.defaultBlockState().canSurvive(world, BlockPos.containing(x, yy, z))) {
				if (world instanceof ServerLevel _level)
					_level.holderOrThrow(ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.parse("oneiricconcept:light_sakura"))).value().place(_level, _level.getChunkSource().getGenerator(), _level.getRandom(),
							BlockPos.containing(x, yy, z));
			}
		}
	}
}