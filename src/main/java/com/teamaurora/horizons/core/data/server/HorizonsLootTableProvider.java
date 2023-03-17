package com.teamaurora.horizons.core.data.server;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.common.block.VerticalSlabBlock;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.BlockPos;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author rose_
 */
public class HorizonsLootTableProvider extends LootTableProvider {
    private final Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet> blockTables = Pair.of(Blocks::new, LootContextParamSets.BLOCK);

    public HorizonsLootTableProvider(GatherDataEvent event) {
        super(event.getGenerator());
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return ImmutableList.of(this.blockTables);
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) { }

    private static <T> Iterable<T> getContent(IForgeRegistry<T> entry) {
        return entry.getValues().stream().filter(i -> entry.getKey(i) != null
                && Horizons.MODID.equals(entry.getKey(i).getNamespace())).collect(Collectors.toSet());
    }

    private static class Blocks extends BlockLoot {
        @Override
        protected void addTables() {
            this.dropSelf(HorizonsBlocks.STRIPPED_CYPRESS_LOG.get());
            this.dropSelf(HorizonsBlocks.STRIPPED_CYPRESS_WOOD.get());
            this.dropSelf(HorizonsBlocks.CYPRESS_LOG.get());
            this.dropSelf(HorizonsBlocks.CYPRESS_WOOD.get());
            this.dropSelf(HorizonsBlocks.CYPRESS_PLANKS.get());
            this.add(HorizonsBlocks.CYPRESS_SLAB.get(), Blocks::createSlabItemTable);
            this.dropSelf(HorizonsBlocks.CYPRESS_STAIRS.get());
            this.dropSelf(HorizonsBlocks.CYPRESS_FENCE.get());
            this.dropSelf(HorizonsBlocks.CYPRESS_FENCE_GATE.get());
            this.dropSelf(HorizonsBlocks.CYPRESS_PRESSURE_PLATE.get());
            this.add(HorizonsBlocks.CYPRESS_DOOR.get(), Blocks::createDoorTable);
            this.dropSelf(HorizonsBlocks.CYPRESS_TRAPDOOR.get());
            this.dropSelf(HorizonsBlocks.CYPRESS_BUTTON.get());
            this.dropSelf(HorizonsBlocks.CYPRESS_SIGNS.getFirst().get());
            this.dropSelf(HorizonsBlocks.CYPRESS_SIGNS.getSecond().get());
            this.dropSelf(HorizonsBlocks.CYPRESS_SAPLING.get());
            this.dropPottedContents(HorizonsBlocks.POTTED_CYPRESS_SAPLING.get());
            this.normalLeaves(HorizonsBlocks.CYPRESS_LEAVES.get(), HorizonsBlocks.CYPRESS_SAPLING.get());

            this.add(HorizonsBlocks.CYPRESS_BEEHIVE.get(), Blocks::createBeeHiveDrop);
            this.dropSelf(HorizonsBlocks.CYPRESS_LADDER.get());
            this.dropSelf(HorizonsBlocks.VERTICAL_CYPRESS_PLANKS.get());
            this.bookshelf(HorizonsBlocks.CYPRESS_BOOKSHELF.get());
            this.dropSelf(HorizonsBlocks.CYPRESS_BOARDS.get());
            this.add(HorizonsBlocks.CYPRESS_VERTICAL_SLAB.get(), Blocks::createVerticalSlabItemTable);
            this.dropSelf(HorizonsBlocks.STRIPPED_CYPRESS_POST.get());
            this.dropSelf(HorizonsBlocks.CYPRESS_POST.get());
            this.dropSelf(HorizonsBlocks.CYPRESS_CHEST.get());
            this.dropSelf(HorizonsBlocks.CYPRESS_TRAPPED_CHEST.get());
            this.dropSelf(HorizonsBlocks.CYPRESS_HEDGE.get());
            this.dropSelf(HorizonsBlocks.CYPRESS_LEAF_CARPET.get());
            this.leafPile(HorizonsBlocks.CYPRESS_LEAF_PILE.get());
            this.add(HorizonsBlocks.HANGING_CYPRESS_LEAVES.get(), Blocks::createShearsOnlyDrop);

            this.cypressKnee(HorizonsBlocks.CYPRESS_KNEE.get(), HorizonsBlocks.CYPRESS_LOG.get());
            this.largeCypressKnee(HorizonsBlocks.LARGE_CYPRESS_KNEE.get(), HorizonsBlocks.CYPRESS_LOG.get());
            this.cypressKnee(HorizonsBlocks.STRIPPED_CYPRESS_KNEE.get(), HorizonsBlocks.STRIPPED_CYPRESS_LOG.get());
            this.largeCypressKnee(HorizonsBlocks.STRIPPED_LARGE_CYPRESS_KNEE.get(), HorizonsBlocks.STRIPPED_CYPRESS_LOG.get());

            this.add(HorizonsBlocks.BEARD_MOSS_BLOCK.get(), Blocks::createShearsOnlyDrop);
            this.add(HorizonsBlocks.BEARD_MOSS.get(), Blocks::createShearsOnlyDrop);

            this.add(HorizonsBlocks.CYPRESS_BRANCH.get(), Blocks::createShearsOnlyDrop);
            this.dropSelf(HorizonsBlocks.GOOSEBERRY_SACK.get());

            this.add(HorizonsBlocks.ALGAE.get(), Blocks::createShearsOnlyDrop);
            this.dropSelf(HorizonsBlocks.ALGAE_THATCH.get());
            this.add(HorizonsBlocks.ALGAE_THATCH_SLAB.get(), Blocks::createSlabItemTable);
            this.dropSelf(HorizonsBlocks.ALGAE_THATCH_STAIRS.get());
            this.add(HorizonsBlocks.ALGAE_THATCH_VERTICAL_SLAB.get(), Blocks::createVerticalSlabItemTable);

            this.dropSelfAndOther(HorizonsBlocks.BLUE_LILY.get(), Items.LILY_PAD);
            this.dropSelfAndOther(HorizonsBlocks.LIGHT_GRAY_LILY.get(), Items.LILY_PAD);
            this.dropSelfAndOther(HorizonsBlocks.CYAN_LILY.get(), Items.LILY_PAD);
            this.dropSelfAndOther(HorizonsBlocks.LIGHT_BLUE_LILY.get(), Items.LILY_PAD);
            this.dropSelfAndOther(HorizonsBlocks.MAGENTA_LILY.get(), Items.LILY_PAD);
            this.dropSelfAndOther(HorizonsBlocks.PINK_LILY.get(), Items.LILY_PAD);
            this.dropSelfAndOther(HorizonsBlocks.PURPLE_LILY.get(), Items.LILY_PAD);
            this.dropSelfAndOther(HorizonsBlocks.WHITE_LILY.get(), Items.LILY_PAD);

            this.dropPottedContents(HorizonsBlocks.POTTED_BLUE_LILY.get());
            this.dropPottedContents(HorizonsBlocks.POTTED_LIGHT_GRAY_LILY.get());
            this.dropPottedContents(HorizonsBlocks.POTTED_CYAN_LILY.get());
            this.dropPottedContents(HorizonsBlocks.POTTED_LIGHT_BLUE_LILY.get());
            this.dropPottedContents(HorizonsBlocks.POTTED_MAGENTA_LILY.get());
            this.dropPottedContents(HorizonsBlocks.POTTED_PINK_LILY.get());
            this.dropPottedContents(HorizonsBlocks.POTTED_PURPLE_LILY.get());
            this.dropPottedContents(HorizonsBlocks.POTTED_WHITE_LILY.get());

            this.add(HorizonsBlocks.GIANT_FERN.get(), b -> createTriplePlantWithSeedDrops(b, net.minecraft.world.level.block.Blocks.FERN));
        }

