package net.stehschnitzel.shutter.block.properties;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Degradable;
import net.minecraft.block.Oxidizable;
import net.stehschnitzel.shutter.init.BlockInit;

import java.util.Optional;
import java.util.function.Supplier;

public interface WeatheringShutter extends Degradable<Oxidizable.OxidationLevel> {
    Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK_SHUTTER = Suppliers.memoize(
            () -> ImmutableBiMap.<Block, Block>builder()
                    .put(BlockInit.COPPER_SHUTTER, BlockInit.EXPOSED_COPPER_SHUTTER)
                    .put(BlockInit.EXPOSED_COPPER_SHUTTER, BlockInit.WEATHERED_COPPER_SHUTTER)
                    .put(BlockInit.WEATHERED_COPPER_SHUTTER, BlockInit.OXIDIZED_COPPER_SHUTTER)
                    .build()
    );
    Supplier<BiMap<Block, Block>> PREVIOUS_BY_BLOCK_SHUTTER = Suppliers.memoize(() -> NEXT_BY_BLOCK_SHUTTER.get().inverse());

    Supplier<BiMap<Block, Block>> SWITCH_TO_WAXED_BLOCK = Suppliers.memoize(
            () -> ImmutableBiMap.<Block, Block>builder()
                    .put(BlockInit.COPPER_SHUTTER, BlockInit.WAXED_COPPER_SHUTTER)
                    .put(BlockInit.WEATHERED_COPPER_SHUTTER, BlockInit.WAXED_WEATHERED_COPPER_SHUTTER)
                    .put(BlockInit.EXPOSED_COPPER_SHUTTER, BlockInit.WAXED_EXPOSED_COPPER_SHUTTER)
                    .put(BlockInit.OXIDIZED_COPPER_SHUTTER, BlockInit.WAXED_OXIDIZED_COPPER_SHUTTER)
                    .build()
    );

    Supplier<BiMap<Block, Block>> SWITCH_TO_UNWAXED_BLOCK = Suppliers.memoize(() -> SWITCH_TO_WAXED_BLOCK.get().inverse());

    static Optional<Block>  getUnwaxedBlock(Block block) {
        return Optional.ofNullable(SWITCH_TO_UNWAXED_BLOCK.get().get(block));
    }

    static Optional<Block>  getWaxedBlock(Block block) {
        return Optional.ofNullable(SWITCH_TO_WAXED_BLOCK.get().get(block));
    }

    static Optional<Block> getDecreasedOxidationBlock(Block block) {
        return Optional.ofNullable(PREVIOUS_BY_BLOCK_SHUTTER.get().get(block));
    }

    static Block getUnaffectedOxidationBlock(Block block) {
        Block block2 = block;

        for(Block block3 = PREVIOUS_BY_BLOCK_SHUTTER.get().get(block2); block3 != null; block3 = PREVIOUS_BY_BLOCK_SHUTTER.get().get(block2)) {
            block2 = block3;
        }

        return block2;
    }

    static Optional<BlockState> getDecreasedOxidationState(BlockState state) {
        return getDecreasedOxidationBlock(state.getBlock()).map((block) -> {
            return block.getStateWithProperties(state);
        });
    }

    static Optional<Block> getIncreasedOxidationBlock(Block block) {
        return Optional.ofNullable(NEXT_BY_BLOCK_SHUTTER.get().get(block));
    }

    static BlockState getUnaffectedOxidationState(BlockState state) {
        return getUnaffectedOxidationBlock(state.getBlock()).getStateWithProperties(state);
    }

    default Optional<BlockState> getDegradationResult(BlockState state) {
        return getIncreasedOxidationBlock(state.getBlock()).map((block) -> {
            return block.getStateWithProperties(state);
        });
    }

    default float getDegradationChanceMultiplier() {
        return this.getDegradationLevel() == Oxidizable.OxidationLevel.UNAFFECTED ? 0.75F : 1.0F;
    }
}
