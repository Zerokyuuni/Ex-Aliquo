package exaliquo.bridges.MineFactoryReloaded;

import static exaliquo.data.ModIDs.getIDs;
import exaliquo.data.ModIDs.Info;
import static exnihilo.registries.ColorRegistry.color;
import static exnihilo.registries.CompostRegistry.register;

public class Composting
{

	protected static void CompostMFR()
	{
		register(getIDs(Info.rubberleaves), 0, 0.125F, color("rubberwood"));
		register(getIDs(Info.rubbersapling), 0, 0.125F, color("rubberwood"));
		register(getIDs(Info.rubbersapling), 1, 0.125F, color("rubberwood"));
	}
}
