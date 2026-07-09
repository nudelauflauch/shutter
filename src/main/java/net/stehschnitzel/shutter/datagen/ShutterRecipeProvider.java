package net.stehschnitzel.shutter.datagen;

//import blueduck.outer_end.registry.OuterEndBlocks;
//import com.teamabnormals.autumnity.core.registry.AutumnityBlocks;
//import com.teamabnormals.caverns_and_chasms.core.registry.CCBlocks;
//import com.teamabnormals.endergetic.core.registry.EEBlocks;
//import com.teamabnormals.environmental.core.registry.EnvironmentalBlocks;
//import net.mehvahdjukaar.snowyspirit.reg.ModRegistry;

import com.ninni.twigs.registry.TwigsItems;
import com.teamabnormals.autumnity.core.registry.AutumnityBlocks;
import com.teamabnormals.caverns_and_chasms.core.registry.CCBlocks;
import com.teamabnormals.environmental.core.registry.EnvironmentalBlocks;
import com.teamabnormals.upgrade_aquatic.core.registry.UABlocks;
import net.mehvahdjukaar.snowyspirit.reg.ModRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.orcinus.goodending.init.GoodEndingBlocks;
import net.satisfy.beachparty.core.registry.ObjectRegistry;
import net.stehschnitzel.shutter.init.BlockInit;
import org.violetmoon.quark.content.world.module.AncientWoodModule;
import org.violetmoon.quark.content.world.module.AzaleaWoodModule;
import org.violetmoon.quark.content.world.module.BlossomTreesModule;
import samebutdifferent.ecologics.registry.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ShutterRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ShutterRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pWriter) {
        defaultShutter(Items.ACACIA_SLAB, BlockInit.ACACIA_SHUTTER.get()).save(pWriter);
        defaultShutter(Items.BIRCH_SLAB, BlockInit.BIRCH_SHUTTER.get()).save(pWriter);
        defaultShutter(Items.CRIMSON_SLAB, BlockInit.CRIMSON_SHUTTER.get()).save(pWriter);
        defaultShutter(Items.DARK_OAK_SLAB, BlockInit.DARK_OAK_SHUTTER.get()).save(pWriter);
        defaultShutter(Items.JUNGLE_SLAB, BlockInit.JUNGLE_SHUTTER.get()).save(pWriter);
        defaultShutter(Items.OAK_SLAB, BlockInit.OAK_SHUTTER.get()).save(pWriter);
        defaultShutter(Items.SPRUCE_SLAB, BlockInit.SPRUCE_SHUTTER.get()).save(pWriter);
        defaultShutter(Items.WARPED_SLAB, BlockInit.WARPED_SHUTTER.get()).save(pWriter);
        defaultShutter(Items.MANGROVE_SLAB, BlockInit.MANGROVE_SHUTTER.get()).save(pWriter);
        defaultShutter(Items.BAMBOO_SLAB, BlockInit.BAMBOO_SHUTTER.get()).save(pWriter);
        defaultShutter(Items.CHERRY_SLAB, BlockInit.CHERRY_SHUTTER.get()).save(pWriter);
        defaultShutter(Items.GLASS_PANE, BlockInit.GLASS_SHUTTER.get()).save(pWriter);

        defaultShutter(Items.COPPER_BLOCK, BlockInit.COPPER_SHUTTER.get(), 8).save(pWriter);
        defaultShutter(Items.EXPOSED_COPPER, BlockInit.EXPOSED_COPPER_SHUTTER.get(), 8).save(pWriter);
        defaultShutter(Items.OXIDIZED_COPPER, BlockInit.OXIDIZED_COPPER_SHUTTER.get(), 8).save(pWriter);
        defaultShutter(Items.WEATHERED_COPPER, BlockInit.WEATHERED_COPPER_SHUTTER.get(), 8).save(pWriter);

        waxed_shutter(BlockInit.COPPER_SHUTTER.get(), BlockInit.WAXED_COPPER_SHUTTER.get()).save(pWriter);
        waxed_shutter(BlockInit.EXPOSED_COPPER_SHUTTER.get(), BlockInit.WAXED_EXPOSED_COPPER_SHUTTER.get()).save(pWriter);
        waxed_shutter(BlockInit.OXIDIZED_COPPER_SHUTTER.get(), BlockInit.WAXED_OXIDIZED_COPPER_SHUTTER.get()).save(pWriter);
        waxed_shutter(BlockInit.WEATHERED_COPPER_SHUTTER.get(), BlockInit.WAXED_WEATHERED_COPPER_SHUTTER.get()).save(pWriter);


        ingotShutter(Items.GOLD_INGOT, Items.GOLD_NUGGET, BlockInit.GOLD_SHUTTER.get()).save(pWriter);
        ingotShutter(Items.IRON_INGOT, Items.IRON_NUGGET, BlockInit.IRON_SHUTTER.get()).save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BlockInit.NETHERITE_SHUTTER.get())
                .requires(BlockInit.GOLD_SHUTTER.get())
                .requires(Items.NETHERITE_SCRAP)
                .unlockedBy(getHasName(BlockInit.GOLD_SHUTTER.get()), has(BlockInit.GOLD_SHUTTER.get()))
                .unlockedBy(getHasName(Items.NETHERITE_SCRAP), has(Items.NETHERITE_SCRAP))
                .save(pWriter);

        defaultShutter(ObjectRegistry.PALM_SLAB.get(), BlockInit.PALM_SHUTTER.get()).save(pWriter);

        defaultShutter(AutumnityBlocks.MAPLE_SLAB.get(), BlockInit.MAPLE_SHUTTER.get()).save(pWriter);

        defaultShutter(CCBlocks.AZALEA_SLAB.get(), BlockInit.CAVERN_AZALEA_SHUTTER.get()).save(pWriter);

        defaultShutter(ModBlocks.AZALEA_SLAB, BlockInit.AZALEA_SHUTTER.get()).save(pWriter);
        defaultShutter(ModBlocks.COCONUT_SLAB, BlockInit.COCONUT_SHUTTER.get()).save(pWriter);
        defaultShutter(ModBlocks.FLOWERING_AZALEA_SLAB, BlockInit.FLOWERING_AZALEA_SHUTTER.get()).save(pWriter);
        defaultShutter(ModBlocks.WALNUT_SLAB, BlockInit.WALNUT_SHUTTER.get()).save(pWriter);

        defaultShutter(EnvironmentalBlocks.PLUM_SLAB.get(), BlockInit.PLUM_SHUTTER.get()).save(pWriter);
        defaultShutter(EnvironmentalBlocks.WILLOW_SLAB.get(), BlockInit.WILLOW_SHUTTER.get()).save(pWriter);
        defaultShutter(EnvironmentalBlocks.WISTERIA_SLAB.get(), BlockInit.WISTERIA_SHUTTER.get()).save(pWriter);
        defaultShutter(EnvironmentalBlocks.PINE_SLAB.get(), BlockInit.PINE_SHUTTER.get()).save(pWriter);

        defaultShutter(GoodEndingBlocks.CYPRESS_SLAB.get(), BlockInit.CYPRESS_SHUTTER.get()).save(pWriter);   //TODO doesnt work because of Good Ending
        defaultShutter(GoodEndingBlocks.MUDDY_OAK_SLAB.get(), BlockInit.MUDDY_OAK_SHUTTER.get()).save(pWriter);

