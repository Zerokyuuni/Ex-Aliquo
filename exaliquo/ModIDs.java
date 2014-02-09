package exaliquo;

import static cpw.mods.fml.common.registry.GameRegistry.findBlock;
import static cpw.mods.fml.common.registry.GameRegistry.findItem;
import exaliquo.ModIDs.Info;

public class ModIDs
{
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