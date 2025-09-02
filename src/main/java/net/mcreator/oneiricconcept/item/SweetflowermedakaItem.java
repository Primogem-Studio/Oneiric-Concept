package net.mcreator.oneiricconcept.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class SweetflowermedakaItem extends Item {
	public SweetflowermedakaItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(6).saturationModifier(0.3f).build()));
	}
}