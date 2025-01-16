package net.forist.mccourse.entity;

import net.forist.mccourse.MCCourseMod;
import net.forist.mccourse.entity.custom.CapybaraEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities
{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPE =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MCCourseMod.MOD_ID);

    public static final RegistryObject<EntityType<CapybaraEntity>> CAPYBARA = ENTITY_TYPE.register("capybara",
            ()-> EntityType.Builder.of(CapybaraEntity::new, MobCategory.CREATURE).sized(0.5f,0.4f).build("capybara"));

    public static void register(IEventBus eventBus)
    {
        ENTITY_TYPE.register(eventBus);
    }
}
