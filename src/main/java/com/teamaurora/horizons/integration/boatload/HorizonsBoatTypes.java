package com.teamaurora.horizons.integration.boatload;

import com.teamabnormals.boatload.common.item.FurnaceBoatItem;
import com.teamabnormals.boatload.common.item.LargeBoatItem;
import com.teamabnormals.boatload.core.api.BoatloadBoatType;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsItems;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

/**
 * @author rose_
 */
public final class HorizonsBoatTypes {
    public static final BoatloadBoatType CYPRESS = BoatloadBoatType.register(BoatloadBoatType.create(Horizons.REGISTRY_HELPER.prefix("cypress"), () -> HorizonsBlocks.CYPRESS_PLANKS.get().asItem(), () -> HorizonsItems.CYPRESS_BOATS.getFirst().get(), () -> HorizonsItems.CYPRESS_BOATS.getSecond().get(), () -> HorizonsItems.CYPRESS_FURNACE_BOAT.get(), () -> HorizonsItems.LARGE_CYPRESS_BOAT.get()));
    public static final BoatloadBoatType REDWOOD = BoatloadBoatType.register(BoatloadBoatType.create(Horizons.REGISTRY_HELPER.prefix("redwood"), () -> HorizonsBlocks.REDWOOD_PLANKS.get().asItem(), () -> HorizonsItems.REDWOOD_BOATS.getFirst().get(), () -> HorizonsItems.REDWOOD_BOATS.getSecond().get(), () -> HorizonsItems.REDWOOD_FURNACE_BOAT.get(), () -> HorizonsItems.LARGE_REDWOOD_BOAT.get()));
    public static final BoatloadBoatType REDBUD = BoatloadBoatType.register(BoatloadBoatType.create(Horizons.REGISTRY_HELPER.prefix("redbud"), () -> HorizonsBlocks.REDBUD_PLANKS.get().asItem(), () -> HorizonsItems.REDBUD_BOATS.getFirst().get(), () -> HorizonsItems.REDBUD_BOATS.getSecond().get(), () -> HorizonsItems.REDBUD_FURNACE_BOAT.get(), () -> HorizonsItems.LARGE_REDBUD_BOAT.get()));
    public static final BoatloadBoatType JACARANDA = BoatloadBoatType.register(BoatloadBoatType.create(Horizons.REGISTRY_HELPER.prefix("jacaranda"), () -> HorizonsBlocks.JACARANDA_PLANKS.get().asItem(), () -> HorizonsItems.JACARANDA_BOATS.getFirst().get(), () -> HorizonsItems.JACARANDA_BOATS.getSecond().get(), () -> HorizonsItems.JACARANDA_FURNACE_BOAT.get(), () -> HorizonsItems.LARGE_JACARANDA_BOAT.get()));

    public static final Supplier<Item> CYPRESS_FURNACE_BOAT = () -> new FurnaceBoatItem(CYPRESS);
    public static final Supplier<Item> LARGE_CYPRESS_BOAT = () -> new LargeBoatItem(CYPRESS);    
    public static final Supplier<Item> REDWOOD_FURNACE_BOAT = () -> new FurnaceBoatItem(REDWOOD);
    public static final Supplier<Item> LARGE_REDWOOD_BOAT = () -> new LargeBoatItem(REDWOOD);
    public static final Supplier<Item> REDBUD_FURNACE_BOAT = () -> new FurnaceBoatItem(REDBUD);
    public static final Supplier<Item> LARGE_REDBUD_BOAT = () -> new LargeBoatItem(REDBUD);
    public static final Supplier<Item> JACARANDA_FURNACE_BOAT = () -> new FurnaceBoatItem(JACARANDA);
    public static final Supplier<Item> LARGE_JACARANDA_BOAT = () -> new LargeBoatItem(JACARANDA);
}
