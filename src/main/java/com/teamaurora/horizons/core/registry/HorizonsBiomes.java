package com.teamaurora.horizons.core.registry;

import com.teamabnormals.blueprint.core.util.registry.BiomeSubRegistryHelper;
import com.teamaurora.horizons.core.Horizons;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

/**
 * @author rose_
 */
@Mod.EventBusSubscriber(modid = Horizons.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HorizonsBiomes {
    public static final BiomeSubRegistryHelper HELPER = Horizons.REGISTRY_HELPER.getBiomeSubHelper();

    // Biomes //

    public static final BiomeSubRegistryHelper.KeyedBiome BAYOU = HELPER.createBiome("bayou", HorizonsBiomes::bayou);
    public static final BiomeSubRegistryHelper.KeyedBiome REDBUD_GROVE = HELPER.createBiome("redbud_grove", HorizonsBiomes::redbudGrove);
    public static final BiomeSubRegistryHelper.KeyedBiome REDWOOD_FOREST = HELPER.createBiome("redwood_forest", HorizonsBiomes::redwoodForest);

    // Biome Builders //

    private static Biome bayou() {
        MobSpawnSettings.Builder spawns = baseBayouSpawns();
        BiomeGenerationSettings.Builder gen = new BiomeGenerationSettings.Builder();

        BiomeDefaultFeatures.addFossilDecoration(gen);
        OverworldBiomes.globalOverworldGeneration(gen);
        BiomeDefaultFeatures.addFerns(gen);
        BiomeDefaultFeatures.addPlainGrass(gen);
        BiomeDefaultFeatures.addDefaultOres(gen);
        BiomeDefaultFeatures.addSwampClayDisk(gen);

        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.FLOWER_SWAMP);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_TAIGA_2);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_PLAIN);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.BROWN_MUSHROOM_SWAMP);
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.RED_MUSHROOM_SWAMP);

        BiomeDefaultFeatures.addDefaultMushrooms(gen);
        BiomeDefaultFeatures.addSwampExtraVegetation(gen);

        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);

        return biome(Biome.Precipitation.RAIN, 0.75F, 1.0F, 0x87C0C6, 0x3D5156, 0xA0E2E5, spawns, gen, OverworldBiomes.NORMAL_MUSIC);
    }

    private static Biome redbudGrove() {
        MobSpawnSettings.Builder spawns = baseRedbudGroveSpawns();
        BiomeGenerationSettings.Builder gen = new BiomeGenerationSettings.Builder();

        OverworldBiomes.globalOverworldGeneration(gen);
        BiomeDefaultFeatures.addPlainGrass(gen);
        BiomeDefaultFeatures.addDefaultOres(gen);
        BiomeDefaultFeatures.addDefaultSoftDisks(gen);
        BiomeDefaultFeatures.addMeadowVegetation(gen);
        BiomeDefaultFeatures.addExtraEmeralds(gen);
        BiomeDefaultFeatures.addInfestedStone(gen);

        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, HorizonsFeatures.Placements.REDBUD_TREES.getHolder().get());
        gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, HorizonsFeatures.Placements.TALL_BIRCH.getHolder().get());

        return biome(Biome.Precipitation.RAIN, 0.8F, 0.8F, 937679, 329011, 12638463, spawns, gen, Musics.createGameMusic(SoundEvents.MUSIC_BIOME_MEADOW));
    }

    private static Biome redwoodForest() {
        MobSpawnSettings.Builder spawns = baseRedwoodForestSpawns();
        BiomeGenerationSettings.Builder gen = new BiomeGenerationSettings.Builder();

        OverworldBiomes.globalOverworldGeneration(gen);
        gen.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, HorizonsFeatures.Placements.DARK_BOULDER.getHolder().get());
        BiomeDefaultFeatures.addFerns(gen);
        BiomeDefaultFeatures.addDefaultOres(gen);
        BiomeDefaultFeatures.addDefaultSoftDisks(gen);
        BiomeDefaultFeatures.addDefaultFlowers(gen);
        BiomeDefaultFeatures.addGiantTaigaVegetation(gen);
        BiomeDefaultFeatures.addDefaultMushrooms(gen);
        BiomeDefaultFeatures.addDefaultExtraVegetation(gen);
        BiomeDefaultFeatures.addCommonBerryBushes(gen);

        return biome(Biome.Precipitation.RAIN, 0.25F, 0.8F, 4159204, 329011, 12638463, spawns, gen, Musics.createGameMusic(SoundEvents.MUSIC_BIOME_OLD_GROWTH_TAIGA));
    }

    // Base Spawns //

    private static MobSpawnSettings.Builder baseBayouSpawns() {
        MobSpawnSettings.Builder spawns = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.commonSpawns(spawns);
        BiomeDefaultFeatures.farmAnimals(spawns);
        spawns.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 2, 1, 1));
        spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FROG, 3, 2, 4));

        return spawns;
    }

    private static MobSpawnSettings.Builder baseRedbudGroveSpawns() {
        MobSpawnSettings.Builder spawns = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.commonSpawns(spawns);
        spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 1, 1, 2));
        spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 2, 2, 6));
        spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 2, 2, 4));

        return spawns;
    }

    private static MobSpawnSettings.Builder baseRedwoodForestSpawns() {
        MobSpawnSettings.Builder spawns = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.commonSpawns(spawns);
        BiomeDefaultFeatures.farmAnimals(spawns);
        spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4));
        spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3));
        spawns.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));

        return spawns;
    }

    // Util //

    private static Biome biome(Biome.Precipitation precipitation, float temperature, float downfall, int waterColor, int waterFogColor, int fogColor, MobSpawnSettings.Builder spawnBuilder, BiomeGenerationSettings.Builder biomeBuilder, @Nullable Music music) {
        return new Biome.BiomeBuilder()
                .precipitation(precipitation)
                .temperature(temperature)
                .downfall(downfall)
                .specialEffects(new BiomeSpecialEffects.Builder().waterColor(waterColor)
                        .waterFogColor(waterFogColor).fogColor(fogColor)
                        .skyColor(calculateSkyColor(temperature))
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(music).build()).mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build()).build();
    }

    private static int calculateSkyColor(float temperature) {
        float clampedTemp = Mth.clamp(temperature / 3.0F, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - clampedTemp * 0.05F, 0.5F + clampedTemp * 0.1F, 1.0F);
    }

}
