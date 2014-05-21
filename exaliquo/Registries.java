package exaliquo;

import static exaliquo.data.ModIDs.getBlock;

import org.lwjgl.opengl.Display;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

import exaliquo.blocks.*;
import exaliquo.bridges.TConstruct.SkyModifiers;
import exaliquo.bridges.TConstruct.Modifiers.ModCrooked;
import exaliquo.bridges.TConstruct.Modifiers.ModHammered;
import exaliquo.data.AliquoMaterial;
import exaliquo.data.Configurations;
import exaliquo.data.ExAOreTab;
import exaliquo.data.ExATab;
import exaliquo.data.OreDict;
import static exaliquo.data.ModIDs.getItem;
import exaliquo.data.ModIDs.Info;
import exaliquo.items.AliquoHammer;
import exaliquo.items.AliquoItemOre;
import exaliquo.items.DragonEgg;
import exaliquo.items.GoldCrook;
import exaliquo.items.HayCrook;
import exaliquo.items.ReedCrook;
import exaliquo.items.ThaumiumHammer;
import exaliquo.items.blocks.ItemBlockOre;
import exaliquo.data.ModsLoaded;

public class Registries
{
	public static ExATab exatab;
	public static ExAOreTab oretab;
	
	private static String[] hammershape = { " i ", " si", "s  " };
	private static String[] crookshape = { "ii", " i", " i" };
	public static String[] oreType = { "Gravel","Sand","Dust" };
	private static String[] oreshape = { "ii", "ii" };
	public static Item hammerThaum;
	public static Item hammerInvar;
	public static Item hammerCopper;
	public static Item hammerTin;
	public static Item hammerSilver;
	public static Item hammerLead;
	public static Item hammerPlatinum;
	public static Item hammerNickel;
	public static Item hammerAluminum;
	public static Item crookReed;
	public static Item crookGold;
	public static Item crookHay;
	public static Item dragonEgg;
	
	public static Block blockEndEye;
	public static Block blockEndCake;
	
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
	
	public static void registerItems()
	{
		if (ModsLoaded.isThaumcraftLoaded)
		{
			hammerThaum = new ThaumiumHammer(Configurations.thaumHammer).setUnlocalizedName("ExAliquo.ThaumHammer").registerItem().setCreativeTab(exatab);
		}
		hammerInvar = new AliquoHammer(Configurations.invarHammer, "invar").registerItem().setCreativeTab(exatab);
		hammerCopper = new AliquoHammer(Configurations.copperHammer, "copper").registerItem().setCreativeTab(exatab);
		hammerTin = new AliquoHammer(Configurations.tinHammer, "tin").registerItem().setCreativeTab(exatab);
		hammerSilver = new AliquoHammer(Configurations.silverHammer, "silver").registerItem().setCreativeTab(exatab);
		hammerLead = new AliquoHammer(Configurations.leadHammer, "lead").registerItem().setCreativeTab(exatab);
		hammerPlatinum = new AliquoHammer(Configurations.platinumHammer, "platinum").registerItem().setCreativeTab(exatab);
		hammerNickel = new AliquoHammer(Configurations.nickelHammer, "nickel").registerItem().setCreativeTab(exatab);
		hammerAluminum = new AliquoHammer(Configurations.aluminumHammer, "aluminum").registerItem().setCreativeTab(exatab);
		
		crookReed = new ReedCrook(Configurations.reedCrook).setUnlocalizedName("ExAliquo.ReedCrook").setCreativeTab(exatab);
		GameRegistry.registerItem(crookReed, "ExAliquo.ReedCrook");
		crookGold = new GoldCrook(Configurations.goldCrook).setUnlocalizedName("ExAliquo.GoldCrook").setCreativeTab(exatab);
		GameRegistry.registerItem(crookGold, "ExAliquo.GoldCrook");
		crookHay = new HayCrook(Configurations.hayCrook).setUnlocalizedName("ExAliquo.HayCrook").setCreativeTab(exatab);
		GameRegistry.registerItem(crookHay, "ExAliquo.HayCrook");
		dragonEgg = new DragonEgg(Configurations.dragonEgg).setUnlocalizedName("ExAliquo.DragonEgg").setCreativeTab(exatab);
		GameRegistry.registerItem(dragonEgg, "ExAliquo.DragonEgg");
		
		registerOreItems();
	}
	
