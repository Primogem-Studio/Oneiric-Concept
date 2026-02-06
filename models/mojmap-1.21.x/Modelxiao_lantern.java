// Made with Blockbench 5.0.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelxiao_lantern<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "xiao_lantern"), "main");
	private final ModelPart all;
	private final ModelPart head;
	private final ModelPart bone;
	private final ModelPart bone4;
	private final ModelPart _top_3;
	private final ModelPart __top_3;
	private final ModelPart bone3;
	private final ModelPart _top_2;
	private final ModelPart __top_2;
	private final ModelPart bone2;
	private final ModelPart _top_;
	private final ModelPart __top_;
	private final ModelPart top_mian;
	private final ModelPart bone6;
	private final ModelPart bone5;
	private final ModelPart bone7;
	private final ModelPart body;
	private final ModelPart bone8;
	private final ModelPart dob_side;
	private final ModelPart side2;
	private final ModelPart side;
	private final ModelPart dob_side2;
	private final ModelPart side3;
	private final ModelPart side4;
	private final ModelPart dob_side3;
	private final ModelPart side5;
	private final ModelPart side6;
	private final ModelPart dob_side4;
	private final ModelPart side7;
	private final ModelPart side8;
	private final ModelPart dob_side5;
	private final ModelPart side9;
	private final ModelPart side10;
	private final ModelPart dob_side6;
	private final ModelPart side11;
	private final ModelPart side12;
	private final ModelPart floot;
	private final ModelPart leg4;
	private final ModelPart leg;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart connect;
	private final ModelPart bone9;
	private final ModelPart bone10;
	private final ModelPart bone11;
	private final ModelPart support;
	private final ModelPart bone12;
	private final ModelPart bone16;
	private final ModelPart core;
	private final ModelPart link;
	private final ModelPart bone15;
	private final ModelPart bone13;
	private final ModelPart bone14;
	private final ModelPart bone17;
	private final ModelPart bone18;
	private final ModelPart bone19;
	private final ModelPart bone20;
	private final ModelPart bone21;
	private final ModelPart bone22;
	private final ModelPart tip;
	private final ModelPart bone24;
	private final ModelPart bone23;
	private final ModelPart bone25;

	public Modelxiao_lantern(ModelPart root) {
		this.all = root.getChild("all");
		this.head = this.all.getChild("head");
		this.bone = this.head.getChild("bone");
		this.bone4 = this.bone.getChild("bone4");
		this._top_3 = this.bone4.getChild("_top_3");
		this.__top_3 = this.bone4.getChild("__top_3");
		this.bone3 = this.bone.getChild("bone3");
		this._top_2 = this.bone3.getChild("_top_2");
		this.__top_2 = this.bone3.getChild("__top_2");
		this.bone2 = this.bone.getChild("bone2");
		this._top_ = this.bone2.getChild("_top_");
		this.__top_ = this.bone2.getChild("__top_");
		this.top_mian = this.head.getChild("top_mian");
		this.bone6 = this.top_mian.getChild("bone6");
		this.bone5 = this.top_mian.getChild("bone5");
		this.bone7 = this.top_mian.getChild("bone7");
		this.body = this.all.getChild("body");
		this.bone8 = this.body.getChild("bone8");
		this.dob_side = this.bone8.getChild("dob_side");
		this.side2 = this.dob_side.getChild("side2");
		this.side = this.dob_side.getChild("side");
		this.dob_side2 = this.bone8.getChild("dob_side2");
		this.side3 = this.dob_side2.getChild("side3");
		this.side4 = this.dob_side2.getChild("side4");
		this.dob_side3 = this.bone8.getChild("dob_side3");
		this.side5 = this.dob_side3.getChild("side5");
		this.side6 = this.dob_side3.getChild("side6");
		this.dob_side4 = this.bone8.getChild("dob_side4");
		this.side7 = this.dob_side4.getChild("side7");
		this.side8 = this.dob_side4.getChild("side8");
		this.dob_side5 = this.bone8.getChild("dob_side5");
		this.side9 = this.dob_side5.getChild("side9");
		this.side10 = this.dob_side5.getChild("side10");
		this.dob_side6 = this.bone8.getChild("dob_side6");
		this.side11 = this.dob_side6.getChild("side11");
		this.side12 = this.dob_side6.getChild("side12");
		this.floot = this.all.getChild("floot");
		this.leg4 = this.floot.getChild("leg4");
		this.leg = this.leg4.getChild("leg");
		this.leg2 = this.leg4.getChild("leg2");
		this.leg3 = this.leg4.getChild("leg3");
		this.connect = this.floot.getChild("connect");
		this.bone9 = this.connect.getChild("bone9");
		this.bone10 = this.connect.getChild("bone10");
		this.bone11 = this.connect.getChild("bone11");
		this.support = this.floot.getChild("support");
		this.bone12 = this.support.getChild("bone12");
		this.bone16 = this.support.getChild("bone16");
		this.core = this.floot.getChild("core");
		this.link = this.floot.getChild("link");
		this.bone15 = this.link.getChild("bone15");
		this.bone13 = this.bone15.getChild("bone13");
		this.bone14 = this.bone15.getChild("bone14");
		this.bone17 = this.link.getChild("bone17");
		this.bone18 = this.bone17.getChild("bone18");
		this.bone19 = this.bone17.getChild("bone19");
		this.bone20 = this.link.getChild("bone20");
		this.bone21 = this.bone20.getChild("bone21");
		this.bone22 = this.bone20.getChild("bone22");
		this.tip = this.floot.getChild("tip");
		this.bone24 = this.tip.getChild("bone24");
		this.bone23 = this.tip.getChild("bone23");
		this.bone25 = this.tip.getChild("bone25");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition all = partdefinition.addOrReplaceChild("all", CubeListBuilder.create(),
				PartPose.offset(0.0F, -3.5F, 0.0F));

		PartDefinition head = all.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(6, 5)
						.addBox(-0.5F, -1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 7)
						.addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone = head.addOrReplaceChild("bone", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition bone4 = bone.addOrReplaceChild("bone4", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 2.1651F, -1.0F, 0.0F, 1.0472F, 0.0F));

		PartDefinition _top_3 = bone4.addOrReplaceChild("_top_3", CubeListBuilder.create(),
				PartPose.offset(0.0F, -1.1651F, 0.0F));

		PartDefinition cube_r1 = _top_3.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, -1.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r2 = _top_3.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 1.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition __top_3 = bone4.addOrReplaceChild("__top_3", CubeListBuilder.create(),
				PartPose.offset(0.0F, 1.1651F, 0.0F));

		PartDefinition cube_r3 = __top_3.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 1.5F, -10.0F, 1.0F, 4.0F, 10.0F,
						new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(0.0F, -3.3303F, -1.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r4 = __top_3.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 1.5F, 0.0F, 1.0F, 4.0F, 10.0F,
						new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(0.0F, -3.3303F, 1.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition bone3 = bone.addOrReplaceChild("bone3", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 2.1651F, -1.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition _top_2 = bone3.addOrReplaceChild("_top_2", CubeListBuilder.create(),
				PartPose.offset(0.0F, -1.1651F, 0.0F));

		PartDefinition cube_r5 = _top_2.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, -1.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r6 = _top_2.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 1.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition __top_2 = bone3.addOrReplaceChild("__top_2", CubeListBuilder.create(),
				PartPose.offset(0.0F, 1.1651F, 0.0F));

		PartDefinition cube_r7 = __top_2.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 1.5F, -10.0F, 1.0F, 4.0F, 10.0F,
						new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(0.0F, -3.3303F, -1.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r8 = __top_2.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 1.5F, 0.0F, 1.0F, 4.0F, 10.0F,
						new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(0.0F, -3.3303F, 1.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create(),
				PartPose.offset(0.0F, 2.1651F, -1.0F));

		PartDefinition _top_ = bone2.addOrReplaceChild("_top_", CubeListBuilder.create(),
				PartPose.offset(0.0F, -1.1651F, 0.0F));

		PartDefinition cube_r9 = _top_.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, -1.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r10 = _top_.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, 1.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition __top_ = bone2.addOrReplaceChild("__top_", CubeListBuilder.create(),
				PartPose.offset(0.0F, 1.1651F, 0.0F));

		PartDefinition cube_r11 = __top_.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 1.5F, -10.0F, 1.0F, 4.0F, 10.0F,
						new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(0.0F, -3.3303F, -1.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r12 = __top_.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 1.5F, 0.0F, 1.0F, 4.0F, 10.0F,
						new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(0.0F, -3.3303F, 1.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition top_mian = head.addOrReplaceChild("top_mian", CubeListBuilder.create(),
				PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition bone6 = top_mian.addOrReplaceChild("bone6", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r13 = bone6
				.addOrReplaceChild("cube_r13",
						CubeListBuilder.create().texOffs(0, 14).addBox(-9.0F, -0.5F, -5.0F, 9.0F, 1.0F, 10.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition cube_r14 = bone6.addOrReplaceChild("cube_r14",
				CubeListBuilder.create().texOffs(0, 14).mirror()
						.addBox(0.0F, -0.5F, -5.0F, 9.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition bone5 = top_mian.addOrReplaceChild("bone5", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition cube_r15 = bone5
				.addOrReplaceChild("cube_r15",
						CubeListBuilder.create().texOffs(0, 14).addBox(-9.0F, -0.5F, -5.0F, 9.0F, 1.0F, 10.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition cube_r16 = bone5.addOrReplaceChild("cube_r16",
				CubeListBuilder.create().texOffs(0, 14).mirror()
						.addBox(0.0F, -0.5F, -5.0F, 9.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition bone7 = top_mian.addOrReplaceChild("bone7", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.0472F, 0.0F));

		PartDefinition cube_r17 = bone7
				.addOrReplaceChild("cube_r17",
						CubeListBuilder.create().texOffs(0, 14).addBox(-9.0F, -0.5F, -5.0F, 9.0F, 1.0F, 10.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition cube_r18 = bone7.addOrReplaceChild("cube_r18",
				CubeListBuilder.create().texOffs(0, 14).mirror()
						.addBox(0.0F, -0.5F, -5.0F, 9.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition body = all.addOrReplaceChild("body", CubeListBuilder.create(),
				PartPose.offset(0.0F, 39.5F, 0.0F));

		PartDefinition bone8 = body.addOrReplaceChild("bone8", CubeListBuilder.create(),
				PartPose.offset(0.0F, -32.5F, 0.0F));

		PartDefinition dob_side = bone8.addOrReplaceChild("dob_side", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition side2 = dob_side.addOrReplaceChild("side2", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 6.2359F, 0.0F, 0.0F, 2.618F, 0.0F));

		PartDefinition cube_r19 = side2.addOrReplaceChild("cube_r19",
				CubeListBuilder.create().texOffs(0, 25).addBox(0.5F, -1.0F, 0.0F, 9.0F, 1.0F, 13.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 0.0598F, -19.2085F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r20 = side2.addOrReplaceChild("cube_r20",
				CubeListBuilder.create().texOffs(28, 19).addBox(0.5F, 0.0F, -4.0F, 9.0F, 1.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, -3.5655F, -17.518F, 1.1345F, 0.0F, 0.0F));

		PartDefinition cube_r21 = side2.addOrReplaceChild("cube_r21",
				CubeListBuilder.create().texOffs(0, 39).addBox(-4.0F, -1.5F, -10.0F, 9.0F, 1.0F, 10.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -7.2664F, -8.1077F, 0.5236F, 0.0F, 0.0F));

		PartDefinition side = dob_side.addOrReplaceChild("side", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 6.2359F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition cube_r22 = side.addOrReplaceChild("cube_r22",
				CubeListBuilder.create().texOffs(0, 25).addBox(0.5F, -1.0F, 0.0F, 9.0F, 1.0F, 13.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 0.0598F, -19.2085F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r23 = side.addOrReplaceChild("cube_r23",
				CubeListBuilder.create().texOffs(28, 19).addBox(0.5F, 0.0F, -4.0F, 9.0F, 1.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, -3.5655F, -17.518F, 1.1345F, 0.0F, 0.0F));

		PartDefinition cube_r24 = side.addOrReplaceChild("cube_r24",
				CubeListBuilder.create().texOffs(0, 39).addBox(-4.0F, -1.5F, -10.0F, 9.0F, 1.0F, 10.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -7.2664F, -8.1077F, 0.5236F, 0.0F, 0.0F));

		PartDefinition dob_side2 = bone8.addOrReplaceChild("dob_side2", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition side3 = dob_side2.addOrReplaceChild("side3", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 6.2359F, 0.0F, 0.0F, 2.618F, 0.0F));

		PartDefinition cube_r25 = side3.addOrReplaceChild("cube_r25",
				CubeListBuilder.create().texOffs(0, 25).addBox(0.5F, -1.0F, 0.0F, 9.0F, 1.0F, 13.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 0.0598F, -19.2085F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r26 = side3.addOrReplaceChild("cube_r26",
				CubeListBuilder.create().texOffs(28, 19).addBox(0.5F, 0.0F, -4.0F, 9.0F, 1.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, -3.5655F, -17.518F, 1.1345F, 0.0F, 0.0F));

		PartDefinition cube_r27 = side3.addOrReplaceChild("cube_r27",
				CubeListBuilder.create().texOffs(0, 39).addBox(-4.0F, -1.5F, -10.0F, 9.0F, 1.0F, 10.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -7.2664F, -8.1077F, 0.5236F, 0.0F, 0.0F));

		PartDefinition side4 = dob_side2.addOrReplaceChild("side4", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 6.2359F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition cube_r28 = side4.addOrReplaceChild("cube_r28",
				CubeListBuilder.create().texOffs(0, 25).addBox(0.5F, -1.0F, 0.0F, 9.0F, 1.0F, 13.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 0.0598F, -19.2085F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r29 = side4.addOrReplaceChild("cube_r29",
				CubeListBuilder.create().texOffs(28, 19).addBox(0.5F, 0.0F, -4.0F, 9.0F, 1.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, -3.5655F, -17.518F, 1.1345F, 0.0F, 0.0F));

		PartDefinition cube_r30 = side4.addOrReplaceChild("cube_r30",
				CubeListBuilder.create().texOffs(0, 39).addBox(-4.0F, -1.5F, -10.0F, 9.0F, 1.0F, 10.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -7.2664F, -8.1077F, 0.5236F, 0.0F, 0.0F));

		PartDefinition dob_side3 = bone8.addOrReplaceChild("dob_side3", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition side5 = dob_side3.addOrReplaceChild("side5", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 6.2359F, 0.0F, 0.0F, 2.618F, 0.0F));

		PartDefinition cube_r31 = side5.addOrReplaceChild("cube_r31",
				CubeListBuilder.create().texOffs(0, 25).addBox(0.5F, -1.0F, 0.0F, 9.0F, 1.0F, 13.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 0.0598F, -19.2085F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r32 = side5.addOrReplaceChild("cube_r32",
				CubeListBuilder.create().texOffs(28, 19).addBox(0.5F, 0.0F, -4.0F, 9.0F, 1.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, -3.5655F, -17.518F, 1.1345F, 0.0F, 0.0F));

		PartDefinition cube_r33 = side5.addOrReplaceChild("cube_r33",
				CubeListBuilder.create().texOffs(0, 39).addBox(-4.0F, -1.5F, -10.0F, 9.0F, 1.0F, 10.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -7.2664F, -8.1077F, 0.5236F, 0.0F, 0.0F));

		PartDefinition side6 = dob_side3.addOrReplaceChild("side6", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 6.2359F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition cube_r34 = side6.addOrReplaceChild("cube_r34",
				CubeListBuilder.create().texOffs(0, 25).addBox(0.5F, -1.0F, 0.0F, 9.0F, 1.0F, 13.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 0.0598F, -19.2085F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r35 = side6.addOrReplaceChild("cube_r35",
				CubeListBuilder.create().texOffs(28, 19).addBox(0.5F, 0.0F, -4.0F, 9.0F, 1.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, -3.5655F, -17.518F, 1.1345F, 0.0F, 0.0F));

		PartDefinition cube_r36 = side6.addOrReplaceChild("cube_r36",
				CubeListBuilder.create().texOffs(0, 39).addBox(-4.0F, -1.5F, -10.0F, 9.0F, 1.0F, 10.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -7.2664F, -8.1077F, 0.5236F, 0.0F, 0.0F));

		PartDefinition dob_side4 = bone8.addOrReplaceChild("dob_side4", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition side7 = dob_side4.addOrReplaceChild("side7", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 6.2359F, 0.0F, 0.0F, 2.618F, 0.0F));

		PartDefinition cube_r37 = side7.addOrReplaceChild("cube_r37",
				CubeListBuilder.create().texOffs(0, 25).addBox(0.5F, -1.0F, 0.0F, 9.0F, 1.0F, 13.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 0.0598F, -19.2085F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r38 = side7.addOrReplaceChild("cube_r38",
				CubeListBuilder.create().texOffs(28, 19).addBox(0.5F, 0.0F, -4.0F, 9.0F, 1.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, -3.5655F, -17.518F, 1.1345F, 0.0F, 0.0F));

		PartDefinition cube_r39 = side7.addOrReplaceChild("cube_r39",
				CubeListBuilder.create().texOffs(0, 39).addBox(-4.0F, -1.5F, -10.0F, 9.0F, 1.0F, 10.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -7.2664F, -8.1077F, 0.5236F, 0.0F, 0.0F));

		PartDefinition side8 = dob_side4.addOrReplaceChild("side8", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 6.2359F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition cube_r40 = side8.addOrReplaceChild("cube_r40",
				CubeListBuilder.create().texOffs(0, 25).addBox(0.5F, -1.0F, 0.0F, 9.0F, 1.0F, 13.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 0.0598F, -19.2085F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r41 = side8.addOrReplaceChild("cube_r41",
				CubeListBuilder.create().texOffs(28, 19).addBox(0.5F, 0.0F, -4.0F, 9.0F, 1.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, -3.5655F, -17.518F, 1.1345F, 0.0F, 0.0F));

		PartDefinition cube_r42 = side8.addOrReplaceChild("cube_r42",
				CubeListBuilder.create().texOffs(0, 39).addBox(-4.0F, -1.5F, -10.0F, 9.0F, 1.0F, 10.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -7.2664F, -8.1077F, 0.5236F, 0.0F, 0.0F));

		PartDefinition dob_side5 = bone8.addOrReplaceChild("dob_side5", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -2.0944F, 0.0F));

		PartDefinition side9 = dob_side5.addOrReplaceChild("side9", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 6.2359F, 0.0F, 0.0F, 2.618F, 0.0F));

		PartDefinition cube_r43 = side9.addOrReplaceChild("cube_r43",
				CubeListBuilder.create().texOffs(0, 25).addBox(0.5F, -1.0F, 0.0F, 9.0F, 1.0F, 13.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 0.0598F, -19.2085F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r44 = side9.addOrReplaceChild("cube_r44",
				CubeListBuilder.create().texOffs(28, 19).addBox(0.5F, 0.0F, -4.0F, 9.0F, 1.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, -3.5655F, -17.518F, 1.1345F, 0.0F, 0.0F));

		PartDefinition cube_r45 = side9.addOrReplaceChild("cube_r45",
				CubeListBuilder.create().texOffs(0, 39).addBox(-4.0F, -1.5F, -10.0F, 9.0F, 1.0F, 10.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -7.2664F, -8.1077F, 0.5236F, 0.0F, 0.0F));

		PartDefinition side10 = dob_side5.addOrReplaceChild("side10", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 6.2359F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition cube_r46 = side10.addOrReplaceChild("cube_r46",
				CubeListBuilder.create().texOffs(0, 25).addBox(0.5F, -1.0F, 0.0F, 9.0F, 1.0F, 13.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 0.0598F, -19.2085F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r47 = side10.addOrReplaceChild("cube_r47",
				CubeListBuilder.create().texOffs(28, 19).addBox(0.5F, 0.0F, -4.0F, 9.0F, 1.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, -3.5655F, -17.518F, 1.1345F, 0.0F, 0.0F));

		PartDefinition cube_r48 = side10.addOrReplaceChild("cube_r48",
				CubeListBuilder.create().texOffs(0, 39).addBox(-4.0F, -1.5F, -10.0F, 9.0F, 1.0F, 10.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -7.2664F, -8.1077F, 0.5236F, 0.0F, 0.0F));

		PartDefinition dob_side6 = bone8.addOrReplaceChild("dob_side6", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -2.618F, 0.0F));

		PartDefinition side11 = dob_side6.addOrReplaceChild("side11", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 6.2359F, 0.0F, 0.0F, 2.618F, 0.0F));

		PartDefinition cube_r49 = side11.addOrReplaceChild("cube_r49",
				CubeListBuilder.create().texOffs(0, 25).addBox(0.5F, -1.0F, 0.0F, 9.0F, 1.0F, 13.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 0.0598F, -19.2085F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r50 = side11.addOrReplaceChild("cube_r50",
				CubeListBuilder.create().texOffs(28, 19).addBox(0.5F, 0.0F, -4.0F, 9.0F, 1.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, -3.5655F, -17.518F, 1.1345F, 0.0F, 0.0F));

		PartDefinition cube_r51 = side11.addOrReplaceChild("cube_r51",
				CubeListBuilder.create().texOffs(0, 39).addBox(-4.0F, -1.5F, -10.0F, 9.0F, 1.0F, 10.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -7.2664F, -8.1077F, 0.5236F, 0.0F, 0.0F));

		PartDefinition side12 = dob_side6.addOrReplaceChild("side12", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 6.2359F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition cube_r52 = side12.addOrReplaceChild("cube_r52",
				CubeListBuilder.create().texOffs(0, 25).addBox(0.5F, -1.0F, 0.0F, 9.0F, 1.0F, 13.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 0.0598F, -19.2085F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r53 = side12.addOrReplaceChild("cube_r53",
				CubeListBuilder.create().texOffs(28, 19).addBox(0.5F, 0.0F, -4.0F, 9.0F, 1.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, -3.5655F, -17.518F, 1.1345F, 0.0F, 0.0F));

		PartDefinition cube_r54 = side12.addOrReplaceChild("cube_r54",
				CubeListBuilder.create().texOffs(0, 39).addBox(-4.0F, -1.5F, -10.0F, 9.0F, 1.0F, 10.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -7.2664F, -8.1077F, 0.5236F, 0.0F, 0.0F));

		PartDefinition floot = all.addOrReplaceChild("floot", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.5F, 0.0F));

		PartDefinition leg4 = floot.addOrReplaceChild("leg4", CubeListBuilder.create(),
				PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition leg = leg4.addOrReplaceChild("leg",
				CubeListBuilder.create().texOffs(7, 7)
						.addBox(-0.5F, -7.0F, 6.5F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.01F)).texOffs(7, 7)
						.addBox(-0.5F, -7.0F, -9.5F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.01F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg2 = leg4.addOrReplaceChild("leg2",
				CubeListBuilder.create().texOffs(7, 7)
						.addBox(-0.5F, -7.0F, 6.5F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.01F)).texOffs(7, 7)
						.addBox(-0.5F, -7.0F, -9.5F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition leg3 = leg4.addOrReplaceChild("leg3",
				CubeListBuilder.create().texOffs(7, 7)
						.addBox(-0.5F, -7.0F, 6.5F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.01F)).texOffs(7, 7)
						.addBox(-0.5F, -7.0F, -9.5F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.0472F, 0.0F));

		PartDefinition connect = floot.addOrReplaceChild("connect", CubeListBuilder.create(),
				PartPose.offset(0.0F, -4.5F, 0.0F));

		PartDefinition bone9 = connect.addOrReplaceChild("bone9",
				CubeListBuilder.create().texOffs(2, 2)
						.addBox(6.5F, 4.5F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.01F)).texOffs(2, 2).mirror()
						.addBox(-7.5F, 4.5F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.01F)).mirror(false),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone10 = connect.addOrReplaceChild("bone10",
				CubeListBuilder.create().texOffs(2, 2)
						.addBox(6.5F, 4.5F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.01F)).texOffs(2, 2).mirror()
						.addBox(-7.5F, 4.5F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.01F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone11 = connect.addOrReplaceChild("bone11",
				CubeListBuilder.create().texOffs(2, 2)
						.addBox(6.5F, 4.5F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.01F)).texOffs(2, 2).mirror()
						.addBox(-7.5F, 4.5F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.01F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.0472F, 0.0F));

		PartDefinition support = floot.addOrReplaceChild("support", CubeListBuilder.create(),
				PartPose.offset(0.0F, -5.5F, 1.0F));

		PartDefinition bone12 = support.addOrReplaceChild("bone12", CubeListBuilder.create(),
				PartPose.offset(0.0F, 2.1651F, -1.0F));

		PartDefinition cube_r55 = bone12.addOrReplaceChild("cube_r55",
				CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, 4.5F, -10.0F, 1.0F, 1.0F, 8.0F,
						new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(0.0F, -2.1651F, -1.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r56 = bone12.addOrReplaceChild("cube_r56",
				CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, 4.5F, -10.0F, 1.0F, 1.0F, 8.0F,
						new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(0.866F, -2.1651F, -0.5F, 0.1745F, -1.0472F, 0.0F));

		PartDefinition cube_r57 = bone12.addOrReplaceChild("cube_r57",
				CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, 4.5F, -10.0F, 1.0F, 1.0F, 8.0F,
						new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(-0.866F, -2.1651F, -0.5F, 0.1745F, 1.0472F, 0.0F));

		PartDefinition bone16 = support.addOrReplaceChild("bone16", CubeListBuilder.create(),
				PartPose.offset(0.0F, 2.1651F, -1.0F));

		PartDefinition cube_r58 = bone16.addOrReplaceChild("cube_r58",
				CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, 4.5F, 2.0F, 1.0F, 1.0F, 8.0F,
						new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(0.0F, -2.1651F, 1.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r59 = bone16.addOrReplaceChild("cube_r59",
				CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, 4.5F, 2.0F, 1.0F, 1.0F, 8.0F,
						new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(0.866F, -2.1651F, 0.5F, -0.1745F, 1.0472F, 0.0F));

		PartDefinition cube_r60 = bone16.addOrReplaceChild("cube_r60",
				CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, 4.5F, 2.0F, 1.0F, 1.0F, 8.0F,
						new CubeDeformation(0.01F)),
				PartPose.offsetAndRotation(-0.866F, -2.1651F, 0.5F, -0.1745F, -1.0472F, 0.0F));

		PartDefinition core = floot.addOrReplaceChild("core",
				CubeListBuilder.create().texOffs(28, 39)
						.addBox(-2.0F, -24.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(31, 25)
						.addBox(-3.0F, -18.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 14.0F, 0.0F));

		PartDefinition link = floot.addOrReplaceChild("link", CubeListBuilder.create(),
				PartPose.offset(0.0F, 15.0F, 0.0F));

		PartDefinition bone15 = link.addOrReplaceChild("bone15", CubeListBuilder.create(),
				PartPose.offset(0.0F, -16.0F, 0.0F));

		PartDefinition bone13 = bone15.addOrReplaceChild("bone13", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 9.0F));

		PartDefinition cube_r61 = bone13.addOrReplaceChild("cube_r61",
				CubeListBuilder.create().texOffs(0, 14).addBox(-0.5F, -4.0F, 0.0F, 1.0F, 6.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -17.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r62 = bone13.addOrReplaceChild("cube_r62",
				CubeListBuilder.create().texOffs(0, 14).addBox(-0.5F, -4.0F, 0.0F, 1.0F, 6.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -18.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition bone14 = bone15.addOrReplaceChild("bone14", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, -9.0F));

		PartDefinition cube_r63 = bone14.addOrReplaceChild("cube_r63",
				CubeListBuilder.create().texOffs(0, 14).addBox(-0.5F, -4.0F, 0.0F, 1.0F, 6.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 17.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r64 = bone14.addOrReplaceChild("cube_r64",
				CubeListBuilder.create().texOffs(0, 14).addBox(-0.5F, -4.0F, 0.0F, 1.0F, 6.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 18.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition bone17 = link.addOrReplaceChild("bone17", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition bone18 = bone17.addOrReplaceChild("bone18", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 9.0F));

		PartDefinition cube_r65 = bone18.addOrReplaceChild("cube_r65",
				CubeListBuilder.create().texOffs(0, 14).addBox(-0.5F, -4.0F, 0.0F, 1.0F, 6.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -17.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r66 = bone18.addOrReplaceChild("cube_r66",
				CubeListBuilder.create().texOffs(0, 14).addBox(-0.5F, -4.0F, 0.0F, 1.0F, 6.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -18.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition bone19 = bone17.addOrReplaceChild("bone19", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, -9.0F));

		PartDefinition cube_r67 = bone19.addOrReplaceChild("cube_r67",
				CubeListBuilder.create().texOffs(0, 14).addBox(-0.5F, -4.0F, 0.0F, 1.0F, 6.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 17.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r68 = bone19.addOrReplaceChild("cube_r68",
				CubeListBuilder.create().texOffs(0, 14).addBox(-0.5F, -4.0F, 0.0F, 1.0F, 6.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 18.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition bone20 = link.addOrReplaceChild("bone20", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, 0.0F, 1.0472F, 0.0F));

		PartDefinition bone21 = bone20.addOrReplaceChild("bone21", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 9.0F));

		PartDefinition cube_r69 = bone21.addOrReplaceChild("cube_r69",
				CubeListBuilder.create().texOffs(0, 14).addBox(-0.5F, -4.0F, 0.0F, 1.0F, 6.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -17.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r70 = bone21.addOrReplaceChild("cube_r70",
				CubeListBuilder.create().texOffs(0, 14).addBox(-0.5F, -4.0F, 0.0F, 1.0F, 6.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -18.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition bone22 = bone20.addOrReplaceChild("bone22", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, -9.0F));

		PartDefinition cube_r71 = bone22.addOrReplaceChild("cube_r71",
				CubeListBuilder.create().texOffs(0, 14).addBox(-0.5F, -4.0F, 0.0F, 1.0F, 6.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 17.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r72 = bone22.addOrReplaceChild("cube_r72",
				CubeListBuilder.create().texOffs(0, 14).addBox(-0.5F, -4.0F, 0.0F, 1.0F, 6.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 18.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition tip = floot.addOrReplaceChild("tip", CubeListBuilder.create().texOffs(38, 12).addBox(-1.5F, 9.0F,
				-1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 0.0F));

		PartDefinition bone24 = tip.addOrReplaceChild("bone24",
				CubeListBuilder.create().texOffs(0, 25)
						.addBox(-1.0F, -6.0F, -1.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 40)
						.addBox(1.0F, -5.0F, -1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(6, 40)
						.addBox(-2.0F, -5.0F, -1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 2.0F, 0.5F));

		PartDefinition bone23 = tip.addOrReplaceChild("bone23", CubeListBuilder.create().texOffs(0, 2).addBox(-0.5F,
				-16.0F, 8.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, -9.0F));

		PartDefinition cube_r73 = bone23.addOrReplaceChild("cube_r73",
				CubeListBuilder.create().texOffs(0, 14).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 4.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -16.0F, 9.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition bone25 = tip.addOrReplaceChild("bone25", CubeListBuilder.create().texOffs(0, 2).addBox(-0.5F,
				8.0F, 8.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -9.0F));

		PartDefinition cube_r74 = bone25
				.addOrReplaceChild("cube_r74",
						CubeListBuilder.create().texOffs(0, 14).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 8.0F, 9.0F, 0.0F, 0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		all.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}