package net.mcreator.oneiricconcept.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class IceFreshRawFrostweaveSalmonSlicesItem extends Item {
	public IceFreshRawFrostweaveSalmonSlicesItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(6).saturationModifier(0.3f).build()));
	}
}