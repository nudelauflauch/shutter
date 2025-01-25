package net.stehschnitzel.shutter.block;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class LeadShutter extends Shutter {

	public LeadShutter(Settings settings) {
		super(settings, true);
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
		if (!player.isSneaking()) {
			int rand = new Random().nextInt(100);
			if (rand < 35 && !world.isClient) {
				super.update(world, pos, state.get(OPEN) + 1, false);

				super.playSound(world, pos, world.getBlockState(pos).get(OPEN));
			}
			return ActionResult.success(!world.isClient);
		}
		return ActionResult.FAIL;
	}
}
