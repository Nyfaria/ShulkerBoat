package com.nyfaria.shulkerboat.init;

import com.nyfaria.shulkerboat.NyfsShulkerBoat;
import com.nyfaria.shulkerboat.item.ShulkerBoatItem;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NyfsShulkerBoat.MODID);

    public static final RegistryObject<ShulkerBoatItem> SPRUCE_SHULKER_BOAT = ITEMS.register("spruce_shulker_boat",()-> new ShulkerBoatItem(true, Boat.Type.SPRUCE, null,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> SPRUCE_SHULKER_BOAT_RED = ITEMS.register("spruce_shulker_boat_red",()-> new ShulkerBoatItem(true, Boat.Type.SPRUCE, DyeColor.RED,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> SPRUCE_SHULKER_BOAT_GREEN = ITEMS.register("spruce_shulker_boat_green",()-> new ShulkerBoatItem(true, Boat.Type.SPRUCE,DyeColor.GREEN ,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> SPRUCE_SHULKER_BOAT_BLUE = ITEMS.register("spruce_shulker_boat_blue",()-> new ShulkerBoatItem(true, Boat.Type.SPRUCE, DyeColor.BLUE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> SPRUCE_SHULKER_BOAT_PURPLE = ITEMS.register("spruce_shulker_boat_purple",()-> new ShulkerBoatItem(true, Boat.Type.SPRUCE, DyeColor.PURPLE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> SPRUCE_SHULKER_BOAT_CYAN = ITEMS.register("spruce_shulker_boat_cyan",()-> new ShulkerBoatItem(true, Boat.Type.SPRUCE, DyeColor.CYAN,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> SPRUCE_SHULKER_BOAT_BLACK = ITEMS.register("spruce_shulker_boat_black",()-> new ShulkerBoatItem(true, Boat.Type.SPRUCE, DyeColor.BLACK, (new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> SPRUCE_SHULKER_BOAT_GRAY = ITEMS.register("spruce_shulker_boat_gray",()-> new ShulkerBoatItem(true, Boat.Type.SPRUCE, DyeColor.GRAY,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> SPRUCE_SHULKER_BOAT_WHITE = ITEMS.register("spruce_shulker_boat_white",()-> new ShulkerBoatItem(true, Boat.Type.SPRUCE, DyeColor.WHITE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> SPRUCE_SHULKER_BOAT_ORANGE = ITEMS.register("spruce_shulker_boat_orange",()-> new ShulkerBoatItem(true, Boat.Type.SPRUCE, DyeColor.ORANGE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> SPRUCE_SHULKER_BOAT_MAGENTA = ITEMS.register("spruce_shulker_boat_magenta",()-> new ShulkerBoatItem(true, Boat.Type.SPRUCE, DyeColor.MAGENTA,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> SPRUCE_SHULKER_BOAT_LIGHT_BLUE = ITEMS.register("spruce_shulker_boat_light_blue",()-> new ShulkerBoatItem(true, Boat.Type.SPRUCE, DyeColor.LIGHT_BLUE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> SPRUCE_SHULKER_BOAT_YELLOW = ITEMS.register("spruce_shulker_boat_yellow",()-> new ShulkerBoatItem(true, Boat.Type.SPRUCE, DyeColor.YELLOW,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> SPRUCE_SHULKER_BOAT_LIME = ITEMS.register("spruce_shulker_boat_lime",()-> new ShulkerBoatItem(true, Boat.Type.SPRUCE, DyeColor.LIME,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> SPRUCE_SHULKER_BOAT_PINK = ITEMS.register("spruce_shulker_boat_pink",()-> new ShulkerBoatItem(true, Boat.Type.SPRUCE, DyeColor.PINK,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> SPRUCE_SHULKER_BOAT_BROWN = ITEMS.register("spruce_shulker_boat_brown",()-> new ShulkerBoatItem(true, Boat.Type.SPRUCE, DyeColor.BROWN,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> SPRUCE_SHULKER_BOAT_LIGHT_GRAY = ITEMS.register("spruce_shulker_boat_light_gray",()-> new ShulkerBoatItem(true, Boat.Type.SPRUCE, DyeColor.LIGHT_GRAY,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> OAK_SHULKER_BOAT = ITEMS.register("oak_shulker_boat",()-> new ShulkerBoatItem(true, Boat.Type.OAK, null,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> OAK_SHULKER_BOAT_RED = ITEMS.register("oak_shulker_boat_red",()-> new ShulkerBoatItem(true, Boat.Type.OAK, DyeColor.RED,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> OAK_SHULKER_BOAT_GREEN = ITEMS.register("oak_shulker_boat_green",()-> new ShulkerBoatItem(true, Boat.Type.OAK,DyeColor.GREEN ,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> OAK_SHULKER_BOAT_BLUE = ITEMS.register("oak_shulker_boat_blue",()-> new ShulkerBoatItem(true, Boat.Type.OAK, DyeColor.BLUE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> OAK_SHULKER_BOAT_PURPLE = ITEMS.register("oak_shulker_boat_purple",()-> new ShulkerBoatItem(true, Boat.Type.OAK, DyeColor.PURPLE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> OAK_SHULKER_BOAT_CYAN = ITEMS.register("oak_shulker_boat_cyan",()-> new ShulkerBoatItem(true, Boat.Type.OAK, DyeColor.CYAN,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> OAK_SHULKER_BOAT_BLACK = ITEMS.register("oak_shulker_boat_black",()-> new ShulkerBoatItem(true, Boat.Type.OAK, DyeColor.BLACK, (new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> OAK_SHULKER_BOAT_GRAY = ITEMS.register("oak_shulker_boat_gray",()-> new ShulkerBoatItem(true, Boat.Type.OAK, DyeColor.GRAY,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> OAK_SHULKER_BOAT_WHITE = ITEMS.register("oak_shulker_boat_white",()-> new ShulkerBoatItem(true, Boat.Type.OAK, DyeColor.WHITE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> OAK_SHULKER_BOAT_ORANGE = ITEMS.register("oak_shulker_boat_orange",()-> new ShulkerBoatItem(true, Boat.Type.OAK, DyeColor.ORANGE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> OAK_SHULKER_BOAT_MAGENTA = ITEMS.register("oak_shulker_boat_magenta",()-> new ShulkerBoatItem(true, Boat.Type.OAK, DyeColor.MAGENTA,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> OAK_SHULKER_BOAT_LIGHT_BLUE = ITEMS.register("oak_shulker_boat_light_blue",()-> new ShulkerBoatItem(true, Boat.Type.OAK, DyeColor.LIGHT_BLUE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> OAK_SHULKER_BOAT_YELLOW = ITEMS.register("oak_shulker_boat_yellow",()-> new ShulkerBoatItem(true, Boat.Type.OAK, DyeColor.YELLOW,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> OAK_SHULKER_BOAT_LIME = ITEMS.register("oak_shulker_boat_lime",()-> new ShulkerBoatItem(true, Boat.Type.OAK, DyeColor.LIME,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> OAK_SHULKER_BOAT_PINK = ITEMS.register("oak_shulker_boat_pink",()-> new ShulkerBoatItem(true, Boat.Type.OAK, DyeColor.PINK,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> OAK_SHULKER_BOAT_BROWN = ITEMS.register("oak_shulker_boat_brown",()-> new ShulkerBoatItem(true, Boat.Type.OAK, DyeColor.BROWN,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> OAK_SHULKER_BOAT_LIGHT_GRAY = ITEMS.register("oak_shulker_boat_light_gray",()-> new ShulkerBoatItem(true, Boat.Type.OAK, DyeColor.LIGHT_GRAY,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> ACACIA_SHULKER_BOAT = ITEMS.register("acacia_shulker_boat",()-> new ShulkerBoatItem(true, Boat.Type.ACACIA, null,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> ACACIA_SHULKER_BOAT_RED = ITEMS.register("acacia_shulker_boat_red",()-> new ShulkerBoatItem(true, Boat.Type.ACACIA, DyeColor.RED,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> ACACIA_SHULKER_BOAT_GREEN = ITEMS.register("acacia_shulker_boat_green",()-> new ShulkerBoatItem(true, Boat.Type.ACACIA,DyeColor.GREEN ,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> ACACIA_SHULKER_BOAT_BLUE = ITEMS.register("acacia_shulker_boat_blue",()-> new ShulkerBoatItem(true, Boat.Type.ACACIA, DyeColor.BLUE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> ACACIA_SHULKER_BOAT_PURPLE = ITEMS.register("acacia_shulker_boat_purple",()-> new ShulkerBoatItem(true, Boat.Type.ACACIA, DyeColor.PURPLE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> ACACIA_SHULKER_BOAT_CYAN = ITEMS.register("acacia_shulker_boat_cyan",()-> new ShulkerBoatItem(true, Boat.Type.ACACIA, DyeColor.CYAN,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> ACACIA_SHULKER_BOAT_BLACK = ITEMS.register("acacia_shulker_boat_black",()-> new ShulkerBoatItem(true, Boat.Type.ACACIA, DyeColor.BLACK, (new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> ACACIA_SHULKER_BOAT_GRAY = ITEMS.register("acacia_shulker_boat_gray",()-> new ShulkerBoatItem(true, Boat.Type.ACACIA, DyeColor.GRAY,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> ACACIA_SHULKER_BOAT_WHITE = ITEMS.register("acacia_shulker_boat_white",()-> new ShulkerBoatItem(true, Boat.Type.ACACIA, DyeColor.WHITE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> ACACIA_SHULKER_BOAT_ORANGE = ITEMS.register("acacia_shulker_boat_orange",()-> new ShulkerBoatItem(true, Boat.Type.ACACIA, DyeColor.ORANGE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> ACACIA_SHULKER_BOAT_MAGENTA = ITEMS.register("acacia_shulker_boat_magenta",()-> new ShulkerBoatItem(true, Boat.Type.ACACIA, DyeColor.MAGENTA,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> ACACIA_SHULKER_BOAT_LIGHT_BLUE = ITEMS.register("acacia_shulker_boat_light_blue",()-> new ShulkerBoatItem(true, Boat.Type.ACACIA, DyeColor.LIGHT_BLUE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> ACACIA_SHULKER_BOAT_YELLOW = ITEMS.register("acacia_shulker_boat_yellow",()-> new ShulkerBoatItem(true, Boat.Type.ACACIA, DyeColor.YELLOW,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> ACACIA_SHULKER_BOAT_LIME = ITEMS.register("acacia_shulker_boat_lime",()-> new ShulkerBoatItem(true, Boat.Type.ACACIA, DyeColor.LIME,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> ACACIA_SHULKER_BOAT_PINK = ITEMS.register("acacia_shulker_boat_pink",()-> new ShulkerBoatItem(true, Boat.Type.ACACIA, DyeColor.PINK,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> ACACIA_SHULKER_BOAT_BROWN = ITEMS.register("acacia_shulker_boat_brown",()-> new ShulkerBoatItem(true, Boat.Type.ACACIA, DyeColor.BROWN,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> ACACIA_SHULKER_BOAT_LIGHT_GRAY = ITEMS.register("acacia_shulker_boat_light_gray",()-> new ShulkerBoatItem(true, Boat.Type.ACACIA, DyeColor.LIGHT_GRAY,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> BIRCH_SHULKER_BOAT = ITEMS.register("birch_shulker_boat",()-> new ShulkerBoatItem(true, Boat.Type.BIRCH, null,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> BIRCH_SHULKER_BOAT_RED = ITEMS.register("birch_shulker_boat_red",()-> new ShulkerBoatItem(true, Boat.Type.BIRCH, DyeColor.RED,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> BIRCH_SHULKER_BOAT_GREEN = ITEMS.register("birch_shulker_boat_green",()-> new ShulkerBoatItem(true, Boat.Type.BIRCH,DyeColor.GREEN ,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> BIRCH_SHULKER_BOAT_BLUE = ITEMS.register("birch_shulker_boat_blue",()-> new ShulkerBoatItem(true, Boat.Type.BIRCH, DyeColor.BLUE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> BIRCH_SHULKER_BOAT_PURPLE = ITEMS.register("birch_shulker_boat_purple",()-> new ShulkerBoatItem(true, Boat.Type.BIRCH, DyeColor.PURPLE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> BIRCH_SHULKER_BOAT_CYAN = ITEMS.register("birch_shulker_boat_cyan",()-> new ShulkerBoatItem(true, Boat.Type.BIRCH, DyeColor.CYAN,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> BIRCH_SHULKER_BOAT_BLACK = ITEMS.register("birch_shulker_boat_black",()-> new ShulkerBoatItem(true, Boat.Type.BIRCH, DyeColor.BLACK, (new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> BIRCH_SHULKER_BOAT_GRAY = ITEMS.register("birch_shulker_boat_gray",()-> new ShulkerBoatItem(true, Boat.Type.BIRCH, DyeColor.GRAY,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> BIRCH_SHULKER_BOAT_WHITE = ITEMS.register("birch_shulker_boat_white",()-> new ShulkerBoatItem(true, Boat.Type.BIRCH, DyeColor.WHITE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> BIRCH_SHULKER_BOAT_ORANGE = ITEMS.register("birch_shulker_boat_orange",()-> new ShulkerBoatItem(true, Boat.Type.BIRCH, DyeColor.ORANGE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> BIRCH_SHULKER_BOAT_MAGENTA = ITEMS.register("birch_shulker_boat_magenta",()-> new ShulkerBoatItem(true, Boat.Type.BIRCH, DyeColor.MAGENTA,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> BIRCH_SHULKER_BOAT_LIGHT_BLUE = ITEMS.register("birch_shulker_boat_light_blue",()-> new ShulkerBoatItem(true, Boat.Type.BIRCH, DyeColor.LIGHT_BLUE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> BIRCH_SHULKER_BOAT_YELLOW = ITEMS.register("birch_shulker_boat_yellow",()-> new ShulkerBoatItem(true, Boat.Type.BIRCH, DyeColor.YELLOW,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> BIRCH_SHULKER_BOAT_LIME = ITEMS.register("birch_shulker_boat_lime",()-> new ShulkerBoatItem(true, Boat.Type.BIRCH, DyeColor.LIME,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> BIRCH_SHULKER_BOAT_PINK = ITEMS.register("birch_shulker_boat_pink",()-> new ShulkerBoatItem(true, Boat.Type.BIRCH, DyeColor.PINK,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> BIRCH_SHULKER_BOAT_BROWN = ITEMS.register("birch_shulker_boat_brown",()-> new ShulkerBoatItem(true, Boat.Type.BIRCH, DyeColor.BROWN,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> BIRCH_SHULKER_BOAT_LIGHT_GRAY = ITEMS.register("birch_shulker_boat_light_gray",()-> new ShulkerBoatItem(true, Boat.Type.BIRCH, DyeColor.LIGHT_GRAY,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> JUNGLE_SHULKER_BOAT = ITEMS.register("jungle_shulker_boat",()-> new ShulkerBoatItem(true, Boat.Type.JUNGLE, null,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> JUNGLE_SHULKER_BOAT_RED = ITEMS.register("jungle_shulker_boat_red",()-> new ShulkerBoatItem(true, Boat.Type.JUNGLE, DyeColor.RED,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> JUNGLE_SHULKER_BOAT_GREEN = ITEMS.register("jungle_shulker_boat_green",()-> new ShulkerBoatItem(true, Boat.Type.JUNGLE,DyeColor.GREEN ,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> JUNGLE_SHULKER_BOAT_BLUE = ITEMS.register("jungle_shulker_boat_blue",()-> new ShulkerBoatItem(true, Boat.Type.JUNGLE, DyeColor.BLUE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> JUNGLE_SHULKER_BOAT_PURPLE = ITEMS.register("jungle_shulker_boat_purple",()-> new ShulkerBoatItem(true, Boat.Type.JUNGLE, DyeColor.PURPLE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> JUNGLE_SHULKER_BOAT_CYAN = ITEMS.register("jungle_shulker_boat_cyan",()-> new ShulkerBoatItem(true, Boat.Type.JUNGLE, DyeColor.CYAN,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> JUNGLE_SHULKER_BOAT_BLACK = ITEMS.register("jungle_shulker_boat_black",()-> new ShulkerBoatItem(true, Boat.Type.JUNGLE, DyeColor.BLACK, (new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> JUNGLE_SHULKER_BOAT_GRAY = ITEMS.register("jungle_shulker_boat_gray",()-> new ShulkerBoatItem(true, Boat.Type.JUNGLE, DyeColor.GRAY,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> JUNGLE_SHULKER_BOAT_WHITE = ITEMS.register("jungle_shulker_boat_white",()-> new ShulkerBoatItem(true, Boat.Type.JUNGLE, DyeColor.WHITE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> JUNGLE_SHULKER_BOAT_ORANGE = ITEMS.register("jungle_shulker_boat_orange",()-> new ShulkerBoatItem(true, Boat.Type.JUNGLE, DyeColor.ORANGE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> JUNGLE_SHULKER_BOAT_MAGENTA = ITEMS.register("jungle_shulker_boat_magenta",()-> new ShulkerBoatItem(true, Boat.Type.JUNGLE, DyeColor.MAGENTA,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> JUNGLE_SHULKER_BOAT_LIGHT_BLUE = ITEMS.register("jungle_shulker_boat_light_blue",()-> new ShulkerBoatItem(true, Boat.Type.JUNGLE, DyeColor.LIGHT_BLUE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> JUNGLE_SHULKER_BOAT_YELLOW = ITEMS.register("jungle_shulker_boat_yellow",()-> new ShulkerBoatItem(true, Boat.Type.JUNGLE, DyeColor.YELLOW,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> JUNGLE_SHULKER_BOAT_LIME = ITEMS.register("jungle_shulker_boat_lime",()-> new ShulkerBoatItem(true, Boat.Type.JUNGLE, DyeColor.LIME,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> JUNGLE_SHULKER_BOAT_PINK = ITEMS.register("jungle_shulker_boat_pink",()-> new ShulkerBoatItem(true, Boat.Type.JUNGLE, DyeColor.PINK,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> JUNGLE_SHULKER_BOAT_BROWN = ITEMS.register("jungle_shulker_boat_brown",()-> new ShulkerBoatItem(true, Boat.Type.JUNGLE, DyeColor.BROWN,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> JUNGLE_SHULKER_BOAT_LIGHT_GRAY = ITEMS.register("jungle_shulker_boat_light_gray",()-> new ShulkerBoatItem(true, Boat.Type.JUNGLE, DyeColor.LIGHT_GRAY,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> MANGROVE_SHULKER_BOAT = ITEMS.register("mangrove_shulker_boat",()-> new ShulkerBoatItem(true, Boat.Type.MANGROVE, null,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> MANGROVE_SHULKER_BOAT_RED = ITEMS.register("mangrove_shulker_boat_red",()-> new ShulkerBoatItem(true, Boat.Type.MANGROVE, DyeColor.RED,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> MANGROVE_SHULKER_BOAT_GREEN = ITEMS.register("mangrove_shulker_boat_green",()-> new ShulkerBoatItem(true, Boat.Type.MANGROVE,DyeColor.GREEN ,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> MANGROVE_SHULKER_BOAT_BLUE = ITEMS.register("mangrove_shulker_boat_blue",()-> new ShulkerBoatItem(true, Boat.Type.MANGROVE, DyeColor.BLUE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> MANGROVE_SHULKER_BOAT_PURPLE = ITEMS.register("mangrove_shulker_boat_purple",()-> new ShulkerBoatItem(true, Boat.Type.MANGROVE, DyeColor.PURPLE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> MANGROVE_SHULKER_BOAT_CYAN = ITEMS.register("mangrove_shulker_boat_cyan",()-> new ShulkerBoatItem(true, Boat.Type.MANGROVE, DyeColor.CYAN,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> MANGROVE_SHULKER_BOAT_BLACK = ITEMS.register("mangrove_shulker_boat_black",()-> new ShulkerBoatItem(true, Boat.Type.MANGROVE, DyeColor.BLACK, (new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> MANGROVE_SHULKER_BOAT_GRAY = ITEMS.register("mangrove_shulker_boat_gray",()-> new ShulkerBoatItem(true, Boat.Type.MANGROVE, DyeColor.GRAY,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> MANGROVE_SHULKER_BOAT_WHITE = ITEMS.register("mangrove_shulker_boat_white",()-> new ShulkerBoatItem(true, Boat.Type.MANGROVE, DyeColor.WHITE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> MANGROVE_SHULKER_BOAT_ORANGE = ITEMS.register("mangrove_shulker_boat_orange",()-> new ShulkerBoatItem(true, Boat.Type.MANGROVE, DyeColor.ORANGE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> MANGROVE_SHULKER_BOAT_MAGENTA = ITEMS.register("mangrove_shulker_boat_magenta",()-> new ShulkerBoatItem(true, Boat.Type.MANGROVE, DyeColor.MAGENTA,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> MANGROVE_SHULKER_BOAT_LIGHT_BLUE = ITEMS.register("mangrove_shulker_boat_light_blue",()-> new ShulkerBoatItem(true, Boat.Type.MANGROVE, DyeColor.LIGHT_BLUE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> MANGROVE_SHULKER_BOAT_YELLOW = ITEMS.register("mangrove_shulker_boat_yellow",()-> new ShulkerBoatItem(true, Boat.Type.MANGROVE, DyeColor.YELLOW,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> MANGROVE_SHULKER_BOAT_LIME = ITEMS.register("mangrove_shulker_boat_lime",()-> new ShulkerBoatItem(true, Boat.Type.MANGROVE, DyeColor.LIME,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> MANGROVE_SHULKER_BOAT_PINK = ITEMS.register("mangrove_shulker_boat_pink",()-> new ShulkerBoatItem(true, Boat.Type.MANGROVE, DyeColor.PINK,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> MANGROVE_SHULKER_BOAT_BROWN = ITEMS.register("mangrove_shulker_boat_brown",()-> new ShulkerBoatItem(true, Boat.Type.MANGROVE, DyeColor.BROWN,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> MANGROVE_SHULKER_BOAT_LIGHT_GRAY = ITEMS.register("mangrove_shulker_boat_light_gray",()-> new ShulkerBoatItem(true, Boat.Type.MANGROVE, DyeColor.LIGHT_GRAY,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> DARK_OAK_SHULKER_BOAT = ITEMS.register("dark_oak_shulker_boat",()-> new ShulkerBoatItem(true, Boat.Type.DARK_OAK, null,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> DARK_OAK_SHULKER_BOAT_RED = ITEMS.register("dark_oak_shulker_boat_red",()-> new ShulkerBoatItem(true, Boat.Type.DARK_OAK, DyeColor.RED,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> DARK_OAK_SHULKER_BOAT_GREEN = ITEMS.register("dark_oak_shulker_boat_green",()-> new ShulkerBoatItem(true, Boat.Type.DARK_OAK,DyeColor.GREEN ,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> DARK_OAK_SHULKER_BOAT_BLUE = ITEMS.register("dark_oak_shulker_boat_blue",()-> new ShulkerBoatItem(true, Boat.Type.DARK_OAK, DyeColor.BLUE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> DARK_OAK_SHULKER_BOAT_PURPLE = ITEMS.register("dark_oak_shulker_boat_purple",()-> new ShulkerBoatItem(true, Boat.Type.DARK_OAK, DyeColor.PURPLE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> DARK_OAK_SHULKER_BOAT_CYAN = ITEMS.register("dark_oak_shulker_boat_cyan",()-> new ShulkerBoatItem(true, Boat.Type.DARK_OAK, DyeColor.CYAN,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> DARK_OAK_SHULKER_BOAT_BLACK = ITEMS.register("dark_oak_shulker_boat_black",()-> new ShulkerBoatItem(true, Boat.Type.DARK_OAK, DyeColor.BLACK, (new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> DARK_OAK_SHULKER_BOAT_GRAY = ITEMS.register("dark_oak_shulker_boat_gray",()-> new ShulkerBoatItem(true, Boat.Type.DARK_OAK, DyeColor.GRAY,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> DARK_OAK_SHULKER_BOAT_WHITE = ITEMS.register("dark_oak_shulker_boat_white",()-> new ShulkerBoatItem(true, Boat.Type.DARK_OAK, DyeColor.WHITE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> DARK_OAK_SHULKER_BOAT_ORANGE = ITEMS.register("dark_oak_shulker_boat_orange",()-> new ShulkerBoatItem(true, Boat.Type.DARK_OAK, DyeColor.ORANGE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> DARK_OAK_SHULKER_BOAT_MAGENTA = ITEMS.register("dark_oak_shulker_boat_magenta",()-> new ShulkerBoatItem(true, Boat.Type.DARK_OAK, DyeColor.MAGENTA,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> DARK_OAK_SHULKER_BOAT_LIGHT_BLUE = ITEMS.register("dark_oak_shulker_boat_light_blue",()-> new ShulkerBoatItem(true, Boat.Type.DARK_OAK, DyeColor.LIGHT_BLUE,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> DARK_OAK_SHULKER_BOAT_YELLOW = ITEMS.register("dark_oak_shulker_boat_yellow",()-> new ShulkerBoatItem(true, Boat.Type.DARK_OAK, DyeColor.YELLOW,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> DARK_OAK_SHULKER_BOAT_LIME = ITEMS.register("dark_oak_shulker_boat_lime",()-> new ShulkerBoatItem(true, Boat.Type.DARK_OAK, DyeColor.LIME,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> DARK_OAK_SHULKER_BOAT_PINK = ITEMS.register("dark_oak_shulker_boat_pink",()-> new ShulkerBoatItem(true, Boat.Type.DARK_OAK, DyeColor.PINK,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> DARK_OAK_SHULKER_BOAT_BROWN = ITEMS.register("dark_oak_shulker_boat_brown",()-> new ShulkerBoatItem(true, Boat.Type.DARK_OAK, DyeColor.BROWN,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    public static final RegistryObject<ShulkerBoatItem> DARK_OAK_SHULKER_BOAT_LIGHT_GRAY = ITEMS.register("dark_oak_shulker_boat_light_gray",()-> new ShulkerBoatItem(true, Boat.Type.DARK_OAK, DyeColor.LIGHT_GRAY,(new Item.Properties()).stacksTo(1).tab(NyfsShulkerBoat.ITEM_GROUP)));
    
}
