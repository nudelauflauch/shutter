package net.stehschnitzel.shutter.init;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.stehschnitzel.shutter.ShutterMain;
import net.stehschnitzel.shutter.block.GoldShutter;
import net.stehschnitzel.shutter.block.InteractionShutter;
import net.stehschnitzel.shutter.block.Shutter;
import net.stehschnitzel.shutter.block.WeatheringCopperShutter;

import java.util.function.Function;
import java.util.function.Supplier;

public class BlockInit {

    public static final Block INTERACTION_SHUTTER_WOOD = registerBlockWithoutItem("interaction_shutter_wood",
            InteractionShutter::new, () -> (BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_WOOD).noLootTable().replaceable().noCollision()));

    public static final Block INTERACTION_SHUTTER_CRIMSON = registerBlockWithoutItem("interaction_shutter_crimson",
            InteractionShutter::new, () -> (BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_DOOR).noLootTable().replaceable().noCollision()));

    public static final Block INTERACTION_SHUTTER_IRON = registerBlockWithoutItem("interaction_shutter_iron",
            InteractionShutter::new, () -> (BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR).noLootTable().replaceable().noCollision()));

    public static final Block INTERACTION_SHUTTER_WARPED = registerBlockWithoutItem("interaction_shutter_warped",
            InteractionShutter::new, () -> (BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_DOOR).noLootTable().replaceable().noCollision()));

    public static final Block INTERACTION_SHUTTER_COPPER = registerBlockWithoutItem("interaction_shutter_copper",
            InteractionShutter::new, () -> (BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK).noLootTable().replaceable().noCollision()));

    public static final Block INTERACTION_SHUTTER_NETHERITE = registerBlockWithoutItem("interaction_shutter_netherite",
            InteractionShutter::new, () -> (BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK).noLootTable().replaceable().noCollision()));

    public static final Block INTERACTION_SHUTTER_GLASS = registerBlockWithoutItem("interaction_shutter_glass",
            InteractionShutter::new, () -> (BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noLootTable().replaceable().noCollision()));


    // ecologics
    public static final Block AZALEA_SHUTTER = registerWoodenShutter("azalea_shutter");

    public static final Block COCONUT_SHUTTER = registerWoodenShutter("coconut_shutter");

    public static final Block FLOWERING_AZALEA_SHUTTER = registerWoodenShutter("flowering_azalea_shutter");

    public static final Block WALNUT_SHUTTER = registerWoodenShutter("walnut_shutter");

    //minecraft
    public static final Block ACACIA_SHUTTER = registerWoodenShutter("acacia_shutter");

    public static final Block BIRCH_SHUTTER = registerWoodenShutter("birch_shutter");

    public static final Block CRIMSON_SHUTTER = registerWoodenShutter("crimson_shutter");

    public static final Block DARK_OAK_SHUTTER = registerWoodenShutter("dark_oak_shutter");

    public static final Block IRON_SHUTTER = registerBlock("iron_shutter",
            Shutter::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR), false);

    public static final Block JUNGLE_SHUTTER = registerWoodenShutter("jungle_shutter");

    public static final Block OAK_SHUTTER = registerWoodenShutter("oak_shutter");

    public static final Block SPRUCE_SHUTTER = registerWoodenShutter("spruce_shutter");

    public static final Block WARPED_SHUTTER = registerWoodenShutter("warped_shutter");

    public static final Block MANGROVE_SHUTTER = registerWoodenShutter("mangrove_shutter");

    public static final Block BAMBOO_SHUTTER = registerWoodenShutter("bamboo_shutter");

    public static final Block CHERRY_SHUTTER = registerWoodenShutter("cherry_shutter");

    public static final Block PALE_OAK_SHUTTER = registerWoodenShutter("pale_oak_shutter");

    public static final Block COPPER_SHUTTER = registerBlock(
            "copper_shutter", properties -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.UNAFFECTED, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_DOOR), false);

    public static final Block EXPOSED_COPPER_SHUTTER = registerBlock(
            "exposed_copper_shutter", properties -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.EXPOSED, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.EXPOSED_COPPER_DOOR), false);

    public static final Block OXIDIZED_COPPER_SHUTTER = registerBlock(
            "oxidized_copper_shutter", properties -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.OXIDIZED, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OXIDIZED_COPPER_DOOR), false);

    public static final Block WEATHERED_COPPER_SHUTTER = registerBlock(
            "weathered_copper_shutter", properties -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.WEATHERED, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WEATHERED_COPPER_DOOR), false);

    public static final Block WAXED_COPPER_SHUTTER = registerBlock(
            "waxed_copper_shutter",properties -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.UNAFFECTED,
                    properties), () -> BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_DOOR), false);

    public static final Block WAXED_EXPOSED_COPPER_SHUTTER = registerBlock(
            "waxed_exposed_copper_shutter", properties -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.EXPOSED, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.EXPOSED_COPPER_DOOR), false);

    public static final Block WAXED_OXIDIZED_COPPER_SHUTTER = registerBlock(
            "waxed_oxidized_copper_shutter", properties -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.OXIDIZED, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.OXIDIZED_COPPER_DOOR), false);

    public static final Block WAXED_WEATHERED_COPPER_SHUTTER = registerBlock(
            "waxed_weathered_copper_shutter", properties -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.WEATHERED, properties),
            () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WEATHERED_COPPER_DOOR), false);

    //mc but not really
    public static final Block GOLD_SHUTTER = registerBlock("gold_shutter",
            GoldShutter::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK), false);

    public static final Block GLASS_SHUTTER = registerBlock("glass_shutter",
            Shutter::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS), false);

    public static final Block NETHERITE_SHUTTER = registerBlock("netherite_shutter",
            GoldShutter::new, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK), false);

    // Twigs Blocks
    public static final Block STRIPPED_BAMBOO_SHUTTER = registerWoodenShutter("stripped_bamboo_shutter");

    // Snowy Spirit
    public static final Block GINGERBREAD_SHUTTER = registerWoodenShutter("gingerbread_shutter");

    //goodending
    public static final Block CYPRESS_SHUTTER = registerWoodenShutter("cypress_shutter");

    public static final Block MUDDY_OAK_SHUTTER = registerWoodenShutter("muddy_oak_shutter");

    //beachparty
    public static final Block PALM_SHUTTER = registerWoodenShutter("palm_shutter");

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


    // Wooden shutter
    private static Shutter registerWoodenShutter(String name) {
        return registerBlock(
                name,
                Shutter::new,
                () -> BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_WOOD)
        );
    }

    // Register block with item (burnable by default)
    private static <T extends Block> T registerBlock(
            String name,
            Function<BlockBehaviour.Properties, T> factory,
            Supplier<BlockBehaviour.Properties> properties) {

        return registerBlock(name, factory, properties, true);
    }

    // Register block with configurable burnability
    private static <T extends Block> T registerBlock(
            String name,
            Function<BlockBehaviour.Properties, T> factory,
            Supplier<BlockBehaviour.Properties> properties,
            boolean burnAble) {

        T registeredBlock =
                registerBlockWithoutItem(name, factory, properties);

        registerBlockItem(name, registeredBlock, burnAble);

        return registeredBlock;
    }

    // Register block without item
    private static <T extends Block> T registerBlockWithoutItem(
            String name,
            Function<BlockBehaviour.Properties, T> factory,
            Supplier<BlockBehaviour.Properties> properties) {

        ResourceKey<Block> blockKey = ResourceKey.create(
                Registries.BLOCK,
                Identifier.fromNamespaceAndPath(ShutterMain.MOD_ID, name)
        );

        T block = factory.apply(properties.get().setId(blockKey));

        return Registry.register(
                BuiltInRegistries.BLOCK,
                blockKey,
                block
        );
    }

    // Register block item
    private static <T extends Block> void registerBlockItem(
            String name,
            T registeredBlock,
            boolean burnAble) {

        ResourceKey<Item> itemKey = ResourceKey.create(
                Registries.ITEM,
                Identifier.fromNamespaceAndPath(ShutterMain.MOD_ID, name)
        );

        BlockItem blockItem = new BlockItem(
                registeredBlock,
                new Item.Properties()
                        .setId(itemKey)
                        .useBlockDescriptionPrefix()
        );

        Registry.register(
                BuiltInRegistries.ITEM,
                itemKey,
                blockItem
        );

        if (burnAble) {
            FuelRegistryEvents.BUILD.register(
                    (builder, context) -> builder.add(blockItem, 300)
            );
        }
    }



    public static void registerModBlocks() {

    }

}
