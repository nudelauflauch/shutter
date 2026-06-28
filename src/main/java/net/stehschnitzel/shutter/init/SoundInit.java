package net.stehschnitzel.shutter.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.stehschnitzel.shutter.ShutterMain;

import java.util.function.Supplier;

public class SoundInit {
	
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
			DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, ShutterMain.MOD_ID);

    public static final Supplier<SoundEvent> SHUTTER_OPEN_HALF = registerSoundEvent("shutter_open_half");
    public static final Supplier<SoundEvent> SHUTTER_OPEN_FULL = registerSoundEvent("shutter_open_full");
    public static final Supplier<SoundEvent> SHUTTER_CLOSE = registerSoundEvent("shutter_close");


    public static final Supplier<SoundEvent> SHUTTER_OPEN_HALF_METAL = registerSoundEvent("shutter_open_half_metal");
	public static final Supplier<SoundEvent> SHUTTER_OPEN_FULL_METAL = registerSoundEvent("shutter_open_full_metal");
	public static final Supplier<SoundEvent> SHUTTER_CLOSE_METAL = registerSoundEvent("shutter_close_metal");

	private static Supplier<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(ShutterMain.MOD_ID, name)));
    }

	public static void register(IEventBus bus) {
		SOUND_EVENTS.register(bus);
	}
}
