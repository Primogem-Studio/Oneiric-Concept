package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;
import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;
import net.mcreator.oneiricconcept.OneiricconceptMod;

public class MakemetalmeltProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double a = 0;
		double b = 0;
		double Magnification = 0;
		double healthre = 0;
		BlockState block = Blocks.AIR.defaultBlockState();
		ItemStack blkitm = ItemStack.EMPTY;
		block = (world.getBlockState(BlockPos.containing(x, y + 1, z)));
		blkitm = (new ItemStack(block.getBlock()));
		if (block.getBlock() == OneiricconceptModBlocks.GEOOO_1.get()) {
			for (int index0 = 0; index0 < 200; index0++) {
				a = a + 1;
				OneiricconceptMod.queueServerWork((int) a, () -> {
					if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == OneiricconceptModBlocks.GEOOO_1.get()) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.FLAME, (x + 0.5), (y + 1), (z + 0.5), 1, 0.06, 0.01, 0.06, 0.01);
					}
				});
			}
			OneiricconceptMod.queueServerWork(202, () -> {
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == OneiricconceptModBlocks.GEOOO_1.get() && (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == OneiricconceptModBlocks.MOLTEN_METAL_BLOCK.get()) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.FLAME, (x + 0.5), (y + 3), (z + 0.5), 100, 0.05, 1, 0.05, 0.1);
					world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(OneiricconceptModItems.IGNIS_AURELIAE.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			});
		} else if (world instanceof Level _level16 && _level16.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput(blkitm), _level16).isPresent()) {
			world.destroyBlock(BlockPos.containing(x, y + 1, z), false);
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, (y + 1), z,
						(world instanceof Level _lvlSmeltResult
								? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput(blkitm), _lvlSmeltResult).map(recipe -> recipe.value().getResultItem(_lvlSmeltResult.registryAccess()).copy())
										.orElse(ItemStack.EMPTY)
								: ItemStack.EMPTY));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}
}
