package net.stehschnitzel.shutter.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class GoldShutter extends Shutter {

    public GoldShutter(Properties properties) {
        super(properties, true);
    }

    @Override
    public InteractionResult useWithoutItem(net.minecraft.world.level.block.state.BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, net.minecraft.world.phys.BlockHitResult pHitResult) {
        if (!pPlayer.mayBuild()) {
            return InteractionResult.PASS;
        } else if (!pPlayer.isCrouching()
                && !pLevel.getBlockState(pPos).getValue(Shutter.POWERED)) {
            this.update(pLevel, pPos, pState.getValue(OPEN) + 1, false);
            this.playSound(pPlayer, pLevel, pPos);
            return InteractionResult.SUCCESS_SERVER;
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
    public void redstoneUpdate(Level pLevel, BlockPos pPos) {
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