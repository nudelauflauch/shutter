package net.stehschnitzel.shutter.init;

import com.google.common.base.Supplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.stehschnitzel.shutter.ShutterMain;
import net.stehschnitzel.shutter.common.blocks.*;
import net.stehschnitzel.shutter.common.items.BurnableItem;

import java.util.function.Function;

public class BlockInit {

	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister
		.createBlocks(ShutterMain.MOD_ID);

	public static final DeferredRegister.Items MINECRAFT_ITEMS = DeferredRegister
			.createItems(ShutterMain.MOD_ID);


	// ecologics newest 1.20.1 fabric and forge
//	public static final DeferredBlock<Shutter> AZALEA_SHUTTER = registerBlock("azalea_shutter",
//			properties -> new Shutter(
//			properties.ofFullCopy(Blocks.ACACIA_WOOD)), ITEMS_ECOLOGICS);
//
//	public static final DeferredBlock<Shutter> COCONUT_SHUTTER = registerBlock(
//			"coconut_shutter", properties -> new Shutter(
//					properties.ofFullCopy(Blocks.ACACIA_WOOD)), ITEMS_ECOLOGICS);
//
//	public static final DeferredBlock<Shutter> FLOWERING_AZALEA_SHUTTER = registerBlock(
//			"flowering_azalea_shutter", properties -> new Shutter(
//					properties.ofFullCopy(Blocks.ACACIA_WOOD)), ITEMS_ECOLOGICS);
//
//	public static final DeferredBlock<Shutter> WALNUT_SHUTTER = registerBlock(
//			"walnut_shutter", properties -> new Shutter(
//					properties.ofFullCopy(Blocks.ACACIA_WOOD)), ITEMS_ECOLOGICS);

	// endergetic 1.19.2 forge only
//	public static final DeferredBlock<Shutter> POISE_SHUTTER = registerBlock(
//			"poise_shutter", properties -> new Shutter(
//					properties.ofFullCopy(Blocks.ACACIA_WOOD)), ITEMS_ENDERGETIC);


