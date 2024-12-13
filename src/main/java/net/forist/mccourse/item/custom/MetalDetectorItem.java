package net.forist.mccourse.item.custom;

import com.mojang.datafixers.util.Pair;
import net.forist.mccourse.util.ModTags;
import net.minecraft.client.Screenshot;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolActions;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState blockState = pContext.getLevel().getBlockState(positionClicked.below(i));

                if (isValuableBlock(blockState)) {
                    outputValuableCoordinates(positionClicked.below(i), player, blockState.getBlock());
                    foundBlock = true;

                    break;
                }
            }

            if (!foundBlock) {
                outputNoValuableFound(player);
            }
        }

        //Durability decrease

        {
            Player player = pContext.getPlayer();

            if (player != null)
            {
                pContext.getItemInHand().hurtAndBreak(1, player, LivingEntity.getSlotForHand(pContext.getHand()));
            }
        }

        //pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), player -> player.broadcastBreakEvent(player.getUsedItemHand()));
        //pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), entity -> entity.onEquippedItemBroken(entity.getUsedItemHand()));


        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if (Screen.hasShiftDown())
        {
            pTooltipComponents.add(Component.translatable("tooltip.mccourse.metal_detector.tooltip.shift"));
        }else
        {
            pTooltipComponents.add(Component.translatable("tooltip.mccourse.metal_detector.tooltip"));
        }

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }

    private void outputNoValuableFound(Player player) {
        player.sendSystemMessage(Component.translatable("item.mccourse.metal_detector.no_valuables"));
    }

    private void outputValuableCoordinates(BlockPos below, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Valuable Found: " + I18n.get(block.getDescriptionId()) +
                " at (" + below.getX() + "," + below.getY() + "," + below.getZ() + ")")); //I18n = use langauges that we understand
    }

    private boolean isValuableBlock(BlockState blockState) {
        return blockState.is(ModTags.Block.METAL_DETECTOR_VALUABLES);
    }



}
