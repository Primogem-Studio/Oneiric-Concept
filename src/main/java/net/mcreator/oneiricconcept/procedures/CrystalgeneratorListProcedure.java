package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class CrystalgeneratorListProcedure {
	public static double execute(ItemStack itemstack) {
		double crystal_power = 0;
		boolean iscrystals = false;
		ItemStack crystal = ItemStack.EMPTY;
		ItemStack listitem = ItemStack.EMPTY;
		crystal = itemstack;
		if (crystal.is(ItemTags.create(ResourceLocation.parse("oneiricconcept:crystals1")))) {
			crystal_power = 16000;
		} else if (crystal.is(ItemTags.create(ResourceLocation.parse("oneiricconcept:crystals2")))) {
			crystal_power = 64000;
		} else if (crystal.is(ItemTags.create(ResourceLocation.parse("oneiricconcept:crystals3")))) {
			crystal_power = 160000;
		} else if (crystal.is(ItemTags.create(ResourceLocation.parse("oneiricconcept:crystals4")))) {
			crystal_power = 1600000;
		} else if (crystal.is(ItemTags.create(ResourceLocation.parse("c:crystals")))) {
			crystal_power = 160;
		}
		return crystal_power;
	}
}