package com.teamaurora.horizons.core;

import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import com.teamaurora.horizons.core.data.client.HorizonsLanguageProvider;
import com.teamaurora.horizons.core.data.client.HorizonsModelProvider;
import com.teamaurora.horizons.core.data.server.HorizonsLootTableProvider;
import com.teamaurora.horizons.core.data.server.HorizonsRecipeProvider;
import com.teamaurora.horizons.core.data.server.HorizonsStructureRepaletterProvider;
import com.teamaurora.horizons.core.data.server.modifiers.HorizonsAdvancementModifierProvider;
import com.teamaurora.horizons.core.data.server.modifiers.HorizonsBiomeModifier;
import com.teamaurora.horizons.core.data.server.modifiers.HorizonsModdedBiomeSliceProvider;
import com.teamaurora.horizons.core.data.server.tags.HorizonsBiomeTagsProvider;
import com.teamaurora.horizons.core.data.server.tags.HorizonsBlockTagsProvider;
import com.teamaurora.horizons.core.data.server.tags.HorizonsItemTagsProvider;
import com.teamaurora.horizons.core.other.HorizonsBlockInfo;
import com.teamaurora.horizons.core.other.HorizonsFeatures;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

/**
 * @author rose_
 */
@Mod(Horizons.MODID)
public class Horizons {
    public static final String MODID = "horizons";
    public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MODID);

    public Horizons() {
        final IEventBus bus = Mod.EventBusSubscriber.Bus.MOD.bus().get();
        final ModLoadingContext context = ModLoadingContext.get();

        MinecraftForge.EVENT_BUS.register(this);
        HorizonsFeatures.FEATURES.register(bus);
        HorizonsFeatures.Features.CONFIGURED_FEATURES.register(bus);
        HorizonsFeatures.Placements.PLACED_FEATURES.register(bus);

        REGISTRY_HELPER.register(bus);

        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);
        bus.addListener(this::dataSetup);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            HorizonsBlockInfo.registerCompostables();
            HorizonsBlockInfo.registerFlammables();
        });
    }

    private void clientSetup(FMLClientSetupEvent event) {

    }

    private void dataSetup(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        boolean client = event.includeClient();
        boolean server = event.includeServer();

        gen.addProvider(client, new HorizonsLanguageProvider(event));
        gen.addProvider(client, new HorizonsModelProvider(event));

        gen.addProvider(server, new HorizonsRecipeProvider(event));
        gen.addProvider(server, new HorizonsBlockTagsProvider(event));
        gen.addProvider(server, new HorizonsBiomeTagsProvider(event));
        gen.addProvider(server, new HorizonsItemTagsProvider(event));
        gen.addProvider(server, new HorizonsLootTableProvider(event));
        gen.addProvider(server, new HorizonsAdvancementModifierProvider(event));
        gen.addProvider(server, new HorizonsStructureRepaletterProvider(event));
        gen.addProvider(server, new HorizonsModdedBiomeSliceProvider(event));
        gen.addProvider(server, HorizonsBiomeModifier.register(event));
    }

}
