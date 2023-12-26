package net.stehschnitzel.shutter.common.blocks;

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
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.registries.RegistryObject;
import net.stehschnitzel.shutter.common.blocks.properties.ShutterDouble;
import net.stehschnitzel.shutter.common.blocks.properties.ShutterPos;
import net.stehschnitzel.shutter.common.blocks.properties.ShutterVoxels;
import net.stehschnitzel.shutter.init.BlockInit;
import net.stehschnitzel.shutter.init.SoundInit;

public class Shutter extends Block {

	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
	public static final EnumProperty<ShutterPos> POS = EnumProperty
			.create("half", ShutterPos.class);

	public static final IntegerProperty OPEN = IntegerProperty.create("open", 0,2);

	public static final EnumProperty<ShutterDouble> DOUBLE_DOOR = EnumProperty
			.create("double_door", ShutterDouble.class);

	private BlockState[] sideblocks = new BlockState[2];
	private boolean isMetal;

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

	public void update(Level pLevel, BlockPos pPos, int state, boolean first) {
		if (pLevel.getBlockState(pPos).getValue(DOUBLE_DOOR) != ShutterDouble.NONE) {
			if (state < 2) {
				updateAllDouble(pLevel, pPos, state, first);
			} else if (state == 2 && stateTwoPossibleDouble(pLevel, pPos, first)) {
				updateAllDouble(pLevel, pPos, 2, first);
			} else {
				updateAllDouble(pLevel, pPos, 0, first);
			}
		} else {
			if (state < 2) {
				updateAll(pLevel, pPos, state, first);
			} else if (state == 2 && stateTwoPossible(pLevel, pPos, first)) {
				updateAll(pLevel, pPos, 2, first);
			} else {
				updateAll(pLevel, pPos, 0, first);
			}
		}
	}

	private void updateAllDouble(Level level, BlockPos pos, int state, boolean first) {
		updateAll(level, pos, state, first);
		updateAll(level, this.hasShutterAsNeighbor(level,pos), state, first);
	}

