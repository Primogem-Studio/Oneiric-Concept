package net.mcreator.oneiricconcept.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class StuffingItem extends Item {
	public StuffingItem() {
		super(new Item.Properties().fireResistant().food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.3f).build()));
	}
}