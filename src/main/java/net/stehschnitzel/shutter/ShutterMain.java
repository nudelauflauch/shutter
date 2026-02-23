package net.stehschnitzel.shutter;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.stehschnitzel.shutter.common.blocks.Shutter;
import net.stehschnitzel.shutter.init.BlockInit;
import net.stehschnitzel.shutter.init.CreativTabInit;
import net.stehschnitzel.shutter.init.SoundInit;

@Mod(ShutterMain.MODID)
public class ShutterMain {
	public static final String MODID = "shutter";
	public ShutterMain() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		BlockInit.register(bus);
		SoundInit.register(bus);
        CreativTabInit.register(bus);

		MinecraftForge.EVENT_BUS.register(this);
	}

    @SubscribeEvent
    public void rightClickEvent(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        Block block = level.getBlockState(pos).getBlock();
        if (block instanceof GlassBlock || block instanceof IronBarsBlock) {
            Player player = event.getEntity();
            InteractionHand hand = event.getHand();
            BlockHitResult hit = event.getHitVec();

            if (!level.isClientSide) {
                BlockPos[] neighbourPos = {pos.north(), pos.south(), pos.west(), pos.east()};
                for (BlockPos localPos : neighbourPos) {

                    if (level.getBlockState(localPos).getBlock() instanceof Shutter shutter) {
                        shutter.use(level.getBlockState(localPos), level, localPos, player, hand, hit);
                    }
                }
            }
        }
    }

}
