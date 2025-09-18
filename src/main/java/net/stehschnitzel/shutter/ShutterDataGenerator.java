package net.stehschnitzel.shutter;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.stehschnitzel.shutter.datagen.ShutterBlockTagProvider;
import net.stehschnitzel.shutter.datagen.ShutterLootTablesProvider;
import net.stehschnitzel.shutter.datagen.ShutterModelProvider;
import net.stehschnitzel.shutter.datagen.ShutterRecipeProvider;

public class ShutterDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ShutterBlockTagProvider::new);
		pack.addProvider(ShutterRecipeProvider::new);
		pack.addProvider(ShutterLootTablesProvider::new);
		pack.addProvider(ShutterModelProvider::new);
	}
}
