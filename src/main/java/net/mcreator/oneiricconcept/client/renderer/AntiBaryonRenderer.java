
package net.mcreator.oneiricconcept.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import net.mcreator.oneiricconcept.entity.AntiBaryonEntity;
import net.mcreator.oneiricconcept.client.model.animations.BaryonAnimation;
import net.mcreator.oneiricconcept.client.model.ModelBaryon;

public class AntiBaryonRenderer extends MobRenderer<AntiBaryonEntity, ModelBaryon<AntiBaryonEntity>> {
	public AntiBaryonRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelBaryon.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(AntiBaryonEntity entity) {
		return ResourceLocation.parse("oneiricconcept:textures/entities/antibaryon.png");
	}

	private static final class AnimatedModel extends ModelBaryon<AntiBaryonEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<AntiBaryonEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(AntiBaryonEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, BaryonAnimation.animation, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(AntiBaryonEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
