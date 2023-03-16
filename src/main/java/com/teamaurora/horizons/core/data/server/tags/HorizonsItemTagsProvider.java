package com.teamaurora.horizons.core.data.server.tags;

import com.teamabnormals.blueprint.core.other.tags.BlueprintBlockTags;
import com.teamabnormals.blueprint.core.other.tags.BlueprintItemTags;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.other.tags.HorizonsBlockTags;
import com.teamaurora.horizons.core.other.tags.HorizonsItemTags;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsItems;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.data.event.GatherDataEvent;

/**
 * @author rose_
 */
public class HorizonsItemTagsProvider extends ItemTagsProvider {
    public HorizonsItemTagsProvider(GatherDataEvent event) {
        super(event.getGenerator(), HorizonsBlockTagsProvider.INSTANCE, Horizons.MODID, event.getExistingFileHelper());
    }

    @Override
    protected void addTags() {
        //horizons
        this.copy(HorizonsBlockTags.CYPRESS_LOGS, HorizonsItemTags.CYPRESS_LOGS);

        //quark
        this.tag(BlueprintItemTags.BOATABLE_CHESTS).add(HorizonsBlocks.CYPRESS_CHEST.get().asItem());
        this.tag(BlueprintItemTags.REVERTABLE_CHESTS).add(HorizonsBlocks.CYPRESS_CHEST.get().asItem());
        this.copy(BlueprintBlockTags.LADDERS, BlueprintItemTags.LADDERS);
        this.copy(BlueprintBlockTags.VERTICAL_SLABS, BlueprintItemTags.VERTICAL_SLABS);
        this.copy(BlueprintBlockTags.WOODEN_VERTICAL_SLABS, BlueprintItemTags.WOODEN_VERTICAL_SLABS);

        //forge
        this.tag(HorizonsItemTags.BERRIES).add(HorizonsItems.GOOSEBERRIES.get());
        this.tag(Tags.Items.BOOKSHELVES).add(HorizonsBlocks.CYPRESS_BOOKSHELF.get().asItem());
        this.copy(Tags.Blocks.CHESTS_WOODEN, Tags.Items.CHESTS_WOODEN);
        this.copy(Tags.Blocks.CHESTS_TRAPPED, Tags.Items.CHESTS_TRAPPED);

        //minecraft
        this.tag(ItemTags.NON_FLAMMABLE_WOOD).add(HorizonsBlocks.CYPRESS_BOARDS.get().asItem());
        this.tag(ItemTags.BOATS).add(HorizonsItems.CYPRESS_BOATS.getFirst().get());
        this.tag(ItemTags.CHEST_BOATS).add(HorizonsItems.CYPRESS_BOATS.getSecond().get());
        this.tag(ItemTags.SIGNS).add(HorizonsBlocks.CYPRESS_SIGNS.getFirst().get().asItem());
        this.copy(BlockTags.BUTTONS, ItemTags.BUTTONS);
        this.copy(HorizonsBlockTags.CYPRESS_LEAVES, ItemTags.LEAVES);
        this.copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
        this.copy(BlockTags.PLANKS, ItemTags.PLANKS);
        this.copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
        this.copy(BlockTags.SLABS, ItemTags.SLABS);
        this.copy(BlockTags.SMALL_FLOWERS, ItemTags.SMALL_FLOWERS);
        this.copy(BlockTags.STAIRS, ItemTags.STAIRS);
        this.copy(BlockTags.WALLS, ItemTags.WALLS);
        this.copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
        this.copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
        this.copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);
        this.copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        this.copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
        this.copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        this.copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
    }

}
