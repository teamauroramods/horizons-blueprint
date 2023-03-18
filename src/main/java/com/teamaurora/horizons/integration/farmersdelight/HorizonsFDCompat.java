package com.teamaurora.horizons.integration.farmersdelight;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public final class HorizonsFDCompat {
    public static final Supplier<Block> CABINET_SUPPLIER = () -> new HorizonsCabinetBlock(BlockBehaviour.Properties.copy(Blocks.BARREL));
}
