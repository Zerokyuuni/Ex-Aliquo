package exaliquo.bridges.ArsMagica;

import exaliquo.data.Configurations;

public class ArsMagica
{

	public static void initArsMagica()
	{
		Colors.ColorArs();
		Composting.CompostingArs();
		Hammering.HammerArs();
		Heat.HeatArs();
		Recipes.CraftArs();
		if (Configurations.sieveNovas) Sieving.SievingArs();
	}
}
