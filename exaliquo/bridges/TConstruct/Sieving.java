package exaliquo.bridges.TConstruct;

import static exaliquo.data.ModIDs.getIDs;
import static exaliquo.data.BonusSieving.*;
import exaliquo.Registries;
import exaliquo.data.Configurations;
import exaliquo.data.ModIDs.Info;
import exnihilo.registries.SieveRegistry;

public class Sieving
{

	private static int soil = getIDs(Info.craftedsoil);
	
	protected static void SieveTConstruct()
	{
		if (Configurations.sieveOreBushes)
		{
			SieveRegistry.register(stone, 0, getIDs(Info.oreberrybush), 0, 256);	//Iron
			SieveRegistry.register(stone, 0, getIDs(Info.oreberrybush), 1, 256);	//Gold
			SieveRegistry.register(stone, 0, getIDs(Info.oreberrybush), 2, 256);	//Copper
			SieveRegistry.register(stone, 0, getIDs(Info.oreberrybush), 3, 256);	//Tin
			SieveRegistry.register(stone, 0, getIDs(Info.oreberrybush2), 0, 256);	//Aluminum
		}
		if (Configurations.sieveEssenceBushes)
		{
			SieveRegistry.register(stone, 0, getIDs(Info.oreberrybush2), 1, 128);
		}
		SieveRegistry.register(soil, 0, getIDs(Info.tinkerfood), 0, 4);
		SieveRegistry.register(soil, 0, getIDs(Info.materials), 1, 3);
		SieveRegistry.register(soil, 0, getIDs(Info.materials), 17, 10);
	}
}
