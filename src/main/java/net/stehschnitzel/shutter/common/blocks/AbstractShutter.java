package net.stehschnitzel.shutter.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.registries.RegistryObject;
import net.stehschnitzel.shutter.common.blocks.properties.ShutterDouble;
import net.stehschnitzel.shutter.common.blocks.properties.ShutterPos;
import net.stehschnitzel.shutter.init.BlockInit;
import net.stehschnitzel.shutter.init.SoundInit;

import javax.annotation.Nullable;
import java.util.List;

abstract class AbstractShutter extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    public static final EnumProperty<ShutterPos> POS = EnumProperty
            .create("half", ShutterPos.class);

    public static final IntegerProperty OPEN = IntegerProperty.create("open", 0,2);

    public static final EnumProperty<ShutterDouble> DOUBLE_DOOR = EnumProperty
            .create("double_door", ShutterDouble.class);
    //	private final BlockState[] sideblocks = new BlockState[2];
    boolean isMetal = false;

    public AbstractShutter (Properties properties) {
        this(properties, false);
    }

    public AbstractShutter(Properties properties, boolean isMetal) {
        super(properties);
        this.isMetal = isMetal;
        this.registerDefaultState(this.defaultBlockState()
                .setValue(FACING, Direction.NORTH)
                .setValue(POWERED, false)
                .setValue(OPEN, 0)
                .setValue(POS, ShutterPos.NORMAL)
                .setValue(DOUBLE_DOOR, ShutterDouble.NONE));
    }

    void updateRedstone(Level level, BlockPos pos, boolean first) {
        updateRedstone(level, pos, first, level.getBlockState(pos).getValue(DOUBLE_DOOR));
    }

    void updateRedstone(Level level, BlockPos pos, boolean first, ShutterDouble doorType) {
        if (doorType == ShutterDouble.NONE) {
             if ( stateTwoPossible(level, pos, first)) {
                updateAll(level, pos, 2, first);
            } else {
                updateAll(level, pos, 1, first);
            }
        } else {
            List<BlockState> sideblocks = getNeighborBlocks(level, pos);
            BlockPos neighborPos = getNeighborShutterPos(level, pos, doorType == ShutterDouble.RIGHT ? sideblocks.get(0) : sideblocks.get(1));

             if (stateTwoPossibleDouble(level, pos, first)) {
                updateAll(level, pos, 2, first);
                updateAll(level, neighborPos, 2, first);

            } else {
                updateAll(level, pos, 1, first);
                updateAll(level, neighborPos, 1, first);
            }
        }
    }

    public void update(Level level, BlockPos pos, int state, boolean first) {
        ShutterDouble doorType = level.getBlockState(pos).getValue(DOUBLE_DOOR);

        if (doorType == ShutterDouble.NONE) {
            updateSingleDoor(level, pos, state, first);
        } else {
            updateDoubleDoor(level, pos, state, first, doorType);
        }
    }

    private void updateSingleDoor(Level level, BlockPos pos, int state, boolean first) {
        if (state < 2) {
            updateAll(level, pos, state, first);
        } else if (state == 2 && stateTwoPossible(level, pos, first)) {
            updateAll(level, pos, 2, first);
        } else {
            updateAll(level, pos, 0, first);
        }
    }

    private void updateDoubleDoor(Level level, BlockPos pos, int state, boolean first, ShutterDouble doorType) {
        List<BlockState> sideblocks = getNeighborBlocks(level, pos);

        BlockPos neighborPos = getNeighborShutterPos(level, pos, doorType == ShutterDouble.RIGHT ? sideblocks.get(0) : sideblocks.get(1));

        if (state < 2) {
            updateAll(level, pos, state, first);
            updateAll(level, neighborPos, state, first);

        } else if (state == 2 && stateTwoPossibleDouble(level, pos, first)) {
            updateAll(level, pos, 2, first);
            updateAll(level, neighborPos, 2, first);

        } else {
            updateAll(level, pos, 0, first);
            updateAll(level, neighborPos, 0, first);
        }
    }

    boolean stateTwoPossibleDouble(Level level, BlockPos pos, boolean first) {
        boolean thisCanUpdate = stateTwoPossible(level, pos, first);
        ShutterDouble doorType = level.getBlockState(pos).getValue(DOUBLE_DOOR);

        List<BlockState> sideblocks = getNeighborBlocks(level, pos);
        BlockPos neighborPos = getNeighborShutterPos(level, pos, doorType == ShutterDouble.RIGHT ? sideblocks.get(0) : sideblocks.get(1));

        return thisCanUpdate && stateTwoPossible(level, neighborPos, first);
    }

    private void updateAll(Level level, BlockPos pos, int state, boolean first) {
        if (!first) {
            setOpen(level, pos, state);
        }

        boolean[] arr = {true, false};

        for (boolean up : arr) {
            int y = pos.getY() + (up ? 1 : -1);

            while (y > -70 && y < 330) {
                BlockPos updatePos = new BlockPos(pos.getX(), y, pos.getZ());
                Block block = level.getBlockState(updatePos).getBlock();

                if (block instanceof Shutter shutter) {
                    shutter.setOpen(level, updatePos, state);
                    //29 72 16
                } else {
                    break;
                }

                y = up ? y + 1 : y - 1;
            }
        }
    }

    boolean stateTwoPossible(Level level, BlockPos pos, boolean first) {
        boolean[] arr = {true, false};

        if (!first &&
                level.getBlockState(pos).getBlock() instanceof Shutter shutter &&
                !shutter.canUpdate(level, pos)) {
            return false;
        }

        for (boolean up : arr) {
            int y = pos.getY();

            while (y > -70 && y < 330) {
                BlockPos newPos = new BlockPos(pos.getX(), y, pos.getZ());
                Block block = level.getBlockState(newPos).getBlock();

                if (block instanceof Shutter shutter) {

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
        switch (facing) {
            case NORTH -> {
                return List.of(new BlockState[]{level.getBlockState(pos.east()), level.getBlockState(pos.west())});
            }
            case SOUTH -> {
                return List.of(new BlockState[]{level.getBlockState(pos.west()), level.getBlockState(pos.east())});
            }
            case EAST -> {
                return List.of(new BlockState[]{level.getBlockState(pos.south()), level.getBlockState(pos.north())});
            }
            default -> {
                return List.of(new BlockState[]{level.getBlockState(pos.north()), level.getBlockState(pos.south())});
            }
        }
    }

    public void playSound(Level level, BlockPos pos) {
        level.playSound(null, pos, this.getSound(level, pos).get(),
                SoundSource.BLOCKS, 1F, 1F);
    }

    private RegistryObject<SoundEvent> getSound(Level level, BlockPos pos) {
        int open = level.getBlockState(pos).getValue(OPEN);
        return open == 0
                ? SoundInit.SHUTTER_CLOSE
                : open == 2 && this.canUpdate(level, pos)
                ? SoundInit.SHUTTER_OPEN_HALF
                : SoundInit.SHUTTER_OPEN_FULL;
    }

    BlockPos getNeighborShutterPos(Level level, BlockPos pos, BlockState state) {
        if (level.getBlockState(pos.north()).equals(state)) return pos.north();
        if (level.getBlockState(pos.east()).equals(state)) return pos.east();
        if (level.getBlockState(pos.south()).equals(state)) return pos.south();
        else return pos.west();
    }

    public void redstoneUpdate(Level pLevel, BlockPos pFromPos, BlockPos pPos) {
        // For redstone or power
        if (!(pLevel.getBlockState(pFromPos).getBlock() instanceof Shutter)) {
            // opening
            if (pLevel.hasNeighborSignal(pPos) || pLevel.hasNeighborSignal(pPos.above())) {
                this.setPowered(pLevel, pPos, true);
                updateRedstone(pLevel, pPos, false);
                this.playSound(pLevel, pPos);

            // closing
            } else if (!pLevel.hasNeighborSignal(pPos)
                    && pLevel.getBlockState(pPos).getValue(POWERED)) {
                this.setPowered(pLevel, pPos, false);
                this.update(pLevel, pPos, 0, false);
                this.playSound(pLevel, pPos);
            }
        }
    }

    ShutterPos getPosition(Level pLevel, BlockPos pPos) {
        boolean above = this.getBlockAbove(pPos, pLevel) instanceof Shutter;
        boolean below = this.getBlockBelow(pPos, pLevel) instanceof Shutter;

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
    public boolean isFlammable(BlockState state, BlockGetter level,
                               BlockPos pos, Direction direction) {
        return this.isMetal
                || state.is(BlockInit.GLASS_SHUTTER.get());
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level,
                               BlockPos pos, Direction direction) {
        return !this.isMetal
                || state.is(BlockInit.GLASS_SHUTTER.get()) ? 20 : 0;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level,
                                  BlockPos pos, Direction direction) {
        return !this.isMetal
                || state.is(BlockInit.GLASS_SHUTTER.get()) ? 5 : 0;
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
        for (BlockState block1 : sideblocks) {
            if (!isValidBlockForUpdate(block1.getBlock())) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidBlockForUpdate(Block block) {
        return block == Blocks.AIR
                || block instanceof IPlantable
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
                || block instanceof RedStoneWireBlock
                || block instanceof LeverBlock
                || block instanceof TripWireBlock
                || block instanceof TripWireHookBlock
                || block instanceof LightningRodBlock
                || block instanceof BellBlock
                || block instanceof BigDripleafBlock
                || block instanceof BigDripleafStemBlock
                || block instanceof PointedDripstoneBlock
                || block instanceof AmethystClusterBlock
                || block instanceof BuddingAmethystBlock
                || block instanceof WebBlock
                || block instanceof CoralFanBlock
                || block instanceof CoralPlantBlock
                || block instanceof IronBarsBlock
                || block instanceof SkullBlock
                || block instanceof SporeBlossomBlock
                || block instanceof BambooSaplingBlock;
    }

    public void setPowered(Level level, BlockPos pos, boolean state) {
        level.setBlock(pos, level.getBlockState(pos).setValue(POWERED, state), 18);
    }

    public void setOpen(Level level, BlockPos pos, int state) {
        level.setBlock(pos, level.getBlockState(pos).setValue(OPEN, state), 18);
    }

    Block getBlockAbove(BlockPos pos, Level level) {
        return level.getBlockState(pos.above()).getBlock();
    }

    Block getBlockBelow(BlockPos pos, Level level) {
        return level.getBlockState(pos.below()).getBlock();
    }

    @Override
    protected void createBlockStateDefinition(
            StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(POS);
        pBuilder.add(FACING);
        pBuilder.add(OPEN);
        pBuilder.add(POWERED);
        pBuilder.add(DOUBLE_DOOR);
    }

}
