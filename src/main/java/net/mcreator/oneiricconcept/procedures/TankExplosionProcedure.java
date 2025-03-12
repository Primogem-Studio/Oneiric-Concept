package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class TankExplosionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double lvl = 0;
		double Inventorynu = 0;
		lvl = getFluidTankLevel(world, BlockPos.containing(x, y, z), 1, null) / 2000;
		lvl = lvl + getBlockNBTNumber(world, BlockPos.containing(x, y, z), "lavasnu") / 80;
		Inventorynu = 2;
		for (int index0 = 0; index0 < 9; index0++) {
			lvl = lvl + itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) Inventorynu).getCount();
			Inventorynu = Inventorynu + 1;
		}
		OverlimitExplosionProcedure.execute(world, x, y, z, lvl);
	}

	private static int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank, Direction direction) {
		if (level instanceof ILevelExtension levelExtension) {
			IFluidHandler fluidHandler = levelExtension.getCapability(Capabilities.FluidHandler.BLOCK, pos, direction);
			if (fluidHandler != null)
				return fluidHandler.getFluidInTank(tank).getAmount();
		}
		return 0;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
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
