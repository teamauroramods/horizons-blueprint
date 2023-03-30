package com.teamaurora.horizons.core.registry;

import com.mojang.serialization.Codec;
import com.teamaurora.horizons.common.levelgen.modifier.BoulderBiomeModifier;
import com.teamaurora.horizons.core.Horizons;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author rose_
 */
public final class HorizonsBiomeModifierSerializers {
    public static final DeferredRegister<Codec<? extends BiomeModifier>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, Horizons.MODID);

    public static final RegistryObject<Codec<? extends BiomeModifier>> BOULDERS = SERIALIZERS.register("boulders", () -> BoulderBiomeModifier.CODEC);
}
