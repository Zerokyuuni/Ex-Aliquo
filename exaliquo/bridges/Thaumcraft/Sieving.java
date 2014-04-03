package exaliquo.bridges.Thaumcraft;

import static exaliquo.data.ModIDs.getIDs;
import static exaliquo.data.BonusSieving.*;
import exaliquo.data.ModIDs.Info;
import static exnihilo.registries.SieveRegistry.register;

public class Sieving
{

	protected static void SieveThaumcraft()
	{
		register(gravel, 0, getIDs(Info.nuggets), 5, 8);
		register(gravel, 0, getIDs(Info.resources), 6, 8);
		register(dirt, 0, getIDs(Info.manabean), 0, 64);
	}
}
