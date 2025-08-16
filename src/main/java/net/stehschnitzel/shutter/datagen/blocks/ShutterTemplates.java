package net.stehschnitzel.shutter.datagen.blocks;

import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;

import java.util.Optional;

@OnlyIn(Dist.CLIENT)
public class ShutterTemplates {

    public static final TextureSlot BASE = TextureSlot.create("base", TextureSlot.ALL);

    public static final ModelTemplate SHUTTER_NORMAL_0 = create(
            "template_shutter_0", "_normal_0");
    public static final ModelTemplate SHUTTER_NORMAL_1 = create(
            "template_shutter_1", "_normal_1");
    public static final ModelTemplate SHUTTER_NORMAL_2 = create(
            "template_shutter_2", "_normal_2");

    public static final ModelTemplate SHUTTER_NORMAL_LEFT_0 = create(
            "template_shutter_left_0", "_normal_left_0");
    public static final ModelTemplate SHUTTER_NORMAL_LEFT_1 = create(
            "template_shutter_left_1", "_normal_left_1");
    public static final ModelTemplate SHUTTER_NORMAL_LEFT_2 = create(
            "template_shutter_left_2", "_normal_left_2");

    public static final ModelTemplate SHUTTER_NORMAL_RIGHT_0 = create(
            "template_shutter_right_0", "_normal_right_0");
    public static final ModelTemplate SHUTTER_NORMAL_RIGHT_1 = create(
            "template_shutter_right_1", "_normal_right_1");
    public static final ModelTemplate SHUTTER_NORMAL_RIGHT_2 = create(
            "template_shutter_right_2", "_normal_right_2");


    public static final ModelTemplate SHUTTER_LOWER_0 = create(
            "template_shutter_0", "_lower_0");
    public static final ModelTemplate SHUTTER_LOWER_1 = create(
            "template_shutter_1", "_lower_1");
    public static final ModelTemplate SHUTTER_LOWER_2 = create(
            "template_shutter_2", "_lower_2");

    public static final ModelTemplate SHUTTER_LOWER_LEFT_0 = create(
            "template_shutter_left_0", "_lower_left_0");
    public static final ModelTemplate SHUTTER_LOWER_LEFT_1 = create(
            "template_shutter_left_1", "_lower_left_1");
    public static final ModelTemplate SHUTTER_LOWER_LEFT_2 = create(
            "template_shutter_left_2", "_lower_left_2");

    public static final ModelTemplate SHUTTER_LOWER_RIGHT_0 = create(
            "template_shutter_right_0", "_lower_right_0");
    public static final ModelTemplate SHUTTER_LOWER_RIGHT_1 = create(
            "template_shutter_right_1", "_lower_right_1");
    public static final ModelTemplate SHUTTER_LOWER_RIGHT_2 = create(
            "template_shutter_right_2", "_lower_right_2");


    public static final ModelTemplate SHUTTER_MIDDLE_0 = create(
            "template_shutter_0", "_middle_0");
    public static final ModelTemplate SHUTTER_MIDDLE_1 = create(
            "template_shutter_1", "_middle_1");
    public static final ModelTemplate SHUTTER_MIDDLE_2 = create(
            "template_shutter_2", "_middle_2");

    public static final ModelTemplate SHUTTER_MIDDLE_LEFT_0 = create(
            "template_shutter_left_0", "_middle_left_0");
    public static final ModelTemplate SHUTTER_MIDDLE_LEFT_1 = create(
            "template_shutter_left_1", "_middle_left_1");
    public static final ModelTemplate SHUTTER_MIDDLE_LEFT_2 = create(
            "template_shutter_left_2", "_middle_left_2");

    public static final ModelTemplate SHUTTER_MIDDLE_RIGHT_0 = create(
            "template_shutter_right_0", "_middle_right_0");
    public static final ModelTemplate SHUTTER_MIDDLE_RIGHT_1 = create(
            "template_shutter_right_1", "_middle_right_1");
    public static final ModelTemplate SHUTTER_MIDDLE_RIGHT_2 = create(
            "template_shutter_right_2", "_middle_right_2");


    public static final ModelTemplate SHUTTER_UPPER_0 = create(
            "template_shutter_0", "_upper_0");
    public static final ModelTemplate SHUTTER_UPPER_1 = create(
            "template_shutter_1", "_upper_1");
    public static final ModelTemplate SHUTTER_UPPER_2 = create(
            "template_shutter_2", "_upper_2");

    public static final ModelTemplate SHUTTER_UPPER_LEFT_0 = create(
            "template_shutter_left_0", "_upper_left_0");
    public static final ModelTemplate SHUTTER_UPPER_LEFT_1 = create(
            "template_shutter_left_1", "_upper_left_1");
    public static final ModelTemplate SHUTTER_UPPER_LEFT_2 = create(
            "template_shutter_left_2", "_upper_left_2");

    public static final ModelTemplate SHUTTER_UPPER_RIGHT_0 = create(
            "template_shutter_right_0", "_upper_right_0");
    public static final ModelTemplate SHUTTER_UPPER_RIGHT_1 = create(
            "template_shutter_right_1", "_upper_right_1");
    public static final ModelTemplate SHUTTER_UPPER_RIGHT_2 = create(
            "template_shutter_right_2", "_upper_right_2");

    public static ModelTemplate create(String name, String suffix) {
        ExtendedModelTemplateBuilder.builder().renderType("").build();
        return new ModelTemplate(
                Optional.of(ModelLocationUtils.decorateBlockModelLocation("shutter:" + name)),
                Optional.of(suffix),
                TextureSlot.PARTICLE, BASE
        );
    }

}
