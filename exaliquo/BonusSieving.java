package exaliquo;

import net.minecraft.block.Block;

import static cpw.mods.fml.common.registry.GameRegistry.findItem;
import static cpw.mods.fml.common.registry.GameRegistry.findBlock;

import static exaliquo.data.ModIDs.getIDs;
import exaliquo.data.Configurations;
import exaliquo.data.ModIDs.Info;
import exnihilo.registries.SieveRegistry;
import mariculture.world.WorldPlus;

public class BonusSieving
{
	static int dirt = Block.dirt.blockID;
	static int gravel = Block.gravel.blockID;
	static int sand = Block.sand.blockID;
	static int soulsand = Block.slowSand.blockID;
	static int stone = Block.stone.blockID;
	static int topiary = getIDs(Info.topiary);
	
	public static void addTinkerToSieves()
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
		if (Configurations.sieveNetherOres)
		{
			SieveRegistry.register(soulsand, 0, getIDs(Info.materials), 28, 64); //Cobalt
			SieveRegistry.register(soulsand, 0, getIDs(Info.materials), 29, 64); //Ardite
		}
		SieveRegistry.register(getIDs(Info.craftedsoil), 0, getIDs(Info.tinkerfood), 0, 4);
		SieveRegistry.register(getIDs(Info.craftedsoil), 0, getIDs(Info.materials), 1, 3);
		SieveRegistry.register(getIDs(Info.craftedsoil), 0, getIDs(Info.materials), 17, 10);
	}

	public static void addNaturaToSieves()
	{
		for (int i = 0; i < 3; i++)
		{
			if (Configurations.sieveRedwoods)
			{
				SieveRegistry.register(topiary, i, getIDs(Info.flora), 0, 256);
			}
			if (Configurations.sieveOverworldTrees)
			{
				SieveRegistry.register(topiary, i, getIDs(Info.flora), 1, 90);
				if (Configurations.sieveHopseed)
				{
					SieveRegistry.register(topiary, i, getIDs(Info.flora), 2, 90);
				}
				SieveRegistry.register(topiary, i, getIDs(Info.flora), 3, 64);
				SieveRegistry.register(topiary, i, getIDs(Info.raresap), 0, 128);
				SieveRegistry.register(topiary, i, getIDs(Info.raresap), 1, 128);
				SieveRegistry.register(topiary, i, getIDs(Info.raresap), 2, 128);
				SieveRegistry.register(topiary, i, getIDs(Info.raresap), 3, 128);
				SieveRegistry.register(topiary, i, getIDs(Info.raresap), 4, 128);
			}
			if (Configurations.sieveBerryBushes)
			{
				SieveRegistry.register(topiary, 0, getIDs(Info.good), 0, 64);
				SieveRegistry.register(topiary, 0, getIDs(Info.good), 1, 64);
				SieveRegistry.register(topiary, 0, getIDs(Info.good), 2, 64);
				SieveRegistry.register(topiary, 0, getIDs(Info.good), 3, 64);
			}
		}
		if (Configurations.sieveNetherTrees)
		{
			SieveRegistry.register(soulsand, 0, getIDs(Info.flora), 4, 128);
			SieveRegistry.register(soulsand, 0, getIDs(Info.flora), 5, 128);
			SieveRegistry.register(soulsand, 0, getIDs(Info.flora), 6, 128);
			SieveRegistry.register(soulsand, 0, getIDs(Info.flora), 7, 128);
			
			for (int i = 0; i < 4; i++)
			{
				SieveRegistry.register(getIDs(Info.monochrome), 1, getIDs(Info.badberry), i, 16);
				SieveRegistry.register(getIDs(Info.monochrome), 2, getIDs(Info.badberry), i, 16);
				for (int j = 0; j < 4; j++)
				{
					SieveRegistry.register(getIDs(Info.darkleaves), j, getIDs(Info.badberry), i, 16);
				}
			}
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
		
		if ((Configurations.sieveRedwoods) || (Configurations.sieveOverworldTrees))
		{
			for (int i = 0; i < 4;i++)
			{
				SieveRegistry.register(getIDs(Info.monochrome), 0, getIDs(Info.goodberry), i, 16);
				SieveRegistry.register(getIDs(Info.monochrome), 3, getIDs(Info.goodberry), i, 16);
				for (int j = 0; j < 4; j++)
				{
					SieveRegistry.register(getIDs(Info.leaves), j, getIDs(Info.goodberry), i, 16);
					SieveRegistry.register(getIDs(Info.rareleaves), j, getIDs(Info.goodberry), i, 16);
				}
			}
		}
	}

	public static void addArsToSieves()
	{
		SieveRegistry.register(sand, 0, getIDs(Info.nova), 0, 32);
	}

	public static void addThaumcraftToSieves()
	{
		SieveRegistry.register(gravel, 0, getIDs(Info.nuggets), 5, 8);
		SieveRegistry.register(gravel, 0, getIDs(Info.resources), 6, 8);
		SieveRegistry.register(dirt, 0, getIDs(Info.manabean), 0, 64);
	}
	
	public static void addBambooToSieves()
	{
		SieveRegistry.register(Block.leaves.blockID, 3, getIDs(Info.gcbamboo), 0, 64);
	}
	
	public static void addBeesToSieves()
	{
		SieveRegistry.register(getIDs(Info.silkleaves), 0, getIDs(Info.gcbee), 0, 16);
		SieveRegistry.register(getIDs(Info.silkleaves), 1, getIDs(Info.gcbee), 0, 16);
		SieveRegistry.register(getIDs(Info.silkleaves), 2, getIDs(Info.gcbee), 0, 16);
		SieveRegistry.register(getIDs(Info.silkleaves), 3, getIDs(Info.gcbee), 0, 16);
	}

	public static void addMaricultureToSieves()
	{
		SieveRegistry.register(sand, 0, getIDs(Info.mariores), 3, 12);
		if (WorldPlus.isActive) SieveRegistry.register(sand, 0, getIDs(Info.maricoral), 0, 64);
		SieveRegistry.register(getIDs(Info.mariores), 3, getIDs(Info.mariores), 2, 128);
	}
}
