package com.teamaurora.horizons.core.data.server;

import com.teamabnormals.blueprint.core.api.conditions.QuarkFlagRecipeCondition;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.other.tags.HorizonsItemTags;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsItems;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.AndCondition;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import net.minecraftforge.common.crafting.conditions.OrCondition;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;

/**
 * @author rose_
 */
public class HorizonsRecipeProvider extends RecipeProvider {
    public HorizonsRecipeProvider(GatherDataEvent event) {
        super(event.getGenerator());
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(HorizonsItems.GOOSEBERRY_JUICE.get()).requires(Items.GLASS_BOTTLE).requires(HorizonsItems.GOOSEBERRIES.get(), 3).unlockedBy(getHasName(HorizonsItems.GOOSEBERRIES.get()), has(HorizonsItems.GOOSEBERRIES.get())).save(consumer, getSaveLocation(HorizonsItems.GOOSEBERRY_JUICE.get()));
        ShapelessRecipeBuilder.shapeless(Items.SUGAR, 3).requires(HorizonsItems.GOOSEBERRY_JUICE.get()).unlockedBy(getHasName(HorizonsItems.GOOSEBERRY_JUICE.get()), has(HorizonsItems.GOOSEBERRY_JUICE.get())).save(consumer, Horizons.REGISTRY_HELPER.prefix("gooseberry_juice_to_sugar"));
        ShapelessRecipeBuilder.shapeless(HorizonsItems.HONEY_GLAZED_GOOSEBERRIES.get()).requires(HorizonsItems.GOOSEBERRIES.get()).requires(Items.HONEY_BOTTLE).unlockedBy(getHasName(HorizonsItems.GOOSEBERRIES.get()), has(HorizonsItems.GOOSEBERRIES.get())).save(consumer, getSaveLocation(HorizonsItems.HONEY_GLAZED_GOOSEBERRIES.get()));
        ShapelessRecipeBuilder.shapeless(HorizonsItems.GOOSEBERRY_JAM_COOKIE.get(), 8).requires(HorizonsItems.GOOSEBERRY_JAM.get()).requires(Items.WHEAT, 2).unlockedBy(getHasName(HorizonsItems.GOOSEBERRY_JAM.get()), has(HorizonsItems.GOOSEBERRY_JAM.get())).save(consumer, getSaveLocation(HorizonsItems.GOOSEBERRY_JAM_COOKIE.get()));
        ShapelessRecipeBuilder.shapeless(HorizonsItems.GOOSEBERRY_PIE.get()).requires(HorizonsItems.GOOSEBERRIES.get()).requires(Tags.Items.EGGS).requires(Items.SUGAR).unlockedBy(getHasName(HorizonsItems.GOOSEBERRIES.get()), has(HorizonsItems.GOOSEBERRIES.get())).save(consumer, getSaveLocation(HorizonsItems.GOOSEBERRY_PIE.get()));
        ShapelessRecipeBuilder.shapeless(HorizonsItems.GOOSEBERRY_JAM.get(), 3).requires(HorizonsItems.HONEY_GLAZED_GOOSEBERRIES.get()).requires(Items.GLASS_BOTTLE, 3).unlockedBy(getHasName(HorizonsItems.HONEY_GLAZED_GOOSEBERRIES.get()), has(HorizonsItems.HONEY_GLAZED_GOOSEBERRIES.get())).save(consumer, getSaveLocation(HorizonsItems.GOOSEBERRY_JAM.get()));
        ShapelessRecipeBuilder.shapeless(Items.SUGAR, 3).requires(HorizonsItems.GOOSEBERRY_JAM.get()).unlockedBy(getHasName(HorizonsItems.GOOSEBERRY_JAM.get()), has(HorizonsItems.GOOSEBERRY_JAM.get())).save(consumer, Horizons.REGISTRY_HELPER.prefix("gooseberry_jam_to_sugar"));
        quarkCompressedBlock(HorizonsItems.GOOSEBERRIES.get(), HorizonsBlocks.GOOSEBERRY_SACK.get(), "berry_sack", consumer);
        ShapedRecipeBuilder.shaped(HorizonsBlocks.ALGAE_THATCH.get(), 4).define('#', HorizonsBlocks.ALGAE.get()).pattern("##").pattern("##").unlockedBy(getHasName(HorizonsBlocks.ALGAE.get()), has(HorizonsBlocks.ALGAE.get())).save(consumer, getSaveLocation(HorizonsBlocks.ALGAE_THATCH.get()));
        slab(HorizonsBlocks.ALGAE_THATCH.get(), HorizonsBlocks.ALGAE_THATCH_SLAB.get(), consumer);
        stairs(HorizonsBlocks.ALGAE_THATCH.get(), HorizonsBlocks.ALGAE_THATCH_STAIRS.get(), consumer);
        verticalSlab(HorizonsBlocks.ALGAE_THATCH_VERTICAL_SLAB.get(), HorizonsBlocks.ALGAE_THATCH_SLAB.get(), consumer);
        woodSet(HorizonsItemTags.CYPRESS_LOGS, HorizonsBlocks.CYPRESS_PLANKS.get(), HorizonsBlocks.CYPRESS_SLAB.get(), HorizonsBlocks.CYPRESS_STAIRS.get(), HorizonsBlocks.CYPRESS_LOG.get(), HorizonsBlocks.CYPRESS_WOOD.get(), HorizonsBlocks.STRIPPED_CYPRESS_LOG.get(), HorizonsBlocks.STRIPPED_CYPRESS_WOOD.get(), HorizonsItems.CYPRESS_BOATS.getFirst().get(),  HorizonsItems.CYPRESS_BOATS.getSecond().get(), HorizonsBlocks.CYPRESS_BUTTON.get(), HorizonsBlocks.CYPRESS_DOOR.get(), HorizonsBlocks.CYPRESS_TRAPDOOR.get(), HorizonsBlocks.CYPRESS_FENCE.get(), HorizonsBlocks.CYPRESS_FENCE_GATE.get(), HorizonsBlocks.CYPRESS_PRESSURE_PLATE.get(), HorizonsBlocks.CYPRESS_SIGNS.getFirst().get(), HorizonsBlocks.CYPRESS_VERTICAL_SLAB.get(), HorizonsBlocks.CYPRESS_POST.get(), HorizonsBlocks.STRIPPED_CYPRESS_POST.get(), HorizonsBlocks.CYPRESS_BOARDS.get(), HorizonsBlocks.CYPRESS_BEEHIVE.get(), HorizonsBlocks.CYPRESS_LADDER.get(), HorizonsBlocks.CYPRESS_BOOKSHELF.get(), HorizonsBlocks.CYPRESS_CHEST.get(), HorizonsBlocks.CYPRESS_TRAPPED_CHEST.get(), HorizonsItems.LARGE_CYPRESS_BOAT.get(), HorizonsItems.CYPRESS_FURNACE_BOAT.get(), HorizonsBlocks.VERTICAL_CYPRESS_PLANKS.get(), HorizonsBlocks.CYPRESS_CABINET.get(), consumer);
        woodSet(HorizonsItemTags.REDWOOD_LOGS, HorizonsBlocks.REDWOOD_PLANKS.get(), HorizonsBlocks.REDWOOD_SLAB.get(), HorizonsBlocks.REDWOOD_STAIRS.get(), HorizonsBlocks.REDWOOD_LOG.get(), HorizonsBlocks.REDWOOD_WOOD.get(), HorizonsBlocks.STRIPPED_REDWOOD_LOG.get(), HorizonsBlocks.STRIPPED_REDWOOD_WOOD.get(), HorizonsItems.REDWOOD_BOATS.getFirst().get(),  HorizonsItems.REDWOOD_BOATS.getSecond().get(), HorizonsBlocks.REDWOOD_BUTTON.get(), HorizonsBlocks.REDWOOD_DOOR.get(), HorizonsBlocks.REDWOOD_TRAPDOOR.get(), HorizonsBlocks.REDWOOD_FENCE.get(), HorizonsBlocks.REDWOOD_FENCE_GATE.get(), HorizonsBlocks.REDWOOD_PRESSURE_PLATE.get(), HorizonsBlocks.REDWOOD_SIGNS.getFirst().get(), HorizonsBlocks.REDWOOD_VERTICAL_SLAB.get(), HorizonsBlocks.REDWOOD_POST.get(), HorizonsBlocks.STRIPPED_REDWOOD_POST.get(), HorizonsBlocks.REDWOOD_BOARDS.get(), HorizonsBlocks.REDWOOD_BEEHIVE.get(), HorizonsBlocks.REDWOOD_LADDER.get(), HorizonsBlocks.REDWOOD_BOOKSHELF.get(), HorizonsBlocks.REDWOOD_CHEST.get(), HorizonsBlocks.REDWOOD_TRAPPED_CHEST.get(), HorizonsItems.LARGE_REDWOOD_BOAT.get(), HorizonsItems.REDWOOD_FURNACE_BOAT.get(), HorizonsBlocks.VERTICAL_REDWOOD_PLANKS.get(), HorizonsBlocks.REDWOOD_CABINET.get(), consumer);
        leafSet(HorizonsItemTags.CYPRESS_LOGS, HorizonsBlocks.CYPRESS_LEAVES.get(), HorizonsBlocks.CYPRESS_HEDGE.get(), HorizonsBlocks.CYPRESS_LEAF_CARPET.get(), HorizonsBlocks.CYPRESS_LEAF_PILE.get(), consumer);
        leafSet(HorizonsItemTags.REDWOOD_LOGS, HorizonsBlocks.REDWOOD_LEAVES.get(), HorizonsBlocks.REDWOOD_HEDGE.get(), HorizonsBlocks.REDWOOD_LEAF_CARPET.get(), HorizonsBlocks.REDWOOD_LEAF_PILE.get(), consumer);
        flowerToDye(HorizonsBlocks.BLUE_LILY.get(), Items.BLUE_DYE, consumer);
        flowerToDye(HorizonsBlocks.LIGHT_GRAY_LILY.get(), Items.LIGHT_GRAY_DYE, consumer);
        flowerToDye(HorizonsBlocks.CYAN_LILY.get(), Items.CYAN_DYE, consumer);
        flowerToDye(HorizonsBlocks.LIGHT_BLUE_LILY.get(), Items.LIGHT_BLUE_DYE, consumer);
        flowerToDye(HorizonsBlocks.MAGENTA_LILY.get(), Items.MAGENTA_DYE, consumer);
        flowerToDye(HorizonsBlocks.PINK_LILY.get(), Items.PINK_DYE, consumer);
        flowerToDye(HorizonsBlocks.PURPLE_LILY.get(), Items.PURPLE_DYE, consumer);
        flowerToDye(HorizonsBlocks.WHITE_LILY.get(), Items.WHITE_DYE, consumer);
        mossyBlock(HorizonsBlocks.LIGHT_BOULDER.get(), HorizonsBlocks.MOSSY_LIGHT_BOULDER.get(), consumer);
        mossyBlock(HorizonsBlocks.DARK_BOULDER.get(), HorizonsBlocks.MOSSY_DARK_BOULDER.get(), consumer);
        ShapedRecipeBuilder.shaped(HorizonsBlocks.BOULDER_BRICKS.get(), 4).define('L', HorizonsBlocks.LIGHT_BOULDER.get()).define('D', HorizonsBlocks.DARK_BOULDER.get()).pattern("LD").pattern("DL").unlockedBy(getHasName(HorizonsBlocks.LIGHT_BOULDER.get()), has(HorizonsBlocks.LIGHT_BOULDER.get())).save(consumer, getSaveLocation(HorizonsBlocks.BOULDER_BRICKS.get()));
        stoneBlockSet(HorizonsBlocks.LIGHT_BOULDER.get(), HorizonsBlocks.LIGHT_BOULDER_SLAB.get(), HorizonsBlocks.LIGHT_BOULDER_STAIRS.get(), HorizonsBlocks.LIGHT_BOULDER_VERTICAL_SLAB.get(), HorizonsBlocks.LIGHT_BOULDER_WALL.get(), consumer);
        stoneBlockSet(HorizonsBlocks.MOSSY_LIGHT_BOULDER.get(), HorizonsBlocks.MOSSY_LIGHT_BOULDER_SLAB.get(), HorizonsBlocks.MOSSY_LIGHT_BOULDER_STAIRS.get(), HorizonsBlocks.MOSSY_LIGHT_BOULDER_VERTICAL_SLAB.get(), HorizonsBlocks.MOSSY_LIGHT_BOULDER_WALL.get(), consumer);
        stoneBlockSet(HorizonsBlocks.DARK_BOULDER.get(), HorizonsBlocks.DARK_BOULDER_SLAB.get(), HorizonsBlocks.DARK_BOULDER_STAIRS.get(), HorizonsBlocks.DARK_BOULDER_VERTICAL_SLAB.get(), HorizonsBlocks.DARK_BOULDER_WALL.get(), consumer);
        stoneBlockSet(HorizonsBlocks.MOSSY_DARK_BOULDER.get(), HorizonsBlocks.MOSSY_DARK_BOULDER_SLAB.get(), HorizonsBlocks.MOSSY_DARK_BOULDER_STAIRS.get(), HorizonsBlocks.MOSSY_DARK_BOULDER_VERTICAL_SLAB.get(), HorizonsBlocks.MOSSY_DARK_BOULDER_WALL.get(), consumer);
        stoneBlockSet(HorizonsBlocks.BOULDER_BRICKS.get(), HorizonsBlocks.BOULDER_BRICK_SLAB.get(), HorizonsBlocks.BOULDER_BRICK_STAIRS.get(), HorizonsBlocks.BOULDER_BRICK_VERTICAL_SLAB.get(), HorizonsBlocks.BOULDER_BRICK_WALL.get(), consumer);
        flowerToDye(HorizonsBlocks.YELLOW_DAISY.get(), Items.YELLOW_DYE, consumer);
        flowerToDye(HorizonsBlocks.RED_DAISY.get(), Items.RED_DYE, consumer);
        flowerToDye(HorizonsBlocks.PURPLE_DAISY.get(), Items.PURPLE_DYE, consumer);
        flowerToDye(HorizonsBlocks.PINK_DAISY.get(), Items.PINK_DYE, consumer);
        flowerToDye(HorizonsBlocks.ORANGE_DAISY.get(), Items.ORANGE_DYE, consumer);
        flowerToDye(HorizonsBlocks.MAGENTA_DAISY.get(), Items.MAGENTA_DYE, consumer);
        flowerToDye(HorizonsBlocks.BLUE_DAISY.get(), Items.BLUE_DYE, consumer);
    }

