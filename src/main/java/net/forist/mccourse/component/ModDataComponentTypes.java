package net.forist.mccourse.component;

import net.forist.mccourse.MCCourseMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes
{
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPE =
            DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, MCCourseMod.MOD_ID);

    public static final RegistryObject<DataComponentType<BlockPos>> COORDINATES = register("coordinates",
            builder -> builder.persistent(BlockPos.CODEC));

    private static <T>RegistryObject<DataComponentType<T>> register(String name, UnaryOperator<DataComponentType.Builder<T>> builderOperator )
    {
        return DATA_COMPONENT_TYPE.register(name,() -> builderOperator.apply(DataComponentType.builder()).build());
    }

    public static void register(IEventBus eventBus)
    {
        DATA_COMPONENT_TYPE.register(eventBus);
    }
}