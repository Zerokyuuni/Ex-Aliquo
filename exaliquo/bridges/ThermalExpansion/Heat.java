package exaliquo.bridges.ThermalExpansion;

import static exaliquo.data.ModIDs.getIDs;
import exaliquo.data.ModIDs.Info;
import static exnihilo.registries.HeatRegistry.register;


public class Heat
{
	public static void HeatThermalExpansion()
	{
		register(getIDs(Info.liquidpyro), 0.5F);
		register(getIDs(Info.liquidpyro), 0, 0.7F);
		register(getIDs(Info.liquidcold), 0.2F);
		register(getIDs(Info.liquidcold), 0, 0.3F);
	}
}
