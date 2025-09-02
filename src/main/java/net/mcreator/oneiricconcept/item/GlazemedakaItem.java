package net.mcreator.oneiricconcept.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class GlazemedakaItem extends Item {
	public GlazemedakaItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(6).saturationModifier(0.3f).build()));
	}
}