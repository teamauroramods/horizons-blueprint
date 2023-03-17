package com.teamaurora.horizons.core.other.events;

import com.teamaurora.horizons.common.block.cypress.DoubleCypressKneeBlock;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.registry.HorizonsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * @author rose_
 */
@Mod.EventBusSubscriber(modid = Horizons.MODID)
public class HorizonsEntityEvents {

    @SubscribeEvent
    public static void onToolModified(BlockEvent.BlockToolModificationEvent event) {
        ToolAction action = event.getToolAction();
        BlockState state = event.getState();

        //cypress knee axe stripping
        if(action.equals(ToolActions.AXE_STRIP) && !event.isSimulated())
            if (state.is(HorizonsBlocks.CYPRESS_KNEE.get()))
                event.setFinalState(HorizonsBlocks.STRIPPED_CYPRESS_KNEE.get().defaultBlockState());
            else if (state.is(HorizonsBlocks.LARGE_CYPRESS_KNEE.get())) {
                BlockPos pos = state.getValue(DoubleCypressKneeBlock.HALF) == DoubleBlockHalf.UPPER ? event.getPos().below() : event.getPos();
                DoubleCypressKneeBlock.placeAt(HorizonsBlocks.STRIPPED_LARGE_CYPRESS_KNEE.get(), event.getLevel(), pos, 3);
                event.setFinalState(HorizonsBlocks.STRIPPED_LARGE_CYPRESS_KNEE.get().withPropertiesOf(state));
            }
    }

}
