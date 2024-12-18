
package net.mcreator.oneiricconcept.block;

import org.checkerframework.checker.units.qual.s;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.procedures.BananaMushroomboneProcedure;
import net.mcreator.oneiricconcept.procedures.BananaMushroomNagadusProcedure;

import java.util.List;

public class BananaMushroomBlock extends FlowerBlock implements BonemealableBlock {
	public BananaMushroomBlock() {
		super(MobEffects.LUCK, 100, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.GRASS).instabreak().lightLevel(s -> 3).noCollission().offsetType(BlockBehaviour.OffsetType.NONE).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 100;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("block.oneiricconcept.banana_mushroom.description_0"));
		list.add(Component.translatable("block.oneiricconcept.banana_mushroom.description_1"));
		list.add(Component.translatable("block.oneiricconcept.banana_mushroom.description_2"));
		list.add(Component.translatable("block.oneiricconcept.banana_mushroom.description_3"));
		list.add(Component.translatable("block.oneiricconcept.banana_mushroom.description_4"));
		list.add(Component.translatable("block.oneiricconcept.banana_mushroom.description_5"));
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}

	@Override
	public boolean isValidBonemealTarget(LevelReader worldIn, BlockPos pos, BlockState blockstate) {
		return true;
	}

	@Override
	public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState blockstate) {
		return BananaMushroomboneProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState blockstate) {
		BananaMushroomNagadusProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}
