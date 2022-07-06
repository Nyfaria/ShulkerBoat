package com.nyfaria.shulkerboat.datagen;

import com.nyfaria.shulkerboat.NyfsShulkerBoat;
import com.nyfaria.shulkerboat.init.ItemInit;
import com.nyfaria.shulkerboat.init.TagInit;
import com.nyfaria.shulkerboat.item.ShulkerBoatItem;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> recipeSaver) {
        ItemInit.ITEMS.getEntries()
                .stream().map(Supplier::get)
                .map(item ->(ShulkerBoatItem)item)
                .forEach(theItem -> boatPlusBoxRecipe(theItem, recipeSaver));
//        ItemInit.ITEMS.getEntries().stream().filter(item -> ((ShulkerBoatItem)item.get()).getColor() != null)
//                .map(Supplier::get)
//                .map(item ->(ShulkerBoatItem)item)
//                .forEach(theItem ->
//                                boatPlusDye(theItem, recipeSaver));

    }

    public void boatPlusBoxRecipe(ShulkerBoatItem boat, Consumer<FinishedRecipe> recipeSaver) {
        Item boatItem = ForgeRegistries.ITEMS.getValues().stream().filter(item -> {
            if (item instanceof BoatItem theBoat) {
                return boat.getType() == theBoat.type;
            }
            return false;
        }).findFirst().get();

        ShapelessRecipeBuilder.shapeless(boat)
                .requires(ShulkerBoxBlock.getBlockByColor(boat.getColor()))
                .requires(boatItem)
                .unlockedBy("has_boat",has(boatItem)).save(recipeSaver);
    }

    public void boatPlusDye(ShulkerBoatItem boat, Consumer<FinishedRecipe> recipeSaver){
        String name2 = ForgeRegistries.ITEMS.getKey(boat).getPath();
        ShapelessRecipeBuilder.shapeless(boat)
                .requires(TagInit.SHULKER_BOATS)
                .requires(DyeItem.byColor(boat.getColor()))
                .unlockedBy("has_shulker_boat",has(TagInit.SHULKER_BOATS)).save(recipeSaver, new ResourceLocation(NyfsShulkerBoat.MODID,name2 + "with_dye"));
    }
}
