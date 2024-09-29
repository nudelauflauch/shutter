package net.stehschnitzel.shutter.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.stehschnitzel.shutter.ShutterMain;

public class BlockEntityInit {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ShutterMain.MODID);

//    public static final RegistryObject<BlockEntityType<NetheriteShutterBlockEntity>> GEM_EMPOWERING_STATION_BE =
//            BLOCK_ENTITIES.register("gem_empowering_station_block_entity", () ->
//                    BlockEntityType.Builder.of(NetheriteShutterBlockEntity::new,
//                            BlockInit.NETHERITE_SHUTTER.get()).build(null));

}
