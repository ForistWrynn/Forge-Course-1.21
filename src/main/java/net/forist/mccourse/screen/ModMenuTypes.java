package net.forist.mccourse.screen;

import net.forist.mccourse.MCCourseMod;
import net.forist.mccourse.screen.custom.crystallizer.CrystallizerMenu;
import net.forist.mccourse.screen.custom.pedestal.PedestalMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class ModMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, MCCourseMod.MOD_ID);

    public static final RegistryObject<MenuType<PedestalMenu>> PEDESTAL_MENU =
            registerMenuType("pedestal_menu",PedestalMenu::new);
    public static final RegistryObject<MenuType<CrystallizerMenu>> CRYSTALLIZER_MENU =
            registerMenuType("crystallizer_menu", CrystallizerMenu::new);

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name,
                                                                                                 IContainerFactory<T> factory){
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus){
        MENUS.register(eventBus);
    }

}
