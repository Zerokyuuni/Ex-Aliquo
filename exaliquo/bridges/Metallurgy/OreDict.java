package exaliquo.bridges.Metallurgy;

import exaliquo.Registries;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDict
{

	protected static void registerExMetallurgyOreDict()
	{
		for (int i = 0; i < 3; i++)
		{
			OreDictionary.registerOre("oreAdamantine", new ItemStack(Registries.adamantineOreBlock, 1, i));
			OreDictionary.registerOre("oreAlduorite", new ItemStack(Registries.alduoriteOreBlock, 1, i));
			OreDictionary.registerOre("oreAstral Silver", new ItemStack(Registries.astralsilverOreBlock, 1, i));
			OreDictionary.registerOre("oreAtlarus", new ItemStack(Registries.atlarusOreBlock, 1, i));
			OreDictionary.registerOre("oreCarmot", new ItemStack(Registries.carmotOreBlock, 1, i));
			OreDictionary.registerOre("oreCeruclase", new ItemStack(Registries.ceruclaseOreBlock, 1, i));
			OreDictionary.registerOre("oreDeep Iron", new ItemStack(Registries.deepironOreBlock, 1, i));
			OreDictionary.registerOre("oreEximite", new ItemStack(Registries.eximiteOreBlock, 1, i));
			OreDictionary.registerOre("oreIgnatius", new ItemStack(Registries.ignatiusOreBlock, 1, i));
			OreDictionary.registerOre("oreInfuscolium", new ItemStack(Registries.infuscoliumOreBlock, 1, i));
			OreDictionary.registerOre("oreKalendrite", new ItemStack(Registries.kalendriteOreBlock, 1, i));
			OreDictionary.registerOre("oreLemurite", new ItemStack(Registries.lemuriteOreBlock, 1, i));
			OreDictionary.registerOre("oreManganese", new ItemStack(Registries.manganeseOreBlock, 1, i));
			OreDictionary.registerOre("oreMeutoite", new ItemStack(Registries.meutoiteOreBlock, 1, i));
			OreDictionary.registerOre("oreMidasium", new ItemStack(Registries.midasiumOreBlock, 1, i));
			OreDictionary.registerOre("oreMithril", new ItemStack(Registries.mithrilOreBlock, 1, i));
			OreDictionary.registerOre("oreOrichalcum", new ItemStack(Registries.orichalcumOreBlock, 1, i));
			OreDictionary.registerOre("oreOureclase", new ItemStack(Registries.oureclaseOreBlock, 1, i));
			OreDictionary.registerOre("orePrometheum", new ItemStack(Registries.prometheumOreBlock, 1, i));
			OreDictionary.registerOre("oreRubracium", new ItemStack(Registries.rubraciumOreBlock, 1, i));
			OreDictionary.registerOre("oreSanguinite", new ItemStack(Registries.sanguiniteOreBlock, 1, i));
			OreDictionary.registerOre("oreShadow Iron", new ItemStack(Registries.shadowironOreBlock, 1, i));
			OreDictionary.registerOre("oreVulcanite", new ItemStack(Registries.vulcaniteOreBlock, 1, i));
			OreDictionary.registerOre("oreVyroxeres", new ItemStack(Registries.vyroxeresOreBlock, 1, i));
			OreDictionary.registerOre("oreZinc", new ItemStack(Registries.zincOreBlock, 1, i));
		}
	}
}
