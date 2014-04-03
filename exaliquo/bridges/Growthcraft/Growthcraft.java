package exaliquo.bridges.Growthcraft;

import cpw.mods.fml.common.Loader;

public class Growthcraft
{

	protected static boolean isGCApples = Loader.isModLoaded("Growthcraft|Apples");
	protected static boolean isGCBamboo = Loader.isModLoaded("Growthcraft|Bamboo");
	protected static boolean isGCBees = Loader.isModLoaded("Growthcraft|Bees");
	protected static boolean isGCGrapes = Loader.isModLoaded("Growthcraft|Grapes");
	protected static boolean isGCHops = Loader.isModLoaded("Growthcraft|Hops");
	protected static boolean isGCRice = Loader.isModLoaded("Growthcraft|Rice");
	
	public static void initGrowthcraft()
	{
		Colors.ColorGrowth();
		Composting.CompostGrowth();
		Sieving.SieveGrowth();
	}
}
