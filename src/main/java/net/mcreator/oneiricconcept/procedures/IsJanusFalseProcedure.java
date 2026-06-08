package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.item.ItemStack;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;

public class IsJanusFalseProcedure {
	public static boolean execute(ItemStack itemstack) {
		return !(OneiricconceptModItems.JANUS_SLATE.get() == itemstack.getItem());
	}
}