package net.stehschnitzel.shutter.init;

import com.google.common.base.Supplier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.stehschnitzel.shutter.ShutterMain;
import net.stehschnitzel.shutter.common.blocks.*;
import net.stehschnitzel.shutter.common.items.BurnableItem;

public class BlockInit {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister
			.create(ForgeRegistries.BLOCKS, ShutterMain.MODID);

	public static final DeferredRegister<Item> MINECRAFT_ITEMS = DeferredRegister
			.create(ForgeRegistries.ITEMS, ShutterMain.MODID);

    //interaction shutters
    public static final RegistryObject<Block> INTERACTION_SHUTTER_WOOD = registerBlockWithoutItem("interaction_shutter_wood", () -> new InteractionShutter(
            BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD).noLootTable().replaceable().noCollission()));

    public static final RegistryObject<Block> INTERACTION_SHUTTER_CRIMSON = registerBlockWithoutItem(
            "interaction_shutter_crimson", () -> new InteractionShutter(
            BlockBehaviour.Properties.copy(Blocks.CRIMSON_DOOR).noLootTable().replaceable().noCollission()));

    public static final RegistryObject<Block> INTERACTION_SHUTTER_IRON = registerBlockWithoutItem("interaction_shutter_iron", () -> new InteractionShutter(
            BlockBehaviour.Properties.copy(Blocks.IRON_DOOR).noLootTable().replaceable().noCollission()));

    public static final RegistryObject<Block> INTERACTION_SHUTTER_WARPED = registerBlockWithoutItem("interaction_shutter_warped", () -> new InteractionShutter(
            BlockBehaviour.Properties.copy(Blocks.WARPED_DOOR).noLootTable().replaceable().noCollission()));

    public static final RegistryObject<Block> INTERACTION_SHUTTER_COPPER = registerBlockWithoutItem("interaction_shutter_copper", () -> new InteractionShutter(
            BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK).noLootTable().replaceable().noCollission()));

    public static final RegistryObject<Block> INTERACTION_SHUTTER_NETHERITE = registerBlockWithoutItem("interaction_shutter_netherite", () -> new InteractionShutter(
            BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).noLootTable().replaceable().noCollission()));

    public static final RegistryObject<Block> INTERACTION_SHUTTER_GLASS = registerBlockWithoutItem("interaction_shutter_glass", () -> new InteractionShutter(
            BlockBehaviour.Properties.copy(Blocks.GLASS).noLootTable().replaceable().noCollission()));



    // minecraft
    public static final RegistryObject<Shutter> ACACIA_SHUTTER = registerWoodenShutter(
            "acacia_shutter");


    public static final RegistryObject<Shutter> BIRCH_SHUTTER = registerWoodenShutter(
            "birch_shutter");


    public static final RegistryObject<Shutter> CRIMSON_SHUTTER = registerBlock(
            "crimson_shutter",
            () -> new Shutter(
                    BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)), false);

    public static final RegistryObject<Shutter> DARK_OAK_SHUTTER = registerWoodenShutter(
            "dark_oak_shutter");


    public static final RegistryObject<Shutter> IRON_SHUTTER = registerBlock(
            "iron_shutter", () -> new Shutter(
                    BlockBehaviour.Properties.copy(Blocks.IRON_DOOR), true), false);

    public static final RegistryObject<Shutter> JUNGLE_SHUTTER = registerWoodenShutter(
            "jungle_shutter");


    public static final RegistryObject<Shutter> OAK_SHUTTER = registerWoodenShutter(
            "oak_shutter");


    public static final RegistryObject<Shutter> SPRUCE_SHUTTER = registerWoodenShutter(
            "spruce_shutter");


    public static final RegistryObject<Shutter> WARPED_SHUTTER = registerBlock(
            "warped_shutter", () -> new Shutter(
                    BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)), false);

    public static final RegistryObject<Shutter> MANGROVE_SHUTTER = registerWoodenShutter(
            "mangrove_shutter");

    public static final RegistryObject<Shutter> BAMBOO_SHUTTER = registerBlock(
            "bamboo_shutter", () -> new Shutter(
                    BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS)));

    public static final RegistryObject<Shutter> CHERRY_SHUTTER = registerBlock(
            "cherry_shutter", () -> new Shutter(
                    BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)));

    public static final RegistryObject<Shutter> COPPER_SHUTTER = registerBlock(
            "copper_shutter", () -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.UNAFFECTED,
                    BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)));

    public static final RegistryObject<Shutter> EXPOSED_COPPER_SHUTTER = registerBlock(
            "exposed_copper_shutter", () -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.EXPOSED,
                    BlockBehaviour.Properties.copy(Blocks.EXPOSED_COPPER)));

    public static final RegistryObject<Shutter> OXIDIZED_COPPER_SHUTTER = registerBlock(
            "oxidized_copper_shutter", () -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.OXIDIZED,
                    BlockBehaviour.Properties.copy(Blocks.OXIDIZED_COPPER)));

    public static final RegistryObject<Shutter> WEATHERED_COPPER_SHUTTER = registerBlock(
            "weathered_copper_shutter", () -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.WEATHERED,
                    BlockBehaviour.Properties.copy(Blocks.WEATHERED_COPPER)));

    public static final RegistryObject<Shutter> WAXED_COPPER_SHUTTER = registerBlock(
            "waxed_copper_shutter", () -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.UNAFFECTED,
                    BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)));

    public static final RegistryObject<Shutter> WAXED_EXPOSED_COPPER_SHUTTER = registerBlock(
            "waxed_exposed_copper_shutter", () -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.EXPOSED,
                    BlockBehaviour.Properties.copy(Blocks.EXPOSED_COPPER)));

    public static final RegistryObject<Shutter> WAXED_OXIDIZED_COPPER_SHUTTER = registerBlock(
            "waxed_oxidized_copper_shutter", () -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.OXIDIZED,
                    BlockBehaviour.Properties.copy(Blocks.OXIDIZED_COPPER)));

    public static final RegistryObject<Shutter> WAXED_WEATHERED_COPPER_SHUTTER = registerBlock(
            "waxed_weathered_copper_shutter", () -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.WEATHERED,
                    BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)));


    //mc but not really
    public static final RegistryObject<Shutter> GOLD_SHUTTER = registerBlock(
            "gold_shutter", () -> new GoldShutter(
                    BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)), false);

    public static final RegistryObject<Shutter> NETHERITE_SHUTTER = registerBlock(
            "netherite_shutter", () -> new GoldShutter(
                    BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)), false);

    public static final RegistryObject<Shutter> GLASS_SHUTTER = registerBlock(
            "glass_shutter", () -> new Shutter(
                    BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()),
            false);

    //beachparty
    public static final RegistryObject<Shutter> PALM_SHUTTER = registerWoodenShutter(
            "palm_shutter");


    //autumnity
    public static final RegistryObject<Shutter> MAPLE_SHUTTER = registerWoodenShutter(
            "maple_shutter");


    //Caverns & Chasms
    public static final RegistryObject<Shutter> CAVERN_AZALEA_SHUTTER = registerWoodenShutter(
            "cavern_azalea_shutter");


    // ecologics
    public static final RegistryObject<Shutter> AZALEA_SHUTTER = registerWoodenShutter(
            "azalea_shutter");


    public static final RegistryObject<Shutter> COCONUT_SHUTTER = registerWoodenShutter(
            "coconut_shutter");


    public static final RegistryObject<Shutter> FLOWERING_AZALEA_SHUTTER = registerWoodenShutter(
            "flowering_azalea_shutter");


    public static final RegistryObject<Shutter> WALNUT_SHUTTER = registerWoodenShutter(
            "walnut_shutter");


    //environmental
    public static final RegistryObject<Shutter> PLUM_SHUTTER = registerWoodenShutter(
            "plum_shutter");


    public static final RegistryObject<Shutter> WILLOW_SHUTTER = registerWoodenShutter(
            "willow_shutter");


    public static final RegistryObject<Shutter> WISTERIA_SHUTTER = registerWoodenShutter(
            "wisteria_shutter");


    public static final RegistryObject<Shutter> PINE_SHUTTER = registerWoodenShutter(
            "pine_shutter");


    //goodending 1.20.1 forge and fabric
    public static final RegistryObject<Shutter> CYPRESS_SHUTTER = registerWoodenShutter(
            "cypress_shutter");


    public static final RegistryObject<Shutter> MUDDY_OAK_SHUTTER = registerWoodenShutter(
            "muddy_oak_shutter");


    // Oreganized 1.20.1 forge only
