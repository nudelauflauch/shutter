package net.stehschnitzel.shutter;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;
import net.stehschnitzel.shutter.init.ItemInit;

public class ShutterTab extends CreativeModeTab {
	
	

	public ShutterTab(String label) {
		super(label);
	}

	@Override
	public ItemStack makeIcon() {
		return new ItemStack(ItemInit.OAK_SHUTTER.get());
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
		if (!FMLLoader.isProduction()) {
			registerCreate(items);
			registerEcologics(items);
			registerEndergetic(items);
			registerOuterEnd(items);
			registerQuark(items);
			registerSupplementaries(items);
			registerTwigs(items);
			registerOreganized(items);
			
		}
	}

	private void registerMinecraftShutters(NonNullList<ItemStack> items) {
		items.add(new ItemStack(ItemInit.ACACIA_SHUTTER.get()));
		items.add(new ItemStack(ItemInit.BIRCH_SHUTTER.get()));
		items.add(new ItemStack(ItemInit.CRIMSON_SHUTTER.get()));
		items.add(new ItemStack(ItemInit.DARK_OAK_SHUTTER.get()));
		items.add(new ItemStack(ItemInit.IRON_SHUTTER.get()));
		items.add(new ItemStack(ItemInit.JUNGLE_SHUTTER.get()));
		items.add(new ItemStack(ItemInit.OAK_SHUTTER.get()));
		items.add(new ItemStack(ItemInit.SPRUCE_SHUTTER.get()));
		items.add(new ItemStack(ItemInit.WARPED_SHUTTER.get()));
	}

	private void registerCreate(NonNullList<ItemStack> items) {
		items.add(new ItemStack(ItemInit.GLASS_SHUTTER.get()));
	}

	private void registerEcologics(NonNullList<ItemStack> items) {
		items.add(new ItemStack(ItemInit.AZALEA_SHUTTER.get()));
		items.add(new ItemStack(ItemInit.COCONUT_SHUTTER.get()));
		items.add(new ItemStack(ItemInit.FLOWERING_AZALEA_SHUTTER.get()));
		items.add(new ItemStack(ItemInit.WALNUT_SHUTTER.get()));
	}

	private void registerEndergetic(NonNullList<ItemStack> items) {
		items.add(new ItemStack(ItemInit.POISE_SHUTTER.get()));
	}
	private void registerOuterEnd(NonNullList<ItemStack> items) {
		items.add(new ItemStack(ItemInit.AZURE_SHUTTER.get()));
	}
	private void registerQuark(NonNullList<ItemStack> items) {
		items.add(new ItemStack(ItemInit.BLOSSOM_SHUTTER.get()));
	}
	private void registerSupplementaries(NonNullList<ItemStack> items) {
		items.add(new ItemStack(ItemInit.GOLD_SHUTTER.get()));
		items.add(new ItemStack(ItemInit.NETHERITE_SHUTTER.get()));
	}
	private void registerTwigs(NonNullList<ItemStack> items) {
		items.add(new ItemStack(ItemInit.STRIPPED_BAMBOO_SHUTTER.get()));
	}
	
	private void registerOreganized(NonNullList<ItemStack> items) {
		items.add(new ItemStack(ItemInit.SILVER_SHUTTER.get()));
		items.add(new ItemStack(ItemInit.LEAD_SHUTTER.get()));
	}
}
