package exaliquo;

import net.minecraft.block.Block;

import static cpw.mods.fml.common.registry.GameRegistry.findItem;
import static cpw.mods.fml.common.registry.GameRegistry.findBlock;

import static exaliquo.data.ModIDs.getIDs;
import exaliquo.data.Configurations;
import exaliquo.data.ModIDs.Info;
import exnihilo.registries.SieveRegistry;

public class BonusSieving
{
	static int dirt = Block.dirt.blockID;
	static int gravel = Block.gravel.blockID;
	static int sand = Block.sand.blockID;
	static int soulsand = Block.slowSand.blockID;
	
	public static void addTinkerToSieves()
	{
		if (Configurations.sieveOreBushes)
		{
			SieveRegistry.register(dirt, 0, getIDs(Info.oreberrybush), 0, 256);		//Iron
			SieveRegistry.register(dirt, 0, getIDs(Info.oreberrybush), 1, 256);		//Gold
			SieveRegistry.register(dirt, 0, getIDs(Info.oreberrybush), 2, 256);	//Copper
			SieveRegistry.register(dirt, 0, getIDs(Info.oreberrybush), 3, 256);	//Tin
			SieveRegistry.register(dirt, 0, getIDs(Info.oreberrybush2), 0, 256);	//Aluminum
		}
		if (Configurations.sieveEssenceBushes)
		{
			SieveRegistry.register(dirt, 0, getIDs(Info.oreberrybush2), 1, 128);
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
			SieveRegistry.register(dirt, 0, getIDs(Info.good), 0, 64);
			SieveRegistry.register(dirt, 0, getIDs(Info.good), 1, 64);
			SieveRegistry.register(dirt, 0, getIDs(Info.good), 2, 64);
			SieveRegistry.register(dirt, 0, getIDs(Info.good), 3, 64);
		}
		if (Configurations.sieveDarkBerries)
		{
			SieveRegistry.register(soulsand, 0, getIDs(Info.evil), 0, 64);
			SieveRegistry.register(soulsand, 0, getIDs(Info.evil), 1, 64);
			SieveRegistry.register(soulsand, 0, getIDs(Info.evil), 2, 64);
			SieveRegistry.register(soulsand, 0, getIDs(Info.evil), 3, 64);
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

	public static void addThaumcraftToSieves()
	{
		SieveRegistry.register(gravel, 0, getIDs(Info.nuggets), 5, 8);
		SieveRegistry.register(gravel, 0, getIDs(Info.resources), 6, 8);
	}
}
