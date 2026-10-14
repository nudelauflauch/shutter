package net.stehschnitzel.shutter.datagen.block;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.stehschnitzel.shutter.ShutterMain;
import net.stehschnitzel.shutter.common.blocks.Shutter;
import net.stehschnitzel.shutter.common.blocks.properties.ShutterDouble;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ShutterBlockModelGenerators extends BlockModelGenerators {

    public ShutterBlockModelGenerators(Consumer<BlockModelDefinitionGenerator> blockStateOutput, ItemModelOutput itemModelOutput, BiConsumer<Identifier, ModelInstance> modelOutput) {
        super(blockStateOutput, itemModelOutput, modelOutput);
    }

    public static TextureMapping shutterMapping(DeferredBlock<Shutter> deferredBlock) {
        return shutterMapping(deferredBlock, deferredBlock.get());
    }

    public static TextureMapping shutterMapping(DeferredBlock<Shutter> deferredBlock, Block particle) {
        return new TextureMapping()
                .put(ShutterTemplates.BASE, TextureMapping.getBlockTexture(deferredBlock.get()))
                .put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(particle));
    }

    //for blocks that look like a different block for example waxed shutters dont have their own textures
    public void createShutter(BlockModelGenerators blockModels, DeferredBlock<Shutter> deferredBlock, DeferredBlock<Shutter> usedTextureBlock, Block particleBlock) {
        //creates the shutter model
        TextureMapping texturemapping = shutterMapping(usedTextureBlock, particleBlock);
        createShutter(blockModels, deferredBlock, texturemapping);

        //copies the item model form the #usedTextureBlock as the model for the #deferredBlock
        this.registerSimpleItemModel(deferredBlock.get(),
                ModelTemplates.FLAT_ITEM
                        .create(
                                ModelLocationUtils.getModelLocation(deferredBlock.asItem()),
                                TextureMapping.layer0(TextureMapping.getItemTexture(usedTextureBlock.asItem())),
                                this.modelOutput
                        ));
    }

    //the particle texture is the same as the block texture
    public void createShutter(BlockModelGenerators blockModels, DeferredBlock<Shutter> deferredBlock) {
        createShutter(blockModels, deferredBlock, deferredBlock.get());
    }

    //uses specific textures for the particle but are all solid
    public void createShutter(BlockModelGenerators blockModels, DeferredBlock<Shutter> deferredBlock, Block particleBlock) {
        //creates the shutter model
        TextureMapping texturemapping = shutterMapping(deferredBlock, particleBlock);
        createShutter(blockModels, deferredBlock, texturemapping);

        //registers the item model for the shutter
        this.registerSimpleFlatItemModel(deferredBlock.asItem());
    }

    //creates a shutter model and a blockstate for blocks
    public void createShutter(BlockModelGenerators blockModels, DeferredBlock<Shutter> deferredBlock, TextureMapping texturemapping) {
        Block shutterBlock = deferredBlock.get();
        //all the different models for every state
        MultiVariant normal_0 = plainVariant(ShutterTemplates.SHUTTER_NORMAL_0
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant normal_1 = plainVariant(ShutterTemplates.SHUTTER_NORMAL_1
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant normal_2 = plainVariant(ShutterTemplates.SHUTTER_NORMAL_2
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant normal_left_0 = plainVariant(ShutterTemplates.SHUTTER_NORMAL_LEFT_0
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant normal_left_1 = plainVariant(ShutterTemplates.SHUTTER_NORMAL_LEFT_1
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant normal_left_2 = plainVariant(ShutterTemplates.SHUTTER_NORMAL_LEFT_2
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant normal_right_0 = plainVariant(ShutterTemplates.SHUTTER_NORMAL_RIGHT_0
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant normal_right_1 = plainVariant(ShutterTemplates.SHUTTER_NORMAL_RIGHT_1
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant normal_right_2 = plainVariant(ShutterTemplates.SHUTTER_NORMAL_RIGHT_2
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant lower_0 = plainVariant(ShutterTemplates.SHUTTER_LOWER_0
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant lower_1 = plainVariant(ShutterTemplates.SHUTTER_LOWER_1
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant lower_2 = plainVariant(ShutterTemplates.SHUTTER_LOWER_2
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant lower_left_0 = plainVariant(ShutterTemplates.SHUTTER_LOWER_LEFT_0
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant lower_left_1 = plainVariant(ShutterTemplates.SHUTTER_LOWER_LEFT_1
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant lower_left_2 = plainVariant(ShutterTemplates.SHUTTER_LOWER_LEFT_2
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant lower_right_0 = plainVariant(ShutterTemplates.SHUTTER_LOWER_RIGHT_0
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant lower_right_1 = plainVariant(ShutterTemplates.SHUTTER_LOWER_RIGHT_1
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant lower_right_2 = plainVariant(ShutterTemplates.SHUTTER_LOWER_RIGHT_2
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant middle_0 = plainVariant(ShutterTemplates.SHUTTER_MIDDLE_0
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant middle_1 = plainVariant(ShutterTemplates.SHUTTER_MIDDLE_1
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant middle_2 = plainVariant(ShutterTemplates.SHUTTER_MIDDLE_2
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant middle_left_0 = plainVariant(ShutterTemplates.SHUTTER_MIDDLE_LEFT_0
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant middle_left_1 = plainVariant(ShutterTemplates.SHUTTER_MIDDLE_LEFT_1
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant middle_left_2 = plainVariant(ShutterTemplates.SHUTTER_MIDDLE_LEFT_2
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant middle_right_0 = plainVariant(ShutterTemplates.SHUTTER_MIDDLE_RIGHT_0
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant middle_right_1 = plainVariant(ShutterTemplates.SHUTTER_MIDDLE_RIGHT_1
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant middle_right_2 = plainVariant(ShutterTemplates.SHUTTER_MIDDLE_RIGHT_2
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant upper_0 = plainVariant(ShutterTemplates.SHUTTER_UPPER_0
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant upper_1 = plainVariant(ShutterTemplates.SHUTTER_UPPER_1
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant upper_2 = plainVariant(ShutterTemplates.SHUTTER_UPPER_2
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant upper_left_0 = plainVariant(ShutterTemplates.SHUTTER_UPPER_LEFT_0
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant upper_left_1 = plainVariant(ShutterTemplates.SHUTTER_UPPER_LEFT_1
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant upper_left_2 = plainVariant(ShutterTemplates.SHUTTER_UPPER_LEFT_2
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant upper_right_0 = plainVariant(ShutterTemplates.SHUTTER_UPPER_RIGHT_0
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant upper_right_1 = plainVariant(ShutterTemplates.SHUTTER_UPPER_RIGHT_1
                .create(shutterBlock, texturemapping, this.modelOutput));
        MultiVariant upper_right_2 = plainVariant(ShutterTemplates.SHUTTER_UPPER_RIGHT_2
                .create(shutterBlock, texturemapping, this.modelOutput));

        //buildes the blockstate file
        blockModels.blockStateOutput.accept(
                createShutter(
                        shutterBlock,
                        lower_0, lower_1, lower_2,
                        lower_left_0, lower_left_1, lower_left_2,
                        lower_right_0, lower_right_1, lower_right_2,

                        normal_0, normal_1, normal_2,
                        normal_left_0, normal_left_1, normal_left_2,
                        normal_right_0, normal_right_1, normal_right_2,

                        upper_0, upper_1, upper_2,
                        upper_left_0, upper_left_1, upper_left_2,
                        upper_right_0, upper_right_1, upper_right_2,

                        middle_0, middle_1, middle_2,
                        middle_left_0, middle_left_1, middle_left_2,
                        middle_right_0, middle_right_1, middle_right_2
                )
        );
    }

    //creates the block state fill using the different models and returns the final blockstate
    public static BlockModelDefinitionGenerator createShutter(
            Block block,
            MultiVariant lower_0, MultiVariant lower_1, MultiVariant lower_2,
            MultiVariant lower_left_0, MultiVariant lower_left_1, MultiVariant lower_left_2,
            MultiVariant lower_right_0, MultiVariant lower_right_1, MultiVariant lower_right_2,

            MultiVariant normal_0, MultiVariant normal_1, MultiVariant normal_2,
            MultiVariant normal_left_0, MultiVariant normal_left_1, MultiVariant normal_left_2,
            MultiVariant normal_right_0, MultiVariant normal_right_1, MultiVariant normal_right_2,

            MultiVariant upper_0, MultiVariant upper_1, MultiVariant upper_2,
            MultiVariant upper_left_0, MultiVariant upper_left_1, MultiVariant upper_left_2,
            MultiVariant upper_right_0, MultiVariant upper_right_1, MultiVariant upper_right_2,

            MultiVariant middle_0, MultiVariant middle_1, MultiVariant middle_2,
            MultiVariant middle_left_0, MultiVariant middle_left_1, MultiVariant middle_left_2,
            MultiVariant middle_right_0, MultiVariant middle_right_1, MultiVariant middle_right_2
    ) {
        return MultiVariantGenerator.dispatch(block)
                .with(
                        PropertyDispatch.initial(
                                BlockStateProperties.HORIZONTAL_FACING,
                                Shutter.SHUTTER_POS,
                                Shutter.DOUBLE_DOOR,
                                Shutter.OPEN

                        ).generate (
                                (direction, shutterPos, shutterDouble, open) -> {

                                    MultiVariant model = null;
                                    switch (shutterPos) {
                                        case LOWER:
                                            if (open==0 && shutterDouble== ShutterDouble.NONE)  { model = lower_0; break; }
                                            if (open==1 && shutterDouble==ShutterDouble.NONE)  { model = lower_1; break; }
                                            if (open==2 && shutterDouble==ShutterDouble.NONE)  { model = lower_2; break; }

                                            if (open==0 && shutterDouble==ShutterDouble.LEFT)  { model = lower_left_0; break; }
                                            if (open==1 && shutterDouble==ShutterDouble.LEFT)  { model = lower_left_1; break; }
                                            if (open==2 && shutterDouble==ShutterDouble.LEFT)  { model = lower_left_2; break; }

                                            if (open==0 && shutterDouble==ShutterDouble.RIGHT)  { model = lower_right_0; break; }
                                            if (open==1 && shutterDouble==ShutterDouble.RIGHT)  { model = lower_right_1; break; }
                                            if (open==2 && shutterDouble==ShutterDouble.RIGHT)  { model = lower_right_2; break; }
                                        case MIDDLE:
                                            if (open==0 && shutterDouble==ShutterDouble.NONE)  { model = middle_0; break; }
                                            if (open==1 && shutterDouble==ShutterDouble.NONE)  { model = middle_1; break; }
                                            if (open==2 && shutterDouble==ShutterDouble.NONE)  { model = middle_2; break; }

                                            if (open==0 && shutterDouble==ShutterDouble.LEFT)  { model = middle_left_0; break; }
                                            if (open==1 && shutterDouble==ShutterDouble.LEFT)  { model = middle_left_1; break; }
                                            if (open==2 && shutterDouble==ShutterDouble.LEFT)  { model = middle_left_2; break; }

                                            if (open==0 && shutterDouble==ShutterDouble.RIGHT)  { model = middle_right_0; break; }
                                            if (open==1 && shutterDouble==ShutterDouble.RIGHT)  { model = middle_right_1; break; }
                                            if (open==2 && shutterDouble==ShutterDouble.RIGHT)  { model = middle_right_2; break; }
                                        case UPPER:
                                            if (open==0 && shutterDouble==ShutterDouble.NONE)  { model = upper_0; break; }
                                            if (open==1 && shutterDouble==ShutterDouble.NONE)  { model = upper_1; break; }
                                            if (open==2 && shutterDouble==ShutterDouble.NONE)  { model = upper_2; break; }

                                            if (open==0 && shutterDouble==ShutterDouble.LEFT)  { model = upper_left_0; break; }
                                            if (open==1 && shutterDouble==ShutterDouble.LEFT)  { model = upper_left_1; break; }
                                            if (open==2 && shutterDouble==ShutterDouble.LEFT)  { model = upper_left_2; break; }

                                            if (open==0 && shutterDouble==ShutterDouble.RIGHT)  { model = upper_right_0; break; }
                                            if (open==1 && shutterDouble==ShutterDouble.RIGHT)  { model = upper_right_1; break; }
                                            if (open==2 && shutterDouble==ShutterDouble.RIGHT)  { model = upper_right_2; break; }
                                        default:
                                            if (open==0 && shutterDouble==ShutterDouble.NONE)  { model = normal_0; break; }
                                            if (open==1 && shutterDouble==ShutterDouble.NONE)  { model = normal_1; break; }
                                            if (open==2 && shutterDouble==ShutterDouble.NONE)  { model = normal_2; break; }

                                            if (open==0 && shutterDouble==ShutterDouble.LEFT)  { model = normal_left_0; break; }
                                            if (open==1 && shutterDouble==ShutterDouble.LEFT)  { model = normal_left_1; break; }
                                            if (open==2 && shutterDouble==ShutterDouble.LEFT)  { model = normal_left_2; break; }

                                            if (open==0 && shutterDouble==ShutterDouble.RIGHT)  { model = normal_right_0; break; }
                                            if (open==1 && shutterDouble==ShutterDouble.RIGHT)  { model = normal_right_1; break; }
                                            if (open==2 && shutterDouble==ShutterDouble.RIGHT)  { model = normal_right_2; break; }
                                    }

                                    //turns the model using the direction property
                                    switch (direction) {
                                        case Direction.SOUTH: return model.with(Y_ROT_180);
                                        case Direction.EAST: return model.with(Y_ROT_90);
                                        case Direction.WEST: return model.with(Y_ROT_270);
                                        default: return model;
                                    }
                                }
                        )
                );
    }
}