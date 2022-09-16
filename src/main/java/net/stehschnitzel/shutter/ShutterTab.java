package net.stehschnitzel.shutter;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.stehschnitzel.shutter.init.Init;

public class ShutterTab extends CreativeModeTab {

	public ShutterTab(String label) {
		super(label);
	}

	@Override
	public ItemStack makeIcon() {
		return new ItemStack(Init.OAK_SHUTTER.get());
	}

	@Override
	public void fillItemList(NonNullList<ItemStack> items) {
		items.add(new ItemStack(Init.ACACIA_SHUTTER.get()));
		items.add(new ItemStack(Init.BIRCH_SHUTTER.get()));
		items.add(new ItemStack(Init.CRIMSON_SHUTTER.get()));
		items.add(new ItemStack(Init.DARK_OAK_SHUTTER.get()));
		items.add(new ItemStack(Init.IRON_SHUTTER.get()));
		items.add(new ItemStack(Init.JUNGLE_SHUTTER.get()));
		items.add(new ItemStack(Init.OAK_SHUTTER.get()));
		items.add(new ItemStack(Init.SPRUCE_SHUTTER.get()));
		items.add(new ItemStack(Init.WARPED_SHUTTER.get()));
	}

}