    private static void woodSet(TagKey<Item> logs, Block planks, Block slab, Block stairs, Block log, Block wood, Block strippedLog, Block strippedWood, ItemLike boat, ItemLike chestBoat, Block button, Block door, Block trapdoor, Block fence, Block fenceGate, Block pressurePlate, Block sign, Block verticalSlab, Block post, Block strippedPost, Block boards, Block beehive, Block ladder, Block bookshelf, Block chest, Block trappedChest, Item largeBoat, Item furnaceBoat, Block verticalPlanks, Block cabinet, Consumer<FinishedRecipe> consumer) {
        woodenBoat(consumer, boat, planks);
        ShapelessRecipeBuilder.shapeless(chestBoat).group("chest_boat").requires(Tags.Items.CHESTS_WOODEN).requires(boat).unlockedBy(getHasName(boat), has(boat)).save(consumer, getSaveLocation(chestBoat));
        ShapelessRecipeBuilder.shapeless(button).group("wooden_button").requires(planks).unlockedBy(getHasName(planks), has(planks)).save(consumer, getSaveLocation(button));
        ShapedRecipeBuilder.shaped(door, 3).group("wooden_door").define('#', planks).pattern("##").pattern("##").pattern("##").unlockedBy(getHasName(planks), has(planks)).save(consumer, getSaveLocation(door));
        ShapedRecipeBuilder.shaped(fence, 3).group("wooden_fence").define('#', planks).define('S', Items.STICK).pattern("#S#").pattern("#S#").unlockedBy(getHasName(planks), has(planks)).save(consumer, getSaveLocation(fence));
        ShapedRecipeBuilder.shaped(fenceGate).group("wooden_fence_gate").define('#', planks).define('S', Items.STICK).pattern("S#S").pattern("S#S").unlockedBy(getHasName(planks), has(planks)).save(consumer, getSaveLocation(fenceGate));
        ShapedRecipeBuilder.shaped(pressurePlate).group("wooden_pressure_plate").define('#', planks).pattern("##").unlockedBy(getHasName(planks), has(planks)).save(consumer, getSaveLocation(pressurePlate));
        ShapedRecipeBuilder.shaped(sign, 3).group("wooden_sign").define('#', planks).define('S', Items.STICK).pattern("###").pattern("###").pattern(" S ").unlockedBy(getHasName(planks), has(planks)).save(consumer, getSaveLocation(sign));
        ShapedRecipeBuilder.shaped(trapdoor, 2).group("wooden_trapdoor").define('#', planks).pattern("###").pattern("###").unlockedBy(getHasName(planks), has(planks)).save(consumer, getSaveLocation(trapdoor));
        planksFromLogs(consumer, planks, logs);
        woodFromLogs(consumer, wood, log);
        woodFromLogs(consumer, strippedWood, strippedLog);
        slab(planks, slab, "wooden_slab", consumer);
        stairs(planks, stairs, "wooden_stairs", consumer);
        verticalSlab(verticalSlab, slab, consumer);
        post(post, wood, consumer);
        post(strippedPost, strippedWood, consumer);
        conditionalRecipe(ShapedRecipeBuilder.shaped(boards, 3).group("wooden_boards").define('#', planks).pattern("#").pattern("#").pattern("#").unlockedBy(getHasName(planks), has(planks)), new ModLoadedCondition("woodworks"), consumer, getSaveLocation(boards));
        conditionalRecipe(ShapedRecipeBuilder.shaped(beehive).group("wooden_beehive").define('#', planks).define('H', Items.HONEYCOMB).pattern("###").pattern("HHH").pattern("###").unlockedBy(getHasName(planks), has(planks)), new ModLoadedCondition("woodworks"), consumer, getSaveLocation(beehive));
        conditionalRecipe(ShapedRecipeBuilder.shaped(ladder, 4).group("wooden_ladders").define('#', planks).define('S', Items.STICK).pattern("S S").pattern("S#S").pattern("S S").unlockedBy(getHasName(planks), has(planks)), new OrCondition(new ModLoadedCondition("woodworks"), getQuarkCondition("variant_ladders")), consumer, getSaveLocation(ladder));
        conditionalRecipe(ShapedRecipeBuilder.shaped(bookshelf).group("wooden_bookshelves").define('#', planks).define('B', Items.BOOK).pattern("###").pattern("BBB").pattern("###").unlockedBy(getHasName(planks), has(planks)), new OrCondition(new ModLoadedCondition("woodworks"), getQuarkCondition("variant_bookshelves")), consumer, getSaveLocation(bookshelf));
        conditionalRecipe(ShapedRecipeBuilder.shaped(chest).group("wooden_chests").define('#', planks).pattern("###").pattern("# #").pattern("###").unlockedBy(getHasName(planks), has(planks)), new OrCondition(new ModLoadedCondition("woodworks"), getQuarkCondition("variant_chests")), consumer, getSaveLocation(chest));
        conditionalRecipe(ShapedRecipeBuilder.shaped(chest, 4).group("wooden_chests").define('#', logs).pattern("###").pattern("# #").pattern("###").unlockedBy("has_lots_of_items", new InventoryChangeTrigger.TriggerInstance(EntityPredicate.Composite.ANY, MinMaxBounds.Ints.atLeast(10), MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, new ItemPredicate[0])), new AndCondition(getQuarkCondition("wood_to_chest_recipes"), getQuarkCondition("variant_chests")), consumer, Horizons.REGISTRY_HELPER.prefix(getItemName(chest) + "_wood"));
        conditionalRecipe(ShapelessRecipeBuilder.shapeless(trappedChest).requires(chest).requires(Items.TRIPWIRE_HOOK).unlockedBy("has_lots_of_items", new InventoryChangeTrigger.TriggerInstance(EntityPredicate.Composite.ANY, MinMaxBounds.Ints.atLeast(10), MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, new ItemPredicate[0])), new OrCondition(new ModLoadedCondition("woodworks"), getQuarkCondition("variant_chests")), consumer, getSaveLocation(trappedChest));
        conditionalRecipe(ShapelessRecipeBuilder.shapeless(furnaceBoat).requires(Items.FURNACE).requires(boat).unlockedBy(getHasName(boat), has(boat)), new ModLoadedCondition("boatload"), consumer, getSaveLocation(furnaceBoat));
        conditionalRecipe(ShapedRecipeBuilder.shaped(largeBoat).group("wooden_chests").define('#', planks).define('B', boat).pattern("#B#").pattern("###").unlockedBy(getHasName(boat), has(boat)), new ModLoadedCondition("boatload"), consumer, getSaveLocation(largeBoat));
        conditionalRecipe(ShapedRecipeBuilder.shaped(verticalPlanks, 3).define('#', planks).pattern("#").pattern("#").pattern("#").unlockedBy(getHasName(planks), has(planks)), getQuarkCondition("vertical_planks"), consumer, getSaveLocation(verticalPlanks));
        conditionalRecipe(ShapelessRecipeBuilder.shapeless(planks).requires(verticalPlanks).unlockedBy(getHasName(verticalPlanks), has(verticalPlanks)), getQuarkCondition("vertical_planks"), consumer, Horizons.REGISTRY_HELPER.prefix(getItemName(verticalPlanks) + "_revert"));
        conditionalRecipe(ShapedRecipeBuilder.shaped(cabinet).define('#', slab).define('T', trapdoor).pattern("###").pattern("T T").pattern("###").unlockedBy(getHasName(trapdoor), has(trapdoor)), new ModLoadedCondition("farmersdelight"), consumer, getSaveLocation(cabinet));
    }

