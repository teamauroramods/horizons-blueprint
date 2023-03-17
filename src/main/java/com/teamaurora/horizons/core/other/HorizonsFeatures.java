package com.teamaurora.horizons.core.other;

import com.teamaurora.horizons.common.levelgen.feature.AlgaePatch;
import com.teamaurora.horizons.core.Horizons;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

/**
 * @author rose_
 */
public final class HorizonsFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Horizons.MODID);

    public static RegistryObject<Feature<NoneFeatureConfiguration>> ALGAE_PATCH = FEATURES.register("algae_patch", AlgaePatch::new);

    public static class Configs {

    }

    public static class Features {
        public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Horizons.MODID);

        public static final RegistryObject<ConfiguredFeature<?, ?>> ALGAE = CONFIGURED_FEATURES.register("algae", () -> new ConfiguredFeature<>(ALGAE_PATCH.get(), NoneFeatureConfiguration.NONE));

    }

    public static class Placements {
        public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Horizons.MODID);

        public static final RegistryObject<PlacedFeature> ALGAE = createPlantPatch("algae", 3, Features.ALGAE);

        private static RegistryObject<PlacedFeature> createPlantPatch(String name, int onceEvery, RegistryObject<ConfiguredFeature<?, ?>> feature) {
            return register(name, feature, RarityFilter.onAverageOnceEvery(onceEvery), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        }

        public static RegistryObject<PlacedFeature> register(String name, RegistryObject<? extends ConfiguredFeature<?, ?>> configuredFeature, PlacementModifier... placementModifiers) {
            return register(name, configuredFeature, List.of(placementModifiers));
        }

        public static RegistryObject<PlacedFeature> register(String name, RegistryObject<? extends ConfiguredFeature<?, ?>> configuredFeature, List<PlacementModifier> placementModifiers) {
            return PLACED_FEATURES.register(name, () -> new PlacedFeature((Holder<ConfiguredFeature<?, ?>>) configuredFeature.getHolder().get(), placementModifiers));
        }

        public static RegistryObject<PlacedFeature> register(String name, Holder<? extends ConfiguredFeature<?, ?>> configuredFeature, List<PlacementModifier> placementModifiers) {
            return PLACED_FEATURES.register(name, () -> new PlacedFeature((Holder<ConfiguredFeature<?, ?>>) configuredFeature, placementModifiers));
        }
    }

}
