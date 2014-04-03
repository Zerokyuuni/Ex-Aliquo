package exaliquo.bridges.Metallurgy;

import cpw.mods.fml.common.Loader;

public class Metallurgy
{

	public static void initMetallurgy()
	{
		Hammering.HammerMetallurgy();
		Sieving.SieveMetallurgy();
		FurnaceSmelting.registerExMetallurgySmelting();
		OreDict.registerExMetallurgyOreDict();
		if (Loader.isModLoaded("ExtraTIC")) Smelting.SmeltMetallurgy();
	}
}
