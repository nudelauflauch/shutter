package net.stehschnitzel.shutter.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.stehschnitzel.shutter.block.properties.ShutterDouble;
import net.stehschnitzel.shutter.block.properties.ShutterPos;
import net.stehschnitzel.shutter.block.properties.ShutterVoxels;
import org.jspecify.annotations.Nullable;

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
            return InteractionResult.SUCCESS_SERVER;
        }
        return InteractionResult.FAIL;
    }

    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, @Nullable Orientation orientation, boolean movedByPiston) {
        List<BlockState> sideblocks = getNeighborBlocks(level, pos);

        // double shutter
        // checks if it should update its double block state
        if (state.getValue(DOUBLE_DOOR) == ShutterDouble.NONE) {
            BlockPos right = getNeighborShutterPos(pos, ShutterDouble.RIGHT, state.getValue(FACING));
            BlockPos left = getNeighborShutterPos(pos, ShutterDouble.LEFT, state.getValue(FACING));

            if (sideblocks.get(0).getBlock() instanceof Shutter && pos.equals(getNeighborShutterPos(level, right))) {
                (level).setBlock(pos, level.getBlockState(pos)
                                .setValue(DOUBLE_DOOR, ShutterDouble.RIGHT),
                        18);

                updatePosNeighborHelper(level, pos);

            } else if (sideblocks.get(1).getBlock() instanceof Shutter && pos.equals(getNeighborShutterPos(level, left))) {
                (level).setBlock(pos, level.getBlockState(pos)
                                .setValue(DOUBLE_DOOR, ShutterDouble.LEFT),
                        18);

                updatePosNeighborHelper(level, pos);
            }
        }

        // resets it to None, if there are no shutters left or right
        if (state.getValue(DOUBLE_DOOR) == ShutterDouble.LEFT && !(sideblocks.get(1).getBlock() instanceof Shutter)) {
            (level).setBlock(pos, level.getBlockState(pos)
                            .setValue(DOUBLE_DOOR, ShutterDouble.NONE),
                    18);

            updatePosNeighborHelper(level, pos);
        }
        if (state.getValue(DOUBLE_DOOR) == ShutterDouble.RIGHT && !(sideblocks.get(0).getBlock() instanceof Shutter)) {
            (level).setBlock(pos, level.getBlockState(pos).setValue(DOUBLE_DOOR, ShutterDouble.NONE), 18);

            updatePosNeighborHelper(level, pos);
        }


        // resets the shutter to 0 when it can't be in state 2
        if (!level.isClientSide() && state.getValue(OPEN) == 2
                && !canUpdate(level, pos)) {
            int open = hasRedstonePower(level, pos) ? 1 : 0;
            this.update(level, pos, open, false);
            this.playSound(null, level, pos);
        }

        if (state.getValue(OPEN) != 0 && state.getValue(WATERLOGGED)) {
            (level).scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
    }

    private void updatePosNeighborHelper(Level level, BlockPos pos) {
        if (this.getPosition(level, pos) != level.getBlockState(pos).getValue(SHUTTER_POS)) {
            level.setBlock(pos, level.getBlockState(pos).setValue(SHUTTER_POS, this.getPosition(level, pos)), 3);
        }
    }

    @Override
    protected int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos, Direction direction) {
        switch (state.getValue(OPEN)) {
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
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess scheduledTickAccess, BlockPos pos,
                                     Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        if (state.getValue(WATERLOGGED)) {
            scheduledTickAccess.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        redstoneUpdate((Level) level, neighborPos, pos);

        // update position
        if (pos.above().equals(neighborPos) || pos.below().equals(neighborPos)) {
            updatePosNeighborHelper((Level) level, pos);
        }

        return super.updateShape(state, level, scheduledTickAccess, pos, direction, neighborPos, neighborState, random);
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