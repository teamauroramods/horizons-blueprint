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
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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
        ShapelessRecipeBuilder.shapeless(HorizonsItems.GOOSEBERRY_JUICE.get()).requires(Items.GLASS_BOTTLE).requires(HorizonsItems.GOOSEBERRIES.get(), 3).unlockedBy("has_gooseberries", has(HorizonsItems.GOOSEBERRIES.get())).save(consumer, getSaveLocation(HorizonsItems.GOOSEBERRY_JUICE.get()));
        ShapelessRecipeBuilder.shapeless(Items.SUGAR, 3).requires(HorizonsItems.GOOSEBERRY_JUICE.get()).unlockedBy("has_gooseberry_juice", has(HorizonsItems.GOOSEBERRY_JUICE.get())).save(consumer, Horizons.REGISTRY_HELPER.prefix("gooseberry_juice_to_sugar"));
        ShapelessRecipeBuilder.shapeless(HorizonsItems.HONEY_GLAZED_GOOSEBERRIES.get()).requires(HorizonsItems.GOOSEBERRIES.get()).requires(Items.HONEY_BOTTLE).unlockedBy("has_gooseberries", has(HorizonsItems.GOOSEBERRIES.get())).save(consumer, getSaveLocation(HorizonsItems.HONEY_GLAZED_GOOSEBERRIES.get()));
        ShapelessRecipeBuilder.shapeless(HorizonsItems.GOOSEBERRY_JAM_COOKIE.get(), 8).requires(HorizonsItems.GOOSEBERRY_JAM.get()).requires(Items.WHEAT, 2).unlockedBy("has_gooseberry_jam", has(HorizonsItems.GOOSEBERRY_JAM.get())).save(consumer, getSaveLocation(HorizonsItems.GOOSEBERRY_JAM_COOKIE.get()));
        ShapelessRecipeBuilder.shapeless(HorizonsItems.GOOSEBERRY_PIE.get()).requires(HorizonsItems.GOOSEBERRIES.get()).requires(Tags.Items.EGGS).requires(Items.SUGAR).unlockedBy("has_gooseberries", has(HorizonsItems.GOOSEBERRIES.get())).save(consumer, getSaveLocation(HorizonsItems.GOOSEBERRY_PIE.get()));
        ShapelessRecipeBuilder.shapeless(HorizonsItems.GOOSEBERRY_JAM.get(), 3).requires(HorizonsItems.HONEY_GLAZED_GOOSEBERRIES.get()).requires(Items.GLASS_BOTTLE, 3).unlockedBy("has_honey_glazed_gooseberries", has(HorizonsItems.HONEY_GLAZED_GOOSEBERRIES.get())).save(consumer, getSaveLocation(HorizonsItems.GOOSEBERRY_JAM.get()));
        ShapelessRecipeBuilder.shapeless(Items.SUGAR, 3).requires(HorizonsItems.GOOSEBERRY_JAM.get()).unlockedBy("has_gooseberry_jam", has(HorizonsItems.GOOSEBERRY_JAM.get())).save(consumer, Horizons.REGISTRY_HELPER.prefix("gooseberry_jam_to_sugar"));
        quarkCompressedBlock(HorizonsItems.GOOSEBERRIES.get(), HorizonsBlocks.GOOSEBERRY_SACK.get(), "berry_sack", consumer);
        ShapedRecipeBuilder.shaped(HorizonsBlocks.ALGAE_THATCH.get(), 4).define('#', HorizonsBlocks.ALGAE.get()).pattern("##").pattern("##").unlockedBy("has_algae", has(HorizonsBlocks.ALGAE.get())).save(consumer, getSaveLocation(HorizonsBlocks.ALGAE_THATCH.get()));
        slab(HorizonsBlocks.ALGAE_THATCH.get(), HorizonsBlocks.ALGAE_THATCH_SLAB.get(), consumer);
        stairs(HorizonsBlocks.ALGAE_THATCH.get(), HorizonsBlocks.ALGAE_THATCH_STAIRS.get(), consumer);
        verticalSlab(HorizonsBlocks.ALGAE_THATCH_VERTICAL_SLAB.get(), HorizonsBlocks.ALGAE_THATCH_SLAB.get(), consumer);
        woodSet("cypress", HorizonsItemTags.CYPRESS_LOGS, HorizonsBlocks.CYPRESS_PLANKS.get(), HorizonsBlocks.CYPRESS_SLAB.get(), HorizonsBlocks.CYPRESS_STAIRS.get(), HorizonsBlocks.CYPRESS_LOG.get(), HorizonsBlocks.CYPRESS_WOOD.get(), HorizonsBlocks.STRIPPED_CYPRESS_LOG.get(), HorizonsBlocks.STRIPPED_CYPRESS_WOOD.get(), HorizonsItems.CYPRESS_BOATS.getFirst().get(),  HorizonsItems.CYPRESS_BOATS.getSecond().get(), HorizonsBlocks.CYPRESS_BUTTON.get(), HorizonsBlocks.CYPRESS_DOOR.get(), HorizonsBlocks.CYPRESS_TRAPDOOR.get(), HorizonsBlocks.CYPRESS_FENCE.get(), HorizonsBlocks.CYPRESS_FENCE_GATE.get(), HorizonsBlocks.CYPRESS_PRESSURE_PLATE.get(), HorizonsBlocks.CYPRESS_SIGNS.getFirst().get(), HorizonsBlocks.CYPRESS_VERTICAL_SLAB.get(), HorizonsBlocks.CYPRESS_POST.get(), HorizonsBlocks.STRIPPED_CYPRESS_POST.get(), HorizonsBlocks.CYPRESS_BOARDS.get(), HorizonsBlocks.CYPRESS_BEEHIVE.get(), HorizonsBlocks.CYPRESS_LADDER.get(), HorizonsBlocks.CYPRESS_BOOKSHELF.get(), HorizonsBlocks.CYPRESS_CHEST.get(), HorizonsBlocks.CYPRESS_TRAPPED_CHEST.get(), HorizonsItems.LARGE_CYPRESS_BOAT.get(), HorizonsItems.CYPRESS_FURNACE_BOAT.get(), HorizonsBlocks.VERTICAL_CYPRESS_PLANKS.get(), consumer);
        leafSet(HorizonsItemTags.CYPRESS_LOGS, HorizonsBlocks.CYPRESS_LEAVES.get(), HorizonsBlocks.CYPRESS_HEDGE.get(), HorizonsBlocks.CYPRESS_LEAF_CARPET.get(), HorizonsBlocks.CYPRESS_LEAF_PILE.get(), consumer);
        flowerToDye(HorizonsBlocks.BLUE_LILY.get(), Items.BLUE_DYE, consumer);
        flowerToDye(HorizonsBlocks.LIGHT_GRAY_LILY.get(), Items.LIGHT_GRAY_DYE, consumer);
        flowerToDye(HorizonsBlocks.CYAN_LILY.get(), Items.CYAN_DYE, consumer);
        flowerToDye(HorizonsBlocks.LIGHT_BLUE_LILY.get(), Items.LIGHT_BLUE_DYE, consumer);
        flowerToDye(HorizonsBlocks.MAGENTA_LILY.get(), Items.MAGENTA_DYE, consumer);
        flowerToDye(HorizonsBlocks.PINK_LILY.get(), Items.PINK_DYE, consumer);
        flowerToDye(HorizonsBlocks.PURPLE_LILY.get(), Items.PURPLE_DYE, consumer);
        flowerToDye(HorizonsBlocks.WHITE_LILY.get(), Items.WHITE_DYE, consumer);
    }

    private static void woodSet(String name, TagKey<Item> logs, Block planks, Block slab, Block stairs, Block log, Block wood, Block strippedLog, Block strippedWood, ItemLike boat, ItemLike chestBoat, Block button, Block door, Block trapdoor, Block fence, Block fenceGate, Block pressurePlate, Block sign, Block verticalSlab, Block post, Block strippedPost, Block boards, Block beehive, Block ladder, Block bookshelf, Block chest, Block trappedChest, Item largeBoat, Item furnaceBoat, Block verticalPlanks, Consumer<FinishedRecipe> consumer) {
        woodenBoat(consumer, boat, planks);
        ShapelessRecipeBuilder.shapeless(chestBoat).group("chest_boat").requires(Tags.Items.CHESTS_WOODEN).requires(boat).unlockedBy("has_" + getItemName(boat), has(boat)).save(consumer, getSaveLocation(chestBoat));
        ShapelessRecipeBuilder.shapeless(button).group("wooden_button").requires(planks).unlockedBy("has_" + name + "_planks", has(planks)).save(consumer, getSaveLocation(button));
        ShapedRecipeBuilder.shaped(door, 3).group("wooden_door").define('#', planks).pattern("##").pattern("##").pattern("##").unlockedBy("has_" + name + "_planks", has(planks)).save(consumer, getSaveLocation(door));
        ShapedRecipeBuilder.shaped(fence, 3).group("wooden_fence").define('#', planks).define('S', Items.STICK).pattern("#S#").pattern("#S#").unlockedBy("has_" + name + "_planks", has(planks)).save(consumer, getSaveLocation(fence));
        ShapedRecipeBuilder.shaped(fenceGate).group("wooden_fence_gate").define('#', planks).define('S', Items.STICK).pattern("S#S").pattern("S#S").unlockedBy("has_" + name + "_planks", has(planks)).save(consumer, getSaveLocation(fenceGate));
        ShapedRecipeBuilder.shaped(pressurePlate).group("wooden_pressure_plate").define('#', planks).pattern("##").unlockedBy("has_" + name + "_planks", has(planks)).save(consumer, getSaveLocation(pressurePlate));
        ShapedRecipeBuilder.shaped(sign, 3).group("wooden_sign").define('#', planks).define('S', Items.STICK).pattern("###").pattern("###").pattern(" S ").unlockedBy("has_" + name + "_planks", has(planks)).save(consumer, getSaveLocation(sign));
        ShapedRecipeBuilder.shaped(trapdoor, 2).group("wooden_trapdoor").define('#', planks).pattern("###").pattern("###").unlockedBy("has_" + name + "_planks", has(planks)).save(consumer, getSaveLocation(trapdoor));
        planksFromLogs(consumer, planks, logs);
        woodFromLogs(consumer, wood, log);
        woodFromLogs(consumer, strippedWood, strippedLog);
        slab(planks, slab, "wooden_slab", consumer);
        stairs(planks, stairs, "wooden_stairs", consumer);
        verticalSlab(verticalSlab, slab, consumer);
        post(post, wood, consumer);
        post(strippedPost, strippedWood, consumer);
        conditionalRecipe(ShapedRecipeBuilder.shaped(boards, 3).group("wooden_boards").define('#', planks).pattern("#").pattern("#").pattern("#").unlockedBy("has_" + name + "_planks", has(planks)), new ModLoadedCondition("woodworks"), consumer, getSaveLocation(boards));
        conditionalRecipe(ShapedRecipeBuilder.shaped(beehive).group("wooden_beehive").define('#', planks).define('H', Items.HONEYCOMB).pattern("###").pattern("HHH").pattern("###").unlockedBy("has_" + name + "_planks", has(planks)), new ModLoadedCondition("woodworks"), consumer, getSaveLocation(beehive));
        conditionalRecipe(ShapedRecipeBuilder.shaped(ladder, 4).group("wooden_ladders").define('#', planks).define('S', Items.STICK).pattern("S S").pattern("S#S").pattern("S S").unlockedBy("has_" + name + "_planks", has(planks)), new OrCondition(new ModLoadedCondition("woodworks"), getQuarkCondition("variant_ladders")), consumer, getSaveLocation(ladder));
        conditionalRecipe(ShapedRecipeBuilder.shaped(bookshelf).group("wooden_bookshelves").define('#', planks).define('B', Items.BOOK).pattern("###").pattern("BBB").pattern("###").unlockedBy("has_" + name + "_planks", has(planks)), new OrCondition(new ModLoadedCondition("woodworks"), getQuarkCondition("variant_bookshelves")), consumer, getSaveLocation(bookshelf));
        conditionalRecipe(ShapedRecipeBuilder.shaped(chest).group("wooden_chests").define('#', planks).pattern("###").pattern("# #").pattern("###").unlockedBy("has_" + name + "_planks", has(planks)), new OrCondition(new ModLoadedCondition("woodworks"), getQuarkCondition("variant_chests")), consumer, getSaveLocation(chest));
        conditionalRecipe(ShapedRecipeBuilder.shaped(chest, 4).group("wooden_chests").define('#', logs).pattern("###").pattern("# #").pattern("###").unlockedBy("has_lots_of_items", new InventoryChangeTrigger.TriggerInstance(EntityPredicate.Composite.ANY, MinMaxBounds.Ints.atLeast(10), MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, new ItemPredicate[0])), new AndCondition(getQuarkCondition("wood_to_chest_recipes"), getQuarkCondition("variant_chests")), consumer, Horizons.REGISTRY_HELPER.prefix(getItemName(chest) + "_wood"));
        conditionalRecipe(ShapelessRecipeBuilder.shapeless(trappedChest).requires(chest).requires(Items.TRIPWIRE_HOOK).unlockedBy("has_lots_of_items", new InventoryChangeTrigger.TriggerInstance(EntityPredicate.Composite.ANY, MinMaxBounds.Ints.atLeast(10), MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, new ItemPredicate[0])), new OrCondition(new ModLoadedCondition("woodworks"), getQuarkCondition("variant_chests")), consumer, getSaveLocation(trappedChest));
        conditionalRecipe(ShapelessRecipeBuilder.shapeless(furnaceBoat).requires(Items.FURNACE).requires(boat).unlockedBy("has_" + name + "_boat", has(boat)), new ModLoadedCondition("boatload"), consumer, getSaveLocation(furnaceBoat));
        conditionalRecipe(ShapedRecipeBuilder.shaped(largeBoat).group("wooden_chests").define('#', planks).define('B', boat).pattern("#B#").pattern("###").unlockedBy("has_" + name + "_boat", has(boat)), new ModLoadedCondition("boatload"), consumer, getSaveLocation(largeBoat));
        conditionalRecipe(ShapedRecipeBuilder.shaped(verticalPlanks, 3).define('#', planks).pattern("#").pattern("#").pattern("#").unlockedBy("has_" + name + "_planks", has(planks)), getQuarkCondition("vertical_planks"), consumer, getSaveLocation(verticalPlanks));
        conditionalRecipe(ShapelessRecipeBuilder.shapeless(planks).requires(verticalPlanks).unlockedBy("has_" + name + "_vertical_planks", has(verticalPlanks)), getQuarkCondition("vertical_planks"), consumer, Horizons.REGISTRY_HELPER.prefix(getItemName(verticalPlanks) + "_revert"));
    }

    private static void leafSet(TagKey<Item> log, ItemLike leaves, ItemLike hedge, ItemLike leafCarpet, ItemLike leafPile, Consumer<FinishedRecipe> consumer) {
        conditionalRecipe(ShapedRecipeBuilder.shaped(hedge, 2).define('#', log).define('L', leaves).pattern("L").pattern("#").unlockedBy("has_leaves", has(leaves)), getQuarkCondition("hedges"), consumer, getSaveLocation(hedge));
        conditionalRecipe(ShapedRecipeBuilder.shaped(leafCarpet, 3).define('#', leaves).pattern("##").unlockedBy("has_leaves", has(leaves)), getQuarkCondition("leaf_carpet"), consumer, getSaveLocation(leafCarpet));
        conditionalRecipe(ShapelessRecipeBuilder.shapeless(leafPile, 4).requires(leaves).unlockedBy("has_leaves", has(leaves)), new ModLoadedCondition("woodworks"), consumer, getSaveLocation(leafPile));
        conditionalRecipe(ShapedRecipeBuilder.shaped(leaves).define('#', leafPile).pattern("##").pattern("##").unlockedBy("has_leaf_pile", has(leafPile)), new ModLoadedCondition("woodworks"), consumer, Horizons.REGISTRY_HELPER.prefix(getItemName(leaves) + "_from_leaf_pile"));
    }

    private static void flowerToDye(Block flower, Item dye, Consumer<FinishedRecipe> consumer) {
        String flowerName = getItemName(flower);
        String dyeName = getItemName(dye);
        ShapelessRecipeBuilder.shapeless(dye).group(dyeName).requires(flower).unlockedBy("has_" + flowerName, has(flower)).save(consumer, Horizons.REGISTRY_HELPER.prefix(dyeName + "_from_" + flowerName));
    }

    private static void stairs(ItemLike ingredient, ItemLike stairs, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(stairs, 4).define('#', ingredient).pattern("#  ").pattern("## ").pattern("###").unlockedBy("has_" + getItemName(ingredient), has(ingredient)).save(consumer, getSaveLocation(stairs));
    }

    private static void stairs(ItemLike ingredient, ItemLike stairs, String group, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(stairs, 4).group(group).define('#', ingredient).pattern("#  ").pattern("## ").pattern("###").unlockedBy("has_" + getItemName(ingredient), has(ingredient)).save(consumer, getSaveLocation(stairs));
    }

    private static void wall(ItemLike ingredient, ItemLike wall, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(wall, 6).define('#', ingredient).pattern("###").pattern("###").unlockedBy("has_" + getItemName(ingredient), has(ingredient)).save(consumer, getSaveLocation(wall));
    }

    private static void slab(ItemLike ingredient, ItemLike slab, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(slab, 6).define('#', ingredient).pattern("###").unlockedBy("has_" + getItemName(ingredient), has(ingredient)).save(consumer, getSaveLocation(slab));
    }

    private static void slab(ItemLike ingredient, ItemLike slab, String group, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(slab, 6).group(group).define('#', ingredient).pattern("###").unlockedBy("has_" + getItemName(ingredient), has(ingredient)).save(consumer, getSaveLocation(slab));
    }

    private static void verticalSlab(ItemLike verticalSlab, ItemLike slab, Consumer<FinishedRecipe> consumer) {
        conditionalRecipe(ShapedRecipeBuilder.shaped(verticalSlab, 3).define('#', slab).pattern("#").pattern("#").pattern("#").unlockedBy("has_slab", has(slab)), getQuarkCondition("vertical_slabs"), consumer, getSaveLocation(verticalSlab));
        conditionalRecipe(ShapelessRecipeBuilder.shapeless(slab).requires(verticalSlab).unlockedBy("has_vertical_slab", has(verticalSlab)), getQuarkCondition("vertical_slabs"), consumer, Horizons.REGISTRY_HELPER.prefix(getItemName(verticalSlab) + "_revert"));
    }

    private static void post(ItemLike post, ItemLike wood, Consumer<FinishedRecipe> consumer) {
        conditionalRecipe(ShapedRecipeBuilder.shaped(post, 8).define('#', wood).pattern("#").pattern("#").pattern("#").unlockedBy("has_wood", has(wood)), getQuarkCondition("wooden_posts"), consumer, getSaveLocation(post));
    }

    private static void quarkCompressedBlock(ItemLike ingredient, ItemLike block, String flag, Consumer<FinishedRecipe> consumer) {
        String ingredientName = getItemName(ingredient);
        String blockName = getItemName(block);
        ICondition condition = getQuarkCondition(flag);

        conditionalRecipe(ShapedRecipeBuilder.shaped(block).define('#', ingredient).pattern("###").pattern("###").pattern("###").unlockedBy("has_" + ingredientName, has(ingredient)), condition, consumer, Horizons.REGISTRY_HELPER.prefix(blockName));
        conditionalRecipe(ShapelessRecipeBuilder.shapeless(ingredient, 9).requires(block).unlockedBy("has_" + blockName, has(block)), condition, consumer, Horizons.REGISTRY_HELPER.prefix(blockName + "_revert"));
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
