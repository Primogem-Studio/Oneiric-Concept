package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;

public class AntimatterLegionLootProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		ItemStack itmsstk = ItemStack.EMPTY;
		double EquilibriumLevel = 0;
		double lootingAndLuck = 0;
		if (sourceentity instanceof Player) {
			EquilibriumLevel = JunHengDengJiProcedure.execute(sourceentity);
			lootingAndLuck = Math.max((sourceentity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.LUCK) ? _livingEntity1.getAttribute(Attributes.LUCK).getValue() : 0) * 0.2
					+ (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) * 0.2, 10);
			if (0 < EquilibriumLevel) {
				for (int index0 = 0; index0 < (int) Math.ceil(EquilibriumLevel * (EquilibriumLevel + 1)); index0++) {
					if (RandomProcedure.execute(world, 0.2 * EquilibriumLevel)) {
						itmsstk = (RandomProcedure.execute(world, 0.1 * EquilibriumLevel) ? new ItemStack(OneiricconceptModItems.CONQUEROR_S_WILL.get()) : new ItemStack(OneiricconceptModItems.USURPER_S_SCHEME.get()));
					} else {
						if (!world.isClientSide() && world.getServer() != null) {
							for (ItemStack itemstackiterator : world.getServer().reloadableRegistries().getLootTable(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.parse("oneiricconcept:entities/baryon")))
									.getRandomItems(new LootParams.Builder((ServerLevel) world).create(LootContextParamSets.EMPTY))) {
								itmsstk = itemstackiterator;
							}
						}
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itmsstk);
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(OneiricconceptModItems.THIEF_S_INSTINCT.get()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}
}