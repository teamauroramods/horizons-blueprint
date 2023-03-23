package com.teamaurora.horizons.core.registry;

import com.google.common.collect.ImmutableList;
import com.teamaurora.horizons.common.levelgen.feature.AlgaePatch;
import com.teamaurora.horizons.core.Horizons;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.util.InclusiveRange;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.DualNoiseProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
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
        public static final RandomPatchConfiguration GIANT_FERN = createPlantPatch(64, HorizonsBlocks.GIANT_FERN.get().defaultBlockState());

        public static final RandomPatchConfiguration BLUE_LILY = createPlantPatch(64, HorizonsBlocks.BLUE_LILY.get().defaultBlockState());
        public static final RandomPatchConfiguration LIGHT_GRAY_LILY = createPlantPatch(64, HorizonsBlocks.LIGHT_GRAY_LILY.get().defaultBlockState());
        public static final RandomPatchConfiguration CYAN_LILY = createPlantPatch(64, HorizonsBlocks.CYAN_LILY.get().defaultBlockState());
        public static final RandomPatchConfiguration LIGHT_BLUE_LILY = createPlantPatch(64, HorizonsBlocks.LIGHT_BLUE_LILY.get().defaultBlockState());
        public static final RandomPatchConfiguration MAGENTA_LILY = createPlantPatch(64, HorizonsBlocks.MAGENTA_LILY.get().defaultBlockState());
        public static final RandomPatchConfiguration PINK_LILY = createPlantPatch(64, HorizonsBlocks.PINK_LILY.get().defaultBlockState());
        public static final RandomPatchConfiguration PURPLE_LILY = createPlantPatch(64, HorizonsBlocks.PURPLE_LILY.get().defaultBlockState());
        public static final RandomPatchConfiguration WHITE_LILY = createPlantPatch(64, HorizonsBlocks.WHITE_LILY.get().defaultBlockState());

        public static final TreeConfiguration REDBUD_TREE = createRedbudTree(BlockStateProvider.simple(HorizonsBlocks.REDBUD_LEAVES.get())).decorators(List.of(new BeehiveDecorator(.02f))).build();
        public static final TreeConfiguration FLOWERING_REDBUD_TREE = createRedbudTree(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(HorizonsBlocks.BUDDING_REDBUD_LEAVES.get().defaultBlockState(), 3).add(HorizonsBlocks.FLOWERING_REDBUD_LEAVES.get().defaultBlockState(), 1).build())).decorators(List.of(new BeehiveDecorator(.02f))).build();

        private static RandomPatchConfiguration createPlantPatch(int tries, BlockState state) {
            return new RandomPatchConfiguration(tries, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                    new SimpleBlockConfiguration(new DualNoiseProvider(new InclusiveRange<>(1, 3),
                            new NormalNoise.NoiseParameters(-10, 1d), 1f, 2345l,
                            new NormalNoise.NoiseParameters(-3, 1d), 1f, List.of(state)))));
        }

        private static TreeConfiguration.TreeConfigurationBuilder createCypressTree() {
            return new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(HorizonsBlocks.CYPRESS_LOG.get()),
                    new StraightTrunkPlacer(0, 0, 0),
                    BlockStateProvider.simple(HorizonsBlocks.CYPRESS_LEAVES.get().defaultBlockState()),
                    new BlobFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), 0),
                    new TwoLayersFeatureSize(0, 0, 0)).forceDirt();

        }

        private static TreeConfiguration.TreeConfigurationBuilder createRedbudTree(BlockStateProvider leaves) {
            return new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(HorizonsBlocks.REDBUD_LOG.get()),
                    new StraightTrunkPlacer(4, 2, 0),
                    leaves,
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(2), 4),
                    new TwoLayersFeatureSize(1, 0, 1)).forceDirt().ignoreVines();
        }

    }

    public static class Features {
        public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Horizons.MODID);

        public static final RegistryObject<ConfiguredFeature<?, ?>> ALGAE = CONFIGURED_FEATURES.register("algae", () -> new ConfiguredFeature<>(ALGAE_PATCH.get(), NoneFeatureConfiguration.NONE));
        public static final RegistryObject<ConfiguredFeature<?, ?>> GIANT_FERN = CONFIGURED_FEATURES.register("giant_fern", () -> new ConfiguredFeature<>(Feature.NO_BONEMEAL_FLOWER, Configs.GIANT_FERN));

        public static final RegistryObject<ConfiguredFeature<?, ?>> BLUE_LILY = CONFIGURED_FEATURES.register("blue_lily", () -> new ConfiguredFeature<>(Feature.NO_BONEMEAL_FLOWER, Configs.BLUE_LILY));
        public static final RegistryObject<ConfiguredFeature<?, ?>> LIGHT_GRAY_LILY = CONFIGURED_FEATURES.register("light_gray_lily", () -> new ConfiguredFeature<>(Feature.NO_BONEMEAL_FLOWER, Configs.LIGHT_GRAY_LILY));
        public static final RegistryObject<ConfiguredFeature<?, ?>> CYAN_LILY = CONFIGURED_FEATURES.register("cyan_lily", () -> new ConfiguredFeature<>(Feature.NO_BONEMEAL_FLOWER, Configs.CYAN_LILY));
        public static final RegistryObject<ConfiguredFeature<?, ?>> LIGHT_BLUE_LILY = CONFIGURED_FEATURES.register("light_blue_lily", () -> new ConfiguredFeature<>(Feature.NO_BONEMEAL_FLOWER, Configs.LIGHT_BLUE_LILY));
        public static final RegistryObject<ConfiguredFeature<?, ?>> MAGENTA_LILY = CONFIGURED_FEATURES.register("magenta_lily", () -> new ConfiguredFeature<>(Feature.NO_BONEMEAL_FLOWER, Configs.MAGENTA_LILY));
        public static final RegistryObject<ConfiguredFeature<?, ?>> PINK_LILY = CONFIGURED_FEATURES.register("pink_lily", () -> new ConfiguredFeature<>(Feature.NO_BONEMEAL_FLOWER, Configs.PINK_LILY));
        public static final RegistryObject<ConfiguredFeature<?, ?>> PURPLE_LILY = CONFIGURED_FEATURES.register("purple_lily", () -> new ConfiguredFeature<>(Feature.NO_BONEMEAL_FLOWER, Configs.PURPLE_LILY));
        public static final RegistryObject<ConfiguredFeature<?, ?>> WHITE_LILY = CONFIGURED_FEATURES.register("white_lily", () -> new ConfiguredFeature<>(Feature.NO_BONEMEAL_FLOWER, Configs.WHITE_LILY));

        public static final RegistryObject<ConfiguredFeature<?, ?>> REDBUD_TREES = CONFIGURED_FEATURES.register("redbud_trees", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(TreePlacements.FLOWERING_REDBUD_TREES.getHolder().get(), 0.33333334F)), TreePlacements.REDBUD_TREES.getHolder().get())));

    }

    public static class Placements {
        public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Horizons.MODID);

        public static final RegistryObject<PlacedFeature> ALGAE = createPlantPatch("algae", 3, Features.ALGAE);
        public static final RegistryObject<PlacedFeature> GIANT_FERN = createPlantPatch("giant_fern", 4, Features.GIANT_FERN);

        public static final RegistryObject<PlacedFeature> BLUE_LILY = createPlantPatch("blue_lily", 82, Features.BLUE_LILY);
        public static final RegistryObject<PlacedFeature> LIGHT_GRAY_LILY = createPlantPatch("light_gray_lily", 82, Features.LIGHT_GRAY_LILY);
        public static final RegistryObject<PlacedFeature> CYAN_LILY = createPlantPatch("cyan_lily", 82, Features.CYAN_LILY);
        public static final RegistryObject<PlacedFeature> LIGHT_BLUE_LILY = createPlantPatch("light_blue_lily", 82, Features.LIGHT_BLUE_LILY);
        public static final RegistryObject<PlacedFeature> MAGENTA_LILY = createPlantPatch("magenta_lily", 82, Features.MAGENTA_LILY);
        public static final RegistryObject<PlacedFeature> PINK_LILY = createPlantPatch("pink_lily", 82, Features.PINK_LILY);
        public static final RegistryObject<PlacedFeature> PURPLE_LILY = createPlantPatch("purple_lily", 82, Features.PURPLE_LILY);
        public static final RegistryObject<PlacedFeature> WHITE_LILY = createPlantPatch("white_lily", 82, Features.WHITE_LILY);

        public static final RegistryObject<PlacedFeature> REDBUD_TREES = register("redbud_trees", Features.REDBUD_TREES, TreePlacements.treePlacement(PlacementUtils.countExtra(9, .1f, 1)));
        public static final RegistryObject<PlacedFeature> TALL_BIRCH = register("tall_birch", VegetationFeatures.BIRCH_TALL, TreePlacements.treePlacement(PlacementUtils.countExtra(1, .1f, 1)));

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

    public static class TreeFeatures {
        public static final RegistryObject<ConfiguredFeature<?, ?>> REDBUD_TREES = Features.CONFIGURED_FEATURES.register("redbud_trees_checked", () -> new ConfiguredFeature<>(Feature.TREE, Configs.REDBUD_TREE));
        public static final RegistryObject<ConfiguredFeature<?, ?>> FLOWERING_REDBUD_TREES = Features.CONFIGURED_FEATURES.register("flowering_redbud_trees_checked", () -> new ConfiguredFeature<>(Feature.TREE, Configs.FLOWERING_REDBUD_TREE));

    }

    public static class TreePlacements {
        public static final RegistryObject<PlacedFeature> REDBUD_TREES = Placements.register("redbud_trees_checked", TreeFeatures.REDBUD_TREES, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
        public static final RegistryObject<PlacedFeature> FLOWERING_REDBUD_TREES = Placements.register("flowering_redbud_trees_checked", TreeFeatures.FLOWERING_REDBUD_TREES, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));

        public static List<PlacementModifier> treePlacement(PlacementModifier modifier) {
            return ImmutableList.<PlacementModifier>builder().add(modifier).add(InSquarePlacement.spread())
                    .add(VegetationPlacements.TREE_THRESHOLD).add(PlacementUtils.HEIGHTMAP_OCEAN_FLOOR)
                    .add(BiomeFilter.biome()).build();
        }
    }

}
