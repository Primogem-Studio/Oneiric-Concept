package net.mcreator.oneiricconcept.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

import java.util.Optional;

public class TheAnotherWorldSaplingBlock extends SaplingBlock {
	public static final TreeGrower TREE_GROWER = new TreeGrower("the_another_world_sapling", 0.05f, Optional.empty(), Optional.empty(), Optional.of(getFeatureKey("oneiricconcept:the_another_world_tree")), Optional.empty(),
			Optional.of(getFeatureKey("oneiricconcept:the_another_world_tree")), Optional.of(getFeatureKey("oneiricconcept:taw_2")));

	public TheAnotherWorldSaplingBlock() {
		super(TREE_GROWER, BlockBehaviour.Properties.of().mapColor(MapColor.DIAMOND).randomTicks().sound(SoundType.GRASS).instabreak().lightLevel(s -> 3).noCollission().pushReaction(PushReaction.DESTROY));
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
		return groundState.is(OneiricconceptModBlocks.NAGADUS_EMERALD_ORE.get()) || groundState.is(Blocks.DIRT) || groundState.is(Blocks.PODZOL) || groundState.is(Blocks.ROOTED_DIRT) || groundState.is(Blocks.GRASS_BLOCK)
				|| groundState.is(Blocks.SAND) || groundState.is(Blocks.RED_SAND) || groundState.is(Blocks.CLAY) || groundState.is(Blocks.MYCELIUM) || groundState.is(Blocks.SOUL_SAND) || groundState.is(Blocks.SOUL_SOIL)
				|| groundState.is(Blocks.MOSS_BLOCK) || groundState.is(Blocks.GRAVEL);
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		return this.mayPlaceOn(groundState, worldIn, blockpos);
	}

	private static ResourceKey<ConfiguredFeature<?, ?>> getFeatureKey(String feature) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.parse(feature));
	}
}