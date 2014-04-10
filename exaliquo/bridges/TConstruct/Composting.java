package exaliquo.bridges.TConstruct;

import static exaliquo.data.ModIDs.getIDs;
import exaliquo.data.Configurations;
import exaliquo.data.ModIDs.Info;
import static exnihilo.registries.ColorRegistry.color;
import static exnihilo.registries.CompostRegistry.register;

public class Composting
{

	protected static void CompostTConstruct()
	{
		if (Configurations.allowTinkerBushCompost)
		{
			register(getIDs(Info.oreberry), 0, 1.0F, color("ironberry"));
			register(getIDs(Info.oreberry), 1, 1.0F, color("goldberry"));
			register(getIDs(Info.oreberry), 2, 1.0F, color("copperberry"));
			register(getIDs(Info.oreberry), 3, 1.0F, color("tinberry"));
			register(getIDs(Info.oreberrybush2), 0, 1.0F, color("aluminumberry"));
			register(getIDs(Info.oreberrybush2), 1, 1.0F, color("essenceberry"));
		}
		register(getIDs(Info.oreberry), 5, 0.1F, color("essenceberry"));
		register(getIDs(Info.hambone), 0, 1.0F, color("pork_raw"));
		register(getIDs(Info.slimeleaves), 0, 0.125F, color("slime"));
		register(getIDs(Info.slimesapling), 0, 0.125F, color("slime"));
	}
}
