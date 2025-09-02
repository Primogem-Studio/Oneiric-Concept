package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

public class BlockmodeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		ItemStack item = ItemStack.EMPTY;
		double maxmdoe = 0;
		double blockmode = 0;
		item = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		blockmode = blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip2 ? blockstate.getValue(_getip2) : -1;
		if (blockstate.getBlock() == OneiricconceptModBlocks.PRIMOGEM.get()) {
			maxmdoe = 6;
		} else if (blockstate.getBlock() == OneiricconceptModBlocks.HERTABOND.get()) {
			maxmdoe = 10;
		} else {
			maxmdoe = 9;
		}
		if (blockmode < maxmdoe) {
			if (blockstate.getBlock() == (item.getItem() instanceof BlockItem _bi ? _bi.getBlock().defaultBlockState() : Blocks.AIR.defaultBlockState()).getBlock()) {
				{
					int _value = (int) Math.min(maxmdoe, blockmode + 1);
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
				item.shrink(1);
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("translation.key.fail").getString())), true);
			}
		}
		if ((new ItemStack(blockstate.getBlock())).is(ItemTags.create(ResourceLocation.parse("c:gem")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_cluster.place")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.amethyst_cluster.place")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
		} else if ((new ItemStack(blockstate.getBlock())).is(ItemTags.create(ResourceLocation.parse("c:metal")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.metal.place")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.metal.place")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
		}
	}
}