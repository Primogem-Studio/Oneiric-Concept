package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

public class LiheshuxhsProcedure {
	public static ItemStack execute(LevelAccessor world, String ss1) {
		if (ss1 == null)
			return ItemStack.EMPTY;
		ItemStack i1 = ItemStack.EMPTY;
		if (!world.isClientSide() && world.getServer() != null) {
			for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.parse((ss1).toLowerCase(java.util.Locale.ENGLISH))))
					.getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY))) {
				i1 = itemstackiterator;
			}
		}
		return i1;
	}
}