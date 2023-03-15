package com.teamaurora.horizons.core.data.client;

import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.common.block.sign.BlueprintStandingSignBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintWallSignBlock;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;
import org.codehaus.plexus.util.StringUtils;

/**
 * @author rose_
 */
public class HorizonsLanguageProvider extends LanguageProvider {
    public HorizonsLanguageProvider(GatherDataEvent event) {
        super(event.getGenerator(), Horizons.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        //items
        this.translateItem(HorizonsItems.GOOSEBERRIES);
        this.translateItem(HorizonsItems.GOOSEBERRY_JUICE);
        this.translateItem(HorizonsItems.GOOSEBERRY_PIE);
        this.translateItem(HorizonsItems.HONEY_GLAZED_GOOSEBERRIES);
        this.translateItem(HorizonsItems.GOOSEBERRY_JAM);
        this.translateItem(HorizonsItems.GOOSEBERRY_JAM_COOKIE);

        this.translateItem(HorizonsItems.CYPRESS_BOATS.getFirst());
        this.translateItem(HorizonsItems.CYPRESS_BOATS.getSecond());
        this.translateItem(HorizonsItems.CYPRESS_FURNACE_BOAT);
        this.translateItem(HorizonsItems.LARGE_CYPRESS_BOAT);

        //blocks
        this.translateBlock(HorizonsBlocks.STRIPPED_CYPRESS_LOG);
        this.translateBlock(HorizonsBlocks.STRIPPED_CYPRESS_WOOD);
        this.translateBlock(HorizonsBlocks.CYPRESS_LOG);
        this.translateBlock(HorizonsBlocks.CYPRESS_WOOD);
        this.translateBlock(HorizonsBlocks.CYPRESS_PLANKS);
        this.translateBlock(HorizonsBlocks.CYPRESS_SLAB);
        this.translateBlock(HorizonsBlocks.CYPRESS_STAIRS);
        this.translateBlock(HorizonsBlocks.CYPRESS_FENCE);
        this.translateBlock(HorizonsBlocks.CYPRESS_FENCE_GATE);
        this.translateBlock(HorizonsBlocks.CYPRESS_PRESSURE_PLATE);
        this.translateBlock(HorizonsBlocks.CYPRESS_DOOR);
        this.translateBlock(HorizonsBlocks.CYPRESS_TRAPDOOR);
        this.translateBlock(HorizonsBlocks.CYPRESS_BUTTON);
        this.translateSigns(HorizonsBlocks.CYPRESS_SIGNS, "cypress");
        this.translateBlock(HorizonsBlocks.CYPRESS_SAPLING);
        this.translateBlock(HorizonsBlocks.POTTED_CYPRESS_SAPLING);
        this.translateBlock(HorizonsBlocks.CYPRESS_LEAVES);

        this.translateBlock(HorizonsBlocks.VERTICAL_CYPRESS_PLANKS);
        this.translateBlock(HorizonsBlocks.CYPRESS_BEEHIVE);
        this.translateBlock(HorizonsBlocks.CYPRESS_LADDER);
        this.translateBlock(HorizonsBlocks.CYPRESS_BOOKSHELF);
        this.translateBlock(HorizonsBlocks.CYPRESS_BOARDS);
        this.translateBlock(HorizonsBlocks.CYPRESS_VERTICAL_SLAB);
        this.translateBlock(HorizonsBlocks.CYPRESS_POST);
        this.translateBlock(HorizonsBlocks.STRIPPED_CYPRESS_POST);
        this.translateBlock(HorizonsBlocks.CYPRESS_CHEST);
        this.translateBlock(HorizonsBlocks.CYPRESS_TRAPPED_CHEST);
        this.add(HorizonsBlocks.CYPRESS_HEDGE.get(), "Cypress Leaf Hedge");
        this.translateBlock(HorizonsBlocks.CYPRESS_LEAF_CARPET);
        this.translateBlock(HorizonsBlocks.CYPRESS_LEAF_PILE);
        this.translateBlock(HorizonsBlocks.GOOSEBERRY_SACK);

        this.translateBlock(HorizonsBlocks.ALGAE);
        this.translateBlock(HorizonsBlocks.ALGAE_THATCH);
        this.translateBlock(HorizonsBlocks.ALGAE_THATCH_SLAB);
        this.translateBlock(HorizonsBlocks.ALGAE_THATCH_STAIRS);
        this.translateBlock(HorizonsBlocks.ALGAE_THATCH_VERTICAL_SLAB);
    }

    private void translateItem(RegistryObject<? extends Item> item) {
        this.add(item.get(), this.toUpper(ForgeRegistries.ITEMS, item));
    }

    private void translateBlock(RegistryObject<? extends Block> block) {
        this.add(block.get(), this.toUpper(ForgeRegistries.BLOCKS, block));
    }

    private void translateSigns(Pair<RegistryObject<BlueprintStandingSignBlock>, RegistryObject<BlueprintWallSignBlock>> sign, String name) {
        this.translateBlock(sign.getFirst());
        this.add(sign.getFirst().get().getDescriptionId().replace(name, name + "_wall"), this.toUpper(ForgeRegistries.BLOCKS, sign.getSecond()));
    }

    private <T> String toUpper(IForgeRegistry<T> entry, RegistryObject<? extends T> object) {
        return StringUtils.capitaliseAllWords(entry.getKey(object.get()).getPath().replace('_', ' '));
    }

}
