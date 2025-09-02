package net.mcreator.oneiricconcept.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class AmbergrisCheeseSliverItem extends Item {
	public AmbergrisCheeseSliverItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(10).saturationModifier(0.7f).build()));
	}
}