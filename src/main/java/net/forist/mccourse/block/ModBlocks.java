package net.forist.mccourse.block;


import net.forist.mccourse.MCCourseMod;
import net.forist.mccourse.item.ModItems;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
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
