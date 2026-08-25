package net.mcreator.oneiricconcept.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelly_1<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("oneiricconcept", "modelly_1"), "main");
	public final ModelPart bone;
	public final ModelPart left;
	public final ModelPart bone2;
	public final ModelPart right;
	public final ModelPart bone4;
	public final ModelPart bone6;
	public final ModelPart body;
	public final ModelPart mian;
	public final ModelPart bone7;
	public final ModelPart bone8;

	public Modelly_1(ModelPart root) {
		this.bone = root.getChild("bone");
		this.left = this.bone.getChild("left");
		this.bone2 = this.left.getChild("bone2");
		this.right = this.bone.getChild("right");
		this.bone4 = this.right.getChild("bone4");
		this.bone6 = this.bone4.getChild("bone6");
		this.body = this.bone.getChild("body");
		this.mian = this.body.getChild("mian");
		this.bone7 = this.body.getChild("bone7");
		this.bone8 = this.bone7.getChild("bone8");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, 0.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 23.0F, 0.0F));
		PartDefinition left = bone.addOrReplaceChild("left",
				CubeListBuilder.create().texOffs(24, 40).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(64, 66).addBox(-1.0F, -11.0F, -1.0F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(6.0F, 0.0F, -4.0F));
		PartDefinition cube_r1 = left.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(46, 67).addBox(-1.0F, -5.0F, 1.0F, 2.0F, 4.0F, 5.0F, new CubeDeformation(-0.001F)),
				PartPose.offsetAndRotation(0.0F, -2.0F, 8.0F, 0.6109F, 0.0F, 0.0F));
		PartDefinition cube_r2 = left.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(46, 57).addBox(0.0F, 0.0F, 0.0F, 2.0F, 3.0F, 7.0F, new CubeDeformation(-0.001F)),
				PartPose.offsetAndRotation(-1.0F, -11.0F, 4.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition bone2 = left.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 59).addBox(0.0F, -4.0F, -1.0F, 1.0F, 4.0F, 7.0F, new CubeDeformation(-0.001F)), PartPose.offsetAndRotation(1.0F, -2.0F, 2.0F, 0.3491F, 0.0F, 0.0F));
		PartDefinition cube_r3 = bone2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(64, 57).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 7.0F, new CubeDeformation(-0.001F)),
				PartPose.offsetAndRotation(1.0F, -4.0F, -1.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition cube_r4 = bone2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(64, 4).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 7.0F, new CubeDeformation(-0.001F)),
				PartPose.offsetAndRotation(1.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition right = bone.addOrReplaceChild("right", CubeListBuilder.create().texOffs(0, 40).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 0.0F, -4.0F));
		PartDefinition bone4 = right.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(42, 17).addBox(-2.0F, -3.0F, -1.0F, 3.0F, 4.0F, 10.0F, new CubeDeformation(-0.001F)), PartPose.offset(-2.0F, -6.0F, 0.0F));
		PartDefinition cube_r5 = bone4.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(48, 31).addBox(0.0F, -4.0F, 0.0F, 2.0F, 4.0F, 10.0F, new CubeDeformation(-0.001F)),
				PartPose.offsetAndRotation(-2.0F, -3.0F, -1.0F, 0.0F, 0.0F, 1.2654F));
		PartDefinition bone6 = bone4.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(48, 45).addBox(1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(-0.001F)), PartPose.offset(-2.0F, 1.0F, -1.0F));
		PartDefinition cube_r6 = bone6.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(24, 56).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 10.0F, new CubeDeformation(-0.001F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5236F));
		PartDefinition body = bone.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 20).addBox(-5.0F, -6.0F, -6.0F, 10.0F, 9.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(78, 0).addBox(-5.0F, -9.0F, -3.0F, 10.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.2618F, 0.0F, 0.0F));
		PartDefinition cube_r7 = body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(86, 15).addBox(-10.0F, 0.0F, -4.0F, 10.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, -9.0F, -3.0F, 0.7854F, 0.0F, 0.0F));
		PartDefinition mian = body.addOrReplaceChild("mian", CubeListBuilder.create(), PartPose.offset(0.0F, -1.5F, 5.5F));
		PartDefinition cube_r8 = mian.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(68, 17).addBox(-2.0F, 2.0F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.3562F));
		PartDefinition cube_r9 = mian.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(16, 68).addBox(-2.0F, 2.0F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.3562F));
		PartDefinition cube_r10 = mian.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(64, 13).addBox(-2.0F, 2.0F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition cube_r11 = mian.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(64, 15).addBox(-2.0F, 2.0F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition bone7 = body.addOrReplaceChild("bone7",
				CubeListBuilder.create().texOffs(64, 0).addBox(-5.0F, -16.0F, 5.0F, 10.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(68, 19).addBox(1.0F, -13.0F, 5.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 7.0F, 0.0F));
		PartDefinition bone8 = bone7.addOrReplaceChild("bone8",
				CubeListBuilder.create().texOffs(0, 70).addBox(2.0F, 11.0F, -9.5F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 70).addBox(-7.0F, 11.0F, -9.5F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(42, 33)
						.addBox(-2.5F, 11.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(42, 35).addBox(-4.0F, 11.0F, -1.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, -15.0F, 5.5F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}
}