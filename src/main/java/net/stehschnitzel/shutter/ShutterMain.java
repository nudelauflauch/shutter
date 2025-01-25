package net.stehschnitzel.shutter;

import net.stehschnitzel.shutter.init.BlockInit;
import net.stehschnitzel.shutter.init.CreativTabInit;
import net.stehschnitzel.shutter.init.SoundInit;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(ShutterMain.MOD_ID)
public class ShutterMain {
    public static final String MOD_ID = "shutter";
    private static final Logger LOGGER = LogUtils.getLogger();


    public ShutterMain(IEventBus bus, ModContainer modContainer) {
        bus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);

        CreativTabInit.register(bus);
        CreativTabInit.registerDeferredItemRegister(bus);

        BlockInit.registerBlock(bus);
        BlockInit.registerBlockItem(bus);
        SoundInit.register(bus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }
}
