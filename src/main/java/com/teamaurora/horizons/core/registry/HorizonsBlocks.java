package com.teamaurora.horizons.core.registry;

import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.common.block.*;
import com.teamabnormals.blueprint.common.block.chest.BlueprintChestBlock;
import com.teamabnormals.blueprint.common.block.chest.BlueprintTrappedChestBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintStandingSignBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintWallSignBlock;
import com.teamabnormals.blueprint.common.block.thatch.ThatchBlock;
import com.teamabnormals.blueprint.common.block.thatch.ThatchSlabBlock;
import com.teamabnormals.blueprint.common.block.thatch.ThatchStairBlock;
import com.teamabnormals.blueprint.common.block.thatch.ThatchVerticalSlabBlock;
import com.teamabnormals.blueprint.common.block.wood.*;
import com.teamabnormals.blueprint.core.util.PropertyUtil;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import com.teamaurora.horizons.common.block.*;
import com.teamaurora.horizons.common.block.beard_moss.BeardMossBlock;
import com.teamaurora.horizons.common.block.beard_moss.BeardMossBlockBlock;
import com.teamaurora.horizons.common.block.cypress.CypressBranchBlock;
import com.teamaurora.horizons.common.block.cypress.CypressKneeBlock;
import com.teamaurora.horizons.common.block.cypress.DoubleCypressKneeBlock;
import com.teamaurora.horizons.common.block.cypress.HangingCypressLeavesBlock;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.other.HorizonsConstants;
import com.teamaurora.horizons.core.other.HorizonsProperties;
import com.teamaurora.horizons.integration.farmersdelight.HorizonsFDCompat;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author rose_
 */
