package com.teamaurora.horizons.core.data.client;

import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.common.block.sign.BlueprintStandingSignBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintWallSignBlock;
import com.teamabnormals.blueprint.core.util.registry.BiomeSubRegistryHelper;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.registry.HorizonsBiomes;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsEffects;
import com.teamaurora.horizons.core.registry.HorizonsItems;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;
import org.codehaus.plexus.util.StringUtils;

/**
 * @author rose_
 */
public class HorizonsLanguageProvider extends LanguageProvider {
    public HorizonsLanguageProvider(GatherDataEvent event) {
        super(event.getGenerator(), Horizons.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        //items
        this.translateItem(HorizonsItems.GOOSEBERRIES);
        this.translateItem(HorizonsItems.GOOSEBERRY_JUICE);
        this.translateItem(HorizonsItems.GOOSEBERRY_PIE);
        this.translateItem(HorizonsItems.HONEY_GLAZED_GOOSEBERRIES);
        this.translateItem(HorizonsItems.GOOSEBERRY_JAM);
        this.translateItem(HorizonsItems.GOOSEBERRY_JAM_COOKIE);
        this.translateItem(HorizonsItems.SUNFLOWER_SEEDS);
        this.translateItem(HorizonsItems.LAVENDER_SALAD);
        this.translateItem(HorizonsItems.LAVENDER_TEA);

        this.translateItem(HorizonsItems.REDBUD_BLOSSOMS);

        this.translateItem(HorizonsItems.CYPRESS_BOATS.getFirst());
        this.translateItem(HorizonsItems.CYPRESS_BOATS.getSecond());
        this.translateItem(HorizonsItems.CYPRESS_FURNACE_BOAT);
        this.translateItem(HorizonsItems.LARGE_CYPRESS_BOAT);
        this.translateItem(HorizonsItems.REDWOOD_BOATS.getFirst());
        this.translateItem(HorizonsItems.REDWOOD_BOATS.getSecond());
        this.translateItem(HorizonsItems.REDWOOD_FURNACE_BOAT);
        this.translateItem(HorizonsItems.LARGE_REDWOOD_BOAT);
        this.translateItem(HorizonsItems.REDBUD_BOATS.getFirst());
        this.translateItem(HorizonsItems.REDBUD_BOATS.getSecond());
        this.translateItem(HorizonsItems.REDBUD_FURNACE_BOAT);
        this.translateItem(HorizonsItems.LARGE_REDBUD_BOAT);
        this.translateItem(HorizonsItems.JACARANDA_BOATS.getFirst());
        this.translateItem(HorizonsItems.JACARANDA_BOATS.getSecond());
        this.translateItem(HorizonsItems.JACARANDA_FURNACE_BOAT);
        this.translateItem(HorizonsItems.LARGE_JACARANDA_BOAT);

        //blocks
        this.translateBlock(HorizonsBlocks.STRIPPED_CYPRESS_LOG);
        this.translateBlock(HorizonsBlocks.STRIPPED_CYPRESS_WOOD);
        this.translateBlock(HorizonsBlocks.CYPRESS_LOG);
        this.translateBlock(HorizonsBlocks.CYPRESS_WOOD);
        this.translateBlock(HorizonsBlocks.CYPRESS_PLANKS);
        this.translateBlock(HorizonsBlocks.CYPRESS_SLAB);
        this.translateBlock(HorizonsBlocks.CYPRESS_STAIRS);
        this.translateBlock(HorizonsBlocks.CYPRESS_FENCE);
        this.translateBlock(HorizonsBlocks.CYPRESS_FENCE_GATE);
        this.translateBlock(HorizonsBlocks.CYPRESS_PRESSURE_PLATE);
        this.translateBlock(HorizonsBlocks.CYPRESS_DOOR);
        this.translateBlock(HorizonsBlocks.CYPRESS_TRAPDOOR);
        this.translateBlock(HorizonsBlocks.CYPRESS_BUTTON);
        this.translateSigns(HorizonsBlocks.CYPRESS_SIGNS, "cypress");
        this.translateBlock(HorizonsBlocks.CYPRESS_SAPLING);
        this.translateBlock(HorizonsBlocks.POTTED_CYPRESS_SAPLING);
        this.translateBlock(HorizonsBlocks.CYPRESS_LEAVES);

        this.translateBlock(HorizonsBlocks.VERTICAL_CYPRESS_PLANKS);
        this.translateBlock(HorizonsBlocks.CYPRESS_BEEHIVE);
        this.translateBlock(HorizonsBlocks.CYPRESS_LADDER);
        this.translateBlock(HorizonsBlocks.CYPRESS_BOOKSHELF);
        this.translateBlock(HorizonsBlocks.CYPRESS_BOARDS);
        this.translateBlock(HorizonsBlocks.CYPRESS_VERTICAL_SLAB);
        this.translateBlock(HorizonsBlocks.CYPRESS_POST);
        this.translateBlock(HorizonsBlocks.STRIPPED_CYPRESS_POST);
        this.translateBlock(HorizonsBlocks.CYPRESS_CHEST);
        this.translateBlock(HorizonsBlocks.CYPRESS_TRAPPED_CHEST);
        this.translateBlock(HorizonsBlocks.CYPRESS_CABINET);
        this.add(HorizonsBlocks.CYPRESS_HEDGE.get(), "Cypress Leaf Hedge");
        this.translateBlock(HorizonsBlocks.CYPRESS_LEAF_CARPET);
        this.add(HorizonsBlocks.CYPRESS_LEAF_PILE.get(), "Pile of Cypress Leaves");
        this.translateBlock(HorizonsBlocks.HANGING_CYPRESS_LEAVES);

        this.translateBlock(HorizonsBlocks.CYPRESS_KNEE);
        this.translateBlock(HorizonsBlocks.LARGE_CYPRESS_KNEE);
        this.translateBlock(HorizonsBlocks.STRIPPED_CYPRESS_KNEE);
        this.translateBlock(HorizonsBlocks.STRIPPED_LARGE_CYPRESS_KNEE);

        this.add(HorizonsBlocks.BEARD_MOSS_BLOCK.get(), "Beard Moss");
        this.add(HorizonsBlocks.BEARD_MOSS.get(), "Hanging Beard Moss");

        this.translateBlock(HorizonsBlocks.CYPRESS_BRANCH);
        this.translateBlock(HorizonsBlocks.GOOSEBERRY_SACK);

        this.translateBlock(HorizonsBlocks.ALGAE);
        this.translateBlock(HorizonsBlocks.ALGAE_THATCH);
        this.translateBlock(HorizonsBlocks.ALGAE_THATCH_SLAB);
        this.translateBlock(HorizonsBlocks.ALGAE_THATCH_STAIRS);
        this.translateBlock(HorizonsBlocks.ALGAE_THATCH_VERTICAL_SLAB);

        this.translateBlock(HorizonsBlocks.BLUE_LILY);
        this.translateBlock(HorizonsBlocks.LIGHT_GRAY_LILY);
        this.translateBlock(HorizonsBlocks.CYAN_LILY);
        this.translateBlock(HorizonsBlocks.LIGHT_BLUE_LILY);
        this.translateBlock(HorizonsBlocks.MAGENTA_LILY);
        this.translateBlock(HorizonsBlocks.PINK_LILY);
        this.translateBlock(HorizonsBlocks.PURPLE_LILY);
        this.translateBlock(HorizonsBlocks.WHITE_LILY);

        this.translateBlock(HorizonsBlocks.POTTED_BLUE_LILY);
        this.translateBlock(HorizonsBlocks.POTTED_LIGHT_GRAY_LILY);
        this.translateBlock(HorizonsBlocks.POTTED_CYAN_LILY);
        this.translateBlock(HorizonsBlocks.POTTED_LIGHT_BLUE_LILY);
        this.translateBlock(HorizonsBlocks.POTTED_MAGENTA_LILY);
        this.translateBlock(HorizonsBlocks.POTTED_PINK_LILY);
        this.translateBlock(HorizonsBlocks.POTTED_PURPLE_LILY);
        this.translateBlock(HorizonsBlocks.POTTED_WHITE_LILY);

        this.translateBlock(HorizonsBlocks.GIANT_FERN);

        this.translateBlock(HorizonsBlocks.STRIPPED_REDWOOD_LOG);
        this.translateBlock(HorizonsBlocks.STRIPPED_REDWOOD);
        this.translateBlock(HorizonsBlocks.REDWOOD_LOG);
        this.translateBlock(HorizonsBlocks.REDWOOD);
        this.translateBlock(HorizonsBlocks.REDWOOD_PLANKS);
        this.translateBlock(HorizonsBlocks.REDWOOD_SLAB);
        this.translateBlock(HorizonsBlocks.REDWOOD_STAIRS);
        this.translateBlock(HorizonsBlocks.REDWOOD_FENCE);
        this.translateBlock(HorizonsBlocks.REDWOOD_FENCE_GATE);
        this.translateBlock(HorizonsBlocks.REDWOOD_PRESSURE_PLATE);
        this.translateBlock(HorizonsBlocks.REDWOOD_DOOR);
        this.translateBlock(HorizonsBlocks.REDWOOD_TRAPDOOR);
        this.translateBlock(HorizonsBlocks.REDWOOD_BUTTON);
        this.translateSigns(HorizonsBlocks.REDWOOD_SIGNS, "redwood");
        this.translateBlock(HorizonsBlocks.REDWOOD_SAPLING);
        this.translateBlock(HorizonsBlocks.POTTED_REDWOOD_SAPLING);
        this.translateBlock(HorizonsBlocks.REDWOOD_LEAVES);

        this.translateBlock(HorizonsBlocks.VERTICAL_REDWOOD_PLANKS);
        this.translateBlock(HorizonsBlocks.REDWOOD_BEEHIVE);
        this.translateBlock(HorizonsBlocks.REDWOOD_LADDER);
        this.translateBlock(HorizonsBlocks.REDWOOD_BOOKSHELF);
        this.translateBlock(HorizonsBlocks.REDWOOD_BOARDS);
        this.translateBlock(HorizonsBlocks.REDWOOD_VERTICAL_SLAB);
        this.translateBlock(HorizonsBlocks.REDWOOD_POST);
        this.translateBlock(HorizonsBlocks.STRIPPED_REDWOOD_POST);
        this.translateBlock(HorizonsBlocks.REDWOOD_CHEST);
        this.translateBlock(HorizonsBlocks.REDWOOD_TRAPPED_CHEST);
        this.translateBlock(HorizonsBlocks.REDWOOD_CABINET);
        this.add(HorizonsBlocks.REDWOOD_HEDGE.get(), "Redwood Leaf Hedge");
        this.translateBlock(HorizonsBlocks.REDWOOD_LEAF_CARPET);
        this.add(HorizonsBlocks.REDWOOD_LEAF_PILE.get(), "Pile of Redwood Leaves");

        this.translateBlock(HorizonsBlocks.LIGHT_BOULDER);
        this.translateBlock(HorizonsBlocks.LIGHT_BOULDER_SLAB);
        this.translateBlock(HorizonsBlocks.LIGHT_BOULDER_STAIRS);
        this.translateBlock(HorizonsBlocks.LIGHT_BOULDER_VERTICAL_SLAB);
        this.translateBlock(HorizonsBlocks.LIGHT_BOULDER_WALL);
        this.translateBlock(HorizonsBlocks.MOSSY_LIGHT_BOULDER);
        this.translateBlock(HorizonsBlocks.MOSSY_LIGHT_BOULDER_SLAB);
        this.translateBlock(HorizonsBlocks.MOSSY_LIGHT_BOULDER_STAIRS);
        this.translateBlock(HorizonsBlocks.MOSSY_LIGHT_BOULDER_VERTICAL_SLAB);
        this.translateBlock(HorizonsBlocks.MOSSY_LIGHT_BOULDER_WALL);
        this.translateBlock(HorizonsBlocks.DARK_BOULDER);
        this.translateBlock(HorizonsBlocks.DARK_BOULDER_SLAB);
        this.translateBlock(HorizonsBlocks.DARK_BOULDER_STAIRS);
        this.translateBlock(HorizonsBlocks.DARK_BOULDER_VERTICAL_SLAB);
        this.translateBlock(HorizonsBlocks.DARK_BOULDER_WALL);
        this.translateBlock(HorizonsBlocks.MOSSY_DARK_BOULDER);
        this.translateBlock(HorizonsBlocks.MOSSY_DARK_BOULDER_SLAB);
        this.translateBlock(HorizonsBlocks.MOSSY_DARK_BOULDER_STAIRS);
        this.translateBlock(HorizonsBlocks.MOSSY_DARK_BOULDER_VERTICAL_SLAB);
        this.translateBlock(HorizonsBlocks.MOSSY_DARK_BOULDER_WALL);
        this.translateBlock(HorizonsBlocks.BOULDER_BRICKS);
        this.translateBlock(HorizonsBlocks.BOULDER_BRICK_SLAB);
        this.translateBlock(HorizonsBlocks.BOULDER_BRICK_STAIRS);
        this.translateBlock(HorizonsBlocks.BOULDER_BRICK_VERTICAL_SLAB);
        this.translateBlock(HorizonsBlocks.BOULDER_BRICK_WALL);

        this.translateBlock(HorizonsBlocks.YELLOW_DAISY);
        this.translateBlock(HorizonsBlocks.RED_DAISY);
        this.translateBlock(HorizonsBlocks.PURPLE_DAISY);
        this.translateBlock(HorizonsBlocks.PINK_DAISY);
        this.translateBlock(HorizonsBlocks.ORANGE_DAISY);
        this.translateBlock(HorizonsBlocks.MAGENTA_DAISY);
        this.translateBlock(HorizonsBlocks.BLUE_DAISY);
        this.translateBlock(HorizonsBlocks.POTTED_YELLOW_DAISY);
        this.translateBlock(HorizonsBlocks.POTTED_RED_DAISY);
        this.translateBlock(HorizonsBlocks.POTTED_PURPLE_DAISY);
        this.translateBlock(HorizonsBlocks.POTTED_PINK_DAISY);
        this.translateBlock(HorizonsBlocks.POTTED_ORANGE_DAISY);
        this.translateBlock(HorizonsBlocks.POTTED_MAGENTA_DAISY);
        this.translateBlock(HorizonsBlocks.POTTED_BLUE_DAISY);

        this.translateBlock(HorizonsBlocks.STRIPPED_REDBUD_LOG);
        this.translateBlock(HorizonsBlocks.STRIPPED_REDBUD_WOOD);
        this.translateBlock(HorizonsBlocks.REDBUD_LOG);
        this.translateBlock(HorizonsBlocks.REDBUD_WOOD);
        this.translateBlock(HorizonsBlocks.FLOWERING_REDBUD_LOG);
        this.translateBlock(HorizonsBlocks.FLOWERING_REDBUD_WOOD);
        this.translateBlock(HorizonsBlocks.REDBUD_PLANKS);
        this.translateBlock(HorizonsBlocks.REDBUD_SLAB);
        this.translateBlock(HorizonsBlocks.REDBUD_STAIRS);
        this.translateBlock(HorizonsBlocks.REDBUD_FENCE);
        this.translateBlock(HorizonsBlocks.REDBUD_FENCE_GATE);
        this.translateBlock(HorizonsBlocks.REDBUD_PRESSURE_PLATE);
        this.translateBlock(HorizonsBlocks.REDBUD_DOOR);
        this.translateBlock(HorizonsBlocks.REDBUD_TRAPDOOR);
        this.translateBlock(HorizonsBlocks.REDBUD_BUTTON);
        this.translateSigns(HorizonsBlocks.REDBUD_SIGNS, "redbud");
        this.translateBlock(HorizonsBlocks.REDBUD_SAPLING);
        this.translateBlock(HorizonsBlocks.POTTED_REDBUD_SAPLING);
        this.translateBlock(HorizonsBlocks.FLOWERING_REDBUD_SAPLING);
        this.translateBlock(HorizonsBlocks.POTTED_FLOWERING_REDBUD_SAPLING);
        this.translateBlock(HorizonsBlocks.REDBUD_LEAVES);
        this.translateBlock(HorizonsBlocks.BUDDING_REDBUD_LEAVES);
        this.translateBlock(HorizonsBlocks.FLOWERING_REDBUD_LEAVES);

        this.translateBlock(HorizonsBlocks.REDBUD_BEEHIVE);
        this.translateBlock(HorizonsBlocks.REDBUD_LADDER);
        this.translateBlock(HorizonsBlocks.VERTICAL_REDBUD_PLANKS);
        this.translateBlock(HorizonsBlocks.REDBUD_BOOKSHELF);
        this.translateBlock(HorizonsBlocks.REDBUD_BOARDS);
        this.translateBlock(HorizonsBlocks.REDBUD_VERTICAL_SLAB);
        this.translateBlock(HorizonsBlocks.STRIPPED_REDBUD_POST);
        this.translateBlock(HorizonsBlocks.REDBUD_POST);
        this.translateBlock(HorizonsBlocks.FLOWERING_REDBUD_POST);
        this.translateBlock(HorizonsBlocks.REDBUD_CHEST);
        this.translateBlock(HorizonsBlocks.REDBUD_TRAPPED_CHEST);
        this.translateBlock(HorizonsBlocks.REDBUD_CABINET);
        this.add(HorizonsBlocks.REDBUD_HEDGE.get(), "Redbud Leaf Hedge");
        this.translateBlock(HorizonsBlocks.REDBUD_LEAF_CARPET);
        this.add(HorizonsBlocks.REDBUD_LEAF_PILE.get(), "Pile of Redbud Leaves");
        this.add(HorizonsBlocks.BUDDING_REDBUD_HEDGE.get(), "Budding Redbud Leaf Hedge");
        this.translateBlock(HorizonsBlocks.BUDDING_REDBUD_LEAF_CARPET);
        this.add(HorizonsBlocks.BUDDING_REDBUD_LEAF_PILE.get(), "Pile of Budding Redbud Leaves");
        this.add(HorizonsBlocks.FLOWERING_REDBUD_HEDGE.get(), "Flowering Redbud Leaf Hedge");
        this.translateBlock(HorizonsBlocks.FLOWERING_REDBUD_LEAF_CARPET);
        this.add(HorizonsBlocks.FLOWERING_REDBUD_LEAF_PILE.get(), "Pile of Flowering Redbud Leaves");
        this.add(HorizonsBlocks.REDBUD_BLOSSOMS_LEAF_PILE.get(), "Pile of Redbud Blossoms");

        this.translateBlock(HorizonsBlocks.STRIPPED_JACARANDA_LOG);
        this.translateBlock(HorizonsBlocks.STRIPPED_JACARANDA_WOOD);
        this.translateBlock(HorizonsBlocks.JACARANDA_LOG);
        this.translateBlock(HorizonsBlocks.JACARANDA_WOOD);

        this.translateBlock(HorizonsBlocks.JACARANDA_PLANKS);
        this.translateBlock(HorizonsBlocks.JACARANDA_SLAB);
        this.translateBlock(HorizonsBlocks.JACARANDA_STAIRS);
        this.translateBlock(HorizonsBlocks.JACARANDA_FENCE);
        this.translateBlock(HorizonsBlocks.JACARANDA_FENCE_GATE);
        this.translateBlock(HorizonsBlocks.JACARANDA_PRESSURE_PLATE);
        this.translateBlock(HorizonsBlocks.JACARANDA_DOOR);
        this.translateBlock(HorizonsBlocks.JACARANDA_TRAPDOOR);
        this.translateBlock(HorizonsBlocks.JACARANDA_BUTTON);
        this.translateSigns(HorizonsBlocks.JACARANDA_SIGNS, "jacaranda");
        this.translateBlock(HorizonsBlocks.JACARANDA_SAPLING);
        this.translateBlock(HorizonsBlocks.POTTED_JACARANDA_SAPLING);
        this.translateBlock(HorizonsBlocks.AZURE_JACARANDA_SAPLING);
        this.translateBlock(HorizonsBlocks.POTTED_AZURE_JACARANDA_SAPLING);
        this.translateBlock(HorizonsBlocks.JACARANDA_LEAVES);
        this.translateBlock(HorizonsBlocks.BUDDING_JACARANDA_LEAVES);
        this.translateBlock(HorizonsBlocks.FLOWERING_JACARANDA_LEAVES);
        this.translateBlock(HorizonsBlocks.AZURE_JACARANDA_LEAVES);
        this.translateBlock(HorizonsBlocks.BUDDING_AZURE_JACARANDA_LEAVES);
        this.translateBlock(HorizonsBlocks.FLOWERING_AZURE_JACARANDA_LEAVES);

        this.translateBlock(HorizonsBlocks.JACARANDA_BEEHIVE);
        this.translateBlock(HorizonsBlocks.JACARANDA_LADDER);
        this.translateBlock(HorizonsBlocks.VERTICAL_JACARANDA_PLANKS);
        this.translateBlock(HorizonsBlocks.JACARANDA_BOOKSHELF);
        this.translateBlock(HorizonsBlocks.JACARANDA_BOARDS);
        this.translateBlock(HorizonsBlocks.JACARANDA_VERTICAL_SLAB);
        this.translateBlock(HorizonsBlocks.STRIPPED_JACARANDA_POST);
        this.translateBlock(HorizonsBlocks.JACARANDA_POST);
        this.translateBlock(HorizonsBlocks.JACARANDA_CHEST);
        this.translateBlock(HorizonsBlocks.JACARANDA_TRAPPED_CHEST);
        this.translateBlock(HorizonsBlocks.JACARANDA_CABINET);
        this.add(HorizonsBlocks.JACARANDA_HEDGE.get(), "Jacaranda Leaf Hedge");

        this.translateBlock(HorizonsBlocks.JACARANDA_LEAF_CARPET);
        this.add(HorizonsBlocks.JACARANDA_LEAF_PILE.get(), "Pile of Jacaranda Leaves");
        this.add(HorizonsBlocks.BUDDING_JACARANDA_HEDGE.get(), "Budding Jacaranda Leaf Hedge");
        this.translateBlock(HorizonsBlocks.BUDDING_JACARANDA_LEAF_CARPET);
        this.add(HorizonsBlocks.BUDDING_JACARANDA_LEAF_PILE.get(), "Pile of Budding Jacaranda Leaves");
        this.add(HorizonsBlocks.FLOWERING_JACARANDA_HEDGE.get(), "Flowering Jacaranda Leaf Hedge");
        this.translateBlock(HorizonsBlocks.FLOWERING_JACARANDA_LEAF_CARPET);
        this.add(HorizonsBlocks.FLOWERING_JACARANDA_LEAF_PILE.get(), "Pile of Flowering Jacaranda Leaves");

        this.add(HorizonsBlocks.AZURE_JACARANDA_HEDGE.get(), "Blue Jacaranda Leaf Hedge");
        this.translateBlock(HorizonsBlocks.AZURE_JACARANDA_LEAF_CARPET);
        this.add(HorizonsBlocks.AZURE_JACARANDA_LEAF_PILE.get(), "Pile of Blue Jacaranda Leaves");
        this.add(HorizonsBlocks.BUDDING_AZURE_JACARANDA_HEDGE.get(), "Budding Blue Jacaranda Leaf Hedge");
        this.translateBlock(HorizonsBlocks.BUDDING_AZURE_JACARANDA_LEAF_CARPET);
        this.add(HorizonsBlocks.BUDDING_AZURE_JACARANDA_LEAF_PILE.get(), "Pile of Budding Blue Jacaranda Leaves");
        this.add(HorizonsBlocks.FLOWERING_AZURE_JACARANDA_HEDGE.get(), "Flowering Blue Jacaranda Leaf Hedge");
        this.translateBlock(HorizonsBlocks.FLOWERING_AZURE_JACARANDA_LEAF_CARPET);
        this.add(HorizonsBlocks.FLOWERING_AZURE_JACARANDA_LEAF_PILE.get(), "Pile of Flowering Blue Jacaranda Leaves");

        this.translateBlock(HorizonsBlocks.SUNFLOWER_SEED_SACK);

        this.translateBlock(HorizonsBlocks.LAVENDER);
        this.add(HorizonsBlocks.TALL_LAVENDER.get(), "Lavender");
        this.translateBlock(HorizonsBlocks.LAVENDER_BASKET);

        this.translateBlock(HorizonsBlocks.HELICONIA);
        this.translateBlock(HorizonsBlocks.AMARANTHUS);
        this.translateBlock(HorizonsBlocks.MYOSOTIS);

        this.translateBlock(HorizonsBlocks.POTTED_AMARANTHUS);
        this.translateBlock(HorizonsBlocks.POTTED_MYOSOTIS);

        //biomes
        this.translateBiome(HorizonsBiomes.BAYOU);
        this.translateBiome(HorizonsBiomes.REDBUD_GROVE);

        //effects
        this.translateEffect(HorizonsEffects.SUPPORTIVE);

        //potions
        this.translatePotion(HorizonsEffects.SUPPORTIVE_NORMAL, "Supportive");
        this.translatePotion(HorizonsEffects.SUPPORTIVE_LONG, "Supportive");
        this.translatePotion(HorizonsEffects.SUPPORTIVE_STRONG, "Supportive");

    }

    private void translateItem(RegistryObject<? extends Item> item) {
        this.add(item.get(), toUpper(ForgeRegistries.ITEMS, item));
    }

    private void translateBlock(RegistryObject<? extends Block> block) {
        this.add(block.get(), toUpper(ForgeRegistries.BLOCKS, block));
    }

    private void translateSigns(Pair<RegistryObject<BlueprintStandingSignBlock>, RegistryObject<BlueprintWallSignBlock>> sign, String name) {
        this.translateBlock(sign.getFirst());
        this.add(sign.getFirst().get().getDescriptionId().replace(name, name + "_wall"), toUpper(ForgeRegistries.BLOCKS, sign.getSecond()));
    }

    private void translateBiome(BiomeSubRegistryHelper.KeyedBiome biome) {
        this.add("biome." + Horizons.MODID + "." + ForgeRegistries.BIOMES.getKey(biome.get()).getPath(), toUpper(ForgeRegistries.BIOMES, biome.getObject()));
    }

    private void translatePotion(RegistryObject<? extends Potion> potion, String effect) {
        String name = ForgeRegistries.POTIONS.getKey(potion.get()).getPath();

        this.add("item.minecraft.potion.effect." + name, "Potion of " + effect);
        this.add("item.minecraft.splash_potion.effect." + name, "Splash Potion of " + effect);
        this.add("item.minecraft.tipped_arrow.effect." + name, "Arrow of " + effect);
        this.add("item.minecraft.lingering_potion.effect." + name, "Lingering Potion of " + effect);
        this.add("item.caverns_and_chasms.tether_potion.effect." + name, "Tether Potion of " + effect);
    }

    private void translateEffect(RegistryObject<? extends MobEffect> effect) {
        this.add(effect.get(), toUpper(ForgeRegistries.MOB_EFFECTS, effect));
    }

    private static <T> String toUpper(IForgeRegistry<T> entry, RegistryObject<? extends T> object) {
        return StringUtils.capitaliseAllWords(entry.getKey(object.get()).getPath().replace('_', ' '));
    }

}
