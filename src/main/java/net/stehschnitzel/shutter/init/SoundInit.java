package net.stehschnitzel.shutter.init;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.stehschnitzel.shutter.ShutterMain;

public class SoundInit {

    public static final SoundEvent SHUTTER_OPEN_HALF = registerSoundEvent("shutter_open_half");
    public static final SoundEvent SHUTTER_OPEN_FULL = registerSoundEvent("shutter_open_full");
    public static final SoundEvent SHUTTER_CLOSE = registerSoundEvent("shutter_close");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(ShutterMain.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSound() {

    }

}
