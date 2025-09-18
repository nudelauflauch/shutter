package net.stehschnitzel.shutter.datagen;


import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Blocks;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.stehschnitzel.shutter.datagen.blocks.ShutterBlockModelGenerators;
import net.stehschnitzel.shutter.init.BlockInit;

public class ShutterModelProvider extends FabricModelProvider {

    public ShutterModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
//only block models item models will be created automatically
        ShutterBlockModelGenerators shutterGenerator =
                new ShutterBlockModelGenerators(blockStateModelGenerator.blockStateCollector,
                        blockStateModelGenerator.itemModelOutput,
                        blockStateModelGenerator.modelCollector);

//        shutterBuilder(BlockInit.MAPLE_SHUTTER);
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.GLASS_SHUTTER, Blocks.GLASS); //cutout
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.AZALEA_SHUTTER);
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.COCONUT_SHUTTER);
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.FLOWERING_AZALEA_SHUTTER);
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.WALNUT_SHUTTER);
//        shutterBuilder(BlockInit.POISE_SHUTTER);
//        shutterBuilder(BlockInit.PLUM_SHUTTER);
//        shutterBuilder(BlockInit.WILLOW_SHUTTER);
//        shutterBuilder(BlockInit.WISTERIA_SHUTTER);
//        shutterBuilder(BlockInit.PINE_SHUTTER);
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.CYPRESS_SHUTTER);
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.MUDDY_OAK_SHUTTER);

        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.PALM_SHUTTER);


        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.ACACIA_SHUTTER, Blocks.ACACIA_PLANKS);
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.BAMBOO_SHUTTER, Blocks.BAMBOO_BLOCK);
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.BIRCH_SHUTTER, Blocks.BIRCH_PLANKS);
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.CRIMSON_SHUTTER, Blocks.CRIMSON_PLANKS);
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.OAK_SHUTTER, Blocks.OAK_PLANKS);
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.DARK_OAK_SHUTTER, Blocks.DARK_OAK_PLANKS);
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.MANGROVE_SHUTTER, Blocks.MANGROVE_PLANKS);
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.JUNGLE_SHUTTER, Blocks.JUNGLE_PLANKS);
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.WARPED_SHUTTER, Blocks.WARPED_PLANKS);
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.IRON_SHUTTER, Blocks.IRON_BLOCK);
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.SPRUCE_SHUTTER, Blocks.SPRUCE_PLANKS);

//        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.LEAD_SHUTTER);
//        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.SILVER_SHUTTER);
//        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.RIVER_SHUTTER);
//        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.DRIFTWOOD_SHUTTER);
//        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.BLOSSOM_SHUTTER);
//        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.AZURE_SHUTTER);
//        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.ANCIENT_SHUTTER);
//        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.AZALEA_QUARK_SHUTTER);
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.GINGERBREAD_SHUTTER);
//        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.CAVERN_AZALEA_SHUTTER);
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.CHERRY_SHUTTER, Blocks.CHERRY_PLANKS);
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.GOLD_SHUTTER, Blocks.GOLD_BLOCK);
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.NETHERITE_SHUTTER, Blocks.NETHERITE_BLOCK);

        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.STRIPPED_BAMBOO_SHUTTER, Blocks.BAMBOO_PLANKS);

        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.COPPER_SHUTTER, Blocks.COPPER_BLOCK);
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.EXPOSED_COPPER_SHUTTER, Blocks.EXPOSED_COPPER);
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.OXIDIZED_COPPER_SHUTTER, Blocks.OXIDIZED_COPPER);
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.WEATHERED_COPPER_SHUTTER, Blocks.WEATHERED_COPPER);

        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.WAXED_COPPER_SHUTTER, BlockInit.COPPER_SHUTTER, Blocks.COPPER_BLOCK);
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.WAXED_EXPOSED_COPPER_SHUTTER, BlockInit.EXPOSED_COPPER_SHUTTER, Blocks.EXPOSED_COPPER);
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.WAXED_OXIDIZED_COPPER_SHUTTER, BlockInit.OXIDIZED_COPPER_SHUTTER, Blocks.OXIDIZED_COPPER);
        shutterGenerator.createShutter(blockStateModelGenerator, BlockInit.WAXED_WEATHERED_COPPER_SHUTTER, BlockInit.WEATHERED_COPPER_SHUTTER, Blocks.WEATHERED_COPPER);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}