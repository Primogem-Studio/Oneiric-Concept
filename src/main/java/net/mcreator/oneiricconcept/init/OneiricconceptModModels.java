
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.oneiricconcept.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.oneiricconcept.client.model.Modelsky_shattering_lux_arrow;
import net.mcreator.oneiricconcept.client.model.Modelcrystal_turtle;
import net.mcreator.oneiricconcept.client.model.Modelblock;
import net.mcreator.oneiricconcept.client.model.ModelBaryon;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class OneiricconceptModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelsky_shattering_lux_arrow.LAYER_LOCATION, Modelsky_shattering_lux_arrow::createBodyLayer);
		event.registerLayerDefinition(ModelBaryon.LAYER_LOCATION, ModelBaryon::createBodyLayer);
		event.registerLayerDefinition(Modelcrystal_turtle.LAYER_LOCATION, Modelcrystal_turtle::createBodyLayer);
		event.registerLayerDefinition(Modelblock.LAYER_LOCATION, Modelblock::createBodyLayer);
	}
}
