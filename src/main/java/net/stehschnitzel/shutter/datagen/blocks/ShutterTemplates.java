package net.stehschnitzel.shutter.datagen.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.data.Model;
import net.minecraft.client.data.ModelIds;
import net.minecraft.client.data.TextureKey;
import net.minecraft.entity.passive.AbstractDonkeyEntity;
import net.minecraft.util.Identifier;

import java.util.Optional;

@Environment(EnvType.CLIENT)
public class ShutterTemplates {

    public static final TextureKey BASE = TextureKey.of("base", TextureKey.ALL);

    public static final Model SHUTTER_NORMAL_0 = create(
            "template_shutter_normal_0", "_normal_0");
    public static final Model SHUTTER_NORMAL_1 = create(
            "template_shutter_normal_1", "_normal_1");
    public static final Model SHUTTER_NORMAL_2 = create(
            "template_shutter_normal_2", "_normal_2");

    public static final Model SHUTTER_NORMAL_LEFT_0 = create(
            "template_shutter_left_normal_0", "_left_normal_0");
    public static final Model SHUTTER_NORMAL_LEFT_1 = create(
            "template_shutter_left_normal_1", "_left_normal_1");
    public static final Model SHUTTER_NORMAL_LEFT_2 = create(
            "template_shutter_left_normal_2", "_left_normal_2");

    public static final Model SHUTTER_NORMAL_RIGHT_0 = create(
            "template_shutter_right_normal_0", "_right_normal_0");
    public static final Model SHUTTER_NORMAL_RIGHT_1 = create(
            "template_shutter_right_normal_1", "_right_normal_1");
    public static final Model SHUTTER_NORMAL_RIGHT_2 = create(
            "template_shutter_right_normal_2", "_right_normal_2");


    public static final Model SHUTTER_LOWER_0 = create(
            "template_shutter_lower_0", "_lower_0");
    public static final Model SHUTTER_LOWER_1 = create(
            "template_shutter_lower_1", "_lower_1");
    public static final Model SHUTTER_LOWER_2 = create(
            "template_shutter_lower_2", "_lower_2");

    public static final Model SHUTTER_LOWER_LEFT_0 = create(
            "template_shutter_left_lower_0", "_left_lower_0");
    public static final Model SHUTTER_LOWER_LEFT_1 = create(
            "template_shutter_left_lower_1", "_left_lower_1");
    public static final Model SHUTTER_LOWER_LEFT_2 = create(
            "template_shutter_left_lower_2", "_left_lower_2");

    public static final Model SHUTTER_LOWER_RIGHT_0 = create(
            "template_shutter_right_lower_0", "_right_lower_0");
    public static final Model SHUTTER_LOWER_RIGHT_1 = create(
            "template_shutter_right_lower_1", "_right_lower_1");
    public static final Model SHUTTER_LOWER_RIGHT_2 = create(
            "template_shutter_right_lower_2", "_right_lower_2");


    public static final Model SHUTTER_MIDDLE_0 = create(
            "template_shutter_middle_0", "_middle_0");
    public static final Model SHUTTER_MIDDLE_1 = create(
            "template_shutter_middle_1", "_middle_1");
    public static final Model SHUTTER_MIDDLE_2 = create(
            "template_shutter_middle_2", "_middle_2");

    public static final Model SHUTTER_MIDDLE_LEFT_0 = create(
            "template_shutter_left_middle_0", "_left_middle_0");
    public static final Model SHUTTER_MIDDLE_LEFT_1 = create(
            "template_shutter_left_middle_1", "_left_middle_1");
    public static final Model SHUTTER_MIDDLE_LEFT_2 = create(
            "template_shutter_left_middle_2", "_left_middle_2");

    public static final Model SHUTTER_MIDDLE_RIGHT_0 = create(
            "template_shutter_right_middle_0", "_right_middle_0");
    public static final Model SHUTTER_MIDDLE_RIGHT_1 = create(
            "template_shutter_right_middle_1", "_right_middle_1");
    public static final Model SHUTTER_MIDDLE_RIGHT_2 = create(
            "template_shutter_right_middle_2", "_right_middle_2");


    public static final Model SHUTTER_UPPER_0 = create(
            "template_shutter_upper_0", "_upper_0");
    public static final Model SHUTTER_UPPER_1 = create(
            "template_shutter_upper_1", "_upper_1");
    public static final Model SHUTTER_UPPER_2 = create(
            "template_shutter_upper_2", "_upper_2");

    public static final Model SHUTTER_UPPER_LEFT_0 = create(
            "template_shutter_left_upper_0", "_left_upper_0");
    public static final Model SHUTTER_UPPER_LEFT_1 = create(
            "template_shutter_left_upper_1", "_left_upper_1");
    public static final Model SHUTTER_UPPER_LEFT_2 = create(
            "template_shutter_left_upper_2", "_left_upper_2");

    public static final Model SHUTTER_UPPER_RIGHT_0 = create(
            "template_shutter_right_upper_0", "_right_upper_0");
    public static final Model SHUTTER_UPPER_RIGHT_1 = create(
            "template_shutter_right_upper_1", "_right_upper_1");
    public static final Model SHUTTER_UPPER_RIGHT_2 = create(
            "template_shutter_right_upper_2", "_right_upper_2");

    public static Model create(String name, String suffix) {
        return new Model(
                Optional.of(Identifier.of("shutter:block/" + name)),
                Optional.of(suffix),
                TextureKey.PARTICLE, BASE
        );
    }

}
