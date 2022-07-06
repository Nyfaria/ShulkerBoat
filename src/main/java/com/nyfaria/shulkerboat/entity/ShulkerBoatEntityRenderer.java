package com.nyfaria.shulkerboat.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import com.nyfaria.shulkerboat.NyfsShulkerBoat;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.DyeColor;

import java.util.Map;

public class ShulkerBoatEntityRenderer extends EntityRenderer<ShulkerBoatEntity> {

    public final ShulkerBoatModel boatModel;
    private final Map<Boat.Type, Map<DyeColor, Pair<ResourceLocation, ShulkerBoatModel>>> boatResources;
    private final Map<Boat.Type, Pair<ResourceLocation, ShulkerBoatModel>> colorlessBoats;
    public final ResourceLocation texture = new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/oak.png");

    public ShulkerBoatEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.8F;
        boatModel = new ShulkerBoatModel(context.bakeLayer(ShulkerBoatModel.LAYER_LOCATION));
        boatResources = Map.of(
                Boat.Type.OAK, Map.ofEntries(
                        Map.entry(DyeColor.WHITE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/white_oak.png"), boatModel)),
                        Map.entry(DyeColor.ORANGE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/orange_oak.png"), boatModel)),
                        Map.entry(DyeColor.MAGENTA, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/magenta_oak.png"), boatModel)),
                        Map.entry(DyeColor.LIGHT_BLUE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/light_blue_oak.png"), boatModel)),
                        Map.entry(DyeColor.YELLOW, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/yellow_oak.png"), boatModel)),
                        Map.entry(DyeColor.LIME, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/lime_oak.png"), boatModel)),
                        Map.entry(DyeColor.PINK, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/pink_oak.png"), boatModel)),
                        Map.entry(DyeColor.GRAY, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/gray_oak.png"), boatModel)),
                        Map.entry(DyeColor.LIGHT_GRAY, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/light_gray_oak.png"), boatModel)),
                        Map.entry(DyeColor.CYAN, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/cyan_oak.png"), boatModel)),
                        Map.entry(DyeColor.PURPLE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/purple_oak.png"), boatModel)),
                        Map.entry(DyeColor.BLUE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/blue_oak.png"), boatModel)),
                        Map.entry(DyeColor.BROWN, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/brown_oak.png"), boatModel)),
                        Map.entry(DyeColor.GREEN, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/green_oak.png"), boatModel)),
                        Map.entry(DyeColor.RED, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/red_oak.png"), boatModel)),
                        Map.entry(DyeColor.BLACK, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/black_oak.png"), boatModel))

                ),
                Boat.Type.SPRUCE, Map.ofEntries(
                        Map.entry(DyeColor.WHITE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/white_spruce.png"), boatModel)),
                        Map.entry(DyeColor.ORANGE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/orange_spruce.png"), boatModel)),
                        Map.entry(DyeColor.MAGENTA, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/magenta_spruce.png"), boatModel)),
                        Map.entry(DyeColor.LIGHT_BLUE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/light_blue_spruce.png"), boatModel)),
                        Map.entry(DyeColor.YELLOW, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/yellow_spruce.png"), boatModel)),
                        Map.entry(DyeColor.LIME, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/lime_spruce.png"), boatModel)),
                        Map.entry(DyeColor.PINK, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/pink_spruce.png"), boatModel)),
                        Map.entry(DyeColor.GRAY, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/gray_spruce.png"), boatModel)),
                        Map.entry(DyeColor.LIGHT_GRAY, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/light_gray_spruce.png"), boatModel)),
                        Map.entry(DyeColor.CYAN, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/cyan_spruce.png"), boatModel)),
                        Map.entry(DyeColor.PURPLE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/purple_spruce.png"), boatModel)),
                        Map.entry(DyeColor.BLUE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/blue_spruce.png"), boatModel)),
                        Map.entry(DyeColor.BROWN, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/brown_spruce.png"), boatModel)),
                        Map.entry(DyeColor.GREEN, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/green_spruce.png"), boatModel)),
                        Map.entry(DyeColor.RED, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/red_spruce.png"), boatModel)),
                        Map.entry(DyeColor.BLACK, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/black_spruce.png"), boatModel))
                ),
                Boat.Type.MANGROVE, Map.ofEntries(
                        Map.entry(DyeColor.WHITE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/white_mangrove.png"), boatModel)),
                        Map.entry(DyeColor.ORANGE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/orange_mangrove.png"), boatModel)),
                        Map.entry(DyeColor.MAGENTA, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/magenta_mangrove.png"), boatModel)),
                        Map.entry(DyeColor.LIGHT_BLUE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/light_blue_mangrove.png"), boatModel)),
                        Map.entry(DyeColor.YELLOW, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/yellow_mangrove.png"), boatModel)),
                        Map.entry(DyeColor.LIME, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/lime_mangrove.png"), boatModel)),
                        Map.entry(DyeColor.PINK, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/pink_mangrove.png"), boatModel)),
                        Map.entry(DyeColor.GRAY, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/gray_mangrove.png"), boatModel)),
                        Map.entry(DyeColor.LIGHT_GRAY, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/light_gray_mangrove.png"), boatModel)),
                        Map.entry(DyeColor.CYAN, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/cyan_mangrove.png"), boatModel)),
                        Map.entry(DyeColor.PURPLE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/purple_mangrove.png"), boatModel)),
                        Map.entry(DyeColor.BLUE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/blue_mangrove.png"), boatModel)),
                        Map.entry(DyeColor.BROWN, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/brown_mangrove.png"), boatModel)),
                        Map.entry(DyeColor.GREEN, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/green_mangrove.png"), boatModel)),
                        Map.entry(DyeColor.RED, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/red_mangrove.png"), boatModel)),
                        Map.entry(DyeColor.BLACK, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/black_mangrove.png"), boatModel))
                ),
                Boat.Type.DARK_OAK, Map.ofEntries(
                        Map.entry(DyeColor.WHITE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/white_dark_oak.png"), boatModel)),
                        Map.entry(DyeColor.ORANGE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/orange_dark_oak.png"), boatModel)),
                        Map.entry(DyeColor.MAGENTA, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/magenta_dark_oak.png"), boatModel)),
                        Map.entry(DyeColor.LIGHT_BLUE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/light_blue_dark_oak.png"), boatModel)),
                        Map.entry(DyeColor.YELLOW, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/yellow_dark_oak.png"), boatModel)),
                        Map.entry(DyeColor.LIME, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/lime_dark_oak.png"), boatModel)),
                        Map.entry(DyeColor.PINK, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/pink_dark_oak.png"), boatModel)),
                        Map.entry(DyeColor.GRAY, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/gray_dark_oak.png"), boatModel)),
                        Map.entry(DyeColor.LIGHT_GRAY, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/light_gray_dark_oak.png"), boatModel)),
                        Map.entry(DyeColor.CYAN, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/cyan_dark_oak.png"), boatModel)),
                        Map.entry(DyeColor.PURPLE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/purple_dark_oak.png"), boatModel)),
                        Map.entry(DyeColor.BLUE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/blue_dark_oak.png"), boatModel)),
                        Map.entry(DyeColor.BROWN, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/brown_dark_oak.png"), boatModel)),
                        Map.entry(DyeColor.GREEN, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/green_dark_oak.png"), boatModel)),
                        Map.entry(DyeColor.RED, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/red_dark_oak.png"), boatModel)),
                        Map.entry(DyeColor.BLACK, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/black_dark_oak.png"), boatModel))
                ),
                Boat.Type.JUNGLE, Map.ofEntries(
                        Map.entry(DyeColor.WHITE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/white_jungle.png"), boatModel)),
                        Map.entry(DyeColor.ORANGE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/orange_jungle.png"), boatModel)),
                        Map.entry(DyeColor.MAGENTA, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/magenta_jungle.png"), boatModel)),
                        Map.entry(DyeColor.LIGHT_BLUE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/light_blue_jungle.png"), boatModel)),
                        Map.entry(DyeColor.YELLOW, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/yellow_jungle.png"), boatModel)),
                        Map.entry(DyeColor.LIME, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/lime_jungle.png"), boatModel)),
                        Map.entry(DyeColor.PINK, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/pink_jungle.png"), boatModel)),
                        Map.entry(DyeColor.GRAY, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/gray_jungle.png"), boatModel)),
                        Map.entry(DyeColor.LIGHT_GRAY, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/light_gray_jungle.png"), boatModel)),
                        Map.entry(DyeColor.CYAN, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/cyan_jungle.png"), boatModel)),
                        Map.entry(DyeColor.PURPLE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/purple_jungle.png"), boatModel)),
                        Map.entry(DyeColor.BLUE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/blue_jungle.png"), boatModel)),
                        Map.entry(DyeColor.BROWN, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/brown_jungle.png"), boatModel)),
                        Map.entry(DyeColor.GREEN, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/green_jungle.png"), boatModel)),
                        Map.entry(DyeColor.RED, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/red_jungle.png"), boatModel)),
                        Map.entry(DyeColor.BLACK, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/black_jungle.png"), boatModel))
                ),
                Boat.Type.BIRCH, Map.ofEntries(
                        Map.entry(DyeColor.WHITE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/white_birch.png"), boatModel)),
                        Map.entry(DyeColor.ORANGE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/orange_birch.png"), boatModel)),
                        Map.entry(DyeColor.MAGENTA, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/magenta_birch.png"), boatModel)),
                        Map.entry(DyeColor.LIGHT_BLUE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/light_blue_birch.png"), boatModel)),
                        Map.entry(DyeColor.YELLOW, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/yellow_birch.png"), boatModel)),
                        Map.entry(DyeColor.LIME, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/lime_birch.png"), boatModel)),
                        Map.entry(DyeColor.PINK, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/pink_birch.png"), boatModel)),
                        Map.entry(DyeColor.GRAY, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/gray_birch.png"), boatModel)),
                        Map.entry(DyeColor.LIGHT_GRAY, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/light_gray_birch.png"), boatModel)),
                        Map.entry(DyeColor.CYAN, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/cyan_birch.png"), boatModel)),
                        Map.entry(DyeColor.PURPLE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/purple_birch.png"), boatModel)),
                        Map.entry(DyeColor.BLUE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/blue_birch.png"), boatModel)),
                        Map.entry(DyeColor.BROWN, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/brown_birch.png"), boatModel)),
                        Map.entry(DyeColor.GREEN, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/green_birch.png"), boatModel)),
                        Map.entry(DyeColor.RED, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/red_birch.png"), boatModel)),
                        Map.entry(DyeColor.BLACK, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/black_birch.png"), boatModel))
                ),
                Boat.Type.ACACIA, Map.ofEntries(
                        Map.entry(DyeColor.WHITE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/white_acacia.png"), boatModel)),
                        Map.entry(DyeColor.ORANGE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/orange_acacia.png"), boatModel)),
                        Map.entry(DyeColor.MAGENTA, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/magenta_acacia.png"), boatModel)),
                        Map.entry(DyeColor.LIGHT_BLUE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/light_blue_acacia.png"), boatModel)),
                        Map.entry(DyeColor.YELLOW, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/yellow_acacia.png"), boatModel)),
                        Map.entry(DyeColor.LIME, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/lime_acacia.png"), boatModel)),
                        Map.entry(DyeColor.PINK, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/pink_acacia.png"), boatModel)),
                        Map.entry(DyeColor.GRAY, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/gray_acacia.png"), boatModel)),
                        Map.entry(DyeColor.LIGHT_GRAY, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/light_gray_acacia.png"), boatModel)),
                        Map.entry(DyeColor.CYAN, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/cyan_acacia.png"), boatModel)),
                        Map.entry(DyeColor.PURPLE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/purple_acacia.png"), boatModel)),
                        Map.entry(DyeColor.BLUE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/blue_acacia.png"), boatModel)),
                        Map.entry(DyeColor.BROWN, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/brown_acacia.png"), boatModel)),
                        Map.entry(DyeColor.GREEN, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/green_acacia.png"), boatModel)),
                        Map.entry(DyeColor.RED, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/red_acacia.png"), boatModel)),
                        Map.entry(DyeColor.BLACK, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/black_acacia.png"), boatModel))
                )
        );
        colorlessBoats = Map.of(
                Boat.Type.OAK, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/oak.png"), boatModel),
                Boat.Type.SPRUCE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/spruce.png"), boatModel),
                Boat.Type.BIRCH, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/birch.png"), boatModel),
                Boat.Type.JUNGLE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/jungle.png"), boatModel),
                Boat.Type.ACACIA, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/acacia.png"), boatModel),
                Boat.Type.DARK_OAK, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/dark_oak.png"), boatModel),
                Boat.Type.MANGROVE, Pair.of(new ResourceLocation(NyfsShulkerBoat.MODID, "textures/boat/mangrove.png"), boatModel)
        );

    }

    private BoatModel createBoatModel(EntityRendererProvider.Context p_234569_, Boat.Type p_234570_, boolean p_234571_) {
        ModelLayerLocation modellayerlocation = p_234571_ ? ModelLayers.createChestBoatModelName(p_234570_) : ModelLayers.createBoatModelName(p_234570_);
        return new BoatModel(p_234569_.bakeLayer(modellayerlocation), p_234571_);
    }

    private static String getTextureLocation(Boat.Type p_234566_) {
        return "textures/boat/" + p_234566_.getName() + ".png";
    }

    public void render(ShulkerBoatEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose();
        pMatrixStack.translate(0.0D, 0.375D, 0.0D);
        pMatrixStack.mulPose(Vector3f.YP.rotationDegrees(180.0F - pEntityYaw));
        float f = (float) pEntity.getHurtTime() - pPartialTicks;
        float f1 = pEntity.getDamage() - pPartialTicks;
        if (f1 < 0.0F) {
            f1 = 0.0F;
        }

        if (f > 0.0F) {
            pMatrixStack.mulPose(Vector3f.XP.rotationDegrees(Mth.sin(f) * f * f1 / 10.0F * (float) pEntity.getHurtDir()));
        }

        float f2 = pEntity.getBubbleAngle(pPartialTicks);
        if (!Mth.equal(f2, 0.0F)) {
            pMatrixStack.mulPose(new Quaternion(new Vector3f(1.0F, 0.0F, 1.0F), pEntity.getBubbleAngle(pPartialTicks), true));
        }

        Pair<ResourceLocation, ShulkerBoatModel> pair = getModelWithLocation(pEntity);
        ResourceLocation resourcelocation = pair.getFirst();
        ShulkerBoatModel boatmodel = pair.getSecond();
        pMatrixStack.scale(-1.0F, -1.0F, 1.0F);
        pMatrixStack.mulPose(Vector3f.YP.rotationDegrees(90.0F));
        boatmodel.setupAnim(pEntity, pPartialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer vertexconsumer = pBuffer.getBuffer(boatmodel.renderType(resourcelocation));
        boatmodel.renderToBuffer(pMatrixStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        if (!pEntity.isUnderWater()) {
            VertexConsumer vertexconsumer1 = pBuffer.getBuffer(RenderType.waterMask());
            boatmodel.waterPatch().render(pMatrixStack, vertexconsumer1, pPackedLight, OverlayTexture.NO_OVERLAY);
        }

        pMatrixStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    /**
     * Returns the location of an entity's texture.
     */
    @Deprecated // forge: override getModelWithLocation to change the texture / model
    public ResourceLocation getTextureLocation(ShulkerBoatEntity pEntity) {
        return getModelWithLocation(pEntity).getFirst();
    }

    public Pair<ResourceLocation, ShulkerBoatModel> getModelWithLocation(ShulkerBoatEntity boat) {
        if(boat.getColor() == null){
            return colorlessBoats.get(boat.getBoatType());
        }
        return boatResources.get(boat.getBoatType()).get(boat.getColor());
    }
}
