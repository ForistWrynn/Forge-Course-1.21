package net.forist.mccourse.event;

import net.forist.mccourse.MCCourseMod;
import net.forist.mccourse.entity.ModEntities;
import net.forist.mccourse.entity.client.CapybaraModel;
import net.forist.mccourse.entity.client.ModModelLayers;
import net.forist.mccourse.entity.custom.CapybaraEntity;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
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

    @SubscribeEvent
    public static void registerSpawnPlacement(SpawnPlacementRegisterEvent event)
    {
        event.register(ModEntities.CAPYBARA.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}
