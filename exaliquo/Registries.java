package exaliquo;

import static exaliquo.data.ModIDs.getBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

import exaliquo.blocks.ores.OreAdamantine;
import exaliquo.blocks.ores.OreAlduorite;
import exaliquo.blocks.ores.OreArdite;
import exaliquo.blocks.ores.OreAstralSilver;
import exaliquo.blocks.ores.OreAtlarus;
import exaliquo.blocks.ores.OreCarmot;
import exaliquo.blocks.ores.OreCeruclase;
import exaliquo.blocks.ores.OreCobalt;
import exaliquo.blocks.ores.OreDeepIron;
import exaliquo.blocks.ores.OreEximite;
import exaliquo.blocks.ores.OreIgnatius;
import exaliquo.blocks.ores.OreInfuscolium;
import exaliquo.blocks.ores.OreKalendrite;
import exaliquo.blocks.ores.OreLemurite;
import exaliquo.blocks.ores.OreManganese;
import exaliquo.blocks.ores.OreMeuroite;
import exaliquo.blocks.ores.OreMidasium;
import exaliquo.blocks.ores.OreMithril;
import exaliquo.blocks.ores.OreOrichalcum;
import exaliquo.blocks.ores.OreOureclase;
import exaliquo.blocks.ores.OrePrometheum;
import exaliquo.blocks.ores.OreRubracium;
import exaliquo.blocks.ores.OreSanguinite;
import exaliquo.blocks.ores.OreShadowIron;
import exaliquo.blocks.ores.OreVulcanite;
import exaliquo.blocks.ores.OreVyroxeres;
import exaliquo.blocks.ores.OreZinc;
import exaliquo.bridges.TConstruct.SkyModifiers;
import exaliquo.bridges.TConstruct.Modifiers.ModCrooked;
import exaliquo.bridges.TConstruct.Modifiers.ModHammered;
import exaliquo.data.Configurations;
import exaliquo.data.ExATab;
import exaliquo.data.OreDict;
import static exaliquo.data.ModIDs.getItem;
import exaliquo.data.ModIDs.Info;
import exaliquo.items.GoldCrook;
import exaliquo.items.HayCrook;
import exaliquo.items.InvarHammer;
import exaliquo.items.ReedCrook;
import exaliquo.items.ThaumiumHammer;
import exaliquo.items.blocks.ItemBlockOreAdamantine;
import exaliquo.items.blocks.ItemBlockOreAlduorite;
import exaliquo.items.blocks.ItemBlockOreArdite;
import exaliquo.items.blocks.ItemBlockOreAstralSilver;
import exaliquo.items.blocks.ItemBlockOreAtlarus;
import exaliquo.items.blocks.ItemBlockOreCarmot;
import exaliquo.items.blocks.ItemBlockOreCeruclase;
import exaliquo.items.blocks.ItemBlockOreCobalt;
import exaliquo.items.blocks.ItemBlockOreDeepIron;
import exaliquo.items.blocks.ItemBlockOreEximite;
import exaliquo.items.blocks.ItemBlockOreIgnatius;
import exaliquo.items.blocks.ItemBlockOreInfuscolium;
import exaliquo.items.blocks.ItemBlockOreKalendrite;
import exaliquo.items.blocks.ItemBlockOreLemurite;
import exaliquo.items.blocks.ItemBlockOreManganese;
import exaliquo.items.blocks.ItemBlockOreMeuroite;
import exaliquo.items.blocks.ItemBlockOreMidasium;
import exaliquo.items.blocks.ItemBlockOreMithril;
import exaliquo.items.blocks.ItemBlockOreOrichalcum;
import exaliquo.items.blocks.ItemBlockOreOureclase;
import exaliquo.items.blocks.ItemBlockOrePrometheum;
import exaliquo.items.blocks.ItemBlockOreRubracium;
import exaliquo.items.blocks.ItemBlockOreSanguinite;
import exaliquo.items.blocks.ItemBlockOreShadowIron;
import exaliquo.items.blocks.ItemBlockOreVulcanite;
import exaliquo.items.blocks.ItemBlockOreVyroxeres;
import exaliquo.items.blocks.ItemBlockOreZinc;
import exaliquo.items.ores.ItemOreAdamantine;
import exaliquo.items.ores.ItemOreAlduorite;
import exaliquo.items.ores.ItemOreAstralSilver;
import exaliquo.items.ores.ItemOreAtlarus;
import exaliquo.items.ores.ItemOreCarmot;
import exaliquo.items.ores.ItemOreCeruclase;
import exaliquo.items.ores.ItemOreCobalt;
import exaliquo.items.ores.ItemOreArdite;
import exaliquo.items.ores.ItemOreDeepIron;
import exaliquo.items.ores.ItemOreEximite;
import exaliquo.items.ores.ItemOreIgnatius;
import exaliquo.items.ores.ItemOreInfuscolium;
import exaliquo.items.ores.ItemOreKalendrite;
import exaliquo.items.ores.ItemOreLemurite;
import exaliquo.items.ores.ItemOreManganese;
import exaliquo.items.ores.ItemOreMeuroite;
import exaliquo.items.ores.ItemOreMidasium;
import exaliquo.items.ores.ItemOreMithril;
import exaliquo.items.ores.ItemOreOrichalcum;
import exaliquo.items.ores.ItemOreOureclase;
import exaliquo.items.ores.ItemOrePrometheum;
import exaliquo.items.ores.ItemOreRubracium;
import exaliquo.items.ores.ItemOreSanguinite;
import exaliquo.items.ores.ItemOreShadowIron;
import exaliquo.items.ores.ItemOreVulcanite;
import exaliquo.items.ores.ItemOreVyroxeres;
import exaliquo.items.ores.ItemOreZinc;

