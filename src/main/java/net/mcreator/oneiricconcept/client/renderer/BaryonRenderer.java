
package net.mcreator.oneiricconcept.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import net.mcreator.oneiricconcept.procedures.EntitytexturesProcedure;
import net.mcreator.oneiricconcept.entity.BaryonEntity;
import net.mcreator.oneiricconcept.client.model.animations.BaryonAnimation;
import net.mcreator.oneiricconcept.client.model.ModelBaryon;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class BaryonRenderer extends MobRenderer<BaryonEntity, ModelBaryon<BaryonEntity>> {
	public BaryonRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelBaryon.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<BaryonEntity, ModelBaryon<BaryonEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("oneiricconcept:textures/entities/antibaryon.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, BaryonEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (EntitytexturesProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
				}
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(BaryonEntity entity) {
		return ResourceLocation.parse("oneiricconcept:textures/entities/baryon.png");
	}

	private static final class AnimatedModel extends ModelBaryon<BaryonEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<BaryonEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(BaryonEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, BaryonAnimation.animation, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(BaryonEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
