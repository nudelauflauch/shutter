package net.stehschnitzel.shutter.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
//import net.mehvahdjukaar.snowyspirit.reg.ModRegistry;
//import net.orcinus.goodending.init.GoodEndingBlocks;
//import net.orcinus.goodending.init.GoodEndingItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.stehschnitzel.shutter.init.BlockInit;
//import satisfy.beachparty.registry.ObjectRegistry;

import java.util.concurrent.CompletableFuture;

public class ShutterRecipeProvider extends FabricRecipeProvider {

    public ShutterRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                offersDefaultShutter(Items.ACACIA_SLAB, BlockInit.ACACIA_SHUTTER, exporter, this);
                offersDefaultShutter(Items.BIRCH_SLAB, BlockInit.BIRCH_SHUTTER, exporter, this);
                offersDefaultShutter(Items.CRIMSON_SLAB, BlockInit.CRIMSON_SHUTTER, exporter, this);
                offersDefaultShutter(Items.DARK_OAK_SLAB, BlockInit.DARK_OAK_SHUTTER, exporter, this);
                offersDefaultShutter(Items.JUNGLE_SLAB, BlockInit.JUNGLE_SHUTTER, exporter, this);
                offersDefaultShutter(Items.OAK_SLAB, BlockInit.OAK_SHUTTER, exporter, this);
                offersDefaultShutter(Items.SPRUCE_SLAB, BlockInit.SPRUCE_SHUTTER, exporter, this);
                offersDefaultShutter(Items.WARPED_SLAB, BlockInit.WARPED_SHUTTER, exporter, this);
                offersDefaultShutter(Items.MANGROVE_SLAB, BlockInit.MANGROVE_SHUTTER, exporter, this);
                offersDefaultShutter(Items.BAMBOO_SLAB, BlockInit.BAMBOO_SHUTTER, exporter, this);
                offersDefaultShutter(Items.CHERRY_SLAB, BlockInit.CHERRY_SHUTTER, exporter, this);
                offersDefaultShutter(Items.PALE_OAK_SLAB, BlockInit.PALE_OAK_SHUTTER, exporter, this);
                offersDefaultShutter(Items.GLASS_PANE, BlockInit.GLASS_SHUTTER, exporter, this);
//        offersDefaultShutter(ObjectRegistry.PALM_SLAB.get().asItem(), BlockInit.PALM_SHUTTER, output, this);
//        offersDefaultShutter(((Block) ModBlocks.AZALEA_SLAB.get()).asItem(), BlockInit.AZALEA_SHUTTER, output, this);
//        offersDefaultShutter(ModBlocks.COCONUT_SLAB , BlockInit.COCONUT_SHUTTER, output, this);
//        offersDefaultShutter(ModBlocks.FLOWERING_AZALEA_SLAB , BlockInit.FLOWERING_AZALEA_SHUTTER, output, this);
//        offersDefaultShutter(ModBlocks.WALNUT_SLAB , BlockInit.WALNUT_SHUTTER, output, this);

//                createShaped(RecipeCategory.MISC, BlockInit.GINGERBREAD_SHUTTER, 4)
//                        .pattern("##")
//                        .pattern("##")
//                        .input('#', ModRegistry.GINGERBREAD_FROSTED_BLOCK.get())
//                        .criterion(hasItem(ModRegistry.GINGERBREAD_FROSTED_BLOCK.get()), conditionsFromItem(ModRegistry.GINGERBREAD_FROSTED_BLOCK.get()))
//                        .offerTo(output, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(ShutterMain.MOD_ID, "gingerbread_shutter")));

                offerIngotShutter(Items.GOLD_INGOT, Items.GOLD_NUGGET, BlockInit.GOLD_SHUTTER, exporter, this);
                offerIngotShutter(Items.IRON_INGOT, Items.IRON_NUGGET, BlockInit.IRON_SHUTTER, exporter, this);

