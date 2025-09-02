package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class FishdifficultyProcedure {
	public static void execute(Entity entity, ItemStack fishs) {
		if (entity == null)
			return;
		if (fishs.is(ItemTags.create(ResourceLocation.parse("oneiricconcept:fish_very_easy")))) {
			FishingoperateProcedure.execute(entity, fishs);
		} else if (fishs.is(ItemTags.create(ResourceLocation.parse("oneiricconcept:fish_easy")))) {
			FishingoperateProcedure.execute(entity, fishs);
		}
	}
}