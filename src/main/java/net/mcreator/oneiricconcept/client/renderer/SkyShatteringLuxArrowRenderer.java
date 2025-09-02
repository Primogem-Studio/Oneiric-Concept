package net.mcreator.oneiricconcept.client.renderer;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.oneiricconcept.entity.SkyShatteringLuxArrowEntity;
import net.mcreator.oneiricconcept.client.model.Modelsky_shattering_lux_arrow;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SkyShatteringLuxArrowRenderer extends EntityRenderer<SkyShatteringLuxArrowEntity> {
	private static final ResourceLocation texture = ResourceLocation.parse("oneiricconcept:textures/entities/skyshatteringluxarrow.png");
	private final Modelsky_shattering_lux_arrow model;

	public SkyShatteringLuxArrowRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelsky_shattering_lux_arrow(context.bakeLayer(Modelsky_shattering_lux_arrow.LAYER_LOCATION));
	}

	@Override
	public void render(SkyShatteringLuxArrowEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.setupAnim(entityIn, 0, 0, entityIn.tickCount + partialTicks, entityIn.getYRot(), entityIn.getXRot());
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(SkyShatteringLuxArrowEntity entity) {
		return texture;
	}
}