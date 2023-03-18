package com.teamaurora.horizons.core.registry;

import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.common.item.InjectedItem;
import com.teamabnormals.blueprint.core.util.PropertyUtil;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import com.teamaurora.horizons.common.item.AlgaeBlockItem;
import com.teamaurora.horizons.common.item.DrinkableBottleItem;
import com.teamaurora.horizons.common.item.LilyItem;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.other.HorizonsConstants;
import com.teamaurora.horizons.core.other.HorizonsFoods;
import com.teamaurora.horizons.integration.boatload.HorizonsBoatTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author rose_
 */
@Mod.EventBusSubscriber(modid = Horizons.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HorizonsItems {
    public static final ItemSubRegistryHelper HELPER = Horizons.REGISTRY_HELPER.getItemSubHelper();

    // Foods //

    public static final RegistryObject<Item> GOOSEBERRIES = HELPER.createItem("gooseberries", () -> new InjectedItem(Items.GLOW_BERRIES, PropertyUtil.food(HorizonsFoods.GOOSEBERRIES)));
    public static final RegistryObject<Item> GOOSEBERRY_JUICE = HELPER.createItem("gooseberry_juice", () -> new DrinkableBottleItem(HorizonsFoods.GOOSEBERRY_JUICE));
    public static final RegistryObject<Item> GOOSEBERRY_PIE = HELPER.createItem("gooseberry_pie", () -> new Item(PropertyUtil.food(HorizonsFoods.GOOSEBERRY_PIE)));
    public static final RegistryObject<Item> HONEY_GLAZED_GOOSEBERRIES = HELPER.createItem("honey_glazed_gooseberries", () -> new InjectedItem(GOOSEBERRIES.get(), PropertyUtil.food(HorizonsFoods.HONEY_GLAZED_GOOSEBERRIES)));
    public static final RegistryObject<Item> GOOSEBERRY_JAM = HELPER.createItem("gooseberry_jam", () -> new DrinkableBottleItem(() -> SoundEvents.HONEY_DRINK, HorizonsFoods.GOOSEBERRY_JAM));
    public static final RegistryObject<Item> GOOSEBERRY_JAM_COOKIE = HELPER.createItem("gooseberry_jam_cookie", () -> new Item(PropertyUtil.food(ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.FARMERSDELIGHT) ? HorizonsFoods.GOOSEBERRY_JAM_COOKIE_FAST : HorizonsFoods.GOOSEBERRY_JAM_COOKIE)));

    // Boats //

    public static final Pair<RegistryObject<Item>, RegistryObject<Item>> CYPRESS_BOATS = HELPER.createBoatAndChestBoatItem("cypress", HorizonsBlocks.CYPRESS_PLANKS);
    public static final RegistryObject<Item> CYPRESS_FURNACE_BOAT = HELPER.createItem("cypress_furnace_boat", ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.BOATLOAD) ? HorizonsBoatTypes.CYPRESS_FURNACE_BOAT : () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LARGE_CYPRESS_BOAT = HELPER.createItem("large_cypress_boat", ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.BOATLOAD) ? HorizonsBoatTypes.LARGE_CYPRESS_BOAT : () -> new Item(new Item.Properties()));
    public static final Pair<RegistryObject<Item>, RegistryObject<Item>> REDWOOD_BOATS = HELPER.createBoatAndChestBoatItem("redwood", HorizonsBlocks.REDWOOD_PLANKS);
    public static final RegistryObject<Item> REDWOOD_FURNACE_BOAT = HELPER.createItem("redwood_furnace_boat", ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.BOATLOAD) ? HorizonsBoatTypes.REDWOOD_FURNACE_BOAT : () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LARGE_REDWOOD_BOAT = HELPER.createItem("large_redwood_boat", ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.BOATLOAD) ? HorizonsBoatTypes.LARGE_REDWOOD_BOAT : () -> new Item(new Item.Properties()));

    // Misc //

    public static final RegistryObject<Item> ALGAE = HELPER.createItem("algae", () -> new AlgaeBlockItem(HorizonsBlocks.ALGAE.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

    // Lily Items //

    public static final RegistryObject<Item> BLUE_LILY = HELPER.createItem("blue_lily", () -> new LilyItem(HorizonsBlocks.BLUE_LILY.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> LIGHT_GRAY_LILY = HELPER.createItem("light_gray_lily", () -> new LilyItem(HorizonsBlocks.LIGHT_GRAY_LILY.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> CYAN_LILY = HELPER.createItem("cyan_lily", () -> new LilyItem(HorizonsBlocks.CYAN_LILY.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> LIGHT_BLUE_LILY = HELPER.createItem("light_blue_lily", () -> new LilyItem(HorizonsBlocks.LIGHT_BLUE_LILY.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> MAGENTA_LILY = HELPER.createItem("magenta_lily", () -> new LilyItem(HorizonsBlocks.MAGENTA_LILY.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> PINK_LILY = HELPER.createItem("pink_lily", () -> new LilyItem(HorizonsBlocks.PINK_LILY.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> PURPLE_LILY = HELPER.createItem("purple_lily", () -> new LilyItem(HorizonsBlocks.PURPLE_LILY.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> WHITE_LILY = HELPER.createItem("white_lily", () -> new LilyItem(HorizonsBlocks.WHITE_LILY.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
}
