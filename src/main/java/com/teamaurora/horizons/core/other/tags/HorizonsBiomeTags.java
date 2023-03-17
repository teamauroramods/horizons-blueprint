package com.teamaurora.horizons.core.other.tags;

import com.teamabnormals.blueprint.core.util.TagUtil;
import com.teamaurora.horizons.core.Horizons;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public final class HorizonsBiomeTags {
    public static final TagKey<Biome> HAS_PERCH = TagUtil.biomeTag("upgrade_aquatic", "has_animal/perch");

    public static final TagKey<Biome> HAS_ALGAE = TagUtil.biomeTag(Horizons.MODID, "has_feature/algae");

    public static final TagKey<Biome> HAS_BLUE_LILY = TagUtil.biomeTag(Horizons.MODID, "has_feature/blue_lily");
    public static final TagKey<Biome> HAS_LIGHT_GRAY_LILY = TagUtil.biomeTag(Horizons.MODID, "has_feature/light_gray_lily");
    public static final TagKey<Biome> HAS_CYAN_LILY = TagUtil.biomeTag(Horizons.MODID, "has_feature/cyan_lily");
    public static final TagKey<Biome> HAS_LIGHT_BLUE_LILY = TagUtil.biomeTag(Horizons.MODID, "has_feature/light_blue_lily");
    public static final TagKey<Biome> HAS_MAGENTA_LILY = TagUtil.biomeTag(Horizons.MODID, "has_feature/magenta_lily");
    public static final TagKey<Biome> HAS_PINK_LILY = TagUtil.biomeTag(Horizons.MODID, "has_feature/pink_lily");
    public static final TagKey<Biome> HAS_PURPLE_LILY = TagUtil.biomeTag(Horizons.MODID, "has_feature/purple_lily");
    public static final TagKey<Biome> HAS_WHITE_LILY = TagUtil.biomeTag(Horizons.MODID, "has_feature/white_lily");
}
