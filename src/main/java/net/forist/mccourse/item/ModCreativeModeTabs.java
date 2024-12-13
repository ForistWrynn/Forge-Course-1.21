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
                output.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());
                output.accept(ModBlocks.ALEXANDRITE_ORE.get());
                output.accept(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get());
                output.accept(ModBlocks.END_STONE_ALEXANDRITE_ORE.get());
                output.accept(ModBlocks.NETHER_ALEXANDRITE_ORE.get());
                output.accept(ModBlocks.SOUND_BLOCK.get());

                output.accept(ModItems.METAL_DETECTOR.get());

                output.accept(ModItems.KOHLRABI.get());
                output.accept(ModItems.PEAT_BRICK.get());


                //just want this
                output.accept(ModItems.URIEL_MOCHI.get());
                output.accept(ModItems.LEVINA_MOCHI.get());
                output.accept(ModItems.HANNAH_MOCHI.get());

            }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
