package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class PgcwuqiProcedure {
	public static String execute(Entity entity, ItemStack itemstack, String miaoshu) {
		if (entity == null || miaoshu == null)
			return "";
		Entity e1 = null;
		String s1 = "";
		ItemStack i1 = ItemStack.EMPTY;
		e1 = entity;
		i1 = itemstack;
		s1 = miaoshu;
		return net.mcreator.ceshi.procedures.MSHSwuqi00Procedure.execute(e1, i1, s1);
	}
}