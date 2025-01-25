package net.stehschnitzel.shutter.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.stehschnitzel.shutter.ShutterMain;

import java.util.function.Supplier;

public class SoundInit {
	
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Registries.SOUND_EVENT, ShutterMain.MOD_ID);
	
	public static final Supplier<SoundEvent> SHUTTER_OPEN_HALF = registerSoundEvent("shutter_open_half");
	public static final Supplier<SoundEvent> SHUTTER_OPEN_FULL = registerSoundEvent("shutter_open_full");
	public static final Supplier<SoundEvent> SHUTTER_CLOSE = registerSoundEvent("shutter_close");

	private static DeferredHolder<SoundEvent, SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(ShutterMain.MOD_ID, name)));
    }

	public static void register(IEventBus bus) {
		SOUND_EVENTS.register(bus);
	}
}
