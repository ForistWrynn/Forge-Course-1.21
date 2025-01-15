package net.forist.mccourse.block;


import net.forist.mccourse.MCCourseMod;
import net.forist.mccourse.block.custom.*;
import net.forist.mccourse.item.ModItems;
import net.forist.mccourse.sound.ModSounds;
import net.forist.mccourse.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MCCourseMod.MOD_ID);

    public static final RegistryObject<Block> ALEXANDRITE_BLOCK =registerBlock("alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE).requiresCorrectToolForDrops()
                    .strength(5.0F, 6.0F).sound(SoundType.METAL)));

    public static final RegistryObject<Block> RAW_ALEXANDRITE_BLOCK =registerBlock("raw_alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));


    //Ore
    public static final RegistryObject<Block> ALEXANDRITE_ORE =registerBlock("alexandrite_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,5),BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));

    public static final RegistryObject<Block> DEEPSLATE_ALEXANDRITE_ORE =registerBlock("deepslate_alexandrite_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,7),BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));

    public static final RegistryObject<Block> END_STONE_ALEXANDRITE_ORE =registerBlock("end_stone_alexandrite_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,9),BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)));

    public static final RegistryObject<Block> NETHER_ALEXANDRITE_ORE =registerBlock("nether_alexandrite_ore",
            () -> new DropExperienceBlock(UniformInt.of(4,8),BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERRACK)));

    //Special Block

    public static final RegistryObject<Block> SOUND_BLOCK =registerBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noLootTable()));

    public static final RegistryObject<Block> ALEXANDRITE_LAMP = registerBlock("alexandrite_lamp",
            () -> new AlexandriteLampBlock(BlockBehaviour.Properties.of().strength(3f)
                    .lightLevel(state -> state.getValue(AlexandriteLampBlock.CLICKED)? 15:0).sound(ModSounds.ALEXANDRITE_LAMP_SOUNDS)));

    //Advanced Block , Stair , Slab etc.

    public static final RegistryObject<StairBlock> ALEXANDRITE_STAIRS =registerBlock("alexandrite_stairs",
            () -> new StairBlock(ModBlocks.ALEXANDRITE_BLOCK.get().defaultBlockState()
                    , BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE_STAIRS).sound(SoundType.METAL)));

    public static final RegistryObject<SlabBlock> ALEXANDRITE_SLAB =registerBlock("alexandrite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE_SLAB).sound(SoundType.METAL)));

    public static final RegistryObject<PressurePlateBlock> ALEXANDRITE_PRESSURE_PLATE =registerBlock("alexandrite_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<ButtonBlock> ALEXANDRITE_BUTTON =registerBlock("alexandrite_button",
            () -> new ButtonBlock(BlockSetType.IRON,1
                    , BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noCollission()));

    public static final RegistryObject<FenceBlock> ALEXANDRITE_FENCE =registerBlock("alexandrite_fence",
            () -> new FenceBlock( BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<FenceGateBlock> ALEXANDRITE_FENCE_GATE =registerBlock("alexandrite_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA,BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<WallBlock> ALEXANDRITE_WALL =registerBlock("alexandrite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));


    public static final RegistryObject<DoorBlock> ALEXANDRITE_DOOR =registerBlock("alexandrite_door",
            () -> new DoorBlock(BlockSetType.IRON
                    ,BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<TrapDoorBlock> ALEXANDRITE_TRAPDOOR =registerBlock("alexandrite_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON
                    ,BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noOcclusion()));

    //Crop
    public static final RegistryObject<Block> KOHLRABI_CROP = BLOCKS.register("kohlrabi_crop",
            () -> new KohlrabiCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion().noCollission()));

    //Flower
    public static final RegistryObject<Block> SNAPDRAGON = registerBlock("snapdragon",
            () -> new FlowerBlock(MobEffects.BLINDNESS,6,BlockBehaviour.Properties.ofFullCopy(Blocks.ALLIUM)));

    public static final RegistryObject<Block> POTTED_SNAPDRAGON = BLOCKS.register("potted_snapdragon",
            () -> new FlowerPotBlock((()->(FlowerPotBlock) Blocks.FLOWER_POT), SNAPDRAGON,BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));

    //Custom Block
    public static final RegistryObject<Block> GEM_EMPOWERING_STATION = registerBlock("gem_empowering_station",
            () -> new GemEmpoweringStationBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> PEDESTAL =registerBlock("pedestal",
            () -> new PedestalBlock(BlockBehaviour.Properties.of().strength(5.0F, 6.0F).noOcclusion()));

    public static final RegistryObject<Block> CRYSTALLIZER =registerBlock("crystallizer",
            () -> new CrystallizerBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().randomTicks()));

    //WOODS

    public static final RegistryObject<Block> BALSA_LOG =registerBlock("balsa_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> BALSA_WOOD =registerBlock("balsa_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_BALSA_LOG =registerBlock("stripped_balsa_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_BALSA_WOOD =registerBlock("stripped_balsa_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> BALSA_PLANKS =registerBlock("balsa_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> BALSA_LEAVES =registerBlock("balsa_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final RegistryObject<Block> BALSA_SAPLING =registerBlock("balsa_sapling",
            () -> new ModSaplingBlock(ModTreeGrowers.BALSA,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), Blocks.END_STONE));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
