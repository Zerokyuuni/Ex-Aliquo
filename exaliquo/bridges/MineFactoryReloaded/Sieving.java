package exaliquo.bridges.MineFactoryReloaded;

import static exaliquo.data.ModIDs.getIDs;
import static exaliquo.data.BonusSieving.*;
import exaliquo.data.ModIDs.Info;
import static exnihilo.registries.SieveRegistry.register;

public class Sieving
{

	protected static void SieveMFR()
	{
		register(dirt, 0, getIDs(Info.rubbersapling), 1, 8192);
	}
}
