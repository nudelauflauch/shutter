package net.stehschnitzel.shutter.block;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class GoldShutter extends Shutter {

	public GoldShutter(Settings settings) {
		super(settings, true, true);
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
		if (!player.isSneaking()
				&& player.getActiveHand().equals(Hand.MAIN_HAND)
				&& !state.get(POWERED)) {
			super.update(world, pos, state.get(OPEN) + 1, false);
			this.playSound(world, pos);
			return ActionResult.SUCCESS_SERVER;
		}
		return ActionResult.FAIL;
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

	@Override
	public boolean canUpdate(WorldAccess world, BlockPos pos) {
		return super.canUpdate(world, pos);
	}
}