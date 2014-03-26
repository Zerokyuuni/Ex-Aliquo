package exaliquo.data;

import java.io.File;
import java.io.IOException;

import net.minecraftforge.common.Configuration;

public class Configurations {

	public static boolean WYNAUT;
	public static boolean isOre;
	public static boolean allowDustSmelting;
	public static boolean dustValue;
	public static boolean sieveOreBushes;
	public static boolean sieveEssenceBushes;
	public static boolean sieveNetherOres;
	public static int dualTools;
	public static boolean sieveRedwoods;
	public static boolean sieveHopseed;
	public static boolean sieveOverworldTrees;
	public static boolean allowTinkerBushCompost;
	public static boolean sieveNetherTrees;
	public static boolean sieveBerryBushes;
	public static boolean sieveDarkBerries;
	public static boolean hammerMoonstone;
	public static boolean sieveNovas;
	public static boolean miniSmelting;
	public static int silverwoodSwitch;
	public static boolean alternatewater;
	public static boolean runichax;
	public static boolean fishingOysters;
	public static boolean endOverride;
	public static boolean sacredohgodthewood;
	public static int thaumHammer;
	public static int invarHammer;
	public static int reedCrook;
	public static int goldCrook;
	public static boolean ninjaFeesh;
	public static boolean hammerNetherOres;
	public static boolean whenk;
	
	public static int cobaltOreBlock;
	public static int arditeOreBlock;
	public static int adamantineOreBlock;
	public static int alduoriteOreBlock;
	public static int astralsilverOreBlock;
	public static int atlarusOreBlock;
	public static int carmotOreBlock;
	public static int ceruclaseOreBlock;
	public static int deepironOreBlock;
	public static int eximiteOreBlock;
	public static int ignatiusOreBlock;
	public static int infuscoliumOreBlock;
	public static int kalendriteOreBlock;
	public static int lemuriteOreBlock;
	public static int manganeseOreBlock;
	public static int meuroiteOreBlock;
	public static int midasiumOreBlock;
	public static int mithrilOreBlock;
	public static int orichalcumOreBlock;
	public static int oureclaseOreBlock;
	public static int prometheumOreBlock;
	public static int rubraciumOreBlock;
	public static int sanguiniteOreBlock;
	public static int shadowironOreBlock;
	public static int vulcaniteOreBlock;
	public static int vyroxeresOreBlock;
	public static int zincOreBlock;
	
	public static int cobaltOreItem;
	public static int arditeOreItem;
	public static int adamantineOreItem;
	public static int alduoriteOreItem;
	public static int astralsilverOreItem;
	public static int atlarusOreItem;
	public static int carmotOreItem;
	public static int ceruclaseOreItem;
	public static int deepironOreItem;
	public static int eximiteOreItem;
	public static int ignatiusOreItem;
	public static int infuscoliumOreItem;
	public static int kalendriteOreItem;
	public static int lemuriteOreItem;
	public static int manganeseOreItem;
	public static int meuroiteOreItem;
	public static int midasiumOreItem;
	public static int mithrilOreItem;
	public static int orichalcumOreItem;
	public static int oureclaseOreItem;
	public static int prometheumOreItem;
	public static int rubraciumOreItem;
	public static int sanguiniteOreItem;
	public static int shadowironOreItem;
	public static int vulcaniteOreItem;
	public static int vyroxeresOreItem;
	public static int zincOreItem;
	public static boolean registerTConstruct;
	public static boolean registerMetallurgy;
	
