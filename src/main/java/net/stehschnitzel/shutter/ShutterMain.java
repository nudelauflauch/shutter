package net.stehschnitzel.shutter;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.stehschnitzel.shutter.init.BlockInit;
import net.stehschnitzel.shutter.init.CreativTabInit;
import net.stehschnitzel.shutter.init.SoundInit;
import org.slf4j.Logger;

@Mod(ShutterMain.MODID)
public class ShutterMain {
	public static final String MODID = "shutter";
	public static final Logger LOGGER = LogUtils.getLogger();

	public ShutterMain() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		BlockInit.MINECRAFT_ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		SoundInit.register(bus);
		CreativTabInit.TABS.register(bus);
		CreativTabInit.registerDeferredItemRegister(bus);

		MinecraftForge.EVENT_BUS.register(this);
	}

}
