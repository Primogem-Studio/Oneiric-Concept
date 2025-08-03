package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;

public class MoraOnlineProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		ItemStack Litm = ItemStack.EMPTY;
		String lvl = "";
		String primogem = "";
		Litm = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
		lvl = Litm.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("level");
		primogem = "primogemcraft:";
		return (lvl).equals(primogem + "mmola_01") || (lvl).equals(primogem + "jinzhimola")
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == OneiricconceptModItems.BOSS_STONE_COIN_GUN_PLUS.get() && (lvl).equals(primogem + "mljnb");
	}
}