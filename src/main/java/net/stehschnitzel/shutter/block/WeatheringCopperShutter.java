package net.stehschnitzel.shutter.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.stehschnitzel.shutter.init.BlockInit;

public class WeatheringCopperShutter extends Shutter implements Oxidizable {
    public static final MapCodec<WeatheringCopperShutter> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(Oxidizable.OxidationLevel.CODEC.fieldOf("weathering_state").forGetter(Degradable::getDegradationLevel), createSettingsCodec())
                    .apply(instance, WeatheringCopperShutter::new)
    );
    private final Oxidizable.OxidationLevel oxidationLevel;

    public WeatheringCopperShutter(Oxidizable.OxidationLevel oxidationLevel, Settings settings) {
        super(settings, true);
        this.oxidationLevel = oxidationLevel;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!player.isSneaking()) {
            this.update(world, pos, state.get(OPEN) + 1, false);

            this.playSound(world, pos, world.getBlockState(pos).get(OPEN));
            return ActionResult.SUCCESS_SERVER;
        }
        return ActionResult.FAIL;
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.tickDegradation(state, world, pos, random);
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return state.getBlock() != BlockInit.OXIDIZED_COPPER_SHUTTER;
    }

    @Override
    protected MapCodec<? extends WeatheringCopperShutter> getCodec() {
        return CODEC;
    }

    @Override
    public Oxidizable.OxidationLevel getDegradationLevel() {
        return this.oxidationLevel;
    }
}
