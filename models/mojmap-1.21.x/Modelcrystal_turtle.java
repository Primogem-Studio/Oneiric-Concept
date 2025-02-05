// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelcrystal_turtle<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "crystal_turtle"), "main");
	private final ModelPart head;
	private final ModelPart foot;
	private final ModelPart L;
	private final ModelPart R;
	private final ModelPart shell;
	private final ModelPart hand;
	private final ModelPart R2;
	private final ModelPart L2;
	private final ModelPart crystal;

	public Modelcrystal_turtle(ModelPart root) {
		this.head = root.getChild("head");
		this.foot = root.getChild("foot");
		this.L = this.foot.getChild("L");
		this.R = this.foot.getChild("R");
		this.shell = root.getChild("shell");
		this.hand = root.getChild("hand");
		this.R2 = this.hand.getChild("R2");
		this.L2 = this.hand.getChild("L2");
		this.crystal = root.getChild("crystal");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(3, 0).addBox(-3.0F, -2.5F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.5F, -13.0F));

		PartDefinition foot = partdefinition.addOrReplaceChild("foot", CubeListBuilder.create(), PartPose.offset(3.5F, 22.5F, 8.0F));

		PartDefinition L = foot.addOrReplaceChild("L", CubeListBuilder.create().texOffs(1, 12).addBox(-2.0F, -0.5F, 0.0F, 4.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition R = foot.addOrReplaceChild("R", CubeListBuilder.create().texOffs(1, 23).addBox(-2.0F, -0.5F, 0.0F, 4.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, 0.0F, 0.0F));

		PartDefinition shell = partdefinition.addOrReplaceChild("shell", CubeListBuilder.create(), PartPose.offset(4.5F, 23.0F, 8.0F));

		PartDefinition cube_r1 = shell.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(31, 1).addBox(-5.5F, -9.0F, -1.5F, 11.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -0.5F, -9.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r2 = shell.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(7, 37).addBox(-18.0F, -20.0F, -1.0F, 19.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -3.0F, 2.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition hand = partdefinition.addOrReplaceChild("hand", CubeListBuilder.create(), PartPose.offset(5.0F, 21.5F, -6.5F));

		PartDefinition R2 = hand.addOrReplaceChild("R2", CubeListBuilder.create().texOffs(27, 30).addBox(-13.5F, -0.5F, -2.5F, 13.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.0F, 0.0F, 0.0F));

		PartDefinition L2 = hand.addOrReplaceChild("L2", CubeListBuilder.create().texOffs(27, 24).addBox(0.5F, -0.5F, -2.5F, 13.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition crystal = partdefinition.addOrReplaceChild("crystal", CubeListBuilder.create(), PartPose.offset(0.0F, 7.0F, 0.0F));

		PartDefinition cube_r3 = crystal.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(72, 8).addBox(-8.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r4 = crystal.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(72, 8).addBox(-8.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		foot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		shell.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		hand.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		crystal.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}