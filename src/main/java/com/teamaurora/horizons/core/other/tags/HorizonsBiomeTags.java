package com.teamaurora.horizons.core.other.tags;

import com.teamabnormals.blueprint.core.util.TagUtil;
import com.teamaurora.horizons.core.Horizons;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public final class HorizonsBiomeTags {
    public static final TagKey<Biome> HAS_PERCH = TagUtil.biomeTag("upgrade_aquatic", "has_animal/perch");

    public static final TagKey<Biome> HAS_ALGAE = TagUtil.biomeTag(Horizons.MODID, "has_feature/algae");
}
