package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class GetDoubleNBTTagProcedure {
	public static double execute(ItemStack itemstack, String tagname) {
		if (tagname == null)
			return 0;
		return itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble(tagname);
	}
}
