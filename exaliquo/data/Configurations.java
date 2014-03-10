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
	public static int thaumHammer;
	public static int invarHammer;
	public static int reedCrook;
	public static boolean ninjaFeesh;
	
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
		
		isOre = config.get("TCon Tweaks", "Are Gravel/Sand/Dust Ores actually ores", true, "False for counting as an ingot").getBoolean(true);
		allowDustSmelting = config.get("TCon Tweaks", "Can Gravel/Sand/Dust items be smelted", true).getBoolean(true);
		dustValue = config.get("TCon Tweaks", "Normal dust value in the smeltery", true, "Normal is 1/4 the block value. False means dusts are 1/6 the value").getBoolean(true);
		sieveOreBushes = config.get("TCon Tweaks", "Can orebushes be obtained", true).getBoolean(true);
		sieveEssenceBushes = config.get("TCon Tweaks","Can essense bushes be obtained", true).getBoolean(true);
		sieveNetherOres = config.get("TCon Tweaks", "Can nether ores be obtained", true).getBoolean(true);
		allowTinkerBushCompost = config.get("TCon Tweaks", "Can oreberry bushes be composted", false).getBoolean(false);
		miniSmelting = config.get("TCon Tweaks", "Enable mini-smelteries", false).getBoolean(false);
		
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
		
		thaumHammer = config.get("Ex Aliquo things","Thaumium Hammer ID", 20160).getInt(20160);
		invarHammer = config.get("Ex Aliquo things","Invar Hammer ID", 20161).getInt(20161);
		reedCrook = config.get("Ex Aliquo things","Reed Crook", 20300).getInt(20300);
		ninjaFeesh = config.get("Ex Aliquo things","Hide Feesh from hammers",true).getBoolean(true);
		
		
		config.save();
	}
}
