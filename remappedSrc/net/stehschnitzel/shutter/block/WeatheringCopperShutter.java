package net.stehschnitzel.shutter.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Oxidizable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.stehschnitzel.shutter.init.BlockInit;

public class WeatheringCopperShutter extends Shutter implements Oxidizable {
    private final OxidationLevel oxidationLevel;

    public WeatheringCopperShutter(OxidationLevel oxidationLevel, Settings settings) {
        super(settings, false);
        this.oxidationLevel = oxidationLevel;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!player.isSneaking()
                && hand.equals(Hand.MAIN_HAND)
                && !this.isMetal) {
            this.update(world, pos, state.get(OPEN) + 1, false);

            this.playSound(world, pos);
            return ActionResult.success(!world.isClient);
        }
        return ActionResult.FAIL;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.tickDegradation(state, world, pos, random);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return state.getBlock() != BlockInit.OXIDIZED_COPPER_SHUTTER;
    }

    @Override
    public void tickDegradation(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        Oxidizable.super.tickDegradation(state, world, pos, random);
    }

    @Override
    public OxidationLevel getDegradationLevel() {
        return this.oxidationLevel;
    }
}
