package com.teamaurora.horizons.common.item;

import com.teamabnormals.blueprint.common.item.InjectedBlockItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;

/**
 * @author JustinPlayzz
 * @author Steven
 * @author ebo2022
 * @author rose_
 */
public class AlgaeBlockItem extends InjectedBlockItem {
    public AlgaeBlockItem(Block block, Properties builder) {
        super(Items.SEAGRASS, block, builder);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        return InteractionResult.PASS;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        BlockHitResult result = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);
        BlockHitResult result1 = result.withPosition(result.getBlockPos().above());
        InteractionResult type = super.useOn(new UseOnContext(player, hand, result1));

        return new InteractionResultHolder<>(type, player.getItemInHand(hand));
    }

}
