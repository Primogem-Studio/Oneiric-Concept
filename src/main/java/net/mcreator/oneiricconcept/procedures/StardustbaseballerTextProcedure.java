package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

public class StardustbaseballerTextProcedure {
	public static String execute(ItemStack itemstack) {
		double a = 0;
		String nametext = "";
		a = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian");
		nametext = "stardust_baseballer";
		nametext = "translation.oneiricconcept." + nametext + "_";
		return PgcwuqiProcedure.execute(itemstack,
				(("\u00A76\u00A7l\u00A7n" + Component.translatable("translation.oneiricconcept.passive").getString()) + "\n"
						+ ("\u00A7e" + Component.translatable((nametext + "1")).getString() + "\u00A7b" + new java.text.DecimalFormat("##.##").format(a) + "\u00A7e" + Component.translatable((nametext + "2")).getString()))
						+ ""
						+ (("\u00A76\u00A7l\u00A7n" + Component.translatable("translation.oneiricconcept.rightclick").getString()) + "\n"
								+ ("\u00A7e" + Component.translatable((nametext + "1")).getString() + "\u00A7b" + new java.text.DecimalFormat("##.##").format(a) + "\u00A7e" + Component.translatable((nametext + "2")).getString()))
						+ (("\u00A76\u00A7l\u00A7n" + Component.translatable("translation.oneiricconcept.leftclick").getString()) + "\n"
								+ ("\u00A7e" + Component.translatable((nametext + "1")).getString() + "\u00A7b" + new java.text.DecimalFormat("##.##").format(a) + "\u00A7e" + Component.translatable((nametext + "2")).getString())));
	}
}
