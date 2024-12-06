
package net.mcreator.oneiricconcept.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class LessRedstonePowderItem extends Item {
	public LessRedstonePowderItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
