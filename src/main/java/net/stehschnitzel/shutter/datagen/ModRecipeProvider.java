package net.stehschnitzel.shutter.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.stehschnitzel.shutter.init.BlockInit;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        defaultShutter(Items.ACACIA_SLAB, BlockInit.ACACIA_SHUTTER.get()).save(pRecipeOutput);
        defaultShutter(Items.BIRCH_SLAB, BlockInit.BIRCH_SHUTTER.get()).save(pRecipeOutput);
        defaultShutter(Items.CRIMSON_SLAB, BlockInit.CRIMSON_SHUTTER.get()).save(pRecipeOutput);
        defaultShutter(Items.DARK_OAK_SLAB, BlockInit.DARK_OAK_SHUTTER.get()).save(pRecipeOutput);
        defaultShutter(Items.JUNGLE_SLAB, BlockInit.JUNGLE_SHUTTER.get()).save(pRecipeOutput);
        defaultShutter(Items.OAK_SLAB, BlockInit.OAK_SHUTTER.get()).save(pRecipeOutput);
        defaultShutter(Items.SPRUCE_SLAB, BlockInit.SPRUCE_SHUTTER.get()).save(pRecipeOutput);
        defaultShutter(Items.WARPED_SLAB, BlockInit.WARPED_SHUTTER.get()).save(pRecipeOutput);
        defaultShutter(Items.MANGROVE_SLAB, BlockInit.MANGROVE_SHUTTER.get()).save(pRecipeOutput);
        defaultShutter(Items.BAMBOO_SLAB, BlockInit.BAMBOO_SHUTTER.get()).save(pRecipeOutput);
        defaultShutter(Items.CHERRY_SLAB, BlockInit.CHERRY_SHUTTER.get()).save(pRecipeOutput);
        defaultShutter(Items.COPPER_BLOCK, BlockInit.COPPER_SHUTTER.get(), 8).save(pRecipeOutput);
        defaultShutter(Items.WEATHERED_COPPER, BlockInit.WEATHERED_COPPER_SHUTTER.get(), 8).save(pRecipeOutput);
        defaultShutter(Items.GLASS_PANE, BlockInit.GLASS_SHUTTER.get()).save(pRecipeOutput);

        waxed_shutter(BlockInit.COPPER_SHUTTER.get(), BlockInit.WAXED_COPPER_SHUTTER.get()).save(pRecipeOutput);
        waxed_shutter(BlockInit.EXPOSED_COPPER_SHUTTER.get(), BlockInit.WAXED_EXPOSED_COPPER_SHUTTER.get()).save(pRecipeOutput);
        waxed_shutter(BlockInit.OXIDIZED_COPPER_SHUTTER.get(), BlockInit.WAXED_OXIDIZED_COPPER_SHUTTER.get()).save(pRecipeOutput);
        waxed_shutter(BlockInit.WEATHERED_COPPER_SHUTTER.get(), BlockInit.WAXED_WEATHERED_COPPER_SHUTTER.get()).save(pRecipeOutput);

        ingotShutter(Items.GOLD_INGOT, Items.GOLD_NUGGET, BlockInit.GOLD_SHUTTER.get()).save(pRecipeOutput);
        ingotShutter(Items.IRON_INGOT, Items.IRON_NUGGET, BlockInit.IRON_SHUTTER.get()).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BlockInit.NETHERITE_SHUTTER.get())
                .requires(BlockInit.GOLD_SHUTTER.get())
                .requires(Items.NETHERITE_SCRAP)
                .unlockedBy(getHasName(BlockInit.GOLD_SHUTTER.get()), has(BlockInit.GOLD_SHUTTER.get()))
                .unlockedBy(getHasName(Items.NETHERITE_SCRAP), has(Items.NETHERITE_SCRAP))
                .save(pRecipeOutput);
    }

    private ShapedRecipeBuilder ingotShutter(ItemLike inputIngot, ItemLike inputNugget, ItemLike outputItem) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, outputItem, 2)
                .pattern("A_A")
                .pattern("A_A")
                .define('A', inputIngot)
                .define('_', inputNugget)
                .unlockedBy(getHasName(inputIngot), has(inputIngot))
                .unlockedBy(getHasName(inputNugget), has(inputNugget));
    }

    private ShapelessRecipeBuilder waxed_shutter(ItemLike inputShutter, ItemLike ouputItem) {
        return ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ouputItem)
                .requires(Items.HONEYCOMB)
                .requires(inputShutter)
                .unlockedBy(getHasName(inputShutter), has(inputShutter))
                .unlockedBy(getHasName(Items.HONEYCOMB), has(Items.HONEYCOMB));
    }

    private ShapedRecipeBuilder defaultShutter(ItemLike inputItem, ItemLike outputItem) {
        return defaultShutter(inputItem, outputItem, 2);
    }

    private ShapedRecipeBuilder defaultShutter(ItemLike inputItem, ItemLike outputItem, int count) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, outputItem, 4)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', inputItem)
                .unlockedBy(getHasName(inputItem), has(inputItem));
    }
}
