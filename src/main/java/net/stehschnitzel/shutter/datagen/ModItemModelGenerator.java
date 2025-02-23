package net.stehschnitzel.shutter.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.stehschnitzel.shutter.ShutterMain;
import net.stehschnitzel.shutter.common.blocks.Shutter;
import net.stehschnitzel.shutter.init.BlockInit;

public class ModItemModelGenerator extends ItemModelProvider {

    public ModItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ShutterMain.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(BlockInit.MAPLE_SHUTTER);
        simpleItem(BlockInit.GLASS_SHUTTER);
        simpleItem(BlockInit.AZALEA_SHUTTER);
        simpleItem(BlockInit.COCONUT_SHUTTER);
        simpleItem(BlockInit.FLOWERING_AZALEA_SHUTTER);
        simpleItem(BlockInit.WALNUT_SHUTTER);
        simpleItem(BlockInit.CHERRY_ENV_SHUTTER);
        simpleItem(BlockInit.WILLOW_SHUTTER);
        simpleItem(BlockInit.WISTERIA_SHUTTER);
        simpleItem(BlockInit.PINE_SHUTTER);
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
        simpleItem(BlockInit.BLOSSOM_SHUTTER);
        simpleItem(BlockInit.ANCIENT_SHUTTER);
        simpleItem(BlockInit.AZALEA_QUARK_SHUTTER);
        simpleItem(BlockInit.GINGERBREAD_SHUTTER);
        simpleItem(BlockInit.NETHERITE_SHUTTER);
        simpleItem(BlockInit.GOLD_SHUTTER);
        simpleItem(BlockInit.CHERRY_SHUTTER);
        simpleItem(BlockInit.STRIPPED_BAMBOO_SHUTTER);
        simpleItem(BlockInit.CYPRESS_SHUTTER);
        simpleItem(BlockInit.MUDDY_OAK_SHUTTER);
        simpleItem(BlockInit.PALM_SHUTTER);
        simpleItem(BlockInit.AZURE_SHUTTER);
        simpleItem(BlockInit.DRIFTWOOD_SHUTTER);
        simpleItem(BlockInit.RIVER_SHUTTER);
        simpleItem(BlockInit.POISE_SHUTTER);
//        simpleItem(BlockInit.SILVER_SHUTTER);
//        simpleItem(BlockInit.LEAD_SHUTTER);

        simpleItem(BlockInit.COPPER_SHUTTER);
        simpleItem(BlockInit.OXIDIZED_COPPER_SHUTTER);
        simpleItem(BlockInit.WEATHERED_COPPER_SHUTTER);
        simpleItem(BlockInit.EXPOSED_COPPER_SHUTTER);

        simpleItem(BlockInit.WAXED_COPPER_SHUTTER, BlockInit.COPPER_SHUTTER);
        simpleItem(BlockInit.WAXED_OXIDIZED_COPPER_SHUTTER, BlockInit.OXIDIZED_COPPER_SHUTTER);
        simpleItem(BlockInit.WAXED_WEATHERED_COPPER_SHUTTER, BlockInit.WEATHERED_COPPER_SHUTTER);
        simpleItem(BlockInit.WAXED_EXPOSED_COPPER_SHUTTER, BlockInit.EXPOSED_COPPER_SHUTTER);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Shutter> item, RegistryObject<Shutter> originalItem) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ShutterMain.MODID,"item/" + originalItem.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Shutter> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ShutterMain.MODID,"item/" + item.getId().getPath()));
    }

}
