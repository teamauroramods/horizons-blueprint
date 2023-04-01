package com.teamaurora.horizons.core.data.server.tags;

import com.teamabnormals.blueprint.core.other.tags.BlueprintBlockTags;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.other.tags.HorizonsBlockTags;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.data.event.GatherDataEvent;

/**
 * @author rose_
 */
public class HorizonsBlockTagsProvider extends BlockTagsProvider {
    public static BlockTagsProvider INSTANCE;

    public HorizonsBlockTagsProvider(GatherDataEvent event) {
        super(event.getGenerator(), Horizons.MODID, event.getExistingFileHelper());
        INSTANCE = this;
    }

    @Override
    protected void addTags() {
        //horizons
        this.tag(HorizonsBlockTags.CYPRESS_LOGS).add(HorizonsBlocks.CYPRESS_LOG.get(), HorizonsBlocks.CYPRESS_WOOD.get(), HorizonsBlocks.STRIPPED_CYPRESS_LOG.get(), HorizonsBlocks.STRIPPED_CYPRESS_WOOD.get());
        this.tag(HorizonsBlockTags.CYPRESS_LEAVES).add(HorizonsBlocks.CYPRESS_LEAVES.get());
        this.tag(HorizonsBlockTags.REDWOOD_LOGS).add(HorizonsBlocks.REDWOOD_LOG.get(), HorizonsBlocks.REDWOOD.get(), HorizonsBlocks.STRIPPED_REDWOOD_LOG.get(), HorizonsBlocks.STRIPPED_REDWOOD.get());
        this.tag(HorizonsBlockTags.REDWOOD_LEAVES).add(HorizonsBlocks.REDWOOD_LEAVES.get());
        this.tag(HorizonsBlockTags.REDBUD_LOGS).add(HorizonsBlocks.REDBUD_LOG.get(), HorizonsBlocks.REDBUD_WOOD.get(), HorizonsBlocks.STRIPPED_REDBUD_LOG.get(), HorizonsBlocks.STRIPPED_REDBUD_WOOD.get(), HorizonsBlocks.FLOWERING_REDBUD_LOG.get(), HorizonsBlocks.FLOWERING_REDBUD_WOOD.get());
        this.tag(HorizonsBlockTags.REDBUD_LEAVES).add(HorizonsBlocks.REDBUD_LEAVES.get(), HorizonsBlocks.BUDDING_REDBUD_LEAVES.get(), HorizonsBlocks.FLOWERING_REDBUD_LEAVES.get());

        this.tag(HorizonsBlockTags.JACARANDA_LOGS).add(HorizonsBlocks.JACARANDA_LOG.get(), HorizonsBlocks.JACARANDA_WOOD.get(), HorizonsBlocks.STRIPPED_JACARANDA_LOG.get(), HorizonsBlocks.STRIPPED_JACARANDA_WOOD.get());
        this.tag(HorizonsBlockTags.JACARANDA_LEAVES).add(HorizonsBlocks.JACARANDA_LEAVES.get(), HorizonsBlocks.BUDDING_JACARANDA_LEAVES.get(), HorizonsBlocks.FLOWERING_JACARANDA_LEAVES.get(), HorizonsBlocks.AZURE_JACARANDA_LEAVES.get(), HorizonsBlocks.BUDDING_AZURE_JACARANDA_LEAVES.get(), HorizonsBlocks.FLOWERING_AZURE_JACARANDA_LEAVES.get());

        //quark
        this.tag(BlueprintBlockTags.VERTICAL_SLABS).add(HorizonsBlocks.ALGAE_THATCH_VERTICAL_SLAB.get(), HorizonsBlocks.LIGHT_BOULDER_VERTICAL_SLAB.get(), HorizonsBlocks.DARK_BOULDER_VERTICAL_SLAB.get(), HorizonsBlocks.MOSSY_LIGHT_BOULDER_VERTICAL_SLAB.get(), HorizonsBlocks.MOSSY_DARK_BOULDER_VERTICAL_SLAB.get(), HorizonsBlocks.BOULDER_BRICK_VERTICAL_SLAB.get());
        this.tag(BlueprintBlockTags.WOODEN_VERTICAL_SLABS).add(HorizonsBlocks.CYPRESS_VERTICAL_SLAB.get(), HorizonsBlocks.REDWOOD_VERTICAL_SLAB.get(), HorizonsBlocks.REDBUD_VERTICAL_SLAB.get(), HorizonsBlocks.JACARANDA_VERTICAL_SLAB.get());
        this.tag(BlueprintBlockTags.HEDGES).add(HorizonsBlocks.CYPRESS_HEDGE.get(), HorizonsBlocks.REDWOOD_HEDGE.get(), HorizonsBlocks.REDBUD_HEDGE.get(), HorizonsBlocks.BUDDING_REDBUD_HEDGE.get(), HorizonsBlocks.FLOWERING_REDBUD_HEDGE.get(), HorizonsBlocks.JACARANDA_HEDGE.get(), HorizonsBlocks.BUDDING_JACARANDA_HEDGE.get(), HorizonsBlocks.FLOWERING_JACARANDA_HEDGE.get(), HorizonsBlocks.AZURE_JACARANDA_HEDGE.get(), HorizonsBlocks.BUDDING_AZURE_JACARANDA_HEDGE.get(), HorizonsBlocks.FLOWERING_AZURE_JACARANDA_HEDGE.get());
        this.tag(BlueprintBlockTags.LADDERS).add(HorizonsBlocks.CYPRESS_LADDER.get(), HorizonsBlocks.REDWOOD_LADDER.get(), HorizonsBlocks.REDBUD_LADDER.get(), HorizonsBlocks.JACARANDA_LADDER.get());

        //woodworks
        this.tag(BlueprintBlockTags.LEAF_PILES).add(HorizonsBlocks.CYPRESS_LEAF_PILE.get(), HorizonsBlocks.REDWOOD_LEAF_PILE.get(), HorizonsBlocks.REDBUD_LEAF_PILE.get(), HorizonsBlocks.BUDDING_REDBUD_LEAF_PILE.get(), HorizonsBlocks.FLOWERING_REDBUD_LEAF_PILE.get(), HorizonsBlocks.JACARANDA_LEAF_PILE.get(), HorizonsBlocks.BUDDING_JACARANDA_LEAF_PILE.get(), HorizonsBlocks.FLOWERING_JACARANDA_LEAF_PILE.get(), HorizonsBlocks.AZURE_JACARANDA_LEAF_PILE.get(), HorizonsBlocks.BUDDING_AZURE_JACARANDA_LEAF_PILE.get(), HorizonsBlocks.FLOWERING_AZURE_JACARANDA_LEAF_PILE.get(), HorizonsBlocks.REDBUD_BLOSSOMS_LEAF_PILE.get());

        //forge
        this.tag(Tags.Blocks.CHESTS_WOODEN).add(HorizonsBlocks.CYPRESS_CHEST.get(), HorizonsBlocks.CYPRESS_TRAPPED_CHEST.get(), HorizonsBlocks.REDWOOD_CHEST.get(), HorizonsBlocks.REDWOOD_TRAPPED_CHEST.get(), HorizonsBlocks.REDBUD_CHEST.get(), HorizonsBlocks.REDBUD_TRAPPED_CHEST.get(), HorizonsBlocks.JACARANDA_CHEST.get(), HorizonsBlocks.JACARANDA_TRAPPED_CHEST.get());
        this.tag(Tags.Blocks.CHESTS_TRAPPED).add(HorizonsBlocks.CYPRESS_TRAPPED_CHEST.get(), HorizonsBlocks.REDWOOD_TRAPPED_CHEST.get(), HorizonsBlocks.REDBUD_TRAPPED_CHEST.get(), HorizonsBlocks.JACARANDA_TRAPPED_CHEST.get());

        //minecraft
        this.tag(BlockTags.SLABS).add(HorizonsBlocks.ALGAE_THATCH_SLAB.get(), HorizonsBlocks.LIGHT_BOULDER_SLAB.get(), HorizonsBlocks.DARK_BOULDER_SLAB.get(), HorizonsBlocks.MOSSY_LIGHT_BOULDER_SLAB.get(), HorizonsBlocks.MOSSY_DARK_BOULDER_SLAB.get(), HorizonsBlocks.BOULDER_BRICK_SLAB.get());
        this.tag(BlockTags.STAIRS).add(HorizonsBlocks.ALGAE_THATCH_STAIRS.get(), HorizonsBlocks.LIGHT_BOULDER_STAIRS.get(), HorizonsBlocks.DARK_BOULDER_STAIRS.get(), HorizonsBlocks.MOSSY_LIGHT_BOULDER_STAIRS.get(), HorizonsBlocks.MOSSY_DARK_BOULDER_STAIRS.get(), HorizonsBlocks.BOULDER_BRICK_STAIRS.get());
        this.tag(BlockTags.WALLS).add(HorizonsBlocks.LIGHT_BOULDER_WALL.get(), HorizonsBlocks.DARK_BOULDER_WALL.get(), HorizonsBlocks.MOSSY_LIGHT_BOULDER_WALL.get(), HorizonsBlocks.MOSSY_DARK_BOULDER_WALL.get(), HorizonsBlocks.BOULDER_BRICK_WALL.get());
        this.tag(BlockTags.BEEHIVES).add(HorizonsBlocks.CYPRESS_BEEHIVE.get(), HorizonsBlocks.REDWOOD_BEEHIVE.get(), HorizonsBlocks.REDBUD_BEEHIVE.get(), HorizonsBlocks.JACARANDA_BEEHIVE.get());
        this.tag(BlockTags.WOODEN_BUTTONS).add(HorizonsBlocks.CYPRESS_BUTTON.get(), HorizonsBlocks.REDWOOD_BUTTON.get(), HorizonsBlocks.REDBUD_BUTTON.get(), HorizonsBlocks.JACARANDA_BUTTON.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(HorizonsBlocks.CYPRESS_PRESSURE_PLATE.get(), HorizonsBlocks.REDWOOD_PRESSURE_PLATE.get(), HorizonsBlocks.REDBUD_PRESSURE_PLATE.get(), HorizonsBlocks.JACARANDA_PRESSURE_PLATE.get());
        this.tag(BlockTags.PLANKS).add(HorizonsBlocks.CYPRESS_PLANKS.get(), HorizonsBlocks.VERTICAL_CYPRESS_PLANKS.get(), HorizonsBlocks.REDWOOD_PLANKS.get(), HorizonsBlocks.VERTICAL_REDWOOD_PLANKS.get(), HorizonsBlocks.REDBUD_PLANKS.get(), HorizonsBlocks.VERTICAL_REDBUD_PLANKS.get(), HorizonsBlocks.JACARANDA_PLANKS.get(), HorizonsBlocks.VERTICAL_JACARANDA_PLANKS.get());
        this.tag(BlockTags.WOODEN_DOORS).add(HorizonsBlocks.CYPRESS_DOOR.get(), HorizonsBlocks.REDWOOD_DOOR.get(), HorizonsBlocks.REDBUD_DOOR.get(), HorizonsBlocks.JACARANDA_DOOR.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(HorizonsBlocks.CYPRESS_TRAPDOOR.get(), HorizonsBlocks.REDWOOD_TRAPDOOR.get(), HorizonsBlocks.REDBUD_TRAPDOOR.get(), HorizonsBlocks.JACARANDA_TRAPDOOR.get());
        this.tag(BlockTags.WOODEN_STAIRS).add(HorizonsBlocks.CYPRESS_STAIRS.get(), HorizonsBlocks.REDWOOD_STAIRS.get(), HorizonsBlocks.REDBUD_STAIRS.get(), HorizonsBlocks.JACARANDA_STAIRS.get());
        this.tag(BlockTags.WOODEN_SLABS).add(HorizonsBlocks.CYPRESS_SLAB.get(), HorizonsBlocks.REDWOOD_SLAB.get(), HorizonsBlocks.REDBUD_SLAB.get(), HorizonsBlocks.JACARANDA_SLAB.get());
        this.tag(BlockTags.WALL_SIGNS).add(HorizonsBlocks.CYPRESS_SIGNS.getSecond().get(), HorizonsBlocks.REDWOOD_SIGNS.getSecond().get(), HorizonsBlocks.REDBUD_SIGNS.getSecond().get(), HorizonsBlocks.JACARANDA_SIGNS.getSecond().get());
        this.tag(BlockTags.STANDING_SIGNS).add(HorizonsBlocks.CYPRESS_SIGNS.getFirst().get(), HorizonsBlocks.REDWOOD_SIGNS.getFirst().get(), HorizonsBlocks.REDBUD_SIGNS.getFirst().get(), HorizonsBlocks.JACARANDA_SIGNS.getFirst().get());
        this.tag(BlockTags.WOODEN_FENCES).add(HorizonsBlocks.CYPRESS_FENCE.get(), HorizonsBlocks.REDWOOD_FENCE.get(), HorizonsBlocks.REDBUD_FENCE_GATE.get(), HorizonsBlocks.JACARANDA_FENCE_GATE.get());
        this.tag(BlockTags.LOGS_THAT_BURN).addTag(HorizonsBlockTags.CYPRESS_LOGS).addTag(HorizonsBlockTags.REDWOOD_LOGS).addTag(HorizonsBlockTags.REDBUD_LOGS).addTag(HorizonsBlockTags.JACARANDA_LOGS);
        this.tag(BlockTags.LEAVES).addTag(HorizonsBlockTags.CYPRESS_LEAVES).addTag(HorizonsBlockTags.REDWOOD_LEAVES).addTag(HorizonsBlockTags.REDBUD_LEAVES).addTag(HorizonsBlockTags.JACARANDA_LEAVES);
        this.tag(BlockTags.CLIMBABLE).add(HorizonsBlocks.CYPRESS_LADDER.get(), HorizonsBlocks.BEARD_MOSS.get(), HorizonsBlocks.REDWOOD_LADDER.get(), HorizonsBlocks.REDBUD_LADDER.get(), HorizonsBlocks.JACARANDA_LADDER.get());
        this.tag(BlockTags.FENCE_GATES).add(HorizonsBlocks.CYPRESS_FENCE_GATE.get(), HorizonsBlocks.REDWOOD_FENCE_GATE.get(), HorizonsBlocks.REDBUD_FENCE_GATE.get(), HorizonsBlocks.JACARANDA_FENCE.get());
        this.tag(BlockTags.SAPLINGS).add(HorizonsBlocks.CYPRESS_SAPLING.get(), HorizonsBlocks.REDWOOD_SAPLING.get(), HorizonsBlocks.REDBUD_SAPLING.get(), HorizonsBlocks.FLOWERING_REDBUD_SAPLING.get(), HorizonsBlocks.JACARANDA_SAPLING.get(), HorizonsBlocks.AZURE_JACARANDA_SAPLING.get());
        this.tag(BlockTags.REPLACEABLE_PLANTS).add(HorizonsBlocks.GIANT_FERN.get());
        this.tag(BlockTags.TALL_FLOWERS).add(HorizonsBlocks.HELICONIA.get());
        this.tag(BlockTags.FLOWER_POTS).add(HorizonsBlocks.POTTED_CYPRESS_SAPLING.get(), HorizonsBlocks.POTTED_REDWOOD_SAPLING.get(), HorizonsBlocks.POTTED_REDBUD_SAPLING.get(), HorizonsBlocks.POTTED_FLOWERING_REDBUD_SAPLING.get(), HorizonsBlocks.POTTED_BLUE_LILY.get(), HorizonsBlocks.POTTED_LIGHT_GRAY_LILY.get(), HorizonsBlocks.POTTED_CYAN_LILY.get(), HorizonsBlocks.POTTED_LIGHT_BLUE_LILY.get(), HorizonsBlocks.POTTED_MAGENTA_LILY.get(), HorizonsBlocks.POTTED_PINK_LILY.get(), HorizonsBlocks.POTTED_PURPLE_LILY.get(), HorizonsBlocks.POTTED_WHITE_LILY.get(), HorizonsBlocks.POTTED_YELLOW_DAISY.get(), HorizonsBlocks.POTTED_RED_DAISY.get(), HorizonsBlocks.POTTED_PURPLE_DAISY.get(), HorizonsBlocks.POTTED_PINK_DAISY.get(), HorizonsBlocks.POTTED_ORANGE_DAISY.get(), HorizonsBlocks.POTTED_MAGENTA_DAISY.get(), HorizonsBlocks.POTTED_BLUE_DAISY.get(), HorizonsBlocks.POTTED_AMARANTHUS.get(), HorizonsBlocks.POTTED_MYOSOTIS.get(), HorizonsBlocks.POTTED_FIDDLENECK.get());
        this.tag(BlockTags.SMALL_FLOWERS).add(HorizonsBlocks.BLUE_LILY.get(), HorizonsBlocks.LIGHT_GRAY_LILY.get(), HorizonsBlocks.CYAN_LILY.get(), HorizonsBlocks.LIGHT_BLUE_LILY.get(), HorizonsBlocks.MAGENTA_LILY.get(), HorizonsBlocks.PINK_LILY.get(), HorizonsBlocks.PURPLE_LILY.get(), HorizonsBlocks.WHITE_LILY.get(), HorizonsBlocks.YELLOW_DAISY.get(), HorizonsBlocks.RED_DAISY.get(), HorizonsBlocks.PURPLE_DAISY.get(), HorizonsBlocks.PINK_DAISY.get(), HorizonsBlocks.ORANGE_DAISY.get(), HorizonsBlocks.MAGENTA_DAISY.get(), HorizonsBlocks.BLUE_DAISY.get(), HorizonsBlocks.AMARANTHUS.get(), HorizonsBlocks.MYOSOTIS.get(), HorizonsBlocks.FIDDLENECK.get());
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(HorizonsBlocks.ALGAE.get(), HorizonsBlocks.ALGAE_THATCH.get(), HorizonsBlocks.ALGAE_THATCH_SLAB.get(), HorizonsBlocks.ALGAE_THATCH_STAIRS.get(), HorizonsBlocks.ALGAE_THATCH_VERTICAL_SLAB.get(), HorizonsBlocks.CYPRESS_LEAVES.get(), HorizonsBlocks.CYPRESS_LEAF_CARPET.get(), HorizonsBlocks.HANGING_CYPRESS_LEAVES.get(), HorizonsBlocks.BEARD_MOSS_BLOCK.get(), HorizonsBlocks.BEARD_MOSS.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(
                HorizonsBlocks.CYPRESS_BOOKSHELF.get(), HorizonsBlocks.CYPRESS_VERTICAL_SLAB.get(), HorizonsBlocks.CYPRESS_LADDER.get(), HorizonsBlocks.CYPRESS_HEDGE.get(), HorizonsBlocks.CYPRESS_CHEST.get(), HorizonsBlocks.CYPRESS_TRAPPED_CHEST.get(), HorizonsBlocks.CYPRESS_POST.get(), HorizonsBlocks.STRIPPED_CYPRESS_POST.get(), HorizonsBlocks.CYPRESS_BEEHIVE.get(), HorizonsBlocks.CYPRESS_BOARDS.get(), HorizonsBlocks.CYPRESS_KNEE.get(), HorizonsBlocks.LARGE_CYPRESS_KNEE.get(), HorizonsBlocks.STRIPPED_CYPRESS_KNEE.get(), HorizonsBlocks.STRIPPED_LARGE_CYPRESS_KNEE.get(), HorizonsBlocks.CYPRESS_BRANCH.get(), HorizonsBlocks.CYPRESS_CABINET.get(),
                HorizonsBlocks.REDWOOD_BOOKSHELF.get(), HorizonsBlocks.REDWOOD_VERTICAL_SLAB.get(), HorizonsBlocks.REDWOOD_LADDER.get(), HorizonsBlocks.REDWOOD_HEDGE.get(), HorizonsBlocks.REDWOOD_CHEST.get(), HorizonsBlocks.REDWOOD_TRAPPED_CHEST.get(), HorizonsBlocks.REDWOOD_POST.get(), HorizonsBlocks.STRIPPED_REDWOOD_POST.get(), HorizonsBlocks.REDWOOD_BEEHIVE.get(), HorizonsBlocks.REDWOOD_BOARDS.get(), HorizonsBlocks.REDWOOD_CABINET.get(),
                HorizonsBlocks.REDBUD_BOOKSHELF.get(), HorizonsBlocks.REDBUD_VERTICAL_SLAB.get(), HorizonsBlocks.REDBUD_LADDER.get(), HorizonsBlocks.REDBUD_HEDGE.get(), HorizonsBlocks.REDBUD_CHEST.get(), HorizonsBlocks.REDBUD_TRAPPED_CHEST.get(), HorizonsBlocks.REDBUD_POST.get(), HorizonsBlocks.STRIPPED_REDBUD_POST.get(), HorizonsBlocks.REDBUD_BEEHIVE.get(), HorizonsBlocks.REDBUD_BOARDS.get(), HorizonsBlocks.REDBUD_CABINET.get(), HorizonsBlocks.FLOWERING_REDBUD_LOG.get(), HorizonsBlocks.FLOWERING_REDBUD_WOOD.get(), HorizonsBlocks.BUDDING_REDBUD_HEDGE.get(), HorizonsBlocks.FLOWERING_REDBUD_HEDGE.get(), HorizonsBlocks.FLOWERING_REDBUD_POST.get(),
                HorizonsBlocks.JACARANDA_BOOKSHELF.get(), HorizonsBlocks.JACARANDA_VERTICAL_SLAB.get(), HorizonsBlocks.JACARANDA_LADDER.get(), HorizonsBlocks.JACARANDA_HEDGE.get(), HorizonsBlocks.JACARANDA_CHEST.get(), HorizonsBlocks.JACARANDA_TRAPPED_CHEST.get(), HorizonsBlocks.JACARANDA_POST.get(), HorizonsBlocks.STRIPPED_JACARANDA_POST.get(), HorizonsBlocks.JACARANDA_BEEHIVE.get(), HorizonsBlocks.JACARANDA_BOARDS.get(), HorizonsBlocks.JACARANDA_CABINET.get(), HorizonsBlocks.BUDDING_JACARANDA_HEDGE.get(), HorizonsBlocks.FLOWERING_JACARANDA_HEDGE.get(), HorizonsBlocks.AZURE_JACARANDA_HEDGE.get(), HorizonsBlocks.BUDDING_AZURE_JACARANDA_HEDGE.get(), HorizonsBlocks.FLOWERING_AZURE_JACARANDA_HEDGE.get()
        );
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(HorizonsBlocks.LIGHT_BOULDER.get(), HorizonsBlocks.LIGHT_BOULDER_SLAB.get(), HorizonsBlocks.LIGHT_BOULDER_STAIRS.get(), HorizonsBlocks.LIGHT_BOULDER_VERTICAL_SLAB.get(), HorizonsBlocks.LIGHT_BOULDER_WALL.get(), HorizonsBlocks.MOSSY_LIGHT_BOULDER.get(), HorizonsBlocks.MOSSY_LIGHT_BOULDER_SLAB.get(), HorizonsBlocks.MOSSY_LIGHT_BOULDER_STAIRS.get(), HorizonsBlocks.MOSSY_LIGHT_BOULDER_VERTICAL_SLAB.get(), HorizonsBlocks.MOSSY_LIGHT_BOULDER_WALL.get(), HorizonsBlocks.DARK_BOULDER.get(), HorizonsBlocks.DARK_BOULDER_SLAB.get(), HorizonsBlocks.DARK_BOULDER_STAIRS.get(), HorizonsBlocks.DARK_BOULDER_VERTICAL_SLAB.get(), HorizonsBlocks.DARK_BOULDER_WALL.get(), HorizonsBlocks.MOSSY_DARK_BOULDER.get(), HorizonsBlocks.MOSSY_DARK_BOULDER_SLAB.get(), HorizonsBlocks.MOSSY_DARK_BOULDER_STAIRS.get(), HorizonsBlocks.MOSSY_DARK_BOULDER_VERTICAL_SLAB.get(), HorizonsBlocks.MOSSY_DARK_BOULDER_WALL.get(), HorizonsBlocks.BOULDER_BRICKS.get(), HorizonsBlocks.BOULDER_BRICK_SLAB.get(), HorizonsBlocks.BOULDER_BRICK_STAIRS.get(), HorizonsBlocks.BOULDER_BRICK_VERTICAL_SLAB.get(), HorizonsBlocks.BOULDER_BRICK_WALL.get());
    }
}
