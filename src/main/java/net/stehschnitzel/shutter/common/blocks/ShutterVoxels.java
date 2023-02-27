package net.stehschnitzel.shutter.common.blocks;

import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ShutterVoxels {

	public static VoxelShape shutter_e_closed() {
		VoxelShape shape = Shapes.empty();
		shape = Shapes.join(shape, Shapes.box(0.875, 0, 0.5, 1, 1, 1),
				BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.875, 0, 0, 1, 1, 0.5),
				BooleanOp.OR);

		return shape;
	}
	public static VoxelShape shutter_e_fully_opened() {
		VoxelShape shape = Shapes.empty();
		shape = Shapes.join(shape, Shapes.box(0.875, 0, 0.875, 1, 1, 1.375),
				BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.875, 0, -0.375, 1, 1, 0.125),
				BooleanOp.OR);

		return shape;
	}
	public static VoxelShape shutter_e_semi_opened() {
		VoxelShape shape = Shapes.empty();
		shape = Shapes.join(shape, Shapes.box(0.5, 0, 0.875, 1, 1, 1),
				BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.5, 0, 0, 1, 1, 0.125),
				BooleanOp.OR);

		return shape;
	}
	public static VoxelShape shutter_n_closed() {
		VoxelShape shape = Shapes.empty();
		shape = Shapes.join(shape, Shapes.box(0.5, 0, 0, 1, 1, 0.125),
				BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0, 0, 0, 0.5, 1, 0.125),
				BooleanOp.OR);

		return shape;
	}
	public static VoxelShape shutter_n_fully_opened() {
		VoxelShape shape = Shapes.empty();
		shape = Shapes.join(shape, Shapes.box(0.875, 0, 0, 1.375, 1, 0.125),
				BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(-0.375, 0, 0, 0.125, 1, 0.125),
				BooleanOp.OR);

		return shape;
	}
	public static VoxelShape shutter_n_semi_opened() {
		VoxelShape shape = Shapes.empty();
		shape = Shapes.join(shape, Shapes.box(0.875, 0, 0, 1, 1, 0.5),
				BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0, 0, 0, 0.125, 1, 0.5),
				BooleanOp.OR);

		return shape;
	}
	public static VoxelShape shutter_s_closed() {
		VoxelShape shape = Shapes.empty();
		shape = Shapes.join(shape, Shapes.box(0, 0, 0.875, 0.5, 1, 1),
				BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.5, 0, 0.875, 1, 1, 1),
				BooleanOp.OR);

		return shape;
	}
	public static VoxelShape shutter_s_fully_opened() {
		VoxelShape shape = Shapes.empty();
		shape = Shapes.join(shape, Shapes.box(-0.375, 0, 0.875, 0.125, 1, 1),
				BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.875, 0, 0.875, 1.375, 1, 1),
				BooleanOp.OR);

		return shape;
	}
	public static VoxelShape shutter_s_semi_opened() {
		VoxelShape shape = Shapes.empty();
		shape = Shapes.join(shape, Shapes.box(0, 0, 0.5, 0.125, 1, 1),
				BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0.875, 0, 0.5, 1, 1, 1),
				BooleanOp.OR);

		return shape;
	}
	public static VoxelShape shutter_w_closed() {
		VoxelShape shape = Shapes.empty();
		shape = Shapes.join(shape, Shapes.box(0, 0, 0, 0.125, 1, 0.5),
				BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0, 0, 0.5, 0.125, 1, 1),
				BooleanOp.OR);

		return shape;
	}
	public static VoxelShape shutter_w_fully_opened() {
		VoxelShape shape = Shapes.empty();
		shape = Shapes.join(shape, Shapes.box(0, 0, -0.375, 0.125, 1, 0.125),
				BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0, 0, 0.875, 0.125, 1, 1.375),
				BooleanOp.OR);

		return shape;
	}
	public static VoxelShape shutter_w_semi_opened() {
		VoxelShape shape = Shapes.empty();
		shape = Shapes.join(shape, Shapes.box(0, 0, 0, 0.5, 1, 0.125),
				BooleanOp.OR);
		shape = Shapes.join(shape, Shapes.box(0, 0, 0.875, 0.5, 1, 1),
				BooleanOp.OR);

		return shape;
	}
}