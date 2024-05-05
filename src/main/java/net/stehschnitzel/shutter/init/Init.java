package net.stehschnitzel.shutter.init;

import com.google.common.base.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.stehschnitzel.shutter.ShutterMain;
import net.stehschnitzel.shutter.shutter.GoldShutter;
import net.stehschnitzel.shutter.shutter.LeadShutter;
import net.stehschnitzel.shutter.shutter.Shutter;
import net.stehschnitzel.shutter.shutter.SilverShutter;

public class Init {
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

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister
			.create(ForgeRegistries.BLOCKS, ShutterMain.MODID);

	// create
	public static final RegistryObject<Block> GLASS_SHUTTER = registerBlock(
			"glass_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)),
			ShutterMain.SHUTTER_TAB, ITEMS_CREATE);

	// ecologics
	public static final RegistryObject<Block> AZALEA_SHUTTER = registerBlock(
			"azalea_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)),
			ShutterMain.SHUTTER_TAB, ITEMS_ECOLOGICS);

	public static final RegistryObject<Block> COCONUT_SHUTTER = registerBlock(
			"coconut_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)),
			ShutterMain.SHUTTER_TAB, ITEMS_ECOLOGICS);

	public static final RegistryObject<Block> FLOWERING_AZALEA_SHUTTER = registerBlock(
			"flowering_azalea_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)),
			ShutterMain.SHUTTER_TAB, ITEMS_ECOLOGICS);

	public static final RegistryObject<Block> WALNUT_SHUTTER = registerBlock(
			"walnut_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)),
			ShutterMain.SHUTTER_TAB, ITEMS_ECOLOGICS);

	//endergetic
	public static final RegistryObject<Block> POISE_SHUTTER = registerBlock(
			"poise_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)),
			ShutterMain.SHUTTER_TAB, ITEMS_ENDERGETIC);
	
	// minecraft
	public static final RegistryObject<Block> ACACIA_SHUTTER = registerBlock(
			"acacia_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)),
			ShutterMain.SHUTTER_TAB, MINECRAFT_ITEMS);

	public static final RegistryObject<Block> BIRCH_SHUTTER = registerBlock(
			"birch_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)),
			ShutterMain.SHUTTER_TAB, MINECRAFT_ITEMS);

	public static final RegistryObject<Block> CRIMSON_SHUTTER = registerBlock(
			"crimson_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)),
			ShutterMain.SHUTTER_TAB, MINECRAFT_ITEMS);

	public static final RegistryObject<Block> DARK_OAK_SHUTTER = registerBlock(
			"dark_oak_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)),
			ShutterMain.SHUTTER_TAB, MINECRAFT_ITEMS);

	public static final RegistryObject<Block> IRON_SHUTTER = registerBlock(
			"iron_shutter",
			() -> new Shutter(BlockBehaviour.Properties.copy(Blocks.IRON_DOOR)),
			ShutterMain.SHUTTER_TAB, MINECRAFT_ITEMS);
	
	public static final RegistryObject<Block> JUNGLE_SHUTTER = registerBlock(
			"jungle_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)),
			ShutterMain.SHUTTER_TAB, MINECRAFT_ITEMS);

	public static final RegistryObject<Block> OAK_SHUTTER = registerBlock(
			"oak_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)),
			ShutterMain.SHUTTER_TAB, MINECRAFT_ITEMS);

	public static final RegistryObject<Block> SPRUCE_SHUTTER = registerBlock(
			"spruce_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)),
			ShutterMain.SHUTTER_TAB, MINECRAFT_ITEMS);

	public static final RegistryObject<Block> WARPED_SHUTTER = registerBlock(
			"warped_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)),
			ShutterMain.SHUTTER_TAB, MINECRAFT_ITEMS);

	// outer_end
	public static final RegistryObject<Block> AZUER_SHUTTER = registerBlock(
			"azuer_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)),
			ShutterMain.SHUTTER_TAB, ITEMS_OUTER_END);

	// quark
	public static final RegistryObject<Block> BLOSSOM_SHUTTER = registerBlock(
			"blossom_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)),
			ShutterMain.SHUTTER_TAB, ITEMS_QUARK);

	// supplementaries
	public static final RegistryObject<Block> GOLD_SHUTTER = registerBlock(
			"gold_shutter",
			() -> new GoldShutter(BlockBehaviour.Properties.copy(Blocks.IRON_DOOR)),
			ShutterMain.SHUTTER_TAB, ITEMS_SUPPLEMENTARIES);
	
	public static final RegistryObject<Block> NETHERITE_SHUTTER = registerBlock(
			"netherite_shutter",
			() -> new Shutter(BlockBehaviour.Properties.copy(Blocks.IRON_DOOR)),
			ShutterMain.SHUTTER_TAB, ITEMS_SUPPLEMENTARIES);
	
	public static final RegistryObject<Block> LEAD_SHUTTER = registerBlock(
			"lead_shutter",
			() -> new LeadShutter(
					BlockBehaviour.Properties.copy(Blocks.IRON_DOOR)),
			ShutterMain.SHUTTER_TAB, ITEMS_OREGANIZED);
	
	public static final RegistryObject<Block> SILVER_SHUTTER = registerBlock(
			"silver_shutter",
			() -> new SilverShutter(
					BlockBehaviour.Properties.copy(Blocks.IRON_DOOR)),
			ShutterMain.SHUTTER_TAB, ITEMS_OREGANIZED);
	
	//twigs
	public static final RegistryObject<Block> STRIPPED_BAMBOO_SHUTTER = registerBlock(
			"stripped_bamboo_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)),
			ShutterMain.SHUTTER_TAB, ITEMS_TWIGS);


	// Block
	private static <T extends Block> RegistryObject<T> registerBlock(
			String name, Supplier<T> block, CreativeModeTab tab,
			DeferredRegister<Item> item) {
		RegistryObject<T> to_return = BLOCKS.register(name, block);
		registerBlockItem(name, to_return, tab, item);
		return to_return;
	}

	// Items

	private static <T extends Block> RegistryObject<Item> registerBlockItem(
			String name, RegistryObject<T> block, CreativeModeTab tab,
			DeferredRegister<Item> item) {
		return item.register(name, () -> new BlockItem(block.get(),
				new Item.Properties().tab(tab)));
	}

}
