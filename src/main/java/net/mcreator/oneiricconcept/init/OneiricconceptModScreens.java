
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oneiricconcept.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.oneiricconcept.client.gui.PhlogistontankGuiScreen;
import net.mcreator.oneiricconcept.client.gui.FishingScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class OneiricconceptModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(OneiricconceptModMenus.PHLOGISTONTANK_GUI.get(), PhlogistontankGuiScreen::new);
		event.register(OneiricconceptModMenus.FISHING.get(), FishingScreen::new);
	}
}
