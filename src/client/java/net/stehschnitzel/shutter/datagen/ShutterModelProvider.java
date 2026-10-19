package net.stehschnitzel.shutter.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.world.level.block.Blocks;
import net.stehschnitzel.shutter.datagen.blocks.ShutterBlockModelGenerators;
import net.stehschnitzel.shutter.init.BlockInit;

public class ShutterModelProvider extends FabricModelProvider {

    public ShutterModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        //only block models item models will be created automatically
        ShutterBlockModelGenerators shutterGenerator =
                new ShutterBlockModelGenerators(blockModelGenerators.blockStateOutput,
                        blockModelGenerators.itemModelOutput,
                        blockModelGenerators.modelOutput);

//        shutterBuilder(BlockInit.MAPLE_SHUTTER);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.GLASS_SHUTTER, Blocks.GLASS); //cutout
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.AZALEA_SHUTTER);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.COCONUT_SHUTTER);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.FLOWERING_AZALEA_SHUTTER);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.WALNUT_SHUTTER);
//        shutterBuilder(BlockInit.POISE_SHUTTER);
//        shutterBuilder(BlockInit.PLUM_SHUTTER);
//        shutterBuilder(BlockInit.WILLOW_SHUTTER);
//        shutterBuilder(BlockInit.WISTERIA_SHUTTER);
//        shutterBuilder(BlockInit.PINE_SHUTTER);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.CYPRESS_SHUTTER);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.MUDDY_OAK_SHUTTER);

        shutterGenerator.createShutter(blockModelGenerators, BlockInit.PALM_SHUTTER);


        shutterGenerator.createShutter(blockModelGenerators, BlockInit.ACACIA_SHUTTER, Blocks.ACACIA_PLANKS);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.BAMBOO_SHUTTER, Blocks.BAMBOO_BLOCK);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.BIRCH_SHUTTER, Blocks.BIRCH_PLANKS);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.CRIMSON_SHUTTER, Blocks.CRIMSON_PLANKS);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.OAK_SHUTTER, Blocks.OAK_PLANKS);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.DARK_OAK_SHUTTER, Blocks.DARK_OAK_PLANKS);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.MANGROVE_SHUTTER, Blocks.MANGROVE_PLANKS);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.JUNGLE_SHUTTER, Blocks.JUNGLE_PLANKS);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.WARPED_SHUTTER, Blocks.WARPED_PLANKS);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.IRON_SHUTTER, Blocks.IRON_BLOCK);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.SPRUCE_SHUTTER, Blocks.SPRUCE_PLANKS);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.PALE_OAK_SHUTTER, Blocks.PALE_OAK_PLANKS);

//        shutterGenerator.createShutter(blockModelGenerators, BlockInit.LEAD_SHUTTER);
//        shutterGenerator.createShutter(blockModelGenerators, BlockInit.SILVER_SHUTTER);
//        shutterGenerator.createShutter(blockModelGenerators, BlockInit.RIVER_SHUTTER);
//        shutterGenerator.createShutter(blockModelGenerators, BlockInit.DRIFTWOOD_SHUTTER);
//        shutterGenerator.createShutter(blockModelGenerators, BlockInit.BLOSSOM_SHUTTER);
//        shutterGenerator.createShutter(blockModelGenerators, BlockInit.AZURE_SHUTTER);
//        shutterGenerator.createShutter(blockModelGenerators, BlockInit.ANCIENT_SHUTTER);
//        shutterGenerator.createShutter(blockModelGenerators, BlockInit.AZALEA_QUARK_SHUTTER);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.GINGERBREAD_SHUTTER);
//        shutterGenerator.createShutter(blockModelGenerators, BlockInit.CAVERN_AZALEA_SHUTTER);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.CHERRY_SHUTTER, Blocks.CHERRY_PLANKS);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.GOLD_SHUTTER, Blocks.GOLD_BLOCK);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.NETHERITE_SHUTTER, Blocks.NETHERITE_BLOCK);

        shutterGenerator.createShutter(blockModelGenerators, BlockInit.STRIPPED_BAMBOO_SHUTTER, Blocks.BAMBOO_PLANKS);

        shutterGenerator.createShutter(blockModelGenerators, BlockInit.COPPER_SHUTTER, Blocks.COPPER_BLOCK);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.EXPOSED_COPPER_SHUTTER, Blocks.EXPOSED_COPPER);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.OXIDIZED_COPPER_SHUTTER, Blocks.OXIDIZED_COPPER);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.WEATHERED_COPPER_SHUTTER, Blocks.WEATHERED_COPPER);

        shutterGenerator.createShutter(blockModelGenerators, BlockInit.WAXED_COPPER_SHUTTER, BlockInit.COPPER_SHUTTER, Blocks.COPPER_BLOCK);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.WAXED_EXPOSED_COPPER_SHUTTER, BlockInit.EXPOSED_COPPER_SHUTTER, Blocks.EXPOSED_COPPER);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.WAXED_OXIDIZED_COPPER_SHUTTER, BlockInit.OXIDIZED_COPPER_SHUTTER, Blocks.OXIDIZED_COPPER);
        shutterGenerator.createShutter(blockModelGenerators, BlockInit.WAXED_WEATHERED_COPPER_SHUTTER, BlockInit.WEATHERED_COPPER_SHUTTER, Blocks.WEATHERED_COPPER);

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        
    }
}