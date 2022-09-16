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
import net.stehschnitzel.shutter.shutter.Shutter;

public class Init {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister
			.create(ForgeRegistries.ITEMS, ShutterMain.MODID);

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister
			.create(ForgeRegistries.BLOCKS, ShutterMain.MODID);

	public static final RegistryObject<Block> OAK_SHUTTER = registerBlock(
			"oak_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)),
			ShutterMain.SHUTTER_TAB);

	public static final RegistryObject<Block> ACACIA_SHUTTER = registerBlock(
			"acacia_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)),
			ShutterMain.SHUTTER_TAB);

	public static final RegistryObject<Block> BIRCH_SHUTTER = registerBlock(
			"birch_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)),
			ShutterMain.SHUTTER_TAB);

	public static final RegistryObject<Block> CRIMSON_SHUTTER = registerBlock(
			"crimson_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)),
			ShutterMain.SHUTTER_TAB);

	public static final RegistryObject<Block> DARK_OAK_SHUTTER = registerBlock(
			"dark_oak_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)),
			ShutterMain.SHUTTER_TAB);

	public static final RegistryObject<Block> IRON_SHUTTER = registerBlock(
			"iron_shutter",
			() -> new Shutter(BlockBehaviour.Properties.copy(Blocks.IRON_DOOR)),
			ShutterMain.SHUTTER_TAB);

	public static final RegistryObject<Block> JUNGLE_SHUTTER = registerBlock(
			"jungle_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)),
			ShutterMain.SHUTTER_TAB);

	public static final RegistryObject<Block> SPRUCE_SHUTTER = registerBlock(
			"spruce_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)),
			ShutterMain.SHUTTER_TAB);

	public static final RegistryObject<Block> WARPED_SHUTTER = registerBlock(
			"warped_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)),
			ShutterMain.SHUTTER_TAB);

	// Block
	private static <T extends Block> RegistryObject<T> registerBlock(
			String name, Supplier<T> block, CreativeModeTab tab) {
		RegistryObject<T> to_return = BLOCKS.register(name, block);
		registerBlockItem(name, to_return, tab);
		return to_return;
	}

	// Items

	private static <T extends Block> RegistryObject<Item> registerBlockItem(
			String name, RegistryObject<T> block, CreativeModeTab tab) {
		return ITEMS.register(name, () -> new BlockItem(block.get(),
				new Item.Properties().tab(tab)));
	}

}
