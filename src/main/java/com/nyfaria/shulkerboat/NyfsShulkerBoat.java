package com.nyfaria.shulkerboat;

import com.nyfaria.shulkerboat.cap.ExampleHolderAttacher;
import com.nyfaria.shulkerboat.datagen.*;
import com.nyfaria.shulkerboat.init.*;
import com.nyfaria.shulkerboat.item.ShulkerBoatItem;
import com.nyfaria.shulkerboat.network.NetworkHandler;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.data.DataGenerator;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

@Mod(NyfsShulkerBoat.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NyfsShulkerBoat {
    public static final String MODID = "shulkerboat";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab(MODID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.OAK_SHULKER_BOAT.get());
        }
    };
    public NyfsShulkerBoat() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        TagInit.init();
        ItemInit.ITEMS.register(bus);
        EntityInit.ENTITIES.register(bus);
        BlockInit.BLOCKS.register(bus);
        BlockInit.BLOCK_ENTITIES.register(bus);
        RecipeInit.RECIPES.register(bus);
        ExampleHolderAttacher.register();

    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        NetworkHandler.register();
        ItemInit.ITEMS.getEntries().stream().map(Supplier::get)
                .forEach(item ->CauldronInteraction.WATER.put(item,SHULKER_BOAT));
    }

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        if (event.includeServer()) {
            generator.addProvider(true,new ModRecipeProvider(generator));
            generator.addProvider(true,new ModLootTableProvider(generator));
            generator.addProvider(true,new ModSoundProvider(generator, MODID,existingFileHelper));
            generator.addProvider(true,new ModItemTagsProvider(generator, existingFileHelper));
        }
        if (event.includeClient()) {
            generator.addProvider(event.includeClient(),new ModItemModelProvider(generator, existingFileHelper));
            generator.addProvider(event.includeClient(),new ModBlockStateProvider(generator, existingFileHelper));
            generator.addProvider(event.includeClient(),new ModLangProvider(generator, MODID, "en_us"));
        }
    }
    public static CauldronInteraction SHULKER_BOAT = (p_175662_, p_175663_, p_175664_, p_175665_, p_175666_, p_175667_) -> {
        Item block = p_175667_.getItem();
        if (!(block instanceof ShulkerBoatItem)) {
            return InteractionResult.PASS;
        } else {
            if (!p_175663_.isClientSide) {
                ItemStack itemstack = new ItemStack(ItemInit.ITEMS.getEntries()
                        .stream().filter(item -> ((ShulkerBoatItem)item.get()).getType() == ((ShulkerBoatItem) block).getType()).findFirst().get().get());
                if (p_175667_.hasTag()) {
                    itemstack.setTag(p_175667_.getTag().copy());
                }

                p_175665_.setItemInHand(p_175666_, itemstack);
                p_175665_.awardStat(Stats.CLEAN_SHULKER_BOX);
                LayeredCauldronBlock.lowerFillLevel(p_175662_, p_175663_, p_175664_);
            }

            return InteractionResult.sidedSuccess(p_175663_.isClientSide);
        }
    };
}
