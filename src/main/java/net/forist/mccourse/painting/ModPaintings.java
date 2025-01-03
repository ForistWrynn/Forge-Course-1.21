package net.forist.mccourse.painting;

import net.forist.mccourse.MCCourseMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings
{
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANT =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, MCCourseMod.MOD_ID);

    /*
    public static final RegistryObject<PaintingVariant> SAW_THEM = PAINTING_VARIANT.register("saw_them",
            () -> new PaintingVariant(16,16,ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID,
                    "textures/painting/saw_them")));
     */

    public static void register(IEventBus eventBus)
    {
        PAINTING_VARIANT.register(eventBus);
    }
}
