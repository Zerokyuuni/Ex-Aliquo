package exaliquo.bridges.Natura;

import static exaliquo.data.ModIDs.getIDs;
import exaliquo.data.ModIDs.Info;
import static exnihilo.registries.HeatRegistry.register;

public class Heat
{
	
	protected static void HeatNatura()
	{
		register(getIDs(Info.nethersand), 0.25F);
	}
}