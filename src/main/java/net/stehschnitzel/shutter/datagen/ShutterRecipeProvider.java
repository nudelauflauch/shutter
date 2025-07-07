package net.stehschnitzel.shutter.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
//import net.mehvahdjukaar.snowyspirit.reg.ModRegistry;
import net.minecraft.block.Block;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
//import net.orcinus.goodending.init.GoodEndingBlocks;
//import net.orcinus.goodending.init.GoodEndingItems;
import net.stehschnitzel.shutter.ShutterMain;
import net.stehschnitzel.shutter.init.BlockInit;
//import satisfy.beachparty.registry.ObjectRegistry;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ShutterRecipeProvider extends FabricRecipeProvider {

    public ShutterRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                offersDefaultShutter(Items.ACACIA_SLAB, BlockInit.ACACIA_SHUTTER, recipeExporter, this);
                offersDefaultShutter(Items.BIRCH_SLAB, BlockInit.BIRCH_SHUTTER, recipeExporter, this);
                offersDefaultShutter(Items.CRIMSON_SLAB, BlockInit.CRIMSON_SHUTTER, recipeExporter, this);
                offersDefaultShutter(Items.DARK_OAK_SLAB, BlockInit.DARK_OAK_SHUTTER, recipeExporter, this);
                offersDefaultShutter(Items.JUNGLE_SLAB, BlockInit.JUNGLE_SHUTTER, recipeExporter, this);
                offersDefaultShutter(Items.OAK_SLAB, BlockInit.OAK_SHUTTER, recipeExporter, this);
                offersDefaultShutter(Items.SPRUCE_SLAB, BlockInit.SPRUCE_SHUTTER, recipeExporter, this);
                offersDefaultShutter(Items.WARPED_SLAB, BlockInit.WARPED_SHUTTER, recipeExporter, this);
                offersDefaultShutter(Items.MANGROVE_SLAB, BlockInit.MANGROVE_SHUTTER, recipeExporter, this);
                offersDefaultShutter(Items.BAMBOO_SLAB, BlockInit.BAMBOO_SHUTTER, recipeExporter, this);
                offersDefaultShutter(Items.CHERRY_SLAB, BlockInit.CHERRY_SHUTTER, recipeExporter, this);
                offersDefaultShutter(Items.GLASS_PANE, BlockInit.GLASS_SHUTTER, recipeExporter, this);
//        offersDefaultShutter(ObjectRegistry.PALM_SLAB.get().asItem(), BlockInit.PALM_SHUTTER, recipeExporter, this);
//        offersDefaultShutter(((Block) ModBlocks.AZALEA_SLAB.get()).asItem(), BlockInit.AZALEA_SHUTTER, recipeExporter, this);
//        offersDefaultShutter(ModBlocks.COCONUT_SLAB , BlockInit.COCONUT_SHUTTER, recipeExporter, this);
//        offersDefaultShutter(ModBlocks.FLOWERING_AZALEA_SLAB , BlockInit.FLOWERING_AZALEA_SHUTTER, recipeExporter, this);
//        offersDefaultShutter(ModBlocks.WALNUT_SLAB , BlockInit.WALNUT_SHUTTER, recipeExporter, this);

//                createShaped(RecipeCategory.MISC, BlockInit.GINGERBREAD_SHUTTER, 4)
//                        .pattern("##")
//                        .pattern("##")
//                        .input('#', ModRegistry.GINGERBREAD_FROSTED_BLOCK.get())
//                        .criterion(hasItem(ModRegistry.GINGERBREAD_FROSTED_BLOCK.get()), conditionsFromItem(ModRegistry.GINGERBREAD_FROSTED_BLOCK.get()))
//                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(ShutterMain.MOD_ID, "gingerbread_shutter")));

                offerIngotShutter(Items.GOLD_INGOT, Items.GOLD_NUGGET, BlockInit.GOLD_SHUTTER, recipeExporter, this);
                offerIngotShutter(Items.IRON_INGOT, Items.IRON_NUGGET, BlockInit.IRON_SHUTTER, recipeExporter, this);

                createShapeless(RecipeCategory.MISC, BlockInit.NETHERITE_SHUTTER)
                        .input(BlockInit.GOLD_SHUTTER)
                        .input(Items.NETHERITE_SCRAP)
                        .criterion(hasItem(BlockInit.GOLD_SHUTTER), conditionsFromItem(BlockInit.GOLD_SHUTTER))
                        .criterion(hasItem(Items.NETHERITE_SCRAP), conditionsFromItem(Items.NETHERITE_SCRAP))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(ShutterMain.MOD_ID, "netherite_shutter")));

