package net.stehschnitzel.shutter.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.stehschnitzel.shutter.ShutterMain;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = ShutterMain.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        net.minecraft.data.DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new ShutterBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), LootTableProvider.create(packOutput));
        generator.addProvider(event.includeClient(), new ShutterItemModelGenerator(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), new ShutterRecipeProvider(packOutput));

        generator.addProvider(event.includeServer(), new ShutterBlockTagProvider(packOutput, lookupProvider, existingFileHelper));
    }
}