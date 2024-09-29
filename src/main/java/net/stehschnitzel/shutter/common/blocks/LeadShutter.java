package net.stehschnitzel.shutter.common.blocks;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class LeadShutter extends Shutter {

	public LeadShutter(Properties properties) {
		super(properties, true);
	}

	@Override
	public InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
		if (!pPlayer.mayBuild()) {

			return InteractionResult.PASS;
		} else if (!pPlayer.isCrouching()) {
			int rand = new Random().nextInt(100);
			if (rand < 35 && !pLevel.isClientSide()) {
				super.update(pLevel, pPos, pState.getValue(OPEN) + 1, false);

				super.playSound(pLevel, pPos, pLevel.getBlockState(pPos).getValue(OPEN));
			}
			return InteractionResult.sidedSuccess(pLevel.isClientSide);
		}
		return InteractionResult.FAIL;
	}
}
