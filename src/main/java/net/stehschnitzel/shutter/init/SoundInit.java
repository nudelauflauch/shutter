package net.stehschnitzel.shutter.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.stehschnitzel.shutter.ShutterMain;

public class SoundInit {
	
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ShutterMain.MODID);
	
	public static final RegistryObject<SoundEvent> SHUTTER_OPEN_HALF = registerSoundEvent("shutter_open_half");
	public static final RegistryObject<SoundEvent> SHUTTER_OPEN_FULL = registerSoundEvent("shutter_open_full");
	public static final RegistryObject<SoundEvent> SHUTTER_CLOSE = registerSoundEvent("shutter_close");

	private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(ShutterMain.MODID, name)));
    }

	public static void register(IEventBus eventBus) {
		SOUND_EVENTS.register(eventBus);
	}
}
