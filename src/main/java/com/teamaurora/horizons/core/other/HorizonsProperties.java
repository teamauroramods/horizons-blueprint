package com.teamaurora.horizons.core.other;

import com.teamabnormals.blueprint.core.util.PropertyUtil;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

/**
 * @author ebo2022
 * @author rose_
 */
public final class HorizonsProperties {
    public static final PropertyUtil.WoodSetProperties CYPRESS = PropertyUtil.WoodSetProperties.builder(MaterialColor.COLOR_GREEN).build();
    public static final PropertyUtil.WoodSetProperties REDWOOD = PropertyUtil.WoodSetProperties.builder(MaterialColor.COLOR_RED).build();
    public static final PropertyUtil.WoodSetProperties REDBUD = PropertyUtil.WoodSetProperties.builder(MaterialColor.COLOR_RED).build();
    public static final PropertyUtil.WoodSetProperties JACARANDA = PropertyUtil.WoodSetProperties.builder(MaterialColor.COLOR_PURPLE).build();

    public static final BlockBehaviour.Properties GOOSEBERRY_SACK = BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.COLOR_GREEN).strength(0.5F).sound(SoundType.WOOL);
    public static final BlockBehaviour.Properties ALGAE = BlockBehaviour.Properties.of(Material.PLANT).instabreak().sound(HorizonsSoundTypes.ALGAE).noOcclusion().noCollission();
    public static final BlockBehaviour.Properties ALGAE_THATCH = BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_LIGHT_GREEN).strength(0.5F).sound(HorizonsSoundTypes.ALGAE_THATCH).noOcclusion();
    public static final BlockBehaviour.Properties CYPRESS_KNEE = BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).strength(2.0F).sound(HorizonsSoundTypes.THIN_WOOD).noOcclusion().dynamicShape();
    public static final BlockBehaviour.Properties CYPRESS_BRANCH = BlockBehaviour.Properties.of(Material.PLANT).randomTicks().noCollission().sound(HorizonsSoundTypes.THIN_WOOD);
    public static final BlockBehaviour.Properties BEARD_MOSS_BLOCK = BlockBehaviour.Properties.of(Material.PLANT).strength(0.1F).sound(SoundType.MOSS).noOcclusion().isValidSpawn(PropertyUtil::ocelotOrParrot).isSuffocating(PropertyUtil::never).isViewBlocking(PropertyUtil::never);
    public static final BlockBehaviour.Properties BEARD_MOSS = BlockBehaviour.Properties.of(Material.PLANT).instabreak().sound(SoundType.MOSS).noOcclusion().noCollission().randomTicks();
    public static final BlockBehaviour.Properties LILY = BlockBehaviour.Properties.of(Material.PLANT).instabreak().sound(SoundType.LILY_PAD).noOcclusion();
    public static final BlockBehaviour.Properties GIANT_FERN = BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ);
    public static final BlockBehaviour.Properties BOULDER = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(1.5F, 6.0F);
    public static final BlockBehaviour.Properties BOULDER_BRICKS = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).sound(SoundType.NETHER_BRICKS).requiresCorrectToolForDrops().strength(1.5F, 6.0F);
}
