
package net.mcreator.oneiricconcept.block;

import org.checkerframework.checker.units.qual.s;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.Optional;
import java.util.List;

public class BananaMushroomBlock extends SaplingBlock {
	public static final TreeGrower TREE_GROWER = new TreeGrower("banana_mushroom", 0.2f, Optional.empty(), Optional.empty(), Optional.of(getFeatureKey("oneiricconcept:b_2anana_mushroom")), Optional.of(getFeatureKey("oneiricconcept:mm_mushroom")),
			Optional.empty(), Optional.empty());

	public BananaMushroomBlock() {
		super(TREE_GROWER,
				BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).randomTicks().sound(SoundType.GRASS).instabreak().lightLevel(s -> 3).noCollission().offsetType(BlockBehaviour.OffsetType.NONE).pushReaction(PushReaction.DESTROY));
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

	private static ResourceKey<ConfiguredFeature<?, ?>> getFeatureKey(String feature) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.parse(feature));
	}
}
