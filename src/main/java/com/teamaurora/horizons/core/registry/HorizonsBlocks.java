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
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.OakTreeGrower;
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
    public static final RegistryObject<Block> CYPRESS_SAPLING = HELPER.createBlock("cypress_sapling", () -> new BlueprintSaplingBlock(new OakTreeGrower(), PropertyUtil.SAPLING), CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> POTTED_CYPRESS_SAPLING = HELPER.createBlockNoItem("potted_cypress_sapling", () -> new FlowerPotBlock(CYPRESS_SAPLING.get(), PropertyUtil.FLOWER_POT));
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

    public static final RegistryObject<Block> POTTED_BLUE_LILY = HELPER.createBlockNoItem("potted_blue_lily", () -> new FlowerPotBlock(BLUE_LILY.get(), PropertyUtil.FLOWER_POT));
    public static final RegistryObject<Block> POTTED_LIGHT_GRAY_LILY= HELPER.createBlockNoItem("potted_light_gray_lily", () -> new FlowerPotBlock(LIGHT_GRAY_LILY.get(), PropertyUtil.FLOWER_POT));
    public static final RegistryObject<Block> POTTED_CYAN_LILY = HELPER.createBlockNoItem("potted_cyan_lily", () -> new FlowerPotBlock(CYAN_LILY.get(), PropertyUtil.FLOWER_POT));
    public static final RegistryObject<Block> POTTED_LIGHT_BLUE_LILY = HELPER.createBlockNoItem("potted_light_blue_lily", () -> new FlowerPotBlock(LIGHT_BLUE_LILY.get(), PropertyUtil.FLOWER_POT));
    public static final RegistryObject<Block> POTTED_MAGENTA_LILY = HELPER.createBlockNoItem("potted_magenta_lily", () -> new FlowerPotBlock(MAGENTA_LILY.get(), PropertyUtil.FLOWER_POT));
    public static final RegistryObject<Block> POTTED_PINK_LILY = HELPER.createBlockNoItem("potted_pink_lily", () -> new FlowerPotBlock(PINK_LILY.get(), PropertyUtil.FLOWER_POT));
    public static final RegistryObject<Block> POTTED_PURPLE_LILY = HELPER.createBlockNoItem("potted_purple_lily", () -> new FlowerPotBlock(PURPLE_LILY.get(), PropertyUtil.FLOWER_POT));
    public static final RegistryObject<Block> POTTED_WHITE_LILY = HELPER.createBlockNoItem("potted_white_lily", () -> new FlowerPotBlock(WHITE_LILY.get(), PropertyUtil.FLOWER_POT));

    // Misc //

    public static final RegistryObject<Block> GIANT_FERN = HELPER.createInjectedBlock("giant_fern", Items.LARGE_FERN, () -> new DoublePlantBlock(HorizonsProperties.GIANT_FERN), CreativeModeTab.TAB_DECORATIONS);

}
