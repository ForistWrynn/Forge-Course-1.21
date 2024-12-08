package net.forist.mccourse.block.custom;

import net.forist.mccourse.MCCourseMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class SoundBlock extends Block {
    public SoundBlock(Properties pPropertise) {
        super(pPropertise);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer,
                                               InteractionHand pHand, BlockHitResult pHitResult)
    {
        System.out.println("Hello");
        if (pLevel.isClientSide())
        {
            if (pHand == InteractionHand.MAIN_HAND)
            {
                MCCourseMod.LOGGER.info("Main Hand ,Client");
            }
            else
            {
                MCCourseMod.LOGGER.info("Off Hand ,Client");
            }
        }else
        {
            if (pHand == InteractionHand.MAIN_HAND)
            {
                MCCourseMod.LOGGER.info("Main Hand, Server");
            }else
            {
                MCCourseMod.LOGGER.info("Off Hand, Server");
            }
        }

        return super.useWithoutItem(pState, pLevel, pPos, pPlayer, pHitResult);
    }
}
