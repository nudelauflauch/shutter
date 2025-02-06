package net.stehschnitzel.shutter.block;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.stehschnitzel.shutter.block.properties.ShutterDouble;
import net.stehschnitzel.shutter.block.properties.ShutterPos;
import net.stehschnitzel.shutter.init.SoundInit;
import org.jetbrains.annotations.Nullable;

import java.util.List;

abstract class AbstractShutter extends Block {

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty POWERED = Properties.POWERED;
    public static final EnumProperty<ShutterPos> POS = EnumProperty
            .of("half", ShutterPos.class);

    public static final IntProperty OPEN = IntProperty.of("open", 0,2);

    public static final EnumProperty<ShutterDouble> DOUBLE_DOOR = EnumProperty
            .of("double_door", ShutterDouble.class);
    //	private final BlockState[] sideblocks = new BlockState[2];
    boolean isMetal = false;

    public AbstractShutter(Settings settings, boolean isMetal) {
        super(settings);
        this.isMetal = isMetal;
        this.setDefaultState(this.getStateManager().getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(POWERED, false)
                .with(OPEN, 0)
                .with(POS, ShutterPos.NORMAL)
                .with(DOUBLE_DOOR, ShutterDouble.NONE));
    }

    void updateRedstone(World world, BlockPos pos, boolean first) {
        updateRedstone(world, pos, first, world.getBlockState(pos).get(DOUBLE_DOOR), world.getBlockState(pos).get(FACING));
    }

    void updateRedstone(World world, BlockPos pos, boolean first, ShutterDouble doorType, Direction facing) {
        if (doorType == ShutterDouble.NONE) {
             if (stateTwoPossible(world, pos, first, false)) {
                updateAll(world, pos, 2, first, false);
            } else {
                updateAll(world, pos, 1, first, false);
            }
        } else {
            BlockPos neighborPos = getNeighborShutterPos(pos, doorType, facing);

             if (stateTwoPossibleDouble(world, pos, first, doorType, facing)) {
                 updateAll(world, pos, 2, first, true);
                 updateAll(world, neighborPos, 2, false, true);

            } else {
                updateAll(world, pos, 1, first, true);
                updateAll(world, neighborPos, 1, false, true);
            }
        }
    }

    public void update(World world, BlockPos pos, int state, boolean first) {
        ShutterDouble doorType = world.getBlockState(pos).get(DOUBLE_DOOR);

        if (doorType == ShutterDouble.NONE) {
            updateSingleDoor(world, pos, state, first);
        } else {
            updateDoubleDoor(world, pos, state, first, doorType);
        }
    }

    private void updateSingleDoor(World world, BlockPos pos, int state, boolean first) {
        if (state < 2) {
            updateAll(world, pos, state, first, false);
        } else if (state == 2 && stateTwoPossible(world, pos, first, false)) {
            updateAll(world, pos, 2, first, false);
        } else {
            updateAll(world, pos, 0, first, false);
        }
    }

    private void updateDoubleDoor(World world, BlockPos pos, int state, boolean first, ShutterDouble doorType) {
        List<BlockState> sideblocks = getNeighborBlocks(world, pos);

        BlockPos neighborPos = getNeighborShutterPos(world, pos);

        if (state < 2) {
            updateAll(world, pos, state, first, true);
            updateAll(world, neighborPos, state, first, true);

        } else if (state == 2 && stateTwoPossibleDouble(world, pos, first)) {
            updateAll(world, pos, 2, first, true);
            updateAll(world, neighborPos, 2, first, true);

        } else {
            updateAll(world, pos, 0, first, true);
            updateAll(world, neighborPos, 0, first, true);
        }
    }

    boolean stateTwoPossibleDouble(World world, BlockPos pos, boolean first) {
        return stateTwoPossibleDouble(world, pos, first, world.getBlockState(pos).get(DOUBLE_DOOR), world.getBlockState(pos).get(FACING));
    }

    boolean stateTwoPossibleDouble(World world, BlockPos pos, boolean first, ShutterDouble shutterDouble, Direction facing) {
        boolean thisCanUpdate = stateTwoPossible(world, pos, first, true);
        BlockPos neighborPos = getNeighborShutterPos(pos, shutterDouble, facing);

        return thisCanUpdate && stateTwoPossible(world, neighborPos, first, true);
    }

    private void updateAll(World world, BlockPos pos, int state, boolean first, boolean isDouble) {
        if (!first) {
            setOpen(world, pos, state);
        }

        boolean[] arr = {true, false};

        for (boolean up : arr) {
            int y = pos.getY() + (up ? 1 : -1);

            while (y > -70 && y < 330) {
                BlockPos newPos = new BlockPos(pos.getX(), y, pos.getZ());
                Block block = world.getBlockState(newPos).getBlock();

                if (block instanceof Shutter shutter) {
                    if (isDouble && world.getBlockState(newPos).get(DOUBLE_DOOR) == ShutterDouble.NONE) {
                        break;
                    }
                    if (!isDouble && world.getBlockState(newPos).get(DOUBLE_DOOR) != ShutterDouble.NONE) {
                        break;
                    }
                    shutter.setOpen(world, newPos, state);
                } else {
                    break;
                }

                y = up ? y + 1 : y - 1;
            }
        }
    }

