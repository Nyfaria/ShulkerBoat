package com.nyfaria.shulkerboat.entity;

import com.nyfaria.shulkerboat.init.EntityInit;
import com.nyfaria.shulkerboat.init.ItemInit;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.HasCustomInventoryScreen;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ContainerEntity;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class ShulkerBoatEntity extends Boat implements HasCustomInventoryScreen, ContainerEntity {
    private static final int CONTAINER_SIZE = 27;
    private NonNullList<ItemStack> itemStacks = NonNullList.withSize(27, ItemStack.EMPTY);
    private static final EntityDataAccessor<String> COLOR = SynchedEntityData.defineId(ShulkerBoatEntity.class, EntityDataSerializers.STRING);
    @Nullable
    private ResourceLocation lootTable;
    private long lootTableSeed;
    private @Nullable DyeColor color;

    public ShulkerBoatEntity(EntityType<? extends Boat> p_219869_, Level p_219870_) {
        super(p_219869_, p_219870_);
    }

    public ShulkerBoatEntity(Level p_219872_, double p_219873_, double p_219874_, double p_219875_) {
        this(EntityInit.SHULKER_BOAT.get(), p_219872_);
        this.setPos(p_219873_, p_219874_, p_219875_);
        this.xo = p_219873_;
        this.yo = p_219874_;
        this.zo = p_219875_;
    }

    protected float getSinglePassengerXOffset() {
        return 0.15F;
    }

    protected int getMaxPassengers() {
        return 1;
    }

    protected void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        this.addChestVehicleSaveData(tag);
        tag.putString("color", getColor().getName());

    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    protected void readAdditionalSaveData(CompoundTag p_219901_) {
        super.readAdditionalSaveData(p_219901_);
        this.readChestVehicleSaveData(p_219901_);
        entityData.set(COLOR, p_219901_.getString("color"));
    }

    public void destroy(DamageSource p_219892_) {
        ItemStack stack = new ItemStack(getDropItem());
        saveToItem(stack);
        this.spawnAtLocation(stack);
    }

    public void remove(Entity.RemovalReason p_219894_) {
        super.remove(p_219894_);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(COLOR, "");
    }

    public InteractionResult interact(Player p_219898_, InteractionHand p_219899_) {
        return this.canAddPassenger(p_219898_) && !p_219898_.isSecondaryUseActive() ? super.interact(p_219898_, p_219899_) : this.interactWithChestVehicle(this::gameEvent, p_219898_);
    }

    public void openCustomInventoryScreen(Player p_219906_) {
        p_219906_.openMenu(this);
        if (!p_219906_.level.isClientSide) {
            this.gameEvent(GameEvent.CONTAINER_OPEN, p_219906_);
            PiglinAi.angerNearbyPiglins(p_219906_, true);
        }

    }

    public @NotNull Item getDropItem() {
        Item item;
        if (getColor() == null) {
            return switch (getBoatType()) {
                case SPRUCE -> ItemInit.SPRUCE_SHULKER_BOAT.get();
                case BIRCH -> ItemInit.BIRCH_SHULKER_BOAT.get();
                case JUNGLE -> ItemInit.JUNGLE_SHULKER_BOAT.get();
                case ACACIA -> ItemInit.ACACIA_SHULKER_BOAT.get();
                case DARK_OAK -> ItemInit.DARK_OAK_SHULKER_BOAT.get();
                default -> ItemInit.OAK_SHULKER_BOAT.get();
            };
        } else
            item = switch (this.getBoatType()) {
                case SPRUCE -> switch (getColor()) {
                    case WHITE -> ItemInit.SPRUCE_SHULKER_BOAT_WHITE.get();
                    case ORANGE -> ItemInit.SPRUCE_SHULKER_BOAT_ORANGE.get();
                    case MAGENTA -> ItemInit.SPRUCE_SHULKER_BOAT_MAGENTA.get();
                    case LIGHT_BLUE -> ItemInit.SPRUCE_SHULKER_BOAT_LIGHT_BLUE.get();
                    case YELLOW -> ItemInit.SPRUCE_SHULKER_BOAT_YELLOW.get();
                    case LIME -> ItemInit.SPRUCE_SHULKER_BOAT_LIME.get();
                    case PINK -> ItemInit.SPRUCE_SHULKER_BOAT_PINK.get();
                    case GRAY -> ItemInit.SPRUCE_SHULKER_BOAT_GRAY.get();
                    case LIGHT_GRAY -> ItemInit.SPRUCE_SHULKER_BOAT_LIGHT_GRAY.get();
                    case CYAN -> ItemInit.SPRUCE_SHULKER_BOAT_CYAN.get();
                    case PURPLE -> ItemInit.SPRUCE_SHULKER_BOAT_PURPLE.get();
                    case BLUE -> ItemInit.SPRUCE_SHULKER_BOAT_BLUE.get();
                    case BROWN -> ItemInit.SPRUCE_SHULKER_BOAT_BROWN.get();
                    case GREEN -> ItemInit.SPRUCE_SHULKER_BOAT_GREEN.get();
                    case RED -> ItemInit.SPRUCE_SHULKER_BOAT_RED.get();
                    case BLACK -> ItemInit.SPRUCE_SHULKER_BOAT_BLACK.get();
                };
                case BIRCH -> switch (getColor()) {
                    case WHITE -> ItemInit.BIRCH_SHULKER_BOAT_WHITE.get();
                    case ORANGE -> ItemInit.BIRCH_SHULKER_BOAT_ORANGE.get();
                    case MAGENTA -> ItemInit.BIRCH_SHULKER_BOAT_MAGENTA.get();
                    case LIGHT_BLUE -> ItemInit.BIRCH_SHULKER_BOAT_LIGHT_BLUE.get();
                    case YELLOW -> ItemInit.BIRCH_SHULKER_BOAT_YELLOW.get();
                    case LIME -> ItemInit.BIRCH_SHULKER_BOAT_LIME.get();
                    case PINK -> ItemInit.BIRCH_SHULKER_BOAT_PINK.get();
                    case GRAY -> ItemInit.BIRCH_SHULKER_BOAT_GRAY.get();
                    case LIGHT_GRAY -> ItemInit.BIRCH_SHULKER_BOAT_LIGHT_GRAY.get();
                    case CYAN -> ItemInit.BIRCH_SHULKER_BOAT_CYAN.get();
                    case PURPLE -> ItemInit.BIRCH_SHULKER_BOAT_PURPLE.get();
                    case BLUE -> ItemInit.BIRCH_SHULKER_BOAT_BLUE.get();
                    case BROWN -> ItemInit.BIRCH_SHULKER_BOAT_BROWN.get();
                    case GREEN -> ItemInit.BIRCH_SHULKER_BOAT_GREEN.get();
                    case RED -> ItemInit.BIRCH_SHULKER_BOAT_RED.get();
                    case BLACK -> ItemInit.BIRCH_SHULKER_BOAT_BLACK.get();
                };
                case JUNGLE -> switch (getColor()) {
                    case WHITE -> ItemInit.JUNGLE_SHULKER_BOAT_WHITE.get();
                    case ORANGE -> ItemInit.JUNGLE_SHULKER_BOAT_ORANGE.get();
                    case MAGENTA -> ItemInit.JUNGLE_SHULKER_BOAT_MAGENTA.get();
                    case LIGHT_BLUE -> ItemInit.JUNGLE_SHULKER_BOAT_LIGHT_BLUE.get();
                    case YELLOW -> ItemInit.JUNGLE_SHULKER_BOAT_YELLOW.get();
                    case LIME -> ItemInit.JUNGLE_SHULKER_BOAT_LIME.get();
                    case PINK -> ItemInit.JUNGLE_SHULKER_BOAT_PINK.get();
                    case GRAY -> ItemInit.JUNGLE_SHULKER_BOAT_GRAY.get();
                    case LIGHT_GRAY -> ItemInit.JUNGLE_SHULKER_BOAT_LIGHT_GRAY.get();
                    case CYAN -> ItemInit.JUNGLE_SHULKER_BOAT_CYAN.get();
                    case PURPLE -> ItemInit.JUNGLE_SHULKER_BOAT_PURPLE.get();
                    case BLUE -> ItemInit.JUNGLE_SHULKER_BOAT_BLUE.get();
                    case BROWN -> ItemInit.JUNGLE_SHULKER_BOAT_BROWN.get();
                    case GREEN -> ItemInit.JUNGLE_SHULKER_BOAT_GREEN.get();
                    case RED -> ItemInit.JUNGLE_SHULKER_BOAT_RED.get();
                    case BLACK -> ItemInit.JUNGLE_SHULKER_BOAT_BLACK.get();
                };
                case ACACIA -> switch (getColor()) {
                    case WHITE -> ItemInit.ACACIA_SHULKER_BOAT_WHITE.get();
                    case ORANGE -> ItemInit.ACACIA_SHULKER_BOAT_ORANGE.get();
                    case MAGENTA -> ItemInit.ACACIA_SHULKER_BOAT_MAGENTA.get();
                    case LIGHT_BLUE -> ItemInit.ACACIA_SHULKER_BOAT_LIGHT_BLUE.get();
                    case YELLOW -> ItemInit.ACACIA_SHULKER_BOAT_YELLOW.get();
                    case LIME -> ItemInit.ACACIA_SHULKER_BOAT_LIME.get();
                    case PINK -> ItemInit.ACACIA_SHULKER_BOAT_PINK.get();
                    case GRAY -> ItemInit.ACACIA_SHULKER_BOAT_GRAY.get();
                    case LIGHT_GRAY -> ItemInit.ACACIA_SHULKER_BOAT_LIGHT_GRAY.get();
                    case CYAN -> ItemInit.ACACIA_SHULKER_BOAT_CYAN.get();
                    case PURPLE -> ItemInit.ACACIA_SHULKER_BOAT_PURPLE.get();
                    case BLUE -> ItemInit.ACACIA_SHULKER_BOAT_BLUE.get();
                    case BROWN -> ItemInit.ACACIA_SHULKER_BOAT_BROWN.get();
                    case GREEN -> ItemInit.ACACIA_SHULKER_BOAT_GREEN.get();
                    case RED -> ItemInit.ACACIA_SHULKER_BOAT_RED.get();
                    case BLACK -> ItemInit.ACACIA_SHULKER_BOAT_BLACK.get();
                };
                case DARK_OAK -> switch (getColor()) {
                    case WHITE -> ItemInit.DARK_OAK_SHULKER_BOAT_WHITE.get();
                    case ORANGE -> ItemInit.DARK_OAK_SHULKER_BOAT_ORANGE.get();
                    case MAGENTA -> ItemInit.DARK_OAK_SHULKER_BOAT_MAGENTA.get();
                    case LIGHT_BLUE -> ItemInit.DARK_OAK_SHULKER_BOAT_LIGHT_BLUE.get();
                    case YELLOW -> ItemInit.DARK_OAK_SHULKER_BOAT_YELLOW.get();
                    case LIME -> ItemInit.DARK_OAK_SHULKER_BOAT_LIME.get();
                    case PINK -> ItemInit.DARK_OAK_SHULKER_BOAT_PINK.get();
                    case GRAY -> ItemInit.DARK_OAK_SHULKER_BOAT_GRAY.get();
                    case LIGHT_GRAY -> ItemInit.DARK_OAK_SHULKER_BOAT_LIGHT_GRAY.get();
                    case CYAN -> ItemInit.DARK_OAK_SHULKER_BOAT_CYAN.get();
                    case PURPLE -> ItemInit.DARK_OAK_SHULKER_BOAT_PURPLE.get();
                    case BLUE -> ItemInit.DARK_OAK_SHULKER_BOAT_BLUE.get();
                    case BROWN -> ItemInit.DARK_OAK_SHULKER_BOAT_BROWN.get();
                    case GREEN -> ItemInit.DARK_OAK_SHULKER_BOAT_GREEN.get();
                    case RED -> ItemInit.DARK_OAK_SHULKER_BOAT_RED.get();
                    case BLACK -> ItemInit.DARK_OAK_SHULKER_BOAT_BLACK.get();
                };
                case MANGROVE -> switch (getColor()) {
                    case WHITE -> ItemInit.MANGROVE_SHULKER_BOAT_WHITE.get();
                    case ORANGE -> ItemInit.MANGROVE_SHULKER_BOAT_ORANGE.get();
                    case MAGENTA -> ItemInit.MANGROVE_SHULKER_BOAT_MAGENTA.get();
                    case LIGHT_BLUE -> ItemInit.MANGROVE_SHULKER_BOAT_LIGHT_BLUE.get();
                    case YELLOW -> ItemInit.MANGROVE_SHULKER_BOAT_YELLOW.get();
                    case LIME -> ItemInit.MANGROVE_SHULKER_BOAT_LIME.get();
                    case PINK -> ItemInit.MANGROVE_SHULKER_BOAT_PINK.get();
                    case GRAY -> ItemInit.MANGROVE_SHULKER_BOAT_GRAY.get();
                    case LIGHT_GRAY -> ItemInit.MANGROVE_SHULKER_BOAT_LIGHT_GRAY.get();
                    case CYAN -> ItemInit.MANGROVE_SHULKER_BOAT_CYAN.get();
                    case PURPLE -> ItemInit.MANGROVE_SHULKER_BOAT_PURPLE.get();
                    case BLUE -> ItemInit.MANGROVE_SHULKER_BOAT_BLUE.get();
                    case BROWN -> ItemInit.MANGROVE_SHULKER_BOAT_BROWN.get();
                    case GREEN -> ItemInit.MANGROVE_SHULKER_BOAT_GREEN.get();
                    case RED -> ItemInit.MANGROVE_SHULKER_BOAT_RED.get();
                    case BLACK -> ItemInit.MANGROVE_SHULKER_BOAT_BLACK.get();
                };
                default -> switch (getColor()) {
                    case WHITE -> ItemInit.OAK_SHULKER_BOAT_WHITE.get();
                    case ORANGE -> ItemInit.OAK_SHULKER_BOAT_ORANGE.get();
                    case MAGENTA -> ItemInit.OAK_SHULKER_BOAT_MAGENTA.get();
                    case LIGHT_BLUE -> ItemInit.OAK_SHULKER_BOAT_LIGHT_BLUE.get();
                    case YELLOW -> ItemInit.OAK_SHULKER_BOAT_YELLOW.get();
                    case LIME -> ItemInit.OAK_SHULKER_BOAT_LIME.get();
                    case PINK -> ItemInit.OAK_SHULKER_BOAT_PINK.get();
                    case GRAY -> ItemInit.OAK_SHULKER_BOAT_GRAY.get();
                    case LIGHT_GRAY -> ItemInit.OAK_SHULKER_BOAT_LIGHT_GRAY.get();
                    case CYAN -> ItemInit.OAK_SHULKER_BOAT_CYAN.get();
                    case PURPLE -> ItemInit.OAK_SHULKER_BOAT_PURPLE.get();
                    case BLUE -> ItemInit.OAK_SHULKER_BOAT_BLUE.get();
                    case BROWN -> ItemInit.OAK_SHULKER_BOAT_BROWN.get();
                    case GREEN -> ItemInit.OAK_SHULKER_BOAT_GREEN.get();
                    case RED -> ItemInit.OAK_SHULKER_BOAT_RED.get();
                    case BLACK -> ItemInit.OAK_SHULKER_BOAT_BLACK.get();
                };
            };

        return item;
    }

    public void clearContent() {
        this.clearChestVehicleContent();
    }

    /**
     * Returns the number of slots in the inventory.
     */
    public int getContainerSize() {
        return 27;
    }

    /**
     * Returns the stack in the given slot.
     */
    public ItemStack getItem(int p_219880_) {
        return this.getChestVehicleItem(p_219880_);
    }

    /**
     * Removes up to a specified number of items from an inventory slot and returns them in a new stack.
     */
    public ItemStack removeItem(int p_219882_, int p_219883_) {
        return this.removeChestVehicleItem(p_219882_, p_219883_);
    }

    /**
     * Removes a stack from the given slot and returns it.
     */
    public ItemStack removeItemNoUpdate(int p_219904_) {
        return this.removeChestVehicleItemNoUpdate(p_219904_);
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setItem(int p_219885_, ItemStack p_219886_) {
        this.setChestVehicleItem(p_219885_, p_219886_);
    }

    public SlotAccess getSlot(int p_219918_) {
        return this.getChestVehicleSlot(p_219918_);
    }

    /**
     * For tile entities, ensures the chunk containing the tile entity is saved to disk later - the game won't think it
     * hasn't changed and skip it.
     */
    public void setChanged() {
    }

    /**
     * Don't rename this method to canInteractWith due to conflicts with Container
     */
    public boolean stillValid(Player p_219896_) {
        return this.isChestVehicleStillValid(p_219896_);
    }

    @Nullable
    public AbstractContainerMenu createMenu(int p_219910_, Inventory p_219911_, Player p_219912_) {
        if (this.lootTable != null && p_219912_.isSpectator()) {
            return null;
        } else {
            this.unpackLootTable(p_219911_.player);
            return ChestMenu.threeRows(p_219910_, p_219911_, this);
        }
    }

    public void unpackLootTable(@Nullable Player p_219914_) {
        this.unpackChestVehicleLootTable(p_219914_);
    }

    @Nullable
    public ResourceLocation getLootTable() {
        return this.lootTable;
    }

    public void setLootTable(@Nullable ResourceLocation p_219890_) {
        this.lootTable = p_219890_;
    }

    public long getLootTableSeed() {
        return this.lootTableSeed;
    }

    public void setLootTableSeed(long p_219888_) {
        this.lootTableSeed = p_219888_;
    }

    public NonNullList<ItemStack> getItemStacks() {
        return this.itemStacks;
    }

    public void clearItemStacks() {
        this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
    }

    // Forge Start
    private net.minecraftforge.common.util.LazyOptional<?> itemHandler = net.minecraftforge.common.util.LazyOptional.of(() -> new net.minecraftforge.items.wrapper.InvWrapper(this));

    @Override
    public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable net.minecraft.core.Direction facing) {
        if (this.isAlive() && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            return itemHandler.cast();
        return super.getCapability(capability, facing);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        itemHandler.invalidate();
    }

    @Override
    public void reviveCaps() {
        super.reviveCaps();
        itemHandler = net.minecraftforge.common.util.LazyOptional.of(() -> new net.minecraftforge.items.wrapper.InvWrapper(this));
    }

    public void loadFromTag(@Nullable CompoundTag pTag) {
        if (pTag == null) return;
        this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (pTag.contains("Items")) {
            ContainerHelper.loadAllItems(pTag, this.itemStacks);
        }
    }

    public void saveToItem(ItemStack itemstack) {
        CompoundTag tag = new CompoundTag();
        ContainerHelper.saveAllItems(tag, this.itemStacks);
        itemstack.setTag(tag);
    }

    @Nullable
    public DyeColor getColor() {
        return DyeColor.byName(entityData.get(COLOR),null);
    }

    public void setColor(@Nullable DyeColor color) {
        if (color == null) {
            entityData.set(COLOR, "");
        } else {
            entityData.set(COLOR, color.getName());
        }
    }
}
