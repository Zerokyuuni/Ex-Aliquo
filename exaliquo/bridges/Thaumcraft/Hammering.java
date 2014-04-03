package exaliquo.bridges.Thaumcraft;

import static exaliquo.data.ModIDs.getIDs;
import static exaliquo.data.BonusHammerTime.*;
import exaliquo.data.Configurations;
import exaliquo.data.ModIDs.Info;
import static exnihilo.registries.HammerRegistry.register;

public class Hammering
{

	protected static void HammerThaumcraft()
	{
		int watershard = (Configurations.alternatewater) ? clay : ice; 
		register(sandstone, 1, getIDs(Info.shard), 0, 0.1F, 0.03F);
		register(netherrack, 0, getIDs(Info.shard), 1, 0.1F, 0.03F);
		register(watershard, 0, getIDs(Info.shard), 2, 0.1F, 0.03F);
		register(grass, 0, getIDs(Info.shard), 3, 0.1F, 0.03F);
		register(obsidian, 0, getIDs(Info.shard), 4, 0.25F, 0.05F);
		register(winthatfight, 0, getIDs(Info.shard), 5, 0.15F, 0.05F);
	}
}
