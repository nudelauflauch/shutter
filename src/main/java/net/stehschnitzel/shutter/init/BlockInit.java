package net.stehschnitzel.shutter.init;

import com.google.common.base.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
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

	public static final DeferredRegister<Item> ITEMS_CREATE = DeferredRegister
			.create(ForgeRegistries.ITEMS, ShutterMain.MODID);

	public static final DeferredRegister<Item> ITEMS_ECOLOGICS = DeferredRegister
			.create(ForgeRegistries.ITEMS, ShutterMain.MODID);

	public static final DeferredRegister<Item> ITEMS_ENDERGETIC = DeferredRegister
			.create(ForgeRegistries.ITEMS, ShutterMain.MODID);

	public static final DeferredRegister<Item> ITEMS_OUTER_END = DeferredRegister
			.create(ForgeRegistries.ITEMS, ShutterMain.MODID);

	public static final DeferredRegister<Item> ITEMS_QUARK = DeferredRegister
			.create(ForgeRegistries.ITEMS, ShutterMain.MODID);

	public static final DeferredRegister<Item> ITEMS_SUPPLEMENTARIES = DeferredRegister
			.create(ForgeRegistries.ITEMS, ShutterMain.MODID);

	public static final DeferredRegister<Item> ITEMS_OREGANIZED = DeferredRegister
			.create(ForgeRegistries.ITEMS, ShutterMain.MODID);

	public static final DeferredRegister<Item> ITEMS_TWIGS = DeferredRegister
			.create(ForgeRegistries.ITEMS, ShutterMain.MODID);

	public static final DeferredRegister<Item> ITEMS_AUTUMNITY = DeferredRegister
			.create(ForgeRegistries.ITEMS, ShutterMain.MODID);

	public static final DeferredRegister<Item> ITEMS_ENVIRONMENTAL = DeferredRegister
			.create(ForgeRegistries.ITEMS, ShutterMain.MODID);

	public static final DeferredRegister<Item> ITEMS_SNOWY_SPIRIT = DeferredRegister
			.create(ForgeRegistries.ITEMS, ShutterMain.MODID);

	public static final DeferredRegister<Item> ITEMS_UPGRADE_AQUATTIC = DeferredRegister
			.create(ForgeRegistries.ITEMS, ShutterMain.MODID);

	public static final DeferredRegister<Item> ITEMS_GOODENDING = DeferredRegister
			.create(ForgeRegistries.ITEMS, ShutterMain.MODID);

	public static final DeferredRegister<Item> ITEMS_BEACHPARTY = DeferredRegister
			.create(ForgeRegistries.ITEMS, ShutterMain.MODID);


	// ecologics
	public static final RegistryObject<Shutter> AZALEA_SHUTTER = registerBlock("azalea_shutter", () -> new Shutter(
			BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_ECOLOGICS);

	public static final RegistryObject<Shutter> COCONUT_SHUTTER = registerBlock(
			"coconut_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_ECOLOGICS);

	public static final RegistryObject<Shutter> FLOWERING_AZALEA_SHUTTER = registerBlock(
			"flowering_azalea_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_ECOLOGICS);

	public static final RegistryObject<Shutter> WALNUT_SHUTTER = registerBlock(
			"walnut_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_ECOLOGICS);

	// endergetic
	public static final RegistryObject<Shutter> POISE_SHUTTER = registerBlock(
			"poise_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_ENDERGETIC);


	// minecraft
	public static final RegistryObject<Shutter> ACACIA_SHUTTER = registerBlock(
			"acacia_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), MINECRAFT_ITEMS);

	public static final RegistryObject<Shutter> BIRCH_SHUTTER = registerBlock(
			"birch_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), MINECRAFT_ITEMS);

	public static final RegistryObject<Shutter> CRIMSON_SHUTTER = registerBlock(
			"crimson_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)), MINECRAFT_ITEMS, false);

	public static final RegistryObject<Shutter> DARK_OAK_SHUTTER = registerBlock(
			"dark_oak_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), MINECRAFT_ITEMS);

	public static final RegistryObject<Shutter> IRON_SHUTTER = registerBlock(
			"iron_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.IRON_DOOR), true), MINECRAFT_ITEMS, false);

	public static final RegistryObject<Shutter> JUNGLE_SHUTTER = registerBlock(
			"jungle_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), MINECRAFT_ITEMS);

	public static final RegistryObject<Shutter> OAK_SHUTTER = registerBlock(
			"oak_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), MINECRAFT_ITEMS);

	public static final RegistryObject<Shutter> SPRUCE_SHUTTER = registerBlock(
			"spruce_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), MINECRAFT_ITEMS);

	public static final RegistryObject<Shutter> WARPED_SHUTTER = registerBlock(
			"warped_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)), MINECRAFT_ITEMS, false);

	public static final RegistryObject<Shutter> MANGROVE_SHUTTER = registerBlock(
			"mangrove_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), MINECRAFT_ITEMS);

	public static final RegistryObject<Shutter> BAMBOO_SHUTTER = registerBlock(
			"bamboo_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS)), MINECRAFT_ITEMS);

	public static final RegistryObject<Shutter> CHERRY_SHUTTER = registerBlock(
			"cherry_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)), MINECRAFT_ITEMS);

	public static final RegistryObject<Shutter> COPPER_SHUTTER = registerBlock(
			"copper_shutter", () -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.UNAFFECTED,
					BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)), MINECRAFT_ITEMS);

	public static final RegistryObject<Shutter> EXPOSED_COPPER_SHUTTER = registerBlock(
			"exposed_copper_shutter", () -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.EXPOSED,
					BlockBehaviour.Properties.copy(Blocks.EXPOSED_COPPER)), MINECRAFT_ITEMS);

	public static final RegistryObject<Shutter> OXIDIZED_COPPER_SHUTTER = registerBlock(
			"oxidized_copper_shutter", () -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.OXIDIZED,
					BlockBehaviour.Properties.copy(Blocks.OXIDIZED_COPPER)), MINECRAFT_ITEMS);

	public static final RegistryObject<Shutter> WEATHERED_COPPER_SHUTTER = registerBlock(
			"weathered_copper_shutter", () -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.WEATHERED,
					BlockBehaviour.Properties.copy(Blocks.WEATHERED_COPPER)), MINECRAFT_ITEMS);

	public static final RegistryObject<Shutter> WAXED_COPPER_SHUTTER = registerBlock(
			"waxed_copper_shutter", () -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.UNAFFECTED,
					BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)), MINECRAFT_ITEMS);

	public static final RegistryObject<Shutter> WAXED_EXPOSED_COPPER_SHUTTER = registerBlock(
			"waxed_exposed_copper_shutter", () -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.EXPOSED,
					BlockBehaviour.Properties.copy(Blocks.EXPOSED_COPPER)), MINECRAFT_ITEMS);

	public static final RegistryObject<Shutter> WAXED_OXIDIZED_COPPER_SHUTTER = registerBlock(
			"waxed_oxidized_copper_shutter", () -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.OXIDIZED,
					BlockBehaviour.Properties.copy(Blocks.OXIDIZED_COPPER)), MINECRAFT_ITEMS);

	public static final RegistryObject<Shutter> WAXED_WEATHERED_COPPER_SHUTTER = registerBlock(
			"waxed_weathered_copper_shutter", () -> new WeatheringCopperShutter(WeatheringCopper.WeatherState.WEATHERED,
					BlockBehaviour.Properties.copy(Blocks.WEATHERED_COPPER)), MINECRAFT_ITEMS);

	//mc but not really
	public static final RegistryObject<Shutter> GOLD_SHUTTER = registerBlock(
			"gold_shutter", () -> new GoldShutter(
					BlockBehaviour.Properties.copy(Blocks.IRON_DOOR)), MINECRAFT_ITEMS, false);

	public static final RegistryObject<Shutter> NETHERITE_SHUTTER = registerBlock(
			"netherite_shutter", () -> new GoldShutter(
					BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)), MINECRAFT_ITEMS, false);

	public static final RegistryObject<Shutter> GLASS_SHUTTER = registerBlock(
			"glass_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()),
			MINECRAFT_ITEMS, false);

	// outer_end
	public static final RegistryObject<Shutter> AZURE_SHUTTER = registerBlock(
			"azure_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_OUTER_END);


	// quark
	public static final RegistryObject<Shutter> BLOSSOM_SHUTTER = registerBlock(
			"blossom_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_QUARK);

	public static final RegistryObject<Shutter> ANCIENT_SHUTTER = registerBlock(
			"ancient_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_QUARK);

	public static final RegistryObject<Shutter> AZALEA_QUARK_SHUTTER = registerBlock(
			"azalea_quark_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_QUARK);

	// Oreganized
	public static final RegistryObject<Shutter> LEAD_SHUTTER = registerBlock(
			"lead_shutter", () -> new LeadShutter(
					BlockBehaviour.Properties.copy(Blocks.IRON_DOOR)), ITEMS_SUPPLEMENTARIES, false);

	public static final RegistryObject<Shutter> SILVER_SHUTTER = registerBlock(
			"silver_shutter", () -> new SilverShutter(
					BlockBehaviour.Properties.copy(Blocks.IRON_DOOR)), ITEMS_SUPPLEMENTARIES, false);

	// twigs
	public static final RegistryObject<Shutter> STRIPPED_BAMBOO_SHUTTER = registerBlock(
			"stripped_bamboo_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_TWIGS);

	//autumnity
	public static final RegistryObject<Shutter> MAPLE_SHUTTER = registerBlock(
			"maple_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_AUTUMNITY);


	//environmental
	public static final RegistryObject<Shutter> CHERRY_ENV_SHUTTER = registerBlock(
			"cherry_env_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_ENVIRONMENTAL);

	public static final RegistryObject<Shutter> WILLOW_SHUTTER = registerBlock(
			"willow_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_ENVIRONMENTAL);

	public static final RegistryObject<Shutter> WISTERIA_SHUTTER = registerBlock(
			"wisteria_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_ENVIRONMENTAL);

	//snowy spirit
	public static final RegistryObject<Shutter> GINGERBREAD_SHUTTER = registerBlock(
			"gingerbread_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_SNOWY_SPIRIT);

	//update_aquatic
	public static final RegistryObject<Shutter> DRIFTWOOD_SHUTTER = registerBlock(
			"driftwood_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_UPGRADE_AQUATTIC);

	public static final RegistryObject<Shutter> RIVER_SHUTTER = registerBlock(
			"river_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_UPGRADE_AQUATTIC);

	//goodending
	public static final RegistryObject<Shutter> CYPRESS_SHUTTER = registerBlock(
			"cypress_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_GOODENDING);

	public static final RegistryObject<Shutter> MUDDY_OAK_SHUTTER = registerBlock(
			"muddy_oak_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_GOODENDING);

	//beachparty
	public static final RegistryObject<Shutter> PALM_SHUTTER = registerBlock(
			"palm_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_BEACHPARTY);

	// Block
	private static <T extends Block> RegistryObject<T> registerBlock(
			String name, Supplier<T> block, DeferredRegister<Item> item_reg) {
		RegistryObject<T> to_return = BLOCKS.register(name, block);
		registerBlockItem(name, item_reg, to_return, true);
		return to_return;
	}

	private static <T extends Block> RegistryObject<T> registerBlock(
			String name, Supplier<T> block, DeferredRegister<Item> item_reg, boolean burnAble) {
		RegistryObject<T> registryBlock = BLOCKS.register(name, block);
		registerBlockItem(name, item_reg, registryBlock, burnAble);
		return registryBlock;
	}

	private static <T extends Block> RegistryObject<Item> registerBlockItem(
			String name, DeferredRegister<Item> item_reg, RegistryObject<T> registered_block, boolean burnAble) {
		if (burnAble) {
			return item_reg.register(name, () -> new BurnableItem(registered_block.get(), new Item.Properties(), 300));
		} else {
			return item_reg.register(name, () -> new BlockItem(registered_block.get(), new Item.Properties()));
		}
	}
}