//        ingotShutter(OItems.LEAD_INGOT.get(), OItems.LEAD_NUGGET.get(), BlockInit.LEAD_SHUTTER.get());
//        ingotShutter(OItems.SILVER_INGOT.get(), OItems.SILVER_NUGGET.get(), BlockInit.SILVER_SHUTTER.get());

        defaultShutter(BlossomTreesModule.woodSet.slab, BlockInit.BLOSSOM_SHUTTER.get()).save(pWriter);
        defaultShutter(AncientWoodModule.woodSet.slab, BlockInit.ANCIENT_SHUTTER.get()).save(pWriter);
        defaultShutter(AzaleaWoodModule.woodSet.slab, BlockInit.AZALEA_SHUTTER.get()).save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockInit.GINGERBREAD_SHUTTER.get(), 4)
                .pattern("##")
                .pattern("##")
                .define('#', ModRegistry.GINGERBREAD_FROSTED_BLOCK.get())
                .unlockedBy(getHasName(ModRegistry.GINGERBREAD_FROSTED_BLOCK.get()), has(ModRegistry.GINGERBREAD_FROSTED_BLOCK.get()))
                .save(pWriter);

//        defaultShutter(EEBlocks.POISE_SLAB.get(), BlockInit.POISE_SHUTTER.get()).save(pWriter);

//        defaultShutter(OuterEndBlocks.AZURE_SLAB.get(), BlockInit.AZURE_SHUTTER.get()).save(pWriter);

        //idk if thats right TODO
        defaultShutter(TwigsItems.BAMBOO_THATCH_SLAB.get(), BlockInit.STRIPPED_BAMBOO_SHUTTER.get()).save(pWriter);

        defaultShutter(UABlocks.DRIFTWOOD_SLAB.get(), BlockInit.DRIFTWOOD_SHUTTER.get()).save(pWriter);
        defaultShutter(UABlocks.RIVER_SLAB.get(), BlockInit.RIVER_SHUTTER.get()).save(pWriter);


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
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, outputItem, count)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', inputItem)
                .unlockedBy(getHasName(inputItem), has(inputItem));
    }
}
