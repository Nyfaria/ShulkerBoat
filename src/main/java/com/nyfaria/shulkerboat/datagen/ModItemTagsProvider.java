package com.nyfaria.shulkerboat.datagen;

import com.nyfaria.shulkerboat.NyfsShulkerBoat;
import com.nyfaria.shulkerboat.init.ItemInit;
import com.nyfaria.shulkerboat.init.TagInit;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class ModItemTagsProvider extends TagsProvider<Item> {


    public ModItemTagsProvider(DataGenerator p_126546_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_126546_, Registry.ITEM, NyfsShulkerBoat.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        ItemInit.ITEMS.getEntries().stream().map(Supplier::get)
                .forEach(tag(TagInit.SHULKER_BOATS)::add);
    }
}
