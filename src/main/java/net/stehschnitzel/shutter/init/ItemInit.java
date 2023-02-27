package net.stehschnitzel.shutter.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.stehschnitzel.shutter.ShutterMain;
import net.stehschnitzel.shutter.common.items.BurnableItem;

public class ItemInit {

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

	public static final RegistryObject<BlockItem> GLASS_SHUTTER = ITEMS_CREATE
			.register("glass_shutter", () -> new BlockItem(
					BlockInit.GLASS_SHUTTER.get(),
					new Item.Properties().tab(ShutterMain.SHUTTER_TAB)));

	public static final RegistryObject<BlockItem> AZALEA_SHUTTER = ITEMS_QUARK
			.register("azalea_shutter",
					() -> new BurnableItem(BlockInit.AZALEA_SHUTTER.get(),
							new Item.Properties().tab(ShutterMain.SHUTTER_TAB),
							300));

	public static final RegistryObject<BlockItem> COCONUT_SHUTTER = ITEMS_ECOLOGICS
			.register("coconut_shutter",
					() -> new BurnableItem(BlockInit.COCONUT_SHUTTER.get(),
							new Item.Properties().tab(ShutterMain.SHUTTER_TAB),
							300));

	public static final RegistryObject<BlockItem> FLOWERING_AZALEA_SHUTTER = ITEMS_ECOLOGICS
			.register("flowering_azalea_shutter",
					() -> new BurnableItem(
							BlockInit.FLOWERING_AZALEA_SHUTTER.get(),
							new Item.Properties().tab(ShutterMain.SHUTTER_TAB),
							300));

	public static final RegistryObject<BlockItem> WALNUT_SHUTTER = ITEMS_ECOLOGICS
			.register("walnut_shutter",
					() -> new BurnableItem(BlockInit.WALNUT_SHUTTER.get(),
							new Item.Properties().tab(ShutterMain.SHUTTER_TAB),
							300));

	public static final RegistryObject<BlockItem> POISE_SHUTTER = ITEMS_ENDERGETIC
			.register("poise_shutter",
					() -> new BurnableItem(BlockInit.POISE_SHUTTER.get(),
							new Item.Properties().tab(ShutterMain.SHUTTER_TAB),
							300));

	// minecraft
	public static final RegistryObject<BlockItem> ACACIA_SHUTTER = MINECRAFT_ITEMS
			.register("acacia_shutter",
					() -> new BurnableItem(BlockInit.ACACIA_SHUTTER.get(),
							new Item.Properties().tab(ShutterMain.SHUTTER_TAB),
							300));

	public static final RegistryObject<BlockItem> BIRCH_SHUTTER = MINECRAFT_ITEMS
			.register("birch_shutter",
					() -> new BurnableItem(BlockInit.BIRCH_SHUTTER.get(),
							new Item.Properties().tab(ShutterMain.SHUTTER_TAB),
							300));

	public static final RegistryObject<BlockItem> CRIMSON_SHUTTER = MINECRAFT_ITEMS
			.register("crimson_shutter", () -> new BlockItem(
					BlockInit.CRIMSON_SHUTTER.get(),
					new Item.Properties().tab(ShutterMain.SHUTTER_TAB)));

	public static final RegistryObject<BlockItem> DARK_OAK_SHUTTER = MINECRAFT_ITEMS
			.register("dark_oak_shutter",
					() -> new BurnableItem(BlockInit.DARK_OAK_SHUTTER.get(),
							new Item.Properties().tab(ShutterMain.SHUTTER_TAB),
							300));

	public static final RegistryObject<BlockItem> IRON_SHUTTER = MINECRAFT_ITEMS
			.register("iron_shutter", () -> new BlockItem(
					BlockInit.IRON_SHUTTER.get(),
					new Item.Properties().tab(ShutterMain.SHUTTER_TAB)));

	public static final RegistryObject<BlockItem> JUNGLE_SHUTTER = MINECRAFT_ITEMS
			.register("jungle_shutter",
					() -> new BurnableItem(BlockInit.JUNGLE_SHUTTER.get(),
							new Item.Properties().tab(ShutterMain.SHUTTER_TAB),
							300));

	public static final RegistryObject<BlockItem> OAK_SHUTTER = MINECRAFT_ITEMS
			.register("oak_shutter",
					() -> new BurnableItem(BlockInit.OAK_SHUTTER.get(),
							new Item.Properties().tab(ShutterMain.SHUTTER_TAB),
							300));

	public static final RegistryObject<BlockItem> SPRUCE_SHUTTER = MINECRAFT_ITEMS
			.register("spruce_shutter",
					() -> new BurnableItem(BlockInit.SPRUCE_SHUTTER.get(),
							new Item.Properties().tab(ShutterMain.SHUTTER_TAB),
							300));

	public static final RegistryObject<BlockItem> WARPED_SHUTTER = MINECRAFT_ITEMS
			.register("warped_shutter", () -> new BlockItem(
					BlockInit.WARPED_SHUTTER.get(),
					new Item.Properties().tab(ShutterMain.SHUTTER_TAB)));

	public static final RegistryObject<BlockItem> AZURE_SHUTTER = ITEMS_OUTER_END
			.register("azure_shutter",
					() -> new BurnableItem(BlockInit.AZURE_SHUTTER.get(),
							new Item.Properties().tab(ShutterMain.SHUTTER_TAB),
							300));
	
	public static final RegistryObject<BlockItem> BLOSSOM_SHUTTER = ITEMS_CREATE
			.register("blossom_shutter",
					() -> new BurnableItem(BlockInit.BLOSSOM_SHUTTER.get(),
							new Item.Properties().tab(ShutterMain.SHUTTER_TAB),
							300));

	public static final RegistryObject<BlockItem> GOLD_SHUTTER = ITEMS_SUPPLEMENTARIES
			.register("gold_shutter", () -> new BlockItem(
					BlockInit.GOLD_SHUTTER.get(),
					new Item.Properties().tab(ShutterMain.SHUTTER_TAB)));

	public static final RegistryObject<BlockItem> NETHERITE_SHUTTER = ITEMS_SUPPLEMENTARIES
			.register("netherite_shutter", () -> new BlockItem(
					BlockInit.NETHERITE_SHUTTER.get(),
					new Item.Properties().tab(ShutterMain.SHUTTER_TAB)));

	public static final RegistryObject<BlockItem> LEAD_SHUTTER = ITEMS_SUPPLEMENTARIES
			.register("lead_shutter", () -> new BlockItem(
					BlockInit.LEAD_SHUTTER.get(),
					new Item.Properties().tab(ShutterMain.SHUTTER_TAB)));

	public static final RegistryObject<BlockItem> SILVER_SHUTTER = ITEMS_SUPPLEMENTARIES
			.register("silver_shutter", () -> new BlockItem(
					BlockInit.SILVER_SHUTTER.get(),
					new Item.Properties().tab(ShutterMain.SHUTTER_TAB)));

	public static final RegistryObject<BlockItem> STRIPPED_BAMBOO_SHUTTER = ITEMS_TWIGS
			.register("stripped_bamboo_shutter",
					() -> new BurnableItem(
							BlockInit.STRIPPED_BAMBOO_SHUTTER.get(),
							new Item.Properties().tab(ShutterMain.SHUTTER_TAB),
							300));

}
