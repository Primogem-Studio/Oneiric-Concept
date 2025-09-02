package net.mcreator.oneiricconcept.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

public class SweetflowerBlock extends FlowerBlock {
	public SweetflowerBlock() {
		super(MobEffects.LUCK, 100, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.GRASS).instabreak().noCollission().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 100;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}

	@Override
	public boolean mayPlaceOn(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
		return groundState.is(Blocks.GRASS_BLOCK) || groundState.is(Blocks.DIRT_PATH) || groundState.is(Blocks.MYCELIUM) || groundState.is(Blocks.DIRT) || groundState.is(Blocks.PODZOL) || groundState.is(Blocks.ROOTED_DIRT)
				|| groundState.is(Blocks.MUD) || groundState.is(Blocks.PACKED_MUD) || groundState.is(OneiricconceptModBlocks.NAGADUS_EMERALD_ORE.get()) || groundState.is(Blocks.MOSS_BLOCK) || groundState.is(Blocks.SAND)
				|| groundState.is(Blocks.RED_SAND) || groundState.is(Blocks.WARPED_NYLIUM) || groundState.is(Blocks.CRIMSON_NYLIUM) || groundState.is(Blocks.SOUL_SAND) || groundState.is(Blocks.SOUL_SOIL);
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		return this.mayPlaceOn(groundState, worldIn, blockpos);
	}
}