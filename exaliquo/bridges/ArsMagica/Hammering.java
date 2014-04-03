package exaliquo.bridges.ArsMagica;

import static exaliquo.data.ModIDs.getIDs;
import static exaliquo.data.BonusHammerTime.*;
import exaliquo.data.Configurations;
import exaliquo.data.ModIDs.Info;
import static exnihilo.registries.HammerRegistry.register;

public class Hammering
{
	
	protected static void HammerArs()
	{
		register(stone, 0, getIDs(Info.magicore), 0, 0.15F, 0.05F);		//Vinteum
		register(stone, 0, getIDs(Info.magicore), 4, 0.1F, 0.05F);		//Chimerite
		register(stone, 0, getIDs(Info.magicore), 5, 0.08F, 0.05F);		//Blue Topaz
		if (Configurations.hammerMoonstone)
		{
		register(stone, 0, getIDs(Info.magicore), 7, 0.05F, 0.05F);		//Moonstone
		}
		register(netherrack, 0, getIDs(Info.magicore), 6, 0.05F, 0.05F);	//Sunstone		
	}
}
