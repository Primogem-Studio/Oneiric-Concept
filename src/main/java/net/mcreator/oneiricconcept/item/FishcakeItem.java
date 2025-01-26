
package net.mcreator.oneiricconcept.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class FishcakeItem extends Item {
	public FishcakeItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(8).saturationModifier(0.3f).build()));
	}
}
