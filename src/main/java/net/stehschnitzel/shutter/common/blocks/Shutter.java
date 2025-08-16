package net.stehschnitzel.shutter.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.stehschnitzel.shutter.common.blocks.properties.ShutterDouble;
import net.stehschnitzel.shutter.common.blocks.properties.ShutterVoxels;
import org.jetbrains.annotations.Nullable;

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
	protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
		if (!pPlayer.mayBuild()) {
			return InteractionResult.PASS;
		} else if (!pPlayer.isCrouching()
				&& !this.isMetal) {

			this.update(pLevel, pPos, pState.getValue(OPEN) + 1, false);
			if (pState.getValue(WATERLOGGED)) {
				pLevel.scheduleTick(pPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
			}

			this.playSound(pLevel, pPos);
			return InteractionResult.SUCCESS_SERVER;
		}
		return InteractionResult.FAIL;
	}

	@Override
	protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, @Nullable Orientation orientation, boolean movedByPiston) {

		redstoneUpdate(level, neighborBlock, pos);
		List<BlockState> sideblocks = getNeighborBlocks(level, pos);

		//checks if it should update it double block state
		if (state.getValue(DOUBLE_DOOR) == ShutterDouble.NONE) {
			BlockPos right = getNeighborShutterPos(pos, ShutterDouble.RIGHT, state.getValue(FACING));
			BlockPos left = getNeighborShutterPos(pos, ShutterDouble.LEFT, state.getValue(FACING));


			if (sideblocks.get(0).getBlock() instanceof Shutter && pos.equals(getNeighborShutterPos(level, right))) {
				level.setBlock(pos, level.getBlockState(pos).setValue(DOUBLE_DOOR, ShutterDouble.RIGHT), 18);

				updatePosNeighborHelper(level, pos);

			} else if (sideblocks.get(1).getBlock() instanceof Shutter && pos.equals(getNeighborShutterPos(level, left))) {
				level.setBlock(pos, level.getBlockState(pos).setValue(DOUBLE_DOOR, ShutterDouble.LEFT), 18);

				updatePosNeighborHelper(level, pos);
			}
		}

		//resets it to None, if there are no shutters around
		if (state.getValue(DOUBLE_DOOR) == ShutterDouble.LEFT && !(sideblocks.get(1).getBlock() instanceof Shutter)) {
			level.setBlock(pos, level.getBlockState(pos).setValue(DOUBLE_DOOR, ShutterDouble.NONE), 18);

			updatePosNeighborHelper(level, pos);
		}
		if (state.getValue(DOUBLE_DOOR) == ShutterDouble.RIGHT && !(sideblocks.get(0).getBlock() instanceof Shutter)) {
			level.setBlock(pos, level.getBlockState(pos).setValue(DOUBLE_DOOR, ShutterDouble.NONE), 18);

			updatePosNeighborHelper(level, pos);
		}

		// resets the shutter to 0 when it cant be in state 2
		if (!level.isClientSide && state.getValue(OPEN) == 2
				&& !canUpdate(level, pos)) {
			int open = hasRedstonePower(level, pos) ? 1 : 0;
			this.update(level, pos, open, false);
			this.playSound(level, pos);
		}

		//update position
		if (pos.above().equals(neighborBlock) || pos.below().equals(neighborBlock)) {
			updatePosNeighborHelper(level, pos);
		}

		if (state.getValue(OPEN) != 0 && state.getValue(WATERLOGGED)) {
			level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
		}
	}

	//updates the position so it
	private void updatePosNeighborHelper(Level level, BlockPos pos) {
		if (this.getPosition(level, pos) != level.getBlockState(pos).getValue(POS)) {
			level.setBlock(pos, level.getBlockState(pos).setValue(POS, this.getPosition(level, pos)), 3);
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
	protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess scheduledTickAccess, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
		if (state.getValue(WATERLOGGED)) {
			scheduledTickAccess.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
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
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		FluidState fluidstate = pContext.getLevel().getFluidState(pContext.getClickedPos());
		BlockPos blockpos = pContext.getClickedPos();
		Level level = pContext.getLevel();

		int open_state = 0;
		Direction direction = pContext.getHorizontalDirection();
		List<BlockState> sideBlocks = getNeighborBlocks(level, blockpos, direction);
		ShutterDouble isdoubleDoor = ShutterDouble.NONE;

		//get if the neighbours are also shutters
		if (sideBlocks.get(0).getBlock() instanceof Shutter && sideBlocks.get(0).getValue(DOUBLE_DOOR) == ShutterDouble.NONE) {
			isdoubleDoor = ShutterDouble.RIGHT;
			open_state = sideBlocks.get(0).getValue(OPEN);
			if (direction != sideBlocks.get(0).getValue(FACING)) {
				direction = sideBlocks.get(0).getValue(FACING);
				isdoubleDoor = ShutterDouble.LEFT;
			}
		} else if (sideBlocks.get(1).getBlock() instanceof Shutter && sideBlocks.get(1).getValue(DOUBLE_DOOR) == ShutterDouble.NONE) {
			isdoubleDoor = ShutterDouble.LEFT;
			open_state = sideBlocks.get(1).getValue(OPEN);
			if (direction != sideBlocks.get(1).getValue(FACING)) {
				direction = sideBlocks.get(1).getValue(FACING);
				isdoubleDoor = ShutterDouble.RIGHT;
			}
		}

		if (this.getBlockBelow(blockpos, level) instanceof Shutter) {
			open_state = level.getBlockState(blockpos.below()).getValue(OPEN);
			direction = level.getBlockState(blockpos.below()).getValue(FACING);
		} else if (this.getBlockAbove(blockpos, level) instanceof Shutter) {
			open_state = level.getBlockState(blockpos.above()).getValue(OPEN);
			direction = level.getBlockState(blockpos.above()).getValue(FACING);
		} else if (pContext.getPlayer() != null && pContext.getPlayer().isShiftKeyDown() && isdoubleDoor == ShutterDouble.NONE){
			direction = direction.getOpposite();
		}

		boolean neighbor_has_signal = hasRedstonePower(level, blockpos, direction);

		if (neighbor_has_signal) {
			open_state = isdoubleDoor == ShutterDouble.NONE ? this.stateTwoPossible(level, blockpos, true, true) ? 2 : 1 : this.stateTwoPossibleDouble (level, blockpos, true, isdoubleDoor, direction) ? 2 : 1;
			updateRedstone(level, blockpos, true, isdoubleDoor, direction);
		}

		return this.defaultBlockState()
				.setValue(FACING, direction)
				.setValue(POWERED, Boolean.valueOf(neighbor_has_signal))
				.setValue(POS, getPosition(level, blockpos, isdoubleDoor))
				.setValue(DOUBLE_DOOR, isdoubleDoor)
				.setValue(OPEN, open_state)
				.setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
	}
}