package net.stehschnitzel.shutter.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.stehschnitzel.shutter.common.blocks.properties.WeatheringShutter;
import net.stehschnitzel.shutter.init.BlockInit;

import java.util.Optional;

public class WeatheringCopperShutter extends Shutter implements WeatheringShutter {
    WeatheringCopper.WeatherState weatherState;

    public WeatheringCopperShutter(WeatheringCopper.WeatherState weatherState, Properties properties) {
        super(properties, true);
        this.weatherState = weatherState;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pPlayer.mayBuild()) {
            return InteractionResult.PASS;
        } else if (!this.useItemOn(pPlayer.getMainHandItem(), pState, pLevel, pPos, pPlayer, pPlayer.getUsedItemHand(), pHit)
                && !pPlayer.isCrouching()) {
            this.update(pLevel, pPos, pState.getValue(OPEN) + 1, false);

            this.playSound(pLevel, pPos, pLevel.getBlockState(pPos).getValue(OPEN));
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }
        return InteractionResult.FAIL;
    }

    public boolean useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        if (pStack.getItem() instanceof HoneycombItem) {
            Optional<Block> waxed = WeatheringShutter.getWaxedBlock(pState.getBlock());
            if (waxed.isPresent()) {
                pLevel.setBlockAndUpdate(pPos, waxed.get().withPropertiesOf(pState));
                if (!pPlayer.isCreative()) {
                    pStack.shrink(1);
                }
                pLevel.levelEvent(pPlayer, 3003, pPos, 0);
                return true;
            }
        } else if (pStack.getItem() instanceof AxeItem) {
            Optional<Block> unwaxed = WeatheringShutter.getUnwaxedBlock(pState.getBlock());
            Optional<Block> previous = WeatheringShutter.getPrevious(pState.getBlock());
            if (unwaxed.isPresent()) {
                pLevel.setBlockAndUpdate(pPos, unwaxed.get().withPropertiesOf(pState));

                pLevel.playSound(pPlayer, pPos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
                pLevel.levelEvent(pPlayer, 3004, pPos, 0);
            } else if (previous.isPresent()) {
                pLevel.setBlockAndUpdate(pPos, previous.get().withPropertiesOf(pState));

                pLevel.playSound(pPlayer, pPos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
                pLevel.levelEvent(pPlayer, 3005, pPos, 0);
            }
            if ((unwaxed.isPresent() || previous.isPresent())) {
                if (!pPlayer.isCreative()) {
                    pStack.hurtAndBreak(1, pPlayer, (player) -> {
                        player.broadcastBreakEvent(pHand);
                    });
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        this.onRandomTick(pState, pLevel, pPos, pRandom);
    }

    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return pState.getBlock() != BlockInit.OXIDIZED_COPPER_SHUTTER.get();
    }

    @Override
    public WeatheringCopper.WeatherState getAge() {
        return this.weatherState;
    }
}
