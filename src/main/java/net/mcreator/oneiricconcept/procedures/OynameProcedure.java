package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class OynameProcedure {
	public static String execute(ItemStack itemstack) {
		return itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("die");
	}
}
