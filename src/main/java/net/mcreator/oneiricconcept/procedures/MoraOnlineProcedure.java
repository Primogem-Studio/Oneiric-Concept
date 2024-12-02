package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.oneiricconcept.init.OneiricconceptModItems;

public class MoraOnlineProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(OneiricconceptModItems.MORA_MAGAZINE.get())) : false;
	}
}
