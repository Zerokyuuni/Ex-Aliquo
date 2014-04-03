package exaliquo.bridges.Thaumcraft;

import static exaliquo.data.ModIDs.getIDs;
import exaliquo.data.ModIDs.Info;
import static exnihilo.registries.HeatRegistry.register;

public class Heat
{

	protected static void HeatThaumcraft()
	{
		register(getIDs(Info.ttorch), 1, 0.15F);
		register(getIDs(Info.candle), 0.1F);
	}
}
