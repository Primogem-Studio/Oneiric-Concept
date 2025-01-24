
package net.mcreator.oneiricconcept.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class PhlogistonCrystalItem extends Item {
	public PhlogistonCrystalItem() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.COMMON));
	}
}