    boolean stateTwoPossible(World world, BlockPos pos, boolean first, boolean isDouble) {
        boolean[] arr = {true, false};

        if (!first &&
                world.getBlockState(pos).getBlock() instanceof Shutter shutter &&
                !shutter.canUpdate(world, pos)) {
            return false;
        }

        for (boolean up : arr) {
            int y = pos.getY();

            while (y > -70 && y < 330) {
                BlockPos newPos = new BlockPos(pos.getX(), y, pos.getZ());
                Block block = world.getBlockState(newPos).getBlock();

                if (block instanceof Shutter shutter) {
                    if (isDouble && world.getBlockState(newPos).get(DOUBLE_DOOR) == ShutterDouble.NONE) {
                        break;
                    }
                    if (!isDouble && world.getBlockState(newPos).get(DOUBLE_DOOR) != ShutterDouble.NONE) {
                        break;
                    }
                    if (!shutter.canUpdate(world, newPos)) {
                        return false;
                    }
                } else {
                    break;
                }

                y = up ? y + 1 : y - 1;
            }
        }

        return true;
    }

    List<BlockState> getNeighborBlocks(WorldAccess world, BlockPos pos) {
        return getNeighborBlocks(world, pos, world.getBlockState(pos).get(FACING));
    }

    List<BlockState> getNeighborBlocks(WorldAccess world, BlockPos pos, Direction facing) {
        switch (facing) {
            case NORTH -> {
                return List.of(new BlockState[]{world.getBlockState(pos.east()), world.getBlockState(pos.west())});
            }
            case SOUTH -> {
                return List.of(new BlockState[]{world.getBlockState(pos.west()), world.getBlockState(pos.east())});
            }
            case EAST -> {
                return List.of(new BlockState[]{world.getBlockState(pos.south()), world.getBlockState(pos.north())});
            }
            default -> {
                return List.of(new BlockState[]{world.getBlockState(pos.north()), world.getBlockState(pos.south())});
            }
        }
    }

    public void playSound(World world, BlockPos pos, int state) {
        world.playSound(null, pos, this.getSound(state), SoundCategory.BLOCKS, 1F, 1F);
    }

    private SoundEvent getSound(int state) {
        return state == 0
                ? SoundInit.SHUTTER_CLOSE
                : state == 2
                ? SoundInit.SHUTTER_OPEN_HALF
                : SoundInit.SHUTTER_OPEN_FULL;
    }

    BlockPos getNeighborShutterPos(WorldAccess world, BlockPos pos) {
        return getNeighborShutterPos(pos, world.getBlockState(pos));
    }

    BlockPos getNeighborShutterPos(BlockPos pos, BlockState state) {
        return getNeighborShutterPos(pos, state.get(DOUBLE_DOOR), state.get(FACING));
    }

    BlockPos getNeighborShutterPos(BlockPos pos, ShutterDouble shutterDouble, Direction facing) {
        switch (facing) {
            case SOUTH -> {
                return shutterDouble == ShutterDouble.RIGHT ? pos.west() : pos.east();
            }
            case NORTH -> {
                return shutterDouble == ShutterDouble.RIGHT ? pos.east() : pos.west();
            }
            case EAST -> {
                return shutterDouble == ShutterDouble.RIGHT ? pos.south() : pos.north();
            }
            default -> {
                return shutterDouble == ShutterDouble.RIGHT ? pos.north() : pos.south();
            }
        }
    }

    public void redstoneUpdate(World pWorld, BlockPos pFromPos, BlockPos pPos) {
        // For redstone or power
        if (!(pWorld.getBlockState(pFromPos).getBlock() instanceof Shutter)) {
            // opening
            if ((pWorld.isReceivingRedstonePower(pPos) || pWorld.isReceivingRedstonePower(pPos.up())) && !pWorld.getBlockState(pPos).get(POWERED)) {
                setPowered(pWorld, pPos, true);
                updateRedstone(pWorld, pPos, false);
                this.playSound(pWorld, pPos, pWorld.getBlockState(pPos).get(OPEN));

            // closing
            } else if (!pWorld.isReceivingRedstonePower(pPos)
                    && pWorld.getBlockState(pPos).get(POWERED)) {
                setPowered(pWorld, pPos, false);
                this.update(pWorld, pPos, 0, false);
                this.playSound(pWorld, pPos, 0);
            }
        }
    }

    ShutterPos getPosition(WorldAccess pWorld, BlockPos pPos) {
        return getPosition(pWorld, pPos, pWorld.getBlockState(pPos).get(DOUBLE_DOOR));
    }

