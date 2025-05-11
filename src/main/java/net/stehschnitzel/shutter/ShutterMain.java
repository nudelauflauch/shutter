package net.stehschnitzel.shutter;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.stehschnitzel.shutter.init.BlockInit;
import net.stehschnitzel.shutter.init.CreativTabInit;
import net.stehschnitzel.shutter.init.SoundInit;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

@Mod(ShutterMain.MOD_ID)
public class ShutterMain {
	public static final String MOD_ID = "shutter";
	public static final Logger LOGGER = LogUtils.getLogger();

	public ShutterMain(FMLJavaModLoadingContext context) {
		IEventBus bus = context.getModEventBus();
		bus.addListener(this::commonSetup);
		MinecraftForge.EVENT_BUS.register(this);

		CreativTabInit.register(bus);

		CreativTabInit.registerDeferredItemRegister(bus);
		BlockInit.registerBlockItem(bus);
		BlockInit.registerBlock(bus);
		SoundInit.register(bus);
	}

	private void commonSetup(final FMLCommonSetupEvent event)  {

	}

}