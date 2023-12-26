package net.stehschnitzel.shutter.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.stehschnitzel.shutter.ShutterMain;
import net.stehschnitzel.shutter.common.blocks.Shutter;
import net.stehschnitzel.shutter.common.blocks.properties.ShutterDouble;
import net.stehschnitzel.shutter.common.blocks.properties.ShutterPos;
import net.stehschnitzel.shutter.init.BlockInit;

public class ModBlockStateProvider extends ShuterBlockStateCreator {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ShutterMain.MODID, exFileHelper);
        registerStatesAndModels();
    }

    @Override
    protected void registerStatesAndModels() {
        shutterBuilder(BlockInit.MAPLE_SHUTTER);
        shutterBuilderWithRenderTyp(BlockInit.GLASS_SHUTTER, "block/glass", "cutout");
        shutterBuilder(BlockInit.AZALEA_SHUTTER);
        shutterBuilder(BlockInit.COCONUT_SHUTTER);
        shutterBuilder(BlockInit.FLOWERING_AZALEA_SHUTTER);
        shutterBuilder(BlockInit.WALNUT_SHUTTER);
        shutterBuilder(BlockInit.POISE_SHUTTER);
        shutterBuilder(BlockInit.CHERRY_SHUTTER,"block/cherry_planks");
        shutterBuilder(BlockInit.WILLOW_SHUTTER);
        shutterBuilder(BlockInit.WISTERIA_SHUTTER);

        shutterBuilder(BlockInit.ACACIA_SHUTTER, "block/acacia_planks");
        shutterBuilder(BlockInit.BAMBOO_SHUTTER, "block/bamboo_planks");

        //vanila
//
//        shutterBuilder(BlockInit.OAK_SHUTTER, "block/oak_planks");
//        shutterBuilder(BlockInit.DARK_OAK_SHUTTER, "block/dark_oak_planks");
//        shutterBuilder(BlockInit.BIRCH_SHUTTER, "block/birch_planks");
//        shutterBuilder(BlockInit.CHERRY_SHUTTER, "block/cherry_planks");
//        shutterBuilder(BlockInit.CRIMSON_SHUTTER, "block/crimson_planks");
//        shutterBuilder(BlockInit.MANGROVE_SHUTTER, "block/mangrove_planks");
//        shutterBuilder(BlockInit.WARPED_SHUTTER, "block/warped_planks");
//
//        shutterBuilder(BlockInit.SPRUCE_SHUTTER, "block/spruce_planks");
//        shutterBuilder(BlockInit.JUNGLE_SHUTTER, "block/jungle_planks");
//        shutterBuilder(BlockInit.IRON_SHUTTER, "block/iron_block");
//        shutterBuilder(BlockInit.GOLD_SHUTTER, "block/gold_block");
//        shutterBuilder(BlockInit.NETHERITE_SHUTTER, "block/netherite_block");
        //
    }

    private void shutterBuilderWithRenderTyp(RegistryObject<Shutter> block, String renderType) {
        shutterBuilderWithRenderTyp(block, new ResourceLocation(ShutterMain.MODID, "block/" + block.getId().getPath() + "_normal").toString(), renderType);
    }

    private void shutterBuilderWithRenderTyp(RegistryObject<Shutter> block, String particle, String renderType) {
        String name = block.getId().getPath();
        ResourceLocation render = ResourceLocation.tryParse(renderType);

        ModelFile n_0 = shuttter_0(name, "_normal", particle).renderType(render);
        ModelFile n_1 = shuttter_1(name, "_normal", particle).renderType(render);
        ModelFile n_2 = shuttter_2(name, "_normal", particle).renderType(render);

        ModelFile nb_0 = shuttter_0_big(name, "_normal_big", particle).renderType(render);
        ModelFile nb_1 = shuttter_1_big(name, "_normal_big", particle).renderType(render);
        ModelFile nb_2 = shuttter_2_big(name, "_normal_big", particle).renderType(render);

        ModelFile nbr_0 = shuttter_0_big_right(name, "_normal_big", particle).renderType(render);
        ModelFile nbr_1 = shuttter_1_big_right(name, "_normal_big", particle).renderType(render);
        ModelFile nbr_2 = shuttter_2_big_right(name, "_normal_big", particle).renderType(render);

        ModelFile l_0 = shuttter_0(name, "_lower", particle).renderType(render);
        ModelFile l_1 = shuttter_1(name, "_lower", particle).renderType(render);
        ModelFile l_2 = shuttter_2(name, "_lower", particle).renderType(render);

        ModelFile lb_0 = shuttter_0_big(name, "_lower_big", particle).renderType(render);
        ModelFile lb_1 = shuttter_1_big(name, "_lower_big", particle).renderType(render);
        ModelFile lb_2 = shuttter_2_big(name, "_lower_big", particle).renderType(render);

        ModelFile lbr_0 = shuttter_0_big_right(name, "_lower_big", particle).renderType(render);
        ModelFile lbr_1 = shuttter_1_big_right(name, "_lower_big", particle).renderType(render);
        ModelFile lbr_2 = shuttter_2_big_right(name, "_lower_big", particle).renderType(render);

        ModelFile m_0 = shuttter_0(name, "_middle", particle).renderType(render);
        ModelFile m_1 = shuttter_1(name, "_middle", particle).renderType(render);
        ModelFile m_2 = shuttter_2(name, "_middle", particle).renderType(render);

        ModelFile mb_0 = shuttter_0_big(name, "_middle_big", particle).renderType(render);
        ModelFile mb_1 = shuttter_1_big(name, "_middle_big", particle).renderType(render);
        ModelFile mb_2 = shuttter_2_big(name, "_middle_big", particle).renderType(render);

        ModelFile mbr_0 = shuttter_0_big_right(name, "_middle_big", particle).renderType(render);
        ModelFile mbr_1 = shuttter_1_big_right(name, "_middle_big", particle).renderType(render);
        ModelFile mbr_2 = shuttter_2_big_right(name, "_middle_big", particle).renderType(render);

        ModelFile u_0 = shuttter_0(name, "_upper", particle).renderType(render);
        ModelFile u_1 = shuttter_1(name, "_upper", particle).renderType(render);
        ModelFile u_2 = shuttter_2(name, "_upper", particle).renderType(render);

        ModelFile ub_0 = shuttter_0_big(name, "_upper_big", particle).renderType(render);
        ModelFile ub_1 = shuttter_1_big(name, "_upper_big", particle).renderType(render);
        ModelFile ub_2 = shuttter_2_big(name, "_upper_big", particle).renderType(render);

        ModelFile ubr_0 = shuttter_0_big_right(name, "_upper_big", particle).renderType(render);
        ModelFile ubr_1 = shuttter_1_big_right(name, "_upper_big", particle).renderType(render);
        ModelFile ubr_2 = shuttter_2_big_right(name, "_upper_big", particle).renderType(render);

        shutter(block,
                l_0, l_1, l_2,
                lb_0, lb_1, lb_2,
                lbr_0, lbr_1, lbr_2,

                m_0, m_1, m_2,
                mb_0, mb_1, mb_2,
                mbr_0, mbr_1, mbr_2,

                u_0, u_1, u_2,
                ub_0, ub_1, ub_2,
                ubr_0, ubr_1, ubr_2,

                n_0, n_1, n_2,
                nb_0, nb_1, nb_2,
                nbr_0, nbr_1, nbr_2
        );
    }

    private void shutterBuilder(RegistryObject<Shutter> block) {
        shutterBuilder(block, new ResourceLocation(ShutterMain.MODID, "block/" + block.getId().getPath() + "_normal").toString());
    }

    private void shutterBuilder(RegistryObject<Shutter> block, String particle) {
        String name = block.getId().getPath();

        ModelFile n_0 = shuttter_0(name, "_normal", particle);
        ModelFile n_1 = shuttter_1(name, "_normal", particle);
        ModelFile n_2 = shuttter_2(name, "_normal", particle);

        ModelFile nb_0 = shuttter_0_big(name, "_normal_big", particle);
        ModelFile nb_1 = shuttter_1_big(name, "_normal_big", particle);
        ModelFile nb_2 = shuttter_2_big(name, "_normal_big", particle);

        ModelFile nbr_0 = shuttter_0_big_right(name, "_normal_big", particle);
        ModelFile nbr_1 = shuttter_1_big_right(name, "_normal_big", particle);
        ModelFile nbr_2 = shuttter_2_big_right(name, "_normal_big", particle);

        ModelFile l_0 = shuttter_0(name, "_lower", particle);
        ModelFile l_1 = shuttter_1(name, "_lower", particle);
        ModelFile l_2 = shuttter_2(name, "_lower", particle);

        ModelFile lb_0 = shuttter_0_big(name, "_lower_big", particle);
        ModelFile lb_1 = shuttter_1_big(name, "_lower_big", particle);
        ModelFile lb_2 = shuttter_2_big(name, "_lower_big", particle);

        ModelFile lbr_0 = shuttter_0_big_right(name, "_lower_big", particle);
        ModelFile lbr_1 = shuttter_1_big_right(name, "_lower_big", particle);
        ModelFile lbr_2 = shuttter_2_big_right(name, "_lower_big", particle);

        ModelFile m_0 = shuttter_0(name, "_middle", particle);
        ModelFile m_1 = shuttter_1(name, "_middle", particle);
        ModelFile m_2 = shuttter_2(name, "_middle", particle);

        ModelFile mb_0 = shuttter_0_big(name, "_middle_big", particle);
        ModelFile mb_1 = shuttter_1_big(name, "_middle_big", particle);
        ModelFile mb_2 = shuttter_2_big(name, "_middle_big", particle);

        ModelFile mbr_0 = shuttter_0_big_right(name, "_middle_big", particle);
        ModelFile mbr_1 = shuttter_1_big_right(name, "_middle_big", particle);
        ModelFile mbr_2 = shuttter_2_big_right(name, "_middle_big", particle);

        ModelFile u_0 = shuttter_0(name, "_upper", particle);
        ModelFile u_1 = shuttter_1(name, "_upper", particle);
        ModelFile u_2 = shuttter_2(name, "_upper", particle);

        ModelFile ub_0 = shuttter_0_big(name, "_upper_big", particle);
        ModelFile ub_1 = shuttter_1_big(name, "_upper_big", particle);
        ModelFile ub_2 = shuttter_2_big(name, "_upper_big", particle);

        ModelFile ubr_0 = shuttter_0_big_right(name, "_upper_big", particle);
        ModelFile ubr_1 = shuttter_1_big_right(name, "_upper_big", particle);
        ModelFile ubr_2 = shuttter_2_big_right(name, "_upper_big", particle);

        shutter(block,
                l_0, l_1, l_2,
                lb_0, lb_1, lb_2,
                lbr_0, lbr_1, lbr_2,

                m_0, m_1, m_2,
                mb_0, mb_1, mb_2,
                mbr_0, mbr_1, mbr_2,

                u_0, u_1, u_2,
                ub_0, ub_1, ub_2,
                ubr_0, ubr_1, ubr_2,

                n_0, n_1, n_2,
                nb_0, nb_1, nb_2,
                nbr_0, nbr_1, nbr_2
        );
    }

    private void shutter(RegistryObject<Shutter> block,
                        ModelFile l_0, ModelFile l_1, ModelFile l_2,
                        ModelFile lb_0, ModelFile lb_1, ModelFile lb_2,
                        ModelFile lbr_0, ModelFile lbr_1, ModelFile lbr_2,

                         ModelFile n_0, ModelFile n_1, ModelFile n_2,
                         ModelFile nb_0, ModelFile nb_1, ModelFile nb_2,
                         ModelFile nbr_0, ModelFile nbr_1, ModelFile nbr_2,

                         ModelFile u_0, ModelFile u_1, ModelFile u_2,
                         ModelFile ub_0, ModelFile ub_1, ModelFile ub_2,
                         ModelFile ubr_0, ModelFile ubr_1, ModelFile ubr_2,

                         ModelFile m_0, ModelFile m_1, ModelFile m_2,
                         ModelFile mb_0, ModelFile mb_1, ModelFile mb_2,
                         ModelFile mbr_0, ModelFile mbr_1, ModelFile mbr_2
    ) {


        getVariantBuilder(block.get()).forAllStatesExcept(state -> {
            int open = state.getValue(Shutter.OPEN);
            ShutterPos pos = state.getValue(Shutter.POS);
            ShutterDouble doubleDoor = state.getValue(Shutter.DOUBLE_DOOR);
            int yRot = ((int) state.getValue(DoorBlock.FACING).toYRot()) + 180;

            if (open == 1 && doubleDoor != ShutterDouble.NONE) {
                yRot += 270;
            }
            yRot %= 360;

            ModelFile model = null;
            switch (pos) {
                case LOWER:
                    if (open==0&&doubleDoor==ShutterDouble.NONE)  { model = l_0; break; }
                    if (open==1&&doubleDoor==ShutterDouble.NONE)  { model = l_1; break; }
                    if (open==2&&doubleDoor==ShutterDouble.NONE)  { model = l_2; break; }

                    if (open==0&&doubleDoor==ShutterDouble.LEFT)  { model = lb_0; break; }
                    if (open==1&&doubleDoor==ShutterDouble.LEFT)  { model = lb_1; break; }
                    if (open==2&&doubleDoor==ShutterDouble.LEFT)  { model = lb_2; break; }

                    if (open==0&&doubleDoor==ShutterDouble.RIGHT)  { model = lbr_0; break; }
                    if (open==1&&doubleDoor==ShutterDouble.RIGHT)  { model = lbr_1; break; }
                    if (open==2&&doubleDoor==ShutterDouble.RIGHT)  { model = lbr_2; break; }
                case MIDDLE:
                    if (open==0&&doubleDoor==ShutterDouble.NONE)  { model = m_0; break; }
                    if (open==1&&doubleDoor==ShutterDouble.NONE)  { model = m_1; break; }
                    if (open==2&&doubleDoor==ShutterDouble.NONE)  { model = m_2; break; }

                    if (open==0&&doubleDoor==ShutterDouble.LEFT)  { model = mb_0; break; }
                    if (open==1&&doubleDoor==ShutterDouble.LEFT)  { model = mb_1; break; }
                    if (open==2&&doubleDoor==ShutterDouble.LEFT)  { model = mb_2; break; }

                    if (open==0&&doubleDoor==ShutterDouble.RIGHT)  { model = mbr_0; break; }
                    if (open==1&&doubleDoor==ShutterDouble.RIGHT)  { model = mbr_1; break; }
                    if (open==2&&doubleDoor==ShutterDouble.RIGHT)  { model = mbr_2; break; }
                case UPPER:
                    if (open==0&&doubleDoor==ShutterDouble.NONE)  { model = u_0; break; }
                    if (open==1&&doubleDoor==ShutterDouble.NONE)  { model = u_1; break; }
                    if (open==2&&doubleDoor==ShutterDouble.NONE)  { model = u_2; break; }

                    if (open==0&&doubleDoor==ShutterDouble.LEFT)  { model = ub_0; break; }
                    if (open==1&&doubleDoor==ShutterDouble.LEFT)  { model = ub_1; break; }
                    if (open==2&&doubleDoor==ShutterDouble.LEFT)  { model = ub_2; break; }

                    if (open==0&&doubleDoor==ShutterDouble.RIGHT)  { model = ubr_0; break; }
                    if (open==1&&doubleDoor==ShutterDouble.RIGHT)  { model = ubr_1; break; }
                    if (open==2&&doubleDoor==ShutterDouble.RIGHT)  { model = ubr_2; break; }
                default:
                    if (open==0&&doubleDoor==ShutterDouble.NONE)  { model = n_0; break; }
                    if (open==1&&doubleDoor==ShutterDouble.NONE)  { model = n_1; break; }
                    if (open==2&&doubleDoor==ShutterDouble.NONE)  { model = n_2; break; }

                    if (open==0&&doubleDoor==ShutterDouble.LEFT)  { model = nb_0; break; }
                    if (open==1&&doubleDoor==ShutterDouble.LEFT)  { model = nb_1; break; }
                    if (open==2&&doubleDoor==ShutterDouble.LEFT)  { model = nb_2; break; }

                    if (open==0&&doubleDoor==ShutterDouble.RIGHT)  { model = nbr_0; break; }
                    if (open==1&&doubleDoor==ShutterDouble.RIGHT)  { model = nbr_1; break; }
                    if (open==2&&doubleDoor==ShutterDouble.RIGHT)  { model = nbr_2; break; }
            }


            return ConfiguredModel.builder().modelFile(model)
                    .rotationY(yRot)
                    .build();
        }, Shutter.POWERED);
    }
}
