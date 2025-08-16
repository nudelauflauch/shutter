package net.stehschnitzel.shutter.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.stehschnitzel.shutter.ShutterMain;
import net.stehschnitzel.shutter.datagen.blocks.ShutterBlockModelGenerators;
import net.stehschnitzel.shutter.init.BlockInit;

public class ShutterModelProvider extends ModelProvider {

    public ShutterModelProvider(PackOutput output) {
        super(output, ShutterMain.MOD_ID);
    }

    @Override
    public void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        //only block models item models will be created automatically
        ShutterBlockModelGenerators shutterGenerator = new ShutterBlockModelGenerators(blockModels.blockStateOutput, blockModels.itemModelOutput, blockModels.modelOutput);


//        shutterBuilder(BlockInit.MAPLE_SHUTTER);
        shutterGenerator.createShutter(blockModels, BlockInit.GLASS_SHUTTER, Blocks.GLASS, "cutout");
//        shutterBuilder(BlockInit.AZALEA_SHUTTER);
//        shutterBuilder(BlockInit.COCONUT_SHUTTER);
//        shutterBuilder(BlockInit.FLOWERING_AZALEA_SHUTTER);
//        shutterBuilder(BlockInit.WALNUT_SHUTTER);
//        shutterBuilder(BlockInit.POISE_SHUTTER);
//        shutterBuilder(BlockInit.PLUM_SHUTTER);
//        shutterBuilder(BlockInit.WILLOW_SHUTTER);
//        shutterBuilder(BlockInit.WISTERIA_SHUTTER);
//        shutterBuilder(BlockInit.PINE_SHUTTER);
//        shutterBuilder(BlockInit.CYPRESS_SHUTTER);
//        shutterBuilder(BlockInit.MUDDY_OAK_SHUTTER);

//        shutterBuilder(BlockInit.PALM_SHUTTER);


        shutterGenerator.createShutter(blockModels, BlockInit.ACACIA_SHUTTER, Blocks.ACACIA_PLANKS);
        shutterGenerator.createShutter(blockModels, BlockInit.BAMBOO_SHUTTER, Blocks.BAMBOO_BLOCK);
        shutterGenerator.createShutter(blockModels, BlockInit.BIRCH_SHUTTER, Blocks.BIRCH_PLANKS);
        shutterGenerator.createShutter(blockModels, BlockInit.CRIMSON_SHUTTER, Blocks.CRIMSON_PLANKS);
        shutterGenerator.createShutter(blockModels, BlockInit.OAK_SHUTTER, Blocks.OAK_PLANKS);
        shutterGenerator.createShutter(blockModels, BlockInit.DARK_OAK_SHUTTER, Blocks.DARK_OAK_PLANKS);
        shutterGenerator.createShutter(blockModels, BlockInit.MANGROVE_SHUTTER, Blocks.MANGROVE_PLANKS);
        shutterGenerator.createShutter(blockModels, BlockInit.JUNGLE_SHUTTER, Blocks.JUNGLE_PLANKS);
        shutterGenerator.createShutter(blockModels, BlockInit.WARPED_SHUTTER, Blocks.WARPED_PLANKS);
        shutterGenerator.createShutter(blockModels, BlockInit.IRON_SHUTTER, Blocks.IRON_BLOCK);
        shutterGenerator.createShutter(blockModels, BlockInit.SPRUCE_SHUTTER, Blocks.SPRUCE_PLANKS);

//        shutterGenerator.createShutter(blockModels, BlockInit.LEAD_SHUTTER);
//        shutterGenerator.createShutter(blockModels, BlockInit.SILVER_SHUTTER);
//        shutterGenerator.createShutter(blockModels, BlockInit.RIVER_SHUTTER);
//        shutterGenerator.createShutter(blockModels, BlockInit.DRIFTWOOD_SHUTTER);
//        shutterGenerator.createShutter(blockModels, BlockInit.BLOSSOM_SHUTTER);
//        shutterGenerator.createShutter(blockModels, BlockInit.AZURE_SHUTTER);
//        shutterGenerator.createShutter(blockModels, BlockInit.ANCIENT_SHUTTER);
//        shutterGenerator.createShutter(blockModels, BlockInit.AZALEA_QUARK_SHUTTER);
//        shutterGenerator.createShutter(blockModels, BlockInit.GINGERBREAD_SHUTTER);
//        shutterGenerator.createShutter(blockModels, BlockInit.CAVERN_AZALEA_SHUTTER);
        shutterGenerator.createShutter(blockModels, BlockInit.CHERRY_SHUTTER, Blocks.CHERRY_PLANKS);
        shutterGenerator.createShutter(blockModels, BlockInit.GOLD_SHUTTER, Blocks.GOLD_BLOCK);
        shutterGenerator.createShutter(blockModels, BlockInit.NETHERITE_SHUTTER, Blocks.NETHERITE_BLOCK);

//        shutterGenerator.createShutter(blockModels, BlockInit.STRIPPED_BAMBOO_SHUTTER, "block/bamboo_planks");

        shutterGenerator.createShutter(blockModels, BlockInit.COPPER_SHUTTER, Blocks.COPPER_BLOCK);
        shutterGenerator.createShutter(blockModels, BlockInit.EXPOSED_COPPER_SHUTTER, Blocks.EXPOSED_COPPER);
        shutterGenerator.createShutter(blockModels, BlockInit.OXIDIZED_COPPER_SHUTTER, Blocks.OXIDIZED_COPPER);
        shutterGenerator.createShutter(blockModels, BlockInit.WEATHERED_COPPER_SHUTTER, Blocks.WEATHERED_COPPER);

        shutterGenerator.createShutter(blockModels, BlockInit.WAXED_COPPER_SHUTTER, BlockInit.COPPER_SHUTTER, Blocks.COPPER_BLOCK);
        shutterGenerator.createShutter(blockModels, BlockInit.WAXED_EXPOSED_COPPER_SHUTTER, BlockInit.EXPOSED_COPPER_SHUTTER, Blocks.EXPOSED_COPPER);
        shutterGenerator.createShutter(blockModels, BlockInit.WAXED_OXIDIZED_COPPER_SHUTTER, BlockInit.OXIDIZED_COPPER_SHUTTER, Blocks.OXIDIZED_COPPER);
        shutterGenerator.createShutter(blockModels, BlockInit.WAXED_WEATHERED_COPPER_SHUTTER, BlockInit.WEATHERED_COPPER_SHUTTER, Blocks.WEATHERED_COPPER);
    }
}