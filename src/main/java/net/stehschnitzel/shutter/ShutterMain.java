package net.stehschnitzel.shutter;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.stehschnitzel.shutter.common.blocks.Shutter;
import net.stehschnitzel.shutter.init.BlockInit;
import net.stehschnitzel.shutter.init.CreativTabInit;
import net.stehschnitzel.shutter.init.SoundInit;
import org.slf4j.Logger;

@Mod(ShutterMain.MOD_ID)
public class ShutterMain {
	public static final String MOD_ID = "shutter";
	public static final Logger LOGGER = LogUtils.getLogger();

	public ShutterMain(IEventBus bus) {
		bus.addListener(this::commonSetup);
		NeoForge.EVENT_BUS.register(this);

		CreativTabInit.register(bus);

//		CreativTabInit.registerDeferredItemRegister(bus);
		BlockInit.registerBlockItem(bus);
		BlockInit.registerBlock(bus);
		SoundInit.register(bus);
	}

	private void commonSetup(final FMLCommonSetupEvent event)  {

	}

	// You can use SubscribeEvent and let the Event Bus discover methods to call
	@SubscribeEvent
	public void onServerStarting(ServerStartingEvent event) {

	}

    @SubscribeEvent
    public void rightClickEvent(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        Block block = level.getBlockState(pos).getBlock();



        if (event.getHand().equals(InteractionHand.MAIN_HAND) &&
                (block instanceof TransparentBlock || block instanceof IronBarsBlock ||
                    block instanceof FenceBlock || block instanceof FenceGateBlock)) {
            Player player = event.getEntity();
            BlockHitResult hit = event.getHitVec();

            if (!(player.getItemInHand(event.getHand()).getItem() instanceof BlockItem)) {
                BlockPos[] neighbourPos = {pos.north(), pos.south(), pos.west(), pos.east()};
                for (BlockPos localPos : neighbourPos) {

                    if (level.getBlockState(localPos).getBlock() instanceof Shutter shutter) {
                        shutter.useWithoutItem(level.getBlockState(localPos), level, localPos, player, hit);
                        player.swing(InteractionHand.MAIN_HAND);
                    }
                }
            }
        }
    }

}