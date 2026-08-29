package net.stehschnitzel.shutter.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.tags.BlockTags;
import net.stehschnitzel.shutter.init.BlockInit;

import java.util.concurrent.CompletableFuture;

public class ShutterBlockTagProvider extends FabricTagProvider.BlockTagProvider{
    public ShutterBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockInit.IRON_SHUTTER)
                .add(BlockInit.COPPER_SHUTTER)
                .add(BlockInit.EXPOSED_COPPER_SHUTTER)
                .add(BlockInit.OXIDIZED_COPPER_SHUTTER)
                .add(BlockInit.WEATHERED_COPPER_SHUTTER)
                .add(BlockInit.WAXED_COPPER_SHUTTER)
                .add(BlockInit.WAXED_EXPOSED_COPPER_SHUTTER)
                .add(BlockInit.WAXED_OXIDIZED_COPPER_SHUTTER)
                .add(BlockInit.WAXED_WEATHERED_COPPER_SHUTTER)
                .add(BlockInit.GOLD_SHUTTER)
                .add(BlockInit.NETHERITE_SHUTTER);

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(BlockInit.AZALEA_SHUTTER)
                .add(BlockInit.COCONUT_SHUTTER)
                .add(BlockInit.FLOWERING_AZALEA_SHUTTER)
                .add(BlockInit.WALNUT_SHUTTER)
                .add(BlockInit.ACACIA_SHUTTER)
                .add(BlockInit.BIRCH_SHUTTER)
                .add(BlockInit.CRIMSON_SHUTTER)
                .add(BlockInit.DARK_OAK_SHUTTER)
                .add(BlockInit.JUNGLE_SHUTTER)
                .add(BlockInit.OAK_SHUTTER)
                .add(BlockInit.SPRUCE_SHUTTER)
                .add(BlockInit.WARPED_SHUTTER)
                .add(BlockInit.MANGROVE_SHUTTER)
                .add(BlockInit.BAMBOO_SHUTTER)
                .add(BlockInit.STRIPPED_BAMBOO_SHUTTER)
                .add(BlockInit.GINGERBREAD_SHUTTER)
                .add(BlockInit.CYPRESS_SHUTTER)
                .add(BlockInit.MUDDY_OAK_SHUTTER)
                .add(BlockInit.PALM_SHUTTER);
    }
}
