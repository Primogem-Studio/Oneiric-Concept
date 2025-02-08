
package net.mcreator.oneiricconcept.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.FishingRodItem;

public class WildernessRodItem extends FishingRodItem {
	public WildernessRodItem() {
		super(new Item.Properties().durability(100));
	}

	@Override
	public int getEnchantmentValue() {
		return 13;
	}
}
