package net.stehschnitzel.shutter;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLLoader;
import net.stehschnitzel.shutter.init.BlockInit;
import net.stehschnitzel.shutter.init.ItemInit;
import net.stehschnitzel.shutter.init.SoundInit;

import static net.minecraftforge.versions.forge.ForgeVersion.MOD_ID;

@Mod(ShutterMain.MODID)
public class ShutterMain {
	public static final String MODID = "shutter";

	public ShutterMain() {
		final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		ItemInit.MINECRAFT_ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		SoundInit.register(bus);
		ShutterTab.loadMods(bus);
		MinecraftForge.EVENT_BUS.register(this);

		bus.addListener(this::addCreative);

	}

	private void addCreative(CreativeModeTabEvent.BuildContents event) {
		if (event.getTab() == ShutterTab.SHUTTER_TAB) {
			ShutterTab.fillCreativeMenu(event);
		}
	}
}