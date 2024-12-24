package net.forist.mccourse.sound;

import net.forist.mccourse.MCCourseMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds
{
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MCCourseMod.MOD_ID);

    public static final RegistryObject<SoundEvent> METAL_DETECTOR_FOUND_ORE = registerSoundEvents("metal_detector_found_ore");

    public static final RegistryObject<SoundEvent> ALEXANDRITE_LAMP_BREAK = registerSoundEvents("alexandrite_lamp_break");
    public static final RegistryObject<SoundEvent> ALEXANDRITE_LAMP_FALL = registerSoundEvents("alexandrite_lamp_fall");
    public static final RegistryObject<SoundEvent> ALEXANDRITE_LAMP_HIT = registerSoundEvents("alexandrite_lamp_hit");
    public static final RegistryObject<SoundEvent> ALEXANDRITE_LAMP_PLACE = registerSoundEvents("alexandrite_lamp_place");
    public static final RegistryObject<SoundEvent> ALEXANDRITE_LAMP_STEP = registerSoundEvents("alexandrite_lamp_step");

    public static final RegistryObject<SoundEvent> BAR_BRAWL = registerSoundEvents("bar_brawl");

    public static final ResourceKey<JukeboxSong> BAR_BRAWL_KEY = ResourceKey.create(Registries.JUKEBOX_SONG,
            ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID,"bar_brawl"));

    public static final ForgeSoundType ALEXANDRITE_LAMP_SOUNDS = new ForgeSoundType
            (1f,1f,ModSounds.ALEXANDRITE_LAMP_BREAK,ModSounds.ALEXANDRITE_LAMP_STEP
                    ,ModSounds.ALEXANDRITE_LAMP_PLACE,ModSounds.ALEXANDRITE_LAMP_HIT,ModSounds.ALEXANDRITE_LAMP_FALL);

    private static RegistryObject<SoundEvent> registerSoundEvents(String name)
    {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus)
    {
        SOUND_EVENTS.register(eventBus);
    }

}
