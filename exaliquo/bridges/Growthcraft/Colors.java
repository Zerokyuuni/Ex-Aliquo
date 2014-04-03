package exaliquo.bridges.Growthcraft;

import static exnihilo.registries.ColorRegistry.register;
import exnihilo.registries.helpers.Color;

public class Colors
{

	protected static void ColorGrowth()
	{
		if (Growthcraft.isGCBamboo) register("bamboo", new Color("D0CE81"));
		if (Growthcraft.isGCGrapes) register("grape", new Color("4C2973"));
		if (Growthcraft.isGCHops) register("hops", new Color("7BC743"));
	}
}
