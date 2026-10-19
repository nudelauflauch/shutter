package net.stehschnitzel.shutter.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.stehschnitzel.shutter.ShutterMain;

public class ShutterItemGroup {

    public static final CreativeModeTab SHUTTER_GROUP = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(ShutterMain.MOD_ID, "shutter"),
            FabricItemGroup.builder().title(Component.translatable("creativetab.shutter.shutter_tab"))
                    .icon(() -> new ItemStack(BlockInit.OAK_SHUTTER)).displayItems((displayContext, entries) -> {
                        fillItemList(entries);
                    }).build());

    public static void fillItemList(CreativeModeTab.Output items) {
        registerMinecraftShutters(items);
        if (FabricLoader.getInstance().isModLoaded("create")) {
            registerCreate(items);
        }
        if (FabricLoader.getInstance().isModLoaded("ecologics")) {
            registerEcologics(items);
        }
        if (FabricLoader.getInstance().isModLoaded("endergetic")) {
            registerEndergetic(items);
        }
        if (FabricLoader.getInstance().isModLoaded("outer_end")) {
            registerOuterEnd(items);
        }
        if (FabricLoader.getInstance().isModLoaded("quark")) {
            registerQuark(items);
        }
        if (FabricLoader.getInstance().isModLoaded("supplementaries")) {
            registerSupplementaries(items);
        }
        if (FabricLoader.getInstance().isModLoaded("twigs")) {
             registerTwigs(items);
        }
        if (FabricLoader.getInstance().isModLoaded("autumnity")) {
            registerAutumnity(items);
        }
        if (FabricLoader.getInstance().isModLoaded("environmental")) {
            registerEnvironmental(items);
        }
        if (FabricLoader.getInstance().isModLoaded("snowyspirit")) {
            registerSnowySpirit(items);
        }
        if (FabricLoader.getInstance().isModLoaded("upgrade_aquatic")) {
            registerUpdateAquatic(items);
        }
        if (FabricLoader.getInstance().isModLoaded("goodending")) {
            registerGoodEnding(items);
        }
        if (FabricLoader.getInstance().isDevelopmentEnvironment()) {
            registerCreate(items);
            registerEcologics(items);
            registerEndergetic(items);
            registerOuterEnd(items);
            registerQuark(items);
            registerSupplementaries(items);
            registerTwigs(items);
            registerOreganized(items);
            registerAutumnity(items);
            registerEnvironmental(items);
            registerSnowySpirit(items);
            registerUpdateAquatic(items);
            registerGoodEnding(items);
            registerBeachParty(items);
        }
    }

    private static void registerMinecraftShutters(CreativeModeTab.Output items) {
        items.accept(BlockInit.ACACIA_SHUTTER);
        items.accept(BlockInit.BIRCH_SHUTTER);
        items.accept(BlockInit.CRIMSON_SHUTTER);
        items.accept(BlockInit.DARK_OAK_SHUTTER);
        items.accept(BlockInit.IRON_SHUTTER);
        items.accept(BlockInit.JUNGLE_SHUTTER);
        items.accept(BlockInit.OAK_SHUTTER);
        items.accept(BlockInit.SPRUCE_SHUTTER);
        items.accept(BlockInit.WARPED_SHUTTER);
        items.accept(BlockInit.MANGROVE_SHUTTER);
        items.accept(BlockInit.BAMBOO_SHUTTER);
        items.accept(BlockInit.CHERRY_SHUTTER);
        items.accept(BlockInit.PALE_OAK_SHUTTER);
        items.accept(BlockInit.COPPER_SHUTTER);
        items.accept(BlockInit.EXPOSED_COPPER_SHUTTER);
        items.accept(BlockInit.OXIDIZED_COPPER_SHUTTER);
        items.accept(BlockInit.WEATHERED_COPPER_SHUTTER);
        items.accept(BlockInit.WAXED_COPPER_SHUTTER);
        items.accept(BlockInit.WAXED_EXPOSED_COPPER_SHUTTER);
        items.accept(BlockInit.WAXED_OXIDIZED_COPPER_SHUTTER);
        items.accept(BlockInit.WAXED_WEATHERED_COPPER_SHUTTER);


        items.accept(new ItemStack(BlockInit.GOLD_SHUTTER));
        items.accept(new ItemStack(BlockInit.NETHERITE_SHUTTER));
        items.accept(new ItemStack(BlockInit.GLASS_SHUTTER));
    }

    private static void registerCreate(CreativeModeTab.Output items) {
    }

    private static void registerEcologics(CreativeModeTab.Output items) {
        items.accept(BlockInit.AZALEA_SHUTTER);
        items.accept(BlockInit.COCONUT_SHUTTER);
        items.accept(BlockInit.FLOWERING_AZALEA_SHUTTER);
        items.accept(BlockInit.WALNUT_SHUTTER);
    }

    private static void registerEndergetic(CreativeModeTab.Output items) {
//        items.accept(BlockInit.POISE_SHUTTER);
    }

    private static void registerOuterEnd(CreativeModeTab.Output items) {
//        items.accept(BlockInit.AZURE_SHUTTER);
    }

    private static void registerQuark(CreativeModeTab.Output items) {
//        items.accept(BlockInit.ANCIENT_SHUTTER);
//        items.accept(BlockInit.AZALEA_QUARK_SHUTTER);
//        items.accept(BlockInit.BLOSSOM_SHUTTER);

    }

    private static void registerSupplementaries(CreativeModeTab.Output items) {
//        items.accept(BlockInit.GOLD_SHUTTER);
//        items.accept(BlockInit.NETHERITE_SHUTTER);
    }

    private static void registerTwigs(CreativeModeTab.Output items) {
        items.accept(BlockInit.STRIPPED_BAMBOO_SHUTTER);
    }

    private static void registerOreganized(CreativeModeTab.Output items) {
//        items.accept(BlockInit.SILVER_SHUTTER);
//        items.accept(BlockInit.LEAD_SHUTTER);
    }

    private static void registerAutumnity(CreativeModeTab.Output items) {
//        items.accept(BlockInit.MAPLE_SHUTTER);
    }

    private static void registerEnvironmental(CreativeModeTab.Output items) {
//        items.accept(BlockInit.CHERRY_ENV_SHUTTER);
//        items.accept(BlockInit.WILLOW_SHUTTER);
//        items.accept(BlockInit.WISTERIA_SHUTTER);
    }

    private static void registerSnowySpirit(CreativeModeTab.Output items) {
        items.accept(BlockInit.GINGERBREAD_SHUTTER);
    }

    private static void registerUpdateAquatic(CreativeModeTab.Output items) {
//        items.accept(BlockInit.DRIFTWOOD_SHUTTER);
//        items.accept(BlockInit.RIVER_SHUTTER);
    }

    private static void registerGoodEnding(CreativeModeTab.Output items) {
        items.accept(BlockInit.CYPRESS_SHUTTER);
        items.accept(BlockInit.MUDDY_OAK_SHUTTER);
    }

    private static void registerBeachParty(CreativeModeTab.Output items) {
        items.accept(BlockInit.PALM_SHUTTER);
    }

    public static void registerItemGroups() {

    }
}
