package net.stehschnitzel.shutter.init;

import com.google.common.base.Supplier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.stehschnitzel.shutter.ShutterMain;
import net.stehschnitzel.shutter.common.blocks.*;
import net.stehschnitzel.shutter.common.items.BurnableItem;

public class BlockInit {

	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister
		.createBlocks(ShutterMain.MOD_ID);

	public static final DeferredRegister<Item> MINECRAFT_ITEMS = DeferredRegister
			.createItems(ShutterMain.MOD_ID);

    //interaction shutters
    public static final DeferredBlock<Block> INTERACTION_SHUTTER_WOOD = registerBlockWithoutItem("interaction_shutter_wood", () -> new InteractionShutter(
            BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_WOOD).noLootTable().replaceable().noCollission()));

    public static final DeferredBlock<Block> INTERACTION_SHUTTER_CRIMSON = registerBlockWithoutItem("interaction_shutter_crimson", () -> new InteractionShutter(
            BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_DOOR).noLootTable().replaceable().noCollission()));

    public static final DeferredBlock<Block> INTERACTION_SHUTTER_IRON = registerBlockWithoutItem("interaction_shutter_iron", () -> new InteractionShutter(
            BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR).noLootTable().replaceable().noCollission()));

    public static final DeferredBlock<Block> INTERACTION_SHUTTER_WARPED = registerBlockWithoutItem("interaction_shutter_warped", () -> new InteractionShutter(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_DOOR).noLootTable().replaceable().noCollission()));

    public static final DeferredBlock<Block> INTERACTION_SHUTTER_COPPER = registerBlockWithoutItem("interaction_shutter_copper", () -> new InteractionShutter(
            BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK).noLootTable().replaceable().noCollission()));

    public static final DeferredBlock<Block> INTERACTION_SHUTTER_NETHERITE = registerBlockWithoutItem("interaction_shutter_netherite", () -> new InteractionShutter(
            BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK).noLootTable().replaceable().noCollission()));

    public static final DeferredBlock<Block> INTERACTION_SHUTTER_GLASS = registerBlockWithoutItem("interaction_shutter_glass", () -> new InteractionShutter(
            BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noLootTable().replaceable().noCollission()));


	// minecraft
	public static final DeferredBlock<Shutter> ACACIA_SHUTTER = registerWoodenShutter(
			"acacia_shutter");


	public static final DeferredBlock<Shutter> BIRCH_SHUTTER = registerWoodenShutter(
			"birch_shutter");


	public static final DeferredBlock<Shutter> CRIMSON_SHUTTER = registerBlock(
			"crimson_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)), false);

	public static final DeferredBlock<Shutter> DARK_OAK_SHUTTER = registerWoodenShutter(
			"dark_oak_shutter");


	public static final DeferredBlock<Shutter> IRON_SHUTTER = registerBlock(
			"iron_shutter", () -> new Shutter(
					BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR), true), false);

	public static final DeferredBlock<Shutter> JUNGLE_SHUTTER = registerWoodenShutter(
			"jungle_shutter");


	public static final DeferredBlock<Shutter> OAK_SHUTTER = registerWoodenShutter(
			"oak_shutter");


	public static final DeferredBlock<Shutter> SPRUCE_SHUTTER = registerWoodenShutter(
			"spruce_shutter");


	public static final DeferredBlock<Shutter> WARPED_SHUTTER = registerBlock(
			"warped_shutter", () -> new Shutter(
					BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)), false);

	public static final DeferredBlock<Shutter> MANGROVE_SHUTTER = registerWoodenShutter(
			"mangrove_shutter");

	public static final DeferredBlock<Shutter> BAMBOO_SHUTTER = registerBlock(
			"bamboo_shutter", () -> new Shutter(
					BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)));

	public static final DeferredBlock<Shutter> CHERRY_SHUTTER = registerBlock(
			"cherry_shutter", () -> new Shutter(
					BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));

	public static final DeferredBlock<Shutter> COPPER_SHUTTER = registerBlock(
			"copper_shutter", () -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.UNAFFECTED,
					BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_DOOR)));

	public static final DeferredBlock<Shutter> EXPOSED_COPPER_SHUTTER = registerBlock(
			"exposed_copper_shutter", () -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.EXPOSED,
					BlockBehaviour.Properties.ofFullCopy(Blocks.EXPOSED_COPPER_DOOR)));

	public static final DeferredBlock<Shutter> OXIDIZED_COPPER_SHUTTER = registerBlock(
			"oxidized_copper_shutter", () -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.OXIDIZED,
					BlockBehaviour.Properties.ofFullCopy(Blocks.OXIDIZED_COPPER_DOOR)));

	public static final DeferredBlock<Shutter> WEATHERED_COPPER_SHUTTER = registerBlock(
			"weathered_copper_shutter", () -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.WEATHERED,
					BlockBehaviour.Properties.ofFullCopy(Blocks.WEATHERED_COPPER_DOOR)));

	public static final DeferredBlock<Shutter> WAXED_COPPER_SHUTTER = registerBlock(
			"waxed_copper_shutter", () -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.UNAFFECTED,
					BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_DOOR)));

	public static final DeferredBlock<Shutter> WAXED_EXPOSED_COPPER_SHUTTER = registerBlock(
			"waxed_exposed_copper_shutter", () -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.EXPOSED,
					BlockBehaviour.Properties.ofFullCopy(Blocks.EXPOSED_COPPER_DOOR)));

	public static final DeferredBlock<Shutter> WAXED_OXIDIZED_COPPER_SHUTTER = registerBlock(
			"waxed_oxidized_copper_shutter", () -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.OXIDIZED,
					BlockBehaviour.Properties.ofFullCopy(Blocks.OXIDIZED_COPPER_DOOR)));

	public static final DeferredBlock<Shutter> WAXED_WEATHERED_COPPER_SHUTTER = registerBlock(
			"waxed_weathered_copper_shutter", () -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.WEATHERED,
					BlockBehaviour.Properties.ofFullCopy(Blocks.WEATHERED_COPPER_DOOR)));


	//mc but not really
	public static final DeferredBlock<Shutter> GOLD_SHUTTER = registerBlock(
			"gold_shutter", () -> new GoldShutter(
					BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)), false);

	public static final DeferredBlock<Shutter> NETHERITE_SHUTTER = registerBlock(
			"netherite_shutter", () -> new GoldShutter(
					BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK)), false);

	public static final DeferredBlock<Shutter> GLASS_SHUTTER = registerBlock(
			"glass_shutter", () -> new Shutter(
					BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()),
			 false);

    //beachparty
    public static final DeferredBlock<Shutter> PALM_SHUTTER = registerWoodenShutter(
            "palm_shutter");


    //autumnity
    public static final DeferredBlock<Shutter> MAPLE_SHUTTER = registerWoodenShutter(
            "maple_shutter");


    //Caverns & Chasms
    public static final DeferredBlock<Shutter> CAVERN_AZALEA_SHUTTER = registerWoodenShutter(
            "cavern_azalea_shutter");


    // ecologics
    public static final DeferredBlock<Shutter> AZALEA_SHUTTER = registerWoodenShutter(
            "azalea_shutter");


    public static final DeferredBlock<Shutter> COCONUT_SHUTTER = registerWoodenShutter(
            "coconut_shutter");


    public static final DeferredBlock<Shutter> FLOWERING_AZALEA_SHUTTER = registerWoodenShutter(
            "flowering_azalea_shutter");


    public static final DeferredBlock<Shutter> WALNUT_SHUTTER = registerWoodenShutter(
            "walnut_shutter");


    //environmental
    public static final DeferredBlock<Shutter> PLUM_SHUTTER = registerWoodenShutter(
            "plum_shutter");


    public static final DeferredBlock<Shutter> WILLOW_SHUTTER = registerWoodenShutter(
            "willow_shutter");


    public static final DeferredBlock<Shutter> WISTERIA_SHUTTER = registerWoodenShutter(
            "wisteria_shutter");


    public static final DeferredBlock<Shutter> PINE_SHUTTER = registerWoodenShutter(
            "pine_shutter");


    //goodending 1.20.1 forge and fabric
    public static final DeferredBlock<Shutter> CYPRESS_SHUTTER = registerWoodenShutter(
            "cypress_shutter");


    public static final DeferredBlock<Shutter> MUDDY_OAK_SHUTTER = registerWoodenShutter(
            "muddy_oak_shutter");


    // Oreganized 1.20.1 forge only
