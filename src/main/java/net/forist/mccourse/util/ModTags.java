package net.forist.mccourse.util;

import net.forist.mccourse.MCCourseMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Item
    {
        public static final TagKey<net.minecraft.world.item.Item> TRANSFORMABLE_ITEM = createTag("transformable_items");

        private static TagKey<net.minecraft.world.item.Item> createTag(String name)
        {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, name));
        }

        private static TagKey<net.minecraft.world.item.Item> createForgeTag(String name)
        {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", name));
        }
    }

    public static class Block
    {
        public static final TagKey<net.minecraft.world.level.block.Block> METAL_DETECTOR_VALUABLES = createTag("metal_detector_valuables");


        private static TagKey<net.minecraft.world.level.block.Block> createTag(String name)
        {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, name));
        }

        private static TagKey<net.minecraft.world.level.block.Block> createForgeTag(String name)
        {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("forge", name));
        }
    }

}
