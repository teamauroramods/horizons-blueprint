package com.teamaurora.horizons.core.other.events;

import com.teamabnormals.blueprint.core.util.DataUtil;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
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

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        DataUtil.registerBlockItemColor(event.getItemColors(), (stack, c) -> event.getBlockColors().getColor(((BlockItem) stack.getItem()).getBlock().defaultBlockState(), null, null, c), FOLIAGE_COLOR_BLOCKS);
    }

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        DataUtil.registerBlockColor(event.getBlockColors(), (state, tint, pos, u) -> pos != null && tint != null ? BiomeColors.getAverageFoliageColor(tint, pos) : FoliageColor.getDefaultColor(), FOLIAGE_COLOR_BLOCKS);
    }

}
