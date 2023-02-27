package net.stehschnitzel.shutter.init;

import com.google.common.base.Supplier;

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

public class BlockInit {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister
			.create(ForgeRegistries.BLOCKS, ShutterMain.MODID);

	// create
	public static final RegistryObject<Block> GLASS_SHUTTER = registerBlock(
			"glass_shutter", () -> new Shutter(
					BlockBehaviour.Properties.of(Material.GLASS).sound(SoundType.GLASS).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));

	// ecologics
	public static final RegistryObject<Block> AZALEA_SHUTTER = BLOCKS
			.register("azalea_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));

	public static final RegistryObject<Block> COCONUT_SHUTTER = registerBlock(
			"coconut_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));

	public static final RegistryObject<Block> FLOWERING_AZALEA_SHUTTER = registerBlock(
			"flowering_azalea_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));

	public static final RegistryObject<Block> WALNUT_SHUTTER = registerBlock(
			"walnut_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));

	// endergetic
	public static final RegistryObject<Block> POISE_SHUTTER = registerBlock(
			"poise_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));

	// minecraft
	public static final RegistryObject<Block> ACACIA_SHUTTER = registerBlock(
			"acacia_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));

	public static final RegistryObject<Block> BIRCH_SHUTTER = registerBlock(
			"birch_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));

	public static final RegistryObject<Block> CRIMSON_SHUTTER = registerBlock(
			"crimson_shutter",
			() -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));

	public static final RegistryObject<Block> DARK_OAK_SHUTTER = registerBlock(
			"dark_oak_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));

	public static final RegistryObject<Block> IRON_SHUTTER = registerBlock(
			"iron_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.IRON_DOOR)));

	public static final RegistryObject<Block> JUNGLE_SHUTTER = registerBlock(
			"jungle_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));

	public static final RegistryObject<Block> OAK_SHUTTER = registerBlock(
			"oak_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));

	public static final RegistryObject<Block> SPRUCE_SHUTTER = registerBlock(
			"spruce_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));

	public static final RegistryObject<Block> WARPED_SHUTTER = registerBlock(
			"warped_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));

	// outer_end
	public static final RegistryObject<Block> AZURE_SHUTTER = registerBlock(
			"azure_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));

	// quark
	public static final RegistryObject<Block> BLOSSOM_SHUTTER = registerBlock(
			"blossom_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));

	// supplementaries
	public static final RegistryObject<Block> GOLD_SHUTTER = registerBlock(
			"gold_shutter", () -> new GoldShutter(
					BlockBehaviour.Properties.copy(Blocks.IRON_DOOR)));

	public static final RegistryObject<Block> NETHERITE_SHUTTER = registerBlock(
			"netherite_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.IRON_DOOR)));

	public static final RegistryObject<Block> LEAD_SHUTTER = registerBlock(
			"lead_shutter", () -> new LeadShutter(
					BlockBehaviour.Properties.copy(Blocks.IRON_DOOR)));

	public static final RegistryObject<Block> SILVER_SHUTTER = registerBlock(
			"silver_shutter", () -> new SilverShutter(
					BlockBehaviour.Properties.copy(Blocks.IRON_DOOR)));

	// twigs
	public static final RegistryObject<Block> STRIPPED_BAMBOO_SHUTTER = registerBlock(
			"stripped_bamboo_shutter", () -> new Shutter(
					BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));

	// Block
	private static <T extends Block> RegistryObject<T> registerBlock(
			String name, Supplier<T> block) {
		RegistryObject<T> to_return = BLOCKS.register(name, block);
		// registerBlockItem(name, to_return, tab, item);
		return to_return;
	}

}
