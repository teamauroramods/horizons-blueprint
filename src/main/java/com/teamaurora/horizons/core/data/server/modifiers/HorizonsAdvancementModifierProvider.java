package com.teamaurora.horizons.core.data.server.modifiers;

import com.teamabnormals.blueprint.common.advancement.modification.AdvancementModifierProvider;
import com.teamabnormals.blueprint.common.advancement.modification.modifiers.CriteriaModifier;
import com.teamaurora.horizons.core.Horizons;
import com.teamaurora.horizons.core.registry.HorizonsItems;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * @author rose_
 */
public class HorizonsAdvancementModifierProvider extends AdvancementModifierProvider {
    public HorizonsAdvancementModifierProvider(GatherDataEvent event) {
        super(event.getGenerator(), Horizons.MODID);
    }

    @Override
    protected void registerEntries() {
        this.entry("balanced_diet").selects("husbandry/balanced_diet").addModifier(this.food().requirements(RequirementsStrategy.AND).build());
    }

    private CriteriaModifier.Builder builder() {
        return CriteriaModifier.builder(this.modId);
    }

    private CriteriaModifier.Builder food() {
        CriteriaModifier.Builder food = this.builder();
        HorizonsItems.HELPER.getDeferredRegister().getEntries().forEach(i -> {
            if (i.get().getFoodProperties() != null)
                food.addCriterion(ForgeRegistries.ITEMS.getKey(i.get()).getPath(), ConsumeItemTrigger.TriggerInstance.usedItem(i.get()));
        });
        return food;
    }

}
