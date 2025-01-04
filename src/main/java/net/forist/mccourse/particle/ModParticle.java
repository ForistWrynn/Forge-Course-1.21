package net.forist.mccourse.particle;

import net.forist.mccourse.MCCourseMod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticle {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPE =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, MCCourseMod.MOD_ID);

    public static final RegistryObject<SimpleParticleType> ALEXANDRITE_PARTICLE =
            PARTICLE_TYPE.register("alexandrite_particles", () -> new SimpleParticleType(true));

    public static void register(IEventBus eventBus)
    {
        PARTICLE_TYPE.register(eventBus);
    }
}
