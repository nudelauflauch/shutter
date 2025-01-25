package net.stehschnitzel.shutter.block;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SilverShutter extends Shutter {

	public SilverShutter(Settings settings) {
		super(settings, true);
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
		if (!player.isSneaking()
				&& world.getBlockState(pos).get(Shutter.POWERED)) {
			this.update(world, pos, state.get(OPEN) + 1, false);
			this.playSound(world, pos, world.getBlockState(pos).get(OPEN));
		}
		return ActionResult.FAIL;
	}

	@Override
	public void update(World world, BlockPos pos, int state, boolean first) {
		if (world.getBlockState(pos).get(Shutter.POWERED)) {
			super.update(world, pos, state, first);
		}
	}

	@Override
	public void redstoneUpdate(World world, BlockPos neighborPos, BlockPos pos) {
		if (world.isReceivingRedstonePower(pos)) {
			world.setBlockState(pos,
					world.getBlockState(pos).with(Shutter.POWERED, true));
		} else if (!world.isReceivingRedstonePower(pos)
				&& world.getBlockState(pos).get(POWERED)) {
			world.setBlockState(pos, world.getBlockState(pos)
					.with(Shutter.POWERED, false));
		}
	}
}
