// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelBaryon<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "baryon"), "main");
	private final ModelPart core;
	private final ModelPart c1;
	private final ModelPart c2;
	private final ModelPart c3;
	private final ModelPart bone;
	private final ModelPart up;
	private final ModelPart a1;
	private final ModelPart a2;
	private final ModelPart a3;
	private final ModelPart a4;

	public ModelBaryon(ModelPart root) {
		this.core = root.getChild("core");
		this.c1 = this.core.getChild("c1");
		this.c2 = this.core.getChild("c2");
		this.c3 = this.core.getChild("c3");
		this.bone = root.getChild("bone");
		this.up = this.bone.getChild("up");
		this.a1 = this.up.getChild("a1");
		this.a2 = this.up.getChild("a2");
		this.a3 = this.up.getChild("a3");
		this.a4 = this.bone.getChild("a4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition core = partdefinition.addOrReplaceChild("core", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.7854F, -0.7854F, 0.7854F));

		PartDefinition c1 = core.addOrReplaceChild("c1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = c1
				.addOrReplaceChild("cube_r1",
						CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition c2 = core.addOrReplaceChild("c2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = c2
				.addOrReplaceChild("cube_r2",
						CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition c3 = core.addOrReplaceChild("c3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r3 = c3
				.addOrReplaceChild("cube_r3",
						CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(),
				PartPose.offset(0.0F, 11.0F, 0.0F));

		PartDefinition up = bone.addOrReplaceChild("up", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition a1 = up.addOrReplaceChild("a1", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition cube_r4 = a1.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(28, 8)
						.addBox(-4.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 7)
						.addBox(-3.0F, 0.0F, 0.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.0166F, -6.0F, -3.2138F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r5 = a1.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(15, 1).addBox(-1.0F, -2.0F, 1.0F, 1.0F, 1.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.6658F, -7.4836F, -3.2138F, -1.5708F, 0.4363F, -0.7854F));

		PartDefinition cube_r6 = a1.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(15, 1).addBox(-1.0F, -2.0F, 1.0F, 1.0F, 1.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0166F, -6.0F, -3.2138F, -1.5708F, 0.4363F, -0.2618F));

		PartDefinition cube_r7 = a1.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(20, 0).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.0166F, -6.0F, -3.2138F, -1.0036F, 0.4363F, 0.0F));

		PartDefinition a2 = up.addOrReplaceChild("a2", CubeListBuilder.create(),
				PartPose.offsetAndRotation(3.0F, 1.0F, -3.0F, 0.0F, 1.8326F, 0.0F));

		PartDefinition cube_r8 = a2.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(28, 8)
						.addBox(-4.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 7)
						.addBox(-3.0F, 0.0F, 0.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0166F, -6.0F, -7.2138F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r9 = a2.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(15, 1).addBox(-1.0F, -2.0F, 1.0F, 1.0F, 1.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.3342F, -7.4836F, -7.2138F, -1.5708F, 0.4363F, -0.7854F));

		PartDefinition cube_r10 = a2.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(15, 1).addBox(-1.0F, -2.0F, 1.0F, 1.0F, 1.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0166F, -6.0F, -7.2138F, -1.5708F, 0.4363F, -0.2618F));

		PartDefinition cube_r11 = a2.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(20, 0).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0166F, -6.0F, -7.2138F, -1.0036F, 0.4363F, 0.0F));

		PartDefinition a3 = up.addOrReplaceChild("a3", CubeListBuilder.create(),
				PartPose.offsetAndRotation(1.0F, 1.0F, 12.0F, 0.0F, -2.3562F, 0.0F));

		PartDefinition cube_r12 = a3.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(28, 8)
						.addBox(-4.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 7)
						.addBox(-3.0F, 0.0F, 0.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0049F, -6.0F, 5.1975F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r13 = a3.addOrReplaceChild("cube_r13",
				CubeListBuilder.create().texOffs(15, 1).addBox(-1.0F, -2.0F, 1.0F, 1.0F, 1.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-6.3557F, -7.4836F, 5.1975F, -1.5708F, 0.4363F, -0.7854F));

		PartDefinition cube_r14 = a3.addOrReplaceChild("cube_r14",
				CubeListBuilder.create().texOffs(15, 1).addBox(-1.0F, -2.0F, 1.0F, 1.0F, 1.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0049F, -6.0F, 5.1975F, -1.5708F, 0.4363F, -0.2618F));

		PartDefinition cube_r15 = a3.addOrReplaceChild("cube_r15",
				CubeListBuilder.create().texOffs(20, 0).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0049F, -6.0F, 5.1975F, -1.0036F, 0.4363F, 0.0F));

		PartDefinition a4 = bone.addOrReplaceChild("a4", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-0.0341F, 6.2452F, -0.6132F, 2.9234F, 0.4363F, 1.0472F));

		PartDefinition cube_r16 = a4.addOrReplaceChild("cube_r16",
				CubeListBuilder.create().texOffs(28, 8)
						.addBox(-4.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 7)
						.addBox(-3.0F, 0.0F, 0.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.2236F, -1.534F, -0.1955F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r17 = a4.addOrReplaceChild("cube_r17",
				CubeListBuilder.create().texOffs(15, 1).addBox(-1.0F, -2.0F, 1.0F, 1.0F, 1.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.1272F, -3.0176F, -0.1955F, -1.5708F, 0.4363F, -0.7854F));

		PartDefinition cube_r18 = a4.addOrReplaceChild("cube_r18",
				CubeListBuilder.create().texOffs(15, 1).addBox(-1.0F, -2.0F, 1.0F, 1.0F, 1.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.2236F, -1.534F, -0.1955F, -1.5708F, 0.4363F, -0.2618F));

		PartDefinition cube_r19 = a4.addOrReplaceChild("cube_r19",
				CubeListBuilder.create().texOffs(20, 0).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.2236F, -1.534F, -0.1955F, -1.0036F, 0.4363F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		core.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}