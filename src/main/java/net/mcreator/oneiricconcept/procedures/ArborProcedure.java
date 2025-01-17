package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class ArborProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		BlockState blocks = Blocks.AIR.defaultBlockState();
		blocks = (world.getBlockState(BlockPos.containing(x, y, z)));
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (x + 0.5), (y + 0.5), (z + 0.5), 10, 0.3, 0.3, 0.3, 1);
		if (world instanceof Level _level) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
				if (!_level.isClientSide())
					_level.levelEvent(2005, _bp, 0);
			}
		}
		if ((blocks.is(BlockTags.create(ResourceLocation.parse("c:sugar_canes"))) || blocks.is(BlockTags.create(ResourceLocation.parse("c:cactus")))) && RandomProcedure.execute(0.3)) {
			world.setBlock(BlockPos.containing(x, y + 1, z), blocks, 3);
		}
	}
}
