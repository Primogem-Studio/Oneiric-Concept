package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

public class StardustbaseballerTextProcedure {
	public static String execute(ItemStack itemstack) {
		double Refinement = 0;
		String itemname = "";
		String tran = "";
		Refinement = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian");
		tran = "translation.oneiricconcept.";
		itemname = "stardust_baseballer";
		itemname = tran + "" + itemname + "_";
		return PgcwuqiProcedure.execute(itemstack,
				(("\u00A76\u00A7l\u00A7n" + Component.translatable((tran + "passive")).getString() + "\n") + ""
						+ ("\u00A7e" + Component.translatable((itemname + "1")).getString() + "\u00A7b" + new java.text.DecimalFormat("##.##").format(4 + Refinement * 1) + "\u00A7e" + Component.translatable((itemname + "2")).getString() + "\u00A7b"
								+ new java.text.DecimalFormat("##.##").format(16 + Refinement * 4) + "\u00A7e" + Component.translatable((itemname + "3")).getString()))
						+ "\n"
						+ (("\u00A76\u00A7l\u00A7n" + Component.translatable((tran + "rightclick")).getString() + "\n") + ""
								+ ("\u00A7e" + Component.translatable((itemname + "4")).getString() + "\u00A7b" + new java.text.DecimalFormat("##.##").format(300 + Refinement * 75) + "\u00A7e" + Component.translatable((itemname + "5")).getString()
										+ "\u00A7b" + new java.text.DecimalFormat("##.##").format(600 * (1 - 0.1 * Refinement)) + "\u00A7e" + Component.translatable((tran + "second")).getString()))
						+ "\n"
						+ (("\u00A76\u00A7l\u00A7n" + Component.translatable((tran + "leftclick")).getString() + "\n") + ""
								+ ("\u00A7e" + Component.translatable((itemname + "6")).getString() + "\u00A7b" + new java.text.DecimalFormat("##.##").format(4 + Refinement) + "\u00A7e" + Component.translatable((itemname + "7")).getString()
										+ "\u00A7b" + new java.text.DecimalFormat("##.##").format(100 * (1 - 0.1 * Refinement)) + "\u00A7e" + Component.translatable((tran + "second")).getString())));
	}
}
