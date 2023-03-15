package com.teamaurora.horizons.core.other;

import com.teamabnormals.blueprint.core.util.DataUtil;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsItems;

public final class HorizonsBlockInfo {
    public static void registerCompostables() {
        DataUtil.registerCompostable(HorizonsItems.GOOSEBERRIES.get(), .3f);
        DataUtil.registerCompostable(HorizonsItems.HONEY_GLAZED_GOOSEBERRIES.get(), .3f);
        DataUtil.registerCompostable(HorizonsItems.GOOSEBERRY_JAM_COOKIE.get(), .85f);
        DataUtil.registerCompostable(HorizonsItems.GOOSEBERRY_PIE.get(), 1f);

        DataUtil.registerCompostable(HorizonsBlocks.CYPRESS_LEAVES.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.CYPRESS_SAPLING.get(), .3f);
        DataUtil.registerCompostable(HorizonsBlocks.CYPRESS_LEAF_CARPET.get(), .3f);
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
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_LEAF_CARPET.get(), 30, 60);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_HEDGE.get(), 5, 20);
        DataUtil.registerFlammable(HorizonsBlocks.CYPRESS_LEAF_PILE.get(), 30, 60);

    }

}
