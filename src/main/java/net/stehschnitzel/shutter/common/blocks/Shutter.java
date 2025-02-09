package net.stehschnitzel.shutter.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
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
		this.registerDefaultState(this.defaultBlockState()
				.setValue(FACING, Direction.NORTH)
				.setValue(POWERED, false)
				.setValue(OPEN, 0)
				.setValue(POS, ShutterPos.NORMAL)
				.setValue(DOUBLE_DOOR, ShutterDouble.NONE));
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return ShutterVoxels.getShape(pState.getValue(FACING), pState.getValue(OPEN), pState.getValue(DOUBLE_DOOR));
	}

	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
								 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
		if (!pPlayer.mayBuild()) {
			return InteractionResult.PASS;
		} else if (!pPlayer.isCrouching()
				&& pHand.equals(InteractionHand.MAIN_HAND)
				&& !this.isMetal) {

			this.update(pLevel, pPos, pState.getValue(OPEN) + 1, false);

			this.playSound(pLevel, pPos, pLevel.getBlockState(pPos).getValue(OPEN));
			return InteractionResult.sidedSuccess(pLevel.isClientSide);
		}
		return InteractionResult.FAIL;

	}

	@Override
	public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
		redstoneUpdate(pLevel, pFromPos, pPos);
		List<BlockState> sideblocks = getNeighborBlocks(pLevel, pPos);

		//checks if it should update it double block state
		if (pState.getValue(DOUBLE_DOOR) == ShutterDouble.NONE) {
			BlockPos right = getNeighborShutterPos(pPos, ShutterDouble.RIGHT, pState.getValue(FACING));
			BlockPos left = getNeighborShutterPos(pPos, ShutterDouble.LEFT, pState.getValue(FACING));


			if (sideblocks.get(0).getBlock() instanceof Shutter && pPos.equals(getNeighborShutterPos(pLevel, right))) {
				pLevel.setBlock(pPos, pLevel.getBlockState(pPos).setValue(DOUBLE_DOOR, ShutterDouble.RIGHT), 18);

				updatePosNeighborHelper(pLevel, pPos);

			} else if (sideblocks.get(1).getBlock() instanceof Shutter && pPos.equals(getNeighborShutterPos(pLevel, left))) {
				pLevel.setBlock(pPos, pLevel.getBlockState(pPos).setValue(DOUBLE_DOOR, ShutterDouble.LEFT), 18);

				updatePosNeighborHelper(pLevel, pPos);
			}
		}

		//resets it to None, if there are no shutters around
		if (pState.getValue(DOUBLE_DOOR) == ShutterDouble.LEFT && !(sideblocks.get(1).getBlock() instanceof Shutter)) {
			pLevel.setBlock(pPos, pLevel.getBlockState(pPos).setValue(DOUBLE_DOOR, ShutterDouble.NONE), 18);

			updatePosNeighborHelper(pLevel, pPos);
		}
		if (pState.getValue(DOUBLE_DOOR) == ShutterDouble.RIGHT && !(sideblocks.get(0).getBlock() instanceof Shutter)) {
			pLevel.setBlock(pPos, pLevel.getBlockState(pPos).setValue(DOUBLE_DOOR, ShutterDouble.NONE), 18);

			updatePosNeighborHelper(pLevel, pPos);
		}

		// resets the shutter to 0 when i cant be in state 2
		if (!pLevel.isClientSide && pState.getValue(OPEN) == 2
				&& !canUpdate(pLevel, pPos)) {
			this.update(pLevel, pPos, 0, false);
			this.playSound(pLevel, pPos, pLevel.getBlockState(pPos).getValue(OPEN));
		}

		//update position
		if (pPos.above().equals(pFromPos) || pPos.below().equals(pFromPos)) {
			updatePosNeighborHelper(pLevel, pPos);
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
	public BlockState rotate(BlockState pState, Rotation pRotation) {
		return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
	}

	@Override
	public BlockState mirror(BlockState pState, Mirror pMirror) {
		return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		BlockPos blockpos = pContext.getClickedPos();
		Level level = pContext.getLevel();

		int open_state = 0;
		Direction direction = pContext.getHorizontalDirection();
		List<BlockState> sideblocks = getNeighborBlocks(level, blockpos, direction);
		ShutterDouble isdoubleDoor = ShutterDouble.NONE;
		boolean neighbor_has_signal = level.hasNeighborSignal(blockpos) || level.hasNeighborSignal(blockpos.above());

		//get if the neighbours are also shutters
		if (sideblocks.get(0).getBlock() instanceof Shutter && sideblocks.get(0).getValue(DOUBLE_DOOR) == ShutterDouble.NONE) {
			isdoubleDoor = ShutterDouble.RIGHT;
			open_state = sideblocks.get(0).getValue(OPEN);
			if (direction != sideblocks.get(0).getValue(FACING)) {
				direction = sideblocks.get(0).getValue(FACING);
				isdoubleDoor = ShutterDouble.LEFT;
			}
		} else if (sideblocks.get(1).getBlock() instanceof Shutter && sideblocks.get(1).getValue(DOUBLE_DOOR) == ShutterDouble.NONE) {
			isdoubleDoor = ShutterDouble.LEFT;
			open_state = sideblocks.get(1).getValue(OPEN);
			if (direction != sideblocks.get(1).getValue(FACING)) {
				direction = sideblocks.get(1).getValue(FACING);
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

		System.err.println(pContext.getPlayer());
		direction = direction.getOpposite();

		//for bug #21 At world generation the shutter will get placed the opposite way as usually TODO
		if (pContext.getPlayer() == null) {
			direction = direction.getOpposite();
		}

		if (neighbor_has_signal) {
			open_state = isdoubleDoor == ShutterDouble.NONE ? this.stateTwoPossible(level, blockpos, true, true) ? 2 : 1 : this.stateTwoPossibleDouble (level, blockpos, true, isdoubleDoor, direction) ? 2 : 1;
			updateRedstone(level, blockpos, true, isdoubleDoor, direction);
		}

		return this.defaultBlockState()
				.setValue(FACING, direction)
				.setValue(POWERED, neighbor_has_signal)
				.setValue(POS, getPosition(level, blockpos, isdoubleDoor))
				.setValue(DOUBLE_DOOR, isdoubleDoor)
				.setValue(OPEN, open_state);
	}
}