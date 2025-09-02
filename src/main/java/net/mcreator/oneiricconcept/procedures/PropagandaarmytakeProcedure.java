package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

public class PropagandaarmytakeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, double nu) {
		ItemStack item = ItemStack.EMPTY;
		if (!world.isClientSide() && world.getServer() != null) {
			for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.parse("oneiricconcept:entities/publiccc")))
					.getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY))) {
				itemstackiterator.setCount((int) nu);
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 1), (z + 0.5), itemstackiterator);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}