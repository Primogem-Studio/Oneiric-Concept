
package net.mcreator.oneiricconcept.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class BigStoneBlock extends Block implements SimpleWaterloggedBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public BigStoneBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(32f, 10f).requiresCorrectToolForDrops().noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return state.getFluidState().isEmpty();
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(0, -4, 0, 16, 12, 16), box(-9, -16, 1, 7, -6, 15), box(-4, -16, -9, 1, -11, 0), box(25, -16, 9, 30, -14, 12), box(0, -7, -6, 16, 3, 10), box(-2, -3, 2, 5, 7, 12), box(-6, -16, 3, 10, 0, 16),
					box(19, -16, 16, 32, -9, 32), box(16, -16, 0, 32, 0, 16), box(10, -16, 16, 26, 0, 32));
			case NORTH -> Shapes.or(box(0, -4, -0, 16, 12, 16), box(9, -16, 1, 25, -6, 15), box(15, -16, 16, 20, -11, 25), box(-14, -16, 4, -9, -14, 7), box(0, -7, 6, 16, 3, 22), box(11, -3, 4, 18, 7, 14), box(6, -16, 0, 22, 0, 13),
					box(-16, -16, -16, -3, -9, 0), box(-16, -16, 0, 0, 0, 16), box(-10, -16, -16, 6, 0, 0));
			case EAST -> Shapes.or(box(0, -4, 0, 16, 12, 16), box(1, -16, 9, 15, -6, 25), box(-9, -16, 15, 0, -11, 20), box(9, -16, -14, 12, -14, -9), box(-6, -7, 0, 10, 3, 16), box(2, -3, 11, 12, 7, 18), box(3, -16, 6, 16, 0, 22),
					box(16, -16, -16, 32, -9, -3), box(0, -16, -16, 16, 0, 0), box(16, -16, -10, 32, 0, 6));
			case WEST -> Shapes.or(box(-0, -4, 0, 16, 12, 16), box(1, -16, -9, 15, -6, 7), box(16, -16, -4, 25, -11, 1), box(4, -16, 25, 7, -14, 30), box(6, -7, 0, 22, 3, 16), box(4, -3, -2, 14, 7, 5), box(0, -16, -6, 13, 0, 10),
					box(-16, -16, 19, 0, -9, 32), box(0, -16, 16, 16, 0, 32), box(-16, -16, 10, 0, 0, 26));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, flag);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}
}
