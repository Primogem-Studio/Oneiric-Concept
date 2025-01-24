package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;

public class PhlogistonCoreFillProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double fil = 0;
		fil = 2;
		for (int index0 = 0; index0 < 9; index0++) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = new ItemStack(OneiricconceptModItems.PHLOGISTON_CRYSTAL.get()).copy();
				_setstack.setCount(64);
				_itemHandlerModifiable.setStackInSlot((int) fil, _setstack);
			}
			fil = 1 + fil;
		}
	}
}
