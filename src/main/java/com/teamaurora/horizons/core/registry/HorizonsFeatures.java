package com.teamaurora.horizons.core.registry;

import com.teamaurora.horizons.common.levelgen.feature.AlgaePatch;
import com.teamaurora.horizons.core.Horizons;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.InclusiveRange;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.DualNoiseProvider;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
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
        public static final RandomPatchConfiguration BLUE_LILY = createPlantPatch(64, HorizonsBlocks.BLUE_LILY.get().defaultBlockState());
        public static final RandomPatchConfiguration LIGHT_GRAY_LILY = createPlantPatch(64, HorizonsBlocks.LIGHT_GRAY_LILY.get().defaultBlockState());
        public static final RandomPatchConfiguration CYAN_LILY = createPlantPatch(64, HorizonsBlocks.CYAN_LILY.get().defaultBlockState());
        public static final RandomPatchConfiguration LIGHT_BLUE_LILY = createPlantPatch(64, HorizonsBlocks.LIGHT_BLUE_LILY.get().defaultBlockState());
        public static final RandomPatchConfiguration MAGENTA_LILY = createPlantPatch(64, HorizonsBlocks.MAGENTA_LILY.get().defaultBlockState());
        public static final RandomPatchConfiguration PINK_LILY = createPlantPatch(64, HorizonsBlocks.PINK_LILY.get().defaultBlockState());
        public static final RandomPatchConfiguration PURPLE_LILY = createPlantPatch(64, HorizonsBlocks.PURPLE_LILY.get().defaultBlockState());
        public static final RandomPatchConfiguration WHITE_LILY = createPlantPatch(64, HorizonsBlocks.WHITE_LILY.get().defaultBlockState());


        private static RandomPatchConfiguration createPlantPatch(int tries, BlockState state) {
            return new RandomPatchConfiguration(tries, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                    new SimpleBlockConfiguration(new DualNoiseProvider(new InclusiveRange<Integer>(1, 3),
                            new NormalNoise.NoiseParameters(-10, 1d), 1f, 2345l,
                            new NormalNoise.NoiseParameters(-3, 1d), 1f, List.of(state)))));
        }
    }

    public static class Features {
        public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Horizons.MODID);

        public static final RegistryObject<ConfiguredFeature<?, ?>> ALGAE = CONFIGURED_FEATURES.register("algae", () -> new ConfiguredFeature<>(ALGAE_PATCH.get(), NoneFeatureConfiguration.NONE));

        public static final RegistryObject<ConfiguredFeature<?, ?>> BLUE_LILY = CONFIGURED_FEATURES.register("blue_lily", () -> new ConfiguredFeature<>(Feature.NO_BONEMEAL_FLOWER, Configs.BLUE_LILY));
        public static final RegistryObject<ConfiguredFeature<?, ?>> LIGHT_GRAY_LILY = CONFIGURED_FEATURES.register("light_gray_lily", () -> new ConfiguredFeature<>(Feature.NO_BONEMEAL_FLOWER, Configs.LIGHT_GRAY_LILY));
        public static final RegistryObject<ConfiguredFeature<?, ?>> CYAN_LILY = CONFIGURED_FEATURES.register("cyan_lily", () -> new ConfiguredFeature<>(Feature.NO_BONEMEAL_FLOWER, Configs.CYAN_LILY));
        public static final RegistryObject<ConfiguredFeature<?, ?>> LIGHT_BLUE_LILY = CONFIGURED_FEATURES.register("light_blue_lily", () -> new ConfiguredFeature<>(Feature.NO_BONEMEAL_FLOWER, Configs.LIGHT_BLUE_LILY));
        public static final RegistryObject<ConfiguredFeature<?, ?>> MAGENTA_LILY = CONFIGURED_FEATURES.register("magenta_lily", () -> new ConfiguredFeature<>(Feature.NO_BONEMEAL_FLOWER, Configs.MAGENTA_LILY));
        public static final RegistryObject<ConfiguredFeature<?, ?>> PINK_LILY = CONFIGURED_FEATURES.register("pink_lily", () -> new ConfiguredFeature<>(Feature.NO_BONEMEAL_FLOWER, Configs.PINK_LILY));
        public static final RegistryObject<ConfiguredFeature<?, ?>> PURPLE_LILY = CONFIGURED_FEATURES.register("purple_lily", () -> new ConfiguredFeature<>(Feature.NO_BONEMEAL_FLOWER, Configs.PURPLE_LILY));
        public static final RegistryObject<ConfiguredFeature<?, ?>> WHITE_LILY = CONFIGURED_FEATURES.register("white_lily", () -> new ConfiguredFeature<>(Feature.NO_BONEMEAL_FLOWER, Configs.WHITE_LILY));
    }

    public static class Placements {
        public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Horizons.MODID);

        public static final RegistryObject<PlacedFeature> ALGAE = createPlantPatch("algae", 3, Features.ALGAE);

        public static final RegistryObject<PlacedFeature> BLUE_LILY = createPlantPatch("blue_lily", 64, Features.BLUE_LILY);
        public static final RegistryObject<PlacedFeature> LIGHT_GRAY_LILY = createPlantPatch("light_gray_lily", 64, Features.LIGHT_GRAY_LILY);
        public static final RegistryObject<PlacedFeature> CYAN_LILY = createPlantPatch("cyan_lily", 64, Features.CYAN_LILY);
        public static final RegistryObject<PlacedFeature> LIGHT_BLUE_LILY = createPlantPatch("light_blue_lily", 64, Features.LIGHT_BLUE_LILY);
        public static final RegistryObject<PlacedFeature> MAGENTA_LILY = createPlantPatch("magenta_lily", 64, Features.MAGENTA_LILY);
        public static final RegistryObject<PlacedFeature> PINK_LILY = createPlantPatch("pink_lily", 64, Features.PINK_LILY);
        public static final RegistryObject<PlacedFeature> PURPLE_LILY = createPlantPatch("purple_lily", 64, Features.PURPLE_LILY);
        public static final RegistryObject<PlacedFeature> WHITE_LILY = createPlantPatch("white_lily", 64, Features.WHITE_LILY);

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
