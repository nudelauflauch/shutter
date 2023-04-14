package net.stehschnitzel.shutter;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLLoader;
import net.stehschnitzel.shutter.init.ItemInit;

@Mod.EventBusSubscriber(modid = ShutterMain.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ShutterTab{

	public static CreativeModeTab SHUTTER_TAB;

	@SubscribeEvent
	public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
		SHUTTER_TAB = event.registerCreativeModeTab(new ResourceLocation(ShutterMain.MODID, "shutter_tab"),
				builder -> builder.icon(() -> new ItemStack(ItemInit.OAK_SHUTTER.get())).title(Component.literal("Shutter Tab")).build());
	}


	public static void fillCreativeMenu(CreativeModeTabEvent.BuildContents event) {

		registerMinecraftShutters(event);

		if(ModList.get().isLoaded("create")) {
			registerCreate(event);
		} 
		if(ModList.get().isLoaded("ecologics")) {
			registerEcologics(event);
		} 
		if(ModList.get().isLoaded("endergetic")) {
			registerEndergetic(event);
		} 
		if(ModList.get().isLoaded("outer_end")) {
			registerOuterEnd(event);
		} 
		if(ModList.get().isLoaded("quark")) {
			registerQuark(event);
		} 
		if(ModList.get().isLoaded("supplementaries")) {
			registerSupplementaries(event);
		} 
		if(ModList.get().isLoaded("twigs")) {
			registerTwigs(event);
		} 
		if(ModList.get().isLoaded("oreganized")) {
			registerOreganized(event);
		} 
		if (!FMLLoader.isProduction()) {
			registerCreate(event);
			registerEcologics(event);
			registerEndergetic(event);
			registerOuterEnd(event);
			registerQuark(event);
			registerSupplementaries(event);
			registerTwigs(event);
			registerOreganized(event);
			
		}
	}

	private static void registerMinecraftShutters(CreativeModeTabEvent.BuildContents event) {
		event.accept(new ItemStack(ItemInit.ACACIA_SHUTTER.get()));
		event.accept(new ItemStack(ItemInit.BIRCH_SHUTTER.get()));
		event.accept(new ItemStack(ItemInit.CRIMSON_SHUTTER.get()));
		event.accept(new ItemStack(ItemInit.DARK_OAK_SHUTTER.get()));
		event.accept(new ItemStack(ItemInit.IRON_SHUTTER.get()));
		event.accept(new ItemStack(ItemInit.JUNGLE_SHUTTER.get()));
		event.accept(new ItemStack(ItemInit.OAK_SHUTTER.get()));
		event.accept(new ItemStack(ItemInit.SPRUCE_SHUTTER.get()));
		event.accept(new ItemStack(ItemInit.WARPED_SHUTTER.get()));
	}

	private static void registerCreate(CreativeModeTabEvent.BuildContents event) {
		event.accept(new ItemStack(ItemInit.GLASS_SHUTTER.get()));
	}

	private static void registerEcologics(CreativeModeTabEvent.BuildContents event) {
		event.accept(new ItemStack(ItemInit.AZALEA_SHUTTER.get()));
		event.accept(new ItemStack(ItemInit.COCONUT_SHUTTER.get()));
		event.accept(new ItemStack(ItemInit.FLOWERING_AZALEA_SHUTTER.get()));
		event.accept(new ItemStack(ItemInit.WALNUT_SHUTTER.get()));
	}

	private static void registerEndergetic(CreativeModeTabEvent.BuildContents event) {
		event.accept(new ItemStack(ItemInit.POISE_SHUTTER.get()));
	}
	private static void registerOuterEnd(CreativeModeTabEvent.BuildContents event) {
		event.accept(new ItemStack(ItemInit.AZURE_SHUTTER.get()));
	}
	private static void registerQuark(CreativeModeTabEvent.BuildContents event) {
		event.accept(new ItemStack(ItemInit.BLOSSOM_SHUTTER.get()));
	}
	private static void registerSupplementaries(CreativeModeTabEvent.BuildContents event) {
		event.accept(new ItemStack(ItemInit.GOLD_SHUTTER.get()));
		event.accept(new ItemStack(ItemInit.NETHERITE_SHUTTER.get()));
	}
	private static void registerTwigs(CreativeModeTabEvent.BuildContents event) {
		event.accept(new ItemStack(ItemInit.STRIPPED_BAMBOO_SHUTTER.get()));
	}
	
	private static void registerOreganized(CreativeModeTabEvent.BuildContents event) {
		event.accept(new ItemStack(ItemInit.SILVER_SHUTTER.get()));
		event.accept(new ItemStack(ItemInit.LEAD_SHUTTER.get()));
	}
}
