package net.stehschnitzel.shutter.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.stehschnitzel.shutter.common.blocks.properties.ShutterDouble;
import net.stehschnitzel.shutter.common.blocks.properties.ShutterPos;
import net.stehschnitzel.shutter.common.blocks.properties.ShutterVoxels;

import java.util.List;

public class Shutter extends AbstractShutter {

    public Shutter(Properties properties) {
        this(properties, false);
    }

    public Shutter(Properties properties, boolean isMetal) {
        super(properties, isMetal);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return ShutterVoxels.getShape(pState.getValue(FACING), pState.getValue(OPEN), pState.getValue(DOUBLE_DOOR));
    }

    @Override
    public InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        if (!pPlayer.mayBuild()) {
            return InteractionResult.PASS;
        } else if (!pPlayer.isCrouching()
                && !this.isMetal) {

            this.update(pLevel, pPos, pState.getValue(OPEN) + 1, false);
            if (pState.getValue(WATERLOGGED)) {
                pLevel.scheduleTick(pPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
            }

            this.playSound(pPlayer, pLevel, pPos);
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }
        return InteractionResult.FAIL;
    }

    @Override
    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
        redstoneUpdate(pLevel, pFromPos, pPos);
        List<BlockState> sideblocks = getNeighborBlocks(pLevel, pPos);

        // double shutter
        // checks if it should update its double block state
        if (pState.getValue(DOUBLE_DOOR) == ShutterDouble.NONE) {
            BlockPos right = getNeighborShutterPos(pPos, ShutterDouble.RIGHT, pState.getValue(FACING));
            BlockPos left = getNeighborShutterPos(pPos, ShutterDouble.LEFT, pState.getValue(FACING));

            if (sideblocks.get(0).getBlock() instanceof Shutter && pPos.equals(getNeighborShutterPos(pLevel, right))) {
                pLevel.setBlock(pPos, pLevel.getBlockState(pPos)
                        .setValue(DOUBLE_DOOR, ShutterDouble.RIGHT),
                        18);

                updatePosNeighborHelper(pLevel, pPos);

            } else if (sideblocks.get(1).getBlock() instanceof Shutter && pPos.equals(getNeighborShutterPos(pLevel, left))) {
                pLevel.setBlock(pPos, pLevel.getBlockState(pPos)
                        .setValue(DOUBLE_DOOR, ShutterDouble.LEFT),
                        18);

                updatePosNeighborHelper(pLevel, pPos);
            }
        }

        // resets it to None, if there are no shutters left or right
        if (pState.getValue(DOUBLE_DOOR) == ShutterDouble.LEFT && !(sideblocks.get(1).getBlock() instanceof Shutter)) {
            pLevel.setBlock(pPos, pLevel.getBlockState(pPos)
                    .setValue(DOUBLE_DOOR, ShutterDouble.NONE),
                    18);

            updatePosNeighborHelper(pLevel, pPos);
        }
        if (pState.getValue(DOUBLE_DOOR) == ShutterDouble.RIGHT && !(sideblocks.get(0).getBlock() instanceof Shutter)) {
            pLevel.setBlock(pPos, pLevel.getBlockState(pPos).setValue(DOUBLE_DOOR, ShutterDouble.NONE), 18);

            updatePosNeighborHelper(pLevel, pPos);
        }


        // resets the shutter to 0 when it can't be in state 2
        if (!pLevel.isClientSide && pState.getValue(OPEN) == 2
                && !canUpdate(pLevel, pPos)) {
            int open = hasRedstonePower(pLevel, pPos) ? 1 : 0;
            this.update(pLevel, pPos, open, false);
            this.playSound(null, pLevel, pPos);
        }

        // update position
        if (pPos.above().equals(pFromPos) || pPos.below().equals(pFromPos)) {
            updatePosNeighborHelper(pLevel, pPos);
        }