public class Registries
{
	public static ExATab exatab;
	
	private static String[] hammershape = { " i ", " si", "s  " };
	private static String[] crookshape = { "ii", " i", " i" };
	public static String[] oreType = { "Gravel","Sand","Dust" };
	private static String[] oreshape = { "ii", "ii" };
	public static Item hammerThaum;
	public static Item hammerInvar;
	public static Item crookReed;
	public static Item crookGold;
	public static Item crookHay;
	
	public static Block cobaltOreBlock;
	public static Block arditeOreBlock;
	public static Block adamantineOreBlock;
	public static Block alduoriteOreBlock;
	public static Block astralsilverOreBlock;
	public static Block atlarusOreBlock;
	public static Block carmotOreBlock;
	public static Block ceruclaseOreBlock;
	public static Block deepironOreBlock;
	public static Block eximiteOreBlock;
	public static Block ignatiusOreBlock;
	public static Block infuscoliumOreBlock;
	public static Block kalendriteOreBlock;
	public static Block lemuriteOreBlock;
	public static Block manganeseOreBlock;
	public static Block meutoiteOreBlock;
	public static Block midasiumOreBlock;
	public static Block mithrilOreBlock;
	public static Block orichalcumOreBlock;
	public static Block oureclaseOreBlock;
	public static Block prometheumOreBlock;
	public static Block rubraciumOreBlock;
	public static Block sanguiniteOreBlock;
	public static Block shadowironOreBlock;
	public static Block vulcaniteOreBlock;
	public static Block vyroxeresOreBlock;
	public static Block zincOreBlock;
	
	public static Item cobaltOreItem;
	public static Item arditeOreItem;
	public static Item adamantineOreItem;
	public static Item alduoriteOreItem;
	public static Item astralsilverOreItem;
	public static Item atlarusOreItem;
	public static Item carmotOreItem;
	public static Item ceruclaseOreItem;
	public static Item deepironOreItem;
	public static Item eximiteOreItem;
	public static Item ignatiusOreItem;
	public static Item infuscoliumOreItem;
	public static Item kalendriteOreItem;
	public static Item lemuriteOreItem;
	public static Item manganeseOreItem;
	public static Item meutoiteOreItem;
	public static Item midasiumOreItem;
	public static Item mithrilOreItem;
	public static Item orichalcumOreItem;
	public static Item oureclaseOreItem;
	public static Item prometheumOreItem;
	public static Item rubraciumOreItem;
	public static Item sanguiniteOreItem;
	public static Item shadowironOreItem;
	public static Item vulcaniteOreItem;
	public static Item vyroxeresOreItem;
	public static Item zincOreItem;
	
