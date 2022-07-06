package com.nyfaria.shulkerboat.init;

import com.nyfaria.shulkerboat.NyfsShulkerBoat;
import com.nyfaria.shulkerboat.recipes.ShulkerBoatDying;
import com.nyfaria.shulkerboat.recipes.ShulkerBoatRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleRecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RecipeInit {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPES = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, NyfsShulkerBoat.MODID);

    public static final RegistryObject<RecipeSerializer<ShulkerBoatDying>> SHULKER_BOAT_DYING = RECIPES.register("shulker_boat_dying", ()->new SimpleRecipeSerializer<>(ShulkerBoatDying::new));
    public static final RegistryObject<RecipeSerializer<ShulkerBoatRecipe>> SHULKER_BOAT_RECIPE = RECIPES.register("shulker_boat_recipe", ShulkerBoatRecipe.Serializer::new);
}
