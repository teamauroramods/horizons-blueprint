package com.teamaurora.horizons.core.data.client;

import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.common.block.sign.BlueprintStandingSignBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintWallSignBlock;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import com.teamaurora.horizons.core.registry.HorizonsItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;
import java.util.function.Supplier;

/*
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
    }

    private void pottedPlant(RegistryObject<Block> plant, RegistryObject<Block> pot) {
        this.pot(pot, this.blockTexture(plant.get()));
        this.simpleCross(plant);
        this.generatedItem(plant.get(), TextureFolder.Block);
    }

    private void pot(RegistryObject<Block> pot, ResourceLocation texture) {
        ModelFile model = this.models().withExistingParent(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(pot.get())).getPath(), "block/flower_pot_cross").texture("plant", texture).renderType("cutout");
        this.simpleBlock(pot.get(), model);
    }

    private void trapdoor(RegistryObject<? extends Block> trapdoor) {
        String name = this.getItemName(trapdoor.get());
        this.trapdoorBlockWithRenderType((TrapDoorBlock) trapdoor.get(), this.blockTexture(trapdoor.get()), true, "cutout");
        this.itemModels().withExistingParent(name, this.modLoc("block/" + name + "_bottom"));
    }

    private void door(RegistryObject<? extends Block> door) {
        String name = "block/" + this.getItemName(door.get());
        this.doorBlockWithRenderType((DoorBlock) door.get(), this.getItemName(door.get()).replace("_door", ""), this.modLoc(name + "_bottom"), this.modLoc(name + "_top"), "cutout");
        this.generatedItem(door.get(), TextureFolder.Item);
    }

    private void button(RegistryObject<? extends Block> button, Supplier<? extends Block> textureBlock) {
        ResourceLocation texture = this.blockTexture(textureBlock.get());
        this.buttonBlock((ButtonBlock) button.get(), texture);
        this.itemModels().buttonInventory(this.getItemName(button.get()), texture);
    }

    private void pressurePlate(RegistryObject<? extends Block> pressurePlate, Supplier<? extends Block> textureBlock) {
        this.pressurePlateBlock((PressurePlateBlock) pressurePlate.get(), this.blockTexture(textureBlock.get()));
        this.itemModel(pressurePlate);
    }

    private void generatedItem(ItemLike item, TextureFolder folder) {
        String name = this.getItemName(item);
        this.itemModels().withExistingParent(name, "item/generated").texture("layer0", this.modLoc(folder.format(name)));
    }

    private void fence(RegistryObject<? extends Block> fence, Supplier<? extends Block> textureBlock) {
        ResourceLocation texture = this.blockTexture(textureBlock.get());
        this.fenceBlock((FenceBlock) fence.get(), texture);
        this.itemModels().fenceInventory(this.getItemName(fence.get()), texture);
    }

    private void fenceGate(RegistryObject<? extends Block> gate, Supplier<? extends Block> textureBlock) {
        this.fenceGateBlock((FenceGateBlock) gate.get(), this.blockTexture(textureBlock.get()));
        this.itemModel(gate);
    }

    private void slab(RegistryObject<? extends Block> slab, Supplier<? extends Block> textureBlock) {
        ResourceLocation texture = this.blockTexture(textureBlock.get());
        this.slabBlock((SlabBlock) slab.get(), texture, texture);
        this.itemModel(slab);
    }

    private void stairs(RegistryObject<? extends Block> stairs, Supplier<? extends Block> textureBlock) {
        this.stairsBlock((StairBlock) stairs.get(), this.blockTexture(textureBlock.get()));
        this.itemModel(stairs);
    }

    private void cubeAll(RegistryObject<? extends Block> block) {
        this.simpleBlock(block.get());
        this.itemModel(block);
    }

    private void cubeAll(RegistryObject<? extends Block> block, ResourceLocation texture) {
        this.simpleBlock(block.get(), this.models().cubeAll(this.getItemName(block.get()), texture));
        this.itemModel(block);
    }

    private void leaves(RegistryObject<? extends Block> leaves) {
        this.simpleBlock(leaves.get(), this.models().withExistingParent(this.getItemName(leaves.get()), "block/leaves").texture("all", this.blockTexture(leaves.get())).renderType("cutout"));
        this.itemModel(leaves);
    }

    private void simpleCross(RegistryObject<? extends Block> block) {
        this.simpleBlock(block.get(), this.models().cross(this.getItemName(block.get()), this.blockTexture(block.get())).renderType("cutout"));
    }

    private void signs(Pair<RegistryObject<BlueprintStandingSignBlock>, RegistryObject<BlueprintWallSignBlock>> signs, Supplier<? extends Block> textureBlock) {
        this.signBlock(signs.getFirst().get(), signs.getSecond().get(), this.blockTexture(textureBlock.get()));
        this.generatedItem(signs.getFirst().get(), TextureFolder.Item);
    }

    private void log(RegistryObject<? extends Block> log) {
        this.axisBlock((RotatedPillarBlock)log.get(), this.blockTexture(log.get()), this.modLoc("block/" + this.getItemName(log.get()) + "_top"));
        this.itemModel(log);
    }

    // Misc Util //

    private void itemModel(RegistryObject<? extends Block> block) {
        this.itemModels().withExistingParent(this.getItemName(block.get()), this.blockTexture(block.get()));
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