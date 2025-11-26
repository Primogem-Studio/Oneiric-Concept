package net.mcreator.oneiricconcept.client.renderer.block;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import net.mcreator.oneiricconcept.procedures.BoomBlossomsPyroBoomProcedure;
import net.mcreator.oneiricconcept.init.OneiricconceptModBlockEntities;
import net.mcreator.oneiricconcept.client.model.animations.boom_blossomsAnimation;
import net.mcreator.oneiricconcept.client.model.Modelboom_blossoms;
import net.mcreator.oneiricconcept.block.entity.BoomBlossomsPyroBlockEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BoomBlossomsPyroRenderer implements BlockEntityRenderer<BoomBlossomsPyroBlockEntity> {
	private final CustomHierarchicalModel model;
	private final ResourceLocation texture;

	BoomBlossomsPyroRenderer(BlockEntityRendererProvider.Context context) {
		this.model = new CustomHierarchicalModel(context.bakeLayer(Modelboom_blossoms.LAYER_LOCATION));
		this.texture = ResourceLocation.parse("oneiricconcept:textures/block/boom_blossoms.png");
	}

	private void updateRenderState(BoomBlossomsPyroBlockEntity blockEntity) {
		int tickCount = (int) blockEntity.getLevel().getGameTime();
		blockEntity.animationState0.animateWhen(BoomBlossomsPyroBoomProcedure.execute(blockEntity.getLevel(), blockEntity.getBlockPos().getX(), blockEntity.getBlockPos().getY(), blockEntity.getBlockPos().getZ()), tickCount);
	}

	@Override
	public void render(BoomBlossomsPyroBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource renderer, int light, int overlayLight) {
		updateRenderState(blockEntity);
		poseStack.pushPose();
		poseStack.scale(-1, -1, 1);
		poseStack.translate(-0.5, -0.5, 0.5);
		poseStack.translate(0, -1, 0);
		VertexConsumer builder = renderer.getBuffer(RenderType.entityCutout(texture));
		model.setupBlockEntityAnim(blockEntity, blockEntity.getLevel().getGameTime() + partialTick);
		model.renderToBuffer(poseStack, builder, light, overlayLight);
		poseStack.popPose();
	}

	@SubscribeEvent
	public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(OneiricconceptModBlockEntities.BOOM_BLOSSOMS_PYRO.get(), BoomBlossomsPyroRenderer::new);
	}

	private static final class CustomHierarchicalModel extends Modelboom_blossoms {
		private final ModelPart root;
		private final BlockEntityHierarchicalModel animator = new BlockEntityHierarchicalModel();

		public CustomHierarchicalModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		public void setupBlockEntityAnim(BoomBlossomsPyroBlockEntity blockEntity, float ageInTicks) {
			animator.setupBlockEntityAnim(blockEntity, ageInTicks);
			super.setupAnim(null, 0, 0, ageInTicks, 0, 0);
		}

		public ModelPart getRoot() {
			return root;
		}

		private class BlockEntityHierarchicalModel extends HierarchicalModel<Entity> {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			}

			public void setupBlockEntityAnim(BoomBlossomsPyroBlockEntity blockEntity, float ageInTicks) {
				animator.root().getAllParts().forEach(ModelPart::resetPose);
				animator.animate(blockEntity.animationState0, boom_blossomsAnimation.bomb, ageInTicks, 1f);
			}
		}
	}
}