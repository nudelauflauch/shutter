package net.stehschnitzel.shutter;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.stehschnitzel.shutter.init.BlockInit;
import net.stehschnitzel.shutter.init.ItemInit;
import net.stehschnitzel.shutter.init.ShutterItemGroup;
import net.stehschnitzel.shutter.init.SoundInit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShutterMain implements ModInitializer {
	public static final String MOD_ID = "shutter";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ShutterItemGroup.registerItemGroups();

		ItemInit.registerModItems();
		BlockInit.registerModBlocks();

		BlockInit.registerOxidizables();

		SoundInit.registerSound();
	}
}