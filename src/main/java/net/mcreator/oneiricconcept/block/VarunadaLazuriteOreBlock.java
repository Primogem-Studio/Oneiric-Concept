
package net.mcreator.oneiricconcept.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

import com.mojang.serialization.MapCodec;

public class VarunadaLazuriteOreBlock extends FallingBlock {
	public static final MapCodec<VarunadaLazuriteOreBlock> CODEC = simpleCodec(properties -> new VarunadaLazuriteOreBlock());

	public MapCodec<VarunadaLazuriteOreBlock> codec() {
		return CODEC;
	}

	public VarunadaLazuriteOreBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.SAND).strength(4f, 10f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
