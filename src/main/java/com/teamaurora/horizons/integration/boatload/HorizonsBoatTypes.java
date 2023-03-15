package com.teamaurora.horizons.integration.boatload;

import com.teamabnormals.boatload.common.item.FurnaceBoatItem;
import com.teamabnormals.boatload.common.item.LargeBoatItem;
import com.teamabnormals.boatload.core.api.BoatloadBoatType;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsItems;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

/*
 * @author rose_
 */
public final class HorizonsBoatTypes {
    public static final BoatloadBoatType CYPRESS = BoatloadBoatType.register(BoatloadBoatType.create(Horizons.REGISTRY_HELPER.prefix("cypress"), () -> HorizonsBlocks.CYPRESS_PLANKS.get().asItem(), () -> HorizonsItems.CYPRESS_BOATS.getFirst().get(), () -> HorizonsItems.CYPRESS_BOATS.getSecond().get(), () -> HorizonsItems.CYPRESS_FURNACE_BOAT.get(), () -> HorizonsItems.LARGE_CYPRESS_BOAT.get()));

    public static final Supplier<Item> CYPRESS_FURNACE_BOAT = () -> new FurnaceBoatItem(CYPRESS);
    public static final Supplier<Item> LARGE_CYPRESS_BOAT = () -> new LargeBoatItem(CYPRESS);
}
