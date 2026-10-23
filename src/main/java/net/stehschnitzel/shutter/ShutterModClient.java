package net.stehschnitzel.shutter;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.stehschnitzel.shutter.init.BlockInit;

public class ShutterModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(BlockInit.GLASS_SHUTTER, net.minecraft.client.renderer.chunk.ChunkSectionLayer.CUTOUT);
    }
}