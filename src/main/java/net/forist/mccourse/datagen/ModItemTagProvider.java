package net.forist.mccourse.datagen;

import net.forist.mccourse.MCCourseMod;
import net.forist.mccourse.block.ModBlocks;
import net.forist.mccourse.item.ModItems;
import net.forist.mccourse.util.ModTags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                              CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, MCCourseMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider)
    {
        //add Tags here
        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ALEXANDRITE_HELMET.get())
                .add(ModItems.ALEXANDRITE_CHESTPLATE.get())
                .add(ModItems.ALEXANDRITE_LEGGINGS.get())
                .add(ModItems.ALEXANDRITE_BOOTS.get());

        tag(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.BAR_BRAWL_RECORD.get());

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.BALSA_LOG.get().asItem())
                .add(ModBlocks.BALSA_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_BALSA_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_BALSA_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.BALSA_PLANKS.get().asItem());
    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}