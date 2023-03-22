package com.teamaurora.horizons.core.other;

import com.teamabnormals.blueprint.core.util.DataUtil;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsItems;

public final class HorizonsBlockInfo {
    public static void registerCompostables() {
        DataUtil.registerCompostable(HorizonsItems.GOOSEBERRIES.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.GOOSEBERRY_SACK.get(), 1f);
        DataUtil.registerCompostable(HorizonsItems.HONEY_GLAZED_GOOSEBERRIES.get(), .3f);
        DataUtil.registerCompostable(HorizonsItems.GOOSEBERRY_JAM_COOKIE.get(), .85f);
        DataUtil.registerCompostable(HorizonsItems.GOOSEBERRY_PIE.get(), 1f);
        DataUtil.registerCompostable(HorizonsItems.SUNFLOWER_SEEDS.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.SUNFLOWER_SEED_SACK.get(), 1f);

        DataUtil.registerCompostable(HorizonsBlocks.CYPRESS_LEAVES.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.CYPRESS_SAPLING.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.CYPRESS_LEAF_CARPET.get(), .3f);

        DataUtil.registerCompostable(HorizonsBlocks.BEARD_MOSS_BLOCK.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.BEARD_MOSS.get(), .3f);

        DataUtil.registerCompostable(HorizonsBlocks.REDWOOD_LEAVES.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.REDWOOD_SAPLING.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.REDWOOD_LEAF_CARPET.get(), .3f);

        DataUtil.registerCompostable(HorizonsBlocks.REDBUD_LEAVES.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.REDBUD_LEAF_CARPET.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.REDBUD_SAPLING.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.BUDDING_REDBUD_LEAVES.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.BUDDING_REDBUD_LEAF_CARPET.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.BUDDING_REDBUD_SAPLING.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.FLOWERING_REDBUD_LEAVES.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.FLOWERING_REDBUD_LEAF_CARPET.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.FLOWERING_REDBUD_SAPLING.get(), .3f);
        
        DataUtil.registerCompostable(HorizonsBlocks.JACARANDA_LEAVES.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.JACARANDA_LEAF_CARPET.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.JACARANDA_SAPLING.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.BUDDING_JACARANDA_LEAVES.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.BUDDING_JACARANDA_LEAF_CARPET.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.FLOWERING_JACARANDA_LEAVES.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.FLOWERING_JACARANDA_LEAF_CARPET.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.BLUE_JACARANDA_LEAVES.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.BLUE_JACARANDA_LEAF_CARPET.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.BLUE_JACARANDA_SAPLING.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.BUDDING_BLUE_JACARANDA_LEAVES.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.BUDDING_BLUE_JACARANDA_LEAF_CARPET.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.FLOWERING_BLUE_JACARANDA_LEAVES.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.FLOWERING_BLUE_JACARANDA_LEAF_CARPET.get(), .3f);

        DataUtil.registerCompostable(HorizonsBlocks.BLUE_LILY.get(), .65f);
        DataUtil.registerCompostable(HorizonsBlocks.LIGHT_GRAY_LILY.get(), .65f);
        DataUtil.registerCompostable(HorizonsBlocks.CYAN_LILY.get(), .65f);
        DataUtil.registerCompostable(HorizonsBlocks.LIGHT_BLUE_LILY.get(), .65f);
        DataUtil.registerCompostable(HorizonsBlocks.MAGENTA_LILY.get(), .65f);
        DataUtil.registerCompostable(HorizonsBlocks.PINK_LILY.get(), .65f);
        DataUtil.registerCompostable(HorizonsBlocks.PURPLE_LILY.get(), .65f);
        DataUtil.registerCompostable(HorizonsBlocks.WHITE_LILY.get(), .65f);

        DataUtil.registerCompostable(HorizonsBlocks.YELLOW_DAISY.get(), .65f);
        DataUtil.registerCompostable(HorizonsBlocks.RED_DAISY.get(), .65f);
        DataUtil.registerCompostable(HorizonsBlocks.PURPLE_DAISY.get(), .65f);
        DataUtil.registerCompostable(HorizonsBlocks.PINK_DAISY.get(), .65f);
        DataUtil.registerCompostable(HorizonsBlocks.ORANGE_DAISY.get(), .65f);
        DataUtil.registerCompostable(HorizonsBlocks.MAGENTA_DAISY.get(), .65f);
        DataUtil.registerCompostable(HorizonsBlocks.BLUE_DAISY.get(), .65f);
    }

