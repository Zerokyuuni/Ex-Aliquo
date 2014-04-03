package exaliquo.bridges.MineFactoryReloaded;

import exaliquo.data.Configurations;

public class MineFactoryReloaded
{

	public static void initMFR()
	{
		Colors.ColorMFR();
		Composting.CompostMFR();
		if (Configurations.sacredohgodthewood) Sieving.SieveMFR();
	}
}
