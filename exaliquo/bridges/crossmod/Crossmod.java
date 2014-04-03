package exaliquo.bridges.crossmod;

import cpw.mods.fml.common.Loader;

public class Crossmod
{

	public static void initCross()
	{
		if (Loader.isModLoaded("ArsMagica") && Loader.isModLoaded("TConstruct"))
		{
			ArsMagica_Tinker.SmeltArs();
		}
		if (Loader.isModLoaded("Thaumcraft") && Loader.isModLoaded("NetherOres"))
		{
			NetherOres_Thaumcraft.Whenk();
		}
		CropXYZ.Shoukan();
	}
}
