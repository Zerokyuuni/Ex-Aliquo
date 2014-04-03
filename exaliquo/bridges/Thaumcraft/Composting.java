package exaliquo.bridges.Thaumcraft;

import static exaliquo.data.ModIDs.getIDs;
import exaliquo.data.ModIDs.Info;
import static exnihilo.registries.ColorRegistry.color;
import static exnihilo.registries.CompostRegistry.register;

public class Composting
{

	protected static void CompostThaumcraft()
	{
		register(getIDs(Info.thaumplants), 1, 0.125F, color("silverwood"));
		register(getIDs(Info.thaumplants), 2, 0.1F, color("shimmerleaf"));
		register(getIDs(Info.thaumplants), 3, 0.1F, color("cinderpearl"));
		register(getIDs(Info.thaumplants), 4, 0.1F, color("etherealbloom"));
		register(getIDs(Info.thaumleaves), 0, 0.125F, color("greatwood"));
		register(getIDs(Info.thaumleaves), 1, 0.125F, color("silverwood"));
	}
}
