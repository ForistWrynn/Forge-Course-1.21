package net.forist.mccourse.datagen;

import net.forist.mccourse.MCCourseMod;
import net.forist.mccourse.block.ModBlocks;
import net.forist.mccourse.block.custom.AlexandriteLampBlock;
import net.forist.mccourse.block.custom.KohlrabiCropBlock;
import net.forist.mccourse.util.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper)
    {

        super(output, MCCourseMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        blockWithItem(ModBlocks.ALEXANDRITE_BLOCK);

        blockWithItem(ModBlocks.ALEXANDRITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE);
        blockWithItem(ModBlocks.END_STONE_ALEXANDRITE_ORE);
        blockWithItem(ModBlocks.NETHER_ALEXANDRITE_ORE);

        blockWithItem(ModBlocks.RAW_ALEXANDRITE_BLOCK);

        blockWithItem(ModBlocks.SOUND_BLOCK);

        stairsBlock(ModBlocks.ALEXANDRITE_STAIRS.get(),blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        slabBlock(ModBlocks.ALEXANDRITE_SLAB.get(),blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()),blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));

        buttonBlock(ModBlocks.ALEXANDRITE_BUTTON.get(),blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        pressurePlateBlock(ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get(),blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.ALEXANDRITE_DOOR.get(),modLoc("block/alexandrite_door_bottom"),modLoc("block/alexandrite_door_top"),"cutout");
        trapdoorBlockWithRenderType(ModBlocks.ALEXANDRITE_TRAPDOOR.get(),modLoc("block/alexandrite_trapdoor"),true,"cutout");

        fenceBlock(ModBlocks.ALEXANDRITE_FENCE.get(),blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        fenceGateBlock(ModBlocks.ALEXANDRITE_FENCE_GATE.get(),blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        wallBlock(ModBlocks.ALEXANDRITE_WALL.get(),blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));


        blockItem(ModBlocks.ALEXANDRITE_STAIRS);
        blockItem(ModBlocks.ALEXANDRITE_SLAB);

        blockItem(ModBlocks.ALEXANDRITE_DOOR);
        blockItem(ModBlocks.ALEXANDRITE_TRAPDOOR, "_bottom");

        blockItem(ModBlocks.ALEXANDRITE_PRESSURE_PLATE);
        blockItem(ModBlocks.ALEXANDRITE_BUTTON);

        blockItem(ModBlocks.ALEXANDRITE_FENCE);
        blockItem(ModBlocks.ALEXANDRITE_FENCE_GATE);
        blockItem(ModBlocks.ALEXANDRITE_WALL);

        customLamp();

        makeCrop(((CropBlock) ModBlocks.KOHLRABI_CROP.get()), "kohlrabi_stage", "kohlrabi_stage");


        simpleBlock(ModBlocks.SNAPDRAGON.get(),
                models().cross(blockTexture(ModBlocks.SNAPDRAGON.get()).getPath(),blockTexture(ModBlocks.SNAPDRAGON.get())).renderType("cutout"));

        horizontalBlock(ModBlocks.GEM_EMPOWERING_STATION.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/gem_empowering_station")));

        blockItem(ModBlocks.CRYSTALLIZER);

        logBlock(((RotatedPillarBlock) ModBlocks.BALSA_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.BALSA_WOOD.get()),
                blockTexture(ModBlocks.BALSA_LOG.get()), blockTexture(ModBlocks.BALSA_LOG.get()));

        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_BALSA_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_BALSA_WOOD.get()),
                blockTexture(ModBlocks.STRIPPED_BALSA_LOG.get()), blockTexture(ModBlocks.STRIPPED_BALSA_LOG.get()));

        blockItem(ModBlocks.BALSA_LOG);
        blockItem(ModBlocks.BALSA_WOOD);
        blockItem(ModBlocks.STRIPPED_BALSA_LOG);
        blockItem(ModBlocks.STRIPPED_BALSA_WOOD);

        blockWithItem(ModBlocks.BALSA_PLANKS);
        leavesBlock(ModBlocks.BALSA_LEAVES);

        saplingBlock(ModBlocks.BALSA_SAPLING);
    }
    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((KohlrabiCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID
                        , "block/" + textureName + state.getValue(((KohlrabiCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.ALEXANDRITE_LAMP.get()).forAllStates(state -> {
            if(state.getValue(AlexandriteLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("alexandrite_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "block/" + "alexandrite_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("alexandrite_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "block/" + "alexandrite_lamp_off")))};
            }
        });
        simpleBlockItem(ModBlocks.ALEXANDRITE_LAMP.get(), models().cubeAll("alexandrite_lamp_on",
                ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "block/" + "alexandrite_lamp_on")));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject)
    {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("mccourse:block/"
                + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix)
    {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("mccourse:block/"
                + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject)
    {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