@Mod.EventBusSubscriber(modid = Horizons.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HorizonsBlocks {
    public static final BlockSubRegistryHelper HELPER = Horizons.REGISTRY_HELPER.getBlockSubHelper();

    // Cypress //

    public static final RegistryObject<Block> STRIPPED_CYPRESS_LOG = HELPER.createBlock("stripped_cypress_log", () -> new StrippedLogBlock(HorizonsProperties.CYPRESS.log()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_CYPRESS_WOOD = HELPER.createBlock("stripped_cypress_wood", () -> new StrippedWoodBlock(HorizonsProperties.CYPRESS.log()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_LOG = HELPER.createBlock("cypress_log", () -> new LogBlock(STRIPPED_CYPRESS_LOG, HorizonsProperties.CYPRESS.log()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_WOOD = HELPER.createBlock("cypress_wood", () -> new WoodBlock(STRIPPED_CYPRESS_WOOD, HorizonsProperties.CYPRESS.log()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_PLANKS = HELPER.createBlock("cypress_planks", () -> new PlanksBlock(HorizonsProperties.CYPRESS.planks()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_SLAB = HELPER.createBlock("cypress_slab", () -> new WoodSlabBlock(HorizonsProperties.CYPRESS.planks()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_STAIRS = HELPER.createBlock("cypress_stairs", () -> new WoodStairBlock(CYPRESS_PLANKS.get().defaultBlockState(), HorizonsProperties.CYPRESS.planks()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_FENCE = HELPER.createFuelBlock("cypress_fence", () -> new WoodFenceBlock(HorizonsProperties.CYPRESS.planks()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> CYPRESS_FENCE_GATE = HELPER.createFuelBlock("cypress_fence_gate", () -> new WoodFenceGateBlock(HorizonsProperties.CYPRESS.planks()), 300, CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> CYPRESS_PRESSURE_PLATE = HELPER.createBlock("cypress_pressure_plate", () -> new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, HorizonsProperties.CYPRESS.pressurePlate()), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> CYPRESS_DOOR = HELPER.createBlock("cypress_door", () -> new WoodDoorBlock(HorizonsProperties.CYPRESS.door()), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> CYPRESS_TRAPDOOR = HELPER.createBlock("cypress_trapdoor", () -> new WoodTrapDoorBlock(HorizonsProperties.CYPRESS.trapdoor()), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> CYPRESS_BUTTON = HELPER.createBlock("cypress_button", () -> new BlueprintWoodButtonBlock(HorizonsProperties.CYPRESS.button()), CreativeModeTab.TAB_REDSTONE);
    public static final Pair<RegistryObject<BlueprintStandingSignBlock>, RegistryObject<BlueprintWallSignBlock>> CYPRESS_SIGNS = HELPER.createSignBlock("cypress", MaterialColor.COLOR_PURPLE);
    public static final RegistryObject<Block> CYPRESS_SAPLING = HELPER.createBlock("cypress_sapling", () -> new BlueprintSaplingBlock(new OakTreeGrower(), PropertyUtil.sapling()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> POTTED_CYPRESS_SAPLING = HELPER.createBlockNoItem("potted_cypress_sapling", () -> new FlowerPotBlock(CYPRESS_SAPLING.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> CYPRESS_LEAVES = HELPER.createBlock("cypress_leaves", () -> new BlueprintLeavesBlock(HorizonsProperties.CYPRESS.leaves()), CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> VERTICAL_CYPRESS_PLANKS = HELPER.createCompatBlock(HorizonsConstants.QUARK, "vertical_cypress_planks", () -> new Block(HorizonsProperties.CYPRESS.planks()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_BEEHIVE = HELPER.createCompatBlock(HorizonsConstants.WOODWORKS, "cypress_beehive", () -> new BlueprintBeehiveBlock(HorizonsProperties.CYPRESS.beehive()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> CYPRESS_LADDER = HELPER.createFuelBlock("cypress_ladder", () -> new BlueprintLadderBlock(HorizonsProperties.CYPRESS.ladder()), 300, ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.QUARK) || ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.WOODWORKS) ? CreativeModeTab.TAB_DECORATIONS : null);
    public static final RegistryObject<Block> CYPRESS_BOOKSHELF = HELPER.createFuelBlock("cypress_bookshelf", () -> new BookshelfBlock(HorizonsProperties.CYPRESS.bookshelf()), 300, ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.QUARK) || ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.WOODWORKS) ? CreativeModeTab.TAB_BUILDING_BLOCKS : null);
    public static final RegistryObject<Block> CYPRESS_BOARDS = HELPER.createCompatBlock(HorizonsConstants.WOODWORKS, "cypress_boards", () -> new RotatedPillarBlock(HorizonsProperties.CYPRESS.planks()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CYPRESS_VERTICAL_SLAB = HELPER.createCompatFuelBlock(HorizonsConstants.QUARK, "cypress_vertical_slab", () -> new VerticalSlabBlock(HorizonsProperties.CYPRESS.planks()), 150, CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_CYPRESS_POST = HELPER.createCompatFuelBlock(HorizonsConstants.QUARK, "stripped_cypress_post", () -> new WoodPostBlock(HorizonsProperties.CYPRESS.post()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> CYPRESS_POST = HELPER.createCompatFuelBlock(HorizonsConstants.QUARK, "cypress_post", () -> new WoodPostBlock(STRIPPED_CYPRESS_POST, HorizonsProperties.CYPRESS.post()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<BlueprintChestBlock> CYPRESS_CHEST = HELPER.createChestBlock("cypress", HorizonsProperties.CYPRESS.chest(), ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.QUARK) || ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.WOODWORKS) ? CreativeModeTab.TAB_DECORATIONS : null);
    public static final RegistryObject<BlueprintTrappedChestBlock> CYPRESS_TRAPPED_CHEST = HELPER.createTrappedChestBlock("cypress", HorizonsProperties.CYPRESS.chest(), ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.QUARK) || ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.WOODWORKS) ? CreativeModeTab.TAB_REDSTONE : null);
    public static final RegistryObject<Block> CYPRESS_CABINET = HELPER.createCompatFuelBlock(HorizonsConstants.FARMERSDELIGHT, "cypress_cabinet", ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.FARMERSDELIGHT) ? HorizonsFDCompat.CABINET_SUPPLIER : () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> CYPRESS_HEDGE = HELPER.createCompatFuelBlock(HorizonsConstants.QUARK, "cypress_hedge", () -> new HedgeBlock(HorizonsProperties.CYPRESS.planks()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> CYPRESS_LEAF_CARPET = HELPER.createCompatBlock(HorizonsConstants.QUARK, "cypress_leaf_carpet", () -> new LeafCarpetBlock(HorizonsProperties.CYPRESS.leafCarpet()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> CYPRESS_LEAF_PILE = HELPER.createCompatBlock(HorizonsConstants.WOODWORKS, "cypress_leaf_pile", () -> new LeafPileBlock(HorizonsProperties.CYPRESS.leafPile()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> HANGING_CYPRESS_LEAVES = HELPER.createInjectedBlock("hanging_cypress_leaves", Items.HANGING_ROOTS, () -> new HangingCypressLeavesBlock(HorizonsProperties.CYPRESS.leaves()), CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> CYPRESS_KNEE = HELPER.createBlock("cypress_knee", () -> new CypressKneeBlock(HorizonsProperties.CYPRESS_KNEE), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> LARGE_CYPRESS_KNEE = HELPER.createBlock("large_cypress_knee", () -> new DoubleCypressKneeBlock(HorizonsProperties.CYPRESS_KNEE), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> STRIPPED_CYPRESS_KNEE = HELPER.createBlock("stripped_cypress_knee", () -> new CypressKneeBlock(HorizonsProperties.CYPRESS_KNEE), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> STRIPPED_LARGE_CYPRESS_KNEE = HELPER.createBlock("stripped_large_cypress_knee", () -> new DoubleCypressKneeBlock(HorizonsProperties.CYPRESS_KNEE), CreativeModeTab.TAB_DECORATIONS);

    // Beard Moss //

    public static final RegistryObject<Block> BEARD_MOSS_BLOCK = HELPER.createInjectedBlock("beard_moss_block", Items.HANGING_ROOTS, () -> new BeardMossBlockBlock(HorizonsProperties.BEARD_MOSS_BLOCK), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BEARD_MOSS = HELPER.createInjectedBlock("beard_moss", Items.HANGING_ROOTS, () -> new BeardMossBlock(HorizonsProperties.BEARD_MOSS), CreativeModeTab.TAB_DECORATIONS);

    // Gooseberry //

    public static final RegistryObject<Block> CYPRESS_BRANCH = HELPER.createInjectedBlock("cypress_branch", Items.HANGING_ROOTS, () -> new CypressBranchBlock(HorizonsProperties.CYPRESS_BRANCH), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> GOOSEBERRY_SACK = HELPER.createCompatFuelBlock(HorizonsConstants.QUARK, "gooseberry_sack", () -> new Block(HorizonsProperties.GOOSEBERRY_SACK), 300, CreativeModeTab.TAB_DECORATIONS);

    // Algae //

    public static final RegistryObject<Block> ALGAE = HELPER.createBlockNoItem("algae", () -> new AlgaeBlock(HorizonsProperties.ALGAE));
    public static final RegistryObject<Block> ALGAE_THATCH = HELPER.createBlock("algae_thatch", () -> new ThatchBlock(HorizonsProperties.ALGAE_THATCH), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ALGAE_THATCH_SLAB = HELPER.createBlock("algae_thatch_slab", () -> new ThatchSlabBlock(HorizonsProperties.ALGAE_THATCH),CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ALGAE_THATCH_STAIRS = HELPER.createBlock("algae_thatch_stairs" ,() -> new ThatchStairBlock(ALGAE_THATCH.get().defaultBlockState(), HorizonsProperties.ALGAE_THATCH), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ALGAE_THATCH_VERTICAL_SLAB = HELPER.createCompatBlock(HorizonsConstants.QUARK, "algae_thatch_vertical_slab", () -> new ThatchVerticalSlabBlock(HorizonsProperties.ALGAE_THATCH), CreativeModeTab.TAB_BUILDING_BLOCKS);

    // Lily Flowers //

    public static final RegistryObject<Block> BLUE_LILY = HELPER.createBlockNoItem("blue_lily", () -> new LilyFlowerBlock(HorizonsProperties.LILY));
    public static final RegistryObject<Block> LIGHT_GRAY_LILY = HELPER.createBlockNoItem("light_gray_lily", () -> new LilyFlowerBlock(HorizonsProperties.LILY));
    public static final RegistryObject<Block> CYAN_LILY = HELPER.createBlockNoItem("cyan_lily", () -> new LilyFlowerBlock(HorizonsProperties.LILY));
    public static final RegistryObject<Block> LIGHT_BLUE_LILY = HELPER.createBlockNoItem("light_blue_lily", () -> new LilyFlowerBlock(HorizonsProperties.LILY));
    public static final RegistryObject<Block> MAGENTA_LILY = HELPER.createBlockNoItem("magenta_lily", () -> new LilyFlowerBlock(HorizonsProperties.LILY));
    public static final RegistryObject<Block> PINK_LILY = HELPER.createBlockNoItem("pink_lily", () -> new LilyFlowerBlock(HorizonsProperties.LILY));
    public static final RegistryObject<Block> PURPLE_LILY = HELPER.createBlockNoItem("purple_lily", () -> new LilyFlowerBlock(HorizonsProperties.LILY));
    public static final RegistryObject<Block> WHITE_LILY = HELPER.createBlockNoItem("white_lily", () -> new LilyFlowerBlock(HorizonsProperties.LILY));

    public static final RegistryObject<Block> POTTED_BLUE_LILY = HELPER.createBlockNoItem("potted_blue_lily", () -> new FlowerPotBlock(BLUE_LILY.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_LIGHT_GRAY_LILY= HELPER.createBlockNoItem("potted_light_gray_lily", () -> new FlowerPotBlock(LIGHT_GRAY_LILY.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_CYAN_LILY = HELPER.createBlockNoItem("potted_cyan_lily", () -> new FlowerPotBlock(CYAN_LILY.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_LIGHT_BLUE_LILY = HELPER.createBlockNoItem("potted_light_blue_lily", () -> new FlowerPotBlock(LIGHT_BLUE_LILY.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_MAGENTA_LILY = HELPER.createBlockNoItem("potted_magenta_lily", () -> new FlowerPotBlock(MAGENTA_LILY.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_PINK_LILY = HELPER.createBlockNoItem("potted_pink_lily", () -> new FlowerPotBlock(PINK_LILY.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_PURPLE_LILY = HELPER.createBlockNoItem("potted_purple_lily", () -> new FlowerPotBlock(PURPLE_LILY.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_WHITE_LILY = HELPER.createBlockNoItem("potted_white_lily", () -> new FlowerPotBlock(WHITE_LILY.get(), PropertyUtil.flowerPot()));

    // Fern //

    public static final RegistryObject<Block> GIANT_FERN = HELPER.createInjectedBlock("giant_fern", Items.LARGE_FERN, () -> new DoublePlantBlock(HorizonsProperties.GIANT_FERN), CreativeModeTab.TAB_DECORATIONS);

    // Redwood //

    public static final RegistryObject<Block> STRIPPED_REDWOOD_LOG = HELPER.createBlock("stripped_redwood_log", () -> new StrippedLogBlock(HorizonsProperties.REDWOOD.log()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_REDWOOD_WOOD = HELPER.createBlock("stripped_redwood_wood", () -> new StrippedWoodBlock(HorizonsProperties.REDWOOD.log()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDWOOD_LOG = HELPER.createBlock("redwood_log", () -> new LogBlock(STRIPPED_REDWOOD_LOG, HorizonsProperties.REDWOOD.log()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDWOOD_WOOD = HELPER.createBlock("redwood_wood", () -> new WoodBlock(STRIPPED_REDWOOD_WOOD, HorizonsProperties.REDWOOD.log()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDWOOD_PLANKS = HELPER.createBlock("redwood_planks", () -> new PlanksBlock(HorizonsProperties.REDWOOD.planks()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDWOOD_SLAB = HELPER.createBlock("redwood_slab", () -> new WoodSlabBlock(HorizonsProperties.REDWOOD.planks()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDWOOD_STAIRS = HELPER.createBlock("redwood_stairs", () -> new WoodStairBlock(REDWOOD_PLANKS.get().defaultBlockState(), HorizonsProperties.REDWOOD.planks()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDWOOD_FENCE = HELPER.createFuelBlock("redwood_fence", () -> new WoodFenceBlock(HorizonsProperties.REDWOOD.planks()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> REDWOOD_FENCE_GATE = HELPER.createFuelBlock("redwood_fence_gate", () -> new WoodFenceGateBlock(HorizonsProperties.REDWOOD.planks()), 300, CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> REDWOOD_PRESSURE_PLATE = HELPER.createBlock("redwood_pressure_plate", () -> new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, HorizonsProperties.REDWOOD.pressurePlate()), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> REDWOOD_DOOR = HELPER.createBlock("redwood_door", () -> new WoodDoorBlock(HorizonsProperties.REDWOOD.door()), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> REDWOOD_TRAPDOOR = HELPER.createBlock("redwood_trapdoor", () -> new WoodTrapDoorBlock(HorizonsProperties.REDWOOD.trapdoor()), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> REDWOOD_BUTTON = HELPER.createBlock("redwood_button", () -> new BlueprintWoodButtonBlock(HorizonsProperties.REDWOOD.button()), CreativeModeTab.TAB_REDSTONE);
    public static final Pair<RegistryObject<BlueprintStandingSignBlock>, RegistryObject<BlueprintWallSignBlock>> REDWOOD_SIGNS = HELPER.createSignBlock("redwood", MaterialColor.COLOR_PURPLE);
    public static final RegistryObject<Block> REDWOOD_SAPLING = HELPER.createBlock("redwood_sapling", () -> new BlueprintSaplingBlock(new OakTreeGrower(), PropertyUtil.sapling()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> POTTED_REDWOOD_SAPLING = HELPER.createBlockNoItem("potted_redwood_sapling", () -> new FlowerPotBlock(REDWOOD_SAPLING.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> REDWOOD_LEAVES = HELPER.createBlock("redwood_leaves", () -> new BlueprintLeavesBlock(HorizonsProperties.REDWOOD.leaves()), CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> VERTICAL_REDWOOD_PLANKS = HELPER.createCompatBlock(HorizonsConstants.QUARK, "vertical_redwood_planks", () -> new Block(HorizonsProperties.REDWOOD.planks()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDWOOD_BEEHIVE = HELPER.createCompatBlock(HorizonsConstants.WOODWORKS, "redwood_beehive", () -> new BlueprintBeehiveBlock(HorizonsProperties.REDWOOD.beehive()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> REDWOOD_LADDER = HELPER.createFuelBlock("redwood_ladder", () -> new BlueprintLadderBlock(HorizonsProperties.REDWOOD.ladder()), 300, ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.QUARK) || ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.WOODWORKS) ? CreativeModeTab.TAB_DECORATIONS : null);
    public static final RegistryObject<Block> REDWOOD_BOOKSHELF = HELPER.createFuelBlock("redwood_bookshelf", () -> new BookshelfBlock(HorizonsProperties.REDWOOD.bookshelf()), 300, ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.QUARK) || ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.WOODWORKS) ? CreativeModeTab.TAB_BUILDING_BLOCKS : null);
    public static final RegistryObject<Block> REDWOOD_BOARDS = HELPER.createCompatBlock(HorizonsConstants.WOODWORKS, "redwood_boards", () -> new RotatedPillarBlock(HorizonsProperties.REDWOOD.planks()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDWOOD_VERTICAL_SLAB = HELPER.createCompatFuelBlock(HorizonsConstants.QUARK, "redwood_vertical_slab", () -> new VerticalSlabBlock(HorizonsProperties.REDWOOD.planks()), 150, CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_REDWOOD_POST = HELPER.createCompatFuelBlock(HorizonsConstants.QUARK, "stripped_redwood_post", () -> new WoodPostBlock(HorizonsProperties.REDWOOD.post()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> REDWOOD_POST = HELPER.createCompatFuelBlock(HorizonsConstants.QUARK, "redwood_post", () -> new WoodPostBlock(STRIPPED_REDWOOD_POST, HorizonsProperties.REDWOOD.post()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<BlueprintChestBlock> REDWOOD_CHEST = HELPER.createChestBlock("redwood", HorizonsProperties.REDWOOD.chest(), ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.QUARK) || ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.WOODWORKS) ? CreativeModeTab.TAB_DECORATIONS : null);
    public static final RegistryObject<BlueprintTrappedChestBlock> REDWOOD_TRAPPED_CHEST = HELPER.createTrappedChestBlock("redwood", HorizonsProperties.REDWOOD.chest(), ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.QUARK) || ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.WOODWORKS) ? CreativeModeTab.TAB_REDSTONE : null);
    public static final RegistryObject<Block> REDWOOD_CABINET = HELPER.createCompatFuelBlock(HorizonsConstants.FARMERSDELIGHT, "redwood_cabinet", ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.FARMERSDELIGHT) ? HorizonsFDCompat.CABINET_SUPPLIER : () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> REDWOOD_HEDGE = HELPER.createCompatFuelBlock(HorizonsConstants.QUARK, "redwood_hedge", () -> new HedgeBlock(HorizonsProperties.REDWOOD.planks()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> REDWOOD_LEAF_CARPET = HELPER.createCompatBlock(HorizonsConstants.QUARK, "redwood_leaf_carpet", () -> new LeafCarpetBlock(HorizonsProperties.REDWOOD.leafCarpet()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> REDWOOD_LEAF_PILE = HELPER.createCompatBlock(HorizonsConstants.WOODWORKS, "redwood_leaf_pile", () -> new LeafPileBlock(HorizonsProperties.REDWOOD.leafPile()), CreativeModeTab.TAB_DECORATIONS);

    // Boulders //

    public static final RegistryObject<Block> LIGHT_BOULDER = HELPER.createInjectedBlock("light_boulder", Items.COBBLESTONE, () -> new Block(HorizonsProperties.BOULDER), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> LIGHT_BOULDER_SLAB = HELPER.createBlock("light_boulder_slab", () -> new SlabBlock(HorizonsProperties.BOULDER), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> LIGHT_BOULDER_STAIRS = HELPER.createBlock("light_boulder_stairs", () -> new StairBlock(LIGHT_BOULDER.get()::defaultBlockState, HorizonsProperties.BOULDER), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> LIGHT_BOULDER_VERTICAL_SLAB = HELPER.createBlock("light_boulder_vertical_slab", () -> new VerticalSlabBlock(HorizonsProperties.BOULDER), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> LIGHT_BOULDER_WALL = HELPER.createBlock("light_boulder_wall", () -> new WallBlock(HorizonsProperties.BOULDER), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> MOSSY_LIGHT_BOULDER = HELPER.createBlock("mossy_light_boulder", () -> new Block(HorizonsProperties.BOULDER), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> MOSSY_LIGHT_BOULDER_SLAB = HELPER.createBlock("mossy_light_boulder_slab", () -> new SlabBlock(HorizonsProperties.BOULDER), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> MOSSY_LIGHT_BOULDER_STAIRS = HELPER.createBlock("mossy_light_boulder_stairs", () -> new StairBlock(MOSSY_LIGHT_BOULDER.get()::defaultBlockState, HorizonsProperties.BOULDER), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> MOSSY_LIGHT_BOULDER_VERTICAL_SLAB = HELPER.createBlock("mossy_light_boulder_vertical_slab", () -> new VerticalSlabBlock(HorizonsProperties.BOULDER), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> MOSSY_LIGHT_BOULDER_WALL = HELPER.createBlock("mossy_light_boulder_wall", () -> new WallBlock(HorizonsProperties.BOULDER), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> DARK_BOULDER = HELPER.createInjectedBlock("dark_boulder", Items.COBBLESTONE, () -> new Block(HorizonsProperties.BOULDER), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DARK_BOULDER_SLAB = HELPER.createBlock("dark_boulder_slab", () -> new SlabBlock(HorizonsProperties.BOULDER), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DARK_BOULDER_STAIRS = HELPER.createBlock("dark_boulder_stairs", () -> new StairBlock(DARK_BOULDER.get()::defaultBlockState, HorizonsProperties.BOULDER), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DARK_BOULDER_VERTICAL_SLAB = HELPER.createBlock("dark_boulder_vertical_slab", () -> new VerticalSlabBlock(HorizonsProperties.BOULDER), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DARK_BOULDER_WALL = HELPER.createBlock("dark_boulder_wall", () -> new WallBlock(HorizonsProperties.BOULDER), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> MOSSY_DARK_BOULDER = HELPER.createBlock("mossy_dark_boulder", () -> new Block(HorizonsProperties.BOULDER), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> MOSSY_DARK_BOULDER_SLAB = HELPER.createBlock("mossy_dark_boulder_slab", () -> new SlabBlock(HorizonsProperties.BOULDER), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> MOSSY_DARK_BOULDER_STAIRS = HELPER.createBlock("mossy_dark_boulder_stairs", () -> new StairBlock(MOSSY_DARK_BOULDER.get()::defaultBlockState, HorizonsProperties.BOULDER), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> MOSSY_DARK_BOULDER_VERTICAL_SLAB = HELPER.createBlock("mossy_dark_boulder_vertical_slab", () -> new VerticalSlabBlock(HorizonsProperties.BOULDER), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> MOSSY_DARK_BOULDER_WALL = HELPER.createBlock("mossy_dark_boulder_wall", () -> new WallBlock(HorizonsProperties.BOULDER), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BOULDER_BRICKS = HELPER.createBlock("boulder_bricks", () -> new Block(HorizonsProperties.BOULDER_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BOULDER_BRICK_SLAB = HELPER.createBlock("boulder_brick_slab", () -> new SlabBlock(HorizonsProperties.BOULDER_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BOULDER_BRICK_STAIRS = HELPER.createBlock("boulder_brick_stairs", () -> new StairBlock(BOULDER_BRICKS.get()::defaultBlockState, HorizonsProperties.BOULDER_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BOULDER_BRICK_VERTICAL_SLAB = HELPER.createBlock("boulder_brick_vertical_slab", () -> new VerticalSlabBlock(HorizonsProperties.BOULDER_BRICKS), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BOULDER_BRICK_WALL = HELPER.createBlock("boulder_brick_wall", () -> new WallBlock(HorizonsProperties.BOULDER_BRICKS), CreativeModeTab.TAB_DECORATIONS);

    // Daisy Flowers //

    public static final RegistryObject<Block> YELLOW_DAISY = HELPER.createBlock("yellow_daisy", () -> new BlueprintFlowerBlock(() -> MobEffects.BLINDNESS, 12, PropertyUtil.flower()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> RED_DAISY = HELPER.createBlock("red_daisy", () -> new BlueprintFlowerBlock(() -> MobEffects.BLINDNESS, 12, PropertyUtil.flower()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> PURPLE_DAISY = HELPER.createBlock("purple_daisy", () -> new BlueprintFlowerBlock(() -> MobEffects.BLINDNESS, 12, PropertyUtil.flower()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> PINK_DAISY = HELPER.createBlock("pink_daisy", () -> new BlueprintFlowerBlock(() -> MobEffects.BLINDNESS, 12, PropertyUtil.flower()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> ORANGE_DAISY = HELPER.createBlock("orange_daisy", () -> new BlueprintFlowerBlock(() -> MobEffects.BLINDNESS, 12, PropertyUtil.flower()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> MAGENTA_DAISY = HELPER.createBlock("magenta_daisy", () -> new BlueprintFlowerBlock(() -> MobEffects.BLINDNESS, 12, PropertyUtil.flower()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BLUE_DAISY = HELPER.createBlock("blue_daisy", () -> new BlueprintFlowerBlock(() -> MobEffects.BLINDNESS, 12, PropertyUtil.flower()), CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> POTTED_YELLOW_DAISY = HELPER.createBlockNoItem("potted_yellow_daisy", () -> new FlowerPotBlock(YELLOW_DAISY.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_RED_DAISY = HELPER.createBlockNoItem("potted_red_daisy", () -> new FlowerPotBlock(RED_DAISY.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_PURPLE_DAISY = HELPER.createBlockNoItem("potted_purple_daisy", () -> new FlowerPotBlock(PURPLE_DAISY.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_PINK_DAISY = HELPER.createBlockNoItem("potted_pink_daisy", () -> new FlowerPotBlock(PINK_DAISY.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_ORANGE_DAISY = HELPER.createBlockNoItem("potted_orange_daisy", () -> new FlowerPotBlock(ORANGE_DAISY.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_MAGENTA_DAISY = HELPER.createBlockNoItem("potted_magenta_daisy", () -> new FlowerPotBlock(MAGENTA_DAISY.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> POTTED_BLUE_DAISY = HELPER.createBlockNoItem("potted_blue_daisy", () -> new FlowerPotBlock(BLUE_DAISY.get(), PropertyUtil.flowerPot()));

    // Redbud //

    public static final RegistryObject<Block> STRIPPED_REDBUD_LOG = HELPER.createBlock("stripped_redbud_log", () -> new StrippedLogBlock(HorizonsProperties.REDBUD.log()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_REDBUD_WOOD = HELPER.createBlock("stripped_redbud_wood", () -> new StrippedWoodBlock(HorizonsProperties.REDBUD.log()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_LOG = HELPER.createBlock("redbud_log", () -> new LogBlock(STRIPPED_REDBUD_LOG, HorizonsProperties.REDBUD.log()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_WOOD = HELPER.createBlock("redbud_wood", () -> new WoodBlock(STRIPPED_REDBUD_WOOD, HorizonsProperties.REDBUD.log()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> FLOWERING_REDBUD_LOG = HELPER.createBlock("flowering_redbud_log", () -> new LogBlock(STRIPPED_REDBUD_LOG, HorizonsProperties.REDBUD.log()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> FLOWERING_REDBUD_WOOD = HELPER.createBlock("flowering_redbud_wood", () -> new WoodBlock(STRIPPED_REDBUD_WOOD, HorizonsProperties.REDBUD.log()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_PLANKS = HELPER.createBlock("redbud_planks", () -> new PlanksBlock(HorizonsProperties.REDBUD.planks()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_SLAB = HELPER.createBlock("redbud_slab", () -> new WoodSlabBlock(HorizonsProperties.REDBUD.planks()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_STAIRS = HELPER.createBlock("redbud_stairs", () -> new WoodStairBlock(REDBUD_PLANKS.get().defaultBlockState(), HorizonsProperties.REDBUD.planks()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_FENCE = HELPER.createFuelBlock("redbud_fence", () -> new WoodFenceBlock(HorizonsProperties.REDBUD.planks()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> REDBUD_FENCE_GATE = HELPER.createFuelBlock("redbud_fence_gate", () -> new WoodFenceGateBlock(HorizonsProperties.REDBUD.planks()), 300, CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> REDBUD_PRESSURE_PLATE = HELPER.createBlock("redbud_pressure_plate", () -> new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, HorizonsProperties.REDBUD.pressurePlate()), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> REDBUD_DOOR = HELPER.createBlock("redbud_door", () -> new WoodDoorBlock(HorizonsProperties.REDBUD.door()), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> REDBUD_TRAPDOOR = HELPER.createBlock("redbud_trapdoor", () -> new WoodTrapDoorBlock(HorizonsProperties.REDBUD.trapdoor()), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> REDBUD_BUTTON = HELPER.createBlock("redbud_button", () -> new BlueprintWoodButtonBlock(HorizonsProperties.REDBUD.button()), CreativeModeTab.TAB_REDSTONE);
    public static final Pair<RegistryObject<BlueprintStandingSignBlock>, RegistryObject<BlueprintWallSignBlock>> REDBUD_SIGNS = HELPER.createSignBlock("redbud", MaterialColor.COLOR_PURPLE);
    public static final RegistryObject<Block> REDBUD_SAPLING = HELPER.createBlock("redbud_sapling", () -> new BlueprintSaplingBlock(new OakTreeGrower(), PropertyUtil.sapling()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> POTTED_REDBUD_SAPLING = HELPER.createBlockNoItem("potted_redbud_sapling", () -> new FlowerPotBlock(REDBUD_SAPLING.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> BUDDING_REDBUD_SAPLING = HELPER.createBlock("budding_redbud_sapling", () -> new BlueprintSaplingBlock(new OakTreeGrower(), PropertyUtil.sapling()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> POTTED_BUDDING_REDBUD_SAPLING = HELPER.createBlockNoItem("potted_budding_redbud_sapling", () -> new FlowerPotBlock(BUDDING_REDBUD_SAPLING.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> FLOWERING_REDBUD_SAPLING = HELPER.createBlock("flowering_redbud_sapling", () -> new BlueprintSaplingBlock(new OakTreeGrower(), PropertyUtil.sapling()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> POTTED_FLOWERING_REDBUD_SAPLING = HELPER.createBlockNoItem("potted_flowering_redbud_sapling", () -> new FlowerPotBlock(FLOWERING_REDBUD_SAPLING.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> REDBUD_LEAVES = HELPER.createBlock("redbud_leaves", () -> new BlueprintLeavesBlock(HorizonsProperties.REDBUD.leaves()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BUDDING_REDBUD_LEAVES = HELPER.createBlock("budding_redbud_leaves", () -> new BlueprintLeavesBlock(HorizonsProperties.REDBUD.leaves()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> FLOWERING_REDBUD_LEAVES = HELPER.createBlock("flowering_redbud_leaves", () -> new BlueprintLeavesBlock(HorizonsProperties.REDBUD.leaves()), CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> VERTICAL_REDBUD_PLANKS = HELPER.createCompatBlock(HorizonsConstants.QUARK, "vertical_redbud_planks", () -> new Block(HorizonsProperties.REDBUD.planks()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_BEEHIVE = HELPER.createCompatBlock(HorizonsConstants.WOODWORKS, "redbud_beehive", () -> new BlueprintBeehiveBlock(HorizonsProperties.REDBUD.beehive()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> REDBUD_LADDER = HELPER.createFuelBlock("redbud_ladder", () -> new BlueprintLadderBlock(HorizonsProperties.REDBUD.ladder()), 300, ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.QUARK) || ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.WOODWORKS) ? CreativeModeTab.TAB_DECORATIONS : null);
    public static final RegistryObject<Block> REDBUD_BOOKSHELF = HELPER.createFuelBlock("redbud_bookshelf", () -> new BookshelfBlock(HorizonsProperties.REDBUD.bookshelf()), 300, ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.QUARK) || ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.WOODWORKS) ? CreativeModeTab.TAB_BUILDING_BLOCKS : null);
    public static final RegistryObject<Block> REDBUD_BOARDS = HELPER.createCompatBlock(HorizonsConstants.WOODWORKS, "redbud_boards", () -> new RotatedPillarBlock(HorizonsProperties.REDBUD.planks()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> REDBUD_VERTICAL_SLAB = HELPER.createCompatFuelBlock(HorizonsConstants.QUARK, "redbud_vertical_slab", () -> new VerticalSlabBlock(HorizonsProperties.REDBUD.planks()), 150, CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_REDBUD_POST = HELPER.createCompatFuelBlock(HorizonsConstants.QUARK, "stripped_redbud_post", () -> new WoodPostBlock(HorizonsProperties.REDBUD.post()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> REDBUD_POST = HELPER.createCompatFuelBlock(HorizonsConstants.QUARK, "redbud_post", () -> new WoodPostBlock(STRIPPED_REDBUD_POST, HorizonsProperties.REDBUD.post()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> FLOWERING_REDBUD_POST = HELPER.createCompatFuelBlock(HorizonsConstants.QUARK, "flowering_redbud_post", () -> new WoodPostBlock(STRIPPED_REDBUD_POST, HorizonsProperties.REDBUD.post()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<BlueprintChestBlock> REDBUD_CHEST = HELPER.createChestBlock("redbud", HorizonsProperties.REDBUD.chest(), ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.QUARK) || ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.WOODWORKS) ? CreativeModeTab.TAB_DECORATIONS : null);
    public static final RegistryObject<BlueprintTrappedChestBlock> REDBUD_TRAPPED_CHEST = HELPER.createTrappedChestBlock("redbud", HorizonsProperties.REDBUD.chest(), ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.QUARK) || ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.WOODWORKS) ? CreativeModeTab.TAB_REDSTONE : null);
    public static final RegistryObject<Block> REDBUD_CABINET = HELPER.createCompatFuelBlock(HorizonsConstants.FARMERSDELIGHT, "redbud_cabinet", ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.FARMERSDELIGHT) ? HorizonsFDCompat.CABINET_SUPPLIER : () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> REDBUD_HEDGE = HELPER.createCompatFuelBlock(HorizonsConstants.QUARK, "redbud_hedge", () -> new HedgeBlock(HorizonsProperties.REDBUD.planks()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> REDBUD_LEAF_CARPET = HELPER.createCompatBlock(HorizonsConstants.QUARK, "redbud_leaf_carpet", () -> new LeafCarpetBlock(HorizonsProperties.REDBUD.leafCarpet()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> REDBUD_LEAF_PILE = HELPER.createCompatBlock(HorizonsConstants.WOODWORKS, "redbud_leaf_pile", () -> new LeafPileBlock(HorizonsProperties.REDBUD.leafPile()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BUDDING_REDBUD_HEDGE = HELPER.createCompatFuelBlock(HorizonsConstants.QUARK, "budding_redbud_hedge", () -> new HedgeBlock(HorizonsProperties.REDBUD.planks()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BUDDING_REDBUD_LEAF_CARPET = HELPER.createCompatBlock(HorizonsConstants.QUARK, "budding_redbud_leaf_carpet", () -> new LeafCarpetBlock(HorizonsProperties.REDBUD.leafCarpet()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BUDDING_REDBUD_LEAF_PILE = HELPER.createCompatBlock(HorizonsConstants.WOODWORKS, "budding_redbud_leaf_pile", () -> new LeafPileBlock(HorizonsProperties.REDBUD.leafPile()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> FLOWERING_REDBUD_HEDGE = HELPER.createCompatFuelBlock(HorizonsConstants.QUARK, "flowering_redbud_hedge", () -> new HedgeBlock(HorizonsProperties.REDBUD.planks()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> FLOWERING_REDBUD_LEAF_CARPET = HELPER.createCompatBlock(HorizonsConstants.QUARK, "flowering_redbud_leaf_carpet", () -> new LeafCarpetBlock(HorizonsProperties.REDBUD.leafCarpet()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> FLOWERING_REDBUD_LEAF_PILE = HELPER.createCompatBlock(HorizonsConstants.WOODWORKS, "flowering_redbud_leaf_pile", () -> new LeafPileBlock(HorizonsProperties.REDBUD.leafPile()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> REDBUD_BLOSSOMS_LEAF_PILE = HELPER.createBlock("redbud_blossoms_leaf_pile", () -> new LeafPileBlock(HorizonsProperties.REDBUD_BLOSSOMS), CreativeModeTab.TAB_DECORATIONS);

    // Jacaranda //

    public static final RegistryObject<Block> STRIPPED_JACARANDA_LOG = HELPER.createBlock("stripped_jacaranda_log", () -> new StrippedLogBlock(HorizonsProperties.JACARANDA.log()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_JACARANDA_WOOD = HELPER.createBlock("stripped_jacaranda_wood", () -> new StrippedWoodBlock(HorizonsProperties.JACARANDA.log()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_LOG = HELPER.createBlock("jacaranda_log", () -> new LogBlock(STRIPPED_JACARANDA_LOG, HorizonsProperties.JACARANDA.log()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_WOOD = HELPER.createBlock("jacaranda_wood", () -> new WoodBlock(STRIPPED_JACARANDA_WOOD, HorizonsProperties.JACARANDA.log()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_PLANKS = HELPER.createBlock("jacaranda_planks", () -> new PlanksBlock(HorizonsProperties.JACARANDA.planks()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_SLAB = HELPER.createBlock("jacaranda_slab", () -> new WoodSlabBlock(HorizonsProperties.JACARANDA.planks()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_STAIRS = HELPER.createBlock("jacaranda_stairs", () -> new WoodStairBlock(JACARANDA_PLANKS.get().defaultBlockState(), HorizonsProperties.JACARANDA.planks()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_FENCE = HELPER.createFuelBlock("jacaranda_fence", () -> new WoodFenceBlock(HorizonsProperties.JACARANDA.planks()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> JACARANDA_FENCE_GATE = HELPER.createFuelBlock("jacaranda_fence_gate", () -> new WoodFenceGateBlock(HorizonsProperties.JACARANDA.planks()), 300, CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> JACARANDA_PRESSURE_PLATE = HELPER.createBlock("jacaranda_pressure_plate", () -> new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, HorizonsProperties.JACARANDA.pressurePlate()), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> JACARANDA_DOOR = HELPER.createBlock("jacaranda_door", () -> new WoodDoorBlock(HorizonsProperties.JACARANDA.door()), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> JACARANDA_TRAPDOOR = HELPER.createBlock("jacaranda_trapdoor", () -> new WoodTrapDoorBlock(HorizonsProperties.JACARANDA.trapdoor()), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> JACARANDA_BUTTON = HELPER.createBlock("jacaranda_button", () -> new BlueprintWoodButtonBlock(HorizonsProperties.JACARANDA.button()), CreativeModeTab.TAB_REDSTONE);
    public static final Pair<RegistryObject<BlueprintStandingSignBlock>, RegistryObject<BlueprintWallSignBlock>> JACARANDA_SIGNS = HELPER.createSignBlock("jacaranda", MaterialColor.COLOR_PURPLE);
    public static final RegistryObject<Block> JACARANDA_SAPLING = HELPER.createBlock("jacaranda_sapling", () -> new BlueprintSaplingBlock(new OakTreeGrower(), PropertyUtil.sapling()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> POTTED_JACARANDA_SAPLING = HELPER.createBlockNoItem("potted_jacaranda_sapling", () -> new FlowerPotBlock(JACARANDA_SAPLING.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> BLUE_JACARANDA_SAPLING = HELPER.createBlock("blue_jacaranda_sapling", () -> new BlueprintSaplingBlock(new OakTreeGrower(), PropertyUtil.sapling()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> POTTED_BLUE_JACARANDA_SAPLING = HELPER.createBlockNoItem("potted_blue_jacaranda_sapling", () -> new FlowerPotBlock(BLUE_JACARANDA_SAPLING.get(), PropertyUtil.flowerPot()));
    public static final RegistryObject<Block> JACARANDA_LEAVES = HELPER.createBlock("jacaranda_leaves", () -> new BlueprintLeavesBlock(HorizonsProperties.JACARANDA.leaves()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BUDDING_JACARANDA_LEAVES = HELPER.createBlock("budding_jacaranda_leaves", () -> new BlueprintLeavesBlock(HorizonsProperties.JACARANDA.leaves()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> FLOWERING_JACARANDA_LEAVES = HELPER.createBlock("flowering_jacaranda_leaves", () -> new BlueprintLeavesBlock(HorizonsProperties.JACARANDA.leaves()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BLUE_JACARANDA_LEAVES = HELPER.createBlock("blue_jacaranda_leaves", () -> new BlueprintLeavesBlock(HorizonsProperties.JACARANDA.leaves()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BUDDING_BLUE_JACARANDA_LEAVES = HELPER.createBlock("budding_blue_jacaranda_leaves", () -> new BlueprintLeavesBlock(HorizonsProperties.JACARANDA.leaves()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> FLOWERING_BLUE_JACARANDA_LEAVES = HELPER.createBlock("flowering_blue_jacaranda_leaves", () -> new BlueprintLeavesBlock(HorizonsProperties.JACARANDA.leaves()), CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> VERTICAL_JACARANDA_PLANKS = HELPER.createCompatBlock(HorizonsConstants.QUARK, "vertical_jacaranda_planks", () -> new Block(HorizonsProperties.JACARANDA.planks()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_BEEHIVE = HELPER.createCompatBlock(HorizonsConstants.WOODWORKS, "jacaranda_beehive", () -> new BlueprintBeehiveBlock(HorizonsProperties.JACARANDA.beehive()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> JACARANDA_LADDER = HELPER.createFuelBlock("jacaranda_ladder", () -> new BlueprintLadderBlock(HorizonsProperties.JACARANDA.ladder()), 300, ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.QUARK) || ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.WOODWORKS) ? CreativeModeTab.TAB_DECORATIONS : null);
    public static final RegistryObject<Block> JACARANDA_BOOKSHELF = HELPER.createFuelBlock("jacaranda_bookshelf", () -> new BookshelfBlock(HorizonsProperties.JACARANDA.bookshelf()), 300, ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.QUARK) || ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.WOODWORKS) ? CreativeModeTab.TAB_BUILDING_BLOCKS : null);
    public static final RegistryObject<Block> JACARANDA_BOARDS = HELPER.createCompatBlock(HorizonsConstants.WOODWORKS, "jacaranda_boards", () -> new RotatedPillarBlock(HorizonsProperties.JACARANDA.planks()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> JACARANDA_VERTICAL_SLAB = HELPER.createCompatFuelBlock(HorizonsConstants.QUARK, "jacaranda_vertical_slab", () -> new VerticalSlabBlock(HorizonsProperties.JACARANDA.planks()), 150, CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_JACARANDA_POST = HELPER.createCompatFuelBlock(HorizonsConstants.QUARK, "stripped_jacaranda_post", () -> new WoodPostBlock(HorizonsProperties.JACARANDA.post()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> JACARANDA_POST = HELPER.createCompatFuelBlock(HorizonsConstants.QUARK, "jacaranda_post", () -> new WoodPostBlock(STRIPPED_JACARANDA_POST, HorizonsProperties.JACARANDA.post()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<BlueprintChestBlock> JACARANDA_CHEST = HELPER.createChestBlock("jacaranda", HorizonsProperties.JACARANDA.chest(), ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.QUARK) || ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.WOODWORKS) ? CreativeModeTab.TAB_DECORATIONS : null);
    public static final RegistryObject<BlueprintTrappedChestBlock> JACARANDA_TRAPPED_CHEST = HELPER.createTrappedChestBlock("jacaranda", HorizonsProperties.JACARANDA.chest(), ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.QUARK) || ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.WOODWORKS) ? CreativeModeTab.TAB_REDSTONE : null);
    public static final RegistryObject<Block> JACARANDA_CABINET = HELPER.createCompatFuelBlock(HorizonsConstants.FARMERSDELIGHT, "jacaranda_cabinet", ItemSubRegistryHelper.areModsLoaded(HorizonsConstants.FARMERSDELIGHT) ? HorizonsFDCompat.CABINET_SUPPLIER : () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> JACARANDA_HEDGE = HELPER.createCompatFuelBlock(HorizonsConstants.QUARK, "jacaranda_hedge", () -> new HedgeBlock(HorizonsProperties.JACARANDA.planks()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> JACARANDA_LEAF_CARPET = HELPER.createCompatBlock(HorizonsConstants.QUARK, "jacaranda_leaf_carpet", () -> new LeafCarpetBlock(HorizonsProperties.JACARANDA.leafCarpet()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> JACARANDA_LEAF_PILE = HELPER.createCompatBlock(HorizonsConstants.WOODWORKS, "jacaranda_leaf_pile", () -> new LeafPileBlock(HorizonsProperties.JACARANDA.leafPile()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BUDDING_JACARANDA_HEDGE = HELPER.createCompatFuelBlock(HorizonsConstants.QUARK, "budding_jacaranda_hedge", () -> new HedgeBlock(HorizonsProperties.JACARANDA.planks()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BUDDING_JACARANDA_LEAF_CARPET = HELPER.createCompatBlock(HorizonsConstants.QUARK, "budding_jacaranda_leaf_carpet", () -> new LeafCarpetBlock(HorizonsProperties.JACARANDA.leafCarpet()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BUDDING_JACARANDA_LEAF_PILE = HELPER.createCompatBlock(HorizonsConstants.WOODWORKS, "budding_jacaranda_leaf_pile", () -> new LeafPileBlock(HorizonsProperties.JACARANDA.leafPile()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> FLOWERING_JACARANDA_HEDGE = HELPER.createCompatFuelBlock(HorizonsConstants.QUARK, "flowering_jacaranda_hedge", () -> new HedgeBlock(HorizonsProperties.JACARANDA.planks()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> FLOWERING_JACARANDA_LEAF_CARPET = HELPER.createCompatBlock(HorizonsConstants.QUARK, "flowering_jacaranda_leaf_carpet", () -> new LeafCarpetBlock(HorizonsProperties.JACARANDA.leafCarpet()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> FLOWERING_JACARANDA_LEAF_PILE = HELPER.createCompatBlock(HorizonsConstants.WOODWORKS, "flowering_jacaranda_leaf_pile", () -> new LeafPileBlock(HorizonsProperties.JACARANDA.leafPile()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BLUE_JACARANDA_HEDGE = HELPER.createCompatFuelBlock(HorizonsConstants.QUARK, "blue_jacaranda_hedge", () -> new HedgeBlock(HorizonsProperties.JACARANDA.planks()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BLUE_JACARANDA_LEAF_CARPET = HELPER.createCompatBlock(HorizonsConstants.QUARK, "blue_jacaranda_leaf_carpet", () -> new LeafCarpetBlock(HorizonsProperties.JACARANDA.leafCarpet()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BLUE_JACARANDA_LEAF_PILE = HELPER.createCompatBlock(HorizonsConstants.WOODWORKS, "blue_jacaranda_leaf_pile", () -> new LeafPileBlock(HorizonsProperties.JACARANDA.leafPile()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BUDDING_BLUE_JACARANDA_HEDGE = HELPER.createCompatFuelBlock(HorizonsConstants.QUARK, "budding_blue_jacaranda_hedge", () -> new HedgeBlock(HorizonsProperties.JACARANDA.planks()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BUDDING_BLUE_JACARANDA_LEAF_CARPET = HELPER.createCompatBlock(HorizonsConstants.QUARK, "budding_blue_jacaranda_leaf_carpet", () -> new LeafCarpetBlock(HorizonsProperties.JACARANDA.leafCarpet()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> BUDDING_BLUE_JACARANDA_LEAF_PILE = HELPER.createCompatBlock(HorizonsConstants.WOODWORKS, "budding_blue_jacaranda_leaf_pile", () -> new LeafPileBlock(HorizonsProperties.JACARANDA.leafPile()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> FLOWERING_BLUE_JACARANDA_HEDGE = HELPER.createCompatFuelBlock(HorizonsConstants.QUARK, "flowering_blue_jacaranda_hedge", () -> new HedgeBlock(HorizonsProperties.JACARANDA.planks()), 300, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> FLOWERING_BLUE_JACARANDA_LEAF_CARPET = HELPER.createCompatBlock(HorizonsConstants.QUARK, "flowering_blue_jacaranda_leaf_carpet", () -> new LeafCarpetBlock(HorizonsProperties.JACARANDA.leafCarpet()), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> FLOWERING_BLUE_JACARANDA_LEAF_PILE = HELPER.createCompatBlock(HorizonsConstants.WOODWORKS, "flowering_blue_jacaranda_leaf_pile", () -> new LeafPileBlock(HorizonsProperties.JACARANDA.leafPile()), CreativeModeTab.TAB_DECORATIONS);

    // Sunflower //

    public static final RegistryObject<Block> SUNFLOWER_SEED_SACK = HELPER.createCompatFuelBlock(HorizonsConstants.QUARK, "sunflower_seed_sack", () -> new Block(HorizonsProperties.SUNFLOWER_SEED_SACK), 300, CreativeModeTab.TAB_DECORATIONS);
}
