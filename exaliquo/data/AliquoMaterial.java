package exaliquo.data;

import static com.google.common.base.CaseFormat.LOWER_CAMEL;
import static com.google.common.base.CaseFormat.UPPER_UNDERSCORE;
import static com.google.common.base.Predicates.notNull;
import static cpw.mods.fml.common.ObfuscationReflectionHelper.getPrivateValue;
import static net.minecraft.item.EnumToolMaterial.GOLD;
import static net.minecraft.item.EnumToolMaterial.IRON;
import static net.minecraft.item.EnumToolMaterial.WOOD;

import java.util.Arrays;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.OreDictionary;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.ObjectArrays;

public enum AliquoMaterial {
	NONE		(WOOD),
	THAUMIUM	(IRON),
	INVAR		(IRON),
	SILVER		(GOLD),
	ALUMINUM	(WOOD, "ALUMINIUM"), // just an example to set multiple names, maybe no need for aluminum
	
	// add default values here
	;
	
	
	private final EnumToolMaterial fallback;
	private final String[] names;
	
	private AliquoMaterial(EnumToolMaterial fallback, String... altNames) {
		this.fallback = fallback;
		names = ObjectArrays.concat(name(), altNames);
	}
	
	public static AliquoMaterial get(String material) {
		try {
			return valueOf(LOWER_CAMEL.to(UPPER_UNDERSCORE, material));
		} catch (IllegalArgumentException unused) {
			return NONE;
		}
	}
	
	public EnumToolMaterial getToolEnumFromRecipe() {
		EnumToolMaterial toolMaterial = null;

		switch (this) {
		case THAUMIUM:
			break;
		default:
			for (InventoryCrafting crafting : pickaxeCraftings())
				try {
					ItemStack item = CraftingManager.getInstance()
							.findMatchingRecipe(crafting, null);
					
					if (item.getItem() instanceof ItemTool)
						toolMaterial = getPrivateValue(
								ItemTool.class,
								(ItemTool) item.getItem(),
								"toolMaterial");
					
					if (toolMaterial != null)
						break;
				} catch (Exception ignored) { }
		}
		
		return toolMaterial;
	}
	
	public EnumToolMaterial getFallbackToolEnum() {
		for (String name : names)
			try {
				return EnumToolMaterial.valueOf(name);
			} catch (IllegalArgumentException ignored) { }
		
		return fallback;
	}
	
	
	
	private final Iterable<InventoryCrafting> pickaxeCraftings() {
		return FluentIterable.from(Arrays.asList(names))
				.transform(PICKAXE_CRAFTING)
				.filter(notNull());
	}
	
	private static final Container DUMMY_CONTAINER = new Container() {
		@Override public boolean canInteractWith(EntityPlayer player) {
			return false;
		}
		@Override public void onCraftMatrixChanged(IInventory inv) { }
	};
	
	private static final Function<String, InventoryCrafting> PICKAXE_CRAFTING =
			new Function<String, InventoryCrafting>() {
		@Override public InventoryCrafting apply(String input) {
			ItemStack ingot = Iterables.getFirst(OreDictionary.getOres(
					UPPER_UNDERSCORE.to(LOWER_CAMEL, "INGOT_" + input)), null);
			if (ingot == null)
				return null;
			
			InventoryCrafting inv = new InventoryCrafting(DUMMY_CONTAINER, 3, 3);
			for (int i : new int[] {0, 3, 6})
				inv.setInventorySlotContents(i, ingot);
			for (int i : new int[] {4, 5})
				inv.setInventorySlotContents(i, new ItemStack(Item.stick));
			return inv;
		}
	};

}
