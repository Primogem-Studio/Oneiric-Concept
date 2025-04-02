
package net.mcreator.oneiricconcept.block;

import org.checkerframework.checker.units.qual.s;

import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.procedures.MmhitProcedure;
import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

import java.util.List;

public class MmMushroomBlock extends DoublePlantBlock {
	public MmMushroomBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK)
				.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("oneiricconcept:mmm")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("oneiricconcept:mmm")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.grass.place")), () -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.grass.hit")),
						() -> BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("oneiricconcept:mmm"))))
				.instabreak().lightLevel(s -> 3).noCollission().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("block.oneiricconcept.mm_mushroom.description_0"));
		list.add(Component.translatable("block.oneiricconcept.mm_mushroom.description_1"));
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}

	@Override
	public boolean mayPlaceOn(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
		return true;
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		if (blockstate.getValue(HALF) == DoubleBlockHalf.UPPER)
			return groundState.is(this) && groundState.getValue(HALF) == DoubleBlockHalf.LOWER;
		else
			return this.mayPlaceOn(groundState, worldIn, blockpos);
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		MmhitProcedure.execute(world, entity);
		return retval;
	}
}
