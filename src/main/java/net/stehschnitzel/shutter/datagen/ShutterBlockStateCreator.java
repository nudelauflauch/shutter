package net.stehschnitzel.shutter.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.stehschnitzel.shutter.ShutterMain;

public class ShutterBlockStateCreator extends BlockStateProvider {

    public ShutterBlockStateCreator(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
    }

    @Override
    public void registerStatesAndModels() {
    }

    public ModelBuilder shutter_0(String name, String shutter, String particle) {
        return shutter(name, "template_shutter_0", shutter, 0, particle);
    }

    public ModelBuilder shutter_1(String name, String shutter, String particle) {
        return shutter(name, "template_shutter_1", shutter, 1, particle);
    }

    public ModelBuilder shutter_2(String name, String shutter, String particle) {
        return shutter(name, "template_shutter_2", shutter, 2, particle);
    }



    public ModelBuilder shutter_0_big(String name, String shutter, String particle) {
        return shutter_big_left(name, "template_shutter_0_big_left", shutter, 0, particle);
    }

    public ModelBuilder shutter_1_big(String name, String shutter, String particle) {
        return shutter_big_left(name, "template_shutter_1_big_left", shutter, 1, particle);
    }


    public ModelBuilder shutter_2_big(String name, String shutter, String particle) {
        return shutter_big_left(name, "template_shutter_2_big_left", shutter, 2, particle);
    }



    public ModelBuilder shutter_0_big_right(String name, String shutter, String particle) {
        return shutter_big_right(name, "template_shutter_0_big_right", shutter, 0, particle);
    }

    public ModelBuilder shutter_1_big_right(String name, String shutter, String particle) {
        return shutter_big_right(name, "template_shutter_1_big_right", shutter, 1, particle);
    }

    public ModelBuilder shutter_2_big_right(String name, String shutter, String particle) {
        return shutter_big_right(name, "template_shutter_2_big_right", shutter, 2, particle);
    }

    public ModelBuilder shutter_big_right(String name, String template, String shutter, int cnt, String particle) {
        ResourceLocation shutter_texture = ResourceLocation.fromNamespaceAndPath(ShutterMain.MODID, "block/" + name + shutter);

        return models().withExistingParent(name + shutter + "_right_" + cnt, ResourceLocation.fromNamespaceAndPath(ShutterMain.MODID, "block/" + template))
                .texture("texture", shutter_texture)
                .texture("particle", ResourceLocation.tryParse(particle));
    }

    public ModelBuilder shutter_big_left(String name, String template, String shutter, int cnt, String particle) {
        ResourceLocation shutter_texture = ResourceLocation.fromNamespaceAndPath(ShutterMain.MODID, "block/" + name + shutter);

        return models().withExistingParent(name + shutter + "_left_" + cnt, ResourceLocation.fromNamespaceAndPath(ShutterMain.MODID, "block/" + template))
                .texture("texture", shutter_texture)
                .texture("particle", ResourceLocation.tryParse(particle));
    }


    public ModelBuilder shutter(String name, String template, String shutter, int cnt, String particle) {
        ResourceLocation shutter_texture = ResourceLocation.fromNamespaceAndPath(ShutterMain.MODID, "block/" + name + shutter);

        ModelBuilder model =  models().withExistingParent(name + shutter + "_" + cnt, ResourceLocation.fromNamespaceAndPath(ShutterMain.MODID, "block/" + template))
                .texture("texture", shutter_texture)
                .texture("particle", ResourceLocation.tryParse(particle));

        return model;
    }
}
