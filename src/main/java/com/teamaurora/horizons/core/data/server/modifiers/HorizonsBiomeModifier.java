package com.teamaurora.horizons.core.data.server.modifiers;

import com.mojang.serialization.JsonOps;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.registry.HorizonsFeatures;
import com.teamaurora.horizons.core.other.tags.HorizonsBiomeTags;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.data.JsonCodecProvider;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author rose_
 */
public class HorizonsBiomeModifier {
    private static final RegistryAccess access = RegistryAccess.builtinCopy();
    private static final Registry<Biome> biomeRegistry = access.registryOrThrow(Registry.BIOME_REGISTRY);
    private static final Registry<PlacedFeature> placedFeatures = access.registryOrThrow(Registry.PLACED_FEATURE_REGISTRY);
    private static final HashMap<ResourceLocation, BiomeModifier> modifiers = new HashMap<>();

    public static JsonCodecProvider<BiomeModifier> register(GatherDataEvent event) {
        addFeature("algae", HorizonsBiomeTags.HAS_ALGAE, GenerationStep.Decoration.VEGETAL_DECORATION, HorizonsFeatures.Placements.ALGAE);
        addFeature("giant_fern", HorizonsBiomeTags.HAS_GIANT_FERN, GenerationStep.Decoration.VEGETAL_DECORATION, HorizonsFeatures.Placements.GIANT_FERN);

        addFeature("blue_lily", HorizonsBiomeTags.HAS_BLUE_LILY, GenerationStep.Decoration.VEGETAL_DECORATION, HorizonsFeatures.Placements.BLUE_LILY);
        addFeature("light_gray_lily", HorizonsBiomeTags.HAS_LIGHT_GRAY_LILY, GenerationStep.Decoration.VEGETAL_DECORATION, HorizonsFeatures.Placements.LIGHT_GRAY_LILY);
        addFeature("cyan_lily", HorizonsBiomeTags.HAS_CYAN_LILY, GenerationStep.Decoration.VEGETAL_DECORATION, HorizonsFeatures.Placements.CYAN_LILY);
        addFeature("light_blue_lily", HorizonsBiomeTags.HAS_LIGHT_BLUE_LILY, GenerationStep.Decoration.VEGETAL_DECORATION, HorizonsFeatures.Placements.LIGHT_BLUE_LILY);
        addFeature("magenta_lily", HorizonsBiomeTags.HAS_MAGENTA_LILY, GenerationStep.Decoration.VEGETAL_DECORATION, HorizonsFeatures.Placements.MAGENTA_LILY);
        addFeature("pink_lily", HorizonsBiomeTags.HAS_PINK_LILY, GenerationStep.Decoration.VEGETAL_DECORATION, HorizonsFeatures.Placements.PINK_LILY);
        addFeature("purple_lily", HorizonsBiomeTags.HAS_PURPLE_LILY, GenerationStep.Decoration.VEGETAL_DECORATION, HorizonsFeatures.Placements.PURPLE_LILY);
        addFeature("white_lily", HorizonsBiomeTags.HAS_WHITE_LILY, GenerationStep.Decoration.VEGETAL_DECORATION, HorizonsFeatures.Placements.WHITE_LILY);

        return JsonCodecProvider.forDatapackRegistry(event.getGenerator(), event.getExistingFileHelper(), Horizons.MODID, RegistryOps.create(JsonOps.INSTANCE, access), ForgeRegistries.Keys.BIOME_MODIFIERS, modifiers);
    }

    @SafeVarargs
    private static void addFeature(String name, TagKey<Biome> tagKey, GenerationStep.Decoration step, RegistryObject<PlacedFeature>... features) {
        modifiers.put(Horizons.REGISTRY_HELPER.prefix("features/" + name),
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(new HolderSet.Named<>(biomeRegistry, tagKey), featureSet(features), step));
    }

    private static void removeFeature(String name, TagKey<Biome> tagKey, GenerationStep.Decoration step, Holder<PlacedFeature> feature) {
        modifiers.put(Horizons.REGISTRY_HELPER.prefix("removed_features/" + name),
                new ForgeBiomeModifiers.RemoveFeaturesBiomeModifier(new HolderSet.Named<>(biomeRegistry, tagKey), featureSet(feature), Set.of(step)));
    }

    private static <T extends LivingEntity> void addSpawn(String name, TagKey<Biome> tagKey, RegistryObject<EntityType<T>> entity, int weight, int min, int max) {
        modifiers.put(Horizons.REGISTRY_HELPER.prefix("spawns/" + name),
                new ForgeBiomeModifiers.AddSpawnsBiomeModifier(new HolderSet.Named<>(biomeRegistry, tagKey), List.of(new MobSpawnSettings.SpawnerData(entity.get(), weight, min, max))));
    }

    @SafeVarargs
    private static HolderSet<PlacedFeature> featureSet(RegistryObject<PlacedFeature>... features) {
        return HolderSet.direct(Stream.of(features).map(registryObject -> {
            assert registryObject.getKey() != null;
            return placedFeatures.getOrCreateHolderOrThrow(registryObject.getKey());
        }).collect(Collectors.toList()));
    }

    @SafeVarargs
    private static HolderSet<PlacedFeature> featureSet(Holder<PlacedFeature>... features) {
        return HolderSet.direct(Stream.of(features).map(holder -> placedFeatures.getOrCreateHolderOrThrow(holder.unwrapKey().get())).collect(Collectors.toList()));
    }
}