        if (pState.getValue(OPEN) != 0 && pState.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }
    }

    private void updatePosNeighborHelper(Level level, BlockPos pos) {
        if (this.getPosition(level, pos) != level.getBlockState(pos).getValue(SHUTTER_POS)) {
            level.setBlock(pos, level.getBlockState(pos).setValue(SHUTTER_POS, this.getPosition(level, pos)), 3);
        }
    }

    @Override
    public int getAnalogOutputSignal(BlockState pState, Level pLevel, BlockPos pPos) {
        switch (pState.getValue(OPEN)) {
            case 1: return 7;
            case 2: return 15;
            default: return 0;
        }
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState pState) {
        return pState.getValue(OPEN) != 0;
    }

    @Override
    public int getSignal(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pDirection) {
        return super.getSignal(pState, pLevel, pPos, pDirection);
    }

    @Override
    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        if (pState.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }

        return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    public void destroy(LevelAccessor pLevel, BlockPos pPos, BlockState pState) {
        if (pState.getValue(OPEN) == 2) {
            BlockPos[] neighbourPos = {pPos.north(), pPos.south(), pPos.west(), pPos.east()};
            for (BlockPos localPos : neighbourPos) {
                if (pLevel.getBlockState(localPos).getBlock() instanceof InteractionShutter) {
                    pLevel.setBlock(localPos, Blocks.AIR.defaultBlockState(), 127);
                }
            }
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        FluidState fluidstate = pContext.getLevel().getFluidState(pContext.getClickedPos());
        BlockPos blockpos = pContext.getClickedPos();
        Level level = pContext.getLevel();

        int open_state = 0;
        Direction direction = pContext.getHorizontalDirection();
        ShutterDouble doubleDoor = ShutterDouble.NONE;


        // copies the direction from upper or lower
        if (this.getBlockBelow(blockpos, level) instanceof Shutter) {
            direction = level.getBlockState(blockpos.below()).getValue(FACING);

        } else if (this.getBlockAbove(blockpos, level) instanceof Shutter) {
            direction = level.getBlockState(blockpos.above()).getValue(FACING);

        } else if (pContext.getPlayer() != null && pContext.getPlayer().isShiftKeyDown()) {
            direction = direction.getOpposite();
        }


        List<BlockState> sideBlocks = getNeighborBlocks(level, blockpos, direction);

        // sets double
        if (sideBlocks.get(0).getBlock() instanceof Shutter && sideBlocks.get(0).getValue(DOUBLE_DOOR) == ShutterDouble.NONE) {
            doubleDoor = ShutterDouble.RIGHT;
            open_state = sideBlocks.getFirst().getValue(OPEN);

            if (direction != sideBlocks.getFirst().getValue(FACING)) {
                direction = sideBlocks.getFirst().getValue(FACING);
                doubleDoor = ShutterDouble.LEFT;
            }
        } else if (sideBlocks.get(1).getBlock() instanceof Shutter && sideBlocks.get(1).getValue(DOUBLE_DOOR) == ShutterDouble.NONE) {
            doubleDoor = ShutterDouble.LEFT;


            if (direction != sideBlocks.get(1).getValue(FACING)) {
                direction = sideBlocks.get(1).getValue(FACING);
                doubleDoor = ShutterDouble.RIGHT;
            }
        }

        ShutterPos shutterPos = getPosition(level, blockpos, doubleDoor);

        //decides what open state the shutter should be
        //checks if the connected to the lower one > sets open state
        //if not it sets open state to neighbour one
        if (shutterPos != ShutterPos.NORMAL) {
            if (shutterPos == ShutterPos.LOWER) {
                open_state = level.getBlockState(blockpos.above()).getValue(OPEN);
            } else if (shutterPos == ShutterPos.MIDDLE) {
                open_state = level.getBlockState(blockpos.below()).getValue(OPEN);
                update(level, blockpos, open_state, true, doubleDoor, direction);

            } else if (shutterPos == ShutterPos.UPPER) {
                open_state = level.getBlockState(blockpos.below()).getValue(OPEN);
            }
            if (doubleDoor != ShutterDouble.NONE) {
                level.setBlockAndUpdate(getNeighborShutterPos(blockpos, doubleDoor, direction),
                        level.getBlockState(getNeighborShutterPos(blockpos, doubleDoor, direction))
                                .setValue(OPEN, open_state));
            }
        }


        boolean neighbor_has_signal = hasRedstonePower(level, blockpos, direction);

        if (neighbor_has_signal) {
            open_state = doubleDoor == ShutterDouble.NONE
                    ? this.stateTwoPossible(level, blockpos, true, true) ? 2 : 1
                    : this.stateTwoPossibleDouble(level, blockpos, true, doubleDoor, direction) ? 2 : 1;

            updateRedstone(level, blockpos, true, doubleDoor, direction);
        }

        BlockState returnState = this.defaultBlockState()
                .setValue(FACING, direction)
                .setValue(POWERED, Boolean.valueOf(neighbor_has_signal))
                .setValue(SHUTTER_POS, shutterPos)
                .setValue(DOUBLE_DOOR, doubleDoor)
                .setValue(OPEN, open_state)
                .setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));

        if (open_state == 2) {
            handleInteractBlock(level, blockpos, returnState, open_state);
        }

        return returnState;
    }
}