    private static void leafSet(TagKey<Item> log, ItemLike leaves, ItemLike hedge, ItemLike leafCarpet, ItemLike leafPile, Consumer<FinishedRecipe> consumer) {
        conditionalRecipe(ShapedRecipeBuilder.shaped(hedge, 2).define('#', log).define('L', leaves).pattern("L").pattern("#").unlockedBy(getHasName(leaves), has(leaves)), getQuarkCondition("hedges"), consumer, getSaveLocation(hedge));
        conditionalRecipe(ShapedRecipeBuilder.shaped(leafCarpet, 3).define('#', leaves).pattern("##").unlockedBy(getHasName(leaves), has(leaves)), getQuarkCondition("leaf_carpet"), consumer, getSaveLocation(leafCarpet));
        conditionalRecipe(ShapelessRecipeBuilder.shapeless(leafPile, 4).requires(leaves).unlockedBy(getHasName(leaves), has(leaves)), new ModLoadedCondition("woodworks"), consumer, getSaveLocation(leafPile));
        conditionalRecipe(ShapedRecipeBuilder.shaped(leaves).define('#', leafPile).pattern("##").pattern("##").unlockedBy(getHasName(leafPile), has(leafPile)), new ModLoadedCondition("woodworks"), consumer, Horizons.REGISTRY_HELPER.prefix(getItemName(leaves) + "_from_leaf_pile"));
    }

