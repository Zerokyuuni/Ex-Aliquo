package exaliquo.bridges.crossmod;

import static exaliquo.data.ModsLoaded.*;

public class Crossmod
{

	public static void initCross()
	{
		if (isArsMagicaLoaded && isTConLoaded)
		{
			ArsMagica_Tinker.SmeltArs();
		}
		if (isThaumcraftLoaded && isNetherOresLoaded)
		{
			NetherOres_Thaumcraft.Whenk();
		}
		CropXYZ.Shoukan();
	}
}
