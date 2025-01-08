
package net.mcreator.oneiricconcept.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class SweetSesameFillingYuanXiaoItem extends Item {
	public SweetSesameFillingYuanXiaoItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(10).saturationModifier(0.6f).build()));
	}
}
