package net.stehschnitzel.shutter.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;

public class GoldShutter extends Shutter {

	public GoldShutter(Properties properties) {
		super(properties, true, true);
	}

	@Override
	public InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
		if (!pPlayer.mayBuild()) {
			return InteractionResult.PASS;
		} else if (!pPlayer.isCrouching()
				&& !pLevel.getBlockState(pPos).getValue(Shutter.POWERED)
				&& this.update(pLevel, pPos, pState.getValue(OPEN) + 1, false)) {
			if (pState.getValue(WATERLOGGED)) {
				pLevel.scheduleTick(pPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
			}
			this.playSound(pLevel, pPos);
			return InteractionResult.SUCCESS_SERVER;
		}

		return InteractionResult.FAIL;
	}

	@Override
	public boolean update(Level pLevel, BlockPos pPos, int state, boolean first) {
		if (!pLevel.getBlockState(pPos).getValue(Shutter.POWERED)) {
			return super.update(pLevel, pPos, state, first);
		}
		return false;
	}

	@Override
	public void redstoneUpdate(Level pLevel, BlockPos neighborBlock, BlockPos pPos) {
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
