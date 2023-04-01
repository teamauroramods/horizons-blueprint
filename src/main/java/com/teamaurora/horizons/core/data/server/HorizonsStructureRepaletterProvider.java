package com.teamaurora.horizons.core.data.server;

import com.teamabnormals.blueprint.common.world.modification.structure.SimpleStructureRepaletter;
import com.teamabnormals.blueprint.common.world.modification.structure.StructureRepaletterProvider;
import com.teamabnormals.blueprint.core.util.modification.selection.ConditionedResourceSelector;
import com.teamabnormals.blueprint.core.util.modification.selection.selectors.NamesResourceSelector;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * @author rose_
 */
public class HorizonsStructureRepaletterProvider extends StructureRepaletterProvider {

    public HorizonsStructureRepaletterProvider(GatherDataEvent event) {
        super(event.getGenerator(), Horizons.MODID);
    }

    @Override
    protected void registerRepaletters() {
        //swamp hut
        this.register(BuiltinStructures.SWAMP_HUT, Blocks.POTTED_RED_MUSHROOM, HorizonsBlocks.POTTED_PINK_LILY.get());
        this.register(BuiltinStructures.SWAMP_HUT, Blocks.SPRUCE_PLANKS, HorizonsBlocks.CYPRESS_PLANKS.get());
        this.register(BuiltinStructures.SWAMP_HUT, Blocks.SPRUCE_STAIRS, HorizonsBlocks.CYPRESS_STAIRS.get());

        //villages
        this.register(BuiltinStructures.VILLAGE_PLAINS, Blocks.DANDELION, HorizonsBlocks.YELLOW_DAISY.get());
    }

    private void register(ResourceKey<Structure> structure, Block replacesBlock, Block replacesWith, ICondition... conditions) {
        this.registerRepaletter(structure.location().getPath() + "/" + getBlockName(replacesWith) + "_replaces_" + getBlockName(replacesBlock),
                new ConditionedResourceSelector(new NamesResourceSelector(structure.location()), conditions), EventPriority.NORMAL, new SimpleStructureRepaletter(replacesBlock, replacesWith));
    }

    private static String getBlockName(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }

}
