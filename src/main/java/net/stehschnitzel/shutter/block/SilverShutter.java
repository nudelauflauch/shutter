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
		super(settings, true, false);
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
		if (!player.isSneaking()
				&& player.getActiveHand().equals(Hand.MAIN_HAND)
				&& world.getBlockState(pos).get(Shutter.POWERED)) {
			if (this.update(world, pos, state.get(OPEN) + 1, false)) {
				return ActionResult.PASS;
			}
			this.playSound(world, pos);
			return ActionResult.SUCCESS_SERVER;
		}
		return ActionResult.FAIL;
	}

	@Override
	public boolean update(World world, BlockPos pos, int state, boolean first) {
		if (world.getBlockState(pos).get(Shutter.POWERED)) {
			super.update(world, pos, state, first);
		}
		return true;
	}

	@Override
	public void redstoneUpdate(World world, BlockPos pos) {
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
