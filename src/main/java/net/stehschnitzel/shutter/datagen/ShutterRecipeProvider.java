package net.stehschnitzel.shutter.datagen;

//import blueduck.outer_end.registry.OuterEndBlocks;
//import com.teamabnormals.autumnity.core.registry.AutumnityBlocks;
//import com.teamabnormals.caverns_and_chasms.core.registry.CCBlocks;
//import com.teamabnormals.endergetic.core.registry.EEBlocks;
//import com.teamabnormals.environmental.core.registry.EnvironmentalBlocks;
//import net.mehvahdjukaar.snowyspirit.reg.ModRegistry;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.stehschnitzel.shutter.init.BlockInit;

import java.util.concurrent.CompletableFuture;

public class ShutterRecipeProvider extends RecipeProvider {
    public ShutterRecipeProvider(HolderLookup.Provider provider, RecipeOutput output) {
        super(provider, output);
    }

    @Override
    protected void buildRecipes() {
        defaultShutter(Items.ACACIA_SLAB, BlockInit.ACACIA_SHUTTER.get()).save(this.output);
        defaultShutter(Items.BIRCH_SLAB, BlockInit.BIRCH_SHUTTER.get()).save(this.output);
        defaultShutter(Items.CRIMSON_SLAB, BlockInit.CRIMSON_SHUTTER.get()).save(this.output);
        defaultShutter(Items.DARK_OAK_SLAB, BlockInit.DARK_OAK_SHUTTER.get()).save(this.output);
        defaultShutter(Items.JUNGLE_SLAB, BlockInit.JUNGLE_SHUTTER.get()).save(this.output);
        defaultShutter(Items.OAK_SLAB, BlockInit.OAK_SHUTTER.get()).save(this.output);
        defaultShutter(Items.SPRUCE_SLAB, BlockInit.SPRUCE_SHUTTER.get()).save(this.output);
        defaultShutter(Items.WARPED_SLAB, BlockInit.WARPED_SHUTTER.get()).save(this.output);
        defaultShutter(Items.MANGROVE_SLAB, BlockInit.MANGROVE_SHUTTER.get()).save(this.output);
        defaultShutter(Items.BAMBOO_SLAB, BlockInit.BAMBOO_SHUTTER.get()).save(this.output);
        defaultShutter(Items.CHERRY_SLAB, BlockInit.CHERRY_SHUTTER.get()).save(this.output);
        defaultShutter(Items.GLASS_PANE, BlockInit.GLASS_SHUTTER.get()).save(this.output);

        ingotShutter(Items.GOLD_INGOT, Items.GOLD_NUGGET, BlockInit.GOLD_SHUTTER.get()).save(this.output);
        ingotShutter(Items.IRON_INGOT, Items.IRON_NUGGET, BlockInit.IRON_SHUTTER.get()).save(this.output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM),
                        RecipeCategory.BUILDING_BLOCKS,
                        BlockInit.NETHERITE_SHUTTER.get())
                .requires(BlockInit.GOLD_SHUTTER.get())
                .requires(Items.NETHERITE_SCRAP)
                .unlockedBy(getHasName(BlockInit.GOLD_SHUTTER.get()), has(BlockInit.GOLD_SHUTTER.get()))
                .unlockedBy(getHasName(Items.NETHERITE_SCRAP), has(Items.NETHERITE_SCRAP))
                .save(this.output);

//        defaultShutter(ModBlocks.AZALEA_SLAB.get(), BlockInit.AZALEA_SHUTTER.get()).save(this.output);
//        defaultShutter(ModBlocks.COCONUT_SLAB.get(), BlockInit.COCONUT_SHUTTER.get()).save(this.output);
//        defaultShutter(ModBlocks.FLOWERING_AZALEA_SLAB.get(), BlockInit.FLOWERING_AZALEA_SHUTTER.get()).save(this.output);
//        defaultShutter(ModBlocks.WALNUT_SLAB.get(), BlockInit.WALNUT_SHUTTER.get()).save(this.output);
//        defaultShutter(OuterEndBlocks.AZURE_SLAB.get(), BlockInit.AZURE_SHUTTER.get()).save(this.output);
//        ingotShutter(OItems.LEAD_INGOT.get(), OItems.LEAD_NUGGET.get(), BlockInit.LEAD_SHUTTER.get());
//        ingotShutter(OItems.SILVER_INGOT.get(), OItems.SILVER_NUGGET.get(), BlockInit.SILVER_SHUTTER.get());
//        defaultShutter(AutumnityBlocks.MAPLE_SLAB.get(), BlockInit.MAPLE_SHUTTER.get()).save(this.output);

//        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockInit.GINGERBREAD_SHUTTER.get(), 4)
//                .pattern("##")
//                .pattern("##")
//                .define('#', ModRegistry.GINGERBREAD_FROSTED_BLOCK.get())
//                .unlockedBy(getHasName(ModRegistry.GINGERBREAD_FROSTED_BLOCK.get()), has(ModRegistry.GINGERBREAD_FROSTED_BLOCK.get()))
//                .save(this.output);

//        defaultShutter(EnvironmentalBlocks.PLUM_SLAB.get(), BlockInit.PLUM_SHUTTER.get()).save(this.output);
//        defaultShutter(EnvironmentalBlocks.WILLOW_SLAB.get(), BlockInit.WILLOW_SHUTTER.get()).save(this.output);
//        defaultShutter(EnvironmentalBlocks.WISTERIA_SLAB.get(), BlockInit.WISTERIA_SHUTTER.get()).save(this.output);
//        defaultShutter(EnvironmentalBlocks.PINE_SLAB.get(), BlockInit.PINE_SHUTTER.get()).save(this.output);
//
//        defaultShutter(AncientWoodModule.woodSet.slab, BlockInit.ANCIENT_SHUTTER.get()).save(this.output);
//        defaultShutter(BlossomTreesModule.woodSet.slab, BlockInit.BLOSSOM_SHUTTER.get()).save(this.output);

//        defaultShutter(UABlocks.DRIFTWOOD_SLAB.get(), BlockInit.DRIFTWOOD_SHUTTER.get()).save(this.output);
//        defaultShutter(UABlocks.RIVER_SLAB.get(), BlockInit.RIVER_SHUTTER.get()).save(this.output);
//        defaultShutter(GoodEndingBlocks.CYPRESS_SLAB.get(), BlockInit.CYPRESS_SHUTTER.get()).save(this.output);   //TODO doesnt work because of Good Ending
//        defaultShutter(GoodEndingBlocks.MUDDY_OAK_SLAB.get(), BlockInit.MUDDY_OAK_SHUTTER.get()).save(this.output);
//        defaultShutter(ObjectRegistry.PALM_SLAB.get(), BlockInit.PALM_SHUTTER.get()).save(this.output);
//        defaultShutter(EEBlocks.POISE_SLAB.get(), BlockInit.POISE_SHUTTER.get()).save(this.output);
//        defaultShutter(CCBlocks.AZALEA_SLAB.get(), BlockInit.CAVERN_AZALEA_SHUTTER.get()).save(this.output);

