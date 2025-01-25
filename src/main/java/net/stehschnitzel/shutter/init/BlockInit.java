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
import net.stehschnitzel.shutter.block.*;

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

    // Additional Fabric Block Registries
    public static final Block AZALEA_SHUTTER = registerBlock(
            "azalea_shutter",
            AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR));

    public static final Block COCONUT_SHUTTER = registerBlock(
            "coconut_shutter",
            AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR));

    public static final Block FLOWERING_AZALEA_SHUTTER = registerBlock(
            "flowering_azalea_shutter",
            AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR));

    public static final Block WALNUT_SHUTTER = registerBlock(
            "walnut_shutter",
            AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR));

    public static final Block POISE_SHUTTER = registerBlock(
    "poise_shutter",
            AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR));

    public static final Block ACACIA_SHUTTER = registerBlock(
            "acacia_shutter",
            AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR));

    public static final Block BIRCH_SHUTTER = registerBlock(
            "birch_shutter",
            AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR));

    public static final Block CRIMSON_SHUTTER = registerBlock(
            "crimson_shutter",
            AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS));

    public static final Block DARK_OAK_SHUTTER = registerBlock(
            "dark_oak_shutter",
            AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR));

    public static final Block IRON_SHUTTER = registerBlock(
            "iron_shutter",
            settings -> new Shutter(settings,true),
            AbstractBlock.Settings.copy(Blocks.IRON_DOOR).strength(5.0F));

    public static final Block JUNGLE_SHUTTER = registerBlock(
            "jungle_shutter",
            AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR));

    public static final Block OAK_SHUTTER = registerBlock(
            "oak_shutter",
            AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR));

    public static final Block SPRUCE_SHUTTER = registerBlock(
            "spruce_shutter",
            AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR));

    public static final Block WARPED_SHUTTER = registerBlock(
            "warped_shutter",
            AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS));

    public static final Block MANGROVE_SHUTTER = registerBlock(
            "mangrove_shutter",
            AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR));

    public static final Block BAMBOO_SHUTTER = registerBlock(
            "bamboo_shutter",
            AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS));

    public static final Block CHERRY_SHUTTER = registerBlock(
            "cherry_shutter",
            AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS));

    public static final Block GLASS_SHUTTER = registerBlock(
            "glass_shutter",
            AbstractBlock.Settings.copy(Blocks.GLASS).nonOpaque());

    public static final Block COPPER_SHUTTER = registerBlock(
            "copper_shutter",
            settings -> new WeatheringCopperShutter(Oxidizable.OxidationLevel.UNAFFECTED, settings),
            AbstractBlock.Settings.copy(Blocks.COPPER_DOOR));

    public static final Block EXPOSED_COPPER_SHUTTER = registerBlock(
            "exposed_copper_shutter",
            settings -> new WeatheringCopperShutter(Oxidizable.OxidationLevel.EXPOSED, settings),
            AbstractBlock.Settings.copy(Blocks.EXPOSED_COPPER_DOOR));

    public static final Block OXIDIZED_COPPER_SHUTTER = registerBlock(
            "oxidized_copper_shutter",
            settings -> new WeatheringCopperShutter(Oxidizable.OxidationLevel.OXIDIZED, settings),
            AbstractBlock.Settings.copy(Blocks.OXIDIZED_COPPER_DOOR));

    public static final Block WEATHERED_COPPER_SHUTTER = registerBlock(
            "weathered_copper_shutter",
            settings -> new WeatheringCopperShutter(Oxidizable.OxidationLevel.WEATHERED, settings),
            AbstractBlock.Settings.copy(Blocks.WEATHERED_COPPER_DOOR));

    public static final Block WAXED_COPPER_SHUTTER = registerBlock(
            "waxed_copper_shutter",
            settings -> new WeatheringCopperShutter(Oxidizable.OxidationLevel.UNAFFECTED, settings),
            AbstractBlock.Settings.copy(Blocks.COPPER_DOOR));

    public static final Block WAXED_EXPOSED_COPPER_SHUTTER = registerBlock(
            "waxed_exposed_copper_shutter",
            settings -> new WeatheringCopperShutter(Oxidizable.OxidationLevel.EXPOSED, settings),
            AbstractBlock.Settings.copy(Blocks.EXPOSED_COPPER_DOOR));

    public static final Block WAXED_OXIDIZED_COPPER_SHUTTER = registerBlock(
            "waxed_oxidized_copper_shutter",
            settings -> new WeatheringCopperShutter(Oxidizable.OxidationLevel.OXIDIZED, settings),
            AbstractBlock.Settings.copy(Blocks.OXIDIZED_COPPER_DOOR));

    public static final Block WAXED_WEATHERED_COPPER_SHUTTER = registerBlock(
            "waxed_weathered_copper_shutter",
            settings -> new WeatheringCopperShutter(Oxidizable.OxidationLevel.WEATHERED, settings),
            AbstractBlock.Settings.copy(Blocks.WEATHERED_COPPER_DOOR));


    // Outer End Blocks
    public static final Block AZURE_SHUTTER = registerBlock("azure_shutter",
            AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR));

    // Quark Blocks
    public static final Block BLOSSOM_SHUTTER = registerBlock(
            "blossom_shutter",
            AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR));

    public static final Block ANCIENT_SHUTTER = registerBlock(
            "ancient_shutter",
            AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR));

    public static final Block AZALEA_QUARK_SHUTTER = registerBlock(
            "azalea_quark_shutter",
            AbstractBlock.Settings.copy(Blocks.ACACIA_WOOD));

    // Supplementaries Blocks
    public static final Block GOLD_SHUTTER = registerBlock(
            "gold_shutter",
            GoldShutter::new,
            AbstractBlock.Settings.copy(Blocks.IRON_DOOR));

    public static final Block NETHERITE_SHUTTER = registerBlock(
            "netherite_shutter",
            settings -> new Shutter(settings, true),
            AbstractBlock.Settings.copy(Blocks.IRON_DOOR).strength(5.0F));

    //oreganized
    public static final Block LEAD_SHUTTER = registerBlock(
            "lead_shutter",
            LeadShutter::new,
            AbstractBlock.Settings.copy(Blocks.IRON_DOOR));

    public static final Block SILVER_SHUTTER = registerBlock(
            "silver_shutter",
            SilverShutter::new,
            (AbstractBlock.Settings.copy(Blocks.IRON_DOOR)));

    // Twigs Blocks
    public static final Block STRIPPED_BAMBOO_SHUTTER = registerBlock(
            "stripped_bamboo_shutter",
            AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR));

    // Autumnity Blocks
    public static final Block MAPLE_SHUTTER = registerBlock(
            "maple_shutter",
            AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR));

    // Environmental Blocks
    public static final Block CHERRY_ENV_SHUTTER = registerBlock(
            "cherry_env_shutter",
            AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR));

    public static final Block WILLOW_SHUTTER = registerBlock(
            "willow_shutter",
            AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR));

    public static final Block WISTERIA_SHUTTER = registerBlock(
            "wisteria_shutter",
            AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR));

    // Snowy Spirit Blocks
    public static final Block GINGERBREAD_SHUTTER = registerBlock(
            "gingerbread_shutter",
            AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR));

    // Update Aquatic Blocks
    public static final Block DRIFTWOOD_SHUTTER = registerBlock("driftwood_shutter",
            AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR));

    public static final Block RIVER_SHUTTER = registerBlock("river_shutter",
            AbstractBlock.Settings.copy(Blocks.ACACIA_DOOR));


    //goodending
    public static final Block CYPRESS_SHUTTER = registerBlock(
            "cypress_shutter",
            AbstractBlock.Settings.copy(Blocks.ACACIA_WOOD));

    public static final Block MUDDY_OAK_SHUTTER = registerBlock(
            "muddy_oak_shutter",
            AbstractBlock.Settings.copy(Blocks.ACACIA_WOOD));

    private static RegistryKey<Block> keyOfShutter(String id) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ShutterMain.MOD_ID, id));
    }

    private static Block registerBlock(String id, AbstractBlock.Settings settings) {
        return registerBlock(id, Shutter::new, settings);
    }

    private static Block registerBlock(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = (Block)factory.apply(settings.registryKey(keyOfShutter(id)));
        registerBlockItem(id, block);
        return Registry.register(Registries.BLOCK, keyOfShutter(id), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(ShutterMain.MOD_ID, name),
                new BlockItem(block, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ShutterMain.MOD_ID, name)))));
    }


    public static void registerModBlocks() {
        ShutterMain.LOGGER.info("Registering Mod Blocks for " + ShutterMain.MOD_ID);
    }

}
