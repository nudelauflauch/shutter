package net.stehschnitzel.shutter.block.properties;


import net.minecraft.util.StringIdentifiable;

public enum ShutterPos implements StringIdentifiable {
	UPPER, LOWER, MIDDLE, NORMAL;

	@Override
	public String asString() {
		switch (this) {
			case LOWER : {
				return "lower";
			}
			case UPPER : {
				return "upper";
			}
			case MIDDLE : {
				return "middle";
			}
			default :
				return "normal";
		}
	}
}