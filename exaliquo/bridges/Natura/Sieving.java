package exaliquo.bridges.Natura;

import static exaliquo.data.ModIDs.getIDs;
import static exaliquo.data.BonusSieving.*;
import exaliquo.data.Configurations;
import exaliquo.data.ModIDs.Info;
import static exnihilo.registries.SieveRegistry.register;

public class Sieving
{
	
	private static final int topiary = getIDs(Info.topiary);

	protected static void SieveNatura()
	{
		for (int i = 0; i < 3; i++)
		{
			if (Configurations.sieveRedwoods)
			{
				register(topiary, i, getIDs(Info.flora), 0, 256);
			}
			if (Configurations.sieveOverworldTrees)
			{
				register(topiary, i, getIDs(Info.flora), 1, 90);
				if (Configurations.sieveHopseed)
				{
					register(topiary, i, getIDs(Info.flora), 2, 90);
				}
				register(topiary, i, getIDs(Info.flora), 3, 64);
				register(topiary, i, getIDs(Info.raresap), 0, 128);
				register(topiary, i, getIDs(Info.raresap), 1, 128);
				register(topiary, i, getIDs(Info.raresap), 2, 128);
				register(topiary, i, getIDs(Info.raresap), 3, 128);
				register(topiary, i, getIDs(Info.raresap), 4, 128);
			}
			if (Configurations.sieveBerryBushes)
			{
				register(topiary, 0, getIDs(Info.good), 0, 64);
				register(topiary, 0, getIDs(Info.good), 1, 64);
				register(topiary, 0, getIDs(Info.good), 2, 64);
				register(topiary, 0, getIDs(Info.good), 3, 64);
			}
		}
		if (Configurations.sieveNetherTrees)
		{
			register(soulsand, 0, getIDs(Info.flora), 4, 128);
			register(soulsand, 0, getIDs(Info.flora), 5, 128);
			register(soulsand, 0, getIDs(Info.flora), 6, 128);
			register(soulsand, 0, getIDs(Info.flora), 7, 128);
			
			for (int i = 0; i < 4; i++)
			{
				register(getIDs(Info.monochrome), 1, getIDs(Info.badberry), i, 16);
				register(getIDs(Info.monochrome), 2, getIDs(Info.badberry), i, 16);
				for (int j = 0; j < 4; j++)
				{
					register(getIDs(Info.darkleaves), j, getIDs(Info.badberry), i, 16);
				}
			}
		}
		if (Configurations.sieveDarkBerries)
		{
			register(soulsand, 0, getIDs(Info.evil), 0, 64);
			register(soulsand, 0, getIDs(Info.evil), 1, 64);
			register(soulsand, 0, getIDs(Info.evil), 2, 64);
			register(soulsand, 0, getIDs(Info.evil), 3, 64);
		}
		register(soulsand, 0, getIDs(Info.glowshroom), 0, 128);
		register(soulsand, 0, getIDs(Info.glowshroom), 1, 128);
		register(soulsand, 0, getIDs(Info.glowshroom), 2, 128);
		register(soulsand, 0, getIDs(Info.thornvines), 0, 48);
		register(sand, 0, getIDs(Info.fruit), 0, 32);
		
		if ((Configurations.sieveRedwoods) || (Configurations.sieveOverworldTrees))
		{
			for (int i = 0; i < 4;i++)
			{
				register(getIDs(Info.monochrome), 0, getIDs(Info.goodberry), i, 16);
				register(getIDs(Info.monochrome), 3, getIDs(Info.goodberry), i, 16);
				for (int j = 0; j < 4; j++)
				{
					register(getIDs(Info.leaves), j, getIDs(Info.goodberry), i, 16);
					register(getIDs(Info.rareleaves), j, getIDs(Info.goodberry), i, 16);
				}
			}
		}
	}
}
