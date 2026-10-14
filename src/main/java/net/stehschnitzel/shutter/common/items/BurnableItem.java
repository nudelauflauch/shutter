package net.stehschnitzel.shutter.common.items;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.FuelValues;
import org.jspecify.annotations.Nullable;

public class BurnableItem extends BlockItem {

	private final int burnTime;

	public BurnableItem(Block pBlock, Properties pProperties, int burnTime) {
		super(pBlock, pProperties);
		this.burnTime = burnTime;
	}

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType, FuelValues fuelValues) {
        return burnTime;
    }
}
