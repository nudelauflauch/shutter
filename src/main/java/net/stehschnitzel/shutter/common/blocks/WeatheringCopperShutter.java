package net.stehschnitzel.shutter.common.blocks;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class WeatheringCopperShutter extends Shutter implements WeatheringShutter {
    public static final MapCodec<WeatheringCopperShutter> CODEC = RecordCodecBuilder.mapCodec(
            p_311462_ -> p_311462_.group(WeatheringCopper.WeatherState.CODEC.fieldOf("weathering_state").forGetter(ChangeOverTimeBlock::getAge), propertiesCodec())
                    .apply(p_311462_, WeatheringCopperShutter::new)
    );
    WeatheringCopper.WeatherState weatherState;

    public WeatheringCopperShutter(WeatheringCopper.WeatherState weatherState, Properties properties) {
        super(properties, true);
        this.weatherState = weatherState;
    }

    @Override
    public InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        if (!pPlayer.mayBuild()) {
            return InteractionResult.PASS;
        } else if (!pPlayer.isCrouching()) {

            this.update(pLevel, pPos, pState.getValue(OPEN) + 1, false);

            this.playSound(pLevel, pPos, pLevel.getBlockState(pPos).getValue(OPEN));
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }
        return InteractionResult.FAIL;
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return CODEC;
    }

    @Override
    protected void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        this.changeOverTime(pState, pLevel, pPos, pRandom);
        System.out.println("Update");
    }

    @Override
    protected boolean isRandomlyTicking(BlockState pState) {
        System.out.println(WeatheringCopper.getNext(pState.getBlock()).isPresent());
        return WeatheringShutter.getNext(pState.getBlock()).isPresent();
    }

    @Override
    public WeatherState getAge() {
        return this.weatherState;
    }
}
