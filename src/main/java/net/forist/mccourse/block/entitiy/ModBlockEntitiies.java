package net.forist.mccourse.block.entitiy;

import net.forist.mccourse.MCCourseMod;
import net.forist.mccourse.block.ModBlocks;
import net.forist.mccourse.block.entitiy.custom.CrystallizerBlockEntity;
import net.forist.mccourse.block.entitiy.custom.GemEmpoweringStationBlockEntity;
import net.forist.mccourse.block.entitiy.custom.PedestalBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntitiies {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MCCourseMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<GemEmpoweringStationBlockEntity>> GEM_EMPOWERING_STATION_BE =
            BLOCK_ENTITIES.register("gem_empowering_station_block_entity",() ->
                    BlockEntityType.Builder.of(GemEmpoweringStationBlockEntity::new,
                            ModBlocks.GEM_EMPOWERING_STATION.get()).build(null));

    public static final RegistryObject<BlockEntityType<PedestalBlockEntity>> PEDESTAL_BE =
            BLOCK_ENTITIES.register("pedestal_block_entity", () ->
                    BlockEntityType.Builder.of(PedestalBlockEntity::new,
                            ModBlocks.PEDESTAL.get()).build(null));

    public static final RegistryObject<BlockEntityType<CrystallizerBlockEntity>> CRYTALLIZER_BE =
            BLOCK_ENTITIES.register("crytallizer_be", () ->
                    BlockEntityType.Builder.of(CrystallizerBlockEntity::new,
                            ModBlocks.CRYSTALLIZER.get()).build(null));

    public static void register(IEventBus eventBus)
    {
        BLOCK_ENTITIES.register(eventBus);
    }

}
