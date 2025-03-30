package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import java.util.Locale;
import java.util.List;
import java.util.ArrayList;

public class CrystalgeneratorListProcedure {
	public static double execute(ItemStack itemstack) {
		ItemStack crystal = ItemStack.EMPTY;
		double crystal_power = 0;
		String pgc = "";
		boolean iscrystals = false;
		pgc = "primogemcraft:";
		crystal = itemstack;
		List<Object> list16000 = new ArrayList<>(List.of(BuiltInRegistries.ITEM.get(ResourceLocation.parse(pgc + "zuishengduanpian").toLowerCase(Locale.ENGLISH)), CUSTOM.PgcPg,
				BuiltInRegistries.ITEM.get(ResourceLocation.parse(pgc + "disui").toLowerCase(Locale.ENGLISH)), BuiltInRegistries.ITEM.get(ResourceLocation.parse(pgc + "yhjsl").toLowerCase(Locale.ENGLISH)),
				BuiltInRegistries.ITEM.get(ResourceLocation.parse(pgc + "jlliang").toLowerCase(Locale.ENGLISH)), BuiltInRegistries.ITEM.get(ResourceLocation.parse(pgc + "yuanshi").toLowerCase(Locale.ENGLISH))));
		List<Object> list64000 = new ArrayList<>(List.of(CUSTOM.PhlogistonCrystal, BuiltInRegistries.ITEM.get(ResourceLocation.parse(pgc + "zuishengkuai").toLowerCase(Locale.ENGLISH)), CUSTOM.HonkaiSliver,
				BuiltInRegistries.ITEM.get(ResourceLocation.parse(pgc + "laoshi").toLowerCase(Locale.ENGLISH)), BuiltInRegistries.ITEM.get(ResourceLocation.parse(pgc + "chuangshijiejing").toLowerCase(Locale.ENGLISH))));
		List<Object> list160000 = new ArrayList<>(List.of(CUSTOM.Elect1, BuiltInRegistries.ITEM.get(ResourceLocation.parse(pgc + "yhjs").toLowerCase(Locale.ENGLISH))));
		List<Object> list1600000 = new ArrayList<>(List.of(CUSTOM.HonkaiShard, BuiltInRegistries.ITEM.get(ResourceLocation.parse(pgc + "zuishengzijing").toLowerCase(Locale.ENGLISH))));
		if (list16000.contains(crystal)) {
			crystal_power = 16000;
		} else if (list64000.contains(crystal)) {
			crystal_power = 64000;
		} else if (list160000.contains(crystal)) {
			crystal_power = 160000;
		} else if (list1600000.contains(crystal)) {
			crystal_power = 1600000;
		} else if (crystal.is(ItemTags.create(ResourceLocation.parse("c::crystals")))) {
			crystal_power = 1600;
		}
		return crystal_power;
	}
}
