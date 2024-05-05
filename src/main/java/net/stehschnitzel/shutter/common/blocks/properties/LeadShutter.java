package net.stehschnitzel.shutter.shutter;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class LeadShutter extends Shutter {

	public LeadShutter(Properties p_49795_) {
		super(p_49795_);
	}

	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
			Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
		if (!pPlayer.isCrouching() && pHand.equals(InteractionHand.MAIN_HAND)) {
			int rand = new Random().nextInt(100);
			if (rand < 35 && !pLevel.isClientSide()) {
				super.update(pLevel, pPos, pState.getValue(OPEN) + 1, false);

				super.playSound(pLevel, pPos);
			}
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.FAIL;
	}
}
