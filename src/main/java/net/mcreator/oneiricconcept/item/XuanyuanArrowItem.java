
package net.mcreator.oneiricconcept.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;

import net.mcreator.oneiricconcept.procedures.XuanyuanarrowgetProcedure;

public class XuanyuanArrowItem extends Item {
	public XuanyuanArrowItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public void onCraftedBy(ItemStack itemstack, Level world, Player entity) {
		super.onCraftedBy(itemstack, world, entity);
		XuanyuanarrowgetProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}
