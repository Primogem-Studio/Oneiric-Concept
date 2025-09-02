/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oneiricconcept.init;

import org.joml.Vector3f;
import org.joml.Quaternionf;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.oneiricconcept.client.gui.WhiteMoonlightAbsorberGUIScreen;
import net.mcreator.oneiricconcept.client.gui.PhlogistontankGuiScreen;
import net.mcreator.oneiricconcept.client.gui.NestGUIScreen;
import net.mcreator.oneiricconcept.client.gui.LibGuiScreen;
import net.mcreator.oneiricconcept.client.gui.FishingScreen;
import net.mcreator.oneiricconcept.client.gui.CrystalgeneratorGUIScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class OneiricconceptModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(OneiricconceptModMenus.PHLOGISTONTANK_GUI.get(), PhlogistontankGuiScreen::new);
		event.register(OneiricconceptModMenus.FISHING.get(), FishingScreen::new);
		event.register(OneiricconceptModMenus.LIB_GUI.get(), LibGuiScreen::new);
		event.register(OneiricconceptModMenus.CRYSTALGENERATOR_GUI.get(), CrystalgeneratorGUIScreen::new);
		event.register(OneiricconceptModMenus.NEST_GUI.get(), NestGUIScreen::new);
		event.register(OneiricconceptModMenus.WHITE_MOONLIGHT_ABSORBER_GUI.get(), WhiteMoonlightAbsorberGUIScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}

	public static void renderEntityInInventoryFollowsAngle(GuiGraphics guiGraphics, int x, int y, int scale, float angleXComponent, float angleYComponent, LivingEntity entity) {
		Quaternionf pose = new Quaternionf().rotateZ((float) Math.PI);
		Quaternionf cameraOrientation = new Quaternionf().rotateX(angleYComponent * 20 * ((float) Math.PI / 180F));
		pose.mul(cameraOrientation);
		float f2 = entity.yBodyRot;
		float f3 = entity.getYRot();
		float f4 = entity.getXRot();
		float f5 = entity.yHeadRotO;
		float f6 = entity.yHeadRot;
		entity.yBodyRot = 180.0F + angleXComponent * 20.0F;
		entity.setYRot(180.0F + angleXComponent * 40.0F);
		entity.setXRot(-angleYComponent * 20.0F);
		entity.yHeadRot = entity.getYRot();
		entity.yHeadRotO = entity.getYRot();
		InventoryScreen.renderEntityInInventory(guiGraphics, x, y, scale, new Vector3f(0, 0, 0), pose, cameraOrientation, entity);
		entity.yBodyRot = f2;
		entity.setYRot(f3);
		entity.setXRot(f4);
		entity.yHeadRotO = f5;
		entity.yHeadRot = f6;
	}
}