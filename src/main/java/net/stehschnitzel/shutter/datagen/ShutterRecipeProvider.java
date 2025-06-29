package net.stehschnitzel.shutter.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.mehvahdjukaar.snowyspirit.reg.ModRegistry;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
//import net.orcinus.goodending.init.GoodEndingBlocks;
//import net.orcinus.goodending.init.GoodEndingItems;
import net.stehschnitzel.shutter.init.BlockInit;
//import satisfy.beachparty.registry.ObjectRegistry;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ShutterRecipeProvider extends FabricRecipeProvider {

    public ShutterRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offersDefaultShutter(Items.ACACIA_SLAB, BlockInit.ACACIA_SHUTTER, exporter);
        offersDefaultShutter(Items.BIRCH_SLAB, BlockInit.BIRCH_SHUTTER, exporter);
        offersDefaultShutter(Items.CRIMSON_SLAB, BlockInit.CRIMSON_SHUTTER, exporter);
        offersDefaultShutter(Items.DARK_OAK_SLAB, BlockInit.DARK_OAK_SHUTTER, exporter);
        offersDefaultShutter(Items.JUNGLE_SLAB, BlockInit.JUNGLE_SHUTTER, exporter);
        offersDefaultShutter(Items.OAK_SLAB, BlockInit.OAK_SHUTTER, exporter);
        offersDefaultShutter(Items.SPRUCE_SLAB, BlockInit.SPRUCE_SHUTTER, exporter);
        offersDefaultShutter(Items.WARPED_SLAB, BlockInit.WARPED_SHUTTER, exporter);
        offersDefaultShutter(Items.MANGROVE_SLAB, BlockInit.MANGROVE_SHUTTER, exporter);
        offersDefaultShutter(Items.BAMBOO_SLAB, BlockInit.BAMBOO_SHUTTER, exporter);
        offersDefaultShutter(Items.CHERRY_SLAB, BlockInit.CHERRY_SHUTTER, exporter);
        offersDefaultShutter(Items.GLASS_PANE, BlockInit.GLASS_SHUTTER, exporter);
//        offersDefaultShutter(ObjectRegistry.PALM_SLAB.get().asItem(), BlockInit.PALM_SHUTTER, exporter);
//        offersDefaultShutter(((Block) ModBlocks.AZALEA_SLAB.get()).asItem(), BlockInit.AZALEA_SHUTTER, exporter);
//        offersDefaultShutter(ModBlocks.COCONUT_SLAB , BlockInit.COCONUT_SHUTTER, exporter);
//        offersDefaultShutter(ModBlocks.FLOWERING_AZALEA_SLAB , BlockInit.FLOWERING_AZALEA_SHUTTER, exporter);
//        offersDefaultShutter(ModBlocks.WALNUT_SLAB , BlockInit.WALNUT_SHUTTER, exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, BlockInit.GINGERBREAD_SHUTTER, 4)
                .pattern("##")
                .pattern("##")
                .input('#', ModRegistry.GINGERBREAD_FROSTED_BLOCK.get())
                .criterion(hasItem(ModRegistry.GINGERBREAD_FROSTED_BLOCK.get()), conditionsFromItem(ModRegistry.GINGERBREAD_FROSTED_BLOCK.get()))
                .offerTo(exporter);

        offerIngotShutter(Items.GOLD_INGOT, Items.GOLD_NUGGET, BlockInit.GOLD_SHUTTER, exporter);
        offerIngotShutter(Items.IRON_INGOT, Items.IRON_NUGGET, BlockInit.IRON_SHUTTER, exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, BlockInit.NETHERITE_SHUTTER)
                .input(BlockInit.GOLD_SHUTTER)
                .input(Items.NETHERITE_SCRAP)
                .criterion(hasItem(BlockInit.GOLD_SHUTTER), conditionsFromItem(BlockInit.GOLD_SHUTTER))
                .criterion(hasItem(Items.NETHERITE_SCRAP), conditionsFromItem(Items.NETHERITE_SCRAP))
                .offerTo(exporter, Identifier.of(getRecipeName(BlockInit.NETHERITE_SHUTTER)));

