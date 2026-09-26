package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class SkiplifeProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack zpitem = ItemStack.EMPTY;
		double index1 = 0;
		double denominator = 0;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 20);
		if (entity instanceof LivingEntity _entity)
			_entity.removeAllEffects();
		for (int _i1 = 0; _i1 < 36; _i1++) {
			zpitem = (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler3 ? _modHandler3.getStackInSlot((int) _i1).copy() : ItemStack.EMPTY).copy();
			if (zpitem.is(ItemTags.create(ResourceLocation.parse("oneiricconcept:canskip")))) {
				if (zpitem.is(ItemTags.create(ResourceLocation.parse("oneiricconcept:canskip/ticket_progress")))) {
					index1 = index1 + SkipingProcedure.execute(world, entity, zpitem, _i1, 24000, "primogemcraft:ticket_progress");
				} else if (zpitem.is(ItemTags.create(ResourceLocation.parse("oneiricconcept:canskip/numerator")))) {
					final net.minecraft.world.item.ItemStack _coin = zpitem;
					final net.per.primogemcraft.component.CustomBar _bar = _coin.get(net.per.primogemcraft.registry.PGCDataComponents.CUSTOM_BAR.get());
					final int _max = _bar != null ? _bar.denominator() : 0;
					final int _now = _bar != null ? _bar.numerator() : 0;
					denominator = _max > 0 ? _max : itemstack.getOrDefault(net.minecraft.core.component.DataComponents.CUSTOM_DATA, net.minecraft.world.item.component.CustomData.EMPTY).copyTag().getDouble("denominator");
					// 让 Skiping 从真实进度起算，cost(index1) 才等于“剩余进度/1200”
					if (_max > 0)
						net.minecraft.world.item.component.CustomData.update(net.minecraft.core.component.DataComponents.CUSTOM_DATA, _coin, tag -> tag.putDouble("numerator", (double) _now));
					// 把 PMC 的进度条一次填满：下一次 presence tick 就会 progress(0, interval) → burst + spend(integrity)
					if (_max > 0 && _now < _max)
						_coin.set(net.per.primogemcraft.registry.PGCDataComponents.CUSTOM_BAR.get(), new net.per.primogemcraft.component.CustomBar(_max, _max, _bar.visible()));
					index1 = index1 + SkipingProcedure.execute(world, entity, zpitem, _i1, denominator, "numerator");
				} else if (zpitem.is(ItemTags.create(ResourceLocation.parse("oneiricconcept:canskip/curio_counter")))) {
					index1 = index1 + SkipingProcedure.execute(world, entity, zpitem, _i1, 99, "primogemcraft:curio_counter");
				}
			}
		}
		SkipdamageProcedure.execute(world, entity, itemstack, true, index1);
	}
}