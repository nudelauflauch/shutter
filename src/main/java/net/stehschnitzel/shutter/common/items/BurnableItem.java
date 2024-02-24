package net.stehschnitzel.shutter.common.items;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;

public class BurnableItem extends BlockItem {

	private int burnTime;

	public BurnableItem(Block pBlock, Properties pProperties, int burnTime) {
		super(pBlock, pProperties);
		this.burnTime = burnTime;
	}
	
	@Override
	public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
		return this.burnTime;
	}

}