//        offersDefaultShutter(ModBlocks.AZALEA_SLAB, BlockInit.AZALEA_SHUTTER, recipeExporter, this);
//        offersDefaultShutter(ModBlocks.COCONUT_SLAB, BlockInit.COCONUT_SHUTTER, recipeExporter, this);
//        offersDefaultShutter(ModBlocks.FLOWERING_AZALEA_SLAB, BlockInit.FLOWERING_AZALEA_SHUTTER, recipeExporter, this);
//        offersDefaultShutter(ModBlocks.WALNUT_SLAB, BlockInit.WALNUT_SHUTTER, recipeExporter, this);


//        ingotShutter(OItems.LEAD_INGOT, OItems.LEAD_NUGGET, BlockInit.LEAD_SHUTTER, this);
//        ingotShutter(OItems.SILVER_INGOT, OItems.SILVER_NUGGET, BlockInit.SILVER_SHUTTER, this);
//        offersDefaultShutter(UABlocks.DRIFTWOOD_SLAB, BlockInit.DRIFTWOOD_SHUTTER, recipeExporter, this);
//        offersDefaultShutter(UABlocks.RIVER_SLAB, BlockInit.RIVER_SHUTTER, recipeExporter, this);
//        offersDefaultShutter(GoodEndingItems.CYPRESS_SLAB, BlockInit.CYPRESS_SHUTTER, recipeExporter, this);
//        offersDefaultShutter(GoodEndingItems.MUDDY_OAK_SLAB, BlockInit.MUDDY_OAK_SHUTTER, recipeExporter, this);

                offersDefaultShutter(Items.COPPER_BLOCK, BlockInit.COPPER_SHUTTER, 8, recipeExporter, this);
                offersDefaultShutter(Items.WEATHERED_COPPER, BlockInit.WEATHERED_COPPER_SHUTTER, 8, recipeExporter, this);

                waxed_shutter(BlockInit.COPPER_SHUTTER, BlockInit.WAXED_COPPER_SHUTTER, recipeExporter, this);
                waxed_shutter(BlockInit.EXPOSED_COPPER_SHUTTER, BlockInit.WAXED_EXPOSED_COPPER_SHUTTER, recipeExporter, this);
                waxed_shutter(BlockInit.OXIDIZED_COPPER_SHUTTER, BlockInit.WAXED_OXIDIZED_COPPER_SHUTTER, recipeExporter, this);
                waxed_shutter(BlockInit.WEATHERED_COPPER_SHUTTER, BlockInit.WAXED_WEATHERED_COPPER_SHUTTER, recipeExporter, this);
            }
        };
    }

    @Override
    public String getName() {
        return "";
    }

    private void offerIngotShutter(Item inputIngot, Item inputNugget, Block outputItem, RecipeExporter exporter, RecipeGenerator generator) {
        generator.createShaped(RecipeCategory.MISC, outputItem, 2)
                .pattern("A_A")
                .pattern("A_A")
                .input('A', inputIngot)
                .input('_', inputNugget)
                .criterion(generator.hasItem(inputIngot), generator.conditionsFromItem(inputIngot))
                .criterion(generator.hasItem(inputNugget), generator.conditionsFromItem(inputNugget))
                .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(ShutterMain.MOD_ID, generator.getRecipeName(outputItem))));
    }

    private void waxed_shutter(Block inputShutter, Block outputItem, RecipeExporter exporter, RecipeGenerator generator) {
        generator.createShapeless(RecipeCategory.MISC, outputItem)
                .input(Items.HONEYCOMB)
                .input(inputShutter)
                .criterion(generator.hasItem(inputShutter), generator.conditionsFromItem(inputShutter))
                .criterion(generator.hasItem(Items.HONEYCOMB), generator.conditionsFromItem(Items.HONEYCOMB))
                .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(ShutterMain.MOD_ID, generator.getRecipeName(outputItem))));
    }

    private void offersDefaultShutter(Item inputItem, Block outputItem, RecipeExporter exporter, RecipeGenerator generator) {
        offersDefaultShutter(inputItem, outputItem, 2, exporter, generator);
    }

    private void offersDefaultShutter(Item inputItem, Block outputItem, int count, RecipeExporter exporter, RecipeGenerator generator) {
        generator.createShaped(RecipeCategory.MISC, outputItem, count)
                .pattern("AAA")
                .pattern("AAA")
                .input('A', inputItem)
                .criterion(generator.hasItem(inputItem), generator.conditionsFromItem(inputItem))
                .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(ShutterMain.MOD_ID, generator.getRecipeName(outputItem))));
    }
}
