package com.nyfaria.shulkerboat.datagen;

import com.google.common.base.Preconditions;
import com.nyfaria.shulkerboat.NyfsShulkerBoat;
import com.nyfaria.shulkerboat.init.ItemInit;
import com.nyfaria.shulkerboat.item.ShulkerBoatItem;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, NyfsShulkerBoat.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

//        Stream.of()
//                .map(Supplier::get)
//                .forEach(this::simpleHandHeldModel);

//        Stream.of()
//                .map(Supplier::get)
//                .forEach(this::simpleGeneratedModel);

//        Stream.of()
//                .map(Supplier::get)
//                .forEach(this::simpleBlockItemModel);

        ItemInit.ITEMS.getEntries().stream().map(Supplier::get).map(item ->(ShulkerBoatItem) item)
                .forEach(this::shulkerBoat);

    }

    protected ItemModelBuilder simpleBlockItemModel(Block block) {
        String name = getName(block);
        return withExistingParent(name, modLoc("block/" + name));
    }

    protected  ItemModelBuilder shulkerBoat(ShulkerBoatItem item) {
        String name = getName(item);
        String colorName = "";
        if (item.getColor() != null) {
            colorName = "_" + item.getColor().getName();
        }
        return withExistingParent(name, mcLoc("item/" + item.getType().getName() + "_chest_boat"))
                .texture("layer1", "item/shulker_layer" + colorName);
    }
    protected ItemModelBuilder simpleGeneratedModel(Item item) {
        return simpleModel(item, mcLoc("item/generated"));
    }

    protected ItemModelBuilder simpleHandHeldModel(Item item) {
        return simpleModel(item, mcLoc("item/handheld"));
    }

    protected ItemModelBuilder simpleModel(Item item, ResourceLocation parent) {
        String name = getName(item);
        return singleTexture(name, parent, "layer0", modLoc("item/" + name));
    }


    protected String getName(Item item) {
        return ForgeRegistries.ITEMS.getKey(item).getPath();
    }

    protected String getName(Block item) {
        return ForgeRegistries.BLOCKS.getKey(item).getPath();
    }

    @Override
    public ItemModelBuilder getBuilder(String path) {
        Preconditions.checkNotNull(path, "Path must not be null");
        ResourceLocation outputLoc = extendWithFolder(path.contains(":") ? new ResourceLocation(path) : new ResourceLocation(modid, path));
        this.existingFileHelper.trackGenerated(outputLoc, MODEL);
        return generatedModels.computeIfAbsent(outputLoc, loc -> new ItemModelBuilder(loc, existingFileHelper));
    }

    private ResourceLocation extendWithFolder(ResourceLocation rl) {
        if (rl.getPath().contains("/")) {
            return rl;
        }
        return new ResourceLocation(rl.getNamespace(), folder + "/" + rl.getPath());
    }
}
