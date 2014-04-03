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
	
	public static void initGeneralStuff()
	{
		System.out.println("debug: general stuff");
		registerGeneralCompost();
		registerGeneralSieving();
		registerGeneralHammering();
	}
	
	public static void registerGeneralCompost()
	{
		ArrayList<ItemStack> treeSapling = OreDictionary.getOres("treeSapling");
		ArrayList<ItemStack> treeLeaves = OreDictionary.getOres("treeLeaves");
		
		System.out.println("debug: composting");
		
		for (ItemStack sapling : treeSapling)
		{
			System.out.println("debug: saplinging " + sapling);
			if (sapling.itemID != 6)
			{
				for (int i = 0; i < sapling.getMaxDamage(); i++)
				{
					System.out.println("Sapling: " + sapling);
					CompostRegistry.register(sapling.itemID, i, 0.125F, ColorRegistry.color("oak"));
				}
			}
		}
		for (ItemStack leaves : treeLeaves)
		{
			if (leaves.itemID != 18)
			{
				for (int i = 0; i < leaves.getMaxDamage(); i++)
				{
				CompostRegistry.register(leaves.itemID, i, 0.125F, ColorRegistry.color("oak"));
				}
			}
		}
	}

	public static void registerGeneralSieving()
	{
		SieveRegistry.register(Block.lavaStill.blockID, 0, Item.fishCooked.itemID, 0, 1);
		SieveRegistry.register(Block.waterStill.blockID, 0, Item.fishRaw.itemID, 0, 1);
	}
	
	public static void registerGeneralHammering()
	{
		if (Configurations.ninjaFeesh)
		{
			HammerRegistry.register(Block.silverfish.blockID, 0, 0, 0, 0.0F, 0.0F);
			HammerRegistry.register(Block.silverfish.blockID, 1, 0, 0, 0.0F, 0.0F);
			HammerRegistry.register(Block.silverfish.blockID, 2, 0, 0, 0.0F, 0.0F);
		}
	}	
}
