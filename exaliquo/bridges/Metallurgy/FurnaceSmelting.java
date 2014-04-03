package exaliquo.bridges.Metallurgy;

import cpw.mods.fml.common.registry.GameRegistry;
import exaliquo.Registries;
import exaliquo.data.OreDict;

public class FurnaceSmelting
{

	protected static void registerExMetallurgySmelting()
	{
		for (int i = 0; i < 3; i++)
		{
			GameRegistry.addSmelting(Registries.adamantineOreBlock.blockID, OreDict.getFirstOre("ingotAdamantine"), 3);
			GameRegistry.addSmelting(Registries.alduoriteOreBlock.blockID, OreDict.getFirstOre("ingotAlduorite"), 3);
			GameRegistry.addSmelting(Registries.astralsilverOreBlock.blockID, OreDict.getFirstOre("ingotAstral Silver"), 3);
			GameRegistry.addSmelting(Registries.atlarusOreBlock.blockID, OreDict.getFirstOre("ingotAtlarus"), 3);
			GameRegistry.addSmelting(Registries.carmotOreBlock.blockID, OreDict.getFirstOre("ingotCarmot"), 3);
			GameRegistry.addSmelting(Registries.ceruclaseOreBlock.blockID, OreDict.getFirstOre("ingotCeruclase"), 3);
			GameRegistry.addSmelting(Registries.deepironOreBlock.blockID, OreDict.getFirstOre("ingotDeep Iron"), 3);
			GameRegistry.addSmelting(Registries.eximiteOreBlock.blockID, OreDict.getFirstOre("ingotEximite"), 3);
			GameRegistry.addSmelting(Registries.ignatiusOreBlock.blockID, OreDict.getFirstOre("ingotIgnatius"), 3);
			GameRegistry.addSmelting(Registries.infuscoliumOreBlock.blockID, OreDict.getFirstOre("ingotInfuscolium"), 3);
			GameRegistry.addSmelting(Registries.kalendriteOreBlock.blockID, OreDict.getFirstOre("ingotKalendrite"), 3);
			GameRegistry.addSmelting(Registries.lemuriteOreBlock.blockID, OreDict.getFirstOre("ingotLemurite"), 3);
			GameRegistry.addSmelting(Registries.manganeseOreBlock.blockID, OreDict.getFirstOre("ingotManganese"), 3);
			GameRegistry.addSmelting(Registries.meutoiteOreBlock.blockID, OreDict.getFirstOre("ingotMeutoite"), 3);
			GameRegistry.addSmelting(Registries.midasiumOreBlock.blockID, OreDict.getFirstOre("ingotMidasium"), 3);
			GameRegistry.addSmelting(Registries.mithrilOreBlock.blockID, OreDict.getFirstOre("ingotMithril"), 3);
			GameRegistry.addSmelting(Registries.orichalcumOreBlock.blockID, OreDict.getFirstOre("ingotOrichalcum"), 3);
			GameRegistry.addSmelting(Registries.oureclaseOreBlock.blockID, OreDict.getFirstOre("ingotOureclase"), 3);
			GameRegistry.addSmelting(Registries.prometheumOreBlock.blockID, OreDict.getFirstOre("ingotPrometheum"), 3);
			GameRegistry.addSmelting(Registries.rubraciumOreBlock.blockID, OreDict.getFirstOre("ingotRubracium"), 3);
			GameRegistry.addSmelting(Registries.sanguiniteOreBlock.blockID, OreDict.getFirstOre("ingotSanguinite"), 3);
			GameRegistry.addSmelting(Registries.shadowironOreBlock.blockID, OreDict.getFirstOre("ingotShadow Iron"), 3);
			GameRegistry.addSmelting(Registries.vulcaniteOreBlock.blockID, OreDict.getFirstOre("ingotVulcanite"), 3);
			GameRegistry.addSmelting(Registries.vyroxeresOreBlock.blockID, OreDict.getFirstOre("ingotVyroxeres"), 3);
			GameRegistry.addSmelting(Registries.zincOreBlock.blockID, OreDict.getFirstOre("ingotZinc"), 3);
		}
	}
}
