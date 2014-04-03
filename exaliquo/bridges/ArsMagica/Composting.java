package exaliquo.bridges.ArsMagica;

import static exaliquo.data.ModIDs.getIDs;
import exaliquo.data.ModIDs.Info;
import static exnihilo.registries.ColorRegistry.color;
import static exnihilo.registries.CompostRegistry.register;

public class Composting
{

	protected static void CompostingArs()
	{
		register(getIDs(Info.nova), 0, 0.1F, color("nova"));
		register(getIDs(Info.orchid), 0, 0.1F, color("orchid"));
		register(getIDs(Info.aum), 0, 0.1F, color("white"));
		register(getIDs(Info.witchwood), 0, 0.125F, color("witchwood"));
		register(getIDs(Info.witchleaves), 0, 0.125F, color("witchwood"));
		register(getIDs(Info.wakebloom), 0, 0.125F, color("wakebloom"));
		register(getIDs(Info.tarma), 0, 0.125F, color("tarma"));
	}
}