//        offersDefaultShutter(ModBlocks.AZALEA_SLAB, BlockInit.AZALEA_SHUTTER, exporter);
//        offersDefaultShutter(ModBlocks.COCONUT_SLAB, BlockInit.COCONUT_SHUTTER, exporter);
//        offersDefaultShutter(ModBlocks.FLOWERING_AZALEA_SLAB, BlockInit.FLOWERING_AZALEA_SHUTTER, exporter);
//        offersDefaultShutter(ModBlocks.WALNUT_SLAB, BlockInit.WALNUT_SHUTTER, exporter);


//        ingotShutter(OItems.LEAD_INGOT, OItems.LEAD_NUGGET, BlockInit.LEAD_SHUTTER);
//        ingotShutter(OItems.SILVER_INGOT, OItems.SILVER_NUGGET, BlockInit.SILVER_SHUTTER);
//        offersDefaultShutter(UABlocks.DRIFTWOOD_SLAB, BlockInit.DRIFTWOOD_SHUTTER, exporter);
//        offersDefaultShutter(UABlocks.RIVER_SLAB, BlockInit.RIVER_SHUTTER, exporter);
//        offersDefaultShutter(GoodEndingItems.CYPRESS_SLAB, BlockInit.CYPRESS_SHUTTER, exporter);
//        offersDefaultShutter(GoodEndingItems.MUDDY_OAK_SLAB, BlockInit.MUDDY_OAK_SHUTTER, exporter);

        offersDefaultShutter(Items.COPPER_BLOCK, BlockInit.COPPER_SHUTTER, 8, exporter);
        offersDefaultShutter(Items.WEATHERED_COPPER, BlockInit.WEATHERED_COPPER_SHUTTER, 8, exporter);

        waxed_shutter(BlockInit.COPPER_SHUTTER, BlockInit.WAXED_COPPER_SHUTTER, exporter);
        waxed_shutter(BlockInit.EXPOSED_COPPER_SHUTTER, BlockInit.WAXED_EXPOSED_COPPER_SHUTTER, exporter);
        waxed_shutter(BlockInit.OXIDIZED_COPPER_SHUTTER, BlockInit.WAXED_OXIDIZED_COPPER_SHUTTER, exporter);
        waxed_shutter(BlockInit.WEATHERED_COPPER_SHUTTER, BlockInit.WAXED_WEATHERED_COPPER_SHUTTER, exporter);
    }

    private void offerIngotShutter(Item inputIngot, Item inputNugget, Block outputItem, RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, outputItem, 2)
                .pattern("A_A")
                .pattern("A_A")
                .input('A', inputIngot)
                .input('_', inputNugget)
                .criterion(hasItem(inputIngot), conditionsFromItem(inputIngot))
                .criterion(hasItem(inputNugget), conditionsFromItem(inputNugget))
                .offerTo(exporter, Identifier.of(getRecipeName(outputItem)));
    }

    private void waxed_shutter(Block inputShutter, Block outputItem, RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, outputItem)
                .input(Items.HONEYCOMB)
                .input(inputShutter)
                .criterion(hasItem(inputShutter), conditionsFromItem(inputShutter))
                .criterion(hasItem(Items.HONEYCOMB), conditionsFromItem(Items.HONEYCOMB))
                .offerTo(exporter, Identifier.of(getRecipeName(outputItem)));
    }

    private void offersDefaultShutter(Item inputItem, Block outputItem, RecipeExporter exporter) {
        offersDefaultShutter(inputItem, outputItem, 2, exporter);
    }

    private void offersDefaultShutter(Item inputItem, Block outputItem, int count, RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, outputItem, count)
                .pattern("AAA")
                .pattern("AAA")
                .input('A', inputItem)
                .criterion(hasItem(inputItem), conditionsFromItem(inputItem))
                .offerTo(exporter, Identifier.of(getRecipeName(outputItem)));
    }
}
