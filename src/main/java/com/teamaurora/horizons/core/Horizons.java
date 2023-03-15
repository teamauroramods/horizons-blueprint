package com.teamaurora.horizons.core;

import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import com.teamaurora.horizons.core.data.client.HorizonsLanguageProvider;
import com.teamaurora.horizons.core.data.client.HorizonsModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

/*
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

        REGISTRY_HELPER.register(bus);

        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);
        bus.addListener(this::dataSetup);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    private void clientSetup(FMLClientSetupEvent event) {
    }

    private void dataSetup(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        boolean client = event.includeClient();
        boolean server = event.includeServer();

        gen.addProvider(client, new HorizonsLanguageProvider(event));
        gen.addProvider(client, new HorizonsModelProvider(event));
    }

}
