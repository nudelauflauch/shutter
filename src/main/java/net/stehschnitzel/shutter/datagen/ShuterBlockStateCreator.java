package net.stehschnitzel.shutter.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.stehschnitzel.shutter.ShutterMain;

public class ShuterBlockStateCreator extends BlockStateProvider {

    public ShuterBlockStateCreator(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
    }

    public ModelBuilder shuttter_0(String name, String shutter, String particle) {
        return shuttter(name, "template_shutter_0", shutter, 0, particle);
    }

    public ModelBuilder shuttter_1(String name, String shutter, String particle) {
        return shuttter(name, "template_shutter_1", shutter, 1, particle);
    }

    public ModelBuilder shuttter_2(String name, String shutter, String particle) {
        return shuttter(name, "template_shutter_2", shutter, 2, particle);
    }



    public ModelBuilder shuttter_0_big(String name, String shutter, String particle) {
        return shuttter_big_left(name, "template_shutter_0_big_left", shutter, 0, particle);
    }

    public ModelBuilder shuttter_1_big(String name, String shutter, String particle) {
        return shuttter_big_left(name, "template_shutter_1_big_left", shutter, 1, particle);
    }


    public ModelBuilder shuttter_2_big(String name, String shutter, String particle) {
        return shuttter_big_left(name, "template_shutter_2_big_left", shutter, 2, particle);
    }



    public ModelBuilder shuttter_0_big_right(String name, String shutter, String particle) {
        return shuttter_big_right(name, "template_shutter_0_big_right", shutter, 0, particle);
    }

    public ModelBuilder shuttter_1_big_right(String name, String shutter, String particle) {
        return shuttter_big_right(name, "template_shutter_1_big_right", shutter, 1, particle);
    }

    public ModelBuilder shuttter_2_big_right(String name, String shutter, String particle) {
        return shuttter_big_right(name, "template_shutter_2_big_right", shutter, 2, particle);
    }

    public ModelBuilder shuttter_big_right(String name, String template, String shutter, int cnt, String particle) {
        ResourceLocation shutter_texture = new ResourceLocation(ShutterMain.MODID, "block/" + name + shutter);

        return models().withExistingParent(name + shutter + "_right_" + cnt, new ResourceLocation(ShutterMain.MODID, "block/" + template))
                .texture("texture", shutter_texture)
                .texture("particle", ResourceLocation.tryParse(particle));
    }

    public ModelBuilder shuttter_big_left(String name, String template, String shutter, int cnt, String particle) {
        ResourceLocation shutter_texture = new ResourceLocation(ShutterMain.MODID, "block/" + name + shutter);

        return models().withExistingParent(name + shutter + "_left_" + cnt, new ResourceLocation(ShutterMain.MODID, "block/" + template))
                .texture("texture", shutter_texture)
                .texture("particle", ResourceLocation.tryParse(particle));
    }


    public ModelBuilder shuttter(String name, String template, String shutter, int cnt, String particle) {
        ResourceLocation shutter_texture = new ResourceLocation(ShutterMain.MODID, "block/" + name + shutter);

        ModelBuilder model =  models().withExistingParent(name + shutter + "_" + cnt, new ResourceLocation(ShutterMain.MODID, "block/" + template))
                .texture("texture", shutter_texture)
                .texture("particle", ResourceLocation.tryParse(particle));

        return model;
    }
}
