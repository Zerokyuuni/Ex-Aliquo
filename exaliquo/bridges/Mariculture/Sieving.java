package exaliquo.bridges.Mariculture;

import static exaliquo.data.ModIDs.getIDs;
import static exaliquo.data.BonusSieving.*;
import mariculture.core.lib.Modules;
import exaliquo.data.ModIDs.Info;
import static exnihilo.registries.SieveRegistry.register;

public class Sieving
{

	protected static void SieveMariculture()
	{
		if (Modules.isActive(Modules.worldplus)) register(sand, 0, getIDs(Info.maricoral), 0, 32);
		register(sand, 3, getIDs(Info.mariores), 3, 64);
	}
}
