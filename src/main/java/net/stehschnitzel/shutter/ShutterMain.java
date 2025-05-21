package net.stehschnitzel.shutter;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.stehschnitzel.shutter.init.BlockInit;
import net.stehschnitzel.shutter.init.CreativTabInit;
import net.stehschnitzel.shutter.init.SoundInit;
import org.slf4j.Logger;

@Mod(ShutterMain.MOD_ID)
public class ShutterMain {
	public static final String MOD_ID = "shutter";
	public static final Logger LOGGER = LogUtils.getLogger();

	public ShutterMain(IEventBus bus) {
		bus.addListener(this::commonSetup);
		NeoForge.EVENT_BUS.register(this);

		CreativTabInit.register(bus);

//		CreativTabInit.registerDeferredItemRegister(bus);
		BlockInit.registerBlockItem(bus);
		BlockInit.registerBlock(bus);
		SoundInit.register(bus);
	}

	private void commonSetup(final FMLCommonSetupEvent event)  {

	}

	// You can use SubscribeEvent and let the Event Bus discover methods to call
	@SubscribeEvent
	public void onServerStarting(ServerStartingEvent event) {

	}

}