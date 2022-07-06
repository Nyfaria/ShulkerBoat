package com.nyfaria.shulkerboat.event;

import com.nyfaria.shulkerboat.NyfsShulkerBoat;
import com.nyfaria.shulkerboat.entity.ShulkerBoatEntityRenderer;
import com.nyfaria.shulkerboat.entity.ShulkerBoatModel;
import com.nyfaria.shulkerboat.init.EntityInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NyfsShulkerBoat.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.SHULKER_BOAT.get(), ShulkerBoatEntityRenderer::new);
    }
    @SubscribeEvent
    public static void onRenderLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ShulkerBoatModel.LAYER_LOCATION,ShulkerBoatModel::createBodyModel);
    }
}
