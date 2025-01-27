package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;

public class WayfareCutProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		ItemStack itmstk = ItemStack.EMPTY;
		itmstk = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
		if (itmstk.is(ItemTags.create(ResourceLocation.parse("minecraft:swords"))) || itmstk.is(ItemTags.create(ResourceLocation.parse("c:tools/knife")))) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(OneiricconceptModItems.WAYFARE_CAKE_SLICES.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (world instanceof ServerLevel _level) {
				itmstk.hurtAndBreak(20, _level, null, _stkprov -> {
				});
			}
		}
	}
}
