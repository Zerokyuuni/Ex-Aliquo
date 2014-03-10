package exaliquo;

import java.util.ArrayList;

import exaliquo.data.Configurations;
import exnihilo.registries.ColorRegistry;
import exnihilo.registries.CompostRegistry;
import exnihilo.registries.HammerRegistry;
import exnihilo.registries.SieveRegistry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class GeneralAliquo
{
	private static ArrayList<ItemStack> treeSapling = OreDictionary.getOres("treeSapling");
	private static ArrayList<ItemStack> treeLeaves = OreDictionary.getOres("treeLeaves");
	
	public static void registerGeneralCompost()
	{
		for (ItemStack sapling : treeSapling)
		{
			if (sapling.itemID != 6)
			{
				for (int i = 0; i < 16; i++)
				{
					CompostRegistry.register(sapling.itemID, i, 0.125F, ColorRegistry.color("oak"));
				}
			}
		}
		for (ItemStack leaves : treeLeaves)
		{
			if (leaves.itemID != 18)
			{
				for (int i = 0; i < 16; i++)
				{
				CompostRegistry.register(leaves.itemID, i, 0.125F, ColorRegistry.color("oak"));
				}
			}
		}
	}

	public static void registerSieves()
	{
		SieveRegistry.register(Block.lavaStill.blockID, 0, Item.fishCooked.itemID, 0, 1);
		SieveRegistry.register(Block.waterStill.blockID, 0, Item.fishRaw.itemID, 0, 1);
	}
	
	public static void registerHammering()
	{
		if (Configurations.ninjaFeesh)
		{
			HammerRegistry.register(Block.silverfish.blockID, 0, 0, 0, 0.0F, 0.0F);
			HammerRegistry.register(Block.silverfish.blockID, 1, 0, 0, 0.0F, 0.0F);
			HammerRegistry.register(Block.silverfish.blockID, 2, 0, 0, 0.0F, 0.0F);
		}
	}
}
