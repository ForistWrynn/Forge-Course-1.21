package net.forist.mccourse.util;

import net.forist.mccourse.MCCourseMod;
import net.forist.mccourse.component.ModDataComponentTypes;
import net.forist.mccourse.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperties
{
    public static void addCustomItemProperties()
    {
        ItemProperties.register(ModItems.CHISEL.get(), ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID,"used"),
                (itemStack, clientLevel, livingEntity, i) -> itemStack.get(ModDataComponentTypes.COORDINATES.get()) != null ? 1f:0f);


    }
}
