package net.stehschnitzel.shutter;

import net.fabricmc.api.ClientModInitializer;
import net.stehschnitzel.shutter.init.BlockInit;

public class ShutterModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.GLASS_SHUTTER, RenderLayer.getCutout());
    }
}