	// minecraft
	public static final DeferredBlock<Shutter> ACACIA_SHUTTER = registerBlock("acacia_shutter",
			registryName -> new Shutter(
					BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_WOOD).setId(ResourceKey.create(Registries.BLOCK, registryName))));

	public static final DeferredBlock<Shutter> BIRCH_SHUTTER = registerBlock("birch_shutter",
			registryName -> new Shutter(
					BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_WOOD).setId(ResourceKey.create(Registries.BLOCK, registryName))));

	public static final DeferredBlock<Shutter> CRIMSON_SHUTTER = registerBlock("crimson_shutter",
			registryName -> new Shutter(
					BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).setId(ResourceKey.create(Registries.BLOCK, registryName))), false);

	public static final DeferredBlock<Shutter> DARK_OAK_SHUTTER = registerBlock("dark_oak_shutter",
			registryName -> new Shutter(
					BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_WOOD).setId(ResourceKey.create(Registries.BLOCK, registryName))));

	public static final DeferredBlock<Shutter> IRON_SHUTTER = registerBlock("iron_shutter",
			registryName -> new Shutter(
					BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR).setId(ResourceKey.create(Registries.BLOCK, registryName)), true), false);

	public static final DeferredBlock<Shutter> JUNGLE_SHUTTER = registerBlock("jungle_shutter",
			registryName -> new Shutter(
					BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_WOOD).setId(ResourceKey.create(Registries.BLOCK, registryName))));

	public static final DeferredBlock<Shutter> OAK_SHUTTER = registerBlock("oak_shutter",
			registryName -> new Shutter(
					BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_WOOD).setId(ResourceKey.create(Registries.BLOCK, registryName))));

	public static final DeferredBlock<Shutter> SPRUCE_SHUTTER = registerBlock("spruce_shutter",
			registryName -> new Shutter(
					BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_WOOD).setId(ResourceKey.create(Registries.BLOCK, registryName))));

	public static final DeferredBlock<Shutter> WARPED_SHUTTER = registerBlock("warped_shutter",
			registryName -> new Shutter(
					BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).setId(ResourceKey.create(Registries.BLOCK, registryName))), false);

	public static final DeferredBlock<Shutter> MANGROVE_SHUTTER = registerBlock("mangrove_shutter",
			registryName -> new Shutter(
					BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_WOOD).setId(ResourceKey.create(Registries.BLOCK, registryName))));

	public static final DeferredBlock<Shutter> BAMBOO_SHUTTER = registerBlock("bamboo_shutter",
			registryName -> new Shutter(
					BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS).setId(ResourceKey.create(Registries.BLOCK, registryName))));

	public static final DeferredBlock<Shutter> CHERRY_SHUTTER = registerBlock("cherry_shutter",
			registryName -> new Shutter(
					BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).setId(ResourceKey.create(Registries.BLOCK, registryName))));

	public static final DeferredBlock<Shutter> COPPER_SHUTTER = registerBlock("copper_shutter",
			registryName -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.UNAFFECTED,
					BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_DOOR).setId(ResourceKey.create(Registries.BLOCK, registryName))));

	public static final DeferredBlock<Shutter> EXPOSED_COPPER_SHUTTER = registerBlock("exposed_copper_shutter",
			registryName -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.EXPOSED,
					BlockBehaviour.Properties.ofFullCopy(Blocks.EXPOSED_COPPER_DOOR).setId(ResourceKey.create(Registries.BLOCK, registryName))));

	public static final DeferredBlock<Shutter> OXIDIZED_COPPER_SHUTTER = registerBlock("oxidized_copper_shutter",
			registryName -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.OXIDIZED,
					BlockBehaviour.Properties.ofFullCopy(Blocks.OXIDIZED_COPPER_DOOR).setId(ResourceKey.create(Registries.BLOCK, registryName))));

	public static final DeferredBlock<Shutter> WEATHERED_COPPER_SHUTTER = registerBlock("weathered_copper_shutter",
			registryName -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.WEATHERED,
					BlockBehaviour.Properties.ofFullCopy(Blocks.WEATHERED_COPPER_DOOR).setId(ResourceKey.create(Registries.BLOCK, registryName))));

	public static final DeferredBlock<Shutter> WAXED_COPPER_SHUTTER = registerBlock("waxed_copper_shutter",
			registryName -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.UNAFFECTED,
					BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_DOOR).setId(ResourceKey.create(Registries.BLOCK, registryName))));

	public static final DeferredBlock<Shutter> WAXED_EXPOSED_COPPER_SHUTTER = registerBlock("waxed_exposed_copper_shutter",
			registryName -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.EXPOSED,
					BlockBehaviour.Properties.ofFullCopy(Blocks.EXPOSED_COPPER_DOOR).setId(ResourceKey.create(Registries.BLOCK, registryName))));

	public static final DeferredBlock<Shutter> WAXED_OXIDIZED_COPPER_SHUTTER = registerBlock("waxed_oxidized_copper_shutter",
			registryName -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.OXIDIZED,
					BlockBehaviour.Properties.ofFullCopy(Blocks.OXIDIZED_COPPER_DOOR).setId(ResourceKey.create(Registries.BLOCK, registryName))));

	public static final DeferredBlock<Shutter> WAXED_WEATHERED_COPPER_SHUTTER = registerBlock("waxed_weathered_copper_shutter",
			registryName -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.WEATHERED,
					BlockBehaviour.Properties.ofFullCopy(Blocks.WEATHERED_COPPER_DOOR).setId(ResourceKey.create(Registries.BLOCK, registryName))));


	//mc but not really
	public static final DeferredBlock<Shutter> GOLD_SHUTTER = registerBlock("gold_shutter",
			registryName -> new GoldShutter(
					BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR).setId(ResourceKey.create(Registries.BLOCK, registryName))), false);

	public static final DeferredBlock<Shutter> NETHERITE_SHUTTER = registerBlock("netherite_shutter",
			registryName -> new GoldShutter(
					BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK).setId(ResourceKey.create(Registries.BLOCK, registryName))), false);

	public static final DeferredBlock<Shutter> GLASS_SHUTTER = registerBlock("glass_shutter",
			registryName -> new Shutter(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)
					.noOcclusion().setId(ResourceKey.create(Registries.BLOCK, registryName)), false));

	// outer_end 1.20.1 forge
//	public static final DeferredBlock<Shutter> AZURE_SHUTTER = registerBlock(
//			"azure_shutter", () -> new Shutter(
//					properties.ofFullCopy(Blocks.ACACIA_WOOD)), ITEMS_OUTER_END);


	// quark 1.20.1 forge only
//	public static final DeferredBlock<Shutter> BLOSSOM_SHUTTER = registerBlock(
//			"blossom_shutter", () -> new Shutter(
//					properties.ofFullCopy(Blocks.ACACIA_WOOD)), ITEMS_QUARK);
//
//	public static final DeferredBlock<Shutter> ANCIENT_SHUTTER = registerBlock(
//			"ancient_shutter", () -> new Shutter(
//					properties.ofFullCopy(Blocks.ACACIA_WOOD)), ITEMS_QUARK);
//
//	public static final DeferredBlock<Shutter> AZALEA_QUARK_SHUTTER = registerBlock(
//			"azalea_quark_shutter", () -> new Shutter(
//					properties.ofFullCopy(Blocks.ACACIA_WOOD)), ITEMS_QUARK);

	// Oreganized 1.20.1 forge only
