package net.mcreator.oneiricconcept.client.renderer.block;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.ModelPart;

import net.mcreator.oneiricconcept.init.OneiricconceptModBlockEntities;
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

	@Override
	public void render(LY1BlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource renderer, int light, int overlayLight) {
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
		public CustomHierarchicalModel(ModelPart root) {
			super(root);
		}

		/**
		 * 直接读取方块实体NBT中 Ly1TurnProcedure 写入的 ly1Pitch(俯仰) / ly1Yaw(偏航)，
		 * 连续旋转模型部件，替代原来的离散动画方案：
		 * - 偏航：bone.yRot = -yaw（与旧 yN 动画的负号方向一致）
		 * - 俯仰：body.xRot = -20 + pitch（与旧 xN 动画的 -20+N 映射一致）
		 * 注意：此处刻意不调用 ModelPart.resetPose()，以保留模型烘焙时的默认姿态。
		 */
		public void setupBlockEntityAnim(LY1BlockEntity blockEntity, float ageInTicks) {
			double pitch = blockEntity.getPersistentData().getDouble("ly1Pitch");
			double yaw = blockEntity.getPersistentData().getDouble("ly1Yaw");
			bone.yRot = (float) Math.toRadians(-yaw);
			body.xRot = (float) Math.toRadians(-20.0D + pitch);
		}
	}
}