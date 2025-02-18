package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;

public class WaterradiatorProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double previousRecipe = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		BlockState waterblock = Blocks.AIR.defaultBlockState();
		sx = -3;
		for (int index0 = 0; index0 < 7; index0++) {
			sy = -3;
			for (int index1 = 0; index1 < 7; index1++) {
				sz = -3;
				for (int index2 = 0; index2 < 7; index2++) {
					waterblock = (world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)));
					if (waterblock.getBlock() == Blocks.WATER || waterblock.getBlock() == Blocks.WATER) {
						world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), Blocks.AIR.defaultBlockState(), 3);
						if (world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, ResourceLocation.parse("minecraft:is_ocean")))) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + sx), (y + sy), (z + sz), new ItemStack(OneiricconceptModItems.SALT_DUST.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
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
