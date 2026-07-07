package net.stehschnitzel.shutter.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.stehschnitzel.shutter.common.blocks.properties.ShutterDouble;
import net.stehschnitzel.shutter.common.blocks.properties.ShutterPos;
import net.stehschnitzel.shutter.init.BlockInit;
import net.stehschnitzel.shutter.init.SoundInit;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

abstract class AbstractShutter extends Block implements SimpleWaterloggedBlock {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public static final EnumProperty<ShutterPos> SHUTTER_POS =
            EnumProperty.create("half", ShutterPos.class);

    public static final IntegerProperty OPEN =
            IntegerProperty.create("open", 0, 2);

    public static final EnumProperty<ShutterDouble> DOUBLE_DOOR =
            EnumProperty.create("double_door", ShutterDouble.class);

    boolean isMetal;

    public AbstractShutter(Properties properties, boolean isMetal) {
        super(properties);
        this.isMetal = isMetal;

        this.registerDefaultState(this.defaultBlockState()
                .setValue(FACING, Direction.NORTH)
                .setValue(POWERED, false)
                .setValue(OPEN, 0)
                .setValue(SHUTTER_POS, ShutterPos.NORMAL)
                .setValue(DOUBLE_DOOR, ShutterDouble.NONE)
                .setValue(WATERLOGGED, false));
    }

    void updateRedstone(Level level, BlockPos pos, boolean first) {
        updateRedstone(
                level,
                pos,
                first,
                level.getBlockState(pos).getValue(DOUBLE_DOOR),
                level.getBlockState(pos).getValue(FACING)
        );
    }

    void updateRedstone(Level level, BlockPos pos, boolean first, ShutterDouble doorType, Direction facing) {
        if (doorType == ShutterDouble.NONE) {
            if (stateTwoPossible(level, pos, first, false)) {
                updateAll(level, pos, 2, first, false);
            } else {
                updateAll(level, pos, 1, first, false);
            }
        } else {
            BlockPos neighborPos = getNeighborShutterPos(pos, doorType, facing);

            if (stateTwoPossibleDouble(level, pos, first, doorType, facing)) {
                updateAll(level, pos, 2, first, true);
                updateAll(level, neighborPos, 2, false, true);
            } else {
                updateAll(level, pos, 1, first, true);
                updateAll(level, neighborPos, 1, false, true);
            }
        }
    }

    public void update(Level level, BlockPos pos, int state, boolean first) {
        update(level, pos, state, first, level.getBlockState(pos));
    }

    public void update(Level level, BlockPos pos, int state, boolean first, BlockState blockState) {
        update(level, pos, state, first, blockState.getValue(DOUBLE_DOOR), blockState.getValue(FACING));
    }

    public void update(Level level, BlockPos pos, int state, boolean first, ShutterDouble shutterDouble, Direction facing) {
        if (shutterDouble == ShutterDouble.NONE) {
            updateSingleDoor(level, pos, state, first);
        } else {
            updateDoubleDoor(level, pos, state, first, shutterDouble, facing);
        }
    }

    private void updateSingleDoor(Level level, BlockPos pos, int state, boolean first) {
        if (state < 2) {
            updateAll(level, pos, state, first, false);
        } else if (state == 2 && stateTwoPossible(level, pos, first, false)) {
            updateAll(level, pos, state, first, false);
        } else {
            updateAll(level, pos, 0, first, false);
        }
    }

    private void updateDoubleDoor(Level level, BlockPos pos, int state, boolean first, ShutterDouble shutterDouble, Direction facing) {
        BlockPos neighborPos = getNeighborShutterPos(pos, shutterDouble, facing);

        if (state < 2) {
            updateAll(level, pos, state, first, true);
            updateAll(level, neighborPos, state, false, true);
        } else if (state == 2 && stateTwoPossibleDouble(level, pos, first, shutterDouble, facing)) {
            updateAll(level, pos, 2, first, true);
            updateAll(level, neighborPos, 2, false, true);
        } else {
            updateAll(level, pos, 0, first, true);
            updateAll(level, neighborPos, 0, false, true);
        }
    }

    boolean stateTwoPossibleDouble(Level level, BlockPos pos, boolean first, ShutterDouble shutterDouble, Direction facing) {
        boolean thisCanUpdate = stateTwoPossible(level, pos, first, true);
        BlockPos neighborPos = getNeighborShutterPos(pos, shutterDouble, facing);

        return thisCanUpdate && stateTwoPossible(level, neighborPos, first, true);
    }

