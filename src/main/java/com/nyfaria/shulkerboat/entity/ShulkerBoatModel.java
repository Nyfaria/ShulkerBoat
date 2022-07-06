package com.nyfaria.shulkerboat.entity;// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.google.common.collect.ImmutableList;
import com.nyfaria.shulkerboat.NyfsShulkerBoat;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class ShulkerBoatModel extends ListModel<ShulkerBoatEntity> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(NyfsShulkerBoat.MODID, "shulkerboatmodel"), "main");
    private static final String LEFT_PADDLE = "left_paddle";
    private static final String RIGHT_PADDLE = "right_paddle";
    private static final String WATER_PATCH = "water_patch";
    private static final String BOTTOM = "bottom";
    private static final String BACK = "back";
    private static final String FRONT = "front";
    private static final String RIGHT = "right";
    private static final String LEFT = "left";
    private static final String CHEST_BOTTOM = "chest_bottom";
    private static final String CHEST_LID = "chest_lid";
    private static final String CHEST_LOCK = "chest_lock";
    private final ModelPart leftPaddle;
    private final ModelPart rightPaddle;
    private final ModelPart waterPatch;
    private final ImmutableList<ModelPart> parts;

    public ShulkerBoatModel(ModelPart p_233345_) {
        this.leftPaddle = p_233345_.getChild("left_paddle");
        this.rightPaddle = p_233345_.getChild("right_paddle");
        this.waterPatch = p_233345_.getChild("water_patch");
        ImmutableList.Builder<ModelPart> builder = new ImmutableList.Builder<>();
        builder.add(p_233345_.getChild("bottom"), p_233345_.getChild("back"), p_233345_.getChild("front"), p_233345_.getChild("right"), p_233345_.getChild("left"), this.leftPaddle, this.rightPaddle);
        builder.add(p_233345_.getChild("chest_bottom"));
        builder.add(p_233345_.getChild("chest_lid"));
        this.parts = builder.build();
    }

    public static LayerDefinition createBodyModel() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        int i = 32;
        int j = 6;
        int k = 20;
        int l = 4;
        int i1 = 28;
        partdefinition.addOrReplaceChild("bottom", CubeListBuilder.create().texOffs(0, 0).addBox(-14.0F, -9.0F, -3.0F, 28.0F, 16.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 3.0F, 1.0F, ((float) Math.PI / 2F), 0.0F, 0.0F));
        partdefinition.addOrReplaceChild("back", CubeListBuilder.create().texOffs(0, 19).addBox(-13.0F, -7.0F, -1.0F, 18.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(-15.0F, 4.0F, 4.0F, 0.0F, ((float) Math.PI * 1.5F), 0.0F));
        partdefinition.addOrReplaceChild("front", CubeListBuilder.create().texOffs(0, 27).addBox(-8.0F, -7.0F, -1.0F, 16.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(15.0F, 4.0F, 0.0F, 0.0F, ((float) Math.PI / 2F), 0.0F));
        partdefinition.addOrReplaceChild("right", CubeListBuilder.create().texOffs(0, 35).addBox(-14.0F, -7.0F, -1.0F, 28.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 4.0F, -9.0F, 0.0F, (float) Math.PI, 0.0F));
        partdefinition.addOrReplaceChild("left", CubeListBuilder.create().texOffs(0, 43).addBox(-14.0F, -7.0F, -1.0F, 28.0F, 6.0F, 2.0F), PartPose.offset(0.0F, 4.0F, 9.0F));
        partdefinition.addOrReplaceChild("chest_bottom", CubeListBuilder.create().texOffs(0, 110).addBox(-4.0F, -5.0F, -2.0F, 12.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3F, 1.0F, -2F, 0.0F, (-(float)Math.PI / 2F), 0.0F));
        partdefinition.addOrReplaceChild("chest_lid", CubeListBuilder.create().texOffs(0, 89).addBox(-6.0F, -15.0F, 1.0F, 12.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0F, 5, 0.0F, 0.0F, (-(float)Math.PI / 2F), 0.0F));

        int j1 = 20;
        int k1 = 7;
        int l1 = 6;
        float f = -5.0F;
        partdefinition.addOrReplaceChild("left_paddle", CubeListBuilder.create().texOffs(62, 0).addBox(-1.0F, 0.0F, -5.0F, 2.0F, 2.0F, 18.0F).addBox(-1.001F, -3.0F, 8.0F, 1.0F, 6.0F, 7.0F), PartPose.offsetAndRotation(3.0F, -5.0F, 9.0F, 0.0F, 0.0F, 0.19634955F));
        partdefinition.addOrReplaceChild("right_paddle", CubeListBuilder.create().texOffs(62, 20).addBox(-1.0F, 0.0F, -5.0F, 2.0F, 2.0F, 18.0F).addBox(0.001F, -3.0F, 8.0F, 1.0F, 6.0F, 7.0F), PartPose.offsetAndRotation(3.0F, -5.0F, -9.0F, 0.0F, (float) Math.PI, 0.19634955F));
        partdefinition.addOrReplaceChild("water_patch", CubeListBuilder.create().texOffs(0, 0).addBox(-14.0F, -9.0F, -3.0F, 28.0F, 16.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -3.0F, 1.0F, ((float) Math.PI / 2F), 0.0F, 0.0F));
        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    /**
     * Sets this entity's model rotation angles
     */
    public void setupAnim(ShulkerBoatEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        animatePaddle(pEntity, 0, this.leftPaddle, pLimbSwing);
        animatePaddle(pEntity, 1, this.rightPaddle, pLimbSwing);
    }

    public ImmutableList<ModelPart> parts() {
        return this.parts;
    }

    public ModelPart waterPatch() {
        return this.waterPatch;
    }

    private static void animatePaddle(ShulkerBoatEntity pBoat, int pSide, ModelPart pPaddle, float pLimbSwing) {
        float f = pBoat.getRowingTime(pSide, pLimbSwing);
        pPaddle.xRot = Mth.clampedLerp((-(float) Math.PI / 3F), -0.2617994F, (Mth.sin(-f) + 1.0F) / 2.0F);
        pPaddle.yRot = Mth.clampedLerp((-(float) Math.PI / 4F), ((float) Math.PI / 4F), (Mth.sin(-f + 1.0F) + 1.0F) / 2.0F);
        if (pSide == 1) {
            pPaddle.yRot = (float) Math.PI - pPaddle.yRot;
        }

    }
}