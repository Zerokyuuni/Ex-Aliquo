package exaliquo.bridges.ArsMagica;

import static exaliquo.data.ModIDs.getIDs;
import exaliquo.data.ModIDs.Info;
import static exnihilo.registries.HeatRegistry.register;

public class Heat
{

	protected static void HeatArs()
	{
		register(getIDs(Info.vtorch), 0.1F);
	}
}
