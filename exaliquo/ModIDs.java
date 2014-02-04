package exaliquo;

import static cpw.mods.fml.common.registry.GameRegistry.findBlock;
import static cpw.mods.fml.common.registry.GameRegistry.findItem;
import exaliquo.ModIDs.Info;

public class ModIDs
{
		/*
		final static String tc = "TConstruct";
		final static String na = "Natura";
		
		static int oreberrybush = findBlock(tc, "ore.berries.one").blockID;
		static int oreberrybush2 = findBlock(tc, "ore.berries.two").blockID;
		static int hambone = findBlock(tc, "MeatBlock").blockID;
		static int materials = findItem(tc, "materials").itemID;
		static int oreberry = findItem(tc, "oreBerries").itemID;
		
		static int flora = findBlock(na, "florasapling").blockID;
		static int leaves = findBlock(na, "floraleaves").blockID;
		static int raresap = findBlock(na, "Rare Sapling").blockID;
		static int rareleaves = findBlock(na, "Rare Leaves").blockID;
		static int darkleaves = findBlock(na, "Dark Leaves").blockID;
		static int monochrome = findBlock(na, "floraleavesnocolor").blockID;
		static int good = findBlock(na, "BerryBush").blockID;
		static int evil = findBlock(na, "NetherBerryBush").blockID;
		static int blueshroom = findBlock(na, "blueGlowshroom").blockID;
		static int greenshroom = findBlock(na, "greenGlowshroom").blockID;
		static int purpleshroom = findBlock(na, "purpleGlowshroom").blockID;
		static int thornvines = findBlock(na, "Thornvines").blockID;
		static int cactus = findBlock(na, "Saguaro").blockID;
		static int bluebell = findBlock(na, "Bluebells").blockID;
		static int fruit = findItem(na, "saguaro.fruit").itemID;
		static int goodberry = findItem(na, "berry").itemID;
		static int badberry = findItem(na, "berry.nether").itemID;
		static int potash = findItem(na, "Natura.netherfood").itemID;
		static int plants = findItem(na, "barleyFood").itemID;
		static int impmeat = findItem(na, "impmeat").itemID;
		*/
	
	enum Info
	{
		oreberrybush("TConstruct","block","ore.berries.one"),
		oreberrybush2("TConstruct","block","ore.berries.two"),
		hambone("TConstruct","block","MeatBlock"),
		materials("TConstruct","item","materials"),
		oreberry("TConstruct","item","oreBerries"),
		
		flora("Natura","block","florasapling"),
		leaves("Natura","block","floraleaves"),
		raresap("Natura","block","Rare Sapling"),
		rareleaves("Natura","block","Rare Leaves"),
		darkleaves("Natura","block","Dark Leaves"),
		monochrome("Natura","block","floraleavesnocolor"),
		good("Natura","block","BerryBush"),
		evil("Natura","block","NetherBerryBush"),
		blueshroom("Natura","block","blueGlowshroom"),
		greenshroom("Natura","block","greenGlowshroom"),
		purpleshroom("Natura","block","purpleGlowshroom"),
		thornvines("Natura","block","Thornvines"),
		cactus("Natura","block","Saguaro"),
		bluebell("Natura","block","Bluebells"),
		fruit("Natura","item","saguaro.fruit"),
		goodberry("Natura","item","berry"),
		badberry("Natura","item","berry.nether"),
		potash("Natura","item","Natura.netherfood"),
		plants("Natura","item","barleyFood"),
		impmeat("Natura","item","impmeat");
		
		private final String mod;
		private final String type;
		private final String sname;
		
		private Info(String mod, String type, String sname)
		{
			this.mod = mod;
			this.type = type;
			this.sname = sname;
		}
		
		private String mod() { return mod; }
		private String type() { return type; }
		private String sname() {return sname; }
	}
	public static int getIDs(Info info)
	{
		if (info.type == "block")
		{
			return findBlock(info.mod, info.sname).blockID;
		}
		else
		{
			return findItem(info.mod, info.sname).itemID;
		}
	}
}