package exaliquo;

import java.util.ArrayList;

import exnihilo.registries.ColorRegistry;
import exnihilo.registries.CompostRegistry;
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
			System.out.println(sapling.getDisplayName());
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
			System.out.println(leaves.getDisplayName());
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
}
