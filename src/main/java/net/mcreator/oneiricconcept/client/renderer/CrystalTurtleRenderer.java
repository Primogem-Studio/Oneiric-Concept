
package net.mcreator.oneiricconcept.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import net.mcreator.oneiricconcept.procedures.UncrystalProcedure;
import net.mcreator.oneiricconcept.procedures.TurtleCrystalProcedure;
import net.mcreator.oneiricconcept.procedures.ShrinkingShellSuoKeProcedure;
import net.mcreator.oneiricconcept.entity.CrystalTurtleEntity;
import net.mcreator.oneiricconcept.client.model.animations.big_sea_turtleAnimation;
import net.mcreator.oneiricconcept.client.model.Modelbig_sea_turtle;

public class CrystalTurtleRenderer extends MobRenderer<CrystalTurtleEntity, Modelbig_sea_turtle<CrystalTurtleEntity>> {
	public CrystalTurtleRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelbig_sea_turtle.LAYER_LOCATION)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(CrystalTurtleEntity entity) {
		return ResourceLocation.parse("oneiricconcept:textures/entities/crystal_turtle.png");
	}

	@Override
	protected boolean isShaking(CrystalTurtleEntity entity) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		return ShrinkingShellSuoKeProcedure.execute(entity);
	}

	private static final class AnimatedModel extends Modelbig_sea_turtle<CrystalTurtleEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<CrystalTurtleEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(CrystalTurtleEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				if (UncrystalProcedure.execute(entity))
					this.animateWalk(big_sea_turtleAnimation.walk_XingZou, limbSwing, limbSwingAmount, 1f, 1f);
				if (TurtleCrystalProcedure.execute(entity))
					this.animateWalk(big_sea_turtleAnimation.walk_XingZou_crystal, limbSwing, limbSwingAmount, 1f, 1f);
				this.animate(entity.animationState2, big_sea_turtleAnimation.ShrinkingShell_SuoKe, ageInTicks, 1f);
				this.animate(entity.animationState3, big_sea_turtleAnimation.ExtendHead_Shentou, ageInTicks, 1f);
				this.animate(entity.animationState4, big_sea_turtleAnimation.ExtendHead_Shentou_crystal, ageInTicks, 1f);
				this.animate(entity.animationState5, big_sea_turtleAnimation.ShrinkingShell_Suokeing, ageInTicks, 1f);
				this.animate(entity.animationState6, big_sea_turtleAnimation.ShrinkingShell_Suokeing_crystal, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(CrystalTurtleEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
