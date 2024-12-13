package net.forist.mccourse.datagen;

import net.forist.mccourse.block.ModBlocks;
import net.forist.mccourse.item.ModItems;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    private List<ItemLike> ALEXANDRITE_SMELTABLE = List.of(ModItems.RAW_ALEXANDRITE.get(),
            ModBlocks.ALEXANDRITE_ORE.get(),
            ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(),
            ModBlocks.NETHER_ALEXANDRITE_ORE.get(),
            ModBlocks.END_STONE_ALEXANDRITE_ORE.get());

    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput)
    {
        //Shaped Recipe

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ALEXANDRITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ALEXANDRITE.get())
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()),has(ModItems.ALEXANDRITE.get()))
                .save(recipeOutput);

        //Shapeless Recipe

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALEXANDRITE.get())
                .requires(ModBlocks.ALEXANDRITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ALEXANDRITE_BLOCK.get()), has(ModBlocks.ALEXANDRITE_BLOCK.get()))
                .save(recipeOutput);

        nineBlockStorageRecipes(recipeOutput, RecipeCategory.MISC, ModItems.RAW_ALEXANDRITE.get(), RecipeCategory.MISC, ModBlocks.RAW_ALEXANDRITE_BLOCK.get());

        oreSmelting(recipeOutput, ALEXANDRITE_SMELTABLE, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(),0.25f,200,"alexandrite");
        oreBlasting(recipeOutput, ALEXANDRITE_SMELTABLE, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(),0.50f,100,"alexandrite");
    }
}
