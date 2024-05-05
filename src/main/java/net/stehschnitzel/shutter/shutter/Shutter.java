package net.stehschnitzel.shutter.shutter;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
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
import net.minecraftforge.registries.RegistryObject;
import net.stehschnitzel.shutter.init.SoundInit;

public class Shutter extends Block {

	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
	public static final EnumProperty<ShutterPos> POS = EnumProperty
			.create("half", ShutterPos.class);;
	public static final IntegerProperty OPEN = IntegerProperty.create("open", 0,
			2);

	private Block[] sideblocks = new Block[2];
	ShutterPos pos;

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
		if (!pPlayer.isCrouching() && pHand.equals(InteractionHand.MAIN_HAND)
				&& this.material != Material.METAL) {
			this.update(pLevel, pPos, pState.getValue(OPEN) + 1, false);

			this.playSound(pLevel, pPos);
		}
		return InteractionResult.FAIL;
	}

	public void update(Level pLevel, BlockPos pPos, int state, boolean first) {
		if (state < 2) {
			updateAll(pLevel, pPos, state, first);
		} else {
			if (state == 2 && stateTwoPossible(pLevel, pPos, first)) {
				updateAll(pLevel, pPos, 2, first);
			} else {
				updateAll(pLevel, pPos, 0, first);
			}
		}
	}

	private void updateAll(Level level, BlockPos pos, int state,
			@Nullable boolean first) {
		boolean[] arr = {true, false};
		for (boolean up : arr) {
			int y = pos.getY();

			while (y > -70 && y < 330) {
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

			while (y > -70 && y < 330) {
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

	public void playSound(Level level, BlockPos pos) {
		level.playSound(null, pos, this.getSound(level, pos).get(),
				SoundSource.BLOCKS, 100F, 100F);
	}

	private RegistryObject<SoundEvent> getSound(Level level, BlockPos pos) {
		int open = level.getBlockState(pos).getValue(OPEN);
		return open == 0
				? SoundInit.SHUTTER_CLOSE
				: open == 1 && this.canUpdate()
						? SoundInit.SHUTTER_OPEN_HALF
						: SoundInit.SHUTTER_OPEN_FULL;
	}

	// gets called when a block updates
	@Override
	public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos,
			Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
		this.setPosition(pLevel, pPos);

		pLevel.setBlockAndUpdate(pPos,
				pLevel.getBlockState(pPos).setValue(POS, pos));

		redstoneUpdate(pLevel, pFromPos, pPos);
		
		// sets the shutter to 0 when a block on the left or the right is
		// placed
		this.setNeighbourBlocks(pLevel, pPos);
		if (!pLevel.isClientSide && pState.getValue(OPEN) == 2
				&& !canUpdate()) {
			this.update(pLevel, pPos, 0, false);
			this.playSound(pLevel, pPos);
		}
	}

	public void redstoneUpdate(Level pLevel, BlockPos pFromPos, BlockPos pPos) {
		// For redstone or power
		if (!(pLevel.getBlockState(pFromPos).getBlock() instanceof Shutter)) {
			// opening
			if (pLevel.hasNeighborSignal(pPos)) {
				this.setPowered(pLevel, pPos, true);
				if (this.stateTwoPossible(pLevel, pPos, false)) {
					this.update(pLevel, pPos, 2, false);
				} else {
					this.update(pLevel, pPos, 1, false);
				}
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

	private void setPosition(Level pLevel, BlockPos pPos) {
		boolean above = this.getBlockAbove(pPos, pLevel) instanceof Shutter;
		boolean below = this.getBlockBelow(pPos, pLevel) instanceof Shutter;

		if (above && below) {
			this.pos = ShutterPos.MIDDLE;
		} else if (above && !below) {
			this.pos = ShutterPos.LOWER;
		} else if (!above && below) {
			this.pos = ShutterPos.UPPER;
		} else {
			this.pos = ShutterPos.NORMAL;
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {

		BlockPos blockpos = pContext.getClickedPos();
		Level level = pContext.getLevel();

		this.setPosition(level, blockpos);

		boolean flag = level.hasNeighborSignal(blockpos)
				|| level.hasNeighborSignal(blockpos.above());

		if (flag) {
			if (this.stateTwoPossible(level, blockpos, true)) {
				this.update(level, blockpos, 2, true);
			} else {
				this.update(level, blockpos, 1, true);
			}
		}

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

	private void setNeighbourBlocks(Level level, BlockPos pos) {
		this.sideblocks[1] = this.getPlaceDirection(level,
				pos) == Direction.NORTH
				|| this.getPlaceDirection(level, pos) == Direction.SOUTH
						? level.getBlockState(pos.east()).getBlock()
						: level.getBlockState(pos.south()).getBlock();

		this.sideblocks[0] = this.getPlaceDirection(level,
				pos) == Direction.NORTH
				|| this.getPlaceDirection(level, pos) == Direction.SOUTH
						? level.getBlockState(pos.west()).getBlock()
						: level.getBlockState(pos.north()).getBlock();

	}

	private Direction getPlaceDirection(Level level, BlockPos pos) {
		return level.getBlockState(pos).getValue(FACING);
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