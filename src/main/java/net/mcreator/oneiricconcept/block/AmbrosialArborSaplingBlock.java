
package net.mcreator.oneiricconcept.block;

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
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

import java.util.Optional;

public class AmbrosialArborSaplingBlock extends SaplingBlock {
	public static final TreeGrower TREE_GROWER = new TreeGrower("ambrosial_arbor_sapling", Optional.empty(), Optional.of(getFeatureKey("oneiricconcept:ambrosial_arbor")), Optional.empty());

	public AmbrosialArborSaplingBlock() {
		super(TREE_GROWER, BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).randomTicks().sound(SoundType.GRASS).instabreak().noCollission().offsetType(BlockBehaviour.OffsetType.NONE).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public boolean mayPlaceOn(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
		return groundState.is(OneiricconceptModBlocks.NAGADUS_EMERALD_ORE.get()) || groundState.is(Blocks.STONE) || groundState.is(Blocks.GRANITE) || groundState.is(Blocks.DIORITE) || groundState.is(Blocks.ANDESITE)
				|| groundState.is(Blocks.DEEPSLATE) || groundState.is(Blocks.TUFF) || groundState.is(Blocks.SAND) || groundState.is(Blocks.RED_SAND) || groundState.is(Blocks.GRAVEL) || groundState.is(Blocks.GRASS_BLOCK)
				|| groundState.is(Blocks.DIRT_PATH) || groundState.is(Blocks.MYCELIUM) || groundState.is(Blocks.DIRT) || groundState.is(Blocks.COARSE_DIRT) || groundState.is(Blocks.PODZOL) || groundState.is(Blocks.ROOTED_DIRT)
				|| groundState.is(Blocks.MUD) || groundState.is(Blocks.PACKED_MUD) || groundState.is(Blocks.COBBLESTONE) || groundState.is(Blocks.MOSSY_COBBLESTONE) || groundState.is(Blocks.MOSS_BLOCK) || groundState.is(Blocks.BLACKSTONE)
				|| groundState.is(Blocks.SANDSTONE) || groundState.is(Blocks.RED_SANDSTONE) || groundState.is(Blocks.ICE) || groundState.is(Blocks.PACKED_ICE) || groundState.is(Blocks.FROSTED_ICE) || groundState.is(Blocks.BLUE_ICE)
				|| groundState.is(Blocks.NETHERRACK) || groundState.is(Blocks.WARPED_NYLIUM) || groundState.is(Blocks.CRIMSON_NYLIUM) || groundState.is(Blocks.END_STONE) || groundState.is(Blocks.BASALT) || groundState.is(Blocks.BEDROCK);
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
