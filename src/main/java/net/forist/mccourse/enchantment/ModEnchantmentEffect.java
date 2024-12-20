package net.forist.mccourse.enchantment;

import com.mojang.serialization.MapCodec;
import net.forist.mccourse.MCCourseMod;
import net.forist.mccourse.enchantment.custom.LightningStrikerEnchantmentEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantmentEffect
{
    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENTITY_ENCHANTMENT_EFFECT =
            DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, MCCourseMod.MOD_ID);

    public static final RegistryObject<MapCodec<? extends EnchantmentEntityEffect>> LIGHTNING_STRIKER
            = ENTITY_ENCHANTMENT_EFFECT.register("lightning_striker",()-> LightningStrikerEnchantmentEffect.CODEC);

    public static void register(IEventBus eventBus)
    {
        ENTITY_ENCHANTMENT_EFFECT.register(eventBus);
    }
}