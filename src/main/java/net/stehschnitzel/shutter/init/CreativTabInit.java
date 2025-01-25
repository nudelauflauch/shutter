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

	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ShutterMain.MOD_ID);

	public static final RegistryObject<CreativeModeTab> SHUTTER_TAB = CREATIVE_MODE_TAB.register("shutter_tab",
			() -> CreativeModeTab.builder()
					.title(Component.translatable("creativetab.shutter.shutter_tab"))
					.icon(() -> new ItemStack(BlockInit.OAK_SHUTTER.get()))
					.displayItems((pParameters, pOutput) -> {
						CreativTabInit.fillItemList(pOutput);
					})
					.build()
	);

	public static void fillItemList(CreativeModeTab.Output pItems) {
		registerMinecraftShutters(pItems);
//		if(ModList.get().isLoaded("create")) {
//			registerCreate(pItems);
//		}
//		if(ModList.get().isLoaded("ecologics")) {
//			registerEcologics(pItems);
//		}
//		if(ModList.get().isLoaded("endergetic")) {
//			registerEndergetic(pItems);
//		}
//		if(ModList.get().isLoaded("outer_end")) {
//			registerOuterEnd(pItems);
//		}
//		if(ModList.get().isLoaded("quark")) {
//			registerQuark(pItems);
//		}
//		if(ModList.get().isLoaded("Oreganized")) {
//			registerOreganized(pItems);
//		}
//		if(ModList.get().isLoaded("twigs")) {
//			registerTwigs(pItems);
//		}
//		if(ModList.get().isLoaded("autumnity")) {
//			registerAutumnity(pItems);
//		}
//		if(ModList.get().isLoaded("environmental")) {
//			registerEnvironmental(pItems);
//		}
//		if(ModList.get().isLoaded("snowyspirit")) {
//			registerSnowySpirit(pItems);
//		}
//		if(ModList.get().isLoaded("upgrade_aquatic")) {
//			registerUpdateAquatic(pItems);
//		}
//		if(ModList.get().isLoaded("goodending")) {
//			registerGoodEnding(pItems);
//		}
//		if (ModList.get().isLoaded("beachparty")) {
//			registerBeachParty(pItems);
//		}
//		if (!FMLLoader.isProduction()) {
//			registerCreate(pItems);
//			registerEcologics(pItems);
//			registerEndergetic(pItems);
//			registerOuterEnd(pItems);
//			registerQuark(pItems);
//			registerOreganized(pItems);
//			registerTwigs(pItems);
//			registerAutumnity(pItems);
//			registerEnvironmental(pItems);
//			registerSnowySpirit(pItems);
//			registerUpdateAquatic(pItems);
//			registerGoodEnding(pItems);
//			registerBeachParty(pItems);
//		}
	}

	private static void registerMinecraftShutters(CreativeModeTab.Output items) {
		items.accept(BlockInit.ACACIA_SHUTTER.get());
		items.accept(BlockInit.BIRCH_SHUTTER.get());
		items.accept(BlockInit.CRIMSON_SHUTTER.get());
		items.accept(BlockInit.DARK_OAK_SHUTTER.get());
		items.accept(BlockInit.IRON_SHUTTER.get());
		items.accept(BlockInit.JUNGLE_SHUTTER.get());
		items.accept(BlockInit.OAK_SHUTTER.get());
		items.accept(BlockInit.SPRUCE_SHUTTER.get());
		items.accept(BlockInit.WARPED_SHUTTER.get());
		items.accept(BlockInit.MANGROVE_SHUTTER.get());
		items.accept(BlockInit.BAMBOO_SHUTTER.get());
		items.accept(BlockInit.CHERRY_SHUTTER.get());
		items.accept(BlockInit.COPPER_SHUTTER.get());
		items.accept(BlockInit.EXPOSED_COPPER_SHUTTER.get());
		items.accept(BlockInit.WEATHERED_COPPER_SHUTTER.get());
		items.accept(BlockInit.OXIDIZED_COPPER_SHUTTER.get());

		items.accept(BlockInit.WAXED_COPPER_SHUTTER.get());
		items.accept(BlockInit.WAXED_EXPOSED_COPPER_SHUTTER.get());
		items.accept(BlockInit.WAXED_WEATHERED_COPPER_SHUTTER.get());
		items.accept(BlockInit.WAXED_OXIDIZED_COPPER_SHUTTER.get());

		//mc but not really
		items.accept(BlockInit.GOLD_SHUTTER.get());
		items.accept(BlockInit.NETHERITE_SHUTTER.get());
		items.accept(BlockInit.GLASS_SHUTTER.get());
	}

	private static void registerCreate(CreativeModeTab.Output items) {

	}

	private static void registerEcologics(CreativeModeTab.Output items) {
//		items.accept(BlockInit.AZALEA_SHUTTER.get());
//		items.accept(BlockInit.COCONUT_SHUTTER.get());
//		items.accept(BlockInit.FLOWERING_AZALEA_SHUTTER.get());
//		items.accept(BlockInit.WALNUT_SHUTTER.get());
	}

	private static void registerEndergetic(CreativeModeTab.Output items) {
//		items.accept(BlockInit.POISE_SHUTTER.get());
	}

	private static void registerOuterEnd(CreativeModeTab.Output items) {
//		items.accept(BlockInit.AZURE_SHUTTER.get());
	}

	private static void registerQuark(CreativeModeTab.Output items) {
//		items.accept(BlockInit.ANCIENT_SHUTTER.get());
//		items.accept(BlockInit.AZALEA_QUARK_SHUTTER.get());
//		items.accept(BlockInit.BLOSSOM_SHUTTER.get());
	}

	private static void registerOreganized(CreativeModeTab.Output items) {
//		items.accept(BlockInit.LEAD_SHUTTER.get());
//		items.accept(BlockInit.SILVER_SHUTTER.get());
	}

	private static void registerTwigs(CreativeModeTab.Output items) {
//		items.accept(BlockInit.STRIPPED_BAMBOO_SHUTTER.get());
	}

	private static void registerAutumnity(CreativeModeTab.Output items) {
//		items.accept(BlockInit.MAPLE_SHUTTER.get());
	}

	private static void registerEnvironmental(CreativeModeTab.Output items) {
//		items.accept(BlockInit.CHERRY_ENV_SHUTTER.get());
//		items.accept(BlockInit.WILLOW_SHUTTER.get());
//		items.accept(BlockInit.WISTERIA_SHUTTER.get());
	}

	private static void registerSnowySpirit(CreativeModeTab.Output items) {
//		items.accept(BlockInit.GINGERBREAD_SHUTTER.get());
	}

	private static void registerUpdateAquatic(CreativeModeTab.Output items) {
//		items.accept(BlockInit.DRIFTWOOD_SHUTTER.get());
//		items.accept(BlockInit.RIVER_SHUTTER.get());
	}

	private static void registerGoodEnding(CreativeModeTab.Output items) {
//		items.accept(BlockInit.CYPRESS_SHUTTER.get());
//		items.accept(BlockInit.MUDDY_OAK_SHUTTER.get());
	}

	private static void registerBeachParty(CreativeModeTab.Output items) {
//		items.accept(BlockInit.PALM_SHUTTER.get());
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
		modItems.put("snowyspirit", BlockInit.ITEMS_SNOWY_SPIRIT);
		modItems.put("upgrade_aquatic", BlockInit.ITEMS_UPGRADE_AQUATTIC);
		modItems.put("goodending", BlockInit.ITEMS_GOODENDING);
		modItems.put("beachparty", BlockInit.ITEMS_BEACHPARTY);

		for (Map.Entry<String, DeferredRegister<Item>> entry : modItems.entrySet()) {
			String modId = entry.getKey();
			DeferredRegister<Item> itemSupplier = entry.getValue();
			itemSupplier.register(bus);
			if (ModList.get().isLoaded(modId)) {
				itemSupplier.register(bus);
			}

			if (!FMLLoader.isProduction()) {

			}
		}
	}

	public static void register(IEventBus eventBus) {
		CREATIVE_MODE_TAB.register(eventBus);
	}

}
