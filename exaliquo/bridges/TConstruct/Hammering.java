package exaliquo.bridges.TConstruct;

import exaliquo.Registries;
import static exnihilo.registries.HammerRegistry.registerOre;

public class Hammering
{

	protected static void HammerTConstruct()
	{
		for (int i = 0; i < 2; i++)
		{
			registerOre(Registries.cobaltOreBlock.blockID, i, Registries.cobaltOreItem.itemID, i+1);
			registerOre(Registries.arditeOreBlock.blockID, i, Registries.arditeOreItem.itemID, i+1);
		}
	}
}
