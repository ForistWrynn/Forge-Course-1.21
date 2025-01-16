package net.forist.mccourse.event;

import net.forist.mccourse.MCCourseMod;
import net.forist.mccourse.entity.ModEntities;
import net.forist.mccourse.entity.client.CapybaraModel;
import net.forist.mccourse.entity.client.ModModelLayers;
import net.forist.mccourse.entity.custom.CapybaraEntity;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MCCourseMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents
{
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(ModModelLayers.CAPYBARA, CapybaraModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event)
    {
        event.put(ModEntities.CAPYBARA.get(), CapybaraEntity.createAttributes().build());
    }
}
