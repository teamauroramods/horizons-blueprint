package com.teamaurora.horizons.core.data.client;

import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.common.block.VerticalSlabBlock;
import com.teamabnormals.blueprint.common.block.chest.BlueprintChestBlock;
import com.teamabnormals.blueprint.common.block.chest.BlueprintTrappedChestBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintStandingSignBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintWallSignBlock;
import com.teamabnormals.blueprint.core.Blueprint;
import com.teamaurora.horizons.common.block.cypress.CypressBranchBlock;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsItems;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author rose_
 */
public class HorizonsModelProvider extends BlockStateProvider {
    public HorizonsModelProvider(GatherDataEvent event) {
        super(event.getGenerator(), Horizons.MODID, event.getExistingFileHelper());
    }

    @Override
    protected void registerStatesAndModels() {
        //item models
        this.generatedItem(HorizonsItems.GOOSEBERRIES.get(), TextureFolder.Item);
        this.generatedItem(HorizonsItems.GOOSEBERRY_JUICE.get(), TextureFolder.Item);
        this.generatedItem(HorizonsItems.GOOSEBERRY_PIE.get(), TextureFolder.Item);
        this.generatedItem(HorizonsItems.HONEY_GLAZED_GOOSEBERRIES.get(), TextureFolder.Item);
        this.generatedItem(HorizonsItems.GOOSEBERRY_JAM.get(), TextureFolder.Item);
        this.generatedItem(HorizonsItems.GOOSEBERRY_JAM_COOKIE.get(), TextureFolder.Item);

        this.generatedItem(HorizonsItems.CYPRESS_BOATS.getFirst().get(), TextureFolder.Item);
        this.generatedItem(HorizonsItems.CYPRESS_BOATS.getSecond().get(), TextureFolder.Item);
        this.generatedItem(HorizonsItems.CYPRESS_FURNACE_BOAT.get(), TextureFolder.Item);
        this.generatedItem(HorizonsItems.LARGE_CYPRESS_BOAT.get(), TextureFolder.Item);
        this.generatedItem(HorizonsItems.REDWOOD_BOATS.getFirst().get(), TextureFolder.Item);
        this.generatedItem(HorizonsItems.REDWOOD_BOATS.getSecond().get(), TextureFolder.Item);
        this.generatedItem(HorizonsItems.REDWOOD_FURNACE_BOAT.get(), TextureFolder.Item);
        this.generatedItem(HorizonsItems.LARGE_REDWOOD_BOAT.get(), TextureFolder.Item);
        this.generatedItem(HorizonsItems.REDBUD_BOATS.getFirst().get(), TextureFolder.Item);
        this.generatedItem(HorizonsItems.REDBUD_BOATS.getSecond().get(), TextureFolder.Item);
        this.generatedItem(HorizonsItems.REDBUD_FURNACE_BOAT.get(), TextureFolder.Item);
        this.generatedItem(HorizonsItems.LARGE_REDBUD_BOAT.get(), TextureFolder.Item);
        this.generatedItem(HorizonsItems.JACARANDA_BOATS.getFirst().get(), TextureFolder.Item);
        this.generatedItem(HorizonsItems.JACARANDA_BOATS.getSecond().get(), TextureFolder.Item);
        this.generatedItem(HorizonsItems.JACARANDA_FURNACE_BOAT.get(), TextureFolder.Item);
        this.generatedItem(HorizonsItems.LARGE_JACARANDA_BOAT.get(), TextureFolder.Item);

        //block states
        this.log(HorizonsBlocks.STRIPPED_CYPRESS_LOG);
        this.cubeAll(HorizonsBlocks.STRIPPED_CYPRESS_WOOD, this.blockTexture(HorizonsBlocks.STRIPPED_CYPRESS_LOG.get()));
        this.log(HorizonsBlocks.CYPRESS_LOG);
        this.cubeAll(HorizonsBlocks.CYPRESS_WOOD, this.blockTexture(HorizonsBlocks.CYPRESS_LOG.get()));
        this.cubeAll(HorizonsBlocks.CYPRESS_PLANKS);
        this.slab(HorizonsBlocks.CYPRESS_SLAB, HorizonsBlocks.CYPRESS_PLANKS);
        this.stairs(HorizonsBlocks.CYPRESS_STAIRS, HorizonsBlocks.CYPRESS_PLANKS);
        this.fence(HorizonsBlocks.CYPRESS_FENCE, HorizonsBlocks.CYPRESS_PLANKS);
        this.fenceGate(HorizonsBlocks.CYPRESS_FENCE_GATE, HorizonsBlocks.CYPRESS_PLANKS);
        this.pressurePlate(HorizonsBlocks.CYPRESS_PRESSURE_PLATE, HorizonsBlocks.CYPRESS_PLANKS);
        this.door(HorizonsBlocks.CYPRESS_DOOR);
        this.trapdoor(HorizonsBlocks.CYPRESS_TRAPDOOR);
        this.button(HorizonsBlocks.CYPRESS_BUTTON, HorizonsBlocks.CYPRESS_PLANKS);
        this.signs(HorizonsBlocks.CYPRESS_SIGNS, HorizonsBlocks.CYPRESS_PLANKS);
        this.leaves(HorizonsBlocks.CYPRESS_LEAVES);
        this.pottedPlant(HorizonsBlocks.CYPRESS_SAPLING, HorizonsBlocks.POTTED_CYPRESS_SAPLING);

        this.beehive(HorizonsBlocks.CYPRESS_BEEHIVE);
        this.hedge(HorizonsBlocks.CYPRESS_HEDGE, HorizonsBlocks.CYPRESS_LEAVES, HorizonsBlocks.CYPRESS_LOG);
        this.leafCarpet(HorizonsBlocks.CYPRESS_LEAF_CARPET, HorizonsBlocks.CYPRESS_LEAVES);
        this.leafPile(HorizonsBlocks.CYPRESS_LEAF_PILE, HorizonsBlocks.CYPRESS_LEAVES, true);
        this.ladder(HorizonsBlocks.CYPRESS_LADDER);
        this.verticalPlanks(HorizonsBlocks.VERTICAL_CYPRESS_PLANKS, HorizonsBlocks.CYPRESS_PLANKS);
        this.bookshelf(HorizonsBlocks.CYPRESS_BOOKSHELF, HorizonsBlocks.CYPRESS_PLANKS);
        this.boards(HorizonsBlocks.CYPRESS_BOARDS);
        this.verticalSlab(HorizonsBlocks.CYPRESS_VERTICAL_SLAB, HorizonsBlocks.CYPRESS_PLANKS);
        this.post(HorizonsBlocks.CYPRESS_POST, HorizonsBlocks.CYPRESS_LOG);
        this.post(HorizonsBlocks.STRIPPED_CYPRESS_POST, HorizonsBlocks.STRIPPED_CYPRESS_LOG);
        this.chests(HorizonsBlocks.CYPRESS_CHEST, HorizonsBlocks.CYPRESS_TRAPPED_CHEST, HorizonsBlocks.CYPRESS_PLANKS);
        this.cabinet(HorizonsBlocks.CYPRESS_CABINET);
        this.hangingLeaves(HorizonsBlocks.HANGING_CYPRESS_LEAVES);

        this.cypressKnee(HorizonsBlocks.CYPRESS_KNEE);
        this.largeCypressKnee(HorizonsBlocks.LARGE_CYPRESS_KNEE);
        this.cypressKnee(HorizonsBlocks.STRIPPED_CYPRESS_KNEE);
        this.largeCypressKnee(HorizonsBlocks.STRIPPED_LARGE_CYPRESS_KNEE);

        this.beardMossBlock(HorizonsBlocks.BEARD_MOSS_BLOCK);
        this.beardMoss(HorizonsBlocks.BEARD_MOSS);

        this.cypressBranch(HorizonsBlocks.CYPRESS_BRANCH);
        this.cubeBottomTop(HorizonsBlocks.GOOSEBERRY_SACK);

        this.algae(HorizonsBlocks.ALGAE);
        this.thatch(HorizonsBlocks.ALGAE_THATCH);
        this.thatchSlab(HorizonsBlocks.ALGAE_THATCH_SLAB, HorizonsBlocks.ALGAE_THATCH);
        this.thatchStairs(HorizonsBlocks.ALGAE_THATCH_STAIRS, HorizonsBlocks.ALGAE_THATCH);
        this.thatchVerticalSlab(HorizonsBlocks.ALGAE_THATCH_VERTICAL_SLAB, HorizonsBlocks.ALGAE_THATCH);

        this.lily(HorizonsBlocks.BLUE_LILY, HorizonsBlocks.POTTED_BLUE_LILY);
        this.lily(HorizonsBlocks.LIGHT_GRAY_LILY, HorizonsBlocks.POTTED_LIGHT_GRAY_LILY);
        this.lily(HorizonsBlocks.CYAN_LILY, HorizonsBlocks.POTTED_CYAN_LILY);
        this.lily(HorizonsBlocks.LIGHT_BLUE_LILY, HorizonsBlocks.POTTED_LIGHT_BLUE_LILY);
        this.lily(HorizonsBlocks.MAGENTA_LILY, HorizonsBlocks.POTTED_MAGENTA_LILY);
        this.lily(HorizonsBlocks.PINK_LILY, HorizonsBlocks.POTTED_PINK_LILY);
        this.lily(HorizonsBlocks.PURPLE_LILY, HorizonsBlocks.POTTED_PURPLE_LILY);
        this.lily(HorizonsBlocks.WHITE_LILY, HorizonsBlocks.POTTED_WHITE_LILY);

        this.triplePlant(HorizonsBlocks.GIANT_FERN);

        this.log(HorizonsBlocks.STRIPPED_REDWOOD_LOG);
        this.cubeAll(HorizonsBlocks.STRIPPED_REDWOOD_WOOD, this.blockTexture(HorizonsBlocks.STRIPPED_REDWOOD_LOG.get()));
        this.log(HorizonsBlocks.REDWOOD_LOG);
        this.cubeAll(HorizonsBlocks.REDWOOD_WOOD, this.blockTexture(HorizonsBlocks.REDWOOD_LOG.get()));
        this.cubeAll(HorizonsBlocks.REDWOOD_PLANKS);
        this.slab(HorizonsBlocks.REDWOOD_SLAB, HorizonsBlocks.REDWOOD_PLANKS);
        this.stairs(HorizonsBlocks.REDWOOD_STAIRS, HorizonsBlocks.REDWOOD_PLANKS);
        this.fence(HorizonsBlocks.REDWOOD_FENCE, HorizonsBlocks.REDWOOD_PLANKS);
        this.fenceGate(HorizonsBlocks.REDWOOD_FENCE_GATE, HorizonsBlocks.REDWOOD_PLANKS);
        this.pressurePlate(HorizonsBlocks.REDWOOD_PRESSURE_PLATE, HorizonsBlocks.REDWOOD_PLANKS);
        this.door(HorizonsBlocks.REDWOOD_DOOR);
        this.trapdoor(HorizonsBlocks.REDWOOD_TRAPDOOR);
        this.button(HorizonsBlocks.REDWOOD_BUTTON, HorizonsBlocks.REDWOOD_PLANKS);
        this.signs(HorizonsBlocks.REDWOOD_SIGNS, HorizonsBlocks.REDWOOD_PLANKS);
        this.leaves(HorizonsBlocks.REDWOOD_LEAVES);
        this.pottedPlant(HorizonsBlocks.REDWOOD_SAPLING, HorizonsBlocks.POTTED_REDWOOD_SAPLING);

        this.beehive(HorizonsBlocks.REDWOOD_BEEHIVE);
        this.hedge(HorizonsBlocks.REDWOOD_HEDGE, HorizonsBlocks.REDWOOD_LEAVES, HorizonsBlocks.REDWOOD_LOG);
        this.leafCarpet(HorizonsBlocks.REDWOOD_LEAF_CARPET, HorizonsBlocks.REDWOOD_LEAVES);
        this.leafPile(HorizonsBlocks.REDWOOD_LEAF_PILE, HorizonsBlocks.REDWOOD_LEAVES, false);
        this.ladder(HorizonsBlocks.REDWOOD_LADDER);
        this.verticalPlanks(HorizonsBlocks.VERTICAL_REDWOOD_PLANKS, HorizonsBlocks.REDWOOD_PLANKS);
        this.bookshelf(HorizonsBlocks.REDWOOD_BOOKSHELF, HorizonsBlocks.REDWOOD_PLANKS);
        this.boards(HorizonsBlocks.REDWOOD_BOARDS);
        this.verticalSlab(HorizonsBlocks.REDWOOD_VERTICAL_SLAB, HorizonsBlocks.REDWOOD_PLANKS);
        this.post(HorizonsBlocks.REDWOOD_POST, HorizonsBlocks.REDWOOD_LOG);
        this.post(HorizonsBlocks.STRIPPED_REDWOOD_POST, HorizonsBlocks.STRIPPED_REDWOOD_LOG);
        this.chests(HorizonsBlocks.REDWOOD_CHEST, HorizonsBlocks.REDWOOD_TRAPPED_CHEST, HorizonsBlocks.REDWOOD_PLANKS);
        //this.cabinet(HorizonsBlocks.REDWOOD_CABINET);

        this.cubeAll(HorizonsBlocks.LIGHT_BOULDER);
        this.slab(HorizonsBlocks.LIGHT_BOULDER_SLAB, HorizonsBlocks.LIGHT_BOULDER);
        this.stairs(HorizonsBlocks.LIGHT_BOULDER_STAIRS, HorizonsBlocks.LIGHT_BOULDER);
        this.verticalSlab(HorizonsBlocks.LIGHT_BOULDER_VERTICAL_SLAB, HorizonsBlocks.LIGHT_BOULDER);
        this.wall(HorizonsBlocks.LIGHT_BOULDER_WALL, HorizonsBlocks.LIGHT_BOULDER);
        this.cubeAll(HorizonsBlocks.MOSSY_LIGHT_BOULDER);
        this.slab(HorizonsBlocks.MOSSY_LIGHT_BOULDER_SLAB, HorizonsBlocks.MOSSY_LIGHT_BOULDER);
        this.stairs(HorizonsBlocks.MOSSY_LIGHT_BOULDER_STAIRS, HorizonsBlocks.MOSSY_LIGHT_BOULDER);
        this.verticalSlab(HorizonsBlocks.MOSSY_LIGHT_BOULDER_VERTICAL_SLAB, HorizonsBlocks.MOSSY_LIGHT_BOULDER);
        this.wall(HorizonsBlocks.MOSSY_LIGHT_BOULDER_WALL, HorizonsBlocks.MOSSY_LIGHT_BOULDER);
        this.cubeAll(HorizonsBlocks.DARK_BOULDER);
        this.slab(HorizonsBlocks.DARK_BOULDER_SLAB, HorizonsBlocks.DARK_BOULDER);
        this.stairs(HorizonsBlocks.DARK_BOULDER_STAIRS, HorizonsBlocks.DARK_BOULDER);
        this.verticalSlab(HorizonsBlocks.DARK_BOULDER_VERTICAL_SLAB, HorizonsBlocks.DARK_BOULDER);
        this.wall(HorizonsBlocks.DARK_BOULDER_WALL, HorizonsBlocks.DARK_BOULDER);
        this.cubeAll(HorizonsBlocks.MOSSY_DARK_BOULDER);
        this.slab(HorizonsBlocks.MOSSY_DARK_BOULDER_SLAB, HorizonsBlocks.MOSSY_DARK_BOULDER);
        this.stairs(HorizonsBlocks.MOSSY_DARK_BOULDER_STAIRS, HorizonsBlocks.MOSSY_DARK_BOULDER);
        this.verticalSlab(HorizonsBlocks.MOSSY_DARK_BOULDER_VERTICAL_SLAB, HorizonsBlocks.MOSSY_DARK_BOULDER);
        this.wall(HorizonsBlocks.MOSSY_DARK_BOULDER_WALL, HorizonsBlocks.MOSSY_DARK_BOULDER);
        this.cubeAll(HorizonsBlocks.BOULDER_BRICKS);
        this.slab(HorizonsBlocks.BOULDER_BRICK_SLAB, HorizonsBlocks.BOULDER_BRICKS);
        this.stairs(HorizonsBlocks.BOULDER_BRICK_STAIRS, HorizonsBlocks.BOULDER_BRICKS);
        this.verticalSlab(HorizonsBlocks.BOULDER_BRICK_VERTICAL_SLAB, HorizonsBlocks.BOULDER_BRICKS);
        this.wall(HorizonsBlocks.BOULDER_BRICK_WALL, HorizonsBlocks.BOULDER_BRICKS);

        this.pottedPlant(HorizonsBlocks.YELLOW_DAISY, HorizonsBlocks.POTTED_YELLOW_DAISY);
        this.pottedPlant(HorizonsBlocks.RED_DAISY, HorizonsBlocks.POTTED_RED_DAISY);
        this.pottedPlant(HorizonsBlocks.PURPLE_DAISY, HorizonsBlocks.POTTED_PURPLE_DAISY);
        this.pottedPlant(HorizonsBlocks.PINK_DAISY, HorizonsBlocks.POTTED_PINK_DAISY);
        this.pottedPlant(HorizonsBlocks.ORANGE_DAISY, HorizonsBlocks.POTTED_ORANGE_DAISY);
        this.pottedPlant(HorizonsBlocks.MAGENTA_DAISY, HorizonsBlocks.POTTED_MAGENTA_DAISY);
        this.pottedPlant(HorizonsBlocks.BLUE_DAISY, HorizonsBlocks.POTTED_BLUE_DAISY);

        this.log(HorizonsBlocks.STRIPPED_REDBUD_LOG);
        this.cubeAll(HorizonsBlocks.STRIPPED_REDBUD_WOOD, this.blockTexture(HorizonsBlocks.STRIPPED_REDBUD_LOG.get()));
        this.log(HorizonsBlocks.REDBUD_LOG);
        this.cubeAll(HorizonsBlocks.REDBUD_WOOD, this.blockTexture(HorizonsBlocks.REDBUD_LOG.get()));
        this.variantLog(HorizonsBlocks.FLOWERING_REDBUD_LOG, HorizonsBlocks.REDBUD_LOG);
        this.cubeAll(HorizonsBlocks.FLOWERING_REDBUD_WOOD, this.blockTexture(HorizonsBlocks.FLOWERING_REDBUD_LOG.get()));
        this.cubeAll(HorizonsBlocks.REDBUD_PLANKS);
        this.slab(HorizonsBlocks.REDBUD_SLAB, HorizonsBlocks.REDBUD_PLANKS);
        this.stairs(HorizonsBlocks.REDBUD_STAIRS, HorizonsBlocks.REDBUD_PLANKS);
        this.fence(HorizonsBlocks.REDBUD_FENCE, HorizonsBlocks.REDBUD_PLANKS);
        this.fenceGate(HorizonsBlocks.REDBUD_FENCE_GATE, HorizonsBlocks.REDBUD_PLANKS);
        this.pressurePlate(HorizonsBlocks.REDBUD_PRESSURE_PLATE, HorizonsBlocks.REDBUD_PLANKS);
        this.door(HorizonsBlocks.REDBUD_DOOR);
        this.trapdoor(HorizonsBlocks.REDBUD_TRAPDOOR);
        this.button(HorizonsBlocks.REDBUD_BUTTON, HorizonsBlocks.REDBUD_PLANKS);
        this.signs(HorizonsBlocks.REDBUD_SIGNS, HorizonsBlocks.REDBUD_PLANKS);
        this.pottedPlant(HorizonsBlocks.REDBUD_SAPLING, HorizonsBlocks.POTTED_REDBUD_SAPLING);
        this.pottedPlant(HorizonsBlocks.BUDDING_REDBUD_SAPLING, HorizonsBlocks.POTTED_BUDDING_REDBUD_SAPLING);
        this.pottedPlant(HorizonsBlocks.FLOWERING_REDBUD_SAPLING, HorizonsBlocks.POTTED_FLOWERING_REDBUD_SAPLING);
        this.leaves(HorizonsBlocks.REDBUD_LEAVES);
        this.leaves(HorizonsBlocks.BUDDING_REDBUD_LEAVES);
        this.leaves(HorizonsBlocks.FLOWERING_REDBUD_LEAVES);

        this.beehive(HorizonsBlocks.REDBUD_BEEHIVE);
        this.hedge(HorizonsBlocks.REDBUD_HEDGE, HorizonsBlocks.REDBUD_LEAVES, HorizonsBlocks.REDBUD_LOG);
        this.leafCarpet(HorizonsBlocks.REDBUD_LEAF_CARPET, HorizonsBlocks.REDBUD_LEAVES);
        this.leafPile(HorizonsBlocks.REDBUD_LEAF_PILE, HorizonsBlocks.REDBUD_LEAVES, false);
        this.hedge(HorizonsBlocks.BUDDING_REDBUD_HEDGE, HorizonsBlocks.BUDDING_REDBUD_LEAVES, HorizonsBlocks.FLOWERING_REDBUD_LOG);
        this.leafCarpet(HorizonsBlocks.BUDDING_REDBUD_LEAF_CARPET, HorizonsBlocks.BUDDING_REDBUD_LEAVES);
        this.leafPile(HorizonsBlocks.BUDDING_REDBUD_LEAF_PILE, HorizonsBlocks.BUDDING_REDBUD_LEAVES, false);
        this.hedge(HorizonsBlocks.FLOWERING_REDBUD_HEDGE, HorizonsBlocks.FLOWERING_REDBUD_LEAVES, HorizonsBlocks.FLOWERING_REDBUD_LOG);
        this.leafCarpet(HorizonsBlocks.FLOWERING_REDBUD_LEAF_CARPET, HorizonsBlocks.FLOWERING_REDBUD_LEAVES);
        this.leafPile(HorizonsBlocks.FLOWERING_REDBUD_LEAF_PILE, HorizonsBlocks.FLOWERING_REDBUD_LEAVES, false);
        this.ladder(HorizonsBlocks.REDBUD_LADDER);
        this.verticalPlanks(HorizonsBlocks.VERTICAL_REDBUD_PLANKS, HorizonsBlocks.REDBUD_PLANKS);
        this.bookshelf(HorizonsBlocks.REDBUD_BOOKSHELF, HorizonsBlocks.REDBUD_PLANKS);
        this.boards(HorizonsBlocks.REDBUD_BOARDS);
        this.verticalSlab(HorizonsBlocks.REDBUD_VERTICAL_SLAB, HorizonsBlocks.REDBUD_PLANKS);
        this.post(HorizonsBlocks.REDBUD_POST, HorizonsBlocks.REDBUD_LOG);
        this.post(HorizonsBlocks.STRIPPED_REDBUD_POST, HorizonsBlocks.STRIPPED_REDBUD_LOG);
        this.post(HorizonsBlocks.FLOWERING_REDBUD_POST, HorizonsBlocks.FLOWERING_REDBUD_LOG);
        this.chests(HorizonsBlocks.REDBUD_CHEST, HorizonsBlocks.REDBUD_TRAPPED_CHEST, HorizonsBlocks.REDBUD_PLANKS);
        this.cabinet(HorizonsBlocks.REDBUD_CABINET);

        this.log(HorizonsBlocks.STRIPPED_JACARANDA_LOG);
        this.cubeAll(HorizonsBlocks.STRIPPED_JACARANDA_WOOD, this.blockTexture(HorizonsBlocks.STRIPPED_JACARANDA_LOG.get()));
        this.log(HorizonsBlocks.JACARANDA_LOG);
        this.cubeAll(HorizonsBlocks.JACARANDA_WOOD, this.blockTexture(HorizonsBlocks.JACARANDA_LOG.get()));
        this.cubeAll(HorizonsBlocks.JACARANDA_PLANKS);
        this.slab(HorizonsBlocks.JACARANDA_SLAB, HorizonsBlocks.JACARANDA_PLANKS);
        this.stairs(HorizonsBlocks.JACARANDA_STAIRS, HorizonsBlocks.JACARANDA_PLANKS);
        this.fence(HorizonsBlocks.JACARANDA_FENCE, HorizonsBlocks.JACARANDA_PLANKS);
        this.fenceGate(HorizonsBlocks.JACARANDA_FENCE_GATE, HorizonsBlocks.JACARANDA_PLANKS);
        this.pressurePlate(HorizonsBlocks.JACARANDA_PRESSURE_PLATE, HorizonsBlocks.JACARANDA_PLANKS);
        this.door(HorizonsBlocks.JACARANDA_DOOR);
        this.trapdoor(HorizonsBlocks.JACARANDA_TRAPDOOR);
        this.button(HorizonsBlocks.JACARANDA_BUTTON, HorizonsBlocks.JACARANDA_PLANKS);
        this.signs(HorizonsBlocks.JACARANDA_SIGNS, HorizonsBlocks.JACARANDA_PLANKS);
        this.pottedPlant(HorizonsBlocks.JACARANDA_SAPLING, HorizonsBlocks.POTTED_JACARANDA_SAPLING);
        this.pottedPlant(HorizonsBlocks.BLUE_JACARANDA_SAPLING, HorizonsBlocks.POTTED_BLUE_JACARANDA_SAPLING);
        this.leaves(HorizonsBlocks.JACARANDA_LEAVES);
        this.leaves(HorizonsBlocks.BUDDING_JACARANDA_LEAVES);
        this.leaves(HorizonsBlocks.FLOWERING_JACARANDA_LEAVES);
        this.leaves(HorizonsBlocks.BLUE_JACARANDA_LEAVES);
        this.leaves(HorizonsBlocks.BUDDING_BLUE_JACARANDA_LEAVES);
        this.leaves(HorizonsBlocks.FLOWERING_BLUE_JACARANDA_LEAVES);

        this.beehive(HorizonsBlocks.JACARANDA_BEEHIVE);
        this.hedge(HorizonsBlocks.JACARANDA_HEDGE, HorizonsBlocks.JACARANDA_LEAVES, HorizonsBlocks.JACARANDA_LOG);
        this.leafCarpet(HorizonsBlocks.JACARANDA_LEAF_CARPET, HorizonsBlocks.JACARANDA_LEAVES);
        this.leafPile(HorizonsBlocks.JACARANDA_LEAF_PILE, HorizonsBlocks.JACARANDA_LEAVES, false);
        this.hedge(HorizonsBlocks.BUDDING_JACARANDA_HEDGE, HorizonsBlocks.BUDDING_JACARANDA_LEAVES, HorizonsBlocks.JACARANDA_LOG);
        this.leafCarpet(HorizonsBlocks.BUDDING_JACARANDA_LEAF_CARPET, HorizonsBlocks.BUDDING_JACARANDA_LEAVES);
        this.leafPile(HorizonsBlocks.BUDDING_JACARANDA_LEAF_PILE, HorizonsBlocks.BUDDING_JACARANDA_LEAVES, false);
        this.hedge(HorizonsBlocks.FLOWERING_JACARANDA_HEDGE, HorizonsBlocks.FLOWERING_JACARANDA_LEAVES, HorizonsBlocks.JACARANDA_LOG);
        this.leafCarpet(HorizonsBlocks.FLOWERING_JACARANDA_LEAF_CARPET, HorizonsBlocks.FLOWERING_JACARANDA_LEAVES);
        this.leafPile(HorizonsBlocks.FLOWERING_JACARANDA_LEAF_PILE, HorizonsBlocks.FLOWERING_JACARANDA_LEAVES, false);
        this.hedge(HorizonsBlocks.BLUE_JACARANDA_HEDGE, HorizonsBlocks.BLUE_JACARANDA_LEAVES, HorizonsBlocks.JACARANDA_LOG);
        this.leafCarpet(HorizonsBlocks.BLUE_JACARANDA_LEAF_CARPET, HorizonsBlocks.BLUE_JACARANDA_LEAVES);
        this.leafPile(HorizonsBlocks.BLUE_JACARANDA_LEAF_PILE, HorizonsBlocks.BLUE_JACARANDA_LEAVES, false);
        this.hedge(HorizonsBlocks.BUDDING_BLUE_JACARANDA_HEDGE, HorizonsBlocks.BUDDING_BLUE_JACARANDA_LEAVES, HorizonsBlocks.JACARANDA_LOG);
        this.leafCarpet(HorizonsBlocks.BUDDING_BLUE_JACARANDA_LEAF_CARPET, HorizonsBlocks.BUDDING_BLUE_JACARANDA_LEAVES);
        this.leafPile(HorizonsBlocks.BUDDING_BLUE_JACARANDA_LEAF_PILE, HorizonsBlocks.BUDDING_BLUE_JACARANDA_LEAVES, false);
        this.hedge(HorizonsBlocks.FLOWERING_BLUE_JACARANDA_HEDGE, HorizonsBlocks.FLOWERING_BLUE_JACARANDA_LEAVES, HorizonsBlocks.JACARANDA_LOG);
        this.leafCarpet(HorizonsBlocks.FLOWERING_BLUE_JACARANDA_LEAF_CARPET, HorizonsBlocks.FLOWERING_BLUE_JACARANDA_LEAVES);
        this.leafPile(HorizonsBlocks.FLOWERING_BLUE_JACARANDA_LEAF_PILE, HorizonsBlocks.FLOWERING_BLUE_JACARANDA_LEAVES, false);
        this.ladder(HorizonsBlocks.JACARANDA_LADDER);
        this.verticalPlanks(HorizonsBlocks.VERTICAL_JACARANDA_PLANKS, HorizonsBlocks.JACARANDA_PLANKS);
        this.bookshelf(HorizonsBlocks.JACARANDA_BOOKSHELF, HorizonsBlocks.JACARANDA_PLANKS);
        this.boards(HorizonsBlocks.JACARANDA_BOARDS);
        this.verticalSlab(HorizonsBlocks.JACARANDA_VERTICAL_SLAB, HorizonsBlocks.JACARANDA_PLANKS);
        this.post(HorizonsBlocks.JACARANDA_POST, HorizonsBlocks.JACARANDA_LOG);
        this.post(HorizonsBlocks.STRIPPED_JACARANDA_POST, HorizonsBlocks.STRIPPED_JACARANDA_LOG);
        this.chests(HorizonsBlocks.JACARANDA_CHEST, HorizonsBlocks.JACARANDA_TRAPPED_CHEST, HorizonsBlocks.JACARANDA_PLANKS);
        this.cabinet(HorizonsBlocks.JACARANDA_CABINET);
    }

