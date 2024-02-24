package net.stehschnitzel.shutter.common.blocks.properties;

import net.minecraft.util.StringRepresentable;

public enum ShutterDouble implements StringRepresentable {

    NONE("none"),
    LEFT("left"),
    RIGHT("right");

    private final String name;
    private ShutterDouble(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}