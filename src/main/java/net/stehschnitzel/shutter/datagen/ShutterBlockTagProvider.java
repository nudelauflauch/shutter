package net.stehschnitzel.shutter.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.stehschnitzel.shutter.ShutterMain;
import net.stehschnitzel.shutter.init.BlockInit;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ShutterBlockTagProvider extends BlockTagsProvider {
    public ShutterBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,@Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ShutterMain.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
//                .add(BlockInit.LEAD_SHUTTER.get())
//                .add(BlockInit.SILVER_SHUTTER.get())
                .add(BlockInit.IRON_SHUTTER.get())
                .add(BlockInit.COPPER_SHUTTER.get())
                .add(BlockInit.EXPOSED_COPPER_SHUTTER.get())
                .add(BlockInit.OXIDIZED_COPPER_SHUTTER.get())
                .add(BlockInit.WEATHERED_COPPER_SHUTTER.get())
                .add(BlockInit.WAXED_COPPER_SHUTTER.get())
                .add(BlockInit.WAXED_EXPOSED_COPPER_SHUTTER.get())
                .add(BlockInit.WAXED_OXIDIZED_COPPER_SHUTTER.get())
                .add(BlockInit.WAXED_WEATHERED_COPPER_SHUTTER.get())
                .add(BlockInit.GOLD_SHUTTER.get())
                .add(BlockInit.NETHERITE_SHUTTER.get());

        tag(BlockTags.MINEABLE_WITH_AXE)

                .add(BlockInit.ACACIA_SHUTTER.get())
                .add(BlockInit.BIRCH_SHUTTER.get())
                .add(BlockInit.CRIMSON_SHUTTER.get())
                .add(BlockInit.DARK_OAK_SHUTTER.get())
                .add(BlockInit.JUNGLE_SHUTTER.get())
                .add(BlockInit.OAK_SHUTTER.get())
                .add(BlockInit.SPRUCE_SHUTTER.get())
                .add(BlockInit.WARPED_SHUTTER.get())
                .add(BlockInit.MANGROVE_SHUTTER.get())
                .add(BlockInit.BAMBOO_SHUTTER.get())

                .add(BlockInit.PALM_SHUTTER.get())
                .add(BlockInit.MAPLE_SHUTTER.get())
                .add(BlockInit.CAVERN_AZALEA_SHUTTER.get())

                .add(BlockInit.ACACIA_SHUTTER.get())
                .add(BlockInit.COCONUT_SHUTTER.get())
                .add(BlockInit.FLOWERING_AZALEA_SHUTTER.get())
                .add(BlockInit.WALNUT_SHUTTER.get())

                .add(BlockInit.PLUM_SHUTTER.get())
                .add(BlockInit.WILLOW_SHUTTER.get())
                .add(BlockInit.WISTERIA_SHUTTER.get())
                .add(BlockInit.PINE_SHUTTER.get())

                .add(BlockInit.CYPRESS_SHUTTER.get())
                .add(BlockInit.MUDDY_OAK_SHUTTER.get())

                .add(BlockInit.BLOSSOM_SHUTTER.get())
                .add(BlockInit.ANCIENT_SHUTTER.get())
                .add(BlockInit.AZALEA_QUARK_SHUTTER.get())

                .add(BlockInit.GINGERBREAD_SHUTTER.get())

//                .add(BlockInit.POISE_SHUTTER.get())
//                .add(BlockInit.AZURE_SHUTTER.get())

                .add(BlockInit.STRIPPED_BAMBOO_SHUTTER.get())

                .add(BlockInit.DRIFTWOOD_SHUTTER.get())
                .add(BlockInit.RIVER_SHUTTER.get());

    }
}
