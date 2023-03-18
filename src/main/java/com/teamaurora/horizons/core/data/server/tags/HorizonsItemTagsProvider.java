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
        this.copy(HorizonsBlockTags.REDWOOD_LOGS, HorizonsItemTags.REDWOOD_LOGS);
        this.copy(HorizonsBlockTags.REDBUD_LOGS, HorizonsItemTags.REDBUD_LOGS);
        this.copy(HorizonsBlockTags.JACARANDA_LOGS, HorizonsItemTags.JACARANDA_LOGS);

        //quark
        this.tag(BlueprintItemTags.BOATABLE_CHESTS).add(HorizonsBlocks.CYPRESS_CHEST.get().asItem(), HorizonsBlocks.REDWOOD_CHEST.get().asItem(), HorizonsBlocks.REDBUD_CHEST.get().asItem(), HorizonsBlocks.JACARANDA_CHEST.get().asItem());
        this.tag(BlueprintItemTags.REVERTABLE_CHESTS).add(HorizonsBlocks.CYPRESS_CHEST.get().asItem(), HorizonsBlocks.REDWOOD_CHEST.get().asItem(), HorizonsBlocks.REDBUD_CHEST.get().asItem(), HorizonsBlocks.JACARANDA_CHEST.get().asItem());
        this.copy(BlueprintBlockTags.LADDERS, BlueprintItemTags.LADDERS);
        this.copy(BlueprintBlockTags.VERTICAL_SLABS, BlueprintItemTags.VERTICAL_SLABS);
        this.copy(BlueprintBlockTags.WOODEN_VERTICAL_SLABS, BlueprintItemTags.WOODEN_VERTICAL_SLABS);

        //forge
        this.tag(HorizonsItemTags.BERRIES).add(HorizonsItems.GOOSEBERRIES.get());
        this.tag(HorizonsItemTags.STRIPPED_LOGS).add(HorizonsBlocks.STRIPPED_CYPRESS_LOG.get().asItem(), HorizonsBlocks.STRIPPED_REDBUD_LOG.get().asItem(), HorizonsBlocks.STRIPPED_JACARANDA_LOG.get().asItem());
        this.tag(HorizonsItemTags.STRIPPED_WOOD).add(HorizonsBlocks.STRIPPED_CYPRESS_WOOD.get().asItem(), HorizonsBlocks.STRIPPED_REDBUD_WOOD.get().asItem(), HorizonsBlocks.STRIPPED_JACARANDA_WOOD.get().asItem());
        this.tag(Tags.Items.BOOKSHELVES).add(HorizonsBlocks.CYPRESS_BOOKSHELF.get().asItem(), HorizonsBlocks.REDWOOD_BOOKSHELF.get().asItem(), HorizonsBlocks.REDBUD_BOOKSHELF.get().asItem(), HorizonsBlocks.JACARANDA_BOOKSHELF.get().asItem());
        this.copy(Tags.Blocks.CHESTS_WOODEN, Tags.Items.CHESTS_WOODEN);
        this.copy(Tags.Blocks.CHESTS_TRAPPED, Tags.Items.CHESTS_TRAPPED);

        //boatload
        this.tag(BlueprintItemTags.LARGE_BOATS).add(HorizonsItems.LARGE_CYPRESS_BOAT.get(), HorizonsItems.LARGE_REDWOOD_BOAT.get(), HorizonsItems.LARGE_REDBUD_BOAT.get(), HorizonsItems.LARGE_JACARANDA_BOAT.get());
        this.tag(BlueprintItemTags.FURNACE_BOATS).add(HorizonsItems.CYPRESS_FURNACE_BOAT.get(), HorizonsItems.REDWOOD_FURNACE_BOAT.get(), HorizonsItems.REDBUD_FURNACE_BOAT.get(), HorizonsItems.JACARANDA_FURNACE_BOAT.get());

        //farmerdelight
        this.tag(HorizonsItemTags.WOODEN_CABINETS).add(HorizonsBlocks.CYPRESS_CABINET.get().asItem(), HorizonsBlocks.REDWOOD_CABINET.get().asItem(), HorizonsBlocks.REDBUD_CABINET.get().asItem(), HorizonsBlocks.JACARANDA_CABINET.get().asItem());

        //environmental
        this.tag(HorizonsItemTags.DUCK_FOOD).add(HorizonsItems.ALGAE.get());

        //minecraft
        this.tag(ItemTags.NON_FLAMMABLE_WOOD).add(HorizonsBlocks.CYPRESS_BOARDS.get().asItem(), HorizonsBlocks.REDWOOD_BOARDS.get().asItem(), HorizonsBlocks.REDBUD_BOARDS.get().asItem(), HorizonsBlocks.JACARANDA_BOARDS.get().asItem());
        this.tag(ItemTags.BOATS).add(HorizonsItems.CYPRESS_BOATS.getFirst().get(), HorizonsItems.REDWOOD_BOATS.getFirst().get(), HorizonsItems.REDBUD_BOATS.getFirst().get().asItem(), HorizonsItems.REDBUD_BOATS.getFirst().get().asItem());
        this.tag(ItemTags.CHEST_BOATS).add(HorizonsItems.CYPRESS_BOATS.getSecond().get(), HorizonsItems.REDWOOD_BOATS.getSecond().get(), HorizonsItems.REDBUD_BOATS.getSecond().get().asItem(), HorizonsItems.REDBUD_BOATS.getSecond().get().asItem());
        this.tag(ItemTags.SIGNS).add(HorizonsBlocks.CYPRESS_SIGNS.getFirst().get().asItem(), HorizonsBlocks.REDWOOD_SIGNS.getFirst().get().asItem(), HorizonsBlocks.REDBUD_SIGNS.getFirst().get().asItem(), HorizonsBlocks.JACARANDA_SIGNS.getFirst().get().asItem());
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
