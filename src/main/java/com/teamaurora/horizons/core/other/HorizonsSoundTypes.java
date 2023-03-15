package com.teamaurora.horizons.core.other;

import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.util.ForgeSoundType;

public final class HorizonsSoundTypes {
    public static final ForgeSoundType ALGAE = new ForgeSoundType(1F, 2.0F, () -> SoundEvents.LILY_PAD_PLACE, () -> SoundEvents.MOSS_CARPET_STEP, () -> SoundEvents.LILY_PAD_PLACE, () -> SoundEvents.MOSS_CARPET_HIT, () -> SoundEvents.MOSS_CARPET_FALL);
    public static final ForgeSoundType ALGAE_THATCH = new ForgeSoundType(1.0F, 0.7F, () -> SoundEvents.ROOTS_BREAK, () -> SoundEvents.ROOTS_STEP, () -> SoundEvents.ROOTS_PLACE, () -> SoundEvents.GRASS_HIT, () -> SoundEvents.ROOTS_FALL);
}
