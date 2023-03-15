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
}
