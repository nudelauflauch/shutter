package net.stehschnitzel.shutter.block;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.stehschnitzel.shutter.block.properties.ShutterDouble;
import net.stehschnitzel.shutter.block.properties.ShutterPos;
import net.stehschnitzel.shutter.block.properties.ShutterVoxels;
import net.stehschnitzel.shutter.init.SoundInit;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Shutter extends AbstractShutter {


    public Shutter(Settings settings) {
        this(settings, false);
    }

    public Shutter(Settings settings, boolean isMetal) {
        super(settings, isMetal);
        this.setDefaultState(this.getStateManager().getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(POWERED, false)
                .with(OPEN, 0)
                .with(POS, ShutterPos.NORMAL)
                .with(DOUBLE_DOOR, ShutterDouble.NONE));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return ShutterVoxels.getShape(state.get(FACING), state.get(OPEN), state.get(DOUBLE_DOOR));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!player.isSneaking()
                && !this.isMetal) {
            this.update(world, pos, state.get(OPEN) + 1, false);

            this.playSound(world, pos, world.getBlockState(pos).get(OPEN));
            return ActionResult.success(!world.isClient);
        }
        return ActionResult.FAIL;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        redstoneUpdate((World) world, neighborPos, pos);
        List<BlockState> sideblocks = getNeighborBlocks(world, pos);

        if (state.get(DOUBLE_DOOR) == ShutterDouble.NONE) {
            BlockPos right = getNeighborShutterPos(pos, ShutterDouble.RIGHT, state.get(FACING));
            BlockPos left = getNeighborShutterPos(pos, ShutterDouble.LEFT, state.get(FACING));


            if (sideblocks.get(0).getBlock() instanceof Shutter && pos.equals(getNeighborShutterPos(world, right))) {
                world.setBlockState(pos, world.getBlockState(pos).with(DOUBLE_DOOR, ShutterDouble.RIGHT), 18);

                updatePosNeighborHelper(world, pos);

            } else if (sideblocks.get(1).getBlock() instanceof Shutter && pos.equals(getNeighborShutterPos(world, left))) {
                world.setBlockState(pos, world.getBlockState(pos).with(DOUBLE_DOOR, ShutterDouble.LEFT), 18);

                updatePosNeighborHelper(world, pos);
            }
        }

        //resets it to None, if there are no shutters around
        if (state.get(DOUBLE_DOOR) == ShutterDouble.LEFT && !(sideblocks.get(1).getBlock() instanceof Shutter)) {
            world.setBlockState(pos, world.getBlockState(pos).with(DOUBLE_DOOR, ShutterDouble.NONE), 18);

            updatePosNeighborHelper(world, pos);
        }
        if (state.get(DOUBLE_DOOR) == ShutterDouble.RIGHT && !(sideblocks.get(0).getBlock() instanceof Shutter)) {
            world.setBlockState(pos, world.getBlockState(pos).with(DOUBLE_DOOR, ShutterDouble.NONE), 18);

            updatePosNeighborHelper(world, pos);
        }

        // resets the shutter to 0 when i cant be in state 2
        if (state.get(OPEN) == 2 && !canUpdate(world, pos)) {
            this.update((World) world, pos, 0, false);
            this.playSound((World) world, pos, world.getBlockState(pos).get(OPEN));
        }

        //update position
        if (pos.up().equals(neighborPos) || pos.down().equals(neighborPos)) {
            updatePosNeighborHelper(world, pos);
        }
        return state;
    }

    private void updatePosNeighborHelper(WorldAccess world, BlockPos pos) {
        if (this.getPosition(world, pos) != world.getBlockState(pos).get(POS)) {
            world.setBlockState(pos, world.getBlockState(pos).with(POS, this.getPosition(world, pos)), 3);
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos blockpos = ctx.getBlockPos();
        World level = ctx.getWorld();

        int open_state = 0;
        Direction direction = ctx.getHorizontalPlayerFacing();
        List<BlockState> sideblocks = getNeighborBlocks(level, blockpos, direction);
        ShutterDouble isdoubleDoor = ShutterDouble.NONE;
        boolean neighbor_has_signal = level.isReceivingRedstonePower(blockpos) || level.isReceivingRedstonePower(blockpos.up());

        //get if the neighbours are also shutters
        if (sideblocks.get(0).getBlock() instanceof Shutter && sideblocks.get(0).get(DOUBLE_DOOR) == ShutterDouble.NONE) {
            isdoubleDoor = ShutterDouble.RIGHT;
            open_state = sideblocks.get(0).get(OPEN);
            if (direction != sideblocks.get(0).get(FACING)) {
                direction = sideblocks.get(0).get(FACING);
                isdoubleDoor = ShutterDouble.LEFT;
            }
        } else if (sideblocks.get(1).getBlock() instanceof Shutter && sideblocks.get(1).get(DOUBLE_DOOR) == ShutterDouble.NONE) {
            isdoubleDoor = ShutterDouble.LEFT;
            open_state = sideblocks.get(1).get(OPEN);
            if (direction != sideblocks.get(1).get(FACING)) {
                direction = sideblocks.get(1).get(FACING);
                isdoubleDoor = ShutterDouble.RIGHT;
            }
        }

        if (this.getBlockBelow(blockpos, level) instanceof Shutter) {
            open_state = level.getBlockState(blockpos.down()).get(OPEN);
            direction = level.getBlockState(blockpos.down()).get(FACING);
        } else if (this.getBlockAbove(blockpos, level) instanceof Shutter) {
            open_state = level.getBlockState(blockpos.up()).get(OPEN);
            direction = level.getBlockState(blockpos.up()).get(FACING);
        } else if (ctx.getPlayer().isSneaking() && isdoubleDoor == ShutterDouble.NONE){
            direction = direction.getOpposite();
        }

        if (neighbor_has_signal) {
            open_state = isdoubleDoor == ShutterDouble.NONE ? this.stateTwoPossible(level, blockpos, true, true) ? 2 : 1 : this.stateTwoPossibleDouble(level, blockpos, true, isdoubleDoor, direction) ? 2 : 1;
            updateRedstone(level, blockpos, true, isdoubleDoor, direction);
        }

        return this.getDefaultState()
                .with(FACING, direction)
                .with(POWERED, neighbor_has_signal)
                .with(POS, getPosition(level, blockpos, isdoubleDoor))
                .with(DOUBLE_DOOR, isdoubleDoor)
                .with(OPEN, open_state);
    }
}