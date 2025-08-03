package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;

public class PhlogistonTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ItemStack itm0 = ItemStack.EMPTY;
		boolean itmgiv = false;
		boolean found = false;
		double inventory = 0;
		double snu = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double xyz = 0;
		double range = 0;
		snu = getBlockNBTNumber(world, BlockPos.containing(x, y, z), "lavasnu");
		if (1 <= getFluidTankLevel(world, BlockPos.containing(x, y, z), 1, null) && snu < 1000) {
			if (world instanceof ILevelExtension _ext) {
				IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
				if (_fluidHandler != null)
					_fluidHandler.drain(2, IFluidHandler.FluidAction.EXECUTE);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("lavasnu", (snu + 1));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else if (snu >= 1000) {
			inventory = 2;
			while (!itmgiv && inventory <= 10) {
				if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) inventory).getCount() < 64) {
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(OneiricconceptModItems.PHLOGISTON.get()).copy();
						_setstack.setCount(1 + itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) inventory).getCount());
						_itemHandlerModifiable.setStackInSlot((int) inventory, _setstack);
					}
					itmgiv = true;
				} else {
					inventory = 1 + inventory;
				}
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("lavasnu", 0);
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (!itmgiv) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (1 + y), (z + 0.5), new ItemStack(OneiricconceptModItems.PHLOGISTON.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
		snu = getBlockNBTNumber(world, BlockPos.containing(x, y, z), "lavasnu");
		itm0 = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy());
		if ((BuiltInRegistries.ITEM.getKey(itm0.getItem()).toString()).contains("phlogiston") && itm0.isDamaged() && snu >= 10) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("lavasnu", (snu - 10));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ServerLevel _level) {
				itm0.hurtAndBreak(-30, _level, null, _stkprov -> {
				});
			}
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = itm0.copy();
				_setstack.setCount(itm0.getCount());
				_itemHandlerModifiable.setStackInSlot(0, _setstack);
			}
		}
		if (RandomProcedure.execute(world, 0.01)) {
			range = 3;
			xyz = Math.round(0 - (range - 1) / 2);
			sx = xyz;
			found = false;
			for (int index1 = 0; index1 < (int) range; index1++) {
				sy = xyz;
				for (int index2 = 0; index2 < (int) range; index2++) {
					sz = xyz;
					for (int index3 = 0; index3 < (int) range; index3++) {
						if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.FIRE) {
							found = true;
						}
						sz = sz + 1;
					}
					sy = sy + 1;
				}
				sx = sx + 1;
			}
			if (found) {
				InduceddetonationProcedure.execute(world, x, y, z);
			}
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}

	private static int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank, Direction direction) {
		if (level instanceof ILevelExtension levelExtension) {
			IFluidHandler fluidHandler = levelExtension.getCapability(Capabilities.FluidHandler.BLOCK, pos, direction);
			if (fluidHandler != null)
				return fluidHandler.getFluidInTank(tank).getAmount();
		}
		return 0;
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
}