package net.mcreator.oneiricconcept.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class Geomarrowradiatorprocess0Procedure {
	public static void execute(Entity entity, ItemStack item) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			ItemStack _setstack = item.copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
	}
}
