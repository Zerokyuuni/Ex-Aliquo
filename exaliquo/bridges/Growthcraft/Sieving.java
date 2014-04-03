package exaliquo.bridges.Growthcraft;

import static exaliquo.data.ModIDs.getIDs;
import net.minecraft.block.Block;
import exaliquo.data.ModIDs.Info;
import exnihilo.registries.SieveRegistry;
import static exnihilo.registries.SieveRegistry.register;

public class Sieving
{

	protected static void SieveGrowth()
	{
		if (Growthcraft.isGCBamboo) 
		{
			register(Block.leaves.blockID, 3, getIDs(Info.gcbamboo), 0, 64);
		}
		if (Growthcraft.isGCBees)
		{
			register(getIDs(Info.silkleaves), 0, getIDs(Info.gcbee), 0, 16);
			register(getIDs(Info.silkleaves), 1, getIDs(Info.gcbee), 0, 16);
			register(getIDs(Info.silkleaves), 2, getIDs(Info.gcbee), 0, 16);
			register(getIDs(Info.silkleaves), 3, getIDs(Info.gcbee), 0, 16);
		}
	}
}
