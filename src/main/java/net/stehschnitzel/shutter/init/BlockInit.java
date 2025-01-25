package net.stehschnitzel.shutter.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.stehschnitzel.shutter.ShutterMain;
import net.stehschnitzel.shutter.block.GoldShutter;
import net.stehschnitzel.shutter.block.Shutter;

public class BlockInit {

    public static final Block GLASS_SHUTTER = registerBlock("glass_shutter",
            new Shutter(FabricBlockSettings.copyOf(Blocks.GLASS).nonOpaque()));

    // Additional Fabric Block Registries
    public static final Block AZALEA_SHUTTER = registerBlock("azalea_shutter",
            new Shutter(FabricBlockSettings.copyOf(Blocks.ACACIA_DOOR)));

    public static final Block COCONUT_SHUTTER = registerBlock("coconut_shutter",
            new Shutter(FabricBlockSettings.copyOf(Blocks.ACACIA_DOOR)));

    public static final Block FLOWERING_AZALEA_SHUTTER = registerBlock("flowering_azalea_shutter",
            new Shutter(FabricBlockSettings.copyOf(Blocks.ACACIA_DOOR)));

    public static final Block WALNUT_SHUTTER = registerBlock("walnut_shutter",
            new Shutter(FabricBlockSettings.copyOf(Blocks.ACACIA_DOOR)));

//    public static final Block POISE_SHUTTER = registerBlock("poise_shutter",
//            new Shutter(FabricBlockSettings.copyOf(Blocks.ACACIA_DOOR)));

    public static final Block ACACIA_SHUTTER = registerBlock("acacia_shutter",
            new Shutter(FabricBlockSettings.copyOf(Blocks.ACACIA_DOOR)));

    public static final Block BIRCH_SHUTTER = registerBlock("birch_shutter",
            new Shutter(FabricBlockSettings.copyOf(Blocks.ACACIA_DOOR)));

    public static final Block CRIMSON_SHUTTER = registerBlock("crimson_shutter",
            new Shutter(FabricBlockSettings.copyOf(Blocks.CRIMSON_PLANKS)));

    public static final Block DARK_OAK_SHUTTER = registerBlock("dark_oak_shutter",
            new Shutter(FabricBlockSettings.copyOf(Blocks.ACACIA_DOOR)));

    public static final Block IRON_SHUTTER = registerBlock("iron_shutter",
            new Shutter(FabricBlockSettings.copyOf(Blocks.IRON_DOOR).strength(5.0F)));

    public static final Block JUNGLE_SHUTTER = registerBlock("jungle_shutter",
            new Shutter(FabricBlockSettings.copyOf(Blocks.ACACIA_DOOR)));

    public static final Block OAK_SHUTTER = registerBlock("oak_shutter",
            new Shutter(FabricBlockSettings.copyOf(Blocks.ACACIA_DOOR)));

    public static final Block SPRUCE_SHUTTER = registerBlock("spruce_shutter",
            new Shutter(FabricBlockSettings.copyOf(Blocks.ACACIA_DOOR)));

    public static final Block WARPED_SHUTTER = registerBlock("warped_shutter",
            new Shutter(FabricBlockSettings.copyOf(Blocks.WARPED_PLANKS)));

    public static final Block MANGROVE_SHUTTER = registerBlock("mangrove_shutter",
            new Shutter(FabricBlockSettings.copyOf(Blocks.ACACIA_DOOR)));

    public static final Block BAMBOO_SHUTTER = registerBlock("bamboo_shutter",
            new Shutter(FabricBlockSettings.copyOf(Blocks.BAMBOO_PLANKS)));

    public static final Block CHERRY_SHUTTER = registerBlock("cherry_shutter",
            new Shutter(FabricBlockSettings.copyOf(Blocks.CHERRY_PLANKS)));

    // Outer End Blocks
//    public static final Block AZURE_SHUTTER = registerBlock("azure_shutter",
//            new Shutter(FabricBlockSettings.copyOf(Blocks.ACACIA_DOOR)));

    // Quark Blocks
    public static final Block BLOSSOM_SHUTTER = registerBlock("blossom_shutter",
            new Shutter(FabricBlockSettings.copyOf(Blocks.ACACIA_DOOR)));

    public static final Block ANCIENT_SHUTTER = registerBlock("ancient_shutter",
            new Shutter(FabricBlockSettings.copyOf(Blocks.ACACIA_DOOR)));

    public static final Block AZALEA_QUARK_SHUTTER = registerBlock(
            "azalea_quark_shutter", new Shutter(
                    FabricBlockSettings.copy(Blocks.ACACIA_WOOD)));

    // Supplementaries Blocks
    public static final Block GOLD_SHUTTER = registerBlock("gold_shutter",
            new GoldShutter(FabricBlockSettings.copyOf(Blocks.IRON_DOOR)));

    public static final Block NETHERITE_SHUTTER = registerBlock("netherite_shutter",
            new Shutter(FabricBlockSettings.copyOf(Blocks.IRON_DOOR).strength(5.0F)));

//    public static final Block LEAD_SHUTTER = registerBlock("lead_shutter",
//            new LeadShutter(FabricBlockSettings.copyOf(Blocks.IRON_DOOR)));
//
//    public static final Block SILVER_SHUTTER = registerBlock("silver_shutter",
//            new SilverShutter(FabricBlockSettings.copyOf(Blocks.IRON_DOOR)));

    // Twigs Blocks
    public static final Block STRIPPED_BAMBOO_SHUTTER = registerBlock("stripped_bamboo_shutter",
            new Shutter(FabricBlockSettings.copyOf(Blocks.ACACIA_DOOR)));

    // Autumnity Blocks
    public static final Block MAPLE_SHUTTER = registerBlock("maple_shutter",
            new Shutter(FabricBlockSettings.copyOf(Blocks.ACACIA_DOOR)));

    // Environmental Blocks
    public static final Block CHERRY_ENV_SHUTTER = registerBlock("cherry_env_shutter",
            new Shutter(FabricBlockSettings.copyOf(Blocks.ACACIA_DOOR)));

    public static final Block WILLOW_SHUTTER = registerBlock("willow_shutter",
            new Shutter(FabricBlockSettings.copyOf(Blocks.ACACIA_DOOR)));

    public static final Block WISTERIA_SHUTTER = registerBlock("wisteria_shutter",
            new Shutter(FabricBlockSettings.copyOf(Blocks.ACACIA_DOOR)));

    // Snowy Spirit Blocks
    public static final Block GINGERBREAD_SHUTTER = registerBlock("gingerbread_shutter",
            new Shutter(FabricBlockSettings.copyOf(Blocks.ACACIA_DOOR)));

    // Update Aquatic Blocks
//    public static final Block DRIFTWOOD_SHUTTER = registerBlock("driftwood_shutter",
//            new Shutter(FabricBlockSettings.copyOf(Blocks.ACACIA_DOOR)));
//
//    public static final Block RIVER_SHUTTER = registerBlock("river_shutter",
//            new Shutter(FabricBlockSettings.copyOf(Blocks.ACACIA_DOOR)));


    //goodending
    public static final Block CYPRESS_SHUTTER = registerBlock(
            "cypress_shutter", new Shutter(
                    FabricBlockSettings.copy(Blocks.ACACIA_WOOD)));

    public static final Block MUDDY_OAK_SHUTTER = registerBlock(
            "muddy_oak_shutter", new Shutter(
                    FabricBlockSettings.copy(Blocks.ACACIA_WOOD)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(ShutterMain.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(ShutterMain.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }


    public static void registerModBlocks() {

    }

}
