package exaliquo.bridges.crossmod;

import static exaliquo.data.ModsLoaded.*;
import cpw.mods.fml.common.Loader;

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
		if (isExtraTICLoaded && isMetallurgyLoaded)
		{
			ExtraTic_Metallurgy.SmeltMetallurgy();
		}
		if (isExtraTICLoaded && Loader.isModLoaded("Mekanisum"))
		{
			ExtraTic_Mekanism.SmeltMekanism();
		}
		CropXYZ.Shoukan();
	}
}
