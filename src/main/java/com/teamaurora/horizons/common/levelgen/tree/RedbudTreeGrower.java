package com.teamaurora.horizons.common.levelgen.tree;

import com.teamaurora.horizons.core.registry.HorizonsFeatures;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class RedbudTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource rand, boolean bees) {
        return HorizonsFeatures.TreeFeatures.REDBUD_TREES.getHolder().get();
    }

}
