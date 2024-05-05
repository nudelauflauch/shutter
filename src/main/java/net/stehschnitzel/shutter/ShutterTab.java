package net.stehschnitzel.shutter;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;
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
		registerMinecraftShutters(items);
		if(ModList.get().isLoaded("create")) {
			registerCreate(items);
		} 
		if(ModList.get().isLoaded("ecologics")) {
			registerEcologics(items);
		} 
		if(ModList.get().isLoaded("endergetic")) {
			registerEndergetic(items);
		} 
		if(ModList.get().isLoaded("outer_end")) {
			registerOuterEnd(items);
		} 
		if(ModList.get().isLoaded("quark")) {
			registerQuark(items);
		} 
		if(ModList.get().isLoaded("supplementaries")) {
			registerSupplementaries(items);
		} 
		if(ModList.get().isLoaded("twigs")) {
			registerTwigs(items);
		} 
		if(ModList.get().isLoaded("oreganized")) {
			registerOreganized(items);
		} 
	}

	private void registerMinecraftShutters(NonNullList<ItemStack> items) {
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

	private void registerCreate(NonNullList<ItemStack> items) {
		items.add(new ItemStack(Init.GLASS_SHUTTER.get()));
	}

	private void registerEcologics(NonNullList<ItemStack> items) {
		items.add(new ItemStack(Init.AZALEA_SHUTTER.get()));
		items.add(new ItemStack(Init.COCONUT_SHUTTER.get()));
		items.add(new ItemStack(Init.FLOWERING_AZALEA_SHUTTER.get()));
		items.add(new ItemStack(Init.WALNUT_SHUTTER.get()));
	}

	private void registerEndergetic(NonNullList<ItemStack> items) {
		items.add(new ItemStack(Init.POISE_SHUTTER.get()));
	}
	private void registerOuterEnd(NonNullList<ItemStack> items) {
		items.add(new ItemStack(Init.AZUER_SHUTTER.get()));
	}
	private void registerQuark(NonNullList<ItemStack> items) {
		items.add(new ItemStack(Init.BLOSSOM_SHUTTER.get()));
	}
	private void registerSupplementaries(NonNullList<ItemStack> items) {
		items.add(new ItemStack(Init.GOLD_SHUTTER.get()));
		items.add(new ItemStack(Init.NETHERITE_SHUTTER.get()));
	}
	private void registerTwigs(NonNullList<ItemStack> items) {
		items.add(new ItemStack(Init.STRIPPED_BAMBOO_SHUTTER.get()));
	}
	
	private void registerOreganized(NonNullList<ItemStack> items) {
		items.add(new ItemStack(Init.SILVER_SHUTTER.get()));
		items.add(new ItemStack(Init.LEAD_SHUTTER.get()));
	}
}