    // Specific Block Generators //

    private void algae(RegistryObject<Block> algae) {
        this.generatedItem(algae.get(), TextureFolder.Block);
        //ill change this eventually, the model works, but it shouldn't be a multipart builder
        this.getMultipartBuilder(algae.get()).part().modelFile(this.models().withExistingParent(this.getItemName(algae.get()), "blueprint:block/leaf_pile").texture("all", this.blockTexture(algae.get())).renderType("cutout")).uvLock(true).rotationX(90).addModel();
    }

    private void hangingLeaves(RegistryObject<Block> hangingLeaves) {
        this.simpleBlock(hangingLeaves.get(), this.models().withExistingParent(this.getItemName(hangingLeaves.get()), "minecraft:tinted_cross").texture("cross", this.blockTexture(hangingLeaves.get())).renderType("cutout"));
        this.generatedItem(hangingLeaves.get(), TextureFolder.Block);
    }

    private void cypressKnee(RegistryObject<Block> knee) {
        this.generatedItem(knee.get(), TextureFolder.Block);
        this.simpleCross(knee);
    }

    private void largeCypressKnee(RegistryObject<Block> knee) {
        String name = this.getItemName(knee.get());

        this.itemModels().withExistingParent(name, "item/generated").texture("layer0", this.modLoc("block/" + name + "_bottom"));
        this.doubleBlockNoItem(knee);
    }

