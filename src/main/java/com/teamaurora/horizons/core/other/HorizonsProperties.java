package com.teamaurora.horizons.core.other;

import com.teamabnormals.blueprint.core.util.PropertyUtil;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

/**
 * @author rose_
 */
public final class HorizonsProperties {
    public static final PropertyUtil.WoodSetProperties CYPRESS = PropertyUtil.WoodSetProperties.builder(MaterialColor.COLOR_GREEN).build();
    public static final BlockBehaviour.Properties GOOSEBERRY_SACK = BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.COLOR_GREEN).strength(0.5F).sound(SoundType.WOOL);
    public static final BlockBehaviour.Properties ALGAE = BlockBehaviour.Properties.of(Material.PLANT).instabreak().sound(HorizonsSoundTypes.ALGAE).noOcclusion().noCollission();
    public static final BlockBehaviour.Properties ALGAE_THATCH = BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_LIGHT_GREEN).strength(0.5F).sound(HorizonsSoundTypes.ALGAE_THATCH).noOcclusion();


}
