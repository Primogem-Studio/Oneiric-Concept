package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

public class FruitpastebaitFishProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		FishdifficultyProcedure.execute(entity, new ItemStack(
				BuiltInRegistries.ITEM.getOrCreateTag(ItemTags.create(ResourceLocation.parse("oneiricconcept:fruit_paste_bait_fish"))).getRandomElement(RandomSource.create()).orElseGet(() -> BuiltInRegistries.ITEM.wrapAsHolder(Items.AIR)).value()));
	}
}