        defaultShutter(Items.COPPER_BLOCK, BlockInit.COPPER_SHUTTER.get(), 8).save(this.output);
        defaultShutter(Items.EXPOSED_COPPER, BlockInit.EXPOSED_COPPER_SHUTTER.get(), 8).save(this.output);
        defaultShutter(Items.OXIDIZED_COPPER, BlockInit.OXIDIZED_COPPER_SHUTTER.get(), 8).save(this.output);
        defaultShutter(Items.WEATHERED_COPPER, BlockInit.WEATHERED_COPPER_SHUTTER.get(), 8).save(this.output);

        waxed_shutter(BlockInit.COPPER_SHUTTER.get(), BlockInit.WAXED_COPPER_SHUTTER.get()).save(this.output);
        waxed_shutter(BlockInit.EXPOSED_COPPER_SHUTTER.get(), BlockInit.WAXED_EXPOSED_COPPER_SHUTTER.get()).save(this.output);
        waxed_shutter(BlockInit.OXIDIZED_COPPER_SHUTTER.get(), BlockInit.WAXED_OXIDIZED_COPPER_SHUTTER.get()).save(this.output);
        waxed_shutter(BlockInit.WEATHERED_COPPER_SHUTTER.get(), BlockInit.WAXED_WEATHERED_COPPER_SHUTTER.get()).save(this.output);
    }

    private ShapedRecipeBuilder ingotShutter(ItemLike inputIngot, ItemLike inputNugget, ItemLike outputItem) {
        return ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM),
                        RecipeCategory.BUILDING_BLOCKS, outputItem, 2)
                .pattern("A_A")
                .pattern("A_A")
                .define('A', inputIngot)
                .define('_', inputNugget)
                .unlockedBy(getHasName(inputIngot), has(inputIngot))
                .unlockedBy(getHasName(inputNugget), has(inputNugget));
    }

    private ShapelessRecipeBuilder waxed_shutter(ItemLike inputShutter, ItemLike ouputItem) {
        return ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM),
                        RecipeCategory.BUILDING_BLOCKS, ouputItem)
                .requires(Items.HONEYCOMB)
                .requires(inputShutter)
                .unlockedBy(getHasName(inputShutter), has(inputShutter))
                .unlockedBy(getHasName(Items.HONEYCOMB), has(Items.HONEYCOMB));
    }

    private ShapedRecipeBuilder defaultShutter(ItemLike inputItem, ItemLike outputItem) {
        return defaultShutter(inputItem, outputItem, 2);
    }

    private ShapedRecipeBuilder defaultShutter(ItemLike inputItem, ItemLike outputItem, int count) {
        return ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM),
                        RecipeCategory.BUILDING_BLOCKS, outputItem, count)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', inputItem)
                .unlockedBy(getHasName(inputItem), has(inputItem));
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
            super(output, lookupProvider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput output) {
            return new ShutterRecipeProvider(provider, output);
        }

        @Override
        public String getName() {
            return "";
        }
    }
}
