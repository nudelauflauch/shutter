package net.stehschnitzel.shutter.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.stehschnitzel.shutter.common.blocks.properties.ShutterDouble;
import net.stehschnitzel.shutter.init.BlockInit;
import org.jetbrains.annotations.Nullable;

public class InteractionShutter extends Block {

    VoxelShape shape_single_north_left = Shapes.join(Shapes.empty(), Shapes.box(1-0.375, 0, 0, 1, 1, 0.125), BooleanOp.OR);
    VoxelShape shape_single_north_right = Shapes.join(Shapes.empty(), Shapes.box(0, 0, 0, 0.375, 1, 0.125), BooleanOp.OR);
    VoxelShape shape_single_south_left = Shapes.join(Shapes.empty(), Shapes.box(0, 0, 1-0.125, 0.375, 1, 1), BooleanOp.OR);
    VoxelShape shape_single_south_right = Shapes.join(Shapes.empty(), Shapes.box(1-0.375, 0, 1-0.125, 1, 1, 1), BooleanOp.OR);
    VoxelShape shape_single_west_left = Shapes.join(Shapes.empty(), Shapes.box(0, 0, 0, 0.125, 1, 0.375), BooleanOp.OR);
    VoxelShape shape_single_west_right = Shapes.join(Shapes.empty(), Shapes.box(0, 0, 1-0.375, 0.125, 1, 1), BooleanOp.OR);
    VoxelShape shape_single_east_left = Shapes.join(Shapes.empty(), Shapes.box(1-0.125, 0, 1-0.375, 1, 1, 1), BooleanOp.OR);
    VoxelShape shape_single_east_right = Shapes.join(Shapes.empty(), Shapes.box(1-0.125, 0, 0, 1, 1, 0.375), BooleanOp.OR);

    VoxelShape shape_double_north_left = Shapes.join(Shapes.empty(), Shapes.box(1-0.8125, 0, 0, 1, 1, 0.125), BooleanOp.OR);
    VoxelShape shape_double_north_right = Shapes.join(Shapes.empty(), Shapes.box(0, 0, 0, 0.8125, 1, 0.125), BooleanOp.OR);
    VoxelShape shape_double_south_left = Shapes.join(Shapes.empty(), Shapes.box(0, 0, 1-0.125, 0.8125, 1, 1), BooleanOp.OR);
    VoxelShape shape_double_south_right = Shapes.join(Shapes.empty(), Shapes.box(1-0.8125, 0, 1-0.125, 1, 1, 1), BooleanOp.OR);
    VoxelShape shape_double_west_left = Shapes.join(Shapes.empty(), Shapes.box(0, 0, 0, 0.125, 1, 0.8125), BooleanOp.OR);
    VoxelShape shape_double_west_right = Shapes.join(Shapes.empty(), Shapes.box(0, 0, 1-0.8125, 0.125, 1, 1), BooleanOp.OR);
    VoxelShape shape_double_east_left = Shapes.join(Shapes.empty(), Shapes.box(1-0.125, 0, 1-0.8125, 1, 1, 1), BooleanOp.OR);
    VoxelShape shape_double_east_right = Shapes.join(Shapes.empty(), Shapes.box(1-0.125, 0, 0, 1, 1, 0.8125), BooleanOp.OR);


