package net.stehschnitzel.shutter.common.blocks;

import net.minecraft.util.StringRepresentable;

public enum ShutterPos implements StringRepresentable {
	UPPER, LOWER, MIDDLE, NORMAL;

	@Override
	public String getSerializedName() {
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