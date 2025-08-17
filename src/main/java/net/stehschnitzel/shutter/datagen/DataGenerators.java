package net.stehschnitzel.shutter.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.stehschnitzel.shutter.ShutterMain;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = ShutterMain.MOD_ID)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(true, new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(ShutterBlockLootTables::new, LootContextParamSets.BLOCK)), lookupProvider));

//        generator.addProvider(true, new RecipeProvider.Runner(packOutput, lookupProvider));

        BlockTagsProvider blockTagsProvider = new ShutterBlockTagProvider(packOutput, lookupProvider);
        generator.addProvider(true, blockTagsProvider);

        generator.addProvider(true, new ShutterModelProvider(packOutput));
        event.createProvider(ShutterRecipeProvider.Runner::new);
    }

    @SubscribeEvent
    public static void gatherServerData(GatherDataEvent.Server event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(true, new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(ShutterBlockLootTables::new, LootContextParamSets.BLOCK)), lookupProvider));
//        generator.addProvider(true, new RecipeProvider.Runner(packOutput, lookupProvider));
        generator.addProvider(true, new ShutterModelProvider(packOutput));
        event.createProvider(ShutterRecipeProvider.Runner::new);
    }
}