	private void updateAll(Level level, BlockPos pos, int state, boolean first) {
		boolean[] arr = {true, false};
		for (boolean up : arr) {
			int y = pos.getY();

			while (y > -70 && y < 330) {
				BlockPos update_pos = new BlockPos(pos.getX(), y, pos.getZ());
				Block block = level.getBlockState(update_pos).getBlock();

				if (block instanceof Shutter shutter) {
					shutter.setOpen(level, update_pos, state);
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

	private boolean stateTwoPossibleDouble(Level level, BlockPos pos, boolean first) {
		return stateTwoPossible(level, pos, first) && stateTwoPossible(level, this.hasShutterAsNeighbor(level,pos), false);
	}

	private boolean stateTwoPossible(Level level, BlockPos pos, boolean first) {
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
					//if the blo
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
				SoundSource.BLOCKS, 1F, 1F);
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
		this.setNeighbourBlocks(pLevel, pPos);
		redstoneUpdate(pLevel, pFromPos, pPos);


		//checks if it should update it double block state
		if (pState.getValue(DOUBLE_DOOR) == ShutterDouble.NONE) {
			if (sideblocks[0].getBlock() instanceof Shutter) {
				pState = pState.setValue(DOUBLE_DOOR, ShutterDouble.RIGHT);
			} else if (sideblocks[1].getBlock() instanceof Shutter) {
				pState = pState.setValue(DOUBLE_DOOR, ShutterDouble.LEFT);
			}
		}
		//resets it to None, if there are no shutters arround
		if (pState.getValue(DOUBLE_DOOR) == ShutterDouble.LEFT && !(sideblocks[1].getBlock() instanceof Shutter)) {
			pState = pState.setValue(DOUBLE_DOOR, ShutterDouble.NONE);
		}
		if (pState.getValue(DOUBLE_DOOR) == ShutterDouble.RIGHT && !(sideblocks[0].getBlock() instanceof Shutter)) {
			pState = pState.setValue(DOUBLE_DOOR, ShutterDouble.NONE);
		}

			// sets the shutter to 0 when a block on the left or right is placed
		if (!pLevel.isClientSide && pState.getValue(OPEN) == 2
				&& !canUpdate()) {
			this.update(pLevel, pPos, 0, false);
			this.playSound(pLevel, pPos);
		}
		pState = pState.setValue(POS, this.getPosition(pLevel, pPos));
		pLevel.setBlock(pPos, pState, 18);
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

	private ShutterPos getPosition(Level pLevel, BlockPos pPos) {
		boolean above = this.getBlockAbove(pPos, pLevel) instanceof Shutter;
		boolean below = this.getBlockBelow(pPos, pLevel) instanceof Shutter;

		if (above && below) {
			return ShutterPos.MIDDLE;
		} else if (above && !below) {
			return ShutterPos.LOWER;
		} else if (!above && below) {
			return ShutterPos.UPPER;
		}
		return ShutterPos.NORMAL;
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		BlockPos blockpos = pContext.getClickedPos();
		Level level = pContext.getLevel();

		this.setNeighbourBlocks(level, blockpos, pContext.getHorizontalDirection());

		boolean neighbor_has_signal = level.hasNeighborSignal(blockpos)
				|| level.hasNeighborSignal(blockpos.above());

		if (neighbor_has_signal) {
			if (this.stateTwoPossible(level, blockpos, true)) {
				this.update(level, blockpos, 2, true);
			} else {
				this.update(level, blockpos, 1, true);
			}
		}

		//get if the neighbours are also shutters
		ShutterDouble isdoubleDoor = ShutterDouble.NONE;
		if (sideblocks[0].getBlock() instanceof Shutter && sideblocks[0].getValue(DOUBLE_DOOR) == ShutterDouble.NONE) {
			isdoubleDoor = ShutterDouble.RIGHT;
		} else if (sideblocks[1].getBlock() instanceof Shutter && sideblocks[1].getValue(DOUBLE_DOOR) == ShutterDouble.NONE) {
			isdoubleDoor = ShutterDouble.LEFT;
		}

		// gets the block state above and below
		int open_state = neighbor_has_signal ? this.canUpdate() ? 2 : 1 : 0;
		if (this.getBlockBelow(blockpos, level) instanceof Shutter) {
			open_state = level.getBlockState(blockpos.below()).getValue(OPEN);

		} else if (this.getBlockAbove(blockpos, level) instanceof Shutter ) {
			open_state = level.getBlockState(blockpos.above()).getValue(OPEN);
		}

		return this.defaultBlockState()
				.setValue(FACING, pContext.getHorizontalDirection())
				.setValue(POWERED, neighbor_has_signal)
				.setValue(POS, getPosition(level, blockpos))
				.setValue(DOUBLE_DOOR, isdoubleDoor)
				.setValue(OPEN, open_state);

	}

	private void setNeighbourBlocks(Level level, BlockPos pos) {
		this.setNeighbourBlocks(level, pos, this.getPlaceDirection(level, pos));
	}

	private void setNeighbourBlocks(Level level, BlockPos pos, Direction direction) {
		switch (direction) {
			case NORTH: sideblocks[0] = level.getBlockState(pos.east()); sideblocks[1] = level.getBlockState(pos.west()); break;
			case SOUTH: sideblocks[0] = level.getBlockState(pos.west()); sideblocks[1] = level.getBlockState(pos.east()); break;
			case EAST: sideblocks[0] = level.getBlockState(pos.south()); sideblocks[1] = level.getBlockState(pos.north()); break;
			default: sideblocks[0] = level.getBlockState(pos.north()); sideblocks[1] = level.getBlockState(pos.south()); break;
		}
	}

	private BlockPos hasShutterAsNeighbor(Level level, BlockPos pos) {
		if (level.getBlockState(pos.west()).getBlock() instanceof Shutter) {
			return pos.west();
		} else if (level.getBlockState(pos.east()).getBlock() instanceof Shutter) {
			return pos.east();
		} else if (level.getBlockState(pos.north()).getBlock() instanceof Shutter) {
			return pos.north();
		} else if (level.getBlockState(pos.south()).getBlock() instanceof Shutter) {
			return pos.south();
		}
		return pos.north();
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

	private Direction getPlaceDirection(Level level, BlockPos pos) {
		return level.getBlockState(pos).getValue(FACING);
	}

	// if it can get to the next open state
	public boolean canUpdate() {
		for (BlockState block1 : this.sideblocks) {
			if (block1 == null) {
				return false;
			}
			Block block = block1.getBlock();
			if (block != Blocks.AIR && !(block instanceof IPlantable)
					&& !(block instanceof FenceBlock)
					&& !(block instanceof FenceGateBlock)
					&& !(block == Blocks.WATER) && block != Blocks.LAVA
					&& block != Blocks.IRON_BARS
					&& !(block instanceof LanternBlock)
					&& !(block instanceof FlowerPotBlock)
					&& !(block instanceof TorchBlock)
					&& !(block instanceof CandleBlock)
					&& !(block instanceof ButtonBlock)
					&& !(block instanceof LadderBlock)
					&& !(block instanceof SignBlock)
					&& !(block instanceof Shutter)) {
				return false;
			}
		}
		return true;
	}

	public void setPowered(Level level, BlockPos pos, boolean state) {
		level.setBlock(pos,
				level.getBlockState(pos).setValue(POWERED, state), 19);
		System.out.println("sus");
	}

	public void setOpen(Level level, BlockPos pos, int state) {
		level.setBlock(pos,
				level.getBlockState(pos).setValue(OPEN, state), 19);
		System.out.println("sas");
	}

	private Block getBlockAbove(BlockPos pos, Level level) {
		return level.getBlockState(pos.above()).getBlock();
	}

	private Block getBlockBelow(BlockPos pos, Level level) {
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