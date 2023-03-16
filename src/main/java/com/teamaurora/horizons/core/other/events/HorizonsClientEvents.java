package com.teamaurora.horizons.core.other.events;

import com.teamabnormals.blueprint.core.util.DataUtil;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.List;

/**
 * @author rose_
 */
@Mod.EventBusSubscriber(modid = Horizons.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class HorizonsClientEvents {
    private static final List<RegistryObject<Block>> FOLIAGE_COLOR_BLOCKS = Arrays.asList(HorizonsBlocks.CYPRESS_LEAVES, HorizonsBlocks.CYPRESS_HEDGE, HorizonsBlocks.CYPRESS_LEAF_CARPET, HorizonsBlocks.CYPRESS_LEAF_PILE, HorizonsBlocks.HANGING_CYPRESS_LEAVES);
    private static final List<RegistryObject<Block>> LILY_COLOR_BLOCKS = Arrays.asList(HorizonsBlocks.BLUE_LILY, HorizonsBlocks.LIGHT_GRAY_LILY, HorizonsBlocks.CYAN_LILY, HorizonsBlocks.LIGHT_BLUE_LILY, HorizonsBlocks.MAGENTA_LILY, HorizonsBlocks.PINK_LILY, HorizonsBlocks.PURPLE_LILY, HorizonsBlocks.WHITE_LILY);
    private static final List<RegistryObject<Block>> TALL_GRASS_COLOR_BLOCKS = Arrays.asList(HorizonsBlocks.GIANT_FERN);

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        DataUtil.registerBlockItemColor(event.getItemColors(), (stack, c) -> event.getBlockColors().getColor(((BlockItem) stack.getItem()).getBlock().defaultBlockState(), null, null, c), FOLIAGE_COLOR_BLOCKS);
        DataUtil.registerBlockItemColor(event.getItemColors(), (stack, c) -> GrassColor.get(0.5D, 1.0D), TALL_GRASS_COLOR_BLOCKS);
    }

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        DataUtil.registerBlockColor(event.getBlockColors(), (state, tint, pos, u) -> pos != null && tint != null ? BiomeColors.getAverageFoliageColor(tint, pos) : FoliageColor.getDefaultColor(), FOLIAGE_COLOR_BLOCKS);
        DataUtil.registerBlockColor(event.getBlockColors(), (state, tint, pos, u) -> tint != null && pos != null ? 2129968 : 7455580, LILY_COLOR_BLOCKS);
        DataUtil.registerBlockColor(event.getBlockColors(), (state, tint, pos, u) -> tint != null && pos != null ? BiomeColors.getAverageGrassColor(tint, state.getValue(DoublePlantBlock.HALF) == DoubleBlockHalf.UPPER ? pos.below() : pos) : -1, TALL_GRASS_COLOR_BLOCKS);
    }

}
