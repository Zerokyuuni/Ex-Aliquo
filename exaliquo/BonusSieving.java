package exaliquo;

import net.minecraft.block.Block;

import static cpw.mods.fml.common.registry.GameRegistry.findItem;
import static cpw.mods.fml.common.registry.GameRegistry.findBlock;

import static exaliquo.ModIDs.getIDs;
import exaliquo.ModIDs.Info;
import exnihilo.registries.SieveRegistry;

public class BonusSieving
{
	static int dirt = Block.dirt.blockID;
	static int gravel = Block.gravel.blockID;
	static int sand = Block.sand.blockID;
	static int soulsand = Block.slowSand.blockID;
	
	public static void addTinkerToSieves()
	{
		//SieveRegistry.SieveRegistry.register(gravel, 0, Block.tnt.blockID, 0, 1); //WYNAUT
		if (Configurations.sieveOreBushes)
		{
			SieveRegistry.register(dirt, 0, getIDs(Info.oreberrybush), 8, 256);		//Iron
			SieveRegistry.register(dirt, 0, getIDs(Info.oreberrybush), 9, 256);		//Gold
			SieveRegistry.register(dirt, 0, getIDs(Info.oreberrybush), 10, 256);	//Copper
			SieveRegistry.register(dirt, 0, getIDs(Info.oreberrybush), 11, 256);	//Tin
			SieveRegistry.register(dirt, 0, getIDs(Info.oreberrybush2), 8, 256);	//Aluminum
		}
		if (Configurations.sieveEssenceBushes)
		{
			SieveRegistry.register(dirt, 0, getIDs(Info.oreberrybush2), 9, 128);
		}
		if (Configurations.sieveNetherOres)
		{
			SieveRegistry.register(soulsand, 0, getIDs(Info.materials), 28, 64); //Cobalt
			SieveRegistry.register(soulsand, 0, getIDs(Info.materials), 29, 64); //Ardite
		}
	}

	public static void addNaturaToSieves()
	{
		
		if (Configurations.sieveRedwoods)
		{
			SieveRegistry.register(dirt, 0, getIDs(Info.flora), 0, 256);
		}
		if (Configurations.sieveOverworldTrees)
		{
			SieveRegistry.register(dirt, 0, getIDs(Info.flora), 1, 90);
			SieveRegistry.register(dirt, 0, getIDs(Info.flora), 2, 90);
			SieveRegistry.register(dirt, 0, getIDs(Info.flora), 3, 64);
			SieveRegistry.register(dirt, 0, getIDs(Info.raresap), 0, 128);
			SieveRegistry.register(dirt, 0, getIDs(Info.raresap), 1, 128);
			SieveRegistry.register(dirt, 0, getIDs(Info.raresap), 2, 128);
			SieveRegistry.register(dirt, 0, getIDs(Info.raresap), 3, 128);
			SieveRegistry.register(dirt, 0, getIDs(Info.raresap), 4, 128);
		}
		if (Configurations.sieveNetherTrees)
		{
			SieveRegistry.register(soulsand, 0, getIDs(Info.flora), 4, 128);
			SieveRegistry.register(soulsand, 0, getIDs(Info.flora), 5, 128);
			SieveRegistry.register(soulsand, 0, getIDs(Info.flora), 6, 128);
			SieveRegistry.register(soulsand, 0, getIDs(Info.flora), 7, 128);
		}
		if (Configurations.sieveBerryBushes)
		{
			SieveRegistry.register(dirt, 0, getIDs(Info.good), 12, 64);
			SieveRegistry.register(dirt, 0, getIDs(Info.good), 13, 64);
			SieveRegistry.register(dirt, 0, getIDs(Info.good), 14, 64);
			SieveRegistry.register(dirt, 0, getIDs(Info.good), 15, 64);
		}
		if (Configurations.sieveDarkBerries)
		{
			SieveRegistry.register(soulsand, 0, getIDs(Info.evil), 12, 64);
			SieveRegistry.register(soulsand, 0, getIDs(Info.evil), 13, 64);
			SieveRegistry.register(soulsand, 0, getIDs(Info.evil), 14, 64);
			SieveRegistry.register(soulsand, 0, getIDs(Info.evil), 15, 64);
		}
		SieveRegistry.register(soulsand, 0, getIDs(Info.glowshroom), 0, 128);
		SieveRegistry.register(soulsand, 0, getIDs(Info.glowshroom), 1, 128);
		SieveRegistry.register(soulsand, 0, getIDs(Info.glowshroom), 2, 128);
		SieveRegistry.register(soulsand, 0, getIDs(Info.thornvines), 0, 48);
		SieveRegistry.register(sand, 0, getIDs(Info.fruit), 0, 32);
	}

	public static void addArsToSieves()
	{
		SieveRegistry.register(sand, 0, getIDs(Info.nova), 0, 32);
	}
}
