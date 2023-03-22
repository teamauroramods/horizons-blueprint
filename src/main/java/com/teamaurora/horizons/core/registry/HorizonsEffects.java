package com.teamaurora.horizons.core.registry;

import com.teamabnormals.blueprint.core.util.DataUtil;
import com.teamaurora.horizons.common.effect.SupportiveEffect;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.registry.util.EffectSubRegistryHelper;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * @author rose_
 */
@Mod.EventBusSubscriber(modid = Horizons.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class HorizonsEffects {
    public static final EffectSubRegistryHelper HELPER = Horizons.REGISTRY_HELPER.getSubHelper(ForgeRegistries.MOB_EFFECTS);

    // Effects //

    public static final RegistryObject<MobEffect> SUPPORTIVE = HELPER.createEffect("supportive", SupportiveEffect::new);

    // Potions //

    public static final RegistryObject<Potion> SUPPORTIVE_NORMAL = HELPER.createPotion("supportive", SUPPORTIVE, 1800, 0);
    public static final RegistryObject<Potion> SUPPORTIVE_LONG = HELPER.createPotion("supportive_long", SUPPORTIVE, 3600, 0);
    public static final RegistryObject<Potion> SUPPORTIVE_STRONG = HELPER.createPotion("supportive_strong", SUPPORTIVE, 864, 1);


    public static void registerPotionRecipes() {
        DataUtil.addMix(Potions.AWKWARD, HorizonsBlocks.LAVENDER.get().asItem(), SUPPORTIVE_NORMAL.get());
        DataUtil.addMix(SUPPORTIVE_NORMAL.get(), Items.GLOWSTONE_DUST, SUPPORTIVE_STRONG.get());
        DataUtil.addMix(SUPPORTIVE_NORMAL.get(), Items.REDSTONE, SUPPORTIVE_LONG.get());
    }

}
