package com.teamaurora.horizons.core.data.server.tags;

import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.other.tags.HorizonsBiomeTags;
import com.teamaurora.horizons.core.registry.HorizonsBiomes;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.Tags;
import net.minecraftforge.data.event.GatherDataEvent;

/**
 * @author rose_
 */
public class HorizonsBiomeTagsProvider extends BiomeTagsProvider {
    public HorizonsBiomeTagsProvider(GatherDataEvent event) {
        super(event.getGenerator(), Horizons.MODID, event.getExistingFileHelper());
    }

    @Override
    protected void addTags() {
        this.tag(HorizonsBiomeTags.HAS_ALGAE).add(HorizonsBiomes.BAYOU.getKey());
        this.tag(HorizonsBiomeTags.HAS_GIANT_FERN).addTag(Tags.Biomes.IS_SWAMP);

        this.tag(HorizonsBiomeTags.HAS_BLUE_LILY).addTag(Tags.Biomes.IS_SWAMP);
        this.tag(HorizonsBiomeTags.HAS_LIGHT_GRAY_LILY).addTag(Tags.Biomes.IS_SWAMP);
        this.tag(HorizonsBiomeTags.HAS_CYAN_LILY).addTag(Tags.Biomes.IS_SWAMP);
        this.tag(HorizonsBiomeTags.HAS_LIGHT_BLUE_LILY).addTag(Tags.Biomes.IS_SWAMP);
        this.tag(HorizonsBiomeTags.HAS_MAGENTA_LILY).addTag(Tags.Biomes.IS_SWAMP);
        this.tag(HorizonsBiomeTags.HAS_PINK_LILY).addTag(Tags.Biomes.IS_SWAMP);
        this.tag(HorizonsBiomeTags.HAS_PURPLE_LILY).addTag(Tags.Biomes.IS_SWAMP);
        this.tag(HorizonsBiomeTags.HAS_WHITE_LILY).addTag(Tags.Biomes.IS_SWAMP);

        this.tag(HorizonsBiomeTags.HAS_YELLOW_DAISY).add(Biomes.PLAINS, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.WINDSWEPT_FOREST, Biomes.FLOWER_FOREST, Biomes.MEADOW);
        this.tag(HorizonsBiomeTags.HAS_RED_DAISY).add(Biomes.PLAINS, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.WINDSWEPT_FOREST, Biomes.FLOWER_FOREST, Biomes.MEADOW);
        this.tag(HorizonsBiomeTags.HAS_PURPLE_DAISY).add(Biomes.PLAINS, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.WINDSWEPT_FOREST, Biomes.FLOWER_FOREST, Biomes.MEADOW);
        this.tag(HorizonsBiomeTags.HAS_PINK_DAISY).add(Biomes.PLAINS, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.WINDSWEPT_FOREST, Biomes.FLOWER_FOREST, Biomes.MEADOW);
        this.tag(HorizonsBiomeTags.HAS_ORANGE_DAISY).add(Biomes.PLAINS, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.WINDSWEPT_FOREST, Biomes.FLOWER_FOREST, Biomes.MEADOW);
        this.tag(HorizonsBiomeTags.HAS_MAGENTA_DAISY).add(Biomes.PLAINS, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.WINDSWEPT_FOREST, Biomes.FLOWER_FOREST, Biomes.MEADOW);
        this.tag(HorizonsBiomeTags.HAS_BLUE_DAISY).add(Biomes.PLAINS, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.WINDSWEPT_FOREST, Biomes.FLOWER_FOREST, Biomes.MEADOW);

        this.tag(HorizonsBiomeTags.HAS_AMARANTHUS).add(HorizonsBiomes.REDBUD_GROVE.getKey(), Biomes.MEADOW);
        this.tag(HorizonsBiomeTags.HAS_MYOSOTIS).addTag(BiomeTags.IS_TAIGA);
        //this.tag(HorizonsBiomeTags.HAS_FIDDLENECK).a //redwood

        this.tag(HorizonsBiomeTags.HAS_PERCH).add(HorizonsBiomes.BAYOU.getKey());
        this.tag(HorizonsBiomeTags.HAS_CATTAILS).add(HorizonsBiomes.BAYOU.getKey());
        this.tag(HorizonsBiomeTags.HAS_MUD_DISK).add(HorizonsBiomes.BAYOU.getKey());
        this.tag(HorizonsBiomeTags.HAS_SPOTTED_RED_MAPLE_TREES).add(HorizonsBiomes.REDWOOD_FOREST.getKey());

        this.tag(BiomeTags.IS_FOREST).add(HorizonsBiomes.BAYOU.getKey(), HorizonsBiomes.REDBUD_GROVE.getKey(), HorizonsBiomes.REDWOOD_FOREST.getKey());
        this.tag(BiomeTags.HAS_MINESHAFT).add(HorizonsBiomes.BAYOU.getKey(), HorizonsBiomes.REDBUD_GROVE.getKey(), HorizonsBiomes.REDWOOD_FOREST.getKey());
        this.tag(BiomeTags.HAS_SWAMP_HUT).add(HorizonsBiomes.BAYOU.getKey());
        this.tag(BiomeTags.SPAWNS_WARM_VARIANT_FROGS).add(HorizonsBiomes.BAYOU.getKey());
        this.tag(BiomeTags.HAS_RUINED_PORTAL_SWAMP).add(HorizonsBiomes.BAYOU.getKey());
        this.tag(BiomeTags.IS_TAIGA).add(HorizonsBiomes.REDWOOD_FOREST.getKey());
        this.tag(BiomeTags.STRONGHOLD_BIASED_TO).add(HorizonsBiomes.REDWOOD_FOREST.getKey());
        this.tag(Tags.Biomes.IS_SWAMP).add(HorizonsBiomes.BAYOU.getKey());
        this.tag(Tags.Biomes.IS_DENSE).add(HorizonsBiomes.BAYOU.getKey(), HorizonsBiomes.REDWOOD_FOREST.getKey());
        this.tag(Tags.Biomes.IS_DENSE_OVERWORLD).add(HorizonsBiomes.BAYOU.getKey(), HorizonsBiomes.REDWOOD_FOREST.getKey());
        this.tag(Tags.Biomes.IS_CONIFEROUS).add(HorizonsBiomes.REDWOOD_FOREST.getKey());
    }
}
