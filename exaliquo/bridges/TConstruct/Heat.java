package exaliquo.bridges.TConstruct;

import static exaliquo.data.ModIDs.getIDs;
import exaliquo.data.ModIDs.Info;
import static exnihilo.registries.HeatRegistry.register;

public class Heat
{

	protected static void HeatTConstruct()
	{
		register(getIDs(Info.storch), 0.1F);
	}
}
