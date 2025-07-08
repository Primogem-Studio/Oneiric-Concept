
package net.mcreator.oneiricconcept.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.oneiricconcept.entity.EngineeringAntimatterBombEntity;
import net.mcreator.oneiricconcept.client.model.Modelblock;

public class EngineeringAntimatterBombRenderer extends MobRenderer<EngineeringAntimatterBombEntity, Modelblock<EngineeringAntimatterBombEntity>> {
	public EngineeringAntimatterBombRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelblock<EngineeringAntimatterBombEntity>(context.bakeLayer(Modelblock.LAYER_LOCATION)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(EngineeringAntimatterBombEntity entity) {
		return ResourceLocation.parse("oneiricconcept:textures/entities/antimatter_bomb.png");
	}
}
