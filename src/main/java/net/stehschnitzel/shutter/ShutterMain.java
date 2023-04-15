package net.stehschnitzel.shutter;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLLoader;
import net.stehschnitzel.shutter.init.BlockInit;
import net.stehschnitzel.shutter.init.ItemInit;
import net.stehschnitzel.shutter.init.SoundInit;

@Mod(ShutterMain.MODID)
public class ShutterMain {
	public static final String MODID = "shutter";
	public static final ShutterTab SHUTTER_TAB = new ShutterTab("shutter_tab");

	public ShutterMain() {
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		ItemInit.MINECRAFT_ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);

		SoundInit.register(bus);

		if (ModList.get().isLoaded("create")) {
			ItemInit.ITEMS_CREATE.register(bus);
		}

		if (ModList.get().isLoaded("ecologics")) {
			ItemInit.ITEMS_ECOLOGICS.register(bus);
		}

		if (ModList.get().isLoaded("endergetic")) {
			ItemInit.ITEMS_ENDERGETIC.register(bus);
		}

		if (ModList.get().isLoaded("outer_end")) {
			ItemInit.ITEMS_OUTER_END.register(bus);
		}

		if (ModList.get().isLoaded("quark")) {
			ItemInit.ITEMS_QUARK.register(bus);
		}

		if (ModList.get().isLoaded("supplementaries")) {
			ItemInit.ITEMS_SUPPLEMENTARIES.register(bus);
		}

		if (ModList.get().isLoaded("twigs")) {
			ItemInit.ITEMS_TWIGS.register(bus);
		}
		if (ModList.get().isLoaded("oreganized")) {
			ItemInit.ITEMS_OREGANIZED.register(bus);
		}
		if (!FMLLoader.isProduction()) {
			ItemInit.ITEMS_CREATE.register(bus);
			ItemInit.ITEMS_ECOLOGICS.register(bus);
			ItemInit.ITEMS_ENDERGETIC.register(bus);
			ItemInit.ITEMS_OUTER_END.register(bus);
			ItemInit.ITEMS_QUARK.register(bus);
			ItemInit.ITEMS_SUPPLEMENTARIES.register(bus);
			ItemInit.ITEMS_TWIGS.register(bus);
			ItemInit.ITEMS_OREGANIZED.register(bus);
		}
		bus.addListener(this::setup);

		MinecraftForge.EVENT_BUS.register(this);

	}
	
	private void setup(final FMLClientSetupEvent event) {
		ItemBlockRenderTypes.setRenderLayer(BlockInit.ACACIA_SHUTTER.get(),
				RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.BIRCH_SHUTTER.get(),
				RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.CRIMSON_SHUTTER.get(),
				RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.DARK_OAK_SHUTTER.get(),
				RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.IRON_SHUTTER.get(),
				RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.JUNGLE_SHUTTER.get(),
				RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.OAK_SHUTTER.get(),
				RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.SPRUCE_SHUTTER.get(),
				RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.WARPED_SHUTTER.get(),
				RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.GLASS_SHUTTER.get(),
				RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.BLOSSOM_SHUTTER.get(),
				RenderType.translucent());
	}
	
}
