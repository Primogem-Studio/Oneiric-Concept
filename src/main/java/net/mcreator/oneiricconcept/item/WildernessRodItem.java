
package net.mcreator.oneiricconcept.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.FishingRodItem;

public class WildernessRodItem extends FishingRodItem {
	public WildernessRodItem() {
		super(new Item.Properties().durability(160));
	}

	@Override
	public boolean isValidRepairItem(ItemStack itemstack, ItemStack repairitem) {
		return Ingredient.of(new ItemStack(Items.STICK)).test(repairitem);
	}

	@Override
	public int getEnchantmentValue() {
		return 7;
	}
}
