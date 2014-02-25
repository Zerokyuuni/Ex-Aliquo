package exaliquo;

import exnihilo.registries.HeatRegistry;

import static exaliquo.data.ModIDs.getIDs;
import exaliquo.data.ModIDs.Info;

public class HotStuff
{
	public static void addTinkerFuels()
	{
		HeatRegistry.register(getIDs(Info.storch), 0.1F);
	}
	
	public static void addThaumicFuels()
	{
		HeatRegistry.register(getIDs(Info.ttorch), 1, 0.15F);
		HeatRegistry.register(getIDs(Info.candle), 0.1F);
	}
	
	public static void addArsFuels()
	{
		HeatRegistry.register(getIDs(Info.vtorch), 0.1F);
	}
}
