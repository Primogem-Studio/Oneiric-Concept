package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

public class AuspiciouscropsTipProcedure {
	public static String execute(ItemStack itemstack) {
		ItemStack seed = ItemStack.EMPTY;
		double pow = 0;
		double seeds = 0;
		return Component.translatable("item.oneiricconcept.human_height_auspicious_crops.description_0").getString() + "\n"
				+ (AuspiciouscropsEnchantLightProcedure.execute(itemstack) ? "" : Component.translatable("item.oneiricconcept.human_height_auspicious_crops.description_1").getString());
	}
}