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

// Made with Blockbench 5.0.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelboom_blossoms<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("oneiricconcept", "modelboom_blossoms"), "main");
	public final ModelPart melon;
	public final ModelPart top;
	public final ModelPart bone;
	public final ModelPart bone6;
	public final ModelPart bone2;
	public final ModelPart bone5;
	public final ModelPart bone3;
	public final ModelPart bone4;
	public final ModelPart down;
	public final ModelPart bone7;
	public final ModelPart bone8;
	public final ModelPart leaf;
	public final ModelPart top2;
	public final ModelPart dowm;

	public Modelboom_blossoms(ModelPart root) {
		this.melon = root.getChild("melon");
		this.top = this.melon.getChild("top");
		this.bone = this.top.getChild("bone");
		this.bone6 = this.bone.getChild("bone6");
		this.bone2 = this.top.getChild("bone2");
		this.bone5 = this.bone2.getChild("bone5");
		this.bone3 = this.top.getChild("bone3");
		this.bone4 = this.bone3.getChild("bone4");
		this.down = this.melon.getChild("down");
		this.bone7 = this.down.getChild("bone7");
		this.bone8 = this.bone7.getChild("bone8");
		this.leaf = root.getChild("leaf");
		this.top2 = this.leaf.getChild("top2");
		this.dowm = this.leaf.getChild("dowm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition melon = partdefinition.addOrReplaceChild("melon", CubeListBuilder.create(), PartPose.offset(0.0F, 18.0F, 0.0F));
		PartDefinition top = melon.addOrReplaceChild("top", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
		PartDefinition bone = top.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.3876F, -1.5F, -0.3876F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 2.4569F, 0.6591F, 2.6779F));
		PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-0.3876F, -1.5F, -0.3876F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 0.7854F, 0.5236F));
		PartDefinition cube_r3 = bone.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-0.3876F, -1.5F, -0.3876F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.6847F, -0.6591F, 0.4636F));
		PartDefinition cube_r4 = bone.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-0.3876F, -1.5F, -0.3876F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -3.1416F, -0.7854F, 2.618F));
		PartDefinition bone6 = bone.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition cube_r5 = bone6.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-0.3876F, -1.5F, -0.3876F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 2.4569F, 0.6591F, 2.6779F));
		PartDefinition cube_r6 = bone6.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-0.3876F, -1.5F, -0.3876F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 0.7854F, 0.5236F));
		PartDefinition cube_r7 = bone6.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-0.3876F, -1.5F, -0.3876F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.6847F, -0.6591F, 0.4636F));
		PartDefinition cube_r8 = bone6.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-0.3876F, -1.5F, -0.3876F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -3.1416F, -0.7854F, 2.618F));
		PartDefinition bone2 = top.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
		PartDefinition cube_r9 = bone2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(5, 0).addBox(0.3784F, -2.409F, 0.3784F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, -0.7854F, 2.4435F));
		PartDefinition cube_r10 = bone2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(5, 0).addBox(0.3784F, -2.409F, 0.3784F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.271F, 0.5724F, 2.5703F));
		PartDefinition cube_r11 = bone2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(5, 0).addBox(0.3784F, -2.409F, 0.3784F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.6981F));
		PartDefinition cube_r12 = bone2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(5, 0).addBox(0.3784F, -2.409F, 0.3784F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.8706F, -0.5724F, 0.5713F));
		PartDefinition cube_r13 = bone2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(5, 0).addBox(0.3784F, -2.8F, 0.3784F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.6662F, -0.1172F, 2.6662F));
		PartDefinition cube_r14 = bone2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(5, 0).addBox(0.3784F, -2.8F, 0.3784F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.3189F, 1.0823F, 1.8227F));
		PartDefinition cube_r15 = bone2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(5, 0).addBox(0.3784F, -2.8F, 0.3784F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4754F, 0.1172F, 0.4754F));
		PartDefinition cube_r16 = bone2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(5, 0).addBox(0.3784F, -2.8F, 0.3784F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.8227F, -1.0823F, 1.3189F));
		PartDefinition bone5 = bone2.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, -1.1781F, 0.0F));
		PartDefinition cube_r17 = bone5.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(5, 0).addBox(0.3784F, -2.409F, 0.3784F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, -0.7854F, 2.4435F));
		PartDefinition cube_r18 = bone5.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(5, 0).addBox(0.3784F, -2.409F, 0.3784F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.271F, 0.5724F, 2.5703F));
		PartDefinition cube_r19 = bone5.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(5, 0).addBox(0.3784F, -2.409F, 0.3784F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.6981F));
		PartDefinition cube_r20 = bone5.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(5, 0).addBox(0.3784F, -2.409F, 0.3784F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.8706F, -0.5724F, 0.5713F));
		PartDefinition cube_r21 = bone5.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(5, 0).addBox(0.3784F, -2.8F, 0.3784F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.6662F, -0.1172F, 2.6662F));
		PartDefinition cube_r22 = bone5.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(5, 0).addBox(0.3784F, -2.8F, 0.3784F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.3189F, 1.0823F, 1.8227F));
		PartDefinition cube_r23 = bone5.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(5, 0).addBox(0.3784F, -2.8F, 0.3784F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4754F, 0.1172F, 0.4754F));
		PartDefinition cube_r24 = bone5.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(5, 0).addBox(0.3784F, -2.8F, 0.3784F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.8227F, -1.0823F, 1.3189F));
		PartDefinition bone3 = top.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 0.0F));
		PartDefinition cube_r25 = bone3.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 5).addBox(-0.3876F, -1.5F, -0.3876F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, -7.0F, 0.0F, 0.0F, 0.7854F, 1.0472F));
		PartDefinition cube_r26 = bone3.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(0, 5).addBox(-0.3876F, -1.5F, -0.3876F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -7.0F, -3.0F, 1.9584F, 0.3614F, 2.4279F));
		PartDefinition cube_r27 = bone3.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 5).addBox(-0.3876F, -1.5F, -0.3876F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, -7.0F, 0.0F, -3.1416F, -0.7854F, 2.0944F));
		PartDefinition cube_r28 = bone3.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(0, 5).addBox(-0.3876F, -1.5F, -0.3876F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -7.0F, 3.0F, -1.1832F, -0.3614F, 0.7137F));
		PartDefinition bone4 = bone3.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.5253F, 0.0F, 0.0F, -0.7854F, 0.0F));
		PartDefinition cube_r29 = bone4.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(13, 0).addBox(-0.3876F, -1.5F, -0.3876F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, -1.4747F, 0.0F, -3.1416F, -0.7854F, 2.0944F));
		PartDefinition cube_r30 = bone4.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(13, 0).addBox(-0.3876F, -1.5F, -0.3876F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.4747F, 3.0F, -1.1832F, -0.3614F, 0.7137F));
		PartDefinition cube_r31 = bone4.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(13, 0).addBox(-0.3876F, -1.5F, -0.3876F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, -1.4747F, 0.0F, 0.0F, 0.7854F, 1.0472F));
		PartDefinition cube_r32 = bone4.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(13, 0).addBox(-0.3876F, -1.5F, -0.3876F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.4747F, -3.0F, 1.9584F, 0.3614F, 2.4279F));
		PartDefinition down = melon.addOrReplaceChild("down", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));
		PartDefinition bone7 = down.addOrReplaceChild("bone7", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 1.1781F, 0.0F));
		PartDefinition cube_r33 = bone7.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(0, 11).addBox(-0.3876F, 0.5F, -0.3876F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, -2.0F, 0.0F, 3.1416F, -0.7854F, -2.4435F));
		PartDefinition cube_r34 = bone7.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(0, 11).addBox(-0.3876F, 0.5F, -0.3876F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.0F, 3.0F, 0.8706F, -0.5724F, -0.5713F));
		PartDefinition cube_r35 = bone7.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(0, 11).addBox(-0.3876F, 0.5F, -0.3876F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, -2.0F, 0.0F, 0.0F, 0.7854F, -0.6981F));
		PartDefinition cube_r36 = bone7.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(0, 11).addBox(-0.3876F, 0.5F, -0.3876F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.0F, -3.0F, -2.271F, 0.5724F, -2.5703F));
		PartDefinition bone8 = bone7.addOrReplaceChild("bone8", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition cube_r37 = bone8.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(0, 11).addBox(-0.3876F, 0.5F, -0.3876F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, -2.0F, 0.0F, 3.1416F, -0.7854F, -2.4435F));
		PartDefinition cube_r38 = bone8.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 11).addBox(-0.3876F, 0.5F, -0.3876F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.0F, 3.0F, 0.8706F, -0.5724F, -0.5713F));
		PartDefinition cube_r39 = bone8.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(0, 11).addBox(-0.3876F, 0.5F, -0.3876F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, -2.0F, 0.0F, 0.0F, 0.7854F, -0.6981F));
		PartDefinition cube_r40 = bone8.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(0, 11).addBox(-0.3876F, 0.5F, -0.3876F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.0F, -3.0F, -2.271F, 0.5724F, -2.5703F));
		PartDefinition leaf = partdefinition.addOrReplaceChild("leaf", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition top2 = leaf.addOrReplaceChild("top2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r41 = top2.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(0, 25).addBox(-8.0F, -1.0F, 2.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5126F, -1.4398F, 1.6434F));
		PartDefinition cube_r42 = top2.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(0, 25).addBox(-8.0F, -1.0F, 2.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.0114F, 0.0095F, 3.011F));
		PartDefinition cube_r43 = top2.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(0, 25).addBox(-8.0F, -1.0F, 2.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.629F, 1.4398F, 1.4982F));
		PartDefinition cube_r44 = top2.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(0, 25).addBox(-8.0F, -1.0F, 2.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1302F, -0.0095F, 0.1306F));
		PartDefinition dowm = leaf.addOrReplaceChild("dowm", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition cube_r45 = dowm.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(0, 11).mirror().addBox(-4.0F, -1.0F, 0.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
		PartDefinition cube_r46 = dowm.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(0, 11).addBox(0.0F, -1.0F, 0.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, -2.3562F, 0.0F));
		PartDefinition cube_r47 = dowm.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(0, 11).mirror().addBox(-4.0F, -1.0F, 0.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.0F, 0.7854F, 0.0F));
		PartDefinition cube_r48 = dowm.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(0, 11).addBox(0.0F, -1.0F, 0.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.0F, -0.7854F, 0.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		melon.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
		leaf.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}
}