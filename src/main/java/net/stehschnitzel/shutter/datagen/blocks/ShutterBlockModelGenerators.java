package net.stehschnitzel.shutter.datagen.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.data.*;
import net.minecraft.client.data.ItemModelOutput;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.stehschnitzel.shutter.block.Shutter;
import net.stehschnitzel.shutter.block.properties.ShutterDouble;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ShutterBlockModelGenerators extends BlockStateModelGenerator {

    public ShutterBlockModelGenerators(Consumer<BlockModelDefinitionCreator> blockStateCollector, ItemModelOutput itemModelOutput,
                                    BiConsumer<Identifier, ModelSupplier> modelCollector) {
        super(blockStateCollector, itemModelOutput, modelCollector);
    }

    public static TextureMap shutterMapping(Block block) {
        return shutterMapping(block, block);
    }

    public static TextureMap shutterMapping(Block block, Block particle) {
        return new TextureMap()
                .put(ShutterTemplates.BASE, TextureMap.getId(block))
                .put(TextureKey.PARTICLE, TextureMap.getId(block));
    }

    //for blocks that look like a different block for example waxed shutters dont have their own textures
    public void createShutter(BlockStateModelGenerator blockModels, Block deferredBlock, Block usedTextureBlock, Block particleBlock) {
        //creates the shutter model
        TextureMap texturemapping = shutterMapping(usedTextureBlock, particleBlock);
        createShutter(blockModels, deferredBlock, texturemapping);

        //copies the item model form the #usedTextureBlock as the model for the #deferredBlock
        this.registerItemModel(deferredBlock.asItem(),
                Models.GENERATED.upload(ModelIds.getItemModelId(deferredBlock.asItem()), TextureMap.layer0(usedTextureBlock.asItem()), this.modelCollector));
    }

    //the particle texture is the same as the block texture
    public void createShutter(BlockStateModelGenerator blockModels, Block deferredBlock) {
        createShutter(blockModels, deferredBlock, deferredBlock);
    }

    //uses specific textures for the particle but are all solid
    public void createShutter(BlockStateModelGenerator blockModels, Block deferredBlock, Block particleBlock) {
        //creates the shutter model
        TextureMap texturemapping = shutterMapping(deferredBlock, particleBlock);
        createShutter(blockModels, deferredBlock, texturemapping);

        //registers the item model for the shutter
        this.registerItemModel(deferredBlock.asItem(),
                this.uploadItemModel(deferredBlock.asItem()));
    }

    //creates a shutter model and a blockstate for blocks
    public void createShutter(BlockStateModelGenerator blockModels, Block shutterBlock, TextureMap texturemapping) {

        //all the different models for every state
        WeightedVariant normal_0 = createWeightedVariant(ShutterTemplates.SHUTTER_NORMAL_0
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant normal_1 = createWeightedVariant(ShutterTemplates.SHUTTER_NORMAL_1
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant normal_2 = createWeightedVariant(ShutterTemplates.SHUTTER_NORMAL_2
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant normal_left_0 = createWeightedVariant(ShutterTemplates.SHUTTER_NORMAL_LEFT_0
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant normal_left_1 = createWeightedVariant(ShutterTemplates.SHUTTER_NORMAL_LEFT_1
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant normal_left_2 = createWeightedVariant(ShutterTemplates.SHUTTER_NORMAL_LEFT_2
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant normal_right_0 = createWeightedVariant(ShutterTemplates.SHUTTER_NORMAL_RIGHT_0
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant normal_right_1 = createWeightedVariant(ShutterTemplates.SHUTTER_NORMAL_RIGHT_1
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant normal_right_2 = createWeightedVariant(ShutterTemplates.SHUTTER_NORMAL_RIGHT_2
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant lower_0 = createWeightedVariant(ShutterTemplates.SHUTTER_LOWER_0
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant lower_1 = createWeightedVariant(ShutterTemplates.SHUTTER_LOWER_1
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant lower_2 = createWeightedVariant(ShutterTemplates.SHUTTER_LOWER_2
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant lower_left_0 = createWeightedVariant(ShutterTemplates.SHUTTER_LOWER_LEFT_0
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant lower_left_1 = createWeightedVariant(ShutterTemplates.SHUTTER_LOWER_LEFT_1
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant lower_left_2 = createWeightedVariant(ShutterTemplates.SHUTTER_LOWER_LEFT_2
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant lower_right_0 = createWeightedVariant(ShutterTemplates.SHUTTER_LOWER_RIGHT_0
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant lower_right_1 = createWeightedVariant(ShutterTemplates.SHUTTER_LOWER_RIGHT_1
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant lower_right_2 = createWeightedVariant(ShutterTemplates.SHUTTER_LOWER_RIGHT_2
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant middle_0 = createWeightedVariant(ShutterTemplates.SHUTTER_MIDDLE_0
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant middle_1 = createWeightedVariant(ShutterTemplates.SHUTTER_MIDDLE_1
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant middle_2 = createWeightedVariant(ShutterTemplates.SHUTTER_MIDDLE_2
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant middle_left_0 = createWeightedVariant(ShutterTemplates.SHUTTER_MIDDLE_LEFT_0
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant middle_left_1 = createWeightedVariant(ShutterTemplates.SHUTTER_MIDDLE_LEFT_1
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant middle_left_2 = createWeightedVariant(ShutterTemplates.SHUTTER_MIDDLE_LEFT_2
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant middle_right_0 = createWeightedVariant(ShutterTemplates.SHUTTER_MIDDLE_RIGHT_0
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant middle_right_1 = createWeightedVariant(ShutterTemplates.SHUTTER_MIDDLE_RIGHT_1
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant middle_right_2 = createWeightedVariant(ShutterTemplates.SHUTTER_MIDDLE_RIGHT_2
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant upper_0 = createWeightedVariant(ShutterTemplates.SHUTTER_UPPER_0
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant upper_1 = createWeightedVariant(ShutterTemplates.SHUTTER_UPPER_1
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant upper_2 = createWeightedVariant(ShutterTemplates.SHUTTER_UPPER_2
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant upper_left_0 = createWeightedVariant(ShutterTemplates.SHUTTER_UPPER_LEFT_0
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant upper_left_1 = createWeightedVariant(ShutterTemplates.SHUTTER_UPPER_LEFT_1
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant upper_left_2 = createWeightedVariant(ShutterTemplates.SHUTTER_UPPER_LEFT_2
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant upper_right_0 = createWeightedVariant(ShutterTemplates.SHUTTER_UPPER_RIGHT_0
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant upper_right_1 = createWeightedVariant(ShutterTemplates.SHUTTER_UPPER_RIGHT_1
                .upload(shutterBlock, texturemapping, this.modelCollector));
        WeightedVariant upper_right_2 = createWeightedVariant(ShutterTemplates.SHUTTER_UPPER_RIGHT_2
                .upload(shutterBlock, texturemapping, this.modelCollector));

        //buildes the blockstate file
        blockModels.blockStateCollector.accept(
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
    public static BlockModelDefinitionCreator createShutter(
            Block block,
            WeightedVariant lower_0, WeightedVariant lower_1, WeightedVariant lower_2,
            WeightedVariant lower_left_0, WeightedVariant lower_left_1, WeightedVariant lower_left_2,
            WeightedVariant lower_right_0, WeightedVariant lower_right_1, WeightedVariant lower_right_2,

            WeightedVariant normal_0, WeightedVariant normal_1, WeightedVariant normal_2,
            WeightedVariant normal_left_0, WeightedVariant normal_left_1, WeightedVariant normal_left_2,
            WeightedVariant normal_right_0, WeightedVariant normal_right_1, WeightedVariant normal_right_2,

            WeightedVariant upper_0, WeightedVariant upper_1, WeightedVariant upper_2,
            WeightedVariant upper_left_0, WeightedVariant upper_left_1, WeightedVariant upper_left_2,
            WeightedVariant upper_right_0, WeightedVariant upper_right_1, WeightedVariant upper_right_2,

            WeightedVariant middle_0, WeightedVariant middle_1, WeightedVariant middle_2,
            WeightedVariant middle_left_0, WeightedVariant middle_left_1, WeightedVariant middle_left_2,
            WeightedVariant middle_right_0, WeightedVariant middle_right_1, WeightedVariant middle_right_2
    ) {
        return VariantsBlockModelDefinitionCreator.of(block)
                .with(
                        BlockStateVariantMap.models(
                                    Properties.HORIZONTAL_FACING,
                                    Shutter.POS,
                                    Shutter.DOUBLE_DOOR,
                                    Shutter.OPEN

                                ).generate (
                                        (direction, shutterPos, shutterDouble, open) -> {

                                    WeightedVariant model = null;
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
                                        case Direction.SOUTH: return model.apply(ROTATE_Y_180);
                                        case Direction.EAST: return model.apply(ROTATE_Y_90);
                                        case Direction.WEST: return model.apply(ROTATE_Y_270);
                                        default: return model;
                                    }
                                }
                        )
                );
    }
}
