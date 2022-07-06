package com.nyfaria.shulkerboat.recipes;

import com.google.gson.JsonObject;
import com.nyfaria.shulkerboat.init.ItemInit;
import com.nyfaria.shulkerboat.init.RecipeInit;
import com.nyfaria.shulkerboat.item.ShulkerBoatItem;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ShulkerBoxBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import javax.annotation.Nullable;
import java.util.function.Function;


public class ShulkerBoatDying extends CustomRecipe {


    public ShulkerBoatDying(ResourceLocation pId) {
        super(pId);
    }



    @Override
    public boolean matches(CraftingContainer pInv, Level pLevel) {
        int i = 0;
        int j = 0;

        for(int k = 0; k < pInv.getContainerSize(); ++k) {
            ItemStack itemstack = pInv.getItem(k);
            if (!itemstack.isEmpty()) {
                if (itemstack.getItem() instanceof ShulkerBoatItem) {
                    ++i;
                } else {
                    if (!itemstack.is(net.minecraftforge.common.Tags.Items.DYES)) {
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
        ItemStack itemstack = ItemStack.EMPTY;
        net.minecraft.world.item.DyeColor dyecolor = net.minecraft.world.item.DyeColor.WHITE;

        for(int i = 0; i < pInv.getContainerSize(); ++i) {
            ItemStack itemstack1 = pInv.getItem(i);
            if (!itemstack1.isEmpty()) {
                Item item = itemstack1.getItem();
                if (item instanceof ShulkerBoatItem) {
                    itemstack = itemstack1;
                } else {
                    net.minecraft.world.item.DyeColor tmp = net.minecraft.world.item.DyeColor.getColor(itemstack1);
                    if (tmp != null) dyecolor = tmp;
                }
            }
        }
        ShulkerBoatItem item = (ShulkerBoatItem) itemstack.getItem();
        DyeColor dye = dyecolor;
        ItemStack itemstack2 = new ItemStack(ItemInit.ITEMS.getEntries().stream().filter(
                item2 -> ((ShulkerBoatItem)item2.get()).getType() == item.getType() && ((ShulkerBoatItem) item2.get()).getColor() == dye).findFirst().get().get());

        if (itemstack.hasTag()) {
            itemstack2.setTag(itemstack.getTag().copy());
        }

        return itemstack2;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeInit.SHULKER_BOAT_DYING.get();
    }

}

