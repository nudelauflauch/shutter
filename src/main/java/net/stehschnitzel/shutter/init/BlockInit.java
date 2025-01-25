package net.stehschnitzel.shutter.init;

import com.google.common.base.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.stehschnitzel.shutter.ShutterMain;
import net.stehschnitzel.shutter.common.blocks.GoldShutter;
import net.stehschnitzel.shutter.common.blocks.LeadShutter;
import net.stehschnitzel.shutter.common.blocks.Shutter;
import net.stehschnitzel.shutter.common.blocks.SilverShutter;
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








	// create
	public static final RegistryObject<Block> GLASS_SHUTTER = registerBlock(
			"glass_shutter", () -> new Shutter(
					BlockBehaviour.Properties.of(Material.GLASS)
							.sound(SoundType.GLASS).strength(0.3F)
							.sound(SoundType.GLASS).noOcclusion()),
			ITEMS_CREATE, false);

	// ecologics
	public static final RegistryObject<Block> AZALEA_SHUTTER = registerBlock("azalea_shutter", () -> new Shutter(
			BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_ECOLOGICS);

	public static final RegistryObject<Block> COCONUT_SHUTTER = registerBlock(
			"coconut_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_ECOLOGICS);

	public static final RegistryObject<Block> FLOWERING_AZALEA_SHUTTER = registerBlock(
			"flowering_azalea_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_ECOLOGICS);

	public static final RegistryObject<Block> WALNUT_SHUTTER = registerBlock(
			"walnut_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_ECOLOGICS);

	// endergetic
	public static final RegistryObject<Block> POISE_SHUTTER = registerBlock(
			"poise_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_ENDERGETIC);

	// minecraft
	public static final RegistryObject<Block> ACACIA_SHUTTER = registerBlock(
			"acacia_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), MINECRAFT_ITEMS);

	public static final RegistryObject<Block> BIRCH_SHUTTER = registerBlock(
			"birch_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), MINECRAFT_ITEMS);

	public static final RegistryObject<Block> CRIMSON_SHUTTER = registerBlock(
			"crimson_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), MINECRAFT_ITEMS, false);

	public static final RegistryObject<Block> DARK_OAK_SHUTTER = registerBlock(
			"dark_oak_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), MINECRAFT_ITEMS);

	public static final RegistryObject<Block> IRON_SHUTTER = registerBlock(
			"iron_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.IRON_DOOR)), MINECRAFT_ITEMS, false);

	public static final RegistryObject<Block> JUNGLE_SHUTTER = registerBlock(
			"jungle_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), MINECRAFT_ITEMS);

	public static final RegistryObject<Block> OAK_SHUTTER = registerBlock(
			"oak_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), MINECRAFT_ITEMS);

	public static final RegistryObject<Block> SPRUCE_SHUTTER = registerBlock(
			"spruce_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), MINECRAFT_ITEMS);

	public static final RegistryObject<Block> WARPED_SHUTTER = registerBlock(
			"warped_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), MINECRAFT_ITEMS, false);

	public static final RegistryObject<Block> MANGROVE_SHUTTER = registerBlock(
			"mangrove_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), MINECRAFT_ITEMS);

	// outer_end
	public static final RegistryObject<Block> AZURE_SHUTTER = registerBlock(
			"azure_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_OUTER_END);

	// quark
	public static final RegistryObject<Block> BLOSSOM_SHUTTER = registerBlock(
			"blossom_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_QUARK);

	public static final RegistryObject<Block> BAMBOO_SHUTTER = registerBlock(
			"bamboo_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_QUARK);

	public static final RegistryObject<Block> ANCIENT_SHUTTER = registerBlock(
			"ancient_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_QUARK);

	// supplementaries
	public static final RegistryObject<Block> GOLD_SHUTTER = registerBlock(
			"gold_shutter", () -> new GoldShutter(
					BlockBehaviour.Properties.copy(Blocks.IRON_DOOR)), ITEMS_SUPPLEMENTARIES, false);

	public static final RegistryObject<Block> NETHERITE_SHUTTER = registerBlock(
			"netherite_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.IRON_DOOR)), ITEMS_SUPPLEMENTARIES, false);

	public static final RegistryObject<Block> LEAD_SHUTTER = registerBlock(
			"lead_shutter", () -> new LeadShutter(
					BlockBehaviour.Properties.copy(Blocks.IRON_DOOR)), ITEMS_SUPPLEMENTARIES, false);

	public static final RegistryObject<Block> SILVER_SHUTTER = registerBlock(
			"silver_shutter", () -> new SilverShutter(
					BlockBehaviour.Properties.copy(Blocks.IRON_DOOR)), ITEMS_SUPPLEMENTARIES, false);

	// twigs
	public static final RegistryObject<Block> STRIPPED_BAMBOO_SHUTTER = registerBlock(
			"stripped_bamboo_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_TWIGS);

	//autumnity
	public static final RegistryObject<Block> MAPLE_SHUTTER = registerBlock(
			"maple_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_AUTUMNITY);


	//environmental
	public static final RegistryObject<Block> CHERRY_SHUTTER = registerBlock(
			"cherry_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_ENVIRONMENTAL);

	public static final RegistryObject<Block> WILLOW_SHUTTER = registerBlock(
			"willow_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_ENVIRONMENTAL);

	public static final RegistryObject<Block> WISTERIA_SHUTTER = registerBlock(
			"wisteria_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_ENVIRONMENTAL);


	//snowy spirit
	public static final RegistryObject<Block> GINGERBREAD_SHUTTER = registerBlock(
			"gingerbread_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_SNOWY_SPIRIT);


	//update_aquatic
	public static final RegistryObject<Block> DRIFTWOOD_SHUTTER = registerBlock(
			"driftwood_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_UPGRADE_AQUATTIC);

	public static final RegistryObject<Block> RIVER_SHUTTER = registerBlock(
			"river_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)), ITEMS_UPGRADE_AQUATTIC);

	// Block
	private static <T extends Block> RegistryObject<T> registerBlock(
			String name, Supplier<T> block, DeferredRegister<Item> item_reg) {
		RegistryObject<T> to_return = BLOCKS.register(name, block);
		registerBlockItem(name, item_reg, to_return, true);
		return to_return;
	}

	private static <T extends Block> RegistryObject<T> registerBlock(
			String name, Supplier<T> block, DeferredRegister<Item> item_reg, boolean burnAble) {
		RegistryObject<T> to_return = BLOCKS.register(name, block);
		registerBlockItem(name, item_reg, to_return, burnAble);
		return to_return;
	}

	private static <T extends Block> RegistryObject<Item> registerBlockItem(
			String name, DeferredRegister<Item> item_reg, RegistryObject<T> registered_block, boolean burnAble) {
		if (burnAble) {
			return item_reg.register(name, () -> new BurnableItem(registered_block.get(), new Item.Properties().tab(ShutterMain.SHUTTER_TAB), 300));
		} else {
			return item_reg.register(name, () -> new BlockItem(registered_block.get(), new Item.Properties().tab(ShutterMain.SHUTTER_TAB)));
		}
	}

}
