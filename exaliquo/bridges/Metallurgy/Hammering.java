package exaliquo.bridges.Metallurgy;

import exaliquo.Registries;
import static exnihilo.registries.HammerRegistry.registerOre;

public class Hammering
{

	protected static void HammerMetallurgy()
	{
		for (int i = 0; i < 2; i++)
		{
			registerOre(Registries.adamantineOreBlock.blockID, i, Registries.adamantineOreItem.itemID, i+1);
			registerOre(Registries.alduoriteOreBlock.blockID, i, Registries.alduoriteOreItem.itemID, i+1);
			registerOre(Registries.astralsilverOreBlock.blockID, i, Registries.astralsilverOreItem.itemID, i+1);
			registerOre(Registries.atlarusOreBlock.blockID, i, Registries.atlarusOreItem.itemID, i+1);
			registerOre(Registries.carmotOreBlock.blockID, i, Registries.carmotOreItem.itemID, i+1);
			registerOre(Registries.ceruclaseOreBlock.blockID, i, Registries.ceruclaseOreItem.itemID, i+1);
			registerOre(Registries.deepironOreBlock.blockID, i, Registries.deepironOreItem.itemID, i+1);
			registerOre(Registries.eximiteOreBlock.blockID, i, Registries.eximiteOreItem.itemID, i+1);
			registerOre(Registries.ignatiusOreBlock.blockID, i, Registries.ignatiusOreItem.itemID, i+1);
			registerOre(Registries.infuscoliumOreBlock.blockID, i, Registries.infuscoliumOreItem.itemID, i+1);
			registerOre(Registries.kalendriteOreBlock.blockID, i, Registries.kalendriteOreItem.itemID, i+1);
			registerOre(Registries.lemuriteOreBlock.blockID, i, Registries.lemuriteOreItem.itemID, i+1);
			registerOre(Registries.manganeseOreBlock.blockID, i, Registries.manganeseOreItem.itemID, i+1);
			registerOre(Registries.meutoiteOreBlock.blockID, i, Registries.meutoiteOreItem.itemID, i+1);
			registerOre(Registries.midasiumOreBlock.blockID, i, Registries.midasiumOreItem.itemID, i+1);
			registerOre(Registries.mithrilOreBlock.blockID, i, Registries.mithrilOreItem.itemID, i+1);
			registerOre(Registries.orichalcumOreBlock.blockID, i, Registries.orichalcumOreItem.itemID, i+1);
			registerOre(Registries.oureclaseOreBlock.blockID, i, Registries.oureclaseOreItem.itemID, i+1);
			registerOre(Registries.prometheumOreBlock.blockID, i, Registries.prometheumOreItem.itemID, i+1);
			registerOre(Registries.rubraciumOreBlock.blockID, i, Registries.rubraciumOreItem.itemID, i+1);
			registerOre(Registries.sanguiniteOreBlock.blockID, i, Registries.sanguiniteOreItem.itemID, i+1);
			registerOre(Registries.shadowironOreBlock.blockID, i, Registries.shadowironOreItem.itemID, i+1);
			registerOre(Registries.vulcaniteOreBlock.blockID, i, Registries.vulcaniteOreItem.itemID, i+1);
			registerOre(Registries.vyroxeresOreBlock.blockID, i, Registries.vyroxeresOreItem.itemID, i+1);
			registerOre(Registries.zincOreBlock.blockID, i, Registries.zincOreItem.itemID, i+1);
		}
	}
}