	public static void registerItems() {
		hammerThaum = new ThaumiumHammer(Configurations.thaumHammer, OreDict.getMaterial("THAUMIUM")).setUnlocalizedName("ExAliquo.ThaumHammer").setCreativeTab(exatab);
		GameRegistry.registerItem(hammerThaum, "ExAliquo.ThaumHammer");
		hammerInvar = new InvarHammer(Configurations.invarHammer, OreDict.getMaterial("INVAR")).setUnlocalizedName("ExAliquo.InvarHammer").setCreativeTab(exatab);
		GameRegistry.registerItem(hammerInvar,"ExAliquo.InvarHammer");
		crookReed = new ReedCrook(Configurations.reedCrook).setUnlocalizedName("ExAliquo.ReedCrook").setCreativeTab(exatab);
		GameRegistry.registerItem(crookReed, "ExAliquo.ReedCrook");
		crookGold = new GoldCrook(Configurations.goldCrook).setUnlocalizedName("ExAliquo.GoldCrook").setCreativeTab(exatab);
		GameRegistry.registerItem(crookGold, "ExAliquo.GoldCrook");
		crookHay = new HayCrook(Configurations.hayCrook).setUnlocalizedName("ExAliquo.HayCrook").setCreativeTab(exatab);
		GameRegistry.registerItem(crookHay, "ExAliquo.HayCrook");
	}

