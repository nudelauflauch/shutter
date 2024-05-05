package net.stehschnitzel.shutter;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.stehschnitzel.shutter.init.BlockInit;
import net.stehschnitzel.shutter.init.CreativTabInit;
import net.stehschnitzel.shutter.init.SoundInit;

@Mod(ShutterMain.MODID)
public class ShutterMain {
	public static final String MODID = "shutter";
	public ShutterMain() {
<<<<<<< Updated upstream
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();


		BlockInit.MINECRAFT_ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		SoundInit.register(bus);
		CreativTabInit.TABS.register(bus);
		CreativTabInit.registerDeferredItemRegister(bus);
=======
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		Init.MINECRAFT_ITEMS.register(bus);
		Init.BLOCKS.register(bus);

		SoundInit.register(bus);

		if (ModList.get().isLoaded("create")) {
			Init.ITEMS_CREATE.register(bus);
		}

		if (ModList.get().isLoaded("ecologics")) {
			Init.ITEMS_ECOLOGICS.register(bus);
		}

		if (ModList.get().isLoaded("endergetic_expansison")) {
			Init.ITEMS_ENDERGETIC.register(bus);
		}

		if (ModList.get().isLoaded("outer_end")) {
			Init.ITEMS_OUTER_END.register(bus);
		}

		if (ModList.get().isLoaded("quark")) {
			Init.ITEMS_QUARK.register(bus);
		}

		if (ModList.get().isLoaded("supplementaries")) {
			Init.ITEMS_SUPPLEMENTARIES.register(bus);
		}

		if (ModList.get().isLoaded("twigs")) {
			Init.ITEMS_TWIGS.register(bus);
		}
		if (ModList.get().isLoaded("oreganized")) {
			Init.ITEMS_OREGANIZED.register(bus);
		}

		bus.addListener(this::setup);
>>>>>>> Stashed changes

		MinecraftForge.EVENT_BUS.register(this);
	}

<<<<<<< Updated upstream
=======
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
		ItemBlockRenderTypes.setRenderLayer(Init.GLASS_SHUTTER.get(),
				RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(Init.BLOSSOM_SHUTTER.get(),
				RenderType.translucent());
	}
>>>>>>> Stashed changes
}