    ShutterPos getPosition(WorldAccess pWorld, BlockPos pPos, ShutterDouble shutterDouble) {

        boolean above = this.getBlockAbove(pPos, pWorld) instanceof Shutter &&
                        ((shutterDouble == ShutterDouble.NONE &&
                        pWorld.getBlockState(pPos.up()).get(DOUBLE_DOOR) == ShutterDouble.NONE) ||
                        (shutterDouble != ShutterDouble.NONE &&
                        pWorld.getBlockState(pPos.up()).get(DOUBLE_DOOR) != ShutterDouble.NONE));

        boolean below = this.getBlockBelow(pPos, pWorld) instanceof Shutter && ((shutterDouble == ShutterDouble.NONE &&
                    pWorld.getBlockState(pPos.down()).get(DOUBLE_DOOR) == ShutterDouble.NONE) ||
                    (shutterDouble != ShutterDouble.NONE &&
                    pWorld.getBlockState(pPos.down()).get(DOUBLE_DOOR) != ShutterDouble.NONE));

        if (above && below) {
            return ShutterPos.MIDDLE;
        } else if (above) {
            return ShutterPos.LOWER;
        } else if (below) {
            return ShutterPos.UPPER;
        }
        return ShutterPos.NORMAL;
    }

//    @Override
//    public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction direction) {
//        return this.isMetal || state.is(BlockInit.GLASS_SHUTTER.get());
//    }
//
//    @Override
//    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction direction) {
//        return !this.isMetal || state.is(BlockInit.GLASS_SHUTTER.get()) ? 20 : 0;
//    }
//
//    @Override
//    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction direction) {
//        return !this.isMetal || state.is(BlockInit.GLASS_SHUTTER.get()) ? 5 : 0;
//    }

    public boolean canUpdate(WorldAccess world, BlockPos pos) {
        List<BlockState> sideblocks = getNeighborBlocks(world, pos);

        ShutterDouble shutterDouble = world.getBlockState(pos).get(DOUBLE_DOOR);
        if (shutterDouble == ShutterDouble.NONE) {
            return canUpdateSingle(sideblocks);
        }
        return canUpdateDouble(shutterDouble, sideblocks);
    }

    private boolean canUpdateDouble(ShutterDouble shutterDouble, List<BlockState> sideblocks) {
        if (shutterDouble == ShutterDouble.RIGHT) {
            return isValidBlockForUpdate(sideblocks.get(1).getBlock());
        }
        return isValidBlockForUpdate(sideblocks.get(0).getBlock());
    }

    boolean canUpdateSingle(List<BlockState> sideblocks) {
        for (BlockState block1 : sideblocks) {
            if (!isValidBlockForUpdate(block1.getBlock())) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidBlockForUpdate(Block block) {
        return block == Blocks.AIR
                || block instanceof PlantBlock
                || block instanceof FenceBlock
                || block instanceof FenceGateBlock
                || block == Blocks.WATER || block == Blocks.LAVA
                || block == Blocks.IRON_BARS
                || block instanceof LanternBlock
                || block instanceof FlowerPotBlock
                || block instanceof TorchBlock
                || block instanceof CandleBlock
                || block instanceof ButtonBlock
                || block instanceof LadderBlock
                || block instanceof SignBlock
                || block instanceof ChainBlock
                || block instanceof VineBlock
                || block instanceof RedstoneTorchBlock
                || block instanceof LeverBlock
                || block instanceof TripwireBlock
                || block instanceof TripwireHookBlock
                || block instanceof LightningRodBlock
                || block instanceof BellBlock
                || block instanceof BigDripleafBlock
                || block instanceof BigDripleafStemBlock
                || block instanceof PointedDripstoneBlock
                || block instanceof AmethystClusterBlock
                || block instanceof BuddingAmethystBlock
                || block instanceof CobwebBlock
                || block instanceof CoralFanBlock
                || block instanceof CoralBlockBlock
                || block instanceof SkullBlock
                || block instanceof SporeBlossomBlock
                || block instanceof BambooBlock;
    }

    public void setPowered(World world, BlockPos pos, boolean state) {
        world.setBlockState(pos, world.getBlockState(pos).with(POWERED, state));
    }

    public void setOpen(World world, BlockPos pos, int state) {
        world.setBlockState(pos, world.getBlockState(pos).with(OPEN, state));
    }

    Block getBlockAbove(BlockPos pos, WorldAccess world) {
        return world.getBlockState(pos.up()).getBlock();
    }

    Block getBlockBelow(BlockPos pos, WorldAccess world) {
        return world.getBlockState(pos.down()).getBlock();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POS);
        builder.add(FACING);
        builder.add(OPEN);
        builder.add(POWERED);
        builder.add(DOUBLE_DOOR);
    }
}
