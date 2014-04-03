package exaliquo.bridges.Mariculture;

import static exaliquo.data.ModIDs.getIDs;
import static exaliquo.data.BonusSieving.*;
import mariculture.world.WorldPlus;
import exaliquo.data.ModIDs.Info;
import static exnihilo.registries.SieveRegistry.register;

public class Sieving
{

	protected static void SieveMariculture()
	{
		register(sand, 0, getIDs(Info.mariores), 3, 12);
		if (WorldPlus.isActive) register(sand, 0, getIDs(Info.maricoral), 0, 64);
		register(getIDs(Info.mariores), 3, getIDs(Info.mariores), 2, 128);
	}
}
