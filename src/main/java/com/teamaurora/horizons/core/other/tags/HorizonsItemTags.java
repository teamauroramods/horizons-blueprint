package com.teamaurora.horizons.core.other.tags;

import com.teamabnormals.blueprint.core.util.TagUtil;
import com.teamaurora.horizons.core.Horizons;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

/**
 * @author rose_
 */
public final class HorizonsItemTags {
    public static final TagKey<Item> CYPRESS_LOGS = TagUtil.itemTag(Horizons.MODID, "cypress_logs");
    public static final TagKey<Item> BERRIES = TagUtil.itemTag("forge", "berries");

}
