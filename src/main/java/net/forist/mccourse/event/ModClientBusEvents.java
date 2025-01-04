package net.forist.mccourse.event;

import net.forist.mccourse.MCCourseMod;
import net.forist.mccourse.particle.AlexandriteParticles;
import net.forist.mccourse.particle.ModParticle;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MCCourseMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientBusEvents
{
    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event)
    {
        event.registerSpriteSet(ModParticle.ALEXANDRITE_PARTICLE.get(), AlexandriteParticles.Provider::new);
    }
}
