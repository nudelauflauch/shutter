package net.stehschnitzel.shutter.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.stehschnitzel.shutter.ShutterMain;


public class CreativTabInit{

	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ShutterMain.MOD_ID);

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SHUTTER_TAB = CREATIVE_MODE_TAB.register("shutter_tab",
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
        if (ModList.get().isLoaded("beachparty")) {
            registerBeachParty(pItems);
        }
        if(ModList.get().isLoaded("autumnity")) {
            registerAutumnity(pItems);
        }
        if(ModList.get().isLoaded("caverns_and_chasms")) {
            registerCavernsChasms(pItems);
        }
        if(ModList.get().isLoaded("ecologics")) {
            registerEcologics(pItems);
        }
        if(ModList.get().isLoaded("environmental")) {
            registerEnvironmental(pItems);
        }
        if(ModList.get().isLoaded("goodending")) {
            registerGoodEnding(pItems);
        }
        if(ModList.get().isLoaded("oreganized")) {
            registerOreganized(pItems);
        }
        if(ModList.get().isLoaded("quark")) {
            registerQuark(pItems);
        }
        if(ModList.get().isLoaded("snowyspirit")) {
            registerSnowySpirit(pItems);
        }
        if(ModList.get().isLoaded("endergetic")) {
            registerEndergetic(pItems);
        }
        if(ModList.get().isLoaded("outer_end")) {
            registerOuterEnd(pItems);
        }
        if(ModList.get().isLoaded("twigs")) {
            registerTwigs(pItems);
        }
        if(ModList.get().isLoaded("upgrade_aquatic")) {
            registerUpdateAquatic(pItems);
        }
        if(ModList.get().isLoaded("natures_spirit")) {
            registerNaturesSpirit(pItems);
        }
		if (!FMLLoader.isProduction()) {
            registerBeachParty(pItems);
            registerAutumnity(pItems);
            registerCavernsChasms(pItems);
            registerEcologics(pItems);
            registerEnvironmental(pItems);
            registerGoodEnding(pItems);
            registerOreganized(pItems);
            registerQuark(pItems);
            registerSnowySpirit(pItems);
            registerEndergetic(pItems);
            registerOuterEnd(pItems);
            registerTwigs(pItems);
            registerUpdateAquatic(pItems);
            registerNaturesSpirit(pItems);
		}
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

    private static void registerBeachParty(CreativeModeTab.Output items) {
		items.accept(BlockInit.PALM_SHUTTER.get());
    }

    private static void registerAutumnity(CreativeModeTab.Output items) {
		items.accept(BlockInit.MAPLE_SHUTTER.get());
    }

    private static void registerCavernsChasms(CreativeModeTab.Output items) {
        items.accept(BlockInit.CAVERN_AZALEA_SHUTTER.get());
    }

	private static void registerEcologics(CreativeModeTab.Output items) {
		items.accept(BlockInit.AZALEA_SHUTTER.get());
		items.accept(BlockInit.COCONUT_SHUTTER.get());
		items.accept(BlockInit.FLOWERING_AZALEA_SHUTTER.get());
		items.accept(BlockInit.WALNUT_SHUTTER.get());
	}

    private static void registerEnvironmental(CreativeModeTab.Output items) {
		items.accept(BlockInit.PLUM_SHUTTER.get());
		items.accept(BlockInit.WILLOW_SHUTTER.get());
		items.accept(BlockInit.WISTERIA_SHUTTER.get());
		items.accept(BlockInit.PINE_SHUTTER.get());
    }

    private static void registerGoodEnding(CreativeModeTab.Output items) {
		items.accept(BlockInit.CYPRESS_SHUTTER.get());
		items.accept(BlockInit.MUDDY_OAK_SHUTTER.get());
    }

    private static void registerOreganized(CreativeModeTab.Output items) {
//		items.accept(BlockInit.LEAD_SHUTTER.get());
//		items.accept(BlockInit.SILVER_SHUTTER.get());
    }

    private static void registerQuark(CreativeModeTab.Output items) {
        items.accept(BlockInit.BLOSSOM_SHUTTER.get());
        items.accept(BlockInit.ANCIENT_SHUTTER.get());
        items.accept(BlockInit.AZALEA_QUARK_SHUTTER.get());
    }

    private static void registerSnowySpirit(CreativeModeTab.Output items) {
		items.accept(BlockInit.GINGERBREAD_SHUTTER.get());
    }

	private static void registerEndergetic(CreativeModeTab.Output items) {
//		items.accept(BlockInit.POISE_SHUTTER.get());
	}

	private static void registerOuterEnd(CreativeModeTab.Output items) {
//		items.accept(BlockInit.AZURE_SHUTTER.get());
	}

	private static void registerTwigs(CreativeModeTab.Output items) {
		items.accept(BlockInit.STRIPPED_BAMBOO_SHUTTER.get());
	}

	private static void registerUpdateAquatic(CreativeModeTab.Output items) {
		items.accept(BlockInit.DRIFTWOOD_SHUTTER.get());
		items.accept(BlockInit.RIVER_SHUTTER.get());
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
		CREATIVE_MODE_TAB.register(eventBus);
	}

}
