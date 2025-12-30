package net.mcreator.oneiricconcept.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.oneiricconcept.procedures.IfTime5Procedure;
import net.mcreator.oneiricconcept.entity.EngineeringAntimatterBombEntity;
import net.mcreator.oneiricconcept.client.model.Modelblock;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class EngineeringAntimatterBombRenderer extends MobRenderer<EngineeringAntimatterBombEntity, Modelblock<EngineeringAntimatterBombEntity>> {
	public EngineeringAntimatterBombRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelblock<EngineeringAntimatterBombEntity>(context.bakeLayer(Modelblock.LAYER_LOCATION)), 1f);
		this.addLayer(new RenderLayer<EngineeringAntimatterBombEntity, Modelblock<EngineeringAntimatterBombEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("oneiricconcept:textures/entities/white.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, EngineeringAntimatterBombEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (IfTime5Procedure.execute(world)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY);
				}
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(EngineeringAntimatterBombEntity entity) {
		return ResourceLocation.parse("oneiricconcept:textures/entities/antimatter_bomb.png");
	}
}