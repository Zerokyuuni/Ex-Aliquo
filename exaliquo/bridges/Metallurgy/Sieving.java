package exaliquo.bridges.Metallurgy;

import static exaliquo.data.ModIDs.getIDs;
import static exaliquo.data.BonusSieving.*;
import exaliquo.Registries;
import exaliquo.data.ModIDs.Info;
import static exnihilo.registries.SieveRegistry.register;

public class Sieving
{

	protected static void SieveMetallurgy()
	{
		int[] overworld = { gravel, sand, getIDs(Info.dust) };
		int[] nether = { netherrack, soulsand };
		
		//Overworld ores
		for (int i = 0; i < 3; i++)
		{
			register(overworld[i], 0, Registries.adamantineOreItem.itemID, i, 128);
			register(overworld[i], 0, Registries.astralsilverOreItem.itemID, i, 14);
			register(overworld[i], 0, Registries.atlarusOreItem.itemID, i, 128);
			register(overworld[i], 0, Registries.carmotOreItem.itemID, i, 32 );
			register(overworld[i], 0, Registries.deepironOreItem.itemID, i, 8);
			register(overworld[i], 0, Registries.infuscoliumOreItem.itemID, i, 12);
			register(overworld[i], 0, Registries.manganeseOreItem.itemID, i, 6);
			register(overworld[i], 0, Registries.mithrilOreItem.itemID, i, 96);
			register(overworld[i], 0, Registries.orichalcumOreItem.itemID, i, 128);
			register(overworld[i], 0, Registries.oureclaseOreItem.itemID, i, 32);
			register(overworld[i], 0, Registries.prometheumOreItem.itemID, i, 6);
			register(overworld[i], 0, Registries.rubraciumOreItem.itemID, i, 144);
			register(overworld[i], 0, Registries.zincOreItem.itemID, i, 12);
		}
		
		//Nether ores
		for (int i = 0; i < 2; i++)
		{
			register(nether[i], 0, Registries.alduoriteOreItem.itemID, i, 14);
			register(nether[i], 0, Registries.ceruclaseOreItem.itemID, i, 14);
			register(nether[i], 0, Registries.ignatiusOreItem.itemID, i, 7);
			register(nether[i], 0, Registries.kalendriteOreItem.itemID, i, 128);
			register(nether[i], 0, Registries.lemuriteOreItem.itemID, i, 12);
			register(nether[i], 0, Registries.midasiumOreItem.itemID, i, 18);
			register(nether[i], 0, Registries.sanguiniteOreItem.itemID, i, 128);
			register(nether[i], 0, Registries.shadowironOreItem.itemID, i, 8);
			register(nether[i], 0, Registries.vulcaniteOreItem.itemID, i, 128);
			register(nether[i], 0, Registries.vyroxeresOreItem.itemID, i, 64);
		}
		
		//End ores
		register(endstone, 0, Registries.eximiteOreItem.itemID, 0, 92);
		register(endstone, 0, Registries.meutoiteOreItem.itemID, 0, 138);
	}
}
