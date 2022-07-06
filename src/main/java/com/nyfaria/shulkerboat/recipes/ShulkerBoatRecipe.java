package com.nyfaria.shulkerboat.recipes;

import com.google.gson.JsonObject;
import com.nyfaria.shulkerboat.init.ItemInit;
import com.nyfaria.shulkerboat.item.ShulkerBoatItem;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraftforge.common.Tags;

import javax.annotation.Nullable;


public class ShulkerBoatRecipe extends ShapelessRecipe {


    public ShulkerBoatRecipe(ResourceLocation pId, String pGroup, ItemStack pResult, NonNullList<Ingredient> pIngredients) {
        super(pId, pGroup, pResult, pIngredients);
    }

    @Override
    public boolean matches(CraftingContainer pInv, Level pLevel) {
        int i = 0;
        int j = 0;

        for(int k = 0; k < pInv.getContainerSize(); ++k) {
            ItemStack itemstack = pInv.getItem(k);
            if (!itemstack.isEmpty()) {
                if (Block.byItem(itemstack.getItem()) instanceof ShulkerBoxBlock) {
                    ++i;
                } else {
                    if (!itemstack.is(ItemTags.BOATS)) {
                        return false;
                    }

                    ++j;
                }

                if (j > 1 || i > 1) {
                    return false;
                }
            }
        }

        return i == 1 && j == 1;
    }

    @Override
    public ItemStack assemble(CraftingContainer pInv) {
        ItemStack shulkerStack = ItemStack.EMPTY;
        BoatItem boatStack = null;

        for(int i = 0; i < pInv.getContainerSize(); ++i) {
            ItemStack itemstack1 = pInv.getItem(i);
            if (!itemstack1.isEmpty()) {
                Item item = itemstack1.getItem();
                if (Block.byItem(item) instanceof ShulkerBoxBlock) {
                    shulkerStack = itemstack1;
                } else {
                    boatStack = ((BoatItem)itemstack1.getItem());
                }
            }
        }
        Boat.Type type = boatStack.type;
        DyeColor dye = ShulkerBoxBlock.getColorFromItem(shulkerStack.getItem());
        ItemStack itemstack2 = new ItemStack(ItemInit.ITEMS.getEntries().stream().filter(
                item2 -> ((ShulkerBoatItem) item2.get()).getColor() == dye && ((ShulkerBoatItem) item2.get()).getType() == type).findFirst().get().get());

        if (shulkerStack.hasTag()) {
            CompoundTag beTag = BlockItem.getBlockEntityData(shulkerStack);
            ListTag itemsTag = beTag.getList("Items", 10);
            CompoundTag newTag = new CompoundTag();
            newTag.put("Items", itemsTag);
            itemstack2.setTag(newTag);

        }

        return itemstack2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return super.getSerializer();
    }

    public static class Serializer /*extends ForgeRegistryEntry<RecipeSerializer<?>>*/ implements RecipeSerializer<ShulkerBoatRecipe> {
        @Override
        public ShulkerBoatRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            ShapelessRecipe recipe = RecipeSerializer.SHAPELESS_RECIPE.fromJson(recipeId, json);
            return new ShulkerBoatRecipe(recipeId, recipe.getGroup(), recipe.getResultItem(), recipe.getIngredients());
        }

        @Nullable
        @Override
        public ShulkerBoatRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            ShapelessRecipe recipe = RecipeSerializer.SHAPELESS_RECIPE.fromNetwork(recipeId, buffer);
            return new ShulkerBoatRecipe(recipeId, recipe.getGroup(), recipe.getResultItem(), recipe.getIngredients());
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, ShulkerBoatRecipe recipe) {
            RecipeSerializer.SHAPELESS_RECIPE.toNetwork(buffer, recipe);
        }
    }
}

