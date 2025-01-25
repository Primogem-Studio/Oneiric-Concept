
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oneiricconcept.init;

import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;

@EventBusSubscriber
public class OneiricconceptModFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		ItemStack itemstack = event.getItemStack();
		if (itemstack.getItem() == OneiricconceptModItems.PUBLIC_CLAMOR.get())
			event.setBurnTime(1600);
		else if (itemstack.getItem() == OneiricconceptModItems.PHLOGISTON.get())
			event.setBurnTime(20000);
		else if (itemstack.getItem() == OneiricconceptModItems.PHLOGISTON_CRYSTAL.get())
			event.setBurnTime(180000);
	}
}
