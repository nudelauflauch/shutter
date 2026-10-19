package net.stehschnitzel.shutter.mixin;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.stehschnitzel.shutter.block.Shutter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class FenceMixin {

	@Inject(method = "isExceptionForConnection", at = @At("RETURN"), cancellable = true)
	private static void dontConnect(BlockState pState,
                                    CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(cir.getReturnValue() || pState.getBlock() instanceof Shutter);
	}
}