	public static void Load (File location)
	{
		File file = new File(location + "/exaliquo.cfg");
		
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Configuration config = new Configuration(file);
		config.load();
		
		allowDustSmelting = config.get("TCon Tweaks", "Can Gravel/Sand/Dust items be smelted", true).getBoolean(true);
		dustValue = config.get("TCon Tweaks", "Normal dust value in the smeltery", true, "Normal is 1/4 the block value. False means dusts are 1/6 the value").getBoolean(true);
		sieveOreBushes = config.get("TCon Tweaks", "Can orebushes be obtained", true).getBoolean(true);
		sieveEssenceBushes = config.get("TCon Tweaks","Can essense bushes be obtained", true).getBoolean(true);
		sieveNetherOres = config.get("TCon Tweaks", "Can nether ores be obtained", true, "Without Tinker's Construct installed, this can be used to get the Gravel/Sand/Dust for decorative purposes").getBoolean(true);
		allowTinkerBushCompost = config.get("TCon Tweaks", "Can oreberry bushes be composted", false).getBoolean(false);
		miniSmelting = config.get("TCon Tweaks", "Enable mini-smelteries", false).getBoolean(false);
		dualTools = config.get("TCon Tweaks", "Modifier lock", 0, "0 is default (tool restrictions), 1 is dual-use tools unrestricted, 2 is fully unlock").getInt(0);
		
		sieveRedwoods = config.get("Natura Tweaks", "Can redwood trees be obtained", false, "Redwoods eat every block going both up and down. Use at your own peril. Or enjoyment").getBoolean(false);
		sieveHopseed = config.get("Natura Tweaks", "Can hopseed trees be obtained", false).getBoolean(false);
		sieveOverworldTrees = config.get("Natura Tweaks", "Can natura trees be obtained", true).getBoolean(true);
		sieveNetherTrees = config.get("Natura Tweaks", "Can nether trees be obtained", true).getBoolean(true);
		sieveBerryBushes = config.get("Natura Tweaks", "Can berry bushes be obtained", true).getBoolean(true);
		sieveDarkBerries = config.get("Natura Tweaks", "Can nether bushes be obtained", true).getBoolean(true);
		
		hammerMoonstone = config.get("ArsMagica Tweaks", "Can moonstone be obtained", false).getBoolean(false);
		sieveNovas = config.get("ArsMagica Tweaks", "Can desert novas be obtained", true).getBoolean(true);
		
		WYNAUT = config.get("ArsMagica Tweaks","TinkerBridge", true).getBoolean(true);
		
		silverwoodSwitch = config.get("Thaumcraft Tweaks", "Silverwood Setting", 0, "Set 0 for default, 1 for tweaked difficulty, and -1 to disable. See the forum post for difficulty changes").getInt(0);
		alternatewater = config.get("Thaumcraft Tweaks", "For tundra-less skyblocks", false).getBoolean(false);
		runichax = config.get("Thaumcraft Tweaks", "Alternate Runics to prevent wall", true, "False to instead change how greatwoods are obtained").getBoolean(false);
		
		fishingOysters = config.get("Mariculture Tweaks", "Can Oysters be obtained via fishing", true).getBoolean(true);
		endOverride = config.get("Mariculture Tweaks", "Override end-only fishables", true).getBoolean(true);
		
		sacredohgodthewood = config.get("MineFactory Reloaded Tweaks","Can Sacred Rubber Trees be obtained", false).getBoolean(false);
		
		thaumHammer = config.get("Ex Aliquo things","Thaumium Hammer ID", 20160).getInt(20160);
		invarHammer = config.get("Ex Aliquo things","Invar Hammer ID", 20161).getInt(20161);
		reedCrook = config.get("Ex Aliquo things","Reed Crook", 20300).getInt(20300);
		goldCrook = config.get("Ex Aliquo things","Golden Crook", 20301).getInt(20301);
		
		registerMetallurgy = config.get("Metallurgy Things", "Load ExMetallurgy ores anyway", false, "Only used to get the Gravel/Sand/Dust for decorative purposes").getBoolean(false);
		
		cobaltOreBlock = config.get("TCon Block IDs", "CobaltOre Block", 2300).getInt(2300);
		arditeOreBlock = config.get("TCon Block IDs", "ArditeOre Block", 2301).getInt(2301);
		adamantineOreBlock = config.get("Metallurgy Block IDs","AdamantineOre Block",2302).getInt(2302);
		alduoriteOreBlock = config.get("Metallurgy Block IDs","AlduoriteOre Block",2303).getInt(2303);
		astralsilverOreBlock = config.get("Metallurgy Block IDs","AstralSilverOre Block",2304).getInt(2304);
		atlarusOreBlock = config.get("Metallurgy Block IDs","AtlarusOre Block",2305).getInt(2305);
		carmotOreBlock = config.get("Metallurgy Block IDs","CarmotOre Block",2306).getInt(2306);
		ceruclaseOreBlock = config.get("Metallurgy Block IDs","CeruclaseOre Block",2307).getInt(2307);
		deepironOreBlock = config.get("Metallurgy Block IDs","DeepIronOre Block",2308).getInt(2308);
		eximiteOreBlock = config.get("Metallurgy Block IDs","EximiteOre Block",2309).getInt(2309);
		ignatiusOreBlock = config.get("Metallurgy Block IDs","IgnatiusOre Block",2310).getInt(2310);
		infuscoliumOreBlock = config.get("Metallurgy Block IDs","InfucoliumOre Block",2311).getInt(2311);
		kalendriteOreBlock = config.get("Metallurgy Block IDs","KalendriteOre Block",2312).getInt(2312);
		lemuriteOreBlock = config.get("Metallurgy Block IDs","LemuriteOre Block",2313).getInt(2313);
		manganeseOreBlock = config.get("Metallurgy Block IDs","ManganeseOre Block",2314).getInt(2314);
		meuroiteOreBlock = config.get("Metallurgy Block IDs","MeuroiteOre Block",2315).getInt(2315);
		midasiumOreBlock = config.get("Metallurgy Block IDs","MidasiumOre Block",2316).getInt(2316);
		mithrilOreBlock = config.get("Metallurgy Block IDs","MithrilOre Block",2317).getInt(2317);
		orichalcumOreBlock = config.get("Metallurgy Block IDs","OrichalcumOre Block",2318).getInt(2318);
		oureclaseOreBlock = config.get("Metallurgy Block IDs","OureclaseOre Block",2319).getInt(2319);
		prometheumOreBlock = config.get("Metallurgy Block IDs","PromethiumOre Block",2320).getInt(2320);
		rubraciumOreBlock = config.get("Metallurgy Block IDs","RubraciumOre Block",2321).getInt(2321);
		sanguiniteOreBlock = config.get("Metallurgy Block IDs","SanguiniteOre Block",2322).getInt(2322);
		shadowironOreBlock = config.get("Metallurgy Block IDs","ShadowIronOre Block",2323).getInt(2323);
		vulcaniteOreBlock = config.get("Metallurgy Block IDs","VulcaniteOre Block",2324).getInt(2324);
		vyroxeresOreBlock = config.get("Metallurgy Block IDs","VyroxeresOre Block",2325).getInt(2325);
		zincOreBlock = config.get("Metallurgy Block IDs","ZincOre Block",2326).getInt(2326);
		
		cobaltOreItem = config.get("TCon Item IDs", "CobaltOre Item", 20500).getInt(20500);
		arditeOreItem = config.get("TCon Item IDs", "ArditeOre Item", 20501).getInt(20501);
		adamantineOreItem = config.get("Metallurgy Item IDs","AdamantineOre Item", 20502).getInt(20502);
		alduoriteOreItem = config.get("Metallurgy Item IDs","AlduoriteOre Item", 20503).getInt(20503);
		astralsilverOreItem = config.get("Metallurgy Item IDs","AstralSilverOre Item", 20504).getInt(20504);
		atlarusOreItem = config.get("Metallurgy Item IDs","AtlarusOre Item", 20505).getInt(20505);
		carmotOreItem = config.get("Metallurgy Item IDs","CarmotOre Item", 20506).getInt(20506);
		ceruclaseOreItem = config.get("Metallurgy Item IDs","CeruclaseOre Item", 20507).getInt(20507);
		deepironOreItem = config.get("Metallurgy Item IDs","DeepIronOre Item", 20508).getInt(20508);
		eximiteOreItem = config.get("Metallurgy Item IDs","EximiteOre Item", 20509).getInt(20509);
		ignatiusOreItem = config.get("Metallurgy Item IDs","IgnatiusOre Item", 20510).getInt(20510);
		infuscoliumOreItem = config.get("Metallurgy Item IDs","InfuscoliumOre Item", 20511).getInt(20511);
		kalendriteOreItem = config.get("Metallurgy Item IDs","KalendriteOre Item", 20512).getInt(20512);
		lemuriteOreItem = config.get("Metallurgy Item IDs","LemuriteOre Item", 20513).getInt(20513);
		manganeseOreItem = config.get("Metallurgy Item IDs","ManganeseOre Item", 20514).getInt(20514);
		meuroiteOreItem = config.get("Metallurgy Item IDs","MeuroiteOre Item", 20515).getInt(20515);
		midasiumOreItem = config.get("Metallurgy Item IDs","MidasiumOre Item", 20516).getInt(20516);
		mithrilOreItem = config.get("Metallurgy Item IDs","MithrilOre Item", 20517).getInt(20517);
		orichalcumOreItem = config.get("Metallurgy Item IDs","OrichalcumOre Item", 20518).getInt(20518);
		oureclaseOreItem = config.get("Metallurgy Item IDs","OureclaseOre Item", 20519).getInt(20519);
		prometheumOreItem = config.get("Metallurgy Item IDs","PrometheumOre Item", 20520).getInt(20520);
		rubraciumOreItem = config.get("Metallurgy Item IDs","RubraciumOre Item", 20521).getInt(20521);
		sanguiniteOreItem = config.get("Metallurgy Item IDs","SanguiniteOre Item", 20522).getInt(20522);
		shadowironOreItem = config.get("Metallurgy Item IDs","ShadowIronOre Item", 20523).getInt(20523);
		vulcaniteOreItem = config.get("Metallurgy Item IDs","VulcaniteOre Item", 20524).getInt(20524);
		vyroxeresOreItem = config.get("Metallurgy Item IDs","VyroxeresOre Item", 20525).getInt(20525);
		zincOreItem = config.get("Metallurgy Item IDs","ZincOre Item", 20526).getInt(20526);
		
		ninjaFeesh = config.get("Ex Aliquo multi-mod tweaks","Hide Feesh from hammers",true).getBoolean(true);
		isOre = config.get("Ex Aliquo multi-mod tweaks", "Are Gravel/Sand/Dust Ores actually ores", true, "False for counting as an ingot").getBoolean(true);
		hammerNetherOres = config.get("Ex Aliquo multi-mod tweaks", "Does the hammer work on ores in the nether", true).getBoolean(true);
		whenk = config.get("Ex Aliquo multi-mod tweaks", "Whenk :V", true, "Requires ninja-like feesh to do anything").getBoolean(true);
		
		config.save();
	}
}