    private void variantLog(RegistryObject<Block> variant, RegistryObject<Block> log) {
        this.axisBlock((RotatedPillarBlock)variant.get(), this.blockTexture(variant.get()), this.modLoc("block/" + this.getItemName(log.get()) + "_top"));
        this.itemModel(variant);
    }
    
    private void cypressBranch(RegistryObject<Block> branch) {
        String name = this.getItemName(branch.get());
        Function<Integer, ModelFile> model = i -> this.models().withExistingParent(name + "_" + i, this.modLoc("block/template_branch")).texture("branch", this.modLoc("block/" + name + "_" + i)).renderType("cutout");

        this.generatedItem(branch.get(), TextureFolder.Item);
        this.getVariantBuilder(branch.get())
                .partialState().with(CypressBranchBlock.AGE, 0).with(CypressBranchBlock.FACING, Direction.NORTH).addModels(new ConfiguredModel(model.apply(0), 0, 180, true))
                .partialState().with(CypressBranchBlock.AGE, 1).with(CypressBranchBlock.FACING, Direction.NORTH).addModels(new ConfiguredModel(model.apply(1), 0, 180, true))
                .partialState().with(CypressBranchBlock.AGE, 2).with(CypressBranchBlock.FACING, Direction.NORTH).addModels(new ConfiguredModel(model.apply(2), 0, 180, true))
                .partialState().with(CypressBranchBlock.AGE, 0).with(CypressBranchBlock.FACING, Direction.SOUTH).addModels(new ConfiguredModel(model.apply(0), 0, 0, true))
                .partialState().with(CypressBranchBlock.AGE, 1).with(CypressBranchBlock.FACING, Direction.SOUTH).addModels(new ConfiguredModel(model.apply(1), 0, 0, true))
                .partialState().with(CypressBranchBlock.AGE, 2).with(CypressBranchBlock.FACING, Direction.SOUTH).addModels(new ConfiguredModel(model.apply(2), 0, 0, true))
                .partialState().with(CypressBranchBlock.AGE, 0).with(CypressBranchBlock.FACING, Direction.EAST).addModels(new ConfiguredModel(model.apply(0), 0, 270, true))
                .partialState().with(CypressBranchBlock.AGE, 1).with(CypressBranchBlock.FACING, Direction.EAST).addModels(new ConfiguredModel(model.apply(1), 0, 270, true))
                .partialState().with(CypressBranchBlock.AGE, 2).with(CypressBranchBlock.FACING, Direction.EAST).addModels(new ConfiguredModel(model.apply(2), 0, 270, true))
                .partialState().with(CypressBranchBlock.AGE, 0).with(CypressBranchBlock.FACING, Direction.WEST).addModels(new ConfiguredModel(model.apply(0), 0, 90, true))
                .partialState().with(CypressBranchBlock.AGE, 1).with(CypressBranchBlock.FACING, Direction.WEST).addModels(new ConfiguredModel(model.apply(1), 0, 90, true))
                .partialState().with(CypressBranchBlock.AGE, 2).with(CypressBranchBlock.FACING, Direction.WEST).addModels(new ConfiguredModel(model.apply(2), 0, 90, true));
    }

