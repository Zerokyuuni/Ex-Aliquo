package exaliquo.data;

import java.util.ArrayList;

import exaliquo.exaliquo;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

public class OreDict
{
	public static boolean isOreDict(ItemStack itemstack, String name)
	{
		if (OreDictionary.getOreName(OreDictionary.getOreID(itemstack)).equals(name))
		{
			return true;
		}
		else
		{
			return ((OreDictionary.getOres(name).isEmpty()) && (itemstack.itemID == Item.ingotIron.itemID)) ? true : false;
		}
	}

	public static EnumToolMaterial getMaterial(String string)
	{
		try
		{
			return EnumToolMaterial.valueOf(string);
		}
		catch (IllegalArgumentException e)
		{
			return EnumToolMaterial.IRON;
		}
	}

	public static ItemStack getFirstOre(String string)
	{
		return getFirstOre(string, true);
	}
	
	public static ItemStack getFirstOre(String string, boolean warning)
	{
		ArrayList<ItemStack> ores = OreDictionary.getOres(string);
		if (!ores.isEmpty())
		{
			return ores.get(0);
		}
		if (warning) exaliquo.logger.warning("ExAliquo could not find the oreDict item called by " + string);
		return new ItemStack(Block.redstoneWire, 1, 0);
	}

	public static Block getBlock(ItemStack itemStack)
	{
		return Block.blocksList[itemStack.itemID];
	}
}