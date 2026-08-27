package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class JanusDataProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ItemStack slate = ItemStack.EMPTY;
		double xx = 0;
		double yy = 0;
		double zz = 0;
		slate = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy());
		xx = slate.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("STX");
		yy = slate.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("STY");
		zz = slate.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("STZ");
		if (!(slate.getItem() == ItemStack.EMPTY.getItem())) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("tx", xx);
					_blockEntity.getPersistentData().putDouble("ty", yy);
					_blockEntity.getPersistentData().putDouble("tz", zz);
					_blockEntity.getPersistentData().putBoolean("isData", true);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
				_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = slate.copy();
				_setstack.setCount(1);
				_itemHandlerModifiable.setStackInSlot(1, _setstack);
			}
			if (Math.abs(zz - z) <= Math.abs(xx - x)) {
				if (0 < xx - x) {
					{
						Direction _dir = Direction.WEST;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
							world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
						} else {
							_property = _bs.getBlock().getStateDefinition().getProperty("axis");
							if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
								world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
						}
					}
				} else {
					{
						Direction _dir = Direction.EAST;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
							world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
						} else {
							_property = _bs.getBlock().getStateDefinition().getProperty("axis");
							if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
								world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
						}
					}
				}
			} else {
				if (0 < zz - z) {
					{
						Direction _dir = Direction.NORTH;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
							world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
						} else {
							_property = _bs.getBlock().getStateDefinition().getProperty("axis");
							if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
								world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
						}
					}
				} else {
					{
						Direction _dir = Direction.SOUTH;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
							world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
						} else {
							_property = _bs.getBlock().getStateDefinition().getProperty("axis");
							if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
								world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
						}
					}
				}
			}
		}
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