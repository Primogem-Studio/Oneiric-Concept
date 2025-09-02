package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

public class ByzxmsProcedure {
	public static String execute(ItemStack itemstack) {
		double itemmode = 0;
		String s0 = "";
		String s1 = "";
		itemmode = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("mode");
		s0 = "\u00A7e\u00A7l";
		if (itemmode == 0) {
			s1 = (s0 + "\u6D77\u6D0B\u4E4B\u5FC3") + "\n" + "\u00A76\u6301\u7EED\u7184\u706D\u8EAB\u4E0A\u706B\u7130\uFF0C\u5E76\u4E14\u6301\u7EED\u7ED9\u4E88\u6F6E" + "\n"
					+ "\u00A76\u6D8C\u80FD\u91CF\u548C\u6D77\u8C5A\u7684\u9988\u8D60\u72B6\u6001\u6548\u679C\uFF0C\u53F3\u51FB" + "\n" + "\u00A76\u653E\u7F6E\u6C34\u6E90\u3002";
		} else if (itemmode == 1) {
			s1 = (s0 + "" + Component.translatable("item.oneiricconcept.heartofthefrozensea").getString()) + "\n" + DyzxmsProcedure.execute();
		} else if (itemmode == 2) {
			s1 = (s0 + "" + Component.translatable("item.oneiricconcept.heartoftheskysea").getString()) + "\n" + KyzxmsProcedure.execute();
		} else if (itemmode == 3) {
			s1 = (s0 + "" + Component.translatable("item.oneiricconcept.heartofthewarmsea").getString()) + "\n" + NyzxmsProcedure.execute();
		} else {
			s1 = (s0 + "" + Component.translatable("item.oneiricconcept.heartofthefish").getString()) + "\n" + HyyxmsProcedure.execute();
		}
		return Diaoyongshift0Procedure.execute("\u00A7d\u00A7l\u6F5C\u884C\u5DE6\u952E\u4EE5\u5207\u6362\u5F62\u6001" + "\n" + s1, "\u8BE6\u60C5");
	}
}