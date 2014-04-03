package exaliquo.bridges.ArsMagica;

import static exaliquo.data.ModIDs.getIDs;
import static exaliquo.data.BonusSieving.*;
import exaliquo.data.ModIDs.Info;
import static exnihilo.registries.SieveRegistry.register;

public class Sieving
{

	protected static void SievingArs()
	{
		register(sand, 0, getIDs(Info.nova), 0, 32);
	}
}
