package exaliquo;

import java.io.File;
import java.io.IOException;

import net.minecraftforge.common.Configuration;

public class Configurations {

	public static boolean isOre;
	public static boolean allowDustSmelting;
	public static boolean sieveOreBushes;
	public static boolean sieveEssenceBushes;
	public static boolean sieveAluminum;
	public static boolean sieveNetherOres;
	
	public static void Load (File location)
	{
		File file = new File(location + "exaliquo.cfg");
		
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Configuration config = new Configuration(file);
		config.load();
		
		isOre = config.get("TCon Tweaks", "Are Gravel/Sand/Dust Ores actually ores", true, "False for counting as an ingot").getBoolean(true);
		allowDustSmelting = config.get("TCon Tweaks", "Can Gravel/Sand/Dust items be smelted", true).getBoolean(true);
		sieveAluminum = config.get("TCon Tweaks", "Can aluminum be obtained", true).getBoolean(true);
		sieveOreBushes = config.get("TCon Tweaks", "Can orebushes be obtained", true).getBoolean(true);
		sieveEssenceBushes = config.get("TCon Tweaks","Can essense bushes be obtained", true).getBoolean(true);
		sieveNetherOres = config.get("TCon Tweaks", "Can nether ores be obtained", true).getBoolean(true);
		
		
	}
}
