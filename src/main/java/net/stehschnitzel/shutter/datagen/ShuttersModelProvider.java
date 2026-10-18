package net.stehschnitzel.shutter.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.stehschnitzel.shutter.ShutterMain;
import net.stehschnitzel.shutter.datagen.block.ShutterBlockModelGenerators;
import net.stehschnitzel.shutter.init.BlockInit;

public class ShuttersModelProvider extends ModelProvider {
    public ShuttersModelProvider(PackOutput output) {
        super(output, ShutterMain.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        ShutterBlockModelGenerators sG =
                new ShutterBlockModelGenerators(blockModels.blockStateOutput, itemModels.itemModelOutput, itemModels.modelOutput);

        blockModels.createAirLikeBlock(BlockInit.INTERACTION_SHUTTER_WOOD.get(), Blocks.AIR);
        blockModels.createAirLikeBlock(BlockInit.INTERACTION_SHUTTER_CRIMSON.get(), Blocks.AIR);
        blockModels.createAirLikeBlock(BlockInit.INTERACTION_SHUTTER_IRON.get(), Blocks.AIR);
        blockModels.createAirLikeBlock(BlockInit.INTERACTION_SHUTTER_WARPED.get(), Blocks.AIR);
        blockModels.createAirLikeBlock(BlockInit.INTERACTION_SHUTTER_COPPER.get(), Blocks.AIR);
        blockModels.createAirLikeBlock(BlockInit.INTERACTION_SHUTTER_NETHERITE.get(), Blocks.AIR);
        blockModels.createAirLikeBlock(BlockInit.INTERACTION_SHUTTER_GLASS.get(), Blocks.AIR);

        sG.createShutter(blockModels, BlockInit.GLASS_SHUTTER, Blocks.GLASS);


        sG.createShutter(blockModels, BlockInit.ACACIA_SHUTTER, Blocks.ACACIA_PLANKS);
        sG.createShutter(blockModels, BlockInit.BAMBOO_SHUTTER, Blocks.BAMBOO_BLOCK);
        sG.createShutter(blockModels, BlockInit.BIRCH_SHUTTER, Blocks.BIRCH_PLANKS);
        sG.createShutter(blockModels, BlockInit.CRIMSON_SHUTTER, Blocks.CRIMSON_PLANKS);
        sG.createShutter(blockModels, BlockInit.OAK_SHUTTER, Blocks.OAK_PLANKS);
        sG.createShutter(blockModels, BlockInit.DARK_OAK_SHUTTER, Blocks.DARK_OAK_PLANKS);
        sG.createShutter(blockModels, BlockInit.MANGROVE_SHUTTER, Blocks.MANGROVE_PLANKS);
        sG.createShutter(blockModels, BlockInit.JUNGLE_SHUTTER, Blocks.JUNGLE_PLANKS);
        sG.createShutter(blockModels, BlockInit.WARPED_SHUTTER, Blocks.WARPED_PLANKS);
        sG.createShutter(blockModels, BlockInit.IRON_SHUTTER, Blocks.IRON_BLOCK);
        sG.createShutter(blockModels, BlockInit.SPRUCE_SHUTTER, Blocks.SPRUCE_PLANKS);
        sG.createShutter(blockModels, BlockInit.PALE_OAK_SHUTTER, Blocks.PALE_OAK_PLANKS);

        sG.createShutter(blockModels, BlockInit.CHERRY_SHUTTER, Blocks.CHERRY_PLANKS);
        sG.createShutter(blockModels, BlockInit.GOLD_SHUTTER, Blocks.GOLD_BLOCK);
        sG.createShutter(blockModels, BlockInit.NETHERITE_SHUTTER, Blocks.NETHERITE_BLOCK);


        sG.createShutter(blockModels, BlockInit.COPPER_SHUTTER, Blocks.COPPER_BLOCK);
        sG.createShutter(blockModels, BlockInit.EXPOSED_COPPER_SHUTTER, Blocks.EXPOSED_COPPER);
        sG.createShutter(blockModels, BlockInit.OXIDIZED_COPPER_SHUTTER, Blocks.OXIDIZED_COPPER);
        sG.createShutter(blockModels, BlockInit.WEATHERED_COPPER_SHUTTER, Blocks.WEATHERED_COPPER);

        sG.createShutter(blockModels, BlockInit.WAXED_COPPER_SHUTTER, BlockInit.COPPER_SHUTTER, Blocks.COPPER_BLOCK);
        sG.createShutter(blockModels, BlockInit.WAXED_EXPOSED_COPPER_SHUTTER, BlockInit.EXPOSED_COPPER_SHUTTER, Blocks.EXPOSED_COPPER);
        sG.createShutter(blockModels, BlockInit.WAXED_OXIDIZED_COPPER_SHUTTER, BlockInit.OXIDIZED_COPPER_SHUTTER, Blocks.OXIDIZED_COPPER);
        sG.createShutter(blockModels, BlockInit.WAXED_WEATHERED_COPPER_SHUTTER, BlockInit.WEATHERED_COPPER_SHUTTER, Blocks.WEATHERED_COPPER);



        sG.createShutter(blockModels, BlockInit.PALM_SHUTTER);

        sG.createShutter(blockModels, BlockInit.MAPLE_SHUTTER);

        sG.createShutter(blockModels, BlockInit.CAVERN_AZALEA_SHUTTER);

        sG.createShutter(blockModels, BlockInit.AZALEA_SHUTTER);
        sG.createShutter(blockModels, BlockInit.COCONUT_SHUTTER);
        sG.createShutter(blockModels, BlockInit.FLOWERING_AZALEA_SHUTTER);
        sG.createShutter(blockModels, BlockInit.WALNUT_SHUTTER);

        sG.createShutter(blockModels, BlockInit.PLUM_SHUTTER);
        sG.createShutter(blockModels, BlockInit.WILLOW_SHUTTER);
        sG.createShutter(blockModels, BlockInit.WISTERIA_SHUTTER);
        sG.createShutter(blockModels, BlockInit.PINE_SHUTTER);

        sG.createShutter(blockModels, BlockInit.CYPRESS_SHUTTER);
        sG.createShutter(blockModels, BlockInit.MUDDY_OAK_SHUTTER);

//        sG.createShutter(blockModels, BlockInit.LEAD_SHUTTER);
//        sG.createShutter(blockModels, BlockInit.SILVER_SHUTTER);

        sG.createShutter(blockModels, BlockInit.BLOSSOM_SHUTTER);
        sG.createShutter(blockModels, BlockInit.ANCIENT_SHUTTER);
        sG.createShutter(blockModels, BlockInit.AZALEA_QUARK_SHUTTER);

        sG.createShutter(blockModels, BlockInit.GINGERBREAD_SHUTTER);

//        sG.createShutter(blockModels, BlockInit.POISE_SHUTTER);

//        sG.createShutter(blockModels, BlockInit.AZURE_SHUTTER);

        sG.createShutter(blockModels, BlockInit.STRIPPED_BAMBOO_SHUTTER, Blocks.BAMBOO_BLOCK);

        sG.createShutter(blockModels, BlockInit.DRIFTWOOD_SHUTTER);
        sG.createShutter(blockModels, BlockInit.RIVER_SHUTTER);

        sG.createShutter(blockModels, BlockInit.ASPEN_SHUTTER);
        sG.createShutter(blockModels, BlockInit.BLOOMING_PAPER_SHUTTER);
        sG.createShutter(blockModels, BlockInit.CEDAR_SHUTTER);
        sG.createShutter(blockModels, BlockInit.FIR_SHUTTER);
        sG.createShutter(blockModels, BlockInit.FRAMED_PAPER_SHUTTER);
        sG.createShutter(blockModels, BlockInit.GHAF_SHUTTER);
        sG.createShutter(blockModels, BlockInit.JOSHUA_SHUTTER);
        sG.createShutter(blockModels, BlockInit.LARCH_SHUTTER);
        sG.createShutter(blockModels, BlockInit.MAHOGANY_SHUTTER);
        sG.createShutter(blockModels, BlockInit.NAS_COCONUT_SHUTTER);
        sG.createShutter(blockModels, BlockInit.NAS_CYPRESS_SHUTTER);
        sG.createShutter(blockModels, BlockInit.NAS_MAPLE_SHUTTER);
        sG.createShutter(blockModels, BlockInit.NAS_WILLOW_SHUTTER);
        sG.createShutter(blockModels, BlockInit.NAS_WISTERIA_SHUTTER);
        sG.createShutter(blockModels, BlockInit.OLIVE_SHUTTER);
        sG.createShutter(blockModels, BlockInit.PALO_VERDE_SHUTTER);
        sG.createShutter(blockModels, BlockInit.PAPER_SHUTTER);
        sG.createShutter(blockModels, BlockInit.REDWOOD_SHUTTER);
        sG.createShutter(blockModels, BlockInit.SAXAUL_SHUTTER);
        sG.createShutter(blockModels, BlockInit.SUGI_SHUTTER);


    }
}
