package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class WuqijinglianupProcedure {
	public static double execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return 0;
		ItemStack i1 = ItemStack.EMPTY;
		Entity e1 = null;
		i1 = itemstack;
		e1 = entity;
		return net.mcreator.ceshi.procedures.HSjinglianupProcedure.execute(e1, i1);
	}
}