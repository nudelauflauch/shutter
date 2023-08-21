package net.stehschnitzel.shutter;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.stehschnitzel.shutter.init.BlockInit;
import net.stehschnitzel.shutter.init.SoundInit;

@Mod(ShutterMain.MODID)
public class ShutterMain {
	public static final String MODID = "shutter";
	public static final ShutterTab SHUTTER_TAB = new ShutterTab("shutter_tab");
	public ShutterMain() {
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		BlockInit.MINECRAFT_ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		SoundInit.register(bus);
		ShutterTab.registerMods(bus);

		MinecraftForge.EVENT_BUS.register(this);
	}

}
