package net.stehschnitzel.shutter.common.blocks;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.stehschnitzel.shutter.common.blocks.properties.WeatheringShutter;
import net.stehschnitzel.shutter.init.BlockInit;

import java.util.Optional;

public class WeatheringCopperShutter extends Shutter implements WeatheringShutter {
    public static final MapCodec<WeatheringCopperShutter> CODEC = RecordCodecBuilder.mapCodec(
            weatheringState -> weatheringState.group(WeatheringCopper.WeatherState.CODEC.fieldOf("weathering_state").forGetter(ChangeOverTimeBlock::getAge), propertiesCodec())
                    .apply(weatheringState, WeatheringCopperShutter::new)
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
    public ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        if (pStack.getItem() instanceof HoneycombItem) {
            Optional<Block> waxed = WeatheringShutter.getWaxedBlock(pState.getBlock());
            if (waxed.isPresent()) {
                pLevel.setBlockAndUpdate(pPos, waxed.get().withPropertiesOf(pState));
                if (!pPlayer.isCreative()) {
                    pStack.shrink(1);
                }
                pLevel.levelEvent(pPlayer, 3003, pPos, 0);
                return ItemInteractionResult.SKIP_DEFAULT_BLOCK_INTERACTION;
            }
        } else if (pStack.getItem() instanceof AxeItem) {
            Optional<Block> unwaxed = WeatheringShutter.getUnwaxedBlock(pState.getBlock());
            Optional<Block> previous = WeatheringShutter.getPrevious(pState.getBlock());
            if (unwaxed.isPresent()) {
                pLevel.setBlockAndUpdate(pPos, unwaxed.get().withPropertiesOf(pState));

                pLevel.playSound(pPlayer, pPos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
                pLevel.levelEvent(pPlayer, 3004, pPos, 0);
            } else  if (previous.isPresent()) {
                pLevel.setBlockAndUpdate(pPos, previous.get().withPropertiesOf(pState));

                pLevel.playSound(pPlayer, pPos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
                pLevel.levelEvent(pPlayer, 3005, pPos, 0);
            }
            if ((unwaxed.isPresent() || previous.isPresent())) {
                if (!pPlayer.isCreative()) {
                    pStack.hurtAndBreak(1, pPlayer, LivingEntity.getSlotForHand(pHand));
                }
                return ItemInteractionResult.SKIP_DEFAULT_BLOCK_INTERACTION;
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return CODEC;
    }

    @Override
    protected void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        this.changeOverTime(pState, pLevel, pPos, pRandom);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState pState) {
        return pState.getBlock() != BlockInit.OXIDIZED_COPPER_SHUTTER.get();
    }

    @Override
    public WeatherState getAge() {
        return this.weatherState;
    }
}
