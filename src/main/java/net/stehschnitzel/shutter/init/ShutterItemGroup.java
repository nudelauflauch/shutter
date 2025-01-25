package net.stehschnitzel.shutter.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.stehschnitzel.shutter.ShutterMain;

public class ShutterItemGroup {

    public static final ItemGroup SHUTTER_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ShutterMain.MOD_ID, "shutter"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.shutter_tab"))
                    .icon(() -> new ItemStack(BlockInit.OAK_SHUTTER)).entries((displayContext, entries) -> {
                        fillItemList(entries);
                    }).build());

    public static void fillItemList(ItemGroup.Entries items) {
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
        }
    }

    private static void registerMinecraftShutters(ItemGroup.Entries items) {
        items.add(BlockInit.ACACIA_SHUTTER);
        items.add(BlockInit.BIRCH_SHUTTER);
        items.add(BlockInit.CRIMSON_SHUTTER);
        items.add(BlockInit.DARK_OAK_SHUTTER);
        items.add(BlockInit.IRON_SHUTTER);
        items.add(BlockInit.JUNGLE_SHUTTER);
        items.add(BlockInit.OAK_SHUTTER);
        items.add(BlockInit.SPRUCE_SHUTTER);
        items.add(BlockInit.WARPED_SHUTTER);
        items.add(BlockInit.MANGROVE_SHUTTER);
        items.add(BlockInit.BAMBOO_SHUTTER);
        items.add(BlockInit.CHERRY_SHUTTER);
        items.add(BlockInit.COPPER_SHUTTER);
        items.add(BlockInit.EXPOSED_COPPER_SHUTTER);
        items.add(BlockInit.OXIDIZED_COPPER_SHUTTER);
        items.add(BlockInit.WEATHERED_COPPER_SHUTTER);
        items.add(BlockInit.WAXED_COPPER_SHUTTER);
        items.add(BlockInit.WAXED_EXPOSED_COPPER_SHUTTER);
        items.add(BlockInit.WAXED_OXIDIZED_COPPER_SHUTTER);
        items.add(BlockInit.WAXED_WEATHERED_COPPER_SHUTTER);

        items.add(BlockInit.GOLD_SHUTTER);
        items.add(BlockInit.NETHERITE_SHUTTER);
        items.add(BlockInit.GLASS_SHUTTER);
    }

    private static void registerCreate(ItemGroup.Entries items) {
    }

    private static void registerEcologics(ItemGroup.Entries items) {
        items.add(BlockInit.AZALEA_SHUTTER);
        items.add(BlockInit.COCONUT_SHUTTER);
        items.add(BlockInit.FLOWERING_AZALEA_SHUTTER);
        items.add(BlockInit.WALNUT_SHUTTER);
    }

    private static void registerEndergetic(ItemGroup.Entries items) {
        items.add(BlockInit.POISE_SHUTTER);
    }

    private static void registerOuterEnd(ItemGroup.Entries items) {
        items.add(BlockInit.AZURE_SHUTTER);
    }

    private static void registerQuark(ItemGroup.Entries items) {
        items.add(BlockInit.ANCIENT_SHUTTER);
        items.add(BlockInit.AZALEA_QUARK_SHUTTER);
        items.add(BlockInit.BLOSSOM_SHUTTER);

    }

    private static void registerSupplementaries(ItemGroup.Entries items) {
//        items.add(BlockInit.GOLD_SHUTTER);
//        items.add(BlockInit.NETHERITE_SHUTTER);
    }

    private static void registerTwigs(ItemGroup.Entries items) {
        items.add(BlockInit.STRIPPED_BAMBOO_SHUTTER);
    }

    private static void registerOreganized(ItemGroup.Entries items) {
        items.add(BlockInit.SILVER_SHUTTER);
        items.add(BlockInit.LEAD_SHUTTER);
    }

    private static void registerAutumnity(ItemGroup.Entries items) {
        items.add(BlockInit.MAPLE_SHUTTER);
    }

    private static void registerEnvironmental(ItemGroup.Entries items) {
        items.add(BlockInit.CHERRY_ENV_SHUTTER);
        items.add(BlockInit.WILLOW_SHUTTER);
        items.add(BlockInit.WISTERIA_SHUTTER);
    }

    private static void registerSnowySpirit(ItemGroup.Entries items) {
        items.add(BlockInit.GINGERBREAD_SHUTTER);
    }

    private static void registerUpdateAquatic(ItemGroup.Entries items) {
        items.add(BlockInit.DRIFTWOOD_SHUTTER);
        items.add(BlockInit.RIVER_SHUTTER);
    }

    private static void registerGoodEnding(ItemGroup.Entries items) {
        items.add(BlockInit.CYPRESS_SHUTTER);
        items.add(BlockInit.MUDDY_OAK_SHUTTER);
    }


    public static void registerItemGroups() {

    }
}
