package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.oneiricconcept.init.OneiricconceptModGameRules;

public class SpirtbranchofTureLawTextProcedure {
	public static String execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		String itemname = "";
		String tran = "";
		double Refinement = 0;
		double xx = 0;
		double zz = 0;
		Refinement = WuqijinglianupProcedure.execute(entity, itemstack) + 1;
		tran = "translation.oneiricconcept.";
		itemname = "spirtbranchof_ture_law";
		itemname = tran + "" + itemname + "_";
		return PgcwuqiProcedure.execute(entity, itemstack, (("\u00A76\u00A7l\u00A7n" + Component.translatable((tran + "passive")).getString() + "\n") + "" + ("\u00A7e" + Component.translatable((itemname + "1")).getString())) + ""
				+ (entity.hasPermissions(4) ? "\n" + Component.translatable((itemname + "2")).getString() + "\n" : "\n")
				+ (("\u00A76\u00A7l\u00A7n" + Component.translatable((tran + "rightclick")).getString() + "\n") + ""
						+ ("\u00A7e" + Component.translatable((itemname + "3")).getString() + "\u00A7b" + new java.text.DecimalFormat("##.##").format(10 * Refinement) + "\u00A7e" + Component.translatable((itemname + "4")).getString() + "\u00A7b"
								+ new java.text.DecimalFormat("##.##").format(Math.max(0, 1200 - 100 * Refinement) / 20) + "\u00A7e" + Component.translatable((tran + "second")).getString()))
				+ "\n"
				+ (("\u00A76\u00A7l\u00A7n" + Component.translatable((tran + "sneaking_rightclick")).getString() + "\n") + ""
						+ ("\u00A7e" + Component.translatable((itemname + "5")).getString() + "\u00A7b"
								+ (new java.text.DecimalFormat("##.##")
										.format(((entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity10.getAttribute(Attributes.ATTACK_DAMAGE).getValue() : 0) * 1.2
												+ 5 * (world.getLevelData().getGameRules().getInt(OneiricconceptModGameRules.OC_HEALTHMULTIPLIER))) * Refinement))
								+ "\u00A7e" + Component.translatable((itemname + "6")).getString() + "\u00A7b" + new java.text.DecimalFormat("##.##").format(Math.max(0, 2000 - 200 * Refinement) / 20) + "\u00A7e"
								+ Component.translatable((tran + "second")).getString())));
	}
}