	public static void registerBlocks()
	{
		blockEndEye = new BlockEndEye(Configurations.blockEndEye).setUnlocalizedName("EndEye").setCreativeTab(exatab);
		GameRegistry.registerBlock(blockEndEye, "ExAliquo.EndEye");
		blockEndCake = new BlockEndCake(Configurations.blockEndCake).setUnlocalizedName("EndCake").setCreativeTab(exatab);
		GameRegistry.registerBlock(blockEndCake, "ExAliquo.EndCake");
		
		OreDictionary.registerOre("blockEnder", blockEndEye);
		
		registerOres();
	}
	
	static void registerOres()
	{
		cobaltOreBlock = new AliquoOre(Configurations.cobaltOreBlock).setUnlocalizedName("Cobalt");
		GameRegistry.registerBlock(cobaltOreBlock, ItemBlockOre.class, "ExAliquo.CobaltOreBlock");
		arditeOreBlock = new AliquoOre(Configurations.arditeOreBlock).setUnlocalizedName("Ardite");
		GameRegistry.registerBlock(arditeOreBlock, ItemBlockOre.class, "ExAliquo.ArditeOreBlock");
		
		adamantineOreBlock = new AliquoOre(Configurations.adamantineOreBlock).setUnlocalizedName("Adamantine").setCreativeTab(exatab);
		GameRegistry.registerBlock(adamantineOreBlock, ItemBlockOre.class, "ExAliquo.AdamantineOreBlock");
		alduoriteOreBlock = new AliquoOre(Configurations.alduoriteOreBlock).setUnlocalizedName("Alduorite");
		GameRegistry.registerBlock(alduoriteOreBlock, ItemBlockOre.class, "ExAliquo.AlduoriteOreBlock");
		astralsilverOreBlock = new AliquoOre(Configurations.astralsilverOreBlock).setUnlocalizedName("AstralSilver");
		GameRegistry.registerBlock(astralsilverOreBlock, ItemBlockOre.class, "ExAliquo.AstralSilverOreBlock");
		atlarusOreBlock = new AliquoOre(Configurations.atlarusOreBlock).setUnlocalizedName("Atlarus");
		GameRegistry.registerBlock(atlarusOreBlock, ItemBlockOre.class, "ExAliquo.AtlarusOreBlock");
		carmotOreBlock = new AliquoOre(Configurations.carmotOreBlock).setUnlocalizedName("Carmot");
		GameRegistry.registerBlock(carmotOreBlock, ItemBlockOre.class, "ExAliquo.CarmotOreBlock");
		ceruclaseOreBlock = new AliquoOre(Configurations.ceruclaseOreBlock).setUnlocalizedName("Ceruclase");
		GameRegistry.registerBlock(ceruclaseOreBlock, ItemBlockOre.class, "ExAliquo.CeruclaseOreBlock");
		deepironOreBlock = new AliquoOre(Configurations.deepironOreBlock).setUnlocalizedName("DeepIron");
		GameRegistry.registerBlock(deepironOreBlock, ItemBlockOre.class, "ExAliquo.DeepIronOreBlock");
		eximiteOreBlock = new AliquoOre(Configurations.eximiteOreBlock).setUnlocalizedName("Eximite");
		GameRegistry.registerBlock(eximiteOreBlock, ItemBlockOre.class, "ExAliquo.EximiteOreBlock");
		ignatiusOreBlock = new AliquoOre(Configurations.ignatiusOreBlock).setUnlocalizedName("Ignatius");
		GameRegistry.registerBlock(ignatiusOreBlock, ItemBlockOre.class, "ExAliquo.IgnatiusOreBlock");
		infuscoliumOreBlock = new AliquoOre(Configurations.infuscoliumOreBlock).setUnlocalizedName("Infuscolium");
		GameRegistry.registerBlock(infuscoliumOreBlock, ItemBlockOre.class, "ExAliquo.InfuscoliumOreBlock");
		kalendriteOreBlock = new AliquoOre(Configurations.kalendriteOreBlock).setUnlocalizedName("Kalendrite");
		GameRegistry.registerBlock(kalendriteOreBlock, ItemBlockOre.class, "ExAliquo.KalendriteOreBlock");
		lemuriteOreBlock = new AliquoOre(Configurations.lemuriteOreBlock).setUnlocalizedName("Lemurite");
		GameRegistry.registerBlock(lemuriteOreBlock, ItemBlockOre.class, "ExAliquo.LemuriteOreBlock");
		manganeseOreBlock = new AliquoOre(Configurations.manganeseOreBlock).setUnlocalizedName("Manganese");
		GameRegistry.registerBlock(manganeseOreBlock, ItemBlockOre.class, "Exaliquo.ManganeseOreBlock");
		meutoiteOreBlock = new AliquoOre(Configurations.meutoiteOreBlock).setUnlocalizedName("Meutoite");
		GameRegistry.registerBlock(meutoiteOreBlock, ItemBlockOre.class, "ExAliquo.MeuroiteOreBlock");
		midasiumOreBlock = new AliquoOre(Configurations.midasiumOreBlock).setUnlocalizedName("Midasium");
		GameRegistry.registerBlock(midasiumOreBlock, ItemBlockOre.class, "ExAliquo.MidasiumOreBlock");
		mithrilOreBlock = new AliquoOre(Configurations.mithrilOreBlock).setUnlocalizedName("Mithril");
		GameRegistry.registerBlock(mithrilOreBlock, ItemBlockOre.class, "ExAliquo.MithrilOreBlock");
		orichalcumOreBlock = new AliquoOre(Configurations.orichalcumOreBlock).setUnlocalizedName("Orichalcum");
		GameRegistry.registerBlock(orichalcumOreBlock, ItemBlockOre.class, "ExAliquo.OrichalcumOreBlock");
		oureclaseOreBlock = new AliquoOre(Configurations.oureclaseOreBlock).setUnlocalizedName("Oureclase");
		GameRegistry.registerBlock(oureclaseOreBlock, ItemBlockOre.class, "ExAliquo.OureclaseOreBlock");
		prometheumOreBlock = new AliquoOre(Configurations.prometheumOreBlock).setUnlocalizedName("Prometheum");
		GameRegistry.registerBlock(prometheumOreBlock, ItemBlockOre.class, "ExAliquo.PromethiumOreBlock");
		rubraciumOreBlock = new AliquoOre(Configurations.rubraciumOreBlock).setUnlocalizedName("Rubracium");
		GameRegistry.registerBlock(rubraciumOreBlock, ItemBlockOre.class, "ExAliquo.RubraciumOreBlock");
		sanguiniteOreBlock = new AliquoOre(Configurations.sanguiniteOreBlock).setUnlocalizedName("Sanguinite");
		GameRegistry.registerBlock(sanguiniteOreBlock, ItemBlockOre.class, "ExAliquo.SanguinuteOreBlock");
		shadowironOreBlock = new AliquoOre(Configurations.shadowironOreBlock).setUnlocalizedName("ShadowIron");
		GameRegistry.registerBlock(shadowironOreBlock, ItemBlockOre.class, "ExAliquo.ShadowIronOreBlock");
		vulcaniteOreBlock = new AliquoOre(Configurations.vulcaniteOreBlock).setUnlocalizedName("Vulcanite");
		GameRegistry.registerBlock(vulcaniteOreBlock, ItemBlockOre.class, "ExAliquo.VulcaniteOreBlock");
		vyroxeresOreBlock = new AliquoOre(Configurations.vyroxeresOreBlock).setUnlocalizedName("Vyroxeres");
		GameRegistry.registerBlock(vyroxeresOreBlock, ItemBlockOre.class, "ExAliquo.VyroxeresOreBlock");
		zincOreBlock = new AliquoOre(Configurations.zincOreBlock).setUnlocalizedName("Zinc");
		GameRegistry.registerBlock(zincOreBlock, ItemBlockOre.class, "ExAliquo.ZincOreBlock");
	}
	
