package net.stehschnitzel.shutter.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class GoldShutter extends Shutter {

	public GoldShutter(Properties p_49795_) {
		super(p_49795_);
	}

	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
			Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
		if (!pPlayer.mayBuild()) {
			return InteractionResult.PASS;
		} else if (!pPlayer.isCrouching() && pHand.equals(InteractionHand.MAIN_HAND)
				&& !pLevel.getBlockState(pPos).getValue(Shutter.POWERED)) {
			this.update(pLevel, pPos, pState.getValue(OPEN) + 1, false);
			this.playSound(pLevel, pPos);
			return InteractionResult.sidedSuccess(pLevel.isClientSide);
		}
		return InteractionResult.FAIL;
	}

	@Override
	public void update(Level pLevel, BlockPos pPos, int state, boolean first) {
		if (!pLevel.getBlockState(pPos).getValue(Shutter.POWERED)) {
			super.update(pLevel, pPos, state, first);
		}
	}

	@Override
	public void redstoneUpdate(Level pLevel, BlockPos pFromPos, BlockPos pPos) {
		if (pLevel.hasNeighborSignal(pPos)) {
			pLevel.setBlockAndUpdate(pPos,
					pLevel.getBlockState(pPos).setValue(Shutter.POWERED, true));
		} else if (!pLevel.hasNeighborSignal(pPos)
				&& pLevel.getBlockState(pPos).getValue(POWERED)) {
			pLevel.setBlockAndUpdate(pPos, pLevel.getBlockState(pPos)
					.setValue(Shutter.POWERED, false));
		}
	}
}
