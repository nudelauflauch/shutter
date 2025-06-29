package net.stehschnitzel.shutter.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.stehschnitzel.shutter.init.BlockInit;

import java.util.concurrent.CompletableFuture;

public class ShutterLootTablesProvider extends FabricBlockLootTableProvider {

    public ShutterLootTablesProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(BlockInit.AZALEA_SHUTTER);
        addDrop(BlockInit.COCONUT_SHUTTER);
        addDrop(BlockInit.FLOWERING_AZALEA_SHUTTER);
        addDrop(BlockInit.WALNUT_SHUTTER);
        addDrop(BlockInit.ACACIA_SHUTTER);
        addDrop(BlockInit.BIRCH_SHUTTER);
        addDrop(BlockInit.CRIMSON_SHUTTER);
        addDrop(BlockInit.DARK_OAK_SHUTTER);
        addDrop(BlockInit.IRON_SHUTTER);
        addDrop(BlockInit.JUNGLE_SHUTTER);
        addDrop(BlockInit.OAK_SHUTTER);
        addDrop(BlockInit.SPRUCE_SHUTTER);
        addDrop(BlockInit.WARPED_SHUTTER);
        addDrop(BlockInit.MANGROVE_SHUTTER);
        addDrop(BlockInit.BAMBOO_SHUTTER);
        addDrop(BlockInit.CHERRY_SHUTTER);
        addDrop(BlockInit.COPPER_SHUTTER);
        addDrop(BlockInit.EXPOSED_COPPER_SHUTTER);
        addDrop(BlockInit.OXIDIZED_COPPER_SHUTTER);
        addDrop(BlockInit.WEATHERED_COPPER_SHUTTER);
        addDrop(BlockInit.WAXED_COPPER_SHUTTER);
        addDrop(BlockInit.WAXED_EXPOSED_COPPER_SHUTTER);
        addDrop(BlockInit.WAXED_OXIDIZED_COPPER_SHUTTER);
        addDrop(BlockInit.WAXED_WEATHERED_COPPER_SHUTTER);
        addDrop(BlockInit.GOLD_SHUTTER);
        addDrop(BlockInit.GLASS_SHUTTER);
        addDrop(BlockInit.NETHERITE_SHUTTER);
        addDrop(BlockInit.STRIPPED_BAMBOO_SHUTTER);
        addDrop(BlockInit.GINGERBREAD_SHUTTER);
        addDrop(BlockInit.CYPRESS_SHUTTER);
        addDrop(BlockInit.MUDDY_OAK_SHUTTER);
        addDrop(BlockInit.PALM_SHUTTER);
    }
}

