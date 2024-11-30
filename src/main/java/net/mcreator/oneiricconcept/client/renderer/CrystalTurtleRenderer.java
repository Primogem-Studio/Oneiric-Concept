
package net.mcreator.oneiricconcept.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.CreeperModel;

import net.mcreator.oneiricconcept.entity.CrystalTurtleEntity;

public class CrystalTurtleRenderer extends MobRenderer<CrystalTurtleEntity, CreeperModel<CrystalTurtleEntity>> {
	public CrystalTurtleRenderer(EntityRendererProvider.Context context) {
		super(context, new CreeperModel<CrystalTurtleEntity>(context.bakeLayer(ModelLayers.CREEPER)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CrystalTurtleEntity entity) {
		return ResourceLocation.parse("oneiricconcept:textures/entities/big_sea_turtle.png");
	}
}
