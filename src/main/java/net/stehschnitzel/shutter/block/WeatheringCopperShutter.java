package net.stehschnitzel.shutter.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoneycombItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.stehschnitzel.shutter.block.properties.WeatheringShutter;

import java.util.Optional;

public class WeatheringCopperShutter extends Shutter implements WeatheringShutter {
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
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.getItem() instanceof HoneycombItem) {
            Optional<Block> waxed = WeatheringShutter.getWaxedBlock(state.getBlock());
            if (waxed.isPresent()) {
                world.setBlockState(pos, waxed.get().getStateWithProperties(state));
                if (!player.isCreative()) {
                    stack.decrement(1);
                }
                world.syncWorldEvent(player, 3003, pos, 0);
                return ItemActionResult.SKIP_DEFAULT_BLOCK_INTERACTION;
            }
        } else if (stack.getItem() instanceof AxeItem) {
            Optional<Block> unwaxed = WeatheringShutter.getUnwaxedBlock(state.getBlock());
            Optional<Block> previous = WeatheringShutter.getDecreasedOxidationBlock(state.getBlock());
            if (unwaxed.isPresent()) {
                world.setBlockState(pos, unwaxed.get().getStateWithProperties(state));

                world.playSound(player, pos, SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.BLOCKS, 1.0F, 1.0F);
                world.syncWorldEvent(player, 3004, pos, 0);
            } else  if (previous.isPresent()) {
                world.setBlockState(pos, previous.get().getStateWithProperties(state));

                world.playSound(player, pos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                world.syncWorldEvent(player, 3005, pos, 0);
            }
            if ((unwaxed.isPresent() || previous.isPresent())) {
                if (!player.isCreative()) {
                    stack.damage(1, player, LivingEntity.getSlotForHand(hand));
                }
                return ItemActionResult.SKIP_DEFAULT_BLOCK_INTERACTION;
            }
        }
        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!player.isSneaking()) {
            this.update(world, pos, state.get(OPEN) + 1, false);

            this.playSound(world, pos, world.getBlockState(pos).get(OPEN));
            return ActionResult.success(!world.isClient);
        }
        return ActionResult.FAIL;
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.tickDegradation(state, world, pos, random);
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return WeatheringShutter.getIncreasedOxidationBlock(state.getBlock()).isPresent();
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
