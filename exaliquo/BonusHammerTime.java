package exaliquo;

import cpw.mods.fml.common.Loader;
import net.minecraft.block.Block;
import net.minecraftforge.oredict.OreDictionary;
import exnihilo.registries.HammerRegistry;

import static exaliquo.data.ModIDs.getIDs;
import exaliquo.data.Configurations;
import exaliquo.data.ModIDs.Info;

public class BonusHammerTime {

	private static final int stone = Block.stone.blockID;
	private static final int stonebrick = Block.stoneBrick.blockID;
	private static final int netherrack = Block.netherrack.blockID;
	private static final int sandstone = Block.stoneDoubleSlab.blockID;
	private static final int ice = Block.ice.blockID;
	private static final int grass = Block.grass.blockID;
	private static final int obsidian = Block.obsidian.blockID;
	private static final int winthatfight = Block.tnt.blockID;
	private static final int clay = Block.blockClay.blockID;
	
	public static void addArstoMCHammer()
	{
		HammerRegistry.register(stone, 0, getIDs(Info.magicore), 0, 0.15F, 0.05F);		//Vinteum
		HammerRegistry.register(stone, 0, getIDs(Info.magicore), 4, 0.1F, 0.05F);		//Chimerite
		HammerRegistry.register(stone, 0, getIDs(Info.magicore), 5, 0.08F, 0.05F);		//Blue Topaz
		if (Configurations.hammerMoonstone)
		{
		HammerRegistry.register(stone, 0, getIDs(Info.magicore), 7, 0.05F, 0.05F);		//Moonstone
		}
		HammerRegistry.register(netherrack, 0, getIDs(Info.magicore), 6, 0.05F, 0.05F);	//Sunstone		
	}

	public static void addThaumcraftToMCHammer()
	{
		int watershard = (Configurations.alternatewater) ? clay : ice; 
		HammerRegistry.register(sandstone, 1, getIDs(Info.shard), 0, 0.1F, 0.03F);
		HammerRegistry.register(netherrack, 0, getIDs(Info.shard), 1, 0.1F, 0.03F);
		HammerRegistry.register(watershard, 0, getIDs(Info.shard), 2, 0.1F, 0.03F);
		HammerRegistry.register(grass, 0, getIDs(Info.shard), 3, 0.1F, 0.03F);
		HammerRegistry.register(obsidian, 0, getIDs(Info.shard), 4, 0.25F, 0.05F);
		HammerRegistry.register(winthatfight, 0, getIDs(Info.shard), 5, 0.15F, 0.05F);
		if (Loader.isModLoaded("NetherOres") && Configurations.ninjaFeesh)
		{
			HammerRegistry.register(getIDs(Info.hellfeesh), 0, 0, 0, 0.0F, 0.0F);
		}
	}
}
