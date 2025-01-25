package net.stehschnitzel.shutter.common.blocks.properties;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.stehschnitzel.shutter.init.BlockInit;

import java.util.Optional;
import java.util.function.Supplier;

public interface WeatheringShutter extends WeatheringCopper {
    Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK_SHUTTER = Suppliers.memoize(
            () -> ImmutableBiMap.<Block, Block>builder()
                    .put(BlockInit.COPPER_SHUTTER.get(), BlockInit.EXPOSED_COPPER_SHUTTER.get())
                    .put(BlockInit.EXPOSED_COPPER_SHUTTER.get(), BlockInit.WEATHERED_COPPER_SHUTTER.get())
                    .put(BlockInit.WEATHERED_COPPER_SHUTTER.get(), BlockInit.OXIDIZED_COPPER_SHUTTER.get())
                    .build()
    );
    Supplier<BiMap<Block, Block>> PREVIOUS_BY_BLOCK_SHUTTER = Suppliers.memoize(() -> NEXT_BY_BLOCK_SHUTTER.get().inverse());

    Supplier<BiMap<Block, Block>> SWITCH_TO_WAXED_BLOCK = Suppliers.memoize(
            () -> ImmutableBiMap.<Block, Block>builder()
                    .put(BlockInit.COPPER_SHUTTER.get(), BlockInit.WAXED_COPPER_SHUTTER.get())
                    .put(BlockInit.WEATHERED_COPPER_SHUTTER.get(), BlockInit.WAXED_WEATHERED_COPPER_SHUTTER.get())
                    .put(BlockInit.EXPOSED_COPPER_SHUTTER.get(), BlockInit.WAXED_EXPOSED_COPPER_SHUTTER.get())
                    .put(BlockInit.OXIDIZED_COPPER_SHUTTER.get(), BlockInit.WAXED_OXIDIZED_COPPER_SHUTTER.get())
                    .build()
    );

    Supplier<BiMap<Block, Block>> SWITCH_TO_UNWAXED_BLOCK = Suppliers.memoize(() -> SWITCH_TO_WAXED_BLOCK.get().inverse());

    static Optional<Block>  getUnwaxedBlock(Block block) {
        return Optional.ofNullable(SWITCH_TO_UNWAXED_BLOCK.get().get(block));
    }

    static Optional<Block>  getWaxedBlock(Block block) {
        return Optional.ofNullable(SWITCH_TO_WAXED_BLOCK.get().get(block));
    }

    static Optional<Block> getPrevious(Block pBlock) {
        return Optional.ofNullable(PREVIOUS_BY_BLOCK_SHUTTER.get().get(pBlock));
    }

    static Block getFirst(Block pBlock) {
        Block block = pBlock;

        for (Block block1 = PREVIOUS_BY_BLOCK_SHUTTER.get().get(pBlock); block1 != null; block1 = PREVIOUS_BY_BLOCK_SHUTTER.get().get(block1)) {
            block = block1;
        }

        return block;
    }

    static Optional<BlockState> getPrevious(BlockState pState) {
        return getPrevious(pState.getBlock()).map(p_154903_ -> p_154903_.withPropertiesOf(pState));
    }

    static Optional<Block> getNext(Block pBlock) {
        return Optional.ofNullable(NEXT_BY_BLOCK_SHUTTER.get().get(pBlock));
    }

    static BlockState getFirst(BlockState pState) {
        return getFirst(pState.getBlock()).withPropertiesOf(pState);
    }

    @Override
    default Optional<BlockState> getNext(BlockState pState) {
        return getNext(pState.getBlock()).map(p_154896_ -> p_154896_.withPropertiesOf(pState));
    }

    @Override
    default float getChanceModifier() {
        return this.getAge() == WeatheringCopper.WeatherState.UNAFFECTED ? 0.75F : 1.0F;
    }
}
