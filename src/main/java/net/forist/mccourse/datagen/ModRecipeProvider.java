package net.forist.mccourse.datagen;

import net.forist.mccourse.block.ModBlocks;
import net.forist.mccourse.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries)
    {


        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput)
    {
        List<ItemLike> ALEXANDRITE_SMELTABLES = List.of(ModItems.RAW_ALEXANDRITE.get(),
                ModBlocks.ALEXANDRITE_ORE.get(), ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ALEXANDRITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ALEXANDRITE.get())
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 9)
                .requires(ModBlocks.ALEXANDRITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ALEXANDRITE_BLOCK.get()), has(ModBlocks.ALEXANDRITE_BLOCK.get())).save(pRecipeOutput);

        oreSmelting(pRecipeOutput, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.25f, 200, "alexandrite");
        oreBlasting(pRecipeOutput, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.25f, 100, "alexandrite");

        stairBuilder(ModBlocks.ALEXANDRITE_STAIRS.get(),Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()),has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ALEXANDRITE_SLAB.get(), ModItems.ALEXANDRITE.get()); //Already Saved

        buttonBuilder(ModBlocks.ALEXANDRITE_BUTTON.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get(), ModItems.ALEXANDRITE.get());

        fenceBuilder(ModBlocks.ALEXANDRITE_FENCE.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.ALEXANDRITE_FENCE_GATE.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ALEXANDRITE_WALL.get(), ModItems.ALEXANDRITE.get());

        doorBuilder(ModBlocks.ALEXANDRITE_DOOR.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.ALEXANDRITE_TRAPDOOR.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);


    }

}