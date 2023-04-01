package com.teamaurora.horizons.common.levelgen.modifier;

import com.mojang.serialization.Codec;
import com.teamaurora.horizons.core.registry.HorizonsFeatures;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;

import java.util.List;

/**
 * @author rose_
 */
public enum BoulderBiomeModifier implements BiomeModifier {
    INSTANCE;
    public static final Codec<BoulderBiomeModifier> CODEC = Codec.unit(INSTANCE);

    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        List<Holder<PlacedFeature>> placements = builder.getGenerationSettings().getFeatures(GenerationStep.Decoration.LOCAL_MODIFICATIONS);

        if (phase == Phase.REMOVE && placements.contains(MiscOverworldPlacements.FOREST_ROCK)) {
            float temp = builder.getClimateSettings().getTemperature();

            placements.remove(MiscOverworldPlacements.FOREST_ROCK);
            placements.add((temp > 0.75F ? HorizonsFeatures.Placements.LIGHT_BOULDER : HorizonsFeatures.Placements.DARK_BOULDER).getHolder().get());
        }
    }

    @Override
    public Codec<? extends BiomeModifier> codec() {
        return CODEC;
    }

}