    public static void registerFlammables() {
        DataUtil.registerFlammable(HorizonsBlocks.STRIPPED_CYPRESS_LOG.get(), 5, 5);
        DataUtil.registerFlammable(HorizonsBlocks.STRIPPED_CYPRESS_WOOD.get(), 5, 5);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_LOG.get(), 5, 5);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_WOOD.get(), 5, 5);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_PLANKS.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.VERTICAL_CYPRESS_PLANKS.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_SLAB.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_STAIRS.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_FENCE.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_FENCE_GATE.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_BOARDS.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_VERTICAL_SLAB.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_BOOKSHELF.get(), 30, 20);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_BEEHIVE.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_POST.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.STRIPPED_CYPRESS_POST.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_LEAVES.get(), 30, 60);
        DataUtil.registerFlammable(HorizonsBlocks.HANGING_CYPRESS_LEAVES.get(), 30, 60);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_LEAF_CARPET.get(), 30, 60);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_HEDGE.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_LEAF_PILE.get(), 30, 60);
        
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_KNEE.get(), 5, 5);
        DataUtil.registerFlammable(HorizonsBlocks.LARGE_CYPRESS_KNEE.get(), 5, 5);
        DataUtil.registerFlammable(HorizonsBlocks.STRIPPED_CYPRESS_KNEE.get(), 5, 5);
        DataUtil.registerFlammable(HorizonsBlocks.STRIPPED_LARGE_CYPRESS_KNEE.get(), 5, 5);

        DataUtil.registerFlammable(HorizonsBlocks.BEARD_MOSS_BLOCK.get(), 30, 60);
        DataUtil.registerFlammable(HorizonsBlocks.BEARD_MOSS.get(), 30, 60);

        DataUtil.registerFlammable(HorizonsBlocks.STRIPPED_REDWOOD_LOG.get(), 5, 5);
        DataUtil.registerFlammable(HorizonsBlocks.STRIPPED_REDWOOD_WOOD.get(), 5, 5);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_LOG.get(), 5, 5);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_WOOD.get(), 5, 5);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_PLANKS.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.VERTICAL_REDWOOD_PLANKS.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_SLAB.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_STAIRS.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_FENCE.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_FENCE_GATE.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_BOARDS.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_VERTICAL_SLAB.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_BOOKSHELF.get(), 30, 20);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_BEEHIVE.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_POST.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.STRIPPED_REDWOOD_POST.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_LEAVES.get(), 30, 60);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_LEAF_CARPET.get(), 30, 60);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_HEDGE.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.REDWOOD_LEAF_PILE.get(), 30, 60);

        DataUtil.registerFlammable(HorizonsBlocks.BLUE_LILY.get(), 60, 100);
        DataUtil.registerFlammable(HorizonsBlocks.LIGHT_GRAY_LILY.get(), 60, 100);
        DataUtil.registerFlammable(HorizonsBlocks.CYAN_LILY.get(), 60, 100);
        DataUtil.registerFlammable(HorizonsBlocks.LIGHT_BLUE_LILY.get(), 60, 100);
        DataUtil.registerFlammable(HorizonsBlocks.MAGENTA_LILY.get(), 60, 100);
        DataUtil.registerFlammable(HorizonsBlocks.PINK_LILY.get(), 60, 100);
        DataUtil.registerFlammable(HorizonsBlocks.PURPLE_LILY.get(), 60, 100);
        DataUtil.registerFlammable(HorizonsBlocks.WHITE_LILY.get(), 60, 100);

        DataUtil.registerFlammable(HorizonsBlocks.YELLOW_DAISY.get(), 60, 100);
        DataUtil.registerFlammable(HorizonsBlocks.RED_DAISY.get(), 60, 100);
        DataUtil.registerFlammable(HorizonsBlocks.PURPLE_DAISY.get(), 60, 100);
        DataUtil.registerFlammable(HorizonsBlocks.PINK_DAISY.get(), 60, 100);
        DataUtil.registerFlammable(HorizonsBlocks.ORANGE_DAISY.get(), 60, 100);
        DataUtil.registerFlammable(HorizonsBlocks.MAGENTA_DAISY.get(), 60, 100);
        DataUtil.registerFlammable(HorizonsBlocks.BLUE_DAISY.get(), 60, 100);
    }

}
