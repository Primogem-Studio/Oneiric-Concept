package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.component.DataComponents;

public class SkiplifeProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack zpitem = ItemStack.EMPTY;
		double ktime = 0;
		double index1 = 0;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 20);
		if (entity instanceof LivingEntity _entity)
			_entity.removeAllEffects();
		for (int index0 = 0; index0 < 36; index0++) {
			zpitem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler3 ? _modHandler3.getStackInSlot((int) index0).copy() : ItemStack.EMPTY);
			if (zpitem.is(ItemTags.create(ResourceLocation.parse("oneiricconcept:canskip")))) {
				if (zpitem.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("dai_kai_jiang")) {
					SkipingProcedure.execute(world, entity, zpitem, index0, 24000, "k1");
				} else if (zpitem.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("sun_huai")) {
					SkipingProcedure.execute(world, entity, zpitem, index0, 6000, "wzsw");
				}
			}
		}
		SkipdamageProcedure.execute(world, entity, itemstack, true, index1);
	}
}