	static void registerOreItems()
	{
		cobaltOreItem = new AliquoItemOre(Configurations.cobaltOreItem).setUnlocalizedName("ExAliquo.OreCobaltItem");
		GameRegistry.registerItem(cobaltOreItem, "ExAliquo.OreCobaltItem");
		arditeOreItem = new AliquoItemOre(Configurations.arditeOreItem).setUnlocalizedName("ExAliquo.OreArditeItem");
		GameRegistry.registerItem(arditeOreItem, "ExAliquo.OreArditeItem");
		
		adamantineOreItem = new AliquoItemOre(Configurations.adamantineOreItem).setUnlocalizedName("ExAliquo.OreAdamantiumItem");
		GameRegistry.registerItem(adamantineOreItem, "ExAliquo.OreAdamantineItem");
		alduoriteOreItem = new AliquoItemOre(Configurations.alduoriteOreItem).setUnlocalizedName("ExAliquo.OreAlduoriteItem");
		GameRegistry.registerItem(alduoriteOreItem, "ExAliquo.OreAlduoriteItem");
		astralsilverOreItem = new AliquoItemOre(Configurations.astralsilverOreItem).setUnlocalizedName("ExAliquo.OreAstralSilverItem");
		GameRegistry.registerItem(astralsilverOreItem, "ExAliquo.OreAstralSilverItem");
		atlarusOreItem = new AliquoItemOre(Configurations.atlarusOreItem).setUnlocalizedName("ExAliquo.OreAtlarusItem");
		GameRegistry.registerItem(atlarusOreItem, "ExAliquo.OreAtlarusItem");
		carmotOreItem = new AliquoItemOre(Configurations.carmotOreItem).setUnlocalizedName("ExAliquo.OreCarmotItem");
		GameRegistry.registerItem(carmotOreItem, "ExAliquo.CarmotOreItem");
		ceruclaseOreItem = new AliquoItemOre(Configurations.ceruclaseOreItem).setUnlocalizedName("ExAliquo.OreCeruclaseItem");
		GameRegistry.registerItem(ceruclaseOreItem, "ExAliquo.CeruclaseOreItem");
		deepironOreItem = new AliquoItemOre(Configurations.deepironOreItem).setUnlocalizedName("ExAliquo.OreDeepIronItem");
		GameRegistry.registerItem(deepironOreItem, "ExAliquo.DeepIronOreItem");
		eximiteOreItem = new AliquoItemOre(Configurations.eximiteOreItem).setUnlocalizedName("ExAliquo.OreEximiteItem");
		GameRegistry.registerItem(eximiteOreItem, "ExAliquo.EximiteOreItem");
		ignatiusOreItem = new AliquoItemOre(Configurations.ignatiusOreItem).setUnlocalizedName("ExAliquo.OreIgnatiusItem");
		GameRegistry.registerItem(ignatiusOreItem, "ExAliquo.IgnatiusOreItem");
		infuscoliumOreItem = new AliquoItemOre(Configurations.infuscoliumOreItem).setUnlocalizedName("ExAliquo.OreInfuscoliumItem");
		GameRegistry.registerItem(infuscoliumOreItem, "ExAliquo.InfuscoliumOreItem");
		kalendriteOreItem = new AliquoItemOre(Configurations.kalendriteOreItem).setUnlocalizedName("ExAliquo.OreKalendriteItem");
		GameRegistry.registerItem(kalendriteOreItem, "ExAliquo.KalendriteOreItem");
		lemuriteOreItem = new AliquoItemOre(Configurations.lemuriteOreItem).setUnlocalizedName("ExAliquo.OreLemuriteItem");
		GameRegistry.registerItem(lemuriteOreItem, "ExAliquo.LemuriteOreItem");
		manganeseOreItem = new AliquoItemOre(Configurations.manganeseOreItem).setUnlocalizedName("ExAliquo.OreManganeseItem");
		GameRegistry.registerItem(manganeseOreItem, "Exaliquo.ManganeseOreItem");
		meutoiteOreItem = new AliquoItemOre(Configurations.meutoiteOreItem).setUnlocalizedName("ExAliquo.OreMeuroiteItem");
		GameRegistry.registerItem(meutoiteOreItem, "ExAliquo.MeuroiteOreItem");
		midasiumOreItem = new AliquoItemOre(Configurations.midasiumOreItem).setUnlocalizedName("ExAliquo.OreMidasiumItem");
		GameRegistry.registerItem(midasiumOreItem, "ExAliquo.MidasiumOreItem");
		mithrilOreItem = new AliquoItemOre(Configurations.mithrilOreItem).setUnlocalizedName("ExAliquo.OreMithrilItem");
		GameRegistry.registerItem(mithrilOreItem, "ExAliquo.MithrilOreItem");
		orichalcumOreItem = new AliquoItemOre(Configurations.orichalcumOreItem).setUnlocalizedName("ExAliquo.OreOrichalcumItem");
		GameRegistry.registerItem(orichalcumOreItem, "ExAliquo.OrichalcumOreItem");
		oureclaseOreItem = new AliquoItemOre(Configurations.oureclaseOreItem).setUnlocalizedName("ExAliquo.OreOureclaseItem");
		GameRegistry.registerItem(oureclaseOreItem, "ExAliquo.OureclaseOreItem");
		prometheumOreItem = new AliquoItemOre(Configurations.prometheumOreItem).setUnlocalizedName("ExAliquo.OrePrometheumItem");
		GameRegistry.registerItem(prometheumOreItem, "ExAliquo.PromethiumOreItem");
		rubraciumOreItem = new AliquoItemOre(Configurations.rubraciumOreItem).setUnlocalizedName("ExAliquo.OreRubraciumItem");
		GameRegistry.registerItem(rubraciumOreItem, "ExAliquo.RubraciumOreItem");
		sanguiniteOreItem = new AliquoItemOre(Configurations.sanguiniteOreItem).setUnlocalizedName("ExAliquo.OreSanguiniteItem");
		GameRegistry.registerItem(sanguiniteOreItem, "ExAliquo.SanguinuteOreItem");
		shadowironOreItem = new AliquoItemOre(Configurations.shadowironOreItem).setUnlocalizedName("ExAliquo.OreShadowIronItem");
		GameRegistry.registerItem(shadowironOreItem, "ExAliquo.ShadowIronOreItem");
		vulcaniteOreItem = new AliquoItemOre(Configurations.vulcaniteOreItem).setUnlocalizedName("ExAliquo.OreVulcaniteItem");
		GameRegistry.registerItem(vulcaniteOreItem, "ExAliquo.VulcaniteOreItem");
		vyroxeresOreItem = new AliquoItemOre(Configurations.vyroxeresOreItem).setUnlocalizedName("ExAliquo.OreVyroxeresItem");
		GameRegistry.registerItem(vyroxeresOreItem, "ExAliquo.VyroxeresOreItem");
		zincOreItem = new AliquoItemOre(Configurations.zincOreItem).setUnlocalizedName("ExAliquo.OreZincItem");
		GameRegistry.registerItem(zincOreItem, "ExAliquo.ZincOreItem");
	}

