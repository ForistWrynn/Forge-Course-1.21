package net.forist.mccourse.item;

import net.forist.mccourse.MCCourseMod;
import net.forist.mccourse.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MCCourseMod.MOD_ID);

    //Can Copy All of this to create another , but don't forget to rename
    public static final RegistryObject<CreativeModeTab> COURSE_TAB = CREATIVE_MODE_TAB.register("course_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.URIEL_MOCHI.get())).title(Component.translatable("creativetab.course_tab")).displayItems((itemDisplayParameters, output) ->
            {
                output.accept(ModItems.ALEXANDRITE.get());
                output.accept(ModItems.RAW_ALEXANDRITE.get());

                output.accept(ModBlocks.ALEXANDRITE_BLOCK.get());

                output.accept(ModBlocks.ALEXANDRITE_SLAB.get());
                output.accept(ModBlocks.ALEXANDRITE_STAIRS.get());
                output.accept(ModBlocks.ALEXANDRITE_DOOR.get());
                output.accept(ModBlocks.ALEXANDRITE_TRAPDOOR.get());
                output.accept(ModBlocks.ALEXANDRITE_BUTTON.get());
                output.accept(ModBlocks.ALEXANDRITE_FENCE.get());
                output.accept(ModBlocks.ALEXANDRITE_FENCE_GATE.get());
                output.accept(ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get());
                output.accept(ModBlocks.ALEXANDRITE_WALL.get());

                output.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());

                output.accept(ModBlocks.ALEXANDRITE_ORE.get());
                output.accept(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get());
                output.accept(ModBlocks.END_STONE_ALEXANDRITE_ORE.get());
                output.accept(ModBlocks.NETHER_ALEXANDRITE_ORE.get());

                //Advanced Block
                output.accept(ModBlocks.SOUND_BLOCK.get());
                output.accept(ModBlocks.ALEXANDRITE_LAMP.get());

                //Complex Block
                output.accept(ModBlocks.GEM_EMPOWERING_STATION.get());

                //Additional
                output.accept(ModItems.METAL_DETECTOR.get());
                output.accept(ModItems.CHISEL.get());
                output.accept(ModItems.RADIATION_STAFF.get());

                output.accept(ModItems.KOHLRABI.get());
                output.accept(ModItems.PEAT_BRICK.get());

                //Tools
                output.accept(ModItems.ALEXANDRITE_SWORD.get());
                output.accept(ModItems.ALEXANDRITE_SHOVEL.get());
                output.accept(ModItems.ALEXANDRITE_PICKAXE.get());
                output.accept(ModItems.ALEXANDRITE_AXE.get());
                output.accept(ModItems.ALEXANDRITE_HOE.get());

                output.accept(ModItems.ALEXANDRITE_PAXEL.get());
                output.accept(ModItems.ALEXANDRITE_HAMMER.get());

                output.accept(ModItems.ALEXANDRITE_BOW.get());

                output.accept(ModItems.ALEXANDRITE_SHIELD.get());

                //Armor
                output.accept(ModItems.ALEXANDRITE_HELMET.get());
                output.accept(ModItems.ALEXANDRITE_CHESTPLATE.get());
                output.accept(ModItems.ALEXANDRITE_LEGGINGS.get());
                output.accept(ModItems.ALEXANDRITE_BOOTS.get());

                //Animal Armor
                output.accept(ModItems.ALEXANDRITE_HORSE_ARMOR.get());

                //just want this
                output.accept(ModItems.URIEL_MOCHI.get());
                output.accept(ModItems.LEVINA_MOCHI.get());
                output.accept(ModItems.HANNAH_MOCHI.get());
                output.accept(ModItems.TA_YUET.get());

                //Seeds & Plant
                output.accept(ModItems.KOHLRABI_SEEDS.get());
                output.accept(ModBlocks.SNAPDRAGON.get());

                output.accept(ModItems.BAR_BRAWL_RECORD.get());

            }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
