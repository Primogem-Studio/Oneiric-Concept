package net.mcreator.oneiricconcept.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.oneiricconcept.init.OneiricconceptModMenus;
import net.mcreator.oneiricconcept.init.OneiricconceptModItems;

public class BaitProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && _player.containerMenu instanceof OneiricconceptModMenus.MenuAccessor _menu) {
			ItemStack _setstack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof OneiricconceptModMenus.MenuAccessor _menu1 ? _menu1.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
			_setstack.setCount(getAmountInGUISlot(entity, 0) - 1);
			_menu.getSlots().get(0).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof OneiricconceptModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == OneiricconceptModItems.FRUITPASTEBAIT.get()) {
			FruitpastebaitFishProcedure.execute(entity);
		}
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof OneiricconceptModMenus.MenuAccessor menuAccessor) {
			ItemStack stack = menuAccessor.getSlots().get(sltid).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}
}