//	public static final DeferredBlock<Shutter> LEAD_SHUTTER = registerBlock(
//			"lead_shutter", () -> new LeadShutter(
//					properties.ofFullCopy(Blocks.IRON_DOOR)), ITEMS_SUPPLEMENTARIES, false);
//
//	public static final DeferredBlock<Shutter> SILVER_SHUTTER = registerBlock(
//			"silver_shutter", () -> new SilverShutter(
//					properties.ofFullCopy(Blocks.IRON_DOOR)), ITEMS_SUPPLEMENTARIES, false);

	// twigs 1.20.1 forge and fabric
//	public static final DeferredBlock<Shutter> STRIPPED_BAMBOO_SHUTTER = registerBlock(
//			"stripped_bamboo_shutter", () -> new Shutter(
//					properties.ofFullCopy(Blocks.ACACIA_WOOD)), ITEMS_TWIGS);

	//autumnity 1.20.1 forge
//	public static final DeferredBlock<Shutter> MAPLE_SHUTTER = registerBlock(
//			"maple_shutter", () -> new Shutter(
//					properties.ofFullCopy(Blocks.ACACIA_WOOD)), ITEMS_AUTUMNITY);


	//environmental 1.19.2 forge only
//	public static final DeferredBlock<Shutter> CHERRY_ENV_SHUTTER = registerBlock(
//			"cherry_env_shutter", () -> new Shutter(
//					properties.ofFullCopy(Blocks.ACACIA_WOOD)), ITEMS_ENVIRONMENTAL);
//
//	public static final DeferredBlock<Shutter> WILLOW_SHUTTER = registerBlock(
//			"willow_shutter", () -> new Shutter(
//					properties.ofFullCopy(Blocks.ACACIA_WOOD)), ITEMS_ENVIRONMENTAL);
//
//	public static final DeferredBlock<Shutter> WISTERIA_SHUTTER = registerBlock(
//			"wisteria_shutter", () -> new Shutter(
//					properties.ofFullCopy(Blocks.ACACIA_WOOD)), ITEMS_ENVIRONMENTAL);

	//snowy spirit 1.20.1 forge fabric on version 1.21.1
//	public static final DeferredBlock<Shutter> GINGERBREAD_SHUTTER = registerBlock(
//			"gingerbread_shutter", () -> new Shutter(
//					properties.ofFullCopy(Blocks.ACACIA_WOOD)), ITEMS_SNOWY_SPIRIT);

	//update_aquatic 1.20.1 forge
//	public static final DeferredBlock<Shutter> DRIFTWOOD_SHUTTER = registerBlock(
//			"driftwood_shutter", () -> new Shutter(
//					properties.ofFullCopy(Blocks.ACACIA_WOOD)), ITEMS_UPGRADE_AQUATTIC);
//
//	public static final DeferredBlock<Shutter> RIVER_SHUTTER = registerBlock(
//			"river_shutter", () -> new Shutter(
//					properties.ofFullCopy(Blocks.ACACIA_WOOD)), ITEMS_UPGRADE_AQUATTIC);

	//goodending 1.20.1 forge and fabric
//	public static final DeferredBlock<Shutter> CYPRESS_SHUTTER = registerBlock(
//			"cypress_shutter", () -> new Shutter(
//					properties.ofFullCopy(Blocks.ACACIA_WOOD)), ITEMS_GOODENDING);
//
//	public static final DeferredBlock<Shutter> MUDDY_OAK_SHUTTER = registerBlock(
//			"muddy_oak_shutter", () -> new Shutter(
//					properties.ofFullCopy(Blocks.ACACIA_WOOD)), ITEMS_GOODENDING);
	//beachparty
//	public static final DeferredBlock<Shutter> PALM_SHUTTER = registerBlock(
//			"palm_shutter", () -> new Shutter(
//					properties.ofFullCopy(Blocks.ACACIA_WOOD)), ITEMS_BEACHPARTY);

	// Block with burn able block item
	private static <T extends Block> DeferredBlock<T> registerBlock(
			String name, Function<ResourceLocation, ? extends T> func) {
		return registerBlock(name, func, true);
	}

	//block with block item
	private static <T extends Block> DeferredBlock<T> registerBlock(
			String name, Function<ResourceLocation, ? extends T> function, boolean burnAble) {
		DeferredBlock<T> registryBlock = BLOCKS.register(name, function);
		registerBlockItem(name, registryBlock, burnAble);
		return registryBlock;
	}

	private static <T extends Block> void registerBlockItem(
			String name, DeferredBlock<T> block, boolean burnAble) {
		if (burnAble) {
			MINECRAFT_ITEMS.register(name,
					registryName -> new BurnableItem(block.get(),
							new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName)),
					300));
		} else {
			MINECRAFT_ITEMS.registerItem(name, properties -> new BlockItem(block.get(), properties));
		}
	}

	public static void registerBlockItem(IEventBus bus) {
		MINECRAFT_ITEMS.register(bus);
	}

	public static void registerBlock(IEventBus bus) {
		BLOCKS.register(bus);
	}
}
