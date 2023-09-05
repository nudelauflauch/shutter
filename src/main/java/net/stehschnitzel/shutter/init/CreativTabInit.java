package net.stehschnitzel.shutter.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.stehschnitzel.shutter.ShutterMain;

import java.util.HashMap;
import java.util.Map;


public class CreativTabInit{

	public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ShutterMain.MODID);

	public static final RegistryObject<CreativeModeTab> SHUTTER_TAB = TABS.register("shutter_tab",
			() -> CreativeModeTab.builder()
					.title(Component.translatable("itemGroup.shutter_tab"))
					.icon(() -> new ItemStack(BlockInit.OAK_SHUTTER.get()))
					.displayItems((pParameters, pOutput) -> {
						CreativTabInit.fillItemList(pOutput);
					})
					.build()
	);

	public static void fillItemList(CreativeModeTab.Output pItems) {
		registerMinecraftShutters(pItems);
		if(ModList.get().isLoaded("create")) {
			registerCreate(pItems);
		}
		if(ModList.get().isLoaded("ecologics")) {
			registerEcologics(pItems);
		}
		if(ModList.get().isLoaded("endergetic")) {
			registerEndergetic(pItems);
		}
		if(ModList.get().isLoaded("outer_end")) {
			registerOuterEnd(pItems);
		}
		if(ModList.get().isLoaded("quark")) {
			registerQuark(pItems);
		}
		if(ModList.get().isLoaded("supplementaries")) {
			registerSupplementaries(pItems);
		}
		if(ModList.get().isLoaded("twigs")) {
			registerTwigs(pItems);
		}
		if(ModList.get().isLoaded("oreganized")) {
			registerOreganized(pItems);
		}
		if(ModList.get().isLoaded("autumnity")) {
			registerAutumnity(pItems);
		}
		if(ModList.get().isLoaded("environmental")) {
			registerEnvironmental(pItems);
		}
		if(ModList.get().isLoaded("snowy_spirit")) {
			registerSnowySpirit(pItems);
		}
		if(ModList.get().isLoaded("upgrade_aquatic")) {
			registerUpdateAquatic(pItems);
		}
		if (!FMLLoader.isProduction()) {
			registerCreate(pItems);
			registerEcologics(pItems);
			registerEndergetic(pItems);
			registerOuterEnd(pItems);
			registerQuark(pItems);
			registerSupplementaries(pItems);
			registerTwigs(pItems);
			registerOreganized(pItems);
			registerAutumnity(pItems);
			registerEnvironmental(pItems);
			registerSnowySpirit(pItems);
			registerUpdateAquatic(pItems);
		}
	}

	private static void registerMinecraftShutters(CreativeModeTab.Output items) {
		items.accept(new ItemStack(BlockInit.ACACIA_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.BIRCH_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.CRIMSON_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.DARK_OAK_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.IRON_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.JUNGLE_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.OAK_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.SPRUCE_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.WARPED_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.MANGROVE_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.BAMBOO_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.CHERRY_SHUTTER.get()));
	}

	private static void registerCreate(CreativeModeTab.Output items) {
		items.accept(new ItemStack(BlockInit.GLASS_SHUTTER.get()));
	}

	private static void registerEcologics(CreativeModeTab.Output items) {
		items.accept(new ItemStack(BlockInit.AZALEA_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.COCONUT_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.FLOWERING_AZALEA_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.WALNUT_SHUTTER.get()));
	}

	private static void registerEndergetic(CreativeModeTab.Output items) {
		items.accept(new ItemStack(BlockInit.POISE_SHUTTER.get()));
	}

	private static void registerOuterEnd(CreativeModeTab.Output items) {
		items.accept(new ItemStack(BlockInit.AZURE_SHUTTER.get()));
	}

	private static void registerQuark(CreativeModeTab.Output items) {
		items.accept(new ItemStack(BlockInit.ANCIENT_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.BLOSSOM_SHUTTER.get()));
	}

	private static void registerSupplementaries(CreativeModeTab.Output items) {
		items.accept(new ItemStack(BlockInit.GOLD_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.NETHERITE_SHUTTER.get()));
	}

	private static void registerTwigs(CreativeModeTab.Output items) {
		items.accept(new ItemStack(BlockInit.STRIPPED_BAMBOO_SHUTTER.get()));
	}

	private static void registerOreganized(CreativeModeTab.Output items) {
		items.accept(new ItemStack(BlockInit.SILVER_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.LEAD_SHUTTER.get()));
	}

	private static void registerAutumnity(CreativeModeTab.Output items) {
		items.accept(new ItemStack(BlockInit.MAPLE_SHUTTER.get()));
	}

	private static void registerEnvironmental(CreativeModeTab.Output items) {
		items.accept(new ItemStack(BlockInit.CHERRY_ENV_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.WILLOW_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.WISTERIA_SHUTTER.get()));
	}

	private static void registerSnowySpirit(CreativeModeTab.Output items) {
		items.accept(new ItemStack(BlockInit.GINGERBREAD_SHUTTER.get()));
	}

	private static void registerUpdateAquatic(CreativeModeTab.Output items) {
		items.accept(new ItemStack(BlockInit.DRIFTWOOD_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.RIVER_SHUTTER.get()));
	}

	public static void registerDeferredItemRegister(IEventBus bus){
		Map<String, DeferredRegister<Item>> modItems = new HashMap<>();
		modItems.put("autumnity", BlockInit.ITEMS_AUTUMNITY);
		modItems.put("create", BlockInit.ITEMS_CREATE);
		modItems.put("ecologics", BlockInit.ITEMS_ECOLOGICS);
		modItems.put("endergetic", BlockInit.ITEMS_ENDERGETIC);
		modItems.put("outer_end", BlockInit.ITEMS_OUTER_END);
		modItems.put("quark", BlockInit.ITEMS_QUARK);
		modItems.put("supplementaries", BlockInit.ITEMS_SUPPLEMENTARIES);
		modItems.put("twigs", BlockInit.ITEMS_TWIGS);
		modItems.put("oreganized", BlockInit.ITEMS_OREGANIZED);
		modItems.put("environmental", BlockInit.ITEMS_ENVIRONMENTAL);
		modItems.put("snowy_spirit", BlockInit.ITEMS_SNOWY_SPIRIT);
		modItems.put("upgrade_aquatic", BlockInit.ITEMS_UPGRADE_AQUATTIC);

		for (Map.Entry<String, DeferredRegister<Item>> entry : modItems.entrySet()) {
			String modId = entry.getKey();
			DeferredRegister<Item> itemSupplier = entry.getValue();

			if (ModList.get().isLoaded(modId)) {
				itemSupplier.register(bus);
			}

			if (!FMLLoader.isProduction()) {
				itemSupplier.register(bus);
			}
		}
	}
}