    private static void stoneBlockSet(ItemLike block, ItemLike slab, ItemLike stairs, ItemLike verticalSlab, ItemLike wall, Consumer<FinishedRecipe> consumer) {
        stonecutting(block, slab, 2, consumer);
        stonecutting(block, stairs, 1, consumer);
        stairs(block, stairs, consumer);
        slab(block, slab, consumer);
        verticalSlab(verticalSlab, slab, consumer);
        conditionalRecipe(SingleItemRecipeBuilder.stonecutting(Ingredient.of(block), verticalSlab, 2).unlockedBy(getHasName(block), has(block)), getQuarkCondition("vertical_slabs"), consumer, Horizons.REGISTRY_HELPER.prefix(getItemName(verticalSlab) + "_from_" + getItemName(block) + "_stonecutting"));
        stonecutting(block, wall, 1, consumer);
        wall(block, wall, consumer);
    }

    private static void flowerToDye(Block flower, Item dye, Consumer<FinishedRecipe> consumer) {
        String dyeName = getItemName(dye);
        ShapelessRecipeBuilder.shapeless(dye).group(dyeName).requires(flower).unlockedBy(getHasName(flower), has(flower)).save(consumer, Horizons.REGISTRY_HELPER.prefix(dyeName + "_from_" + getItemName(flower)));
    }