//    public static final DeferredBlock<Shutter> LEAD_SHUTTER = registerBlock(
//            "lead_shutter", () -> new LeadShutter(
//                    BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR)), false);
//
//    public static final DeferredBlock<Shutter> SILVER_SHUTTER = registerBlock(
//            "silver_shutter", () -> new SilverShutter(
//                    BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR)), false);

    // quark
    public static final DeferredBlock<Shutter> BLOSSOM_SHUTTER = registerWoodenShutter(
            "blossom_shutter");


    public static final DeferredBlock<Shutter> ANCIENT_SHUTTER = registerWoodenShutter(
            "ancient_shutter");


    public static final DeferredBlock<Shutter> AZALEA_QUARK_SHUTTER = registerWoodenShutter(
            "azalea_quark_shutter");


    //snowy spirit
    public static final DeferredBlock<Shutter> GINGERBREAD_SHUTTER = registerWoodenShutter(
            "gingerbread_shutter");


    // endergetic
//    public static final DeferredBlock<Shutter> POISE_SHUTTER = registerWoodenShutter(
//            "poise_shutter");
//

    // outer_end
//    public static final DeferredBlock<Shutter> AZURE_SHUTTER = registerWoodenShutter(
//            "azure_shutter");
//

    // twigs
    public static final DeferredBlock<Shutter> STRIPPED_BAMBOO_SHUTTER = registerWoodenShutter(
            "stripped_bamboo_shutter");


    //update aquatic
	public static final DeferredBlock<Shutter> DRIFTWOOD_SHUTTER = registerWoodenShutter(
			"driftwood_shutter");

	public static final DeferredBlock<Shutter> RIVER_SHUTTER = registerWoodenShutter(
			"river_shutter");


    //nature spirit
    public static final DeferredBlock<Shutter> ASPEN_SHUTTER = registerWoodenShutter(
            "aspen_shutter");

    public static final DeferredBlock<Shutter> BLOOMING_PAPER_SHUTTER = registerWoodenShutter(
            "blooming_paper_shutter");

    public static final DeferredBlock<Shutter> CEDAR_SHUTTER = registerWoodenShutter(
            "cedar_shutter");

    public static final DeferredBlock<Shutter> FIR_SHUTTER = registerWoodenShutter(
            "fir_shutter");

    public static final DeferredBlock<Shutter> FRAMED_PAPER_SHUTTER = registerWoodenShutter(
            "framed_paper_shutter");

    public static final DeferredBlock<Shutter> GHAF_SHUTTER = registerWoodenShutter(
            "ghaf_shutter");

    public static final DeferredBlock<Shutter> JOSHUA_SHUTTER = registerWoodenShutter(
            "joshua_shutter");

    public static final DeferredBlock<Shutter> LARCH_SHUTTER = registerWoodenShutter(
            "larch_shutter");

    public static final DeferredBlock<Shutter> MAHOGANY_SHUTTER = registerWoodenShutter(
            "mahogany_shutter");

    public static final DeferredBlock<Shutter> NAS_COCONUT_SHUTTER = registerWoodenShutter(
            "nas_coconut_shutter");

    public static final DeferredBlock<Shutter> NAS_CYPRESS_SHUTTER = registerWoodenShutter(
            "nas_cypress_shutter");

    public static final DeferredBlock<Shutter> NAS_MAPLE_SHUTTER = registerWoodenShutter(
            "nas_maple_shutter");

    public static final DeferredBlock<Shutter> NAS_WILLOW_SHUTTER = registerWoodenShutter(
            "nas_willow_shutter");

    public static final DeferredBlock<Shutter> NAS_WISTERIA_SHUTTER = registerWoodenShutter(
            "nas_wisteria_shutter");

    public static final DeferredBlock<Shutter> OLIVE_SHUTTER = registerWoodenShutter(
            "olive_shutter");

    public static final DeferredBlock<Shutter> PALO_VERDE_SHUTTER = registerWoodenShutter(
            "palo_verde_shutter");

    public static final DeferredBlock<Shutter> PAPER_SHUTTER = registerWoodenShutter(
            "paper_shutter");

    public static final DeferredBlock<Shutter> REDWOOD_SHUTTER = registerWoodenShutter(
            "redwood_shutter");

    public static final DeferredBlock<Shutter> SAXAUL_SHUTTER = registerWoodenShutter(
            "saxaul_shutter");

    public static final DeferredBlock<Shutter> SUGI_SHUTTER = registerWoodenShutter(
            "sugi_shutter");



    private static <T extends Block> DeferredBlock<T> registerWoodenShutter(
            String name) {
        DeferredBlock to_return = registerBlock(name, () -> new Shutter(
                BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_WOOD)));
        return to_return;
    }

	// Block
	private static <T extends Block> DeferredBlock<T> registerBlock(
			String name, Supplier<T> block) {
		DeferredBlock<T> to_return = registerBlockWithoutItem(name, block);
		registerBlockItem(name, to_return, true);
		return to_return;
	}

    private static <T extends Block> DeferredBlock<T> registerBlock(
            String name, Supplier<T> block, boolean burnAble) {
        DeferredBlock<T> registryBlock = registerBlockWithoutItem(name, block);
        registerBlockItem(name, registryBlock, burnAble);
        return registryBlock;
    }

    private static <T extends Block> DeferredBlock<T> registerBlockWithoutItem(
            String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

	private static <T extends Block> void registerBlockItem(
			String name, DeferredBlock<T> registeredBlock, boolean burnAble) {
		if (burnAble) {
            MINECRAFT_ITEMS.register(name, () -> new BurnableItem(registeredBlock.get(), new Item.Properties(), 300));
        } else {
            MINECRAFT_ITEMS.register(name, () -> new BlockItem(registeredBlock.get(), new Item.Properties()));
        }
	}

	public static void registerBlockItem(IEventBus bus) {
		MINECRAFT_ITEMS.register(bus);
	}

	public static void registerBlock(IEventBus bus) {
		BLOCKS.register(bus);
	}
}
