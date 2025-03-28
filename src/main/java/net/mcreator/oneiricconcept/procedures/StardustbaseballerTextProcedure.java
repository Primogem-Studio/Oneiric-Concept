package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

public class StardustbaseballerTextProcedure {
	public static String execute(ItemStack itemstack) {
		double a = 0;
		String itemname = "";
		String tran = "";
		a = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian");
		tran = "translation.oneiricconcept.";
		itemname = "translation.oneiricconcept.";
		itemname = tran + "" + itemname + "_";
		return PgcwuqiProcedure.execute(itemstack, (("\u00A76\u00A7l\u00A7n" + Component.translatable((tran + "passive")).getString() + "\n") + ""
				+ ("\u00A7e" + (itemname + "1") + "\u00A7b" + new java.text.DecimalFormat("##.##").format(a) + "\u00A7e" + (itemname + "2") + "\u00A7b" + new java.text.DecimalFormat("##.##").format(a) + "\n" + "\u00A7e" + (itemname + "3")))
				+ ""
				+ (("\u00A76\u00A7l\u00A7n" + Component.translatable((tran + "rightclick")).getString() + "\n") + ""
						+ ("\u00A7e" + (itemname + "4") + "\u00A7b" + new java.text.DecimalFormat("##.##").format(a) + "\u00A7e" + (itemname + "5") + "\u00A7b" + new java.text.DecimalFormat("##.##").format(a) + "\n" + "\u00A7e" + (tran + "second")))
				+ (("\u00A76\u00A7l\u00A7n" + Component.translatable((tran + "leftclick")).getString() + "\n") + "" + ("\u00A7e" + (itemname + "6") + "\u00A7b" + new java.text.DecimalFormat("##.##").format(a) + "\u00A7e" + (itemname + "7")
						+ "\u00A7b" + new java.text.DecimalFormat("##.##").format(a) + "\n" + "\u00A7e" + (tran + "second"))));
	}
}