    private static void mossyBlock(ItemLike ingredient, ItemLike result, Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(result).requires(ingredient).requires(Items.MOSS_BLOCK).unlockedBy(getItemName(ingredient), has(ingredient)).save(consumer, getSaveLocation(result));
        ShapelessRecipeBuilder.shapeless(result).requires(ingredient).requires(Items.VINE).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, Horizons.REGISTRY_HELPER.prefix(getItemName(result) + "_from_vine"));
    }

    private static void stairs(ItemLike ingredient, ItemLike stairs, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(stairs, 4).define('#', ingredient).pattern("#  ").pattern("## ").pattern("###").unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, getSaveLocation(stairs));
    }

    private static void stairs(ItemLike ingredient, ItemLike stairs, String group, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(stairs, 4).group(group).define('#', ingredient).pattern("#  ").pattern("## ").pattern("###").unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, getSaveLocation(stairs));
    }

    private static void wall(ItemLike ingredient, ItemLike wall, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(wall, 6).define('#', ingredient).pattern("###").pattern("###").unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, getSaveLocation(wall));
    }

    private static void slab(ItemLike ingredient, ItemLike slab, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(slab, 6).define('#', ingredient).pattern("###").unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, getSaveLocation(slab));
    }

    private static void slab(ItemLike ingredient, ItemLike slab, String group, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(slab, 6).group(group).define('#', ingredient).pattern("###").unlockedBy(getItemName(ingredient), has(ingredient)).save(consumer, getSaveLocation(slab));
    }

    private static void verticalSlab(ItemLike verticalSlab, ItemLike slab, Consumer<FinishedRecipe> consumer) {
        conditionalRecipe(ShapedRecipeBuilder.shaped(verticalSlab, 3).define('#', slab).pattern("#").pattern("#").pattern("#").unlockedBy(getHasName(slab), has(slab)), getQuarkCondition("vertical_slabs"), consumer, getSaveLocation(verticalSlab));
        conditionalRecipe(ShapelessRecipeBuilder.shapeless(slab).requires(verticalSlab).unlockedBy(getHasName(verticalSlab), has(verticalSlab)), getQuarkCondition("vertical_slabs"), consumer, Horizons.REGISTRY_HELPER.prefix(getItemName(verticalSlab) + "_revert"));
    }

    private static void post(ItemLike post, ItemLike wood, Consumer<FinishedRecipe> consumer) {
        conditionalRecipe(ShapedRecipeBuilder.shaped(post, 8).define('#', wood).pattern("#").pattern("#").pattern("#").unlockedBy(getHasName(wood), has(wood)), getQuarkCondition("wooden_posts"), consumer, getSaveLocation(post));
    }

    private static void quarkCompressedBlock(ItemLike ingredient, ItemLike block, String flag, Consumer<FinishedRecipe> consumer) {
        ICondition condition = getQuarkCondition(flag);

        conditionalRecipe(ShapedRecipeBuilder.shaped(block).define('#', ingredient).pattern("###").pattern("###").pattern("###").unlockedBy(getHasName(ingredient), has(ingredient)), condition, consumer, getSaveLocation(block));
        conditionalRecipe(ShapelessRecipeBuilder.shapeless(ingredient, 9).requires(block).unlockedBy(getHasName(block), has(block)), condition, consumer, Horizons.REGISTRY_HELPER.prefix(getItemName(block) + "_revert"));
    }

    private static void stonecutting(ItemLike ingredient, ItemLike result, int amount, Consumer<FinishedRecipe> consumer) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredient), result, amount).unlockedBy(getHasName(ingredient), has(ingredient)).save(consumer, Horizons.REGISTRY_HELPER.prefix(getItemName(ingredient) + "_from_" + getItemName(result) + "_stonecutting"));
    }

    private static void conditionalRecipe(RecipeBuilder recipe, ICondition condition, Consumer<FinishedRecipe> consumer, ResourceLocation id) {
        ConditionalRecipe.builder().addCondition(condition).addRecipe(consumer1 -> recipe.save(consumer1, id)).generateAdvancement(new ResourceLocation(id.getNamespace(), "recipes/" + recipe.getResult().getItemCategory().getRecipeFolderName() + "/" + id.getPath())).build(consumer, id);
    }

    private static QuarkFlagRecipeCondition getQuarkCondition(String flag) {
        return new QuarkFlagRecipeCondition(new ResourceLocation("blueprint", "quark_flag"), flag);
    }

    private static ResourceLocation getSaveLocation(ItemLike item) {
        return ForgeRegistries.ITEMS.getKey(item.asItem());
    }

}
