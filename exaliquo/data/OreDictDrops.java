package exaliquo.data;

import java.util.ArrayList;

import cpw.mods.fml.common.registry.GameRegistry;

import exaliquo.Registries;
import exaliquo.data.ModIDs.Info;
import exnihilo.registries.HammerRegistry;
import exnihilo.registries.SieveRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictDrops
{
	private static int[] overworld = { BonusSieving.gravel, BonusSieving.sand, ModIDs.getIDs(Info.dust) };
	private static int[] nether = { BonusSieving.netherrack, BonusSieving.soulsand };
	private static int[] end = { BonusSieving.endstone };
	private static int[] sands = { BonusSieving.sand };
	private static int[] gravel = { BonusSieving.gravel };
	
	private enum Metals
	{
		COBALT("ingotCobalt","oreCobalt",0,Registries.cobaltOreItem,Registries.cobaltOreBlock,-1,nether,96),
		ARDITE("ingotArdite","oreArdite",0,Registries.arditeOreItem,Registries.arditeOreBlock,-1,nether,96),
		
		ADAMANTINE("ingotAdamantine","oreAdamantine",1,Registries.adamantineOreItem,Registries.adamantineOreBlock,-1,overworld,160),
		ASTRALSILVER("ingotAstral Silver","oreAstral Silver",1,Registries.astralsilverOreItem,Registries.astralsilverOreBlock,-1,overworld,14),
		ATLARUS("ingotAtlarus","oreAtlatus",1,Registries.atlarusOreItem,Registries.atlarusOreBlock,-1,overworld,160),
		CARMOT("ingotCarmot","oreCarmot",1,Registries.carmotOreItem,Registries.carmotOreBlock,-1,overworld,32),
		DEEPIRON("ingotDeep Iron","oreDeep Iron",1,Registries.deepironOreItem,Registries.deepironOreBlock,-1,overworld,8),
		INFUSCOLIUM("ingotInfuscolium","oreInfuscolium",1,Registries.infuscoliumOreItem,Registries.infuscoliumOreBlock,-1,overworld,12),
		MANGANESE("ingotManganese","oreManganese",1,Registries.manganeseOreItem,Registries.manganeseOreBlock,-1,overworld,6),
		MITHRIL("ingotMithril","oreMithril",1,Registries.mithrilOreItem,Registries.mithrilOreBlock,-1,overworld,96),
		ORICHALCUM("ingotOrichalcum","oreOrichalcum",1,Registries.orichalcumOreItem,Registries.orichalcumOreBlock,-1,overworld,128),
		OURECLASE("ingotOureclase","oreOureclase",1,Registries.oureclaseOreItem,Registries.orichalcumOreBlock,-1,overworld,32),
		PROMETHEUM("ingotPrometheum","orePrometheum",1,Registries.prometheumOreItem,Registries.prometheumOreBlock,-1,overworld,6),
		RUBRACIUM("ingotRubracium","oreRubracium",1,Registries.rubraciumOreItem,Registries.rubraciumOreBlock,-1,overworld,144),
		ZINC("ingotZinc","oreZinc",1,Registries.zincOreItem,Registries.zincOreBlock,-1,overworld,12),
		ALDUORITE("ingotAlduorite","oreAlduorite",1,Registries.alduoriteOreItem,Registries.alduoriteOreBlock,-1,nether,14),
		CERUCLASE("ingotCeruclase","oreCeruclase",1,Registries.ceruclaseOreItem,Registries.ceruclaseOreBlock,-1,nether,14),
		IGNATIUS("ingotIgnatius","oreIgnatius",1,Registries.ignatiusOreItem,Registries.ignatiusOreBlock,-1,nether,7),
		KALENDRITE("ingotKalendrite","oreKalendrite",1,Registries.kalendriteOreItem,Registries.kalendriteOreBlock,-1,nether,128),
		LEMURITE("ingotLemurite","oreLemurite",1,Registries.lemuriteOreItem,Registries.lemuriteOreBlock,-1,nether,12),
		MIDASIUM("ingotMidasium","oreMidasium",1,Registries.midasiumOreItem,Registries.midasiumOreBlock,-1,nether,18),
		SANGUINITE("ingotSanguinite","oreSanguinite",1,Registries.sanguiniteOreItem,Registries.sanguiniteOreBlock,-1,nether,128),
		SHADOWIRON("ingotShadow Iron","oreShadow Iron",1,Registries.shadowironOreItem,Registries.shadowironOreBlock,-1,nether,8),
		VULCANITE("ingotVulcanite","oreVulcanite",1,Registries.vulcaniteOreItem,Registries.vulcaniteOreBlock,-1,nether,128),
		VYROXERES("ingotVyroxeres","oreVyroxeres",1,Registries.vyroxeresOreItem,Registries.vyroxeresOreBlock,-1,nether,64),
		EXIMITE("ingotEximite","oreEximite",1,Registries.eximiteOreItem,Registries.eximiteOreBlock,-1,end,92),
		MEUTOITE("ingotMeutoite","oreMeutoite",1,Registries.meutoiteOreItem,Registries.meutoiteOreBlock,-1,end,138),
		
		LIMESTONE("blockLimestone","blockLimestone",0,OreDict.getFirstOre("blockLimestone",false).getItem(),OreDict.getBlock(OreDict.getFirstOre("blockLimestone",false)),OreDict.getFirstOre("blockLimestone",false).getItemDamage(),sands,4),
		
		ONYX("gemOnyx","oreOnyx",0,OreDict.getFirstOre("gemOnyx",false).getItem(),OreDict.getBlock(OreDict.getFirstOre("oreOnyx",false)),OreDict.getFirstOre("gemOnyx",false).getItemDamage(),gravel,64),
		
		URANIUM("ingotUranium","oreUranium",1,OreDict.getFirstOre("ingotUranium",false).getItem(),OreDict.getBlock(OreDict.getFirstOre("oreUranium",false)),OreDict.getFirstOre("ingotUranium",false).getItemDamage(),sands,48);

		private final String ingot;
		private final String ore;
		private final int smeltnum;
		private final Item partial;
		private final Block full;
		private final int meta;
		private final int[] dropgroup;
		private final int chance;
		
		private Metals(String ingot, String ore, int smeltnum, Item partial, Block full, int meta, int[] dropgroup, int chance)
		{
			this.ingot = ingot;
			this.ore = ore;
			this.smeltnum = smeltnum;
			this.partial = partial;
			this.full = full;
			this.meta = meta;
			this.dropgroup = dropgroup;
			this.chance = chance;
		}
	}
	
	public static void CheckMetals()
	{
		for (Metals metals : Metals.values())
		{
			ArrayList<ItemStack> ores = OreDictionary.getOres(metals.ore);
			if (!ores.isEmpty())
			{
				for (int i = 0; i < metals.dropgroup.length; i++)
				{
					if (metals.meta == -1)
					{
						SieveRegistry.register(metals.dropgroup[i], 0, metals.partial.itemID, i, metals.chance);
					}
					else
					{
						SieveRegistry.register(metals.dropgroup[i], 0, metals.partial.itemID, metals.meta, metals.chance);
					}
				}
				
				for (int i = 0; i < ores.size() ;i++)
				{
					if (metals.meta == -1)
					{
						HammerRegistry.registerOre(ores.get(i).itemID, ores.get(i).getItemDamage(), metals.partial.itemID, 0);
					}
					else
					{
						HammerRegistry.registerOre(ores.get(i).itemID, ores.get(i).getItemDamage(), metals.partial.itemID, metals.meta);
					}
				}
				
				if (metals.full != Block.redstoneWire)
				{
					for (int i = 0; i < metals.dropgroup.length; i++)
					{
						OreDictionary.registerOre(metals.ore, new ItemStack(metals.full,1,i));
					}
				}
			}
			
			ArrayList<ItemStack> ingots = OreDictionary.getOres(metals.ingot);
			if (metals.smeltnum > 0 && !ingots.isEmpty())
			{
				GameRegistry.addSmelting(metals.full.blockID, ingots.get(0), 3);
			}
		}
	}
}
