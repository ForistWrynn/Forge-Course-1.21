package net.forist.mccourse.item.custom;

import net.forist.mccourse.util.ModTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;

public class PaxelItem extends DiggerItem{
    public PaxelItem(Tier pTier, Properties pProperties)
    {
        super(pTier, ModTags.Block.PAXEL_MINEABLE, pProperties);
    }
}
