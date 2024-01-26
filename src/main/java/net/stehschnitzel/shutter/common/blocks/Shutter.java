package net.stehschnitzel.shutter.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
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

	public Shutter (Properties properties) {
		this(properties, false);
	}

	public Shutter(Properties properties, boolean isMetal) {
		super(properties);
		this.isMetal = isMetal;
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

			this.playSound(pLevel, pPos);
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
			if (sideblocks.get(0).getBlock() instanceof Shutter ) {
				pState = pState.setValue(DOUBLE_DOOR, ShutterDouble.RIGHT);

			} else if (sideblocks.get(1).getBlock() instanceof Shutter ) {
				pState = pState.setValue(DOUBLE_DOOR, ShutterDouble.LEFT);
			}
		}

		//resets it to None, if there are no shutters arround
		if (pState.getValue(DOUBLE_DOOR) == ShutterDouble.LEFT && !(sideblocks.get(1).getBlock() instanceof Shutter)) {
			pState = pState.setValue(DOUBLE_DOOR, ShutterDouble.NONE);
		}
		if (pState.getValue(DOUBLE_DOOR) == ShutterDouble.RIGHT && !(sideblocks.get(0).getBlock() instanceof Shutter)) {
			pState = pState.setValue(DOUBLE_DOOR, ShutterDouble.NONE);
		}

		// sets the shutter to 0 when a block on the left or right is placed
		if (!pLevel.isClientSide && pState.getValue(OPEN) == 2
				&& !canUpdate(pLevel, pPos)) {
			this.update(pLevel, pPos, 0, false);
			this.playSound(pLevel, pPos);
		}

		//update pos
		if (pPos.above().equals(pFromPos) || pPos.below().equals(pFromPos)) {
			pState = pState.setValue(POS, this.getPosition(pLevel, pPos));
		}
		pLevel.setBlock(pPos, pState, 18);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		BlockPos blockpos = pContext.getClickedPos();
		Level level = pContext.getLevel();
		Direction direction = pContext.getHorizontalDirection();
		int open_state = 0;

		if (this.getBlockBelow(blockpos, level) instanceof Shutter) {
			open_state = level.getBlockState(blockpos.below()).getValue(OPEN);
			direction = level.getBlockState(blockpos.below()).getValue(FACING);

		} else if (this.getBlockAbove(blockpos, level) instanceof Shutter) {
			open_state = level.getBlockState(blockpos.above()).getValue(OPEN);
			direction = level.getBlockState(blockpos.above()).getValue(FACING);

		}

		List<BlockState> sideblocks = getNeighborBlocks(level, blockpos, direction);

		//get if the neighbours are also shutters
		ShutterDouble isdoubleDoor = ShutterDouble.NONE;
		if (sideblocks.get(0).getBlock() instanceof Shutter && sideblocks.get(0).getValue(DOUBLE_DOOR) == ShutterDouble.NONE) {
			isdoubleDoor = ShutterDouble.RIGHT;
		} else if (sideblocks.get(1).getBlock() instanceof Shutter && sideblocks.get(1).getValue(DOUBLE_DOOR) == ShutterDouble.NONE) {
			isdoubleDoor = ShutterDouble.LEFT;
		}

		boolean neighbor_has_signal = level.hasNeighborSignal(blockpos)
				|| level.hasNeighborSignal(blockpos.above());


		if (neighbor_has_signal) {
			open_state = isdoubleDoor == ShutterDouble.NONE ? this.stateTwoPossible(level, blockpos, true) ? 2 : 1 : this.stateTwoPossibleDouble (level, blockpos, true) ? 2 : 1;

			updateRedstone(level, blockpos, true, isdoubleDoor);
		}

		return this.defaultBlockState()
				.setValue(FACING, direction)
				.setValue(POWERED, neighbor_has_signal)
				.setValue(POS, getPosition(level, blockpos))
				.setValue(DOUBLE_DOOR, isdoubleDoor)
				.setValue(OPEN, open_state);
	}
}