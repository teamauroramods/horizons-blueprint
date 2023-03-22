package com.teamaurora.horizons.common.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;

public class SupportiveEffect extends MobEffect {

    public SupportiveEffect() {
        super(MobEffectCategory.NEUTRAL, 0x845AAA);
    }

    // 0 = passive, 1 = neutral, 2 = hostile
    private int getHostility(Entity entity) {
        /*
        if (entity instanceof IAngerable) {
            return 1;
        } else if (entity instanceof AnimalEntity) {
            return 0;
        } else if (entity instanceof MonsterEntity) {
            return 2;
        } else {
            return 1;
        }
        */

        return 1;
    }

    private int getHostilityBetween(Entity effectUser, Entity affectedEntity) {
        int hos1 = getHostility(effectUser);
        int hos2 = getHostility(affectedEntity);

        if (hos1 == 1 || hos2 == 1) {
            return 1;
        }
        if (hos1 == hos2) {
            return 0;
        }
        return 2;
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        /*
        BlockPos pos = entity.getOnPos();
        List<LivingEntity> entities = entity.level.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(pos.offset(-10, -10, -10), pos.offset(10, 10, 10)));
        entities.remove(entity);

        for (LivingEntity affectedEntity : entities) {
            int hostility = getHostilityBetween(entity, affectedEntity);
            MobEffect effectToApply;

            switch (hostility) {
                default:
                case 0:
                    // Passive
                    effectToApply = MobEffects.REGENERATION;
                    break;
                case 1:
                    // Strength
                    effectToApply = MobEffects.DAMAGE_BOOST;
                    break;
                case 2:
                    // Aggressive
                    effectToApply = MobEffects.DAMAGE_RESISTANCE;
                    break;
            }
            affectedEntity.addEffect(new MobEffectInstance(effectToApply, 200, amplifier, false, true, true));
        }
        */
    }

    /*
    @Override
    public void affectEntity(@Nullable Entity source, @Nullable Entity indirectSource, LivingEntity livingEntity, int amplifier, double health) {

    }


    @Override
    public boolean isReady(int duration, int amplifier) {
        return duration % 4 == 0;
    }
    */
}
