package com.teamaurora.horizons.core.registry;

import com.teamabnormals.blueprint.core.util.registry.BiomeSubRegistryHelper;
import com.teamaurora.horizons.core.Horizons;
import net.minecraft.util.Mth;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Horizons.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HorizonsBiomes {
    public static final BiomeSubRegistryHelper HELPER = Horizons.REGISTRY_HELPER.getBiomeSubHelper();


    private static int calculateSkyColor(float temperature) {
        float clampedTemp = Mth.clamp(temperature / 3.0F, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - clampedTemp * 0.05F, 0.5F + clampedTemp * 0.1F, 1.0F);
    }

}
