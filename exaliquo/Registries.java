package exaliquo;

import static exaliquo.data.ModIDs.getBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

import exaliquo.data.Configurations;
import exaliquo.data.ToolMaterials;
import static exaliquo.data.ModIDs.getItem;
import exaliquo.data.ModIDs.Info;
import exaliquo.items.InvarHammer;
import exaliquo.items.ReedCrook;
import exaliquo.items.ThaumiumHammer;

public class Registries
{
	private static String[] hammershape = { " i ", " si", "s  " };
	private static String[] crookshape = { "ii ", " i ", " i " };
	public static Item hammerThaum;
	public static Item hammerInvar;
	public static Item crookReed;
	
	public static void registerItems() {
		hammerThaum = new ThaumiumHammer(Configurations.thaumHammer, ToolMaterials.getMaterial("THAUMIUM")).setUnlocalizedName("ExAliquo.ThaumHammer");
		GameRegistry.registerItem(hammerThaum, "ExAliquo.ThaumHammer");
		hammerInvar = new InvarHammer(Configurations.invarHammer, ToolMaterials.getMaterial("INVAR")).setUnlocalizedName("ExAliquo.InvarHammer");
		GameRegistry.registerItem(hammerInvar,"ExAliquo.InvarHammer");
		crookReed = new ReedCrook(Configurations.reedCrook).setUnlocalizedName("ExAliquo.ReedCrook");
		GameRegistry.registerItem(crookReed, "ExAliquo.ReedCrook");
	}

	public static void registerRecipes()
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(hammerInvar), new Object[] { hammershape, 's', "stickWood", 'i', "ingotInvar" }));
		GameRegistry.addShapedRecipe(new ItemStack(crookReed), new Object[] { crookshape, 'i', Item.reed });
	}

	public static void registerOreDict()
	{
		for (int i = 0; i < 3; i++)
		{
			OreDictionary.registerOre("oreIron", new ItemStack(getBlock(Info.ironore), 1, i));
			OreDictionary.registerOre("oreGold", new ItemStack(getBlock(Info.goldore), 1, i));
			OreDictionary.registerOre("oreCopper", new ItemStack(getBlock(Info.copperore), 1, i));
			OreDictionary.registerOre("oreTin", new ItemStack(getBlock(Info.tinore), 1, i));
			OreDictionary.registerOre("oreSilver", new ItemStack(getBlock(Info.silverore), 1, i));
			OreDictionary.registerOre("oreLead", new ItemStack(getBlock(Info.leadore), 1, i));
			OreDictionary.registerOre("oreNickel", new ItemStack(getBlock(Info.nickelore), 1, i));
			OreDictionary.registerOre("orePlatinum", new ItemStack(getBlock(Info.platinumore), 1, i));
			OreDictionary.registerOre("oreAluminum", new ItemStack(getBlock(Info.aluminumore), 1, i));
		}
	}

	public static void addNaturaCrafting()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(getBlock(Info.nethersoil), 1, 0), Block.dirt, getItem(Info.witchbucket));
		GameRegistry.addShapelessRecipe(new ItemStack(getBlock(Info.nethersand), 1, 0), Block.sand, getBlock(Info.thornvines), Item.blazePowder);
	}
}
