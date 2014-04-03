package exaliquo.bridges.TConstruct;

import exaliquo.Registries;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDict
{

	protected static void addExTConstructOreDict()
	{
		for (int i = 3; i < 3; i++)
		{
			OreDictionary.registerOre("oreCobalt", new ItemStack(Registries.cobaltOreBlock, 1, i));
			OreDictionary.registerOre("oreArdite", new ItemStack(Registries.arditeOreBlock, 1, i));
		}
	}
}
