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
			registerOreganized(pItems);
		}
		if(ModList.get().isLoaded("twigs")) {
			registerTwigs(pItems);
		}
		if(ModList.get().isLoaded("autumnity")) {
			registerAutumnity(pItems);
		}
		if(ModList.get().isLoaded("environmental")) {
			registerEnvironmental(pItems);
		}
		if(ModList.get().isLoaded("snowyspirit")) {
			registerSnowySpirit(pItems);
		}
		if(ModList.get().isLoaded("upgrade_aquatic")) {
			registerUpdateAquatic(pItems);
		}
		if(ModList.get().isLoaded("goodending")) {
			registerGoodEnding(pItems);
		}
		if (ModList.get().isLoaded("beachparty")) {
			registerBeachParty(pItems);
		}
		if (ModList.get().isLoaded("caverns_and_chasms")) {
			registerBeachParty(pItems);
		}
        if(ModList.get().isLoaded("natures_spirit")) {
            registerNaturesSpirit(pItems);
        }
		if (!FMLLoader.isProduction()) {
			registerCreate(pItems);
			registerEcologics(pItems);
			registerEndergetic(pItems);
			registerOuterEnd(pItems);
			registerQuark(pItems);
			registerOreganized(pItems);
			registerTwigs(pItems);
			registerAutumnity(pItems);
			registerEnvironmental(pItems);
			registerSnowySpirit(pItems);
			registerUpdateAquatic(pItems);
			registerGoodEnding(pItems);
			registerBeachParty(pItems);
			registerCavernsChasms(pItems);
            registerNaturesSpirit(pItems);
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

		items.accept(BlockInit.COPPER_SHUTTER.get());
		items.accept(BlockInit.EXPOSED_COPPER_SHUTTER.get());
		items.accept(BlockInit.WEATHERED_COPPER_SHUTTER.get());
		items.accept(BlockInit.OXIDIZED_COPPER_SHUTTER.get());

		items.accept(BlockInit.WAXED_COPPER_SHUTTER.get());
		items.accept(BlockInit.WAXED_EXPOSED_COPPER_SHUTTER.get());
		items.accept(BlockInit.WAXED_WEATHERED_COPPER_SHUTTER.get());
		items.accept(BlockInit.WAXED_OXIDIZED_COPPER_SHUTTER.get());

		//mc but not really
		items.accept(new ItemStack(BlockInit.GOLD_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.NETHERITE_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.GLASS_SHUTTER.get()));
	}

	private static void registerCreate(CreativeModeTab.Output items) {

	}

	private static void registerEcologics(CreativeModeTab.Output items) {
		items.accept(new ItemStack(BlockInit.CAVERN_AZALEA_SHUTTER.get()));
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
		items.accept(new ItemStack(BlockInit.AZALEA_QUARK_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.BLOSSOM_SHUTTER.get()));
	}

	private static void registerOreganized(CreativeModeTab.Output items) {
//		items.accept(new ItemStack(BlockInit.LEAD_SHUTTER.get()));
//		items.accept(new ItemStack(BlockInit.SILVER_SHUTTER.get()));
	}

	private static void registerTwigs(CreativeModeTab.Output items) {
		items.accept(new ItemStack(BlockInit.STRIPPED_BAMBOO_SHUTTER.get()));
	}

	private static void registerAutumnity(CreativeModeTab.Output items) {
		items.accept(new ItemStack(BlockInit.MAPLE_SHUTTER.get()));
	}

	private static void registerEnvironmental(CreativeModeTab.Output items) {
		items.accept(new ItemStack(BlockInit.PLUM_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.WILLOW_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.WISTERIA_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.PINE_SHUTTER.get()));
	}

	private static void registerSnowySpirit(CreativeModeTab.Output items) {
		items.accept(new ItemStack(BlockInit.GINGERBREAD_SHUTTER.get()));
	}

	private static void registerUpdateAquatic(CreativeModeTab.Output items) {
		items.accept(new ItemStack(BlockInit.DRIFTWOOD_SHUTTER.get()));
		items.accept(new ItemStack(BlockInit.RIVER_SHUTTER.get()));
	}

	private static void registerGoodEnding(CreativeModeTab.Output items) {
		items.accept(BlockInit.CYPRESS_SHUTTER.get());
		items.accept(BlockInit.MUDDY_OAK_SHUTTER.get());
	}

	private static void registerBeachParty(CreativeModeTab.Output items) {
		items.accept(BlockInit.PALM_SHUTTER.get());
	}

	private static void registerCavernsChasms(CreativeModeTab.Output items) {
		items.accept(BlockInit.CAVERN_AZALEA_SHUTTER.get());
	}
    private static void registerNaturesSpirit(CreativeModeTab.Output items) {
        items.accept(BlockInit.ASPEN_SHUTTER.get());
        items.accept(BlockInit.BLOOMING_PAPER_SHUTTER.get());
        items.accept(BlockInit.CEDAR_SHUTTER.get());
        items.accept(BlockInit.FIR_SHUTTER.get());
        items.accept(BlockInit.FRAMED_PAPER_SHUTTER.get());
        items.accept(BlockInit.GHAF_SHUTTER.get());
        items.accept(BlockInit.JOSHUA_SHUTTER.get());
        items.accept(BlockInit.LARCH_SHUTTER.get());
        items.accept(BlockInit.MAHOGANY_SHUTTER.get());
        items.accept(BlockInit.NAS_COCONUT_SHUTTER.get());
        items.accept(BlockInit.NAS_CYPRESS_SHUTTER.get());
        items.accept(BlockInit.NAS_MAPLE_SHUTTER.get());
        items.accept(BlockInit.NAS_WILLOW_SHUTTER.get());
        items.accept(BlockInit.NAS_WISTERIA_SHUTTER.get());
        items.accept(BlockInit.OLIVE_SHUTTER.get());
        items.accept(BlockInit.PALO_VERDE_SHUTTER.get());
        items.accept(BlockInit.PAPER_SHUTTER.get());
        items.accept(BlockInit.REDWOOD_SHUTTER.get());
        items.accept(BlockInit.SAXAUL_SHUTTER.get());
        items.accept(BlockInit.SUGI_SHUTTER.get());
    }

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }

}
