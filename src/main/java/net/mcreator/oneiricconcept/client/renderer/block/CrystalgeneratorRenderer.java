package net.mcreator.oneiricconcept.client.renderer.block;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import net.mcreator.oneiricconcept.init.OneiricconceptModBlockEntities;
import net.mcreator.oneiricconcept.block.entity.CrystalgeneratorBlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

@EventBusSubscriber(Dist.CLIENT)
public class CrystalgeneratorRenderer implements BlockEntityRenderer<CrystalgeneratorBlockEntity> {
	private final ItemRenderer itemRenderer;
	private final RandomSource random = RandomSource.create();

	CrystalgeneratorRenderer(BlockEntityRendererProvider.Context context) {
		this.itemRenderer = context.getItemRenderer();
	}

	@Override
	public void render(CrystalgeneratorBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
		ItemStack itemstack = getFrontItemStack(blockEntity);
		if (itemstack.isEmpty())
			return;
		Level level = blockEntity.getLevel();
		if (level == null)
			return;

		long gameTime = level.getGameTime();
		float bobOffs = (float) Math.floorMod(blockEntity.getBlockPos().asLong(), 628L) / 100.0F;

		poseStack.pushPose();
		// 将物品渲染在透明方块内部（方块中心）
		poseStack.translate(0.5, 0.5, 0.5);

		// 与原版掉落物一致：根据物品栈数量决定渲染的份数
		this.random.setSeed((long) ItemEntityRenderer.getSeedForItemStack(itemstack));
		BakedModel bakedmodel = this.itemRenderer.getModel(itemstack, level, null, 0);
		boolean isGui3d = bakedmodel.isGui3d();

		// 原版掉落物的绕 Y 轴旋转
		float spin = ((float) gameTime + partialTick) / 20.0F + bobOffs;
		poseStack.mulPose(Axis.YP.rotation(spin));

		// 适度放大，让方块内的物品更清晰可见（3D 物品保持接近原尺寸）
		float size = isGui3d ? 0.4F : 0.6F;
		poseStack.scale(size, size, size);

		// 按数量渲染 1/2/3/4/5 份物品（与原版掉落物一致）
		ItemEntityRenderer.renderMultipleFromCount(this.itemRenderer, poseStack, bufferSource, packedLight, itemstack, bakedmodel, isGui3d, this.random);
		poseStack.popPose();
	}

	// 取方块物品栏中最靠前的非空物品栈（从 0 号槽开始）
	private static ItemStack getFrontItemStack(CrystalgeneratorBlockEntity blockEntity) {
		for (int i = 0; i < blockEntity.getContainerSize(); i++) {
			ItemStack stack = blockEntity.getItem(i);
			if (!stack.isEmpty())
				return stack;
		}
		return ItemStack.EMPTY;
	}

	@SubscribeEvent
	public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(OneiricconceptModBlockEntities.CRYSTALGENERATOR.get(), CrystalgeneratorRenderer::new);
	}
}
