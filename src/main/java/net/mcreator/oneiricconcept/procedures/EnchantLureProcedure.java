package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;

public class EnchantLureProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		ItemStack roditem = ItemStack.EMPTY;
		ItemStack baitem = ItemStack.EMPTY;
		boolean EnchantLevelUp = false;
		double enchantlevel = 0;
		double lurelevel = 0;
		double levelupdemand = 0;
		double delitem = 0;
		roditem = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
		baitem = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		enchantlevel = roditem.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LURE));
		if (roditem.is(ItemTags.create(ResourceLocation.parse("minecraft:enchantable/fishing"))) && entity.isShiftKeyDown()
				&& !(entity.level()
						.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
								(entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(Attributes.BLOCK_INTERACTION_RANGE) ? _livingEntity5.getAttribute(Attributes.BLOCK_INTERACTION_RANGE).getValue() : 0))),
								ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getType() == HitResult.Type.BLOCK)) {
			{
				final String _tagName = "lure";
				final double _tagValue = (roditem.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("lure") + baitem.getCount());
				CustomData.update(DataComponents.CUSTOM_DATA, roditem, tag -> tag.putDouble(_tagName, _tagValue));
			}
			lurelevel = roditem.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("lure");
			levelupdemand = Math.pow(2, enchantlevel + 7);
			delitem = baitem.getCount();
			if (enchantlevel >= 5) {
				{
					final String _tagName = "lure";
					final double _tagValue = 0;
					CustomData.update(DataComponents.CUSTOM_DATA, roditem, tag -> tag.putDouble(_tagName, _tagValue));
				}
				delitem = 0;
			} else if (lurelevel >= levelupdemand) {
				EnchantLevelUp = true;
			}
			baitem.shrink((int) delitem);
			if (EnchantLevelUp) {
				roditem.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LURE), (int) (enchantlevel + 1));
				{
					final String _tagName = "lure";
					final double _tagValue = (lurelevel - levelupdemand);
					CustomData.update(DataComponents.CUSTOM_DATA, roditem, tag -> tag.putDouble(_tagName, _tagValue));
				}
			}
			if (EnchantLevelUp) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("translation.oneiricconcept.lurelevelup").getString())), true);
			} else if (enchantlevel < 5) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("translation.oneiricconcept.lure").getString() + "\u00A7e" + roditem.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("lure")
							+ "\u00A7r/\u00A7d" + Math.pow(2, enchantlevel + 7))), true);
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((Component.translatable("translation.oneiricconcept.lurelevelmax").getString())), true);
			}
		}
	}
}
