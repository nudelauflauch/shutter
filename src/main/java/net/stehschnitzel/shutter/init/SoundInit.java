package net.stehschnitzel.shutter.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.stehschnitzel.shutter.ShutterMain;

import java.util.function.Supplier;

public class SoundInit {

    public static final SoundEvent SHUTTER_OPEN_HALF = registerSoundEvent("shutter_open_half");
    public static final SoundEvent SHUTTER_OPEN_FULL = registerSoundEvent("shutter_open_full");
    public static final SoundEvent SHUTTER_CLOSE = registerSoundEvent("shutter_close");

    public static final SoundEvent SHUTTER_OPEN_HALF_METAL = registerSoundEvent("shutter_open_half_metal");
    public static final SoundEvent SHUTTER_OPEN_FULL_METAL = registerSoundEvent("shutter_open_full_metal");
    public static final SoundEvent SHUTTER_CLOSE_METAL = registerSoundEvent("shutter_close_metal");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(ShutterMain.MOD_ID, name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }

    public static void registerSound() {

    }

}
