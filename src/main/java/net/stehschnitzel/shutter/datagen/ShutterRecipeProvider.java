package net.stehschnitzel.shutter.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.stehschnitzel.shutter.init.BlockInit;

import java.util.function.Consumer;

public class ShutterRecipeProvider extends FabricRecipeProvider {

    public ShutterRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        defaultShutter(Items.ACACIA_SLAB, BlockInit.ACACIA_SHUTTER).offerTo(exporter);
        defaultShutter(Items.BIRCH_SLAB, BlockInit.BIRCH_SHUTTER).offerTo(exporter);
        defaultShutter(Items.CRIMSON_SLAB, BlockInit.CRIMSON_SHUTTER).offerTo(exporter);
        defaultShutter(Items.DARK_OAK_SLAB, BlockInit.DARK_OAK_SHUTTER).offerTo(exporter);
        defaultShutter(Items.JUNGLE_SLAB, BlockInit.JUNGLE_SHUTTER).offerTo(exporter);
        defaultShutter(Items.OAK_SLAB, BlockInit.OAK_SHUTTER).offerTo(exporter);
        defaultShutter(Items.SPRUCE_SLAB, BlockInit.SPRUCE_SHUTTER).offerTo(exporter);
        defaultShutter(Items.WARPED_SLAB, BlockInit.WARPED_SHUTTER).offerTo(exporter);
        defaultShutter(Items.MANGROVE_SLAB, BlockInit.MANGROVE_SHUTTER).offerTo(exporter);
        defaultShutter(Items.BAMBOO_SLAB, BlockInit.BAMBOO_SHUTTER).offerTo(exporter);
        defaultShutter(Items.CHERRY_SLAB, BlockInit.CHERRY_SHUTTER).offerTo(exporter);
        defaultShutter(Items.GLASS_PANE, BlockInit.GLASS_SHUTTER).offerTo(exporter);

        ingotShutter(Items.GOLD_INGOT, Items.GOLD_NUGGET, BlockInit.GOLD_SHUTTER).offerTo(exporter);
        ingotShutter(Items.IRON_INGOT, Items.IRON_NUGGET, BlockInit.IRON_SHUTTER).offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, BlockInit.NETHERITE_SHUTTER)
                .input(BlockInit.GOLD_SHUTTER)
                .input(Items.NETHERITE_SCRAP)
                .criterion(hasItem(BlockInit.GOLD_SHUTTER), conditionsFromItem(BlockInit.GOLD_SHUTTER))
                .criterion(hasItem(Items.NETHERITE_SCRAP), conditionsFromItem(Items.NETHERITE_SCRAP))
                .offerTo(exporter);

//        defaultShutter(ModBlocks.AZALEA_SLAB, BlockInit.AZALEA_SHUTTER).offerTo(exporter);
//        defaultShutter(ModBlocks.COCONUT_SLAB, BlockInit.COCONUT_SHUTTER).offerTo(exporter);
//        defaultShutter(ModBlocks.FLOWERING_AZALEA_SLAB, BlockInit.FLOWERING_AZALEA_SHUTTER).offerTo(exporter);
//        defaultShutter(ModBlocks.WALNUT_SLAB, BlockInit.WALNUT_SHUTTER).offerTo(exporter);

//        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BlockInit.GINGERBREAD_SHUTTER, 4)
//                .pattern("##")
//                .pattern("##")
//                .input('#', ModRegistry.GINGERBREAD_FROSTED_BLOCK)
//                .criterion( (ModRegistry.GINGERBREAD_FROSTED_BLOCK), conditionsFromItem(ModRegistry.GINGERBREAD_FROSTED_BLOCK))
//                .offerTo(exporter);


//        ingotShutter(OItems.LEAD_INGOT, OItems.LEAD_NUGGET, BlockInit.LEAD_SHUTTER);
//        ingotShutter(OItems.SILVER_INGOT, OItems.SILVER_NUGGET, BlockInit.SILVER_SHUTTER);
//        defaultShutter(UABlocks.DRIFTWOOD_SLAB, BlockInit.DRIFTWOOD_SHUTTER).offerTo(exporter);
//        defaultShutter(UABlocks.RIVER_SLAB, BlockInit.RIVER_SHUTTER).offerTo(exporter);
//        defaultShutter(GoodEndingBlocks.CYPRESS_SLAB, BlockInit.CYPRESS_SHUTTER).offerTo(exporter);   //TODO doesnt work because of Good Ending
//        defaultShutter(GoodEndingBlocks.MUDDY_OAK_SLAB, BlockInit.MUDDY_OAK_SHUTTER).offerTo(exporter);

        defaultShutter(Items.COPPER_BLOCK, BlockInit.COPPER_SHUTTER, 8).offerTo(exporter);
        defaultShutter(Items.WEATHERED_COPPER, BlockInit.WEATHERED_COPPER_SHUTTER, 8).offerTo(exporter);

        waxed_shutter(BlockInit.COPPER_SHUTTER, BlockInit.WAXED_COPPER_SHUTTER).offerTo(exporter);
        waxed_shutter(BlockInit.EXPOSED_COPPER_SHUTTER, BlockInit.WAXED_EXPOSED_COPPER_SHUTTER).offerTo(exporter);
        waxed_shutter(BlockInit.OXIDIZED_COPPER_SHUTTER, BlockInit.WAXED_OXIDIZED_COPPER_SHUTTER).offerTo(exporter);
        waxed_shutter(BlockInit.WEATHERED_COPPER_SHUTTER, BlockInit.WAXED_WEATHERED_COPPER_SHUTTER).offerTo(exporter);
    }

    private ShapedRecipeJsonBuilder ingotShutter(Item inputIngot, Item inputNugget, Block outputItem) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, outputItem, 2)
                .pattern("A_A")
                .pattern("A_A")
                .input('A', inputIngot)
                .input('_', inputNugget)
                .criterion(hasItem(inputIngot), conditionsFromItem(inputIngot))
                .criterion(hasItem(inputNugget), conditionsFromItem(inputNugget));
    }

    private ShapelessRecipeJsonBuilder waxed_shutter(Block inputShutter, Block ouputItem) {
        return ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ouputItem)
                .input(Items.HONEYCOMB)
                .input(inputShutter)
                .criterion(hasItem(inputShutter), conditionsFromItem(inputShutter))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB));
    }

    private ShapedRecipeJsonBuilder defaultShutter(Item inputItem, Block outputItem) {
        return defaultShutter(inputItem, outputItem, 2);
    }

    private ShapedRecipeJsonBuilder defaultShutter(Item inputItem, Block outputItem, int count) {
        return ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, outputItem, count)
                .pattern("AAA")
                .pattern("AAA")
                .input('A', inputItem)
                .criterion(hasItem(inputItem), conditionsFromItem(inputItem));
    }
}
