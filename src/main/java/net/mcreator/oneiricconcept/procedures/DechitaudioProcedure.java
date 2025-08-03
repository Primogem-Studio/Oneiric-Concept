package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class DechitaudioProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		BlockState blockeman = Blocks.AIR.defaultBlockState();
		blockeman = (world.getBlockState(BlockPos.containing(x, y, z)));
		if ((new ItemStack(blockeman.getBlock())).is(ItemTags.create(ResourceLocation.parse("c:gem")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_cluster.place")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_cluster.place")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
		} else if ((new ItemStack(blockeman.getBlock())).is(ItemTags.create(ResourceLocation.parse("c:metal")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.chain.hit")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.chain.hit")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
		}
	}
}