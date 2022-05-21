package net.stehschnitzel.shutter;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Shutter extends Block {

	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
	public static final EnumProperty<ShutterPos> POS = EnumProperty
			.create("half", ShutterPos.class);;
	public static final IntegerProperty OPEN = IntegerProperty.create("open", 0,
			2);

	private Block[] sideblocks = new Block[2];

	Direction placeDirection;

	public Shutter(Properties p_49795_) {
		super(p_49795_);
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel,
			BlockPos pPos, CollisionContext pContext) {
		switch (pState.getValue(FACING)) {
			case EAST :
				switch (pState.getValue(OPEN)) {
					case 0 :
						return ShutterVoxels.shutter_e_closed();
					case 1 :
						return ShutterVoxels.shutter_e_semi_opened();
					default :
						return ShutterVoxels.shutter_e_fully_opened();
				}
			case SOUTH :
				switch (pState.getValue(OPEN)) {
					case 0 :
						return ShutterVoxels.shutter_s_closed();
					case 1 :
						return ShutterVoxels.shutter_s_semi_opened();
					default :
						return ShutterVoxels.shutter_s_fully_opened();
				}
			case WEST :
				switch (pState.getValue(OPEN)) {
					case 0 :
						return ShutterVoxels.shutter_w_closed();
					case 1 :
						return ShutterVoxels.shutter_w_semi_opened();
					default :
						return ShutterVoxels.shutter_w_fully_opened();
				}
			default :
				switch (pState.getValue(OPEN)) {
					case 0 :
						return ShutterVoxels.shutter_n_closed();
					case 1 :
						return ShutterVoxels.shutter_n_semi_opened();
					default :
						return ShutterVoxels.shutter_n_fully_opened();
				}
		}
	}
	
	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
			Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
		if (!pPlayer.isCrouching()
			&& pHand.equals(InteractionHand.MAIN_HAND) && this.material != Material.METAL) {
			int state = pState.getValue(OPEN);

			if (state == 0) {
				this.updateAll(pLevel, pPos, 1, false);

			} else if (state == 1) {
				// check if it is possible for all shutters to update to state =
				// 2
				if (stateTwoPossible(pLevel, pPos, false)) {
					this.updateAll(pLevel, pPos, 2, false);
				} else {
					this.updateAll(pLevel, pPos, 0, false);
				}

			} else if (state == 2) {
				this.updateAll(pLevel, pPos, 0, false);
			}

			return InteractionResult.SUCCESS;
		}
		return InteractionResult.FAIL;
	}

	private void updateAll(Level level, BlockPos pos, int state,
			@Nullable boolean first) {
		boolean[] arr = {true, false};
		this.playSound(level, pos, state);
		for (boolean up : arr) {
			int y = pos.getY();

			while ((y * y) < 100000) {
				BlockPos newPos = new BlockPos(pos.getX(), y, pos.getZ());
				Block block = level.getBlockState(newPos).getBlock();

				if (block instanceof Shutter shutter) {
					shutter.setOpen(level, newPos, state);
				} else {
					if (!(first && y == pos.getY())) {
						break;
					}
				}
				if (up) {
					y++;
				} else {
					y--;
				}
			}
		}
	}

	private boolean stateTwoPossible(Level level, BlockPos pos,
			@Nullable boolean first) {
		boolean[] arr = {true, false};
		for (boolean up : arr) {
			int y = pos.getY();

			while ((y * y) < 100000) {
				BlockPos newPos = new BlockPos(pos.getX(), y, pos.getZ());
				Block block = level.getBlockState(newPos).getBlock();

				if (block instanceof Shutter shutter) {
					shutter.setNeighbourBlocks(level, newPos);
					if (!shutter.canUpdate()) {
						return false;
					}
				} else if (!(first && y == pos.getY())) {
					break;
				}
				if (up) {
					y++;
				} else {
					y--;
				}
			}
		}
		return true;
	}

	private void playSound(Level level, BlockPos pos, int state) {
		level.levelEvent((Player)null, state == 0 ? this.getCloseSound() : this.getOpenSound(), pos, 0);
	}
	
	private int getCloseSound() {
	      return this.material == Material.METAL ? 1011 : 1012;
	   }

	   private int getOpenSound() {
	      return this.material == Material.METAL ? 1005 : 1006;
	   }
	
	// gets called when a block updates
	// is used for setting the blocks above and below
	@Override
	public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos,
			Block pBlock, BlockPos pFromPos, boolean pIsMoving) {

		ShutterPos pos;
		boolean above = this.isBlockAbove(pLevel, pPos);
		boolean below = this.isBlockBelow(pLevel, pPos);

		// setting everything to default state
		if (above && below) {
			pos = ShutterPos.MIDDLE;
		} else if (above && !below) {
			pos = ShutterPos.LOWER;
		} else if (!above && below) {
			pos = ShutterPos.UPPER;
		} else {
			pos = ShutterPos.NORMAL;
		}
		pLevel.setBlockAndUpdate(pPos,
				pLevel.getBlockState(pPos).setValue(POS, pos));

		// For redstone or power
		if (!(pLevel.getBlockState(pFromPos).getBlock() instanceof Shutter)
				&& pLevel.hasNeighborSignal(pPos)) {
			this.setPowered(pLevel, pPos, true);
			if (this.stateTwoPossible(pLevel, pPos, false)) {
				this.updateAll(pLevel, pPos, 2, false);
			} else {
				this.updateAll(pLevel, pPos, 1, false);
			}
		} else if (!pLevel.hasNeighborSignal(pPos)
				&& pLevel.getBlockState(pPos).getValue(POWERED)) {
			this.setPowered(pLevel, pPos, false);
			this.updateAll(pLevel, pPos, 0, false);
		}

		// sets the shutter to 0 when a block on the left or the right is placed
		if (!pLevel.isClientSide && pState.getValue(OPEN) == 2
				&& !canUpdate()) {
			this.updateAll(pLevel, pPos, 0, false);
		}
	}

	private boolean isBlockBelow(Level level, BlockPos pos) {
		return level.getBlockState(pos.below()).getBlock() instanceof Shutter;
	}

	private boolean isBlockAbove(Level level, BlockPos pos) {
		return level.getBlockState(pos.above()).getBlock() instanceof Shutter;
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {

		BlockPos blockpos = pContext.getClickedPos();
		Level level = pContext.getLevel();

		if (this.getBlockBelow(blockpos, level) instanceof Shutter shutter) {
			this.placeDirection = shutter.placeDirection;
		}
		if (this.getBlockAbove(blockpos, level) instanceof Shutter shutter) {
			this.placeDirection = shutter.placeDirection;
		} else {
			this.placeDirection = pContext.getHorizontalDirection()
					.getOpposite();
		}

		boolean flag = level.hasNeighborSignal(blockpos)
				|| level.hasNeighborSignal(blockpos.above());

		ShutterPos pos;

		boolean above = this.isBlockAbove(level, blockpos);
		boolean below = this.isBlockBelow(level, blockpos);

		// setting everything to default state
		if (above && below) {
			pos = ShutterPos.MIDDLE;
		} else if (above && !below) {
			pos = ShutterPos.LOWER;
		} else if (!above && below) {
			pos = ShutterPos.UPPER;
		} else {
			pos = ShutterPos.NORMAL;
		}

		if (flag) {
			if (this.stateTwoPossible(level, blockpos, true)) {
				this.updateAll(level, blockpos, 2, true);
			} else {
				this.updateAll(level, blockpos, 1, true);
			}
		}

		this.setNeighbourBlocks(level, blockpos);

		// gets the block state above and below
		if (this.getBlockBelow(blockpos, level) instanceof Shutter shutter) {

			return this.defaultBlockState().setValue(POS, pos)
					.setValue(OPEN,
							level.getBlockState(blockpos.below())
									.getValue(OPEN))
					.setValue(FACING, level.getBlockState(blockpos.below())
							.getValue(FACING));

		} else if (this.getBlockAbove(blockpos,
				level) instanceof Shutter shutter) {

			return this.defaultBlockState().setValue(POS, pos)
					.setValue(OPEN,
							level.getBlockState(blockpos.above())
									.getValue(OPEN))
					.setValue(FACING, level.getBlockState(blockpos.above())
							.getValue(FACING));

		}
		return this.defaultBlockState()
				.setValue(FACING,
						pContext.getHorizontalDirection().getOpposite())
				.setValue(POWERED,
						level.hasNeighborSignal(blockpos)
								|| level.hasNeighborSignal(blockpos.above()))
				.setValue(POS, ShutterPos.NORMAL)
				.setValue(OPEN, flag ? this.canUpdate() ? 2 : 1 : 0);

	}

	private void setNeighbourBlocks(Level level, BlockPos blockpos) {
		this.sideblocks[1] = this.placeDirection == Direction.NORTH
				|| this.placeDirection == Direction.SOUTH
						? level.getBlockState(blockpos.east()).getBlock()
						: level.getBlockState(blockpos.south()).getBlock();

		this.sideblocks[0] = this.placeDirection == Direction.NORTH
				|| this.placeDirection == Direction.SOUTH
						? level.getBlockState(blockpos.west()).getBlock()
						: level.getBlockState(blockpos.north()).getBlock();

	}

	// if it can get to the next open state
	private boolean canUpdate() {
		for (Block block : this.sideblocks) {
			if (block != Blocks.AIR) {
				return false;
			}
		}
		return true;
	}

	public void setPowered(Level level, BlockPos pos, boolean state) {
		level.setBlockAndUpdate(pos,
				level.getBlockState(pos).setValue(POWERED, state));
	}

	public void setOpen(Level level, BlockPos pos, int state) {
		level.setBlockAndUpdate(pos,
				level.getBlockState(pos).setValue(OPEN, state));
	}

	private Block getBlockAbove(BlockPos pos, Level level) {
		return level.getBlockState(pos.above()).getBlock();
	}

	private Block getBlockBelow(BlockPos pos, Level level) {
		return level.getBlockState(pos.below()).getBlock();
	}

	@Override
	public BlockState rotate(BlockState pState, Rotation pRotation) {
		return pState.setValue(FACING,
				pRotation.rotate(pState.getValue(FACING)));
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState pState, Mirror pMirror) {
		return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
	}

	@Override
	protected void createBlockStateDefinition(
			StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(FACING, OPEN, POWERED, POS);
		super.createBlockStateDefinition(pBuilder);
	}

}