        private void normalLeaves(Block leaves, Block sapling) {
            this.add(leaves, b -> createLeavesDrops(b, sapling, 0.05F, 0.0625F, 0.083333336F, 0.1F));
        }

        private void dropSelfAndOther(Block block, ItemLike other) {
            this.add(block, b -> LootTable.lootTable()
                    .withPool(applyExplosionCondition(other, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(other))))
                    .withPool(applyExplosionCondition(block, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(block)))));
        }

        private void bookshelf(Block block) {
            this.add(block, b -> createSingleItemTableWithSilkTouch(b, Items.BOOK, ConstantValue.exactly(3f)));
        }

        private void leafPile(Block block) {
            this.add(block, b -> createMultifaceBlockDrops(b, MatchTool.toolMatches(ItemPredicate.Builder.item().of(Tags.Items.SHEARS))));
        }

        private void cypressKnee(Block knee, Block log) {
            this.add(knee, b -> LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f)).add(createCypressKneeLootItemBuilder(knee, log, UniformGenerator.between(1, 2)))));
        }

        private void largeCypressKnee(Block knee, Block log) {
            LootPoolEntryContainer.Builder<?> builder = createCypressKneeLootItemBuilder(knee, log, UniformGenerator.between(2, 4));

            this.add(knee, b -> LootTable.lootTable()
                    .withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(b)
                            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))).when(LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(b)
                            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER).build()).build()), new BlockPos(0, 1, 0))))
                    .withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(b)
                            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))).when(LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(b)
                            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER).build()).build()), new BlockPos(0, -1, 0)))));
        }


        @Override
        public Iterable<Block> getKnownBlocks() {
            return getContent(ForgeRegistries.BLOCKS);
        }

        private static LootTable.Builder createVerticalSlabItemTable(Block block) {
            return LootTable.lootTable()
                    .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1f))
                            .add(applyExplosionDecay(block, LootItem.lootTableItem(block)
                                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2f))
                                            .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                                    .setProperties(StatePropertiesPredicate.Builder.properties()
                                                            .hasProperty(VerticalSlabBlock.TYPE, VerticalSlabBlock.VerticalSlabType.DOUBLE)))))));
        }

        private static LootTable.Builder createTriplePlantWithSeedDrops(Block block, Block drop) {
            LootPoolEntryContainer.Builder<?> builder = LootItem.lootTableItem(drop).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0F)))
                    .when(MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS))).otherwise(applyExplosionCondition(block, LootItem.lootTableItem(Items.WHEAT_SEEDS)).when(LootItemRandomChanceCondition.randomChance(0.125F)));

            return LootTable.lootTable()
                    .withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))).when(LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(block)
                            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER).build()).build()), new BlockPos(0, 1, 0))))
                    .withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(drop)
                            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))).when(LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(block)
                            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER).build()).build()), new BlockPos(0, -1, 0))));
        }

        private static LootPoolEntryContainer.Builder<?> createCypressKneeLootItemBuilder(Block knee, Block log, NumberProvider logCount) {
            return LootItem.lootTableItem(knee).when(MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))))
                    .otherwise(applyExplosionDecay(log, LootItem.lootTableItem(log).apply(SetItemCountFunction.setCount(logCount))));
        }

    }

}
