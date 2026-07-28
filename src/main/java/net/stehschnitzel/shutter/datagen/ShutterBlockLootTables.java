package net.stehschnitzel.shutter.datagen;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.stehschnitzel.shutter.init.BlockInit;

import java.util.Set;

public class ShutterBlockLootTables extends BlockLootSubProvider {
    protected ShutterBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(BlockInit.MAPLE_SHUTTER.get());
        dropWhenSilkTouch(BlockInit.GLASS_SHUTTER.get());
        dropSelf(BlockInit.AZALEA_SHUTTER.get());
        dropSelf(BlockInit.COCONUT_SHUTTER.get());
        dropSelf(BlockInit.FLOWERING_AZALEA_SHUTTER.get());
        dropSelf(BlockInit.WALNUT_SHUTTER.get());
        dropSelf(BlockInit.PLUM_SHUTTER.get());
        dropSelf(BlockInit.WILLOW_SHUTTER.get());
        dropSelf(BlockInit.WISTERIA_SHUTTER.get());
        dropSelf(BlockInit.PINE_SHUTTER.get());
        dropSelf(BlockInit.ACACIA_SHUTTER.get());
        dropSelf(BlockInit.BAMBOO_SHUTTER.get());
        dropSelf(BlockInit.BIRCH_SHUTTER.get());
        dropSelf(BlockInit.CRIMSON_SHUTTER.get());
        dropSelf(BlockInit.OAK_SHUTTER.get());
        dropSelf(BlockInit.DARK_OAK_SHUTTER.get());
        dropSelf(BlockInit.MANGROVE_SHUTTER.get());
        dropSelf(BlockInit.JUNGLE_SHUTTER.get());
        dropSelf(BlockInit.WARPED_SHUTTER.get());
        dropSelf(BlockInit.IRON_SHUTTER.get());
        dropSelf(BlockInit.SPRUCE_SHUTTER.get());
        dropSelf(BlockInit.BLOSSOM_SHUTTER.get());
        dropSelf(BlockInit.ANCIENT_SHUTTER.get());
        dropSelf(BlockInit.AZALEA_QUARK_SHUTTER.get());
        dropSelf(BlockInit.GINGERBREAD_SHUTTER.get());
        dropSelf(BlockInit.NETHERITE_SHUTTER.get());
        dropSelf(BlockInit.GOLD_SHUTTER.get());
        dropSelf(BlockInit.CHERRY_SHUTTER.get());
        dropOther(BlockInit.STRIPPED_BAMBOO_SHUTTER.get(), BlockInit.BAMBOO_SHUTTER.get());
        dropSelf(BlockInit.CYPRESS_SHUTTER.get());
        dropSelf(BlockInit.MUDDY_OAK_SHUTTER.get());
        dropSelf(BlockInit.PALM_SHUTTER.get());
        dropSelf(BlockInit.AZURE_SHUTTER.get());
        dropSelf(BlockInit.RIVER_SHUTTER.get());
        dropSelf(BlockInit.DRIFTWOOD_SHUTTER.get());
//        dropSelf(BlockInit.LEAD_SHUTTER.get());
//        dropSelf(BlockInit.SILVER_SHUTTER.get());
        dropSelf(BlockInit.POISE_SHUTTER.get());

        dropSelf(BlockInit.COPPER_SHUTTER.get());
        dropSelf(BlockInit.EXPOSED_COPPER_SHUTTER.get());
        dropSelf(BlockInit.OXIDIZED_COPPER_SHUTTER.get());
        dropSelf(BlockInit.WEATHERED_COPPER_SHUTTER.get());
        dropSelf(BlockInit.WAXED_COPPER_SHUTTER.get());
        dropSelf(BlockInit.WAXED_EXPOSED_COPPER_SHUTTER.get());
        dropSelf(BlockInit.WAXED_OXIDIZED_COPPER_SHUTTER.get());
        dropSelf(BlockInit.WAXED_WEATHERED_COPPER_SHUTTER.get());
        dropSelf(BlockInit.CAVERN_AZALEA_SHUTTER.get());

        dropSelf(BlockInit.ASPEN_SHUTTER.get());
        dropSelf(BlockInit.BLOOMING_PAPER_SHUTTER.get());
        dropSelf(BlockInit.CEDAR_SHUTTER.get());
        dropSelf(BlockInit.FIR_SHUTTER.get());
        dropSelf(BlockInit.FRAMED_PAPER_SHUTTER.get());
        dropSelf(BlockInit.GHAF_SHUTTER.get());
        dropSelf(BlockInit.JOSHUA_SHUTTER.get());
        dropSelf(BlockInit.LARCH_SHUTTER.get());
        dropSelf(BlockInit.MAHOGANY_SHUTTER.get());
        dropSelf(BlockInit.NAS_COCONUT_SHUTTER.get());
        dropSelf(BlockInit.NAS_CYPRESS_SHUTTER.get());
        dropSelf(BlockInit.NAS_MAPLE_SHUTTER.get());
        dropSelf(BlockInit.NAS_WILLOW_SHUTTER.get());
        dropSelf(BlockInit.NAS_WISTERIA_SHUTTER.get());
        dropSelf(BlockInit.OLIVE_SHUTTER.get());
        dropSelf(BlockInit.PALO_VERDE_SHUTTER.get());
        dropSelf(BlockInit.PAPER_SHUTTER.get());
        dropSelf(BlockInit.REDWOOD_SHUTTER.get());
        dropSelf(BlockInit.SAXAUL_SHUTTER.get());
        dropSelf(BlockInit.SUGI_SHUTTER.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