    public  static final BooleanProperty DOUBLE_SHUTTER = BooleanProperty.create("is_double_shutter");
    public  static final BooleanProperty LEFT_SHUTTER = BooleanProperty.create("left_shutter");
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public InteractionShutter(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState()
                .setValue(FACING, Direction.NORTH)
                .setValue(DOUBLE_SHUTTER, false)
                .setValue(LEFT_SHUTTER, true));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if (pState.getValue(DOUBLE_SHUTTER)) {
            if (pState.getValue(FACING) == Direction.EAST)
                return pState.getValue(LEFT_SHUTTER) ? shape_double_east_left : shape_double_east_right;
            else if (pState.getValue(FACING) == Direction.SOUTH)
                return pState.getValue(LEFT_SHUTTER) ? shape_double_south_left : shape_double_south_right;
            else if (pState.getValue(FACING) == Direction.WEST)
                return pState.getValue(LEFT_SHUTTER) ? shape_double_west_left : shape_double_west_right;
            else return pState.getValue(LEFT_SHUTTER) ? shape_double_north_left : shape_double_north_right;

        } else {
            if (pState.getValue(FACING) == Direction.EAST)
                return pState.getValue(LEFT_SHUTTER) ? shape_single_east_left : shape_single_east_right;
            else if (pState.getValue(FACING) == Direction.SOUTH)
                return pState.getValue(LEFT_SHUTTER) ? shape_single_south_left : shape_single_south_right;
            else if (pState.getValue(FACING) == Direction.WEST)
                return pState.getValue(LEFT_SHUTTER) ? shape_single_west_left : shape_single_west_right;
            else return pState.getValue(LEFT_SHUTTER) ? shape_single_north_left : shape_single_north_right;
        }
    }

    public static void placeInteractionShutter(Level level, BlockPos pos, Direction facing, Block shutterBlock, ShutterDouble sDouble, boolean isLeft) {
        Block interactionShutter;
        if (shutterBlock == BlockInit.CRIMSON_SHUTTER.get()) interactionShutter = BlockInit.INTERACTION_SHUTTER_CRIMSON.get();
        else if (shutterBlock == BlockInit.IRON_SHUTTER.get()) interactionShutter = BlockInit.INTERACTION_SHUTTER_IRON.get();
        else if (shutterBlock == BlockInit.GOLD_SHUTTER.get()) interactionShutter = BlockInit.INTERACTION_SHUTTER_IRON.get();
        else if (shutterBlock == BlockInit.WARPED_SHUTTER.get()) interactionShutter = BlockInit.INTERACTION_SHUTTER_WARPED.get();
        else if (shutterBlock == BlockInit.COPPER_SHUTTER.get()) interactionShutter = BlockInit.INTERACTION_SHUTTER_COPPER.get();
        else if (shutterBlock == BlockInit.EXPOSED_COPPER_SHUTTER.get()) interactionShutter = BlockInit.INTERACTION_SHUTTER_COPPER.get();
        else if (shutterBlock == BlockInit.WEATHERED_COPPER_SHUTTER.get()) interactionShutter = BlockInit.INTERACTION_SHUTTER_COPPER.get();
        else if (shutterBlock == BlockInit.OXIDIZED_COPPER_SHUTTER.get()) interactionShutter = BlockInit.INTERACTION_SHUTTER_COPPER.get();
        else if (shutterBlock == BlockInit.WAXED_COPPER_SHUTTER.get()) interactionShutter = BlockInit.INTERACTION_SHUTTER_COPPER.get();
        else if (shutterBlock == BlockInit.WAXED_EXPOSED_COPPER_SHUTTER.get()) interactionShutter = BlockInit.INTERACTION_SHUTTER_COPPER.get();
        else if (shutterBlock == BlockInit.WAXED_WEATHERED_COPPER_SHUTTER.get()) interactionShutter = BlockInit.INTERACTION_SHUTTER_COPPER.get();
        else if (shutterBlock == BlockInit.WAXED_OXIDIZED_COPPER_SHUTTER.get()) interactionShutter = BlockInit.INTERACTION_SHUTTER_COPPER.get();
        else if (shutterBlock == BlockInit.NETHERITE_SHUTTER.get()) interactionShutter = BlockInit.INTERACTION_SHUTTER_NETHERITE.get();
        else if (shutterBlock == BlockInit.GLASS_SHUTTER.get()) interactionShutter = BlockInit.INTERACTION_SHUTTER_GLASS.get();
        else  interactionShutter = BlockInit.INTERACTION_SHUTTER_WOOD.get();

        level.setBlock(pos, interactionShutter.defaultBlockState()
                .setValue(FACING, facing)
                .setValue(DOUBLE_SHUTTER, !(ShutterDouble.NONE == sDouble))
                .setValue(LEFT_SHUTTER, isLeft), 22);
    }

    @Override
    public InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHit) {

        BlockPos[] neighbourPos = {pPos.north(), pPos.south(), pPos.west(), pPos.east()};
        for (BlockPos localPos : neighbourPos) {

            if (pLevel.getBlockState(localPos).getBlock() instanceof Shutter shutter) {
                shutter.useWithoutItem(pLevel.getBlockState(localPos), pLevel, localPos, pPlayer, pHit);

                if (pLevel.getBlockState(localPos).getValue(Shutter.OPEN) != 2) {
                    pLevel.destroyBlock(pPos, false);
                }
            }
        }

        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.INVISIBLE;
    }

    @Override
    public void destroy(LevelAccessor pLevel, BlockPos pPos, BlockState pState) {
        BlockPos[] neighbourPos = {pPos.north(), pPos.south(), pPos.west(), pPos.east()};
        for (BlockPos localPos : neighbourPos) {
            if (pLevel.getBlockState(localPos).getBlock() instanceof Shutter) {
                pLevel.addFreshEntity(new ItemEntity(
                        (Level) pLevel,
                        localPos.getX(), localPos.getY(), localPos.getZ(),
                        new ItemStack(pLevel.getBlockState(localPos).getBlock().asItem()),
                        0, 0.2f, 0));
                pLevel.setBlock(localPos, Blocks.AIR.defaultBlockState(), 127);


                //to destroy the interact shutter on the other side
                BlockPos[] neighbourOfShutterPos = {localPos.north(), localPos.south(), localPos.west(), localPos.east()};
                for (BlockPos localPosNew : neighbourOfShutterPos) {
                    if (pLevel.getBlockState(localPosNew).getBlock() instanceof InteractionShutter) {
                        pLevel.setBlock(localPosNew, Blocks.AIR.defaultBlockState(), 127);
                    }
                }
            }
        }
    }

    @Override
    protected void spawnDestroyParticles(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState) {
        BlockPos[] neighbourPos = {pPos.north(), pPos.south(), pPos.west(), pPos.east()};
        for (BlockPos localPos : neighbourPos) {

            if (pLevel.getBlockState(localPos).getBlock() instanceof Shutter shutter) {
                pLevel.levelEvent(pPlayer, 2001, localPos, getId(pLevel.getBlockState(localPos)));
            }
        }
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
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction facing = pContext.getHorizontalDirection();
        BlockPos pos = pContext.getClickedPos();
        Level level = pContext.getLevel();
        boolean isDoubleShutter = false;

        BlockPos[] neighbourPos = {pos.north(), pos.south(), pos.west(), pos.east()};
        for (BlockPos localPos : neighbourPos) {

            if (level.getBlockState(localPos).getBlock() instanceof Shutter) {
                isDoubleShutter = level.getBlockState(localPos).getValue(Shutter.DOUBLE_DOOR) != ShutterDouble.NONE;
            }
        }

        return this.defaultBlockState()
                .setValue(FACING, facing)
                .setValue(DOUBLE_SHUTTER, isDoubleShutter);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
        pBuilder.add(DOUBLE_SHUTTER);
        pBuilder.add(LEFT_SHUTTER);
    }
}