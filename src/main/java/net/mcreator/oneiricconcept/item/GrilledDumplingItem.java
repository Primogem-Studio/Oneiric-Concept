package net.mcreator.oneiricconcept.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class GrilledDumplingItem extends Item {
	public GrilledDumplingItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(12).saturationModifier(0.7f).alwaysEdible().build()));
	}
}