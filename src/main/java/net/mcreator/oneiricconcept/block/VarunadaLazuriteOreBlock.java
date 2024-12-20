
package net.mcreator.oneiricconcept.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.procedures.OrexpProcedure;

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

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		OrexpProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		return retval;
	}
}
