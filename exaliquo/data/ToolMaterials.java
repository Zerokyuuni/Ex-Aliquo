package exaliquo.data;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

public class ToolMaterials
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
}