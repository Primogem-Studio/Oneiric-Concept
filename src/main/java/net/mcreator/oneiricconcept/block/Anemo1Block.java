
package net.mcreator.oneiricconcept.block;

import org.checkerframework.checker.units.qual.s;

import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.oneiricconcept.procedures.BreakDropsProcedure;
import net.mcreator.oneiricconcept.procedures.BlockmodeProcedure;
import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

public class Anemo1Block extends Block implements SimpleWaterloggedBlock {
	public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 9);
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public Anemo1Block() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.METAL).strength(1f, 10f).lightLevel(s -> (new Object() {
			public int getLightLevel() {
				if (s.getValue(BLOCKSTATE) == 1)
					return 0;
				if (s.getValue(BLOCKSTATE) == 2)
					return 0;
				if (s.getValue(BLOCKSTATE) == 3)
					return 0;
				if (s.getValue(BLOCKSTATE) == 4)
					return 0;
				if (s.getValue(BLOCKSTATE) == 5)
					return 0;
				if (s.getValue(BLOCKSTATE) == 6)
					return 0;
				if (s.getValue(BLOCKSTATE) == 7)
					return 0;
				if (s.getValue(BLOCKSTATE) == 8)
					return 0;
				if (s.getValue(BLOCKSTATE) == 9)
					return 0;
				return 0;
			}
		}.getLightLevel())).noOcclusion().pushReaction(PushReaction.DESTROY).isRedstoneConductor((bs, br, bp) -> false));
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
		if (state.getValue(BLOCKSTATE) == 1) {
			return switch (state.getValue(FACING)) {
				default -> box(3.5, 0, 4.5, 12.5, 2, 11.5);
				case NORTH -> box(3.5, 0, 4.5, 12.5, 2, 11.5);
				case EAST -> box(4.5, 0, 3.5, 11.5, 2, 12.5);
				case WEST -> box(4.5, 0, 3.5, 11.5, 2, 12.5);
			};
		}
		if (state.getValue(BLOCKSTATE) == 2) {
			return switch (state.getValue(FACING)) {
				default -> box(1, 0, 4.5, 15, 2, 11.5);
				case NORTH -> box(1, 0, 4.5, 15, 2, 11.5);
				case EAST -> box(4.5, 0, 1, 11.5, 2, 15);
				case WEST -> box(4.5, 0, 1, 11.5, 2, 15);
			};
		}
		if (state.getValue(BLOCKSTATE) == 3) {
			return switch (state.getValue(FACING)) {
				default -> box(1, 0, 0.5, 15, 2, 15.5);
				case NORTH -> box(1, 0, 0.5, 15, 2, 15.5);
				case EAST -> box(0.5, 0, 1, 15.5, 2, 15);
				case WEST -> box(0.5, 0, 1, 15.5, 2, 15);
			};
		}
		if (state.getValue(BLOCKSTATE) == 4) {
			return switch (state.getValue(FACING)) {
				default -> box(1, 0, 0.5, 15, 2, 15.5);
				case NORTH -> box(1, 0, 0.5, 15, 2, 15.5);
				case EAST -> box(0.5, 0, 1, 15.5, 2, 15);
				case WEST -> box(0.5, 0, 1, 15.5, 2, 15);
			};
		}
		if (state.getValue(BLOCKSTATE) == 5) {
			return switch (state.getValue(FACING)) {
				default -> box(1, 0, 0.5, 15, 2, 15.5);
				case NORTH -> box(1, 0, 0.5, 15, 2, 15.5);
				case EAST -> box(0.5, 0, 1, 15.5, 2, 15);
				case WEST -> box(0.5, 0, 1, 15.5, 2, 15);
			};
		}
		if (state.getValue(BLOCKSTATE) == 6) {
			return switch (state.getValue(FACING)) {
				default -> box(1, 0, 0.5, 15, 4, 15.5);
				case NORTH -> box(1, 0, 0.5, 15, 4, 15.5);
				case EAST -> box(0.5, 0, 1, 15.5, 4, 15);
				case WEST -> box(0.5, 0, 1, 15.5, 4, 15);
			};
		}
		if (state.getValue(BLOCKSTATE) == 7) {
			return switch (state.getValue(FACING)) {
				default -> box(1, 0, 0.5, 15, 4, 15.5);
				case NORTH -> box(1, 0, 0.5, 15, 4, 15.5);
				case EAST -> box(0.5, 0, 1, 15.5, 4, 15);
				case WEST -> box(0.5, 0, 1, 15.5, 4, 15);
			};
		}
		if (state.getValue(BLOCKSTATE) == 8) {
			return switch (state.getValue(FACING)) {
				default -> box(1, 0, 0.5, 15, 4, 15.5);
				case NORTH -> box(1, 0, 0.5, 15, 4, 15.5);
				case EAST -> box(0.5, 0, 1, 15.5, 4, 15);
				case WEST -> box(0.5, 0, 1, 15.5, 4, 15);
			};
		}
		if (state.getValue(BLOCKSTATE) == 9) {
			return switch (state.getValue(FACING)) {
				default -> box(1, 0, 0.5, 15, 4, 15.5);
				case NORTH -> box(1, 0, 0.5, 15, 4, 15.5);
				case EAST -> box(0.5, 0, 1, 15.5, 4, 15);
				case WEST -> box(0.5, 0, 1, 15.5, 4, 15);
			};
		}
		return switch (state.getValue(FACING)) {
			default -> box(6, 0, 4.5, 10, 2, 11.5);
			case NORTH -> box(6, 0, 4.5, 10, 2, 11.5);
			case EAST -> box(4.5, 0, 6, 11.5, 2, 10);
			case WEST -> box(4.5, 0, 6, 11.5, 2, 10);
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, WATERLOGGED, BLOCKSTATE);
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

	@Override
	public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
		boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
		BreakDropsProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
		return retval;
	}

	@Override
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		BlockmodeProcedure.execute(world, x, y, z, blockstate, entity);
		return InteractionResult.SUCCESS;
	}

	@OnlyIn(Dist.CLIENT)
	public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
		event.getBlockColors().register((bs, world, pos, index) -> {
			return world != null && pos != null ? Minecraft.getInstance().level.getBiome(pos).value().getSkyColor() : 8562943;
		}, OneiricconceptModBlocks.ANEMO_METAL.get());
	}
}
