package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

public class Liheshuxhs2Procedure {
	public static ItemStack execute(String si1) {
		if (si1 == null)
			return ItemStack.EMPTY;
		return new ItemStack((BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse((si1).toLowerCase(java.util.Locale.ENGLISH)))).getRandomElement(RandomSource.create())
				.orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()));
	}
}