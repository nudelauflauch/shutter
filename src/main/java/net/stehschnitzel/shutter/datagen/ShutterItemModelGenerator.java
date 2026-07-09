package net.stehschnitzel.shutter.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.stehschnitzel.shutter.ShutterMain;
import net.stehschnitzel.shutter.common.blocks.Shutter;
import net.stehschnitzel.shutter.init.BlockInit;

import java.util.function.Supplier;

public class ShutterItemModelGenerator extends ItemModelProvider {

    public ShutterItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ShutterMain.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(BlockInit.GLASS_SHUTTER);

        simpleItem(BlockInit.COPPER_SHUTTER);
        simpleItem(BlockInit.OXIDIZED_COPPER_SHUTTER);
        simpleItem(BlockInit.WEATHERED_COPPER_SHUTTER);
        simpleItem(BlockInit.EXPOSED_COPPER_SHUTTER);

        simpleItem(BlockInit.WAXED_COPPER_SHUTTER, BlockInit.COPPER_SHUTTER);
        simpleItem(BlockInit.WAXED_OXIDIZED_COPPER_SHUTTER, BlockInit.OXIDIZED_COPPER_SHUTTER);
        simpleItem(BlockInit.WAXED_WEATHERED_COPPER_SHUTTER, BlockInit.WEATHERED_COPPER_SHUTTER);
        simpleItem(BlockInit.WAXED_EXPOSED_COPPER_SHUTTER, BlockInit.EXPOSED_COPPER_SHUTTER);

        simpleItem(BlockInit.ACACIA_SHUTTER);
        simpleItem(BlockInit.BAMBOO_SHUTTER);
        simpleItem(BlockInit.BIRCH_SHUTTER);
        simpleItem(BlockInit.CRIMSON_SHUTTER);
        simpleItem(BlockInit.OAK_SHUTTER);
        simpleItem(BlockInit.DARK_OAK_SHUTTER);
        simpleItem(BlockInit.MANGROVE_SHUTTER);
        simpleItem(BlockInit.JUNGLE_SHUTTER);
        simpleItem(BlockInit.WARPED_SHUTTER);
        simpleItem(BlockInit.IRON_SHUTTER);
        simpleItem(BlockInit.SPRUCE_SHUTTER);

        simpleItem(BlockInit.NETHERITE_SHUTTER);
        simpleItem(BlockInit.GOLD_SHUTTER);
        simpleItem(BlockInit.CHERRY_SHUTTER);

        simpleItem(BlockInit.PALM_SHUTTER);

        simpleItem(BlockInit.MAPLE_SHUTTER);

        simpleItem(BlockInit.CAVERN_AZALEA_SHUTTER);

        simpleItem(BlockInit.AZALEA_SHUTTER);
        simpleItem(BlockInit.COCONUT_SHUTTER);
        simpleItem(BlockInit.FLOWERING_AZALEA_SHUTTER);
        simpleItem(BlockInit.WALNUT_SHUTTER);

        simpleItem(BlockInit.PLUM_SHUTTER);
        simpleItem(BlockInit.WILLOW_SHUTTER);
        simpleItem(BlockInit.WISTERIA_SHUTTER);
        simpleItem(BlockInit.PINE_SHUTTER);

        simpleItem(BlockInit.CYPRESS_SHUTTER);
        simpleItem(BlockInit.MUDDY_OAK_SHUTTER);

//        simpleItem(BlockInit.LEAD_SHUTTER);
//        simpleItem(BlockInit.SILVER_SHUTTER);

        simpleItem(BlockInit.BLOSSOM_SHUTTER);
        simpleItem(BlockInit.ANCIENT_SHUTTER);
        simpleItem(BlockInit.AZALEA_QUARK_SHUTTER);

        simpleItem(BlockInit.GINGERBREAD_SHUTTER);

//        simpleItem(BlockInit.POISE_SHUTTER);
//        simpleItem(BlockInit.AZURE_SHUTTER);

        simpleItem(BlockInit.STRIPPED_BAMBOO_SHUTTER);

        simpleItem(BlockInit.DRIFTWOOD_SHUTTER);
        simpleItem(BlockInit.RIVER_SHUTTER);

        simpleItem(BlockInit.ASPEN_SHUTTER);
        simpleItem(BlockInit.BLOOMING_PAPER_SHUTTER);
        simpleItem(BlockInit.CEDAR_SHUTTER);
        simpleItem(BlockInit.FIR_SHUTTER);
        simpleItem(BlockInit.FRAMED_PAPER_SHUTTER);
        simpleItem(BlockInit.GHAF_SHUTTER);
        simpleItem(BlockInit.JOSHUA_SHUTTER);
        simpleItem(BlockInit.LARCH_SHUTTER);
        simpleItem(BlockInit.MAHOGANY_SHUTTER);
        simpleItem(BlockInit.NAS_COCONUT_SHUTTER);
        simpleItem(BlockInit.NAS_CYPRESS_SHUTTER);
        simpleItem(BlockInit.NAS_MAPLE_SHUTTER);
        simpleItem(BlockInit.NAS_WILLOW_SHUTTER);
        simpleItem(BlockInit.NAS_WISTERIA_SHUTTER);
        simpleItem(BlockInit.OLIVE_SHUTTER);
        simpleItem(BlockInit.PALO_VERDE_SHUTTER);
        simpleItem(BlockInit.PAPER_SHUTTER);
        simpleItem(BlockInit.REDWOOD_SHUTTER);
        simpleItem(BlockInit.SAXAUL_SHUTTER);
        simpleItem(BlockInit.SUGI_SHUTTER);
    }

    private ItemModelBuilder simpleItem(Supplier<Shutter> item, Supplier<Shutter> originalItem) {
        return withExistingParent(((DeferredHolder) item).getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(ShutterMain.MOD_ID,"item/" + ((DeferredHolder) originalItem).getId().getPath()));
    }

    private ItemModelBuilder simpleItem(Supplier<Shutter> item) {
        return withExistingParent(((DeferredHolder) item).getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(ShutterMain.MOD_ID,"item/" + ((DeferredHolder) item).getId().getPath()));
    }

}
