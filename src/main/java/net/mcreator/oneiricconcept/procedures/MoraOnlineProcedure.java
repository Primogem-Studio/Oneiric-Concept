package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;

public class MoraOnlineProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		ItemStack Litm = ItemStack.EMPTY;
		Litm = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
		return Litm.is(ItemTags.create(ResourceLocation.parse("oneiricconcept:magazine2"))) || Litm.is(ItemTags.create(ResourceLocation.parse("oneiricconcept:magazine1")))
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == OneiricconceptModItems.BOSS_STONE_COIN_GUN_PLUS.get()
						&& (Litm.is(ItemTags.create(ResourceLocation.parse("oneiricconcept:magazine"))) || Litm.getItem() == OneiricconceptModItems.XUANYUAN_ARROW.get());
	}
}
