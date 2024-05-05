package net.stehschnitzel.shutter.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
<<<<<<< Updated upstream
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.stehschnitzel.shutter.common.blocks.Shutter;
=======

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.stehschnitzel.shutter.shutter.Shutter;
>>>>>>> Stashed changes

@Mixin(Block.class)
public class FenceMixins {

<<<<<<< Updated upstream
	@Inject(method = "isExceptionForConnection", at = @At("RETURN"), cancellable = true)
	private static void dontConnect(BlockState pState,
			CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(cir.getReturnValue() || pState.getBlock() instanceof Shutter);
	}

	// @Redirect(method = "isExceptionForConnection", at = @At(value = "INVOKE",
	// target =
	// "isExceptionForConnection(Lnet/minecraft/world/level/block/state/BlockState;)V"))
	// public boolean dontConnect(BlockState pState) {
	// return pState.getBlock() instanceof Shutter;
	// }
=======
	@Inject(method = "isExceptionForConnection", at = @At("HEAD"))
	protected boolean isExceptionForConnection(BlockState pState) {
		if (pState.getBlock() instanceof Shutter) {
			return true;
		} else {
			return Block.isExceptionForConnection(pState);
		}
		
	}
	
>>>>>>> Stashed changes
}
