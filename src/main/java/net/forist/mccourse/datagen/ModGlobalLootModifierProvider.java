package net.forist.mccourse.datagen;

import net.forist.mccourse.MCCourseMod;
import net.forist.mccourse.item.ModItems;
import net.forist.mccourse.loot.AddItemModifier;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider
 {
    public ModGlobalLootModifierProvider(PackOutput output, String modid, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, MCCourseMod.MOD_ID, registries);
    }

    @Override
    protected void start(HolderLookup.Provider provider)
    {
        add("kohlabi_seeds_from_grass",new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SHORT_GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build()}, ModItems.KOHLRABI_SEEDS.get()));

        add("metal_detector_from_jungle_temple",new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chest/jungle_temple")).build()}, ModItems.METAL_DETECTOR.get()));
    }
}