	public static void registerRecipes()
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(hammerInvar), new Object[] { hammershape, 's', "stickWood", 'i', "ingotInvar" }));
		GameRegistry.addShapedRecipe(new ItemStack(crookReed), new Object[] { crookshape, 'i', Item.reed });
		GameRegistry.addShapedRecipe(new ItemStack(crookGold), new Object[] { crookshape, 'i', Item.ingotGold });
		GameRegistry.addShapedRecipe(new ItemStack(crookHay), new Object[] { "wwi", "iwi", " w ", 'w', Item.wheat, 'i', Block.fenceIron });
	}

	public static void registerNihiloOreDict()
	{
		for (int i = 0; i < 3; i++)
		{
			OreDictionary.registerOre("oreIron", new ItemStack(getBlock(Info.ironore), 1, i));
			OreDictionary.registerOre("oreGold", new ItemStack(getBlock(Info.goldore), 1, i));
			OreDictionary.registerOre("oreCopper", new ItemStack(getBlock(Info.copperore), 1, i));
			OreDictionary.registerOre("oreTin", new ItemStack(getBlock(Info.tinore), 1, i));
			OreDictionary.registerOre("oreSilver", new ItemStack(getBlock(Info.silverore), 1, i));
			OreDictionary.registerOre("oreLead", new ItemStack(getBlock(Info.leadore), 1, i));
			OreDictionary.registerOre("oreNickel", new ItemStack(getBlock(Info.nickelore), 1, i));
			OreDictionary.registerOre("orePlatinum", new ItemStack(getBlock(Info.platinumore), 1, i));
			OreDictionary.registerOre("oreAluminum", new ItemStack(getBlock(Info.aluminumore), 1, i));
		}
	}

	public static void registerExTConstructOres()
	{
		cobaltOreBlock = new OreCobalt(Configurations.cobaltOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(cobaltOreBlock, ItemBlockOreCobalt.class, "ExAliquo.CobaltOreBlock");
		arditeOreBlock = new OreArdite(Configurations.arditeOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(arditeOreBlock, ItemBlockOreArdite.class, "ExAliquo.ArditeOreBlock");
		
		cobaltOreItem = new ItemOreCobalt(Configurations.cobaltOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OreCobaltItem");
		GameRegistry.registerItem(cobaltOreItem, "ExAliquo.OreCobaltItem");
		arditeOreItem = new ItemOreArdite(Configurations.arditeOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OreArditeItem");
		GameRegistry.registerItem(arditeOreItem, "ExAliquo.OreArditeItem");
	}
	
	public static void registerExTConstructCrafting()
	{
		for (int i = 0; i < 3; i++)
		{
			GameRegistry.addShapedRecipe(new ItemStack(cobaltOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(cobaltOreItem, 1, i)});
			GameRegistry.addShapedRecipe(new ItemStack(arditeOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(arditeOreItem, 1, i)});
		}
	}
	
	public static void registerExMetallurgyOres()
	{
		adamantineOreBlock = new OreAdamantine(Configurations.adamantineOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(adamantineOreBlock, ItemBlockOreAdamantine.class, "ExAliquo.AdamantineOreBlock");
		alduoriteOreBlock = new OreAlduorite(Configurations.alduoriteOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(alduoriteOreBlock, ItemBlockOreAlduorite.class, "ExAliquo.AlduoriteOreBlock");
		astralsilverOreBlock = new OreAstralSilver(Configurations.astralsilverOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(astralsilverOreBlock, ItemBlockOreAstralSilver.class, "ExAliquo.AstralSilverOreBlock");
		atlarusOreBlock = new OreAtlarus(Configurations.atlarusOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(atlarusOreBlock, ItemBlockOreAtlarus.class, "ExAliquo.AtlarusOreBlock");
		carmotOreBlock = new OreCarmot(Configurations.carmotOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(carmotOreBlock, ItemBlockOreCarmot.class, "ExAliquo.CarmotOreBlock");
		ceruclaseOreBlock = new OreCeruclase(Configurations.ceruclaseOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(ceruclaseOreBlock, ItemBlockOreCeruclase.class, "ExAliquo.CeruclaseOreBlock");
		deepironOreBlock = new OreDeepIron(Configurations.deepironOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(deepironOreBlock, ItemBlockOreDeepIron.class, "ExAliquo.DeepIronOreBlock");
		eximiteOreBlock = new OreEximite(Configurations.eximiteOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(eximiteOreBlock, ItemBlockOreEximite.class, "ExAliquo.EximiteOreBlock");
		ignatiusOreBlock = new OreIgnatius(Configurations.ignatiusOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(ignatiusOreBlock, ItemBlockOreIgnatius.class, "ExAliquo.IgnatiusOreBlock");
		infuscoliumOreBlock = new OreInfuscolium(Configurations.infuscoliumOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(infuscoliumOreBlock, ItemBlockOreInfuscolium.class, "ExAliquo.InfuscoliumOreBlock");
		kalendriteOreBlock = new OreKalendrite(Configurations.kalendriteOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(kalendriteOreBlock, ItemBlockOreKalendrite.class, "ExAliquo.KalendriteOreBlock");
		lemuriteOreBlock = new OreLemurite(Configurations.lemuriteOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(lemuriteOreBlock, ItemBlockOreLemurite.class, "ExAliquo.LemuriteOreBlock");
		manganeseOreBlock = new OreManganese(Configurations.manganeseOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(manganeseOreBlock, ItemBlockOreManganese.class, "Exaliquo.ManganeseOreBlock");
		meutoiteOreBlock = new OreMeuroite(Configurations.meutoiteOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(meutoiteOreBlock, ItemBlockOreMeuroite.class, "ExAliquo.MeuroiteOreBlock");
		midasiumOreBlock = new OreMidasium(Configurations.midasiumOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(midasiumOreBlock, ItemBlockOreMidasium.class, "ExAliquo.MidasiumOreBlock");
		mithrilOreBlock = new OreMithril(Configurations.mithrilOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(mithrilOreBlock, ItemBlockOreMithril.class, "ExAliquo.MithrilOreBlock");
		orichalcumOreBlock = new OreOrichalcum(Configurations.orichalcumOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(orichalcumOreBlock, ItemBlockOreOrichalcum.class, "ExAliquo.OrichalcumOreBlock");
		oureclaseOreBlock = new OreOureclase(Configurations.oureclaseOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(oureclaseOreBlock, ItemBlockOreOureclase.class, "ExAliquo.OureclaseOreBlock");
		prometheumOreBlock = new OrePrometheum(Configurations.prometheumOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(prometheumOreBlock, ItemBlockOrePrometheum.class, "ExAliquo.PromethiumOreBlock");
		rubraciumOreBlock = new OreRubracium(Configurations.rubraciumOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(rubraciumOreBlock, ItemBlockOreRubracium.class, "ExAliquo.RubraciumOreBlock");
		sanguiniteOreBlock = new OreSanguinite(Configurations.sanguiniteOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(sanguiniteOreBlock, ItemBlockOreSanguinite.class, "ExAliquo.SanguinuteOreBlock");
		shadowironOreBlock = new OreShadowIron(Configurations.shadowironOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(shadowironOreBlock, ItemBlockOreShadowIron.class, "ExAliquo.ShadowIronOreBlock");
		vulcaniteOreBlock = new OreVulcanite(Configurations.vulcaniteOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(vulcaniteOreBlock, ItemBlockOreVulcanite.class, "ExAliquo.VulcaniteOreBlock");
		vyroxeresOreBlock = new OreVyroxeres(Configurations.vyroxeresOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(vyroxeresOreBlock, ItemBlockOreVyroxeres.class, "ExAliquo.VyroxeresOreBlock");
		zincOreBlock = new OreZinc(Configurations.zincOreBlock).setCreativeTab(exatab);
		GameRegistry.registerBlock(zincOreBlock, ItemBlockOreZinc.class, "ExAliquo.ZincOreBlock");
		
		adamantineOreItem = new ItemOreAdamantine(Configurations.adamantineOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OreAdamantiumItem");
		GameRegistry.registerItem(adamantineOreItem, "ExAliquo.OreAdamantineItem");
		alduoriteOreItem = new ItemOreAlduorite(Configurations.alduoriteOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OreAlduoriteItem");
		GameRegistry.registerItem(alduoriteOreItem, "ExAliquo.OreAlduoriteItem");
		astralsilverOreItem = new ItemOreAstralSilver(Configurations.astralsilverOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OreAstralSilverItem");
		GameRegistry.registerItem(astralsilverOreItem, "ExAliquo.OreAstralSilverItem");
		atlarusOreItem = new ItemOreAtlarus(Configurations.atlarusOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OreAtlarusItem");
		GameRegistry.registerItem(atlarusOreItem, "ExAliquo.OreAtlarusItem");
		carmotOreItem = new ItemOreCarmot(Configurations.carmotOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OreCarmotItem");
		GameRegistry.registerItem(carmotOreItem, "ExAliquo.CarmotOreItem");
		ceruclaseOreItem = new ItemOreCeruclase(Configurations.ceruclaseOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OreCeruclaseItem");
		GameRegistry.registerItem(ceruclaseOreItem, "ExAliquo.CeruclaseOreItem");
		deepironOreItem = new ItemOreDeepIron(Configurations.deepironOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OreDeepIronItem");
		GameRegistry.registerItem(deepironOreItem, "ExAliquo.DeepIronOreItem");
		eximiteOreItem = new ItemOreEximite(Configurations.eximiteOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OreEximiteItem");
		GameRegistry.registerItem(eximiteOreItem, "ExAliquo.EximiteOreItem");
		ignatiusOreItem = new ItemOreIgnatius(Configurations.ignatiusOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OreIgnatiusItem");
		GameRegistry.registerItem(ignatiusOreItem, "ExAliquo.IgnatiusOreItem");
		infuscoliumOreItem = new ItemOreInfuscolium(Configurations.infuscoliumOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OreInfuscoliumItem");
		GameRegistry.registerItem(infuscoliumOreItem, "ExAliquo.InfuscoliumOreItem");
		kalendriteOreItem = new ItemOreKalendrite(Configurations.kalendriteOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OreKalendriteItem");
		GameRegistry.registerItem(kalendriteOreItem, "ExAliquo.KalendriteOreItem");
		lemuriteOreItem = new ItemOreLemurite(Configurations.lemuriteOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OreLemuriteItem");
		GameRegistry.registerItem(lemuriteOreItem, "ExAliquo.LemuriteOreItem");
		manganeseOreItem = new ItemOreManganese(Configurations.manganeseOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OreManganeseItem");
		GameRegistry.registerItem(manganeseOreItem, "Exaliquo.ManganeseOreItem");
		meutoiteOreItem = new ItemOreMeuroite(Configurations.meutoiteOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OreMeuroiteItem");
		GameRegistry.registerItem(meutoiteOreItem, "ExAliquo.MeuroiteOreItem");
		midasiumOreItem = new ItemOreMidasium(Configurations.midasiumOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OreMidasiumItem");
		GameRegistry.registerItem(midasiumOreItem, "ExAliquo.MidasiumOreItem");
		mithrilOreItem = new ItemOreMithril(Configurations.mithrilOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OreMithrilItem");
		GameRegistry.registerItem(mithrilOreItem, "ExAliquo.MithrilOreItem");
		orichalcumOreItem = new ItemOreOrichalcum(Configurations.orichalcumOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OreOrichalcumItem");
		GameRegistry.registerItem(orichalcumOreItem, "ExAliquo.OrichalcumOreItem");
		oureclaseOreItem = new ItemOreOureclase(Configurations.oureclaseOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OreOureclaseItem");
		GameRegistry.registerItem(oureclaseOreItem, "ExAliquo.OureclaseOreItem");
		prometheumOreItem = new ItemOrePrometheum(Configurations.prometheumOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OrePrometheumItem");
		GameRegistry.registerItem(prometheumOreItem, "ExAliquo.PromethiumOreItem");
		rubraciumOreItem = new ItemOreRubracium(Configurations.rubraciumOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OreRubraciumItem");
		GameRegistry.registerItem(rubraciumOreItem, "ExAliquo.RubraciumOreItem");
		sanguiniteOreItem = new ItemOreSanguinite(Configurations.sanguiniteOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OreSanguiniteItem");
		GameRegistry.registerItem(sanguiniteOreItem, "ExAliquo.SanguinuteOreItem");
		shadowironOreItem = new ItemOreShadowIron(Configurations.shadowironOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OreShadowIronItem");
		GameRegistry.registerItem(shadowironOreItem, "ExAliquo.ShadowIronOreItem");
		vulcaniteOreItem = new ItemOreVulcanite(Configurations.vulcaniteOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OreVulcaniteItem");
		GameRegistry.registerItem(vulcaniteOreItem, "ExAliquo.VulcaniteOreItem");
		vyroxeresOreItem = new ItemOreVyroxeres(Configurations.vyroxeresOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OreVyroxeresItem");
		GameRegistry.registerItem(vyroxeresOreItem, "ExAliquo.VyroxeresOreItem");
		zincOreItem = new ItemOreZinc(Configurations.zincOreItem).setCreativeTab(exatab).setUnlocalizedName("ExAliquo.OreZincItem");
		GameRegistry.registerItem(zincOreItem, "ExAliquo.ZincOreItem");
	}

	public static void registerExMetallurgyCrafting()
	{
		for (int i = 0; i < 3; i++)
		{
			GameRegistry.addShapedRecipe(new ItemStack(adamantineOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(adamantineOreItem, 1, i)});
			GameRegistry.addShapedRecipe(new ItemStack(alduoriteOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(alduoriteOreItem, 1, i)});
			GameRegistry.addShapedRecipe(new ItemStack(astralsilverOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(astralsilverOreItem, 1, i)});
			GameRegistry.addShapedRecipe(new ItemStack(atlarusOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(atlarusOreItem, 1, i)});
			GameRegistry.addShapedRecipe(new ItemStack(carmotOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(carmotOreItem, 1, i)});
			GameRegistry.addShapedRecipe(new ItemStack(ceruclaseOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(ceruclaseOreItem, 1, i)});
			GameRegistry.addShapedRecipe(new ItemStack(deepironOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(deepironOreItem, 1, i)});
			GameRegistry.addShapedRecipe(new ItemStack(eximiteOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(eximiteOreItem, 1, i)});
			GameRegistry.addShapedRecipe(new ItemStack(ignatiusOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(ignatiusOreItem, 1, i)});
			GameRegistry.addShapedRecipe(new ItemStack(infuscoliumOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(infuscoliumOreItem, 1, i)});
			GameRegistry.addShapedRecipe(new ItemStack(kalendriteOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(kalendriteOreItem, 1, i)});
			GameRegistry.addShapedRecipe(new ItemStack(lemuriteOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(lemuriteOreItem, 1, i)});
			GameRegistry.addShapedRecipe(new ItemStack(manganeseOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(manganeseOreItem, 1, i)});
			GameRegistry.addShapedRecipe(new ItemStack(meutoiteOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(meutoiteOreItem, 1, i)});
			GameRegistry.addShapedRecipe(new ItemStack(midasiumOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(midasiumOreItem, 1, i)});
			GameRegistry.addShapedRecipe(new ItemStack(mithrilOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(mithrilOreItem, 1, i)});
			GameRegistry.addShapedRecipe(new ItemStack(orichalcumOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(orichalcumOreItem, 1, i)});
			GameRegistry.addShapedRecipe(new ItemStack(oureclaseOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(oureclaseOreItem, 1, i)});
			GameRegistry.addShapedRecipe(new ItemStack(prometheumOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(prometheumOreItem, 1, i)});
			GameRegistry.addShapedRecipe(new ItemStack(rubraciumOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(adamantineOreItem, 1, i)});
			GameRegistry.addShapedRecipe(new ItemStack(sanguiniteOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(rubraciumOreItem, 1, i)});
			GameRegistry.addShapedRecipe(new ItemStack(shadowironOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(shadowironOreItem, 1, i)});
			GameRegistry.addShapedRecipe(new ItemStack(vulcaniteOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(vulcaniteOreItem, 1, i)});
			GameRegistry.addShapedRecipe(new ItemStack(vyroxeresOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(vyroxeresOreItem, 1, i)});
			GameRegistry.addShapedRecipe(new ItemStack(zincOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(zincOreItem, 1, i)});
		}
	}
}
