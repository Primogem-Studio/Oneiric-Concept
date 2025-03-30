package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;

public class CrystalgeneratoritemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ItemStack crystal = ItemStack.EMPTY;
		double crystal_power = 0;
		String pgc = "";
		boolean iscrystals = false;
		pgc = "primogemcraft:";
		for (int index0 = 0; index0 < 7; index0++) {
			crystal = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) index0).copy());
			if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
				if (!world.isClientSide() && world.getServer() != null)
					world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u5728\u7B2C" + index0 + "\u683C\u7684\u7269\u54C1\uFF1A" + crystal)), false);
			}
			if (!(crystal == ItemStack.EMPTY)) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					int _slotid = (int) index0;
					ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
					_stk.shrink(1);
					_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
				}
				break;
			}
		}
		crystal_power = CrystalgeneratorListProcedure.execute(crystal);
		if (world.getLevelData().getGameRules().getBoolean(OneiricconceptModGameRules.OCDEBUG)) {
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u5411\u53D1\u7535\u6D41\u7A0B\u4F20\u8F93\u7535\u529B\uFF1A" + crystal_power + "\u7269\u54C1\uFF1A" + crystal)), false);
		}
		CrystalgeneratorpowerProcedure.execute(world, x, y, z, crystal_power);
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
