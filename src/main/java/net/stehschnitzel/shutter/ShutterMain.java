package net.stehschnitzel.shutter;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ShutterMain.MODID)
public class ShutterMain {
	public static final String MODID = "shutter";
	public static final ShutterTab SHUTTER_TAB = new ShutterTab("shutter_tab");

	public ShutterMain() {
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		Init.ITEMS.register(bus);
		Init.BLOCKS.register(bus);
		bus.addListener(this::setup);

		MinecraftForge.EVENT_BUS.register(this);

	}

	private void setup(final FMLClientSetupEvent event) {
		ItemBlockRenderTypes.setRenderLayer(Init.ACACIA_SHUTTER.get(),
				RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Init.BIRCH_SHUTTER.get(),
				RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Init.CRIMSON_SHUTTER.get(),
				RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Init.DARK_OAK_SHUTTER.get(),
				RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Init.IRON_SHUTTER.get(),
				RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Init.JUNGLE_SHUTTER.get(),
				RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Init.OAK_SHUTTER.get(),
				RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Init.SPRUCE_SHUTTER.get(),
				RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Init.WARPED_SHUTTER.get(),
				RenderType.translucent());
	}
}
