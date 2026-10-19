package net.stehschnitzel.shutter.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.stehschnitzel.shutter.init.BlockInit;

import java.util.concurrent.CompletableFuture;

public class ShutterLootTablesProvider extends FabricBlockLootTableProvider {

    public ShutterLootTablesProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropSelf(BlockInit.AZALEA_SHUTTER);
        dropSelf(BlockInit.COCONUT_SHUTTER);
        dropSelf(BlockInit.FLOWERING_AZALEA_SHUTTER);
        dropSelf(BlockInit.WALNUT_SHUTTER);
        dropSelf(BlockInit.ACACIA_SHUTTER);
        dropSelf(BlockInit.BIRCH_SHUTTER);
        dropSelf(BlockInit.CRIMSON_SHUTTER);
        dropSelf(BlockInit.DARK_OAK_SHUTTER);
        dropSelf(BlockInit.IRON_SHUTTER);
        dropSelf(BlockInit.JUNGLE_SHUTTER);
        dropSelf(BlockInit.OAK_SHUTTER);
        dropSelf(BlockInit.SPRUCE_SHUTTER);
        dropSelf(BlockInit.WARPED_SHUTTER);
        dropSelf(BlockInit.MANGROVE_SHUTTER);
        dropSelf(BlockInit.BAMBOO_SHUTTER);
        dropSelf(BlockInit.CHERRY_SHUTTER);
        dropSelf(BlockInit.PALE_OAK_SHUTTER);
        dropSelf(BlockInit.COPPER_SHUTTER);
        dropSelf(BlockInit.EXPOSED_COPPER_SHUTTER);
        dropSelf(BlockInit.OXIDIZED_COPPER_SHUTTER);
        dropSelf(BlockInit.WEATHERED_COPPER_SHUTTER);
        dropSelf(BlockInit.WAXED_COPPER_SHUTTER);
        dropSelf(BlockInit.WAXED_EXPOSED_COPPER_SHUTTER);
        dropSelf(BlockInit.WAXED_OXIDIZED_COPPER_SHUTTER);
        dropSelf(BlockInit.WAXED_WEATHERED_COPPER_SHUTTER);
        dropSelf(BlockInit.GOLD_SHUTTER);
        dropSelf(BlockInit.GLASS_SHUTTER);
        dropSelf(BlockInit.NETHERITE_SHUTTER);
        dropSelf(BlockInit.STRIPPED_BAMBOO_SHUTTER);
        dropSelf(BlockInit.GINGERBREAD_SHUTTER);
        dropSelf(BlockInit.CYPRESS_SHUTTER);
        dropSelf(BlockInit.MUDDY_OAK_SHUTTER);
        dropSelf(BlockInit.PALM_SHUTTER);
    }
}

