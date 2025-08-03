package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModMenus;

public class TankAddLvaTagProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double tms = 0;
		double itms = 0;
		double itms2 = 0;
		itms2 = getAmountInGUISlot(entity, 1);
		if (getFluidTankLevel(world, BlockPos.containing(x, y, z), 1, null) <= 9000) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof OneiricconceptModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.LAVA_BUCKET) {
				if (entity instanceof Player _player && _player.containerMenu instanceof OneiricconceptModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(0).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (16 <= itms2) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				} else {
					if (entity instanceof Player _player && _player.containerMenu instanceof OneiricconceptModMenus.MenuAccessor _menu) {
						ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
						_setstack.setCount((int) (itms2 + 1));
						_menu.getSlots().get(1).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				}
				if (world instanceof ILevelExtension _ext) {
					IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
					if (_fluidHandler != null)
						_fluidHandler.fill(new FluidStack(Fluids.LAVA, 1000), IFluidHandler.FluidAction.EXECUTE);
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof OneiricconceptModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.MAGMA_BLOCK.asItem()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof OneiricconceptModMenus.MenuAccessor _menu10 ? _menu10.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Items.MAGMA_CREAM) {
				for (int index0 = 0; index0 < getAmountInGUISlot(entity, 0) + 1; index0++) {
					if (getFluidTankLevel(world, BlockPos.containing(x, y, z), 1, null) <= 9000 || 1 <= getAmountInGUISlot(entity, 1)) {
						if (entity instanceof Player _player && _player.containerMenu instanceof OneiricconceptModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(1);
							_player.containerMenu.broadcastChanges();
						}
						if (world instanceof ILevelExtension _ext) {
							IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
							if (_fluidHandler != null)
								_fluidHandler.fill(new FluidStack(Fluids.LAVA, 1000), IFluidHandler.FluidAction.EXECUTE);
						}
					} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof OneiricconceptModMenus.MenuAccessor _menu17 ? _menu17.getSlots().get(0).getItem() : ItemStack.EMPTY)
							.getItem() == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof OneiricconceptModMenus.MenuAccessor _menu18 ? _menu18.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem()
							&& getAmountInGUISlot(entity, 1) <= 64 || getAmountInGUISlot(entity, 1) <= 0) {
						if (entity instanceof Player _player && _player.containerMenu instanceof OneiricconceptModMenus.MenuAccessor _menu) {
							ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof OneiricconceptModMenus.MenuAccessor _menu23 ? _menu23.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
							_setstack.setCount(getAmountInGUISlot(entity, 0));
							_menu.getSlots().get(1).set(_setstack);
							_player.containerMenu.broadcastChanges();
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof OneiricconceptModMenus.MenuAccessor _menu) {
							_menu.getSlots().get(0).remove(getAmountInGUISlot(entity, 0));
							_player.containerMenu.broadcastChanges();
						}
					} else {
						if (entity instanceof Player _player) {
							ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof OneiricconceptModMenus.MenuAccessor _menu27 ? _menu27.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					}
				}
			}
		}
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof OneiricconceptModMenus.MenuAccessor menuAccessor) {
			ItemStack stack = menuAccessor.getSlots().get(sltid).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}

	private static int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank, Direction direction) {
		if (level instanceof ILevelExtension levelExtension) {
			IFluidHandler fluidHandler = levelExtension.getCapability(Capabilities.FluidHandler.BLOCK, pos, direction);
			if (fluidHandler != null)
				return fluidHandler.getFluidInTank(tank).getAmount();
		}
		return 0;
	}
}