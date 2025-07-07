package net.stehschnitzel.shutter.init;

import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Oxidizable;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.stehschnitzel.shutter.ShutterMain;
import net.stehschnitzel.shutter.block.GoldShutter;
import net.stehschnitzel.shutter.block.Shutter;
import net.stehschnitzel.shutter.block.WeatheringCopperShutter;

import java.util.function.Function;

public class BlockInit {
    public static void registerOxidizables() {
        OxidizableBlocksRegistry.registerOxidizableBlockPair(BlockInit.COPPER_SHUTTER, BlockInit.EXPOSED_COPPER_SHUTTER);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(BlockInit.EXPOSED_COPPER_SHUTTER, BlockInit.WEATHERED_COPPER_SHUTTER);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(BlockInit.WEATHERED_COPPER_SHUTTER, BlockInit.OXIDIZED_COPPER_SHUTTER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(BlockInit.COPPER_SHUTTER, BlockInit.WAXED_COPPER_SHUTTER);

        OxidizableBlocksRegistry.registerWaxableBlockPair(BlockInit.WEATHERED_COPPER_SHUTTER, BlockInit.WAXED_WEATHERED_COPPER_SHUTTER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(BlockInit.EXPOSED_COPPER_SHUTTER, BlockInit.WAXED_EXPOSED_COPPER_SHUTTER);
        OxidizableBlocksRegistry.registerWaxableBlockPair(BlockInit.OXIDIZED_COPPER_SHUTTER, BlockInit.WAXED_OXIDIZED_COPPER_SHUTTER);
    }

    // ecologics
    public static final Block AZALEA_SHUTTER = registerBlock("azalea_shutter", 
            Blocks.ACACIA_DOOR, Shutter::new);

    public static final Block COCONUT_SHUTTER = registerBlock("coconut_shutter",
            AZALEA_SHUTTER, Shutter::new);

    public static final Block FLOWERING_AZALEA_SHUTTER = registerBlock("flowering_azalea_shutter",
            AZALEA_SHUTTER, Shutter::new);

    public static final Block WALNUT_SHUTTER = registerBlock("walnut_shutter",
            AZALEA_SHUTTER, Shutter::new);

    //minecraft
    public static final Block ACACIA_SHUTTER = registerBlock("acacia_shutter",
            AZALEA_SHUTTER, Shutter::new);

    public static final Block BIRCH_SHUTTER = registerBlock("birch_shutter",
            AZALEA_SHUTTER, Shutter::new);

    public static final Block CRIMSON_SHUTTER = registerBlock("crimson_shutter",
            Blocks.CRIMSON_PLANKS, Shutter::new);

    public static final Block DARK_OAK_SHUTTER = registerBlock("dark_oak_shutter",
            AZALEA_SHUTTER, Shutter::new);

    public static final Block IRON_SHUTTER = registerBlock("iron_shutter",
            Blocks.IRON_DOOR, properties -> new Shutter(properties.strength(5.0F), true));

    public static final Block JUNGLE_SHUTTER = registerBlock("jungle_shutter",
            AZALEA_SHUTTER, Shutter::new);

    public static final Block OAK_SHUTTER = registerBlock("oak_shutter",
            AZALEA_SHUTTER, Shutter::new);

    public static final Block SPRUCE_SHUTTER = registerBlock("spruce_shutter",
            AZALEA_SHUTTER, Shutter::new);

    public static final Block WARPED_SHUTTER = registerBlock("warped_shutter",
            Blocks.WARPED_PLANKS, Shutter::new);

    public static final Block MANGROVE_SHUTTER = registerBlock("mangrove_shutter",
            AZALEA_SHUTTER, Shutter::new);

    public static final Block BAMBOO_SHUTTER = registerBlock("bamboo_shutter",
            Blocks.BAMBOO_PLANKS, Shutter::new);

    public static final Block CHERRY_SHUTTER = registerBlock("cherry_shutter",
            Blocks.CHERRY_PLANKS, Shutter::new);

    public static final Block COPPER_SHUTTER = registerBlock(
            "copper_shutter", Blocks.COPPER_BLOCK,
            properties -> new WeatheringCopperShutter(Oxidizable.OxidationLevel.UNAFFECTED, properties));

    public static final Block EXPOSED_COPPER_SHUTTER = registerBlock(
            "exposed_copper_shutter", Blocks.EXPOSED_COPPER,
            properties -> new WeatheringCopperShutter(Oxidizable.OxidationLevel.EXPOSED, properties));

    public static final Block OXIDIZED_COPPER_SHUTTER = registerBlock(
            "oxidized_copper_shutter", Blocks.OXIDIZED_COPPER,
            properties -> new WeatheringCopperShutter(Oxidizable.OxidationLevel.OXIDIZED, properties));

    public static final Block WEATHERED_COPPER_SHUTTER = registerBlock(
            "weathered_copper_shutter", Blocks.WEATHERED_COPPER,
            properties -> new WeatheringCopperShutter(Oxidizable.OxidationLevel.WEATHERED, properties));

    public static final Block WAXED_COPPER_SHUTTER = registerBlock(
            "waxed_copper_shutter", Blocks.COPPER_BLOCK,
            properties -> new WeatheringCopperShutter(Oxidizable.OxidationLevel.UNAFFECTED, properties));

    public static final Block WAXED_EXPOSED_COPPER_SHUTTER = registerBlock(
            "waxed_exposed_copper_shutter", Blocks.EXPOSED_COPPER,
            properties -> new WeatheringCopperShutter(Oxidizable.OxidationLevel.EXPOSED, properties));

    public static final Block WAXED_OXIDIZED_COPPER_SHUTTER = registerBlock(
            "waxed_oxidized_copper_shutter", Blocks.OXIDIZED_COPPER,
            properties -> new WeatheringCopperShutter(Oxidizable.OxidationLevel.OXIDIZED, properties));

    public static final Block WAXED_WEATHERED_COPPER_SHUTTER = registerBlock(
            "waxed_weathered_copper_shutter", Blocks.WEATHERED_COPPER,
            properties -> new WeatheringCopperShutter(Oxidizable.OxidationLevel.WEATHERED, properties));

    //mc but not really
    public static final Block GOLD_SHUTTER = registerBlock("gold_shutter",
            Blocks.IRON_DOOR, GoldShutter::new);

    public static final Block GLASS_SHUTTER = registerBlock("glass_shutter", Blocks.GLASS,
            properties -> new Shutter(properties.nonOpaque()));

    public static final Block NETHERITE_SHUTTER = registerBlock("netherite_shutter",
            Blocks.IRON_DOOR, properties -> new Shutter(properties.strength(5.0F)));

    // Twigs Blocks
    public static final Block STRIPPED_BAMBOO_SHUTTER = registerBlock("stripped_bamboo_shutter",
            AZALEA_SHUTTER, Shutter::new);

    // Snowy Spirit
    public static final Block GINGERBREAD_SHUTTER = registerBlock("gingerbread_shutter",
            AZALEA_SHUTTER, Shutter::new);

    //goodending
    public static final Block CYPRESS_SHUTTER = registerBlock("cypress_shutter",
            AZALEA_SHUTTER, Shutter::new);

    public static final Block MUDDY_OAK_SHUTTER = registerBlock("muddy_oak_shutter",
            AZALEA_SHUTTER, Shutter::new);

    //beachparty
    public static final Block PALM_SHUTTER = registerBlock("palm_shutter",
            AZALEA_SHUTTER, Shutter::new);

    //endergetic
//    public static final Block POISE_SHUTTER = registerBlock("poise_shutter",
//            AZALEA_SHUTTER, Shutter::new);

    // Outer End Blocks
//    public static final Block AZURE_SHUTTER = registerBlock("azure_shutter",
//            AZALEA_SHUTTER, Shutter::new);

    // Quark Blocks
//    public static final Block BLOSSOM_SHUTTER = registerBlock("blossom_shutter",
//            AZALEA_SHUTTER, Shutter::new);
//
//    public static final Block ANCIENT_SHUTTER = registerBlock("ancient_shutter",
//            AZALEA_SHUTTER, Shutter::new);
//
//    public static final Block AZALEA_QUARK_SHUTTER = registerBlock(
//            "azalea_quark_shutter", new Shutter(
//                    FabricBlockSettings.copy(Blocks.ACACIA_WOOD)));

    // Supplementaries
//    public static final Block LEAD_SHUTTER = registerBlock("lead_shutter",
//            new LeadShutter(FabricBlockSettings.copyOf(Blocks.IRON_DOOR)));
//
//    public static final Block SILVER_SHUTTER = registerBlock("silver_shutter",
//            new SilverShutter(FabricBlockSettings.copyOf(Blocks.IRON_DOOR)));

    // Autumnity Blocks
//    public static final Block MAPLE_SHUTTER = registerBlock("maple_shutter",
//            AZALEA_SHUTTER, Shutter::new);

    // Environmental Blocks
//    public static final Block CHERRY_ENV_SHUTTER = registerBlock("cherry_env_shutter",
//            AZALEA_SHUTTER, Shutter::new);
//
//    public static final Block WILLOW_SHUTTER = registerBlock("willow_shutter",
//            AZALEA_SHUTTER, Shutter::new);
//
//    public static final Block WISTERIA_SHUTTER = registerBlock("wisteria_shutter",
//            AZALEA_SHUTTER, Shutter::new);

    // Update Aquatic Blocks
//    public static final Block DRIFTWOOD_SHUTTER = registerBlock("driftwood_shutter",
//            AZALEA_SHUTTER, Shutter::new);
//
//    public static final Block RIVER_SHUTTER = registerBlock("river_shutter",
//            AZALEA_SHUTTER, Shutter::new);

    private static Block registerBlock(String name, Block copiedBlock, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.copy(copiedBlock).registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                Identifier.of(ShutterMain.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(ShutterMain.MOD_ID, name), toRegister);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(ShutterMain.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ShutterMain.MOD_ID, name)))));
    }


    public static void registerModBlocks() {

    }

}
