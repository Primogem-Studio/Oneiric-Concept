package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;

public class HearticeProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		String name = "";
		String itemname = "";
		itemname = new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(((BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH)))).getDisplayName().getString();
		if ((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("ice")).equals("minecraft:frosted_ice")) {
			{
				final String _tagName = "ice";
				final String _tagValue = "minecraft:blue_ice";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			name = itemname + "\uFF08" + Component.translatable("block.minecraft.blue_ice").getString() + "\uFF09";
		} else if ((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("ice")).equals("minecraft:blue_ice")) {
			{
				final String _tagName = "ice";
				final String _tagValue = "off";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			name = "off";
		} else {
			{
				final String _tagName = "ice";
				final String _tagValue = "minecraft:frosted_ice";
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			name = itemname + "\uFF08" + Component.translatable("block.minecraft.frosted_ice").getString() + "\uFF09";
		}
		if ((name).equals("off")) {
			EnchantmentHelper.updateEnchantments(itemstack, mutableEnchantments -> mutableEnchantments.removeIf(enchantment -> enchantment.is(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FROST_WALKER))));
		} else {
			itemstack.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FROST_WALKER), 4);
		}
		itemstack.set(DataComponents.CUSTOM_NAME, Component.literal(name));
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("\u00A7e" + name)), true);
	}
}
