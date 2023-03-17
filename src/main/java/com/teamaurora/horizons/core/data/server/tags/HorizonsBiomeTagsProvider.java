package com.teamaurora.horizons.core.data.server.tags;

import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.other.tags.HorizonsBiomeTags;
import com.teamaurora.horizons.core.registry.HorizonsBiomes;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.Tags;
import net.minecraftforge.data.event.GatherDataEvent;

public class HorizonsBiomeTagsProvider extends BiomeTagsProvider {
    public HorizonsBiomeTagsProvider(GatherDataEvent event) {
        super(event.getGenerator(), Horizons.MODID, event.getExistingFileHelper());
    }

    @Override
    protected void addTags() {
        this.tag(HorizonsBiomeTags.HAS_ALGAE).add(HorizonsBiomes.BAYOU.getKey());

        this.tag(HorizonsBiomeTags.HAS_BLUE_LILY).add(HorizonsBiomes.BAYOU.getKey(), Biomes.SWAMP);
        this.tag(HorizonsBiomeTags.HAS_LIGHT_GRAY_LILY).add(HorizonsBiomes.BAYOU.getKey(), Biomes.MANGROVE_SWAMP);
        this.tag(HorizonsBiomeTags.HAS_CYAN_LILY).add(HorizonsBiomes.BAYOU.getKey(), Biomes.MANGROVE_SWAMP);
        this.tag(HorizonsBiomeTags.HAS_LIGHT_BLUE_LILY).add(HorizonsBiomes.BAYOU.getKey(), Biomes.MANGROVE_SWAMP);
        this.tag(HorizonsBiomeTags.HAS_MAGENTA_LILY).add(Biomes.SWAMP, Biomes.MANGROVE_SWAMP);
        this.tag(HorizonsBiomeTags.HAS_PINK_LILY).add(HorizonsBiomes.BAYOU.getKey(), Biomes.SWAMP);
        this.tag(HorizonsBiomeTags.HAS_PURPLE_LILY).add(Biomes.SWAMP, Biomes.MANGROVE_SWAMP);
        this.tag(HorizonsBiomeTags.HAS_WHITE_LILY).add(HorizonsBiomes.BAYOU.getKey(), Biomes.SWAMP);

        this.tag(HorizonsBiomeTags.HAS_PERCH).add(HorizonsBiomes.BAYOU.getKey());

        this.tag(BiomeTags.HAS_MINESHAFT).add(HorizonsBiomes.BAYOU.getKey());
        this.tag(BiomeTags.HAS_SWAMP_HUT).add(HorizonsBiomes.BAYOU.getKey());
        this.tag(BiomeTags.SPAWNS_WARM_VARIANT_FROGS).add(HorizonsBiomes.BAYOU.getKey());
        this.tag(BiomeTags.HAS_RUINED_PORTAL_SWAMP).add(HorizonsBiomes.BAYOU.getKey());
        this.tag(Tags.Biomes.IS_SWAMP).add(HorizonsBiomes.BAYOU.getKey());
        this.tag(Tags.Biomes.IS_DENSE).add(HorizonsBiomes.BAYOU.getKey());
        this.tag(Tags.Biomes.IS_DENSE_OVERWORLD).add(HorizonsBiomes.BAYOU.getKey());
    }
}
