package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;
import net.mcreator.oneiricconcept.init.OneiricconceptModBlocks;

public class CrystalgeneratorListProcedure {
	public static double execute(ItemStack itemstack) {
		double crystal_power = 0;
		boolean iscrystals = false;
		ItemStack crystal = ItemStack.EMPTY;
		ItemStack listitem = ItemStack.EMPTY;
		crystal = itemstack;
		if (OneiricconceptModBlocks.PRIMOGEM.get().asItem() == crystal.getItem() || BuiltInRegistries.ITEM.get(ResourceLocation.parse("primogemcraft:yuanshi")) == crystal.getItem()
				|| BuiltInRegistries.ITEM.get(ResourceLocation.parse("primogemcraft:disui")) == crystal.getItem() || BuiltInRegistries.ITEM.get(ResourceLocation.parse("primogemcraft:zuishengduanpian")) == crystal.getItem()
				|| BuiltInRegistries.ITEM.get(ResourceLocation.parse("primogemcraft:yhjsl")) == crystal.getItem() || BuiltInRegistries.ITEM.get(ResourceLocation.parse("primogemcraft:jlliang")) == crystal.getItem()) {
			crystal_power = 16000;
		} else if (OneiricconceptModItems.HONKAI_SLIVER.get() == crystal.getItem() || OneiricconceptModItems.PHLOGISTON_CRYSTAL.get() == crystal.getItem()
				|| BuiltInRegistries.ITEM.get(ResourceLocation.parse("primogemcraft:zuishengkuai")) == crystal.getItem() || BuiltInRegistries.ITEM.get(ResourceLocation.parse("primogemcraft:laoshi")) == crystal.getItem()
				|| BuiltInRegistries.ITEM.get(ResourceLocation.parse("primogemcraft:chuangshijiejing")) == crystal.getItem() || OneiricconceptModItems.ONEIRIC_SHARD.get() == crystal.getItem()) {
			crystal_power = 64000;
		} else if (BuiltInRegistries.ITEM.get(ResourceLocation.parse("primogemcraft:yhjs")) == crystal.getItem() || OneiricconceptModBlocks.ELECTRO_METAL.get().asItem() == crystal.getItem()) {
			crystal_power = 160000;
		} else if (OneiricconceptModItems.HONKAI_SHARD.get() == crystal.getItem() || BuiltInRegistries.ITEM.get(ResourceLocation.parse("primogemcraft:zuishengzijing")) == crystal.getItem()) {
			crystal_power = 1600000;
		} else if (crystal.is(ItemTags.create(ResourceLocation.parse("c:crystals")))) {
			crystal_power = 160;
		}
		return crystal_power;
	}
}