    private void updateAll(Level level, BlockPos pos, int state, boolean first, boolean isDouble) {
        if (!first) {
            setOpen(level, pos, state);
            handleInteractBlock(level, pos, state);
        }

        boolean[] directions = {true, false};

        for (boolean up : directions) {
            int y = pos.getY() + (up ? 1 : -1);

            while (y > level.getMinBuildHeight() && y < level.getMaxBuildHeight()) {
                BlockPos newPos = new BlockPos(pos.getX(), y, pos.getZ());
                Block block = level.getBlockState(newPos).getBlock();

                if (block instanceof Shutter shutter) {
                    BlockState newState = level.getBlockState(newPos);

                    if (isDouble && newState.getValue(DOUBLE_DOOR) == ShutterDouble.NONE) {
                        break;
                    }

                    if (!isDouble && newState.getValue(DOUBLE_DOOR) != ShutterDouble.NONE) {
                        break;
                    }

                    shutter.setOpen(level, newPos, state);
                    handleInteractBlock(level, newPos, state);
                } else {
                    break;
                }

                y = up ? y + 1 : y - 1;
            }
        }
    }

    boolean stateTwoPossible(Level level, BlockPos pos, boolean first, boolean isDouble) {
        boolean[] directions = {true, false};

        if (!first
                && level.getBlockState(pos).getBlock() instanceof Shutter shutter
                && !shutter.canUpdate(level, pos)) {
            return false;
        }

        for (boolean up : directions) {
            int y = pos.getY();

            while (y > level.getMinBuildHeight() && y < level.getMaxBuildHeight()) {
                BlockPos newPos = new BlockPos(pos.getX(), y, pos.getZ());
                Block block = level.getBlockState(newPos).getBlock();

                if (block instanceof Shutter shutter) {
                    BlockState newState = level.getBlockState(newPos);

                    if (isDouble && newState.getValue(DOUBLE_DOOR) == ShutterDouble.NONE) {
                        break;
                    }

                    if (!isDouble && newState.getValue(DOUBLE_DOOR) != ShutterDouble.NONE) {
                        break;
                    }

                    if (!shutter.canUpdate(level, newPos)) {
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

    List<BlockState> getNeighborBlocks(Level level, BlockPos pos) {
        return getNeighborBlocks(level, pos, level.getBlockState(pos).getValue(FACING));
    }

    List<BlockState> getNeighborBlocks(Level level, BlockPos pos, Direction facing) {
        return switch (facing) {
            case NORTH -> List.of(level.getBlockState(pos.east()), level.getBlockState(pos.west()));
            case SOUTH -> List.of(level.getBlockState(pos.west()), level.getBlockState(pos.east()));
            case EAST -> List.of(level.getBlockState(pos.south()), level.getBlockState(pos.north()));
            default -> List.of(level.getBlockState(pos.north()), level.getBlockState(pos.south()));
        };
    }

    public static void handleInteractBlock(Level level, BlockPos pos, int open) {
        handleInteractBlock(level, pos, level.getBlockState(pos), open);
    }

    //creates interaction shutters
    public static void handleInteractBlock(Level level, BlockPos shutterPos, BlockState state, int open) {
        if (open == 0 || open == 1) {
            BlockPos[] neighbourPos = {
                    shutterPos.north(),
                    shutterPos.south(),
                    shutterPos.west(),
                    shutterPos.east()
            };

            for (BlockPos localPos : neighbourPos) {
                if (level.getBlockState(localPos).getBlock() instanceof InteractionShutter) {
                    level.setBlock(localPos, Blocks.AIR.defaultBlockState(), 22);
                }
            }

            return;
        }

        ShutterDouble shutterDouble = state.getValue(DOUBLE_DOOR);
        BlockPos[] placePos = {BlockPos.ZERO};

        if (shutterDouble == ShutterDouble.NONE) {
            if (state.getValue(FACING) == Direction.NORTH || state.getValue(FACING) == Direction.SOUTH) {
                placePos = new BlockPos[]{shutterPos.east(), shutterPos.west()};
            } else {
                placePos = new BlockPos[]{shutterPos.north(), shutterPos.south()};
            }
        } else {
            switch (state.getValue(FACING)) {
                case NORTH -> {
                    if (shutterDouble == ShutterDouble.LEFT) {
                        placePos[0] = shutterPos.east();
                    } else {
                        placePos[0] = shutterPos.west();
                    }
                }
                case SOUTH -> {
                    if (shutterDouble == ShutterDouble.LEFT) {
                        placePos[0] = shutterPos.west();
                    } else {
                        placePos[0] = shutterPos.east();
                    }
                }
                case EAST -> {
                    if (shutterDouble == ShutterDouble.LEFT) {
                        placePos[0] = shutterPos.south();
                    } else {
                        placePos[0] = shutterPos.north();
                    }
                }
                default -> {
                    if (shutterDouble == ShutterDouble.LEFT) {
                        placePos[0] = shutterPos.north();
                    } else {
                        placePos[0] = shutterPos.south();
                    }
                }
            }
        }

        for (BlockPos pos1 : placePos) {
            boolean isLeft = switch (state.getValue(FACING)) {
                case NORTH -> shutterPos.west().equals(pos1);
                case SOUTH -> shutterPos.east().equals(pos1);
                case WEST -> shutterPos.south().equals(pos1);
                default -> shutterPos.north().equals(pos1);
            };

            if (level.getBlockState(pos1).getBlock() instanceof AirBlock) {
                InteractionShutter.placeInteractionShutter(
                        level,
                        pos1,
                        state.getValue(FACING),
                        level.getBlockState(shutterPos).getBlock(),
                        shutterDouble,
                        isLeft
                );
            }
        }
    }

    public void playSound(@Nullable Entity entity, Level level, BlockPos pos) {
        playSound(entity, level, pos, level.getBlockState(pos).getValue(OPEN));
    }

    public void playSound(@Nullable Entity entity, Level level, BlockPos pos, int state) {
        level.playSound(entity, pos, this.getSound(state).get(), SoundSource.BLOCKS,
                1F,
                level.getRandom().nextFloat() * 0.1F + 0.9F);
    }

    private Supplier<SoundEvent> getSound(int state) {
        boolean metal = this.isMetal;

        return switch (state) {
            case 0 -> metal ? SoundInit.SHUTTER_CLOSE_METAL : SoundInit.SHUTTER_CLOSE;
            case 1 -> metal ? SoundInit.SHUTTER_OPEN_HALF_METAL : SoundInit.SHUTTER_OPEN_HALF;
            default -> metal ? SoundInit.SHUTTER_OPEN_FULL_METAL : SoundInit.SHUTTER_OPEN_FULL;
        };
    }

    BlockPos getNeighborShutterPos(Level level, BlockPos pos) {
        return getNeighborShutterPos(pos, level.getBlockState(pos));
    }

    BlockPos getNeighborShutterPos(BlockPos pos, BlockState state) {
        return getNeighborShutterPos(pos, state.getValue(DOUBLE_DOOR), state.getValue(FACING));
    }

    BlockPos getNeighborShutterPos(BlockPos pos, ShutterDouble shutterDouble, Direction facing) {
        return switch (facing) {
            case SOUTH -> shutterDouble == ShutterDouble.RIGHT ? pos.west() : pos.east();
            case NORTH -> shutterDouble == ShutterDouble.RIGHT ? pos.east() : pos.west();
            case EAST -> shutterDouble == ShutterDouble.RIGHT ? pos.south() : pos.north();
            default -> shutterDouble == ShutterDouble.RIGHT ? pos.north() : pos.south();
        };
    }

    public boolean hasRedstonePower(Level level, BlockPos pos) {
        return hasRedstonePower(level, pos, level.getBlockState(pos).getValue(FACING));
    }

    public boolean hasRedstonePower(Level level, BlockPos pos, Direction facing) {
        boolean hasSignal = level.hasNeighborSignal(pos);

        if (facing == Direction.WEST || facing == Direction.EAST) {
            return hasSignal
                    || level.hasNeighborSignal(pos.north())
                    || level.hasNeighborSignal(pos.south());
        }

        return hasSignal
                || level.hasNeighborSignal(pos.east())
                || level.hasNeighborSignal(pos.west());
    }

    public void redstoneUpdate(Level level, BlockPos fromPos, BlockPos pos) {
        if (level.getBlockState(fromPos).getBlock() instanceof Shutter) {
            return;
        }

        if (hasRedstonePower(level, pos) && !level.getBlockState(pos).getValue(POWERED)) {
            setPowered(level, pos, true);
            updateRedstone(level, pos, false);
            this.playSound(null, level, pos);

        } else if (!hasRedstonePower(level, pos) && level.getBlockState(pos).getValue(POWERED)) {
            setPowered(level, pos, false);
            this.update(level, pos, 0, false);
            this.playSound(null, level, pos, 0);
        }

        if (level.getBlockState(pos).getValue(OPEN) == 1
                && level.getBlockState(pos).getValue(POWERED)
                && canUpdate(level, pos)) {
            updateRedstone(level, pos, false);
            this.playSound(null, level, pos);
        }
    }

    ShutterPos getPosition(Level level, BlockPos pos) {
        return getPosition(level, pos, level.getBlockState(pos).getValue(DOUBLE_DOOR));
    }

    ShutterPos getPosition(Level level, BlockPos pos, ShutterDouble shutterDouble) {
        boolean above = this.getBlockAbove(pos, level) instanceof Shutter
                && (((shutterDouble == ShutterDouble.NONE
                        && level.getBlockState(pos.above()).getValue(DOUBLE_DOOR) == ShutterDouble.NONE)
                    || (shutterDouble != ShutterDouble.NONE
                        && level.getBlockState(pos.above()).getValue(DOUBLE_DOOR) != ShutterDouble.NONE)));

        boolean below = this.getBlockBelow(pos, level) instanceof Shutter
                && ((shutterDouble == ShutterDouble.NONE
                && level.getBlockState(pos.below()).getValue(DOUBLE_DOOR) == ShutterDouble.NONE)
                || (shutterDouble != ShutterDouble.NONE
                && level.getBlockState(pos.below()).getValue(DOUBLE_DOOR) != ShutterDouble.NONE));

        if (above && below) {
            return ShutterPos.MIDDLE;
        } else if (above) {
            return ShutterPos.LOWER;
        } else if (below) {
            return ShutterPos.UPPER;
        }

        return ShutterPos.NORMAL;
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return !this.isMetal || state.is(BlockInit.GLASS_SHUTTER.get());
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return !this.isMetal || state.is(BlockInit.GLASS_SHUTTER.get()) ? 20 : 0;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return !this.isMetal || state.is(BlockInit.GLASS_SHUTTER.get()) ? 5 : 0;
    }

    public boolean canUpdate(Level level, BlockPos pos) {
        List<BlockState> sideblocks = getNeighborBlocks(level, pos);

        ShutterDouble shutterDouble = level.getBlockState(pos).getValue(DOUBLE_DOOR);
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
        for (BlockState blockState : sideblocks) {
            if (!isValidBlockForUpdate(blockState.getBlock())) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidBlockForUpdate(Block block) {
        return block == Blocks.AIR
                || block instanceof InteractionShutter
                || block instanceof SugarCaneBlock
                || block instanceof BushBlock
                || block instanceof BambooStalkBlock
                || block instanceof BambooSaplingBlock
                || block instanceof CactusBlock
                || block instanceof WaterlilyBlock
                || block instanceof StemBlock
                || block instanceof BigDripleafBlock
                || block instanceof BigDripleafStemBlock
                || block instanceof FenceBlock
                || block instanceof FenceGateBlock
                || block == Blocks.WATER
                || block == Blocks.LAVA
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
                || block instanceof RedStoneWireBlock
                || block instanceof LeverBlock
                || block instanceof TripWireBlock
                || block instanceof TripWireHookBlock
                || block instanceof LightningRodBlock
                || block instanceof BellBlock
                || block instanceof PointedDripstoneBlock
                || block instanceof AmethystClusterBlock
                || block instanceof BuddingAmethystBlock
                || block instanceof WebBlock
                || block instanceof CoralFanBlock
                || block instanceof CoralPlantBlock
                || block instanceof IronBarsBlock
                || block instanceof SkullBlock
                || block instanceof SporeBlossomBlock;
    }

    public void setPowered(Level level, BlockPos pos, boolean state) {
        if (level.getBlockState(pos).hasProperty(POWERED)) {
            level.setBlock(pos, level.getBlockState(pos).setValue(POWERED, state), 3);
        }
    }

    public void setOpen(Level level, BlockPos pos, int state) {
        if (level.getBlockState(pos).hasProperty(OPEN)) {
            level.setBlockAndUpdate(pos, level.getBlockState(pos).setValue(OPEN, state));
        }
    }

    Block getBlockAbove(BlockPos pos, Level level) {
        return level.getBlockState(pos.above()).getBlock();
    }

    Block getBlockBelow(BlockPos pos, Level level) {
        return level.getBlockState(pos.below()).getBlock();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SHUTTER_POS);
        builder.add(FACING);
        builder.add(OPEN);
        builder.add(POWERED);
        builder.add(DOUBLE_DOOR);
        builder.add(WATERLOGGED);
    }
}