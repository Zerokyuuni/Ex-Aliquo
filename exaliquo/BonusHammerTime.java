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

	public static void addTinkerToMCHammer()
	{
		for (int i = 0; i < 2; i++)
		{
			HammerRegistry.registerOre(Registries.cobaltOreBlock.blockID, i, Registries.cobaltOreItem.itemID, i+1);
			HammerRegistry.registerOre(Registries.arditeOreBlock.blockID, i, Registries.arditeOreItem.itemID, i+1);
		}
	}

	public static void addMetallurgyToMCHammer()
	{
		for (int i = 0; i < 2; i++)
		{
			HammerRegistry.registerOre(Registries.adamantineOreBlock.blockID, i, Registries.adamantineOreItem.itemID, i+1);
			HammerRegistry.registerOre(Registries.alduoriteOreBlock.blockID, i, Registries.alduoriteOreItem.itemID, i+1);
			HammerRegistry.registerOre(Registries.astralsilverOreBlock.blockID, i, Registries.astralsilverOreItem.itemID, i+1);
			HammerRegistry.registerOre(Registries.atlarusOreBlock.blockID, i, Registries.atlarusOreItem.itemID, i+1);
			HammerRegistry.registerOre(Registries.carmotOreBlock.blockID, i, Registries.carmotOreItem.itemID, i+1);
			HammerRegistry.registerOre(Registries.ceruclaseOreBlock.blockID, i, Registries.ceruclaseOreItem.itemID, i+1);
			HammerRegistry.registerOre(Registries.deepironOreBlock.blockID, i, Registries.deepironOreItem.itemID, i+1);
			HammerRegistry.registerOre(Registries.eximiteOreBlock.blockID, i, Registries.eximiteOreItem.itemID, i+1);
			HammerRegistry.registerOre(Registries.ignatiusOreBlock.blockID, i, Registries.ignatiusOreItem.itemID, i+1);
			HammerRegistry.registerOre(Registries.infuscoliumOreBlock.blockID, i, Registries.infuscoliumOreItem.itemID, i+1);
			HammerRegistry.registerOre(Registries.kalendriteOreBlock.blockID, i, Registries.kalendriteOreItem.itemID, i+1);
			HammerRegistry.registerOre(Registries.lemuriteOreBlock.blockID, i, Registries.lemuriteOreItem.itemID, i+1);
			HammerRegistry.registerOre(Registries.manganeseOreBlock.blockID, i, Registries.manganeseOreItem.itemID, i+1);
			HammerRegistry.registerOre(Registries.meuroiteOreBlock.blockID, i, Registries.meuroiteOreItem.itemID, i+1);
			HammerRegistry.registerOre(Registries.midasiumOreBlock.blockID, i, Registries.midasiumOreItem.itemID, i+1);
			HammerRegistry.registerOre(Registries.mithrilOreBlock.blockID, i, Registries.mithrilOreItem.itemID, i+1);
			HammerRegistry.registerOre(Registries.orichalcumOreBlock.blockID, i, Registries.orichalcumOreItem.itemID, i+1);
			HammerRegistry.registerOre(Registries.oureclaseOreBlock.blockID, i, Registries.oureclaseOreItem.itemID, i+1);
			HammerRegistry.registerOre(Registries.prometheumOreBlock.blockID, i, Registries.prometheumOreItem.itemID, i+1);
			HammerRegistry.registerOre(Registries.rubraciumOreBlock.blockID, i, Registries.rubraciumOreItem.itemID, i+1);
			HammerRegistry.registerOre(Registries.sanguiniteOreBlock.blockID, i, Registries.sanguiniteOreItem.itemID, i+1);
			HammerRegistry.registerOre(Registries.shadowironOreBlock.blockID, i, Registries.shadowironOreItem.itemID, i+1);
			HammerRegistry.registerOre(Registries.vulcaniteOreBlock.blockID, i, Registries.vulcaniteOreItem.itemID, i+1);
			HammerRegistry.registerOre(Registries.vyroxeresOreBlock.blockID, i, Registries.vyroxeresOreItem.itemID, i+1);
			HammerRegistry.registerOre(Registries.zincOreBlock.blockID, i, Registries.zincOreItem.itemID, i+1);
		}		
	}
}
