package com.filipe.tutorialmod.sound;

import com.filipe.tutorialmod.TutorialMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, TutorialMod.MODID);

    public static final Supplier<SoundEvent> AURA_BLOCK_STEP = registerSoundEvent("aura_block_step");
    public static final Supplier<SoundEvent> AURA_BLOCK_BREAK = registerSoundEvent("aura_block_break");
    public static final Supplier<SoundEvent> AURA_BLOCK_HIT = registerSoundEvent("aura_block_hit");
    public static final Supplier<SoundEvent> AURA_BLOCK_PLACE = registerSoundEvent("aura_block_place");
    public static final Supplier<SoundEvent> AURA_BLOCK_FALL = registerSoundEvent("aura_block_fall");

    public static final Supplier<SoundEvent> SOM_AURA = registerSoundEvent("som_aura");

    public static final DeferredSoundType AURA_BLOCK_SOUNDS = new DeferredSoundType(1f, 1f,
            ModSounds.AURA_BLOCK_BREAK, ModSounds.AURA_BLOCK_STEP, ModSounds.AURA_BLOCK_HIT, ModSounds.AURA_BLOCK_PLACE, ModSounds.AURA_BLOCK_FALL);


    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(TutorialMod.MODID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}