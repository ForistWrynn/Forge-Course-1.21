package net.forist.mccourse.item;

import net.forist.mccourse.MCCourseMod;
import net.forist.mccourse.item.custom.MetalDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MCCourseMod.MOD_ID);

    public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ALEXANDRITE = ITEMS.register("raw_alexandrite", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> URIEL_MOCHI = ITEMS.register("uriel_mochi", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEVINA_MOCHI = ITEMS.register("levina_mochi", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(512)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