                shapeless(RecipeCategory.MISC, BlockInit.NETHERITE_SHUTTER)
                        .requires(BlockInit.GOLD_SHUTTER)
                        .requires(Items.NETHERITE_SCRAP)
                        .unlockedBy(getHasName(BlockInit.GOLD_SHUTTER), has(BlockInit.GOLD_SHUTTER))
                        .unlockedBy(getHasName(Items.NETHERITE_SCRAP), has(Items.NETHERITE_SCRAP))
                        .save(output);
                        //.offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(ShutterMain.MOD_ID, "netherite_shutter")));

//        offersDefaultShutter(ModBlocks.AZALEA_SLAB, BlockInit.AZALEA_SHUTTER, output, this);
//        offersDefaultShutter(ModBlocks.COCONUT_SLAB, BlockInit.COCONUT_SHUTTER, output, this);
//        offersDefaultShutter(ModBlocks.FLOWERING_AZALEA_SLAB, BlockInit.FLOWERING_AZALEA_SHUTTER, output, this);
//        offersDefaultShutter(ModBlocks.WALNUT_SLAB, BlockInit.WALNUT_SHUTTER, output, this);


//        ingotShutter(OItems.LEAD_INGOT, OItems.LEAD_NUGGET, BlockInit.LEAD_SHUTTER, this);
//        ingotShutter(OItems.SILVER_INGOT, OItems.SILVER_NUGGET, BlockInit.SILVER_SHUTTER, this);
//        offersDefaultShutter(UABlocks.DRIFTWOOD_SLAB, BlockInit.DRIFTWOOD_SHUTTER, output, this);
//        offersDefaultShutter(UABlocks.RIVER_SLAB, BlockInit.RIVER_SHUTTER, output, this);
//        offersDefaultShutter(GoodEndingItems.CYPRESS_SLAB, BlockInit.CYPRESS_SHUTTER, output, this);
//        offersDefaultShutter(GoodEndingItems.MUDDY_OAK_SLAB, BlockInit.MUDDY_OAK_SHUTTER, output, this);

                offersDefaultShutter(Items.COPPER_BLOCK, BlockInit.COPPER_SHUTTER, 8, exporter, this);
                offersDefaultShutter(Items.WEATHERED_COPPER, BlockInit.WEATHERED_COPPER_SHUTTER, 8, exporter, this);

                waxed_shutter(BlockInit.COPPER_SHUTTER, BlockInit.WAXED_COPPER_SHUTTER, exporter, this);
                waxed_shutter(BlockInit.EXPOSED_COPPER_SHUTTER, BlockInit.WAXED_EXPOSED_COPPER_SHUTTER, exporter, this);
                waxed_shutter(BlockInit.OXIDIZED_COPPER_SHUTTER, BlockInit.WAXED_OXIDIZED_COPPER_SHUTTER, exporter, this);
                waxed_shutter(BlockInit.WEATHERED_COPPER_SHUTTER, BlockInit.WAXED_WEATHERED_COPPER_SHUTTER, exporter, this);
            }
        };
    }

    @Override
    public String getName() {
        return "";
    }

    private void offerIngotShutter(Item inputIngot, Item inputNugget, Block outputItem, RecipeOutput output, RecipeProvider provider) {
        provider.shaped(RecipeCategory.MISC, outputItem, 2)
                .pattern("A_A")
                .pattern("A_A")
                .define('A', inputIngot)
                .define('_', inputNugget)
                .unlockedBy(RecipeProvider.getHasName(inputIngot), provider.has(inputIngot))
                .unlockedBy(RecipeProvider.getHasName(inputNugget), provider.has(inputNugget))
                .save(output);
    //.save(output, ResourceKey.create(, Identifier.fromNamespaceAndPath(ShutterMain.MOD_ID, RecipeProvider.getHasName(outputItem))));
    }

    private void waxed_shutter(Block inputShutter, Block outputItem, RecipeOutput output, RecipeProvider generator) {
        generator.shapeless(RecipeCategory.MISC, outputItem)
                .requires(Items.HONEYCOMB)
                .requires(inputShutter)
                .unlockedBy(RecipeProvider.getHasName(inputShutter), generator.has(inputShutter))
                .unlockedBy(RecipeProvider.getHasName(Items.HONEYCOMB), generator.has(Items.HONEYCOMB))
                .save(output);
                //.offerTo(output, RegistryKey.of(RegistryKeys.RECIPE, Identifier.fromNamespaceAndPath(ShutterMain.MOD_ID, generator.getRecipeName(outputItem))));
    }

    private void offersDefaultShutter(Item inputItem, Block outputItem, RecipeOutput exporter, RecipeProvider generator) {
        offersDefaultShutter(inputItem, outputItem, 2, exporter, generator);
    }

    private void offersDefaultShutter(Item inputItem, Block outputItem, int count, RecipeOutput output, RecipeProvider generator) {
        generator.shaped(RecipeCategory.MISC, outputItem, count)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', inputItem)
                .unlockedBy(RecipeProvider.getHasName(inputItem), generator.has(inputItem))
                .save(output);
                //.offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(ShutterMain.MOD_ID, generator.getRecipeName(outputItem))));
    }
}