	public static void registerRecipes()
	{
		GameRegistry.addShapedRecipe(new ItemStack(crookReed), new Object[] { crookshape, 'i', Item.reed });
		GameRegistry.addShapedRecipe(new ItemStack(crookGold), new Object[] { crookshape, 'i', Item.ingotGold });
		GameRegistry.addShapedRecipe(new ItemStack(crookHay), new Object[] { "wwi", "iwi", " w ", 'w', Item.wheat, 'i', Block.fenceIron });
		GameRegistry.addShapedRecipe(new ItemStack(Item.potion, 1, 0), new Object[] { "ccc", "cbc", "ccc", 'c', Block.cactus, 'b', Item.glassBottle });
		
		registerOreCrafting();
	}
	
	static void registerOreCrafting()
	{
		for (int i = 0; i < 3; i++)
		{
			GameRegistry.addShapedRecipe(new ItemStack(cobaltOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(cobaltOreItem, 1, i)});
			GameRegistry.addShapedRecipe(new ItemStack(arditeOreBlock, 1, i), new Object[] { oreshape, 'i', new ItemStack(arditeOreItem, 1, i)});
			
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
	
	public static void postInitHammers() {
		for (AliquoHammer hammer : AliquoHammer.registeredHammers()) {
			AliquoMaterial am = AliquoMaterial.get(hammer.material);
			
			EnumToolMaterial toolEnum = am.getToolEnumFromRecipe();
			if (toolEnum != null)
				GameRegistry.addRecipe(new ShapedOreRecipe(
						hammer,	hammershape, 's', "stickWood", 'i', hammer.getIngotName()));
			else
				toolEnum = am.getFallbackToolEnum();
			
			hammer.setToolMaterial(toolEnum);
		}
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
			OreDictionary.registerOre("oreAluminium", new ItemStack(getBlock(Info.aluminumore), 1, i));
		}
	}
}