//    public static final RegistryObject<Shutter> LEAD_SHUTTER = registerBlock(
//            "lead_shutter", () -> new LeadShutter(
//                    BlockBehaviour.Properties.copy(Blocks.IRON_DOOR)), false);
//
//    public static final RegistryObject<Shutter> SILVER_SHUTTER = registerBlock(
//            "silver_shutter", () -> new SilverShutter(
//                    BlockBehaviour.Properties.copy(Blocks.IRON_DOOR)), false);

    // quark
    public static final RegistryObject<Shutter> BLOSSOM_SHUTTER = registerWoodenShutter(
            "blossom_shutter");


    public static final RegistryObject<Shutter> ANCIENT_SHUTTER = registerWoodenShutter(
            "ancient_shutter");


    public static final RegistryObject<Shutter> AZALEA_QUARK_SHUTTER = registerWoodenShutter(
            "azalea_quark_shutter");


    //snowy spirit
    public static final RegistryObject<Shutter> GINGERBREAD_SHUTTER = registerWoodenShutter(
            "gingerbread_shutter");


    // endergetic
    public static final RegistryObject<Shutter> POISE_SHUTTER = registerWoodenShutter(
            "poise_shutter");


    // outer_end
    public static final RegistryObject<Shutter> AZURE_SHUTTER = registerWoodenShutter(
            "azure_shutter");


    // twigs
    public static final RegistryObject<Shutter> STRIPPED_BAMBOO_SHUTTER = registerWoodenShutter(
            "stripped_bamboo_shutter");


    //update aquatic
    public static final RegistryObject<Shutter> DRIFTWOOD_SHUTTER = registerWoodenShutter(
            "driftwood_shutter");

    public static final RegistryObject<Shutter> RIVER_SHUTTER = registerWoodenShutter(
            "river_shutter");

    //nature spirit
    public static final RegistryObject<Shutter> ASPEN_SHUTTER = registerWoodenShutter(
            "aspen_shutter");

    public static final RegistryObject<Shutter> BLOOMING_PAPER_SHUTTER = registerWoodenShutter(
            "blooming_paper_shutter");

    public static final RegistryObject<Shutter> CEDAR_SHUTTER = registerWoodenShutter(
            "cedar_shutter");

    public static final RegistryObject<Shutter> FIR_SHUTTER = registerWoodenShutter(
            "fir_shutter");

    public static final RegistryObject<Shutter> FRAMED_PAPER_SHUTTER = registerWoodenShutter(
            "framed_paper_shutter");

    public static final RegistryObject<Shutter> GHAF_SHUTTER = registerWoodenShutter(
            "ghaf_shutter");

    public static final RegistryObject<Shutter> JOSHUA_SHUTTER = registerWoodenShutter(
            "joshua_shutter");

    public static final RegistryObject<Shutter> LARCH_SHUTTER = registerWoodenShutter(
            "larch_shutter");

    public static final RegistryObject<Shutter> MAHOGANY_SHUTTER = registerWoodenShutter(
            "mahogany_shutter");

    public static final RegistryObject<Shutter> NAS_COCONUT_SHUTTER = registerWoodenShutter(
            "nas_coconut_shutter");

    public static final RegistryObject<Shutter> NAS_CYPRESS_SHUTTER = registerWoodenShutter(
            "nas_cypress_shutter");

    public static final RegistryObject<Shutter> NAS_MAPLE_SHUTTER = registerWoodenShutter(
            "nas_maple_shutter");

    public static final RegistryObject<Shutter> NAS_WILLOW_SHUTTER = registerWoodenShutter(
            "nas_willow_shutter");

    public static final RegistryObject<Shutter> NAS_WISTERIA_SHUTTER = registerWoodenShutter(
            "nas_wisteria_shutter");

    public static final RegistryObject<Shutter> OLIVE_SHUTTER = registerWoodenShutter(
            "olive_shutter");

    public static final RegistryObject<Shutter> PALO_VERDE_SHUTTER = registerWoodenShutter(
            "palo_verde_shutter");

    public static final RegistryObject<Shutter> PAPER_SHUTTER = registerWoodenShutter(
            "paper_shutter");

    public static final RegistryObject<Shutter> REDWOOD_SHUTTER = registerWoodenShutter(
            "redwood_shutter");

    public static final RegistryObject<Shutter> SAXAUL_SHUTTER = registerWoodenShutter(
            "saxaul_shutter");

    public static final RegistryObject<Shutter> SUGI_SHUTTER = registerWoodenShutter(
            "sugi_shutter");

    private static RegistryObject<Shutter> registerWoodenShutter(String name) {
        return registerBlock(name, () -> new Shutter(
                BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));
    }

	// Block
    private static <T extends Block> RegistryObject<T> registerBlockWithoutItem(
            String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(
            String name, Supplier<T> block) {
        RegistryObject<T> to_return = registerNewBlock(name, block);
        registerBlockItem(name, to_return, true);
        return to_return;
    }

    private static <T extends Block> RegistryObject<T> registerBlock(
            String name, Supplier<T> block, boolean burnAble) {
        RegistryObject<T> registryBlock = registerNewBlock(name, block);
        registerBlockItem(name, registryBlock, burnAble);
        return registryBlock;
    }

    private static <T extends Block> RegistryObject<T> registerNewBlock(
            String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

	private static <T extends Block> RegistryObject<Item> registerBlockItem(
			String name, RegistryObject<T> registered_block, boolean burnAble) {
		if (burnAble) {
			return MINECRAFT_ITEMS.register(name, () -> new BurnableItem(registered_block.get(), new Item.Properties(), 300));
		} else {
			return MINECRAFT_ITEMS.register(name, () -> new BlockItem(registered_block.get(), new Item.Properties()));
		}
	}

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        MINECRAFT_ITEMS.register(eventBus);
    }
}
