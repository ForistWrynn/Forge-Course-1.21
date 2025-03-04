package net.forist.mccourse;

import com.mojang.logging.LogUtils;
import net.forist.mccourse.block.ModBlocks;
import net.forist.mccourse.block.entitiy.ModBlockEntitiies;
import net.forist.mccourse.block.entitiy.renderer.PedestalBlockEntityRenderer;
import net.forist.mccourse.component.ModDataComponentTypes;
import net.forist.mccourse.effect.ModEffects;
import net.forist.mccourse.enchantment.ModEnchantmentEffect;
import net.forist.mccourse.entity.ModEntities;
import net.forist.mccourse.entity.client.CapybaraRenderer;
import net.forist.mccourse.entity.client.GiraffeRenderer;
import net.forist.mccourse.fluid.ModFluidTypes;
import net.forist.mccourse.fluid.ModFluids;
import net.forist.mccourse.item.ModCreativeModeTabs;
import net.forist.mccourse.item.ModItems;
import net.forist.mccourse.painting.ModPaintings;
import net.forist.mccourse.particle.ModParticle;
import net.forist.mccourse.potion.ModPotions;
import net.forist.mccourse.recipe.ModRecipes;
import net.forist.mccourse.screen.ModMenuTypes;
import net.forist.mccourse.screen.custom.crystallizer.CrystallizerScreen;
import net.forist.mccourse.screen.custom.pedestal.PedestalScreen;
import net.forist.mccourse.sound.ModSounds;
import net.forist.mccourse.util.ModItemProperties;
import net.forist.mccourse.villager.ModVillagers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MCCourseMod.MOD_ID)
public class MCCourseMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "mccourse";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public MCCourseMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModDataComponentTypes.register(modEventBus);
        ModSounds.register(modEventBus);

        //Lootable Modifier fixing
        //ModLootModifiers.register(modEventBus);

        //Painting
        ModPaintings.register(modEventBus);

        //Custom Effect
        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);

        ModVillagers.register(modEventBus);

        ModParticle.register(modEventBus);

        ModFluidTypes.register(modEventBus);
        ModFluids.register(modEventBus);

        ModBlockEntitiies.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModRecipes.register(modEventBus);

        ModEntities.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register the enchantment
        ModEnchantmentEffect.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->{
            ComposterBlock.COMPOSTABLES.put(ModItems.KOHLRABI.get(),0.35f);
            ComposterBlock.COMPOSTABLES.put(ModItems.KOHLRABI_SEEDS.get(),0.20f);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.SNAPDRAGON.getId(),ModBlocks.POTTED_SNAPDRAGON);

        } );
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
        {
            event.accept(ModBlocks.ALEXANDRITE_BLOCK);
            event.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK);
            event.accept(ModBlocks.ALEXANDRITE_ORE);
            event.accept(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE);
        }

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS)
        {
            event.accept(ModItems.ALEXANDRITE);
            event.accept(ModItems.RAW_ALEXANDRITE);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            ModItemProperties.addCustomItemProperties();
            event.enqueueWork(() -> {
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_AZURITE_WATER.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_AZURITE_WATER.get(), RenderType.translucent());
            });

            MenuScreens.register(ModMenuTypes.PEDESTAL_MENU.get(), PedestalScreen::new);
            MenuScreens.register(ModMenuTypes.CRYSTALLIZER_MENU.get(), CrystallizerScreen::new);

            EntityRenderers.register(ModEntities.CAPYBARA.get(), CapybaraRenderer::new);
            EntityRenderers.register(ModEntities.GIRAFFE.get(), GiraffeRenderer::new);
        }

        @SubscribeEvent
        public static void registerBER(EntityRenderersEvent.RegisterRenderers event)
        {
            event.registerBlockEntityRenderer(ModBlockEntitiies.PEDESTAL_BE.get(), PedestalBlockEntityRenderer::new);
        }
    }
}
