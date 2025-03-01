
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oneiricconcept.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.oneiricconcept.client.renderer.SkyShatteringLuxArrowRenderer;
import net.mcreator.oneiricconcept.client.renderer.CrystalTurtleRenderer;
import net.mcreator.oneiricconcept.client.renderer.BaryonRenderer;
import net.mcreator.oneiricconcept.client.renderer.AntiBaryonRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class OneiricconceptModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(OneiricconceptModEntities.XUANYUAN_SWORD_Q.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(OneiricconceptModEntities.XUANYUAN_Q_2.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(OneiricconceptModEntities.CRYSTAL_TURTLE.get(), CrystalTurtleRenderer::new);
		event.registerEntityRenderer(OneiricconceptModEntities.MORA_COIN.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(OneiricconceptModEntities.INVALID.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(OneiricconceptModEntities.SKY_SHATTERING_LUX_ARROW.get(), SkyShatteringLuxArrowRenderer::new);
		event.registerEntityRenderer(OneiricconceptModEntities.EXPLOSIVE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(OneiricconceptModEntities.XUAN_YUAN_ARROW_ARROW.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(OneiricconceptModEntities.BARYON.get(), BaryonRenderer::new);
		event.registerEntityRenderer(OneiricconceptModEntities.ANTIBARYON.get(), AntiBaryonRenderer::new);
		event.registerEntityRenderer(OneiricconceptModEntities.ON_LASER.get(), ThrownItemRenderer::new);
	}
}
