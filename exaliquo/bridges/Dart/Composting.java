package exaliquo.bridges.Dart;

import static exaliquo.data.ModIDs.getIDs;
import exaliquo.data.ModIDs.Info;
import static exnihilo.registries.ColorRegistry.color;
import static exnihilo.registries.CompostRegistry.register;

public class Composting
{

	protected static void CompostDart()
	{
		register(getIDs(Info.dartsapling), 0, 0.125F, color("force"));
		register(getIDs(Info.dartleaves), 0, 0.125F, color("force"));
	}
}
