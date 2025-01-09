package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;

public class ModevastProcedure {
	public static void execute(ItemStack itemstack) {
		double itemmode = 0;
		itemmode = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("mode");
		if (3 <= itemmode) {
			itemmode = itemmode + 1;
			itemstack.set(DataComponents.CUSTOM_NAME,
					Component.literal((new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(((BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH)))).getDisplayName().getString())));
		} else {
			itemmode = 0;
		}
		{
			final String _tagName = "mode";
			final double _tagValue = itemmode;
			CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
		}
	}
}
