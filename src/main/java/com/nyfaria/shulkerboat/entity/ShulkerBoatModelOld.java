package com.nyfaria.shulkerboat.entity;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nyfaria.shulkerboat.NyfsShulkerBoat;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class ShulkerBoatModelOld<T extends ShulkerBoatEntity> extends ListModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(NyfsShulkerBoat.MODID, "shulkerboatmodel"), "main");
	private final ModelPart front;
	private final ModelPart back;
	private final ModelPart left;
	private final ModelPart right;
	private final ModelPart paddle_left;
	private final ModelPart paddle_right;
	private final ModelPart bottom;
	private final ModelPart bottom_no_water;
	private final ModelPart knob;
	private final ModelPart lid;
	private final ModelPart base;

	public ShulkerBoatModelOld(ModelPart root) {
		this.front = root.getChild("front");
		this.back = root.getChild("back");
		this.left = root.getChild("left");
		this.right = root.getChild("right");
		this.paddle_left = root.getChild("paddle_left");
		this.paddle_right = root.getChild("paddle_right");
		this.bottom = root.getChild("bottom");
		this.bottom_no_water = root.getChild("bottom_no_water");
		this.knob = root.getChild("knob");
		this.lid = root.getChild("lid");
		this.base = root.getChild("base");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition front = partdefinition.addOrReplaceChild("front", CubeListBuilder.create().texOffs(0, 27).addBox(-8.0F, -7.0F, -1.0F, 16.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 22.0F, -15.0F, 0.0F, -3.1416F, 0.0F));

		PartDefinition back = partdefinition.addOrReplaceChild("back", CubeListBuilder.create().texOffs(0, 19).addBox(-5.0F, -7.0F, -1.0F, 18.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 22.0F, 15.0F));

		PartDefinition left = partdefinition.addOrReplaceChild("left", CubeListBuilder.create().texOffs(0, 43).addBox(-32.0F, -7.0F, -1.0F, 28.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 22.0F, -18.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition right = partdefinition.addOrReplaceChild("right", CubeListBuilder.create().texOffs(0, 35).addBox(4.0F, -7.0F, -1.0F, 28.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 22.0F, -18.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition paddle_left = partdefinition.addOrReplaceChild("paddle_left", CubeListBuilder.create().texOffs(62, 0).addBox(-9.65F, 0.0F, -5.0F, 2.0F, 2.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(62, 0).addBox(-9.66F, -3.0F, 8.0F, 1.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.35F, 18.0F, 5.0F, 0.0F, -3.1416F, 0.0F));

		PartDefinition paddle_right = partdefinition.addOrReplaceChild("paddle_right", CubeListBuilder.create().texOffs(62, 20).addBox(7.65F, 0.0F, -5.0F, 2.0F, 2.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(62, 20).addBox(8.66F, -3.0F, 8.0F, 1.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.35F, 18.0F, 5.0F, 0.0F, -3.1416F, 0.0F));

		PartDefinition bottom = partdefinition.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(0, 0).addBox(-16.0F, -9.0F, -3.0F, 28.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 21.0F, -2.0F, 0.0F, 1.5708F, -1.5708F));

		PartDefinition bottom_no_water = partdefinition.addOrReplaceChild("bottom_no_water", CubeListBuilder.create().texOffs(60, 42).addBox(-12.0F, -9.0F, -6.0F, 28.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 15.0F, -2.0F, 0.0F, -1.5708F, 1.5708F));

		PartDefinition knob = partdefinition.addOrReplaceChild("knob", CubeListBuilder.create().texOffs(0, 59).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 2.0F));

		PartDefinition lid = partdefinition.addOrReplaceChild("lid", CubeListBuilder.create().texOffs(0, 89).addBox(-6.0F, -15.0F, 1.0F, 12.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 110).addBox(-4.0F, -5.0F, -2.0F, 12.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 20.0F, 3.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		front.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		back.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		paddle_left.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		paddle_right.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bottom.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bottom_no_water.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		knob.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		lid.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public Iterable<ModelPart> parts() {
		return List.of(front,back, left, right, paddle_left, paddle_right, bottom, bottom_no_water, knob, lid, base);
	}
}