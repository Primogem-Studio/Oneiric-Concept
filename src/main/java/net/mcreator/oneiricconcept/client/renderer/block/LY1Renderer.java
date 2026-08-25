package net.mcreator.oneiricconcept.client.renderer.block;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import net.mcreator.oneiricconcept.procedures.*;
import net.mcreator.oneiricconcept.init.OneiricconceptModBlockEntities;
import net.mcreator.oneiricconcept.client.model.animations.ly_1Animation;
import net.mcreator.oneiricconcept.client.model.Modelly_1;
import net.mcreator.oneiricconcept.block.entity.LY1BlockEntity;
import net.mcreator.oneiricconcept.block.LY1Block;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

@EventBusSubscriber(Dist.CLIENT)
public class LY1Renderer implements BlockEntityRenderer<LY1BlockEntity> {
	private final CustomHierarchicalModel model;
	private final ResourceLocation texture;

	LY1Renderer(BlockEntityRendererProvider.Context context) {
		this.model = new CustomHierarchicalModel(context.bakeLayer(Modelly_1.LAYER_LOCATION));
		this.texture = ResourceLocation.parse("oneiricconcept:textures/block/ly1.png");
	}

	private void updateRenderState(LY1BlockEntity blockEntity) {
		int tickCount = (int) blockEntity.getLevel().getGameTime();
		blockEntity.animationState0.animateWhen(Ly1YAxis180Procedure.execute(), tickCount);
		blockEntity.animationState1.animateWhen(Ly1YAxis90Procedure.execute(), tickCount);
		blockEntity.animationState2.animateWhen(Ly1YAxis40Procedure.execute(), tickCount);
		blockEntity.animationState3.animateWhen(Ly1YAxis30Procedure.execute(), tickCount);
		blockEntity.animationState4.animateWhen(Ly1YAxis20Procedure.execute(), tickCount);
		blockEntity.animationState5.animateWhen(Ly1YAxis10Procedure.execute(), tickCount);
		blockEntity.animationState6.animateWhen(Ly1YAxis8Procedure.execute(), tickCount);
		blockEntity.animationState7.animateWhen(Ly1YAxis4Procedure.execute(), tickCount);
		blockEntity.animationState8.animateWhen(Ly1YAxis2Procedure.execute(), tickCount);
		blockEntity.animationState9.animateWhen(Ly1YAxis1Procedure.execute(), tickCount);
		blockEntity.animationState10.animateWhen(Ly1XAxis80Procedure.execute(), tickCount);
		blockEntity.animationState11.animateWhen(Ly1XAxis40Procedure.execute(), tickCount);
		blockEntity.animationState12.animateWhen(Ly1XAxis20Procedure.execute(), tickCount);
		blockEntity.animationState13.animateWhen(Ly1XAxis10Procedure.execute(), tickCount);
		blockEntity.animationState14.animateWhen(Ly1XAxis8Procedure.execute(), tickCount);
		blockEntity.animationState15.animateWhen(Ly1XAxis4Procedure.execute(), tickCount);
		blockEntity.animationState16.animateWhen(Ly1XAxis2Procedure.execute(), tickCount);
		blockEntity.animationState17.animateWhen(Ly1XAxis1Procedure.execute(), tickCount);
	}

	@Override
	public void render(LY1BlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource renderer, int light, int overlayLight) {
		updateRenderState(blockEntity);
		poseStack.pushPose();
		poseStack.scale(-1, -1, 1);
		poseStack.translate(-0.5, -0.5, 0.5);
		BlockState state = blockEntity.getBlockState();
		Direction facing = state.getValue(LY1Block.FACING);
		switch (facing) {
			case NORTH -> {
			}
			case EAST -> poseStack.mulPose(Axis.YP.rotationDegrees(90));
			case WEST -> poseStack.mulPose(Axis.YP.rotationDegrees(-90));
			case SOUTH -> poseStack.mulPose(Axis.YP.rotationDegrees(180));
		}
		poseStack.translate(0, -1, 0);
		VertexConsumer builder = renderer.getBuffer(RenderType.entityCutout(texture));
		model.setupBlockEntityAnim(blockEntity, blockEntity.getLevel().getGameTime() + partialTick);
		model.renderToBuffer(poseStack, builder, light, overlayLight);
		poseStack.popPose();
	}

	@SubscribeEvent
	public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(OneiricconceptModBlockEntities.LY_1.get(), LY1Renderer::new);
	}

	private static final class CustomHierarchicalModel extends Modelly_1 {
		private final ModelPart root;
		private final BlockEntityHierarchicalModel animator = new BlockEntityHierarchicalModel();

		public CustomHierarchicalModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		public void setupBlockEntityAnim(LY1BlockEntity blockEntity, float ageInTicks) {
			animator.setupBlockEntityAnim(blockEntity, ageInTicks);
			super.setupAnim(null, 0, 0, ageInTicks, 0, 0);
		}

		private class BlockEntityHierarchicalModel extends HierarchicalModel<Entity> {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			}

			public void setupBlockEntityAnim(LY1BlockEntity blockEntity, float ageInTicks) {
				animator.root().getAllParts().forEach(ModelPart::resetPose);
				animator.animate(blockEntity.animationState0, ly_1Animation.y180, ageInTicks, 1f);
				animator.animate(blockEntity.animationState1, ly_1Animation.y90, ageInTicks, 1f);
				animator.animate(blockEntity.animationState2, ly_1Animation.y40, ageInTicks, 1f);
				animator.animate(blockEntity.animationState3, ly_1Animation.y30, ageInTicks, 1f);
				animator.animate(blockEntity.animationState4, ly_1Animation.y20, ageInTicks, 1f);
				animator.animate(blockEntity.animationState5, ly_1Animation.y10, ageInTicks, 1f);
				animator.animate(blockEntity.animationState6, ly_1Animation.y8, ageInTicks, 1f);
				animator.animate(blockEntity.animationState7, ly_1Animation.y4, ageInTicks, 1f);
				animator.animate(blockEntity.animationState8, ly_1Animation.y2, ageInTicks, 1f);
				animator.animate(blockEntity.animationState9, ly_1Animation.y1, ageInTicks, 1f);
				animator.animate(blockEntity.animationState10, ly_1Animation.x80, ageInTicks, 1f);
				animator.animate(blockEntity.animationState11, ly_1Animation.x40, ageInTicks, 1f);
				animator.animate(blockEntity.animationState12, ly_1Animation.x20, ageInTicks, 1f);
				animator.animate(blockEntity.animationState13, ly_1Animation.x10, ageInTicks, 1f);
				animator.animate(blockEntity.animationState14, ly_1Animation.x8, ageInTicks, 1f);
				animator.animate(blockEntity.animationState15, ly_1Animation.x4, ageInTicks, 1f);
				animator.animate(blockEntity.animationState16, ly_1Animation.x2, ageInTicks, 1f);
				animator.animate(blockEntity.animationState17, ly_1Animation.x1, ageInTicks, 1f);
			}
		}
	}
}