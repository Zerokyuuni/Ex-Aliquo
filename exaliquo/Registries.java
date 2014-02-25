package exaliquo;

import net.minecraft.item.Item;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

import exaliquo.data.Configurations;
import exaliquo.data.ToolMaterials;
import exaliquo.items.InvarHammer;
import exaliquo.items.ThaumiumHammer;

public class Registries
{
	private static String[] hammershape = { " i ", " si", "s  " };
	public static Item hammerThaum;
	public static Item hammerInvar;
	
	public static void registerItems() {
		hammerThaum = new ThaumiumHammer(Configurations.thaumHammer, ToolMaterials.getMaterial("THAUMIUM")).setUnlocalizedName("ExAliquo.ThaumHammer");
		GameRegistry.registerItem(hammerThaum, "ExAliquo.ThaumHammer");
		hammerInvar = new InvarHammer(Configurations.invarHammer, ToolMaterials.getMaterial("INVAR")).setUnlocalizedName("ExAliquo.InvarHammer");
		GameRegistry.registerItem(hammerInvar,"ExAliquo.InvarHammer");
	}

	public static void registerRecipes()
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(hammerInvar), new Object[] { hammershape, 's', "stickWood", 'i', "ingotInvar" }));
	}
}
