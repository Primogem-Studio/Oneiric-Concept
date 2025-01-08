
package net.mcreator.oneiricconcept.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class SaltDustItem extends Item {
	public SaltDustItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
