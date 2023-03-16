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

        //quark
        this.tag(BlueprintBlockTags.VERTICAL_SLABS).add(HorizonsBlocks.ALGAE_THATCH_VERTICAL_SLAB.get());
        this.tag(BlueprintBlockTags.WOODEN_VERTICAL_SLABS).add(HorizonsBlocks.CYPRESS_VERTICAL_SLAB.get());
        this.tag(BlueprintBlockTags.HEDGES).add(HorizonsBlocks.CYPRESS_HEDGE.get());
        this.tag(BlueprintBlockTags.LADDERS).add(HorizonsBlocks.CYPRESS_LADDER.get());

        //woodworks
        this.tag(BlueprintBlockTags.LEAF_PILES).add(HorizonsBlocks.CYPRESS_LEAF_PILE.get());

        //forge
        this.tag(Tags.Blocks.CHESTS_WOODEN).add(HorizonsBlocks.CYPRESS_CHEST.get(), HorizonsBlocks.CYPRESS_TRAPPED_CHEST.get());
        this.tag(Tags.Blocks.CHESTS_TRAPPED).add(HorizonsBlocks.CYPRESS_TRAPPED_CHEST.get());

        //minecraft
        this.tag(BlockTags.BEEHIVES).add(HorizonsBlocks.CYPRESS_BEEHIVE.get());
        this.tag(BlockTags.WOODEN_BUTTONS).add(HorizonsBlocks.CYPRESS_BUTTON.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(HorizonsBlocks.CYPRESS_PRESSURE_PLATE.get());
        this.tag(BlockTags.PLANKS).add(HorizonsBlocks.CYPRESS_PLANKS.get(), HorizonsBlocks.VERTICAL_CYPRESS_PLANKS.get());
        this.tag(BlockTags.WOODEN_DOORS).add(HorizonsBlocks.CYPRESS_DOOR.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(HorizonsBlocks.CYPRESS_TRAPDOOR.get());
        this.tag(BlockTags.WOODEN_STAIRS).add(HorizonsBlocks.CYPRESS_STAIRS.get());
        this.tag(BlockTags.WOODEN_SLABS).add(HorizonsBlocks.CYPRESS_SLAB.get());
        this.tag(BlockTags.WALL_SIGNS).add(HorizonsBlocks.CYPRESS_SIGNS.getSecond().get());
        this.tag(BlockTags.STANDING_SIGNS).add(HorizonsBlocks.CYPRESS_SIGNS.getFirst().get());
        this.tag(BlockTags.WOODEN_FENCES).add(HorizonsBlocks.CYPRESS_FENCE.get());
        this.tag(BlockTags.LOGS_THAT_BURN).addTag(HorizonsBlockTags.CYPRESS_LOGS);
        this.tag(BlockTags.LEAVES).addTag(HorizonsBlockTags.CYPRESS_LEAVES);
        this.tag(BlockTags.CLIMBABLE).add(HorizonsBlocks.CYPRESS_LADDER.get());
        this.tag(BlockTags.FENCE_GATES).add(HorizonsBlocks.CYPRESS_FENCE_GATE.get());
        this.tag(BlockTags.SAPLINGS).add(HorizonsBlocks.CYPRESS_SAPLING.get());
        this.tag(BlockTags.FLOWER_POTS).add(HorizonsBlocks.POTTED_CYPRESS_SAPLING.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(HorizonsBlocks.CYPRESS_BOOKSHELF.get(), HorizonsBlocks.CYPRESS_VERTICAL_SLAB.get(), HorizonsBlocks.CYPRESS_LADDER.get(), HorizonsBlocks.CYPRESS_HEDGE.get(), HorizonsBlocks.CYPRESS_CHEST.get(), HorizonsBlocks.CYPRESS_TRAPPED_CHEST.get(), HorizonsBlocks.CYPRESS_POST.get(), HorizonsBlocks.STRIPPED_CYPRESS_POST.get(), HorizonsBlocks.CYPRESS_BEEHIVE.get(), HorizonsBlocks.CYPRESS_BOARDS.get(), HorizonsBlocks.CYPRESS_KNEE.get(), HorizonsBlocks.LARGE_CYPRESS_KNEE.get(), HorizonsBlocks.STRIPPED_CYPRESS_KNEE.get(), HorizonsBlocks.STRIPPED_LARGE_CYPRESS_KNEE.get(), HorizonsBlocks.CYPRESS_BRANCH.get());
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(HorizonsBlocks.ALGAE.get(), HorizonsBlocks.ALGAE_THATCH.get(), HorizonsBlocks.ALGAE_THATCH_SLAB.get(), HorizonsBlocks.ALGAE_THATCH_STAIRS.get(), HorizonsBlocks.ALGAE_THATCH_VERTICAL_SLAB.get(), HorizonsBlocks.CYPRESS_LEAVES.get(), HorizonsBlocks.CYPRESS_LEAF_CARPET.get(), HorizonsBlocks.HANGING_CYPRESS_LEAVES.get(), HorizonsBlocks.BEARD_MOSS_BLOCK.get(), HorizonsBlocks.BEARD_MOSS.get());

    }
}
