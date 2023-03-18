package com.teamaurora.horizons.core.other.tags;

import com.teamabnormals.blueprint.core.util.TagUtil;
import com.teamaurora.horizons.core.Horizons;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

/**
 * @author rose_
 */
public final class HorizonsBlockTags {
    public static final TagKey<Block> CYPRESS_LOGS = TagUtil.blockTag(Horizons.MODID, "cypress_logs");
    public static final TagKey<Block> CYPRESS_LEAVES = TagUtil.blockTag(Horizons.MODID, "cypress_leaves");

    public static final TagKey<Block> REDWOOD_LOGS = TagUtil.blockTag(Horizons.MODID, "redwood_logs");
    public static final TagKey<Block> REDWOOD_LEAVES = TagUtil.blockTag(Horizons.MODID, "redwood_leaves");

    public static final TagKey<Block> REDBUD_LOGS = TagUtil.blockTag(Horizons.MODID, "redbud_logs");
    public static final TagKey<Block> REDBUD_LEAVES = TagUtil.blockTag(Horizons.MODID, "redbud_leaves");

    public static final TagKey<Block> JACARANDA_LOGS = TagUtil.blockTag(Horizons.MODID, "jacaranda_logs");
    public static final TagKey<Block> JACARANDA_LEAVES = TagUtil.blockTag(Horizons.MODID, "jacaranda_leaves");
}
