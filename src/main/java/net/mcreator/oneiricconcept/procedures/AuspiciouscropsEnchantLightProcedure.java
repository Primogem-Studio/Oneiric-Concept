package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class AuspiciouscropsEnchantLightProcedure {
	public static boolean execute(ItemStack itemstack) {
		ItemStack seed = ItemStack.EMPTY;
		double pow = 0;
		double seeds = 0;
		return itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("enable");
	}
}