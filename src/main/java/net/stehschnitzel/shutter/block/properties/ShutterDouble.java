package net.stehschnitzel.shutter.block.properties;

import net.minecraft.util.StringIdentifiable;

public enum ShutterDouble implements StringIdentifiable {

    NONE("none"),
    LEFT("left"),
    RIGHT("right");

    private final String name;
    private ShutterDouble(String name) {
        this.name = name;
    }

    @Override
    public String asString() {
        return this.name;
    }
}