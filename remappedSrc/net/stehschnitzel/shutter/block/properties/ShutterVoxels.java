package net.stehschnitzel.shutter.block.properties;


import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class ShutterVoxels {

	public static VoxelShape getShape(Direction facing, int open, ShutterDouble shutterDouble) {
			switch (facing) {
				case EAST :
					switch (shutterDouble) {
						case NONE:
							switch (open) {
								case 0:
									return shutter_e_closed();
								case 1:
									return shutter_e_semi_opened();
								default:
									return shutter_e_fully_opened();
							}
						case LEFT:
							switch (open) {
								case 0:
									return shutter_e_closed();
								case 1:
									return shutter_s_closed();
								default:
									return shutter_e_big_open();
							}
						default:
							switch (open) {
								case 0:
									return shutter_e_closed();
								case 1:
									return shutter_n_closed();
								default:
									return shutter_e_big_rigth_open();
							}
					}
				case SOUTH :
					switch (shutterDouble) {
						case NONE:
							switch (open) {
								case 0:
									return shutter_s_closed();
								case 1:
									return shutter_s_semi_opened();
								default:
									return shutter_s_fully_opened();
							}
						case LEFT:
							switch (open) {
								case 0:
									return shutter_s_closed();
								case 1:
									return shutter_w_closed();
								default:
									return shutter_s_big_open();
							}
						default:
							switch (open) {
								case 0:
									return shutter_s_closed();
								case 1:
									return shutter_e_closed();
								default:
									return shutter_s_big_right_open();
							}
					}
				case WEST :
					switch (shutterDouble) {
						case NONE:
							switch (open) {
								case 0:
									return shutter_w_closed();
								case 1:
									return shutter_w_semi_opened();
								default:
									return shutter_w_fully_opened();
							}
						case LEFT:
							switch (open) {
								case 0:
									return shutter_w_closed();
								case 1:
									return shutter_n_closed();
								default:
									return shutter_w_big_open();
							}
						default:
							switch (open) {
								case 0:
									return shutter_w_closed();
								case 1:
									return shutter_s_closed();
								default:
									return shutter_w_big_right_open();
							}
					}
				default :
					switch (shutterDouble) {
						case NONE:
						switch (open) {
							case 0:
								return shutter_n_closed();
							case 1:
								return shutter_n_semi_opened();
							default:
								return shutter_n_fully_opened();
						}
						case LEFT:
							switch (open) {
								case 0:
									return shutter_n_closed();
								case 1:
									return shutter_e_closed();
								default:
									return shutter_n_big_open();
							}
						default:
							switch (open) {
								case 0:
									return shutter_n_closed();
								case 1:
									return shutter_w_closed();
								default:
									return shutter_n_big_right_open();
							}
					}
			}
	}

	private static VoxelShape shutter_e_closed() {
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.875, 0, 0.5, 1, 1, 1),
				BooleanBiFunction.OR);
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.875, 0, 0, 1, 1, 0.5),
				BooleanBiFunction.OR);

		return shape;
	}

	private static VoxelShape shutter_e_fully_opened() {
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.875, 0, 0.875, 1, 1, 1.375),
				BooleanBiFunction.OR);
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.875, 0, -0.375, 1, 1, 0.125),
				BooleanBiFunction.OR);

		return shape;
	}

	private static VoxelShape shutter_e_semi_opened() {
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.5, 0, 0.875, 1, 1, 1),
				BooleanBiFunction.OR);
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.5, 0, 0, 1, 1, 0.125),
				BooleanBiFunction.OR);

		return shape;
	}

	private static VoxelShape shutter_n_closed() {
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.5, 0, 0, 1, 1, 0.125),
				BooleanBiFunction.OR);
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0, 0, 0, 0.5, 1, 0.125),
				BooleanBiFunction.OR);

		return shape;
	}

	private static VoxelShape shutter_n_fully_opened() {
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.875, 0, 0, 1.375, 1, 0.125),
				BooleanBiFunction.OR);
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(-0.375, 0, 0, 0.125, 1, 0.125),
				BooleanBiFunction.OR);

		return shape;
	}

	private static VoxelShape shutter_n_semi_opened() {
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.875, 0, 0, 1, 1, 0.5),
				BooleanBiFunction.OR);
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0, 0, 0, 0.125, 1, 0.5),
				BooleanBiFunction.OR);

		return shape;
	}

	private static VoxelShape shutter_s_closed() {
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0, 0, 0.875, 0.5, 1, 1),
				BooleanBiFunction.OR);
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.5, 0, 0.875, 1, 1, 1),
				BooleanBiFunction.OR);

		return shape;
	}

	private static VoxelShape shutter_s_fully_opened() {
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(-0.375, 0, 0.875, 0.125, 1, 1),
				BooleanBiFunction.OR);
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.875, 0, 0.875, 1.375, 1, 1),
				BooleanBiFunction.OR);

		return shape;
	}

	private static VoxelShape shutter_s_semi_opened() {
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0, 0, 0.5, 0.125, 1, 1),
				BooleanBiFunction.OR);
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.875, 0, 0.5, 1, 1, 1),
				BooleanBiFunction.OR);

		return shape;
	}

	private static VoxelShape shutter_w_closed() {
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0, 0, 0, 0.125, 1, 0.5),
				BooleanBiFunction.OR);
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0, 0, 0.5, 0.125, 1, 1),
				BooleanBiFunction.OR);

		return shape;
	}

	private static VoxelShape shutter_w_fully_opened() {
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0, 0, -0.375, 0.125, 1, 0.125),
				BooleanBiFunction.OR);
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0, 0, 0.875, 0.125, 1, 1.375),
				BooleanBiFunction.OR);

		return shape;
	}

	private static VoxelShape shutter_w_semi_opened() {
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0, 0, 0, 0.5, 1, 0.125),
				BooleanBiFunction.OR);
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0, 0, 0.875, 0.5, 1, 1),
				BooleanBiFunction.OR);

		return shape;
	}

	private static VoxelShape shutter_n_big_open(){
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.8125, 0, 0, 1.8125, 1, 0.125), BooleanBiFunction.OR);

		return shape;
	}

	private static VoxelShape shutter_n_big_right_open(){
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(-0.8125, 0, 0, 0.1875, 1, 0.125), BooleanBiFunction.OR);

		return shape;
	}

	private static VoxelShape shutter_w_big_open(){
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0, 0, -0.8125, 0.125, 1, 0.1875), BooleanBiFunction.OR);

		return shape;
	}

	private static VoxelShape shutter_w_big_right_open(){
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0, 0, 0.8125, 0.125, 1, 1.8125), BooleanBiFunction.OR);
		return shape;
	}

	private static VoxelShape shutter_s_big_open(){
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(-0.8125, 0, 0.875, 0.1875, 1, 1), BooleanBiFunction.OR);
		return shape;
	}

	private static VoxelShape shutter_s_big_right_open(){
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.8125, 0, 0.875, 1.8125, 1, 1), BooleanBiFunction.OR);
		return shape;
	}

	private static VoxelShape shutter_e_big_open(){
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.875, 0, 0.8125, 1, 1, 1.8125), BooleanBiFunction.OR);
		return shape;
	}

	private static VoxelShape shutter_e_big_rigth_open(){
		VoxelShape shape = VoxelShapes.empty();
		shape = VoxelShapes.combine(shape, VoxelShapes.cuboid(0.875, 0, -0.8125, 1, 1, 0.1875), BooleanBiFunction.OR);
		return shape;
	}
}