    private void beardMoss(RegistryObject<Block> beardMoss) {
        String name = this.getItemName(beardMoss.get());

        this.itemModels().withExistingParent(name, "item/generated").texture("layer0", this.modLoc("block/" + name + "_bottom"));
        this.doubleBlockNoItem(beardMoss);
    }

    private void beardMossBlock(RegistryObject<Block> beardMoss) {
        this.simpleBlock(beardMoss.get(), this.models().cubeAll(this.getItemName(beardMoss.get()), this.blockTexture(beardMoss.get())).renderType("cutout"));
        this.itemModel(beardMoss);
    }

    private void lily(RegistryObject<Block> lily, RegistryObject<Block> pot) {
        ResourceLocation flower = this.blockTexture(lily.get());

        this.pot(pot, flower);
        this.simpleBlock(lily.get(), this.models().withExistingParent(this.getItemName(lily.get()), this.modLoc("block/template_lily")).texture("flower", flower).renderType("cutout"));
        this.generatedItem(lily.get(), TextureFolder.Block);
    }

    private void triplePlant(RegistryObject<Block> plant) {
        String name = this.getItemName(plant.get());

        ModelFile top = this.models().withExistingParent(name + "_top", this.modLoc("block/template_triple_plant_top")).texture("cross", this.modLoc("block/" + name + "_middle")).texture("top", this.modLoc("block/" + name + "_top")).renderType("cutout");
        ModelFile bottom =  this.models().withExistingParent(name + "_bottom", this.mcLoc("block/tinted_cross")).texture("cross", this.modLoc("block/" + name + "_bottom")).renderType("cutout");

        this.itemModels().withExistingParent(name, "item/generated").texture("layer0", this.modLoc("block/" + name + "_top"));
        this.getVariantBuilder(plant.get())
                .partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(top))
                .partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(bottom));
    }

    // Generic Block Generators //

    private void pottedPlant(RegistryObject<Block> plant, RegistryObject<Block> pot) {
        this.pot(pot, this.blockTexture(plant.get()));
        this.simpleCross(plant);
        this.generatedItem(plant.get(), TextureFolder.Block);
    }

    private void pot(RegistryObject<Block> pot, ResourceLocation texture) {
        ModelFile model = this.models().withExistingParent(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(pot.get())).getPath(), "block/flower_pot_cross").texture("plant", texture).renderType("cutout");
        this.simpleBlock(pot.get(), model);
    }

    private void trapdoor(RegistryObject<Block> trapdoor) {
        String name = this.getItemName(trapdoor.get());
        this.trapdoorBlockWithRenderType((TrapDoorBlock) trapdoor.get(), this.blockTexture(trapdoor.get()), true, "cutout");
        this.itemModels().withExistingParent(name, this.modLoc("block/" + name + "_bottom"));
    }

    private void door(RegistryObject<Block> door) {
        String name = "block/" + this.getItemName(door.get());
        this.doorBlockWithRenderType((DoorBlock) door.get(), this.getItemName(door.get()).replace("_door", ""), this.modLoc(name + "_bottom"), this.modLoc(name + "_top"), "cutout");
        this.generatedItem(door.get(), TextureFolder.Item);
    }

    private void button(RegistryObject<Block> button, Supplier<Block> textureBlock) {
        ResourceLocation texture = this.blockTexture(textureBlock.get());
        this.buttonBlock((ButtonBlock) button.get(), texture);
        this.itemModels().buttonInventory(this.getItemName(button.get()), texture);
    }

    private void pressurePlate(RegistryObject<Block> pressurePlate, Supplier<Block> textureBlock) {
        this.pressurePlateBlock((PressurePlateBlock) pressurePlate.get(), this.blockTexture(textureBlock.get()));
        this.itemModel(pressurePlate);
    }

    private void fence(RegistryObject<Block> fence, Supplier<Block> textureBlock) {
        ResourceLocation texture = this.blockTexture(textureBlock.get());
        this.fenceBlock((FenceBlock) fence.get(), texture);
        this.itemModels().fenceInventory(this.getItemName(fence.get()), texture);
    }

    private void fenceGate(RegistryObject<Block> gate, Supplier<Block> textureBlock) {
        this.fenceGateBlock((FenceGateBlock) gate.get(), this.blockTexture(textureBlock.get()));
        this.itemModel(gate);
    }

    private void slab(RegistryObject<Block> slab, Supplier<Block> textureBlock) {
        ResourceLocation texture = this.blockTexture(textureBlock.get());
        this.slabBlock((SlabBlock) slab.get(), texture, texture);
        this.itemModel(slab);
    }

    private void stairs(RegistryObject<Block> stairs, Supplier<Block> textureBlock) {
        this.stairsBlock((StairBlock) stairs.get(), this.blockTexture(textureBlock.get()));
        this.itemModel(stairs);
    }

    private void cubeAll(RegistryObject<Block> block) {
        this.simpleBlock(block.get());
        this.itemModel(block);
    }

    private void cubeAll(RegistryObject<Block> block, ResourceLocation texture) {
        this.simpleBlock(block.get(), this.models().cubeAll(this.getItemName(block.get()), texture));
        this.itemModel(block);
    }

    private void leaves(RegistryObject<Block> leaves) {
        this.simpleBlock(leaves.get(), this.models().withExistingParent(this.getItemName(leaves.get()), "block/leaves").texture("all", this.blockTexture(leaves.get())).renderType("cutout"));
        this.itemModel(leaves);
    }

    private void simpleCross(RegistryObject<Block> block) {
        this.simpleBlock(block.get(), this.models().cross(this.getItemName(block.get()), this.blockTexture(block.get())).renderType("cutout"));
    }

    private void signs(Pair<RegistryObject<BlueprintStandingSignBlock>, RegistryObject<BlueprintWallSignBlock>> signs, Supplier<Block> textureBlock) {
        this.signBlock(signs.getFirst().get(), signs.getSecond().get(), this.blockTexture(textureBlock.get()));
        this.generatedItem(signs.getFirst().get(), TextureFolder.Item);
    }

    private void log(RegistryObject<Block> log) {
        this.axisBlock((RotatedPillarBlock)log.get(), this.blockTexture(log.get()), this.modLoc("block/" + this.getItemName(log.get()) + "_top"));
        this.itemModel(log);
    }

    private void beehive(RegistryObject<Block> beehive) {
        String name = this.getItemName(beehive.get());
        ModelFile model = this.models().orientable(name, this.modLoc("block/" + name + "_side"), this.modLoc("block/" + name + "_front"), this.modLoc("block/" + name + "_end"));
        ModelFile model_honey = this.models().orientable(name + "_honey", this.modLoc("block/" + name + "_side"), this.modLoc("block/" + name + "_front_honey"), this.modLoc("block/" + name + "_end"));

        this.horizontalBlock(beehive.get(), s -> s.getValue(BeehiveBlock.HONEY_LEVEL) == 5 ? model_honey : model);
        this.itemModel(beehive);
    }

    private void hedge(RegistryObject<Block> hedge, Supplier<Block> leaves, Supplier<Block> log) {
        String name = this.getItemName(hedge.get());
        ModelFile post = this.models().withExistingParent(name + "_post", "blueprint:block/hedge_post").texture("leaf", this.blockTexture(leaves.get())).texture("log", this.blockTexture(log.get())).renderType("cutout");
        ModelFile side = this.models().withExistingParent(name + "_side", "blueprint:block/hedge_side").texture("leaf", this.blockTexture(leaves.get())).renderType("cutout");
        ModelFile extend = this.models().withExistingParent(name + "_extend", "blueprint:block/hedge_extend").texture("leaf", this.blockTexture(leaves.get())).renderType("cutout");

        this.itemModels().withExistingParent(name, this.modLoc("block/" + name + "_post"));
        this.getMultipartBuilder(hedge.get())
                .part().modelFile(post).addModel().condition(BooleanProperty.create("extend"), false).end()
                .part().modelFile(extend).addModel().condition(BooleanProperty.create("extend"), true).end()
                .part().modelFile(side).uvLock(true).addModel().condition(CrossCollisionBlock.NORTH, true).end()
                .part().modelFile(side).uvLock(true).rotationY(90).addModel().condition(CrossCollisionBlock.EAST, true).end()
                .part().modelFile(side).uvLock(true).rotationY(180).addModel().condition(CrossCollisionBlock.SOUTH, true).end()
                .part().modelFile(side).uvLock(true).rotationY(270).addModel().condition(CrossCollisionBlock.WEST, true).end();
    }

    private void chests(RegistryObject<BlueprintChestBlock> chest, RegistryObject<BlueprintTrappedChestBlock> trapped, Supplier<Block> textureBlock) {
        ModelFile model =  this.models().getBuilder(this.getItemName(chest.get())).texture("particle", this.blockTexture(textureBlock.get()));
        this.simpleBlock(chest.get(), model);
        this.simpleBlock(trapped.get(), model);
        this.itemModels().withExistingParent(this.getItemName(chest.get()), "blueprint:item/template_chest");
        this.itemModels().withExistingParent(this.getItemName(trapped.get()), "blueprint:item/template_chest");
    }

    private void leafCarpet(RegistryObject<Block> carpet, Supplier<Block> textureBlock) {
        this.simpleBlock(carpet.get(), this.models().withExistingParent(this.getItemName(carpet.get()), "blueprint:block/leaf_carpet").texture("all", this.blockTexture(textureBlock.get())).renderType("cutout"));
        this.itemModel(carpet);
    }

    private void post(RegistryObject<Block> post, Supplier<Block> textureBlock) {
        ModelFile model = this.models().withExistingParent(this.getItemName(post.get()), "blueprint:block/post").texture("texture", this.blockTexture(textureBlock.get()));
        ModelFile chain = this.models().getExistingFile(Blueprint.REGISTRY_HELPER.prefix("block/chain_small"));
        ModelFile chainTop = this.models().getExistingFile(Blueprint.REGISTRY_HELPER.prefix("block/chain_small_top"));

        this.itemModel(post);
        this.getMultipartBuilder(post.get())
                .part().modelFile(model).addModel().condition(BlockStateProperties.AXIS, Direction.Axis.Y).end()
                .part().modelFile(model).rotationX(90).rotationY(90).addModel().condition(BlockStateProperties.AXIS, Direction.Axis.X).end()
                .part().modelFile(model).rotationX(90).addModel().condition(BlockStateProperties.AXIS, Direction.Axis.Z).end()
                .part().modelFile(chain).addModel().condition(BooleanProperty.create("chain_down"), true).end()
                .part().modelFile(chainTop).addModel().condition(BooleanProperty.create("chain_up"), true).end()
                .part().modelFile(chainTop).rotationX(90).addModel().condition(BooleanProperty.create("chain_north"), true).end()
                .part().modelFile(chain).rotationX(90).addModel().condition(BooleanProperty.create("chain_south"), true).end()
                .part().modelFile(chainTop).rotationX(90).rotationY(90).addModel().condition(BooleanProperty.create("chain_east"), true).end()
                .part().modelFile(chain).rotationX(90).rotationY(90).addModel().condition(BooleanProperty.create("chain_west"), true).end();
    }

    private void leafPile(RegistryObject<Block> leafPile, Supplier<Block> textureBlock, boolean tinted) {
        String name = this.getItemName(leafPile.get());
        ModelFile model = this.models().withExistingParent(name, "blueprint:block/" + (tinted ? "tinted_" : "") + "leaf_pile").texture("all", this.blockTexture(textureBlock.get())).renderType("cutout");

        this.itemModels().withExistingParent(name, "item/generated").texture("layer0", this.modLoc("block/" + this.getItemName(textureBlock.get())));
        this.getMultipartBuilder(leafPile.get())
                .part().modelFile(model).uvLock(true).rotationX(270).addModel().condition(BlockStateProperties.UP, true).end()
                .part().modelFile(model).uvLock(true).rotationX(90).addModel().condition(BlockStateProperties.DOWN, true).end()
                .part().modelFile(model).addModel().condition(BlockStateProperties.NORTH, true).end()
                .part().modelFile(model).uvLock(true).rotationY(180).addModel().condition(BlockStateProperties.SOUTH, true).end()
                .part().modelFile(model).uvLock(true).rotationY(90).addModel().condition(BlockStateProperties.EAST, true).end()
                .part().modelFile(model).uvLock(true).rotationY(270).addModel().condition(BlockStateProperties.WEST, true).end();
    }

    private void verticalSlab(RegistryObject<Block> slab, Supplier<Block> textureBlock) {
        ResourceLocation texture = this.blockTexture(textureBlock.get());
        ModelFile model = this.models().withExistingParent(this.getItemName(slab.get()), "blueprint:block/vertical_slab").texture("top", texture).texture("bottom", texture).texture("side", texture);

        this.itemModel(slab);
        this.getVariantBuilder(slab.get())
                .partialState().with(VerticalSlabBlock.TYPE, VerticalSlabBlock.VerticalSlabType.NORTH).addModels(new ConfiguredModel(model, 0, 0, true))
                .partialState().with(VerticalSlabBlock.TYPE, VerticalSlabBlock.VerticalSlabType.SOUTH).addModels(new ConfiguredModel(model, 0, 180, true))
                .partialState().with(VerticalSlabBlock.TYPE, VerticalSlabBlock.VerticalSlabType.EAST).addModels(new ConfiguredModel(model, 0, 90, true))
                .partialState().with(VerticalSlabBlock.TYPE, VerticalSlabBlock.VerticalSlabType.WEST).addModels(new ConfiguredModel(model, 0, 270, true))
                .partialState().with(VerticalSlabBlock.TYPE, VerticalSlabBlock.VerticalSlabType.DOUBLE).addModels(new ConfiguredModel(this.models().getExistingFile(texture)));
    }

    private void verticalPlanks(RegistryObject<Block> planks, Supplier<Block> textureBlock) {
        ResourceLocation texture = this.blockTexture(textureBlock.get());
        ModelFile model = this.models().withExistingParent(this.getItemName(planks.get()), "blueprint:block/vertical_planks").texture("all", texture);

        this.itemModel(planks);
        this.simpleBlock(planks.get(), model);
    }

    private void boards(RegistryObject<Block> boards) {
        String name = this.getItemName(boards.get());
        ResourceLocation texture = this.blockTexture(boards.get());
        ModelFile boardsModel = models().getBuilder(name).parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Blueprint.MOD_ID, "block/template_boards"))).texture("all", texture);
        ModelFile boardsHorizontalModel = models().getBuilder(name + "_horizontal").parent(new ModelFile.UncheckedModelFile(new ResourceLocation(Blueprint.MOD_ID, "block/template_boards_horizontal"))).texture("all", texture);

        this.itemModel(boards);
        this.getVariantBuilder(boards.get())
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Y).modelForState().modelFile(boardsModel).addModel()
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Z).modelForState().modelFile(boardsHorizontalModel).addModel()
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.X).modelForState().modelFile(boardsHorizontalModel).rotationY(270).addModel();
    }

    private void bookshelf(RegistryObject<Block> bookshelf, Supplier<Block> planks) {
        this.simpleBlock(bookshelf.get(), this.models().cubeColumn(this.getItemName(bookshelf.get()), this.blockTexture(bookshelf.get()), this.blockTexture(planks.get())));
        this.itemModel(bookshelf);
    }

    private void ladder(RegistryObject<Block> ladder) {
        ResourceLocation texture = this.blockTexture(ladder.get());

        this.horizontalBlock(ladder.get(), this.models().withExistingParent(this.getItemName(ladder.get()), "block/ladder").texture("particle", texture).renderType("cutout").texture("texture", texture));
        this.generatedItem(ladder.get(), TextureFolder.Block);
    }

    private void cubeBottomTop(RegistryObject<Block> block) {
        String name = this.getItemName(block.get());

        this.simpleBlock(block.get(), this.models().cubeBottomTop(name, this.modLoc("block/" + name + "_side"), this.modLoc("block/" + name + "_bottom"), this.modLoc("block/" + name + "_top")));
        this.itemModel(block);
    }

    private void thatch(RegistryObject<Block> thatch) {
        String name = this.getItemName(thatch.get());
        ResourceLocation texture = this.blockTexture(thatch.get());
        ResourceLocation extrudes = this.modLoc("block/" + name + "_extrudes");

        this.simpleBlock(thatch.get(), this.models().withExistingParent(name, "blueprint:block/thatch/thatch").texture("thatch", texture).texture("extrudes", extrudes).renderType("cutout"));
        this.itemModel(thatch);
    }

    private void thatchSlab(RegistryObject<Block> thatch, Supplier<Block> textureBlock) {
        String name = this.getItemName(thatch.get());
        ResourceLocation texture = this.blockTexture(textureBlock.get());
        ResourceLocation extrudes = this.modLoc("block/" +  this.getItemName(textureBlock.get()) + "_extrudes");

        ModelFile bottom = this.models().withExistingParent(name, "blueprint:block/thatch/thatch_slab").texture("thatch", texture).texture("extrudes", extrudes).renderType("cutout");
        ModelFile top = this.models().withExistingParent(name + "_top", "blueprint:block/thatch/thatch_slab_top").texture("thatch", texture).texture("extrudes", extrudes).renderType("cutout");

        this.slabBlock((SlabBlock) thatch.get(), bottom, top, this.models().getExistingFile(ForgeRegistries.BLOCKS.getKey(textureBlock.get())));
        this.itemModel(thatch);
    }

    private void thatchStairs(RegistryObject<Block> thatch, Supplier<Block> textureBlock) {
        String name = this.getItemName(thatch.get());
        ResourceLocation texture = this.blockTexture(textureBlock.get());
        ResourceLocation extrudes = this.modLoc("block/" +  this.getItemName(textureBlock.get()) + "_extrudes");

        ModelFile stairs = this.models().withExistingParent(name, "blueprint:block/thatch/thatch_stairs").texture("thatch", texture).texture("extrudes", extrudes).renderType("cutout");
        ModelFile inner = this.models().withExistingParent(name + "_inner", "blueprint:block/thatch/thatch_stairs_inner").texture("thatch", texture).texture("extrudes", extrudes).renderType("cutout");
        ModelFile outer = this.models().withExistingParent(name + "_outer", "blueprint:block/thatch/thatch_stairs_outer").texture("thatch", texture).texture("extrudes", extrudes).renderType("cutout");
        ModelFile inner_top = this.models().withExistingParent(name + "_inner_top", "blueprint:block/thatch/thatch_stairs_inner_top").texture("thatch", texture).texture("extrudes", extrudes).renderType("cutout");
        ModelFile outer_top = this.models().withExistingParent(name + "_outer_top", "blueprint:block/thatch/thatch_stairs_outer_top").texture("thatch", texture).texture("extrudes", extrudes).renderType("cutout");
        ModelFile top = this.models().withExistingParent(name + "_top", "blueprint:block/thatch/thatch_stairs_top").texture("thatch", texture).texture("extrudes", extrudes).renderType("cutout");

        this.itemModel(thatch);
        this.getVariantBuilder(thatch.get())
                .forAllStatesExcept(state -> {
                    Direction facing = state.getValue(StairBlock.FACING);
                    Half half = state.getValue(StairBlock.HALF);
                    StairsShape shape = state.getValue(StairBlock.SHAPE);
                    int yRot = (int) facing.getClockWise().toYRot();

                    if (shape == StairsShape.INNER_LEFT || shape == StairsShape.OUTER_LEFT) yRot += 270;
                    if (half == Half.TOP && shape == StairsShape.STRAIGHT) yRot += 180;
                    if (half == Half.TOP && (shape == StairsShape.INNER_LEFT || shape == StairsShape.INNER_RIGHT)) yRot += 90;

                    yRot %= 360;

                    return ConfiguredModel.builder().modelFile(shape == StairsShape.STRAIGHT ? (half == Half.BOTTOM ? stairs : top)
                            : shape == StairsShape.INNER_LEFT || shape == StairsShape.INNER_RIGHT ? (half == Half.BOTTOM ? inner : inner_top)
                            : (half == Half.BOTTOM ? outer : outer_top)).rotationY(yRot).uvLock(true).build();
                }, StairBlock.WATERLOGGED);
    }

    private void thatchVerticalSlab(RegistryObject<Block> thatch, Supplier<Block> textureBlock) {
        ResourceLocation texture = this.blockTexture(textureBlock.get());
        ResourceLocation extrudes = this.modLoc("block/" +  this.getItemName(textureBlock.get()) + "_extrudes");
        ModelFile model = this.models().withExistingParent(this.getItemName(thatch.get()), "blueprint:block/thatch/thatch_vertical_slab").texture("thatch", texture).texture("extrudes", extrudes).renderType("cutout");

        this.itemModel(thatch);
        this.getVariantBuilder(thatch.get())
                .partialState().with(VerticalSlabBlock.TYPE, VerticalSlabBlock.VerticalSlabType.NORTH).addModels(new ConfiguredModel(model, 0, 0, true))
                .partialState().with(VerticalSlabBlock.TYPE, VerticalSlabBlock.VerticalSlabType.SOUTH).addModels(new ConfiguredModel(model, 0, 180, true))
                .partialState().with(VerticalSlabBlock.TYPE, VerticalSlabBlock.VerticalSlabType.EAST).addModels(new ConfiguredModel(model, 0, 90, true))
                .partialState().with(VerticalSlabBlock.TYPE, VerticalSlabBlock.VerticalSlabType.WEST).addModels(new ConfiguredModel(model, 0, 270, true))
                .partialState().with(VerticalSlabBlock.TYPE, VerticalSlabBlock.VerticalSlabType.DOUBLE).addModels(new ConfiguredModel(this.models().getExistingFile(texture)));
    }

    private void cabinet(RegistryObject<Block> cabinet) {
        String name = this.getItemName(cabinet.get());
        ModelFile model = this.models().orientable(name, this.modLoc("block/" + name + "_side"), this.modLoc("block/" + name + "_front"), this.modLoc("block/" + name + "_end"));
        ModelFile model_open = this.models().orientable(name + "_open", this.modLoc("block/" + name + "_side"), this.modLoc("block/" + name + "_front_open"), this.modLoc("block/" + name + "_end"));

        this.horizontalBlock(cabinet.get(), s -> s.getValue(BlockStateProperties.OPEN) ? model_open : model);
        this.itemModel(cabinet);
    }

    private void doubleBlockNoItem(RegistryObject<Block> block) {
        String name = this.getItemName(block.get());
        Function<String, ModelFile> model = s -> this.models().cross(name + "_" + s, this.modLoc("block/" + name + "_" + s)).renderType("cutout");

        this.getVariantBuilder(block.get())
                .partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER).addModels(new ConfiguredModel(model.apply("top")))
                .partialState().with(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER).addModels(new ConfiguredModel(model.apply("bottom")));
    }

    private void wall(RegistryObject<? extends Block> wall, Supplier<? extends Block> textureBlock) {
        ResourceLocation texture = this.blockTexture(textureBlock.get());
        this.wallBlock((WallBlock) wall.get(), texture);
        this.itemModels().wallInventory(this.getItemName(wall.get()), texture);
    }

    // Misc Util //

    private void itemModel(RegistryObject<Block> block) {
        this.itemModels().withExistingParent(this.getItemName(block.get()), this.blockTexture(block.get()));
    }

    private void generatedItem(ItemLike item, TextureFolder folder) {
        String name = this.getItemName(item);
        this.itemModels().withExistingParent(name, "item/generated").texture("layer0", this.modLoc(folder.format(name)));
    }

    private String getItemName(ItemLike item) {
        return ForgeRegistries.ITEMS.getKey(item.asItem()).getPath();
    }

    private enum TextureFolder {
        Item, Block;

        public String format(String itemName) {
            return this.name().toLowerCase() + '/' + itemName;
        }
    }
}