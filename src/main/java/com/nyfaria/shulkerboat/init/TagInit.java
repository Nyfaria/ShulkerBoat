package com.nyfaria.shulkerboat.init;

import com.nyfaria.shulkerboat.NyfsShulkerBoat;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class TagInit {

    public static final TagKey<Item> SHULKER_BOATS = itemTag("shulker_boats");

    public static void init() {
    }
    public static TagKey<Item> itemTag(String path) {
        return ItemTags.create(new ResourceLocation(NyfsShulkerBoat.MODID, path));
    }
}
