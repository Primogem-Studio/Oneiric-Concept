package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;

public class SkiplifeProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack zpitem = ItemStack.EMPTY;
		double ktime = 0;
		double index1 = 0;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
		for (int index0 = 0; index0 < 36; index0++) {
			zpitem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler ? _modHandler.getStackInSlot((int) index0).copy() : ItemStack.EMPTY);
			if (zpitem.getItem() == BuiltInRegistries.ITEM.get(ResourceLocation.parse("primogemcraft:xyzp")) && zpitem.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("dai_kai_jiang")) {
				ktime = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("k1");
				while (ktime < 24000) {
					index1 = index1 + 1;
					ktime = ktime + 1200;
					{
						final String _tagName = "k1";
						final double _tagValue = ktime;
						CustomData.update(DataComponents.CUSTOM_DATA, zpitem, tag -> tag.putDouble(_tagName, _tagValue));
					}
				}
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
					ItemStack _setstack = zpitem.copy();
					_setstack.setCount(zpitem.getCount());
					_modHandler.setStackInSlot((int) index0, _setstack);
				}
			}
		}
		SkipdamageProcedure.execute(world, entity, itemstack, index1);
	}
}
