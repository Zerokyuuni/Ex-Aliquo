package exaliquo.bridges.Growthcraft;

import static exaliquo.data.ModIDs.getIDs;
import net.minecraft.item.Item;
import exaliquo.data.ModIDs.Info;
import static exnihilo.registries.ColorRegistry.color;
import static exnihilo.registries.CompostRegistry.register;

public class Composting
{

	protected static void CompostGrowth()
	{
		if (Growthcraft.isGCApples)
		{
			register(getIDs(Info.gcapple), 0, 0.03125F, color("apple"));
			register(Item.appleRed.itemID, 0, 0.03125F, color("apple"));
			register(getIDs(Info.gcsappling), 0, 0.03125F, color("oak"));
		}
		if (Growthcraft.isGCBamboo)
		{
			register(getIDs(Info.gcbamboo), 0, 0.125F, color("bamboo"));
			register(getIDs(Info.gcleaves), 0, 0.125F, color("bamboo"));
		}
		if (Growthcraft.isGCGrapes)
		{
			register(getIDs(Info.gcgrape), 0, 0.125F, color("grape"));
			register(getIDs(Info.gcgrapeseed), 0, 0.125F, color("grape"));
		}
		if (Growthcraft.isGCHops)
		{
			register(getIDs(Info.gchops), 0, 0.125F, color("hops"));
			register(getIDs(Info.gchopseed), 0, 0.125F, color("hops"));
		}
		if (Growthcraft.isGCRice)
		{
			register(getIDs(Info.gcrice), 0, 0.125F, color("white"));
			register(getIDs(Info.gcriceball), 0, 0.125F, color("white"));
		}
	}
}
