package exaliquo;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import static net.minecraftforge.fluids.FluidRegistry.getFluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;

import tconstruct.TConstruct;
import tconstruct.library.crafting.Smeltery;
import exnihilo.registries.CrucibleRegistry;

import static exaliquo.data.ModIDs.getBlock;
import static exaliquo.data.ModIDs.getIDs;
import static exaliquo.data.ModIDs.getItem;
import exaliquo.data.Configurations;
import exaliquo.data.ModIDs.Info;

public class MoltenMetals {
	
	private static final int ingotCost = TConstruct.ingotLiquidValue;
	private static final int ingotCostSmeltery = ingotCost * (Configurations.isOre?2:1);
	private static final int dustCostGeneral = ingotCost / (Configurations.dustValue?4:6);
	private static final int dustCostSmeltery = dustCostGeneral * (Configurations.isOre?2:1);
	
	public static void addToSmelting()
	{
		for (int i = 0; i < 3; i++)
		{
			Smeltery.addMelting(getBlock(Info.ironore), i, 600, new FluidStack(getFluid("iron.molten"), ingotCostSmeltery));
			Smeltery.addMelting(getBlock(Info.goldore), i, 400, new FluidStack(getFluid("gold.molten"), ingotCostSmeltery));
			Smeltery.addMelting(getBlock(Info.copperore), i, 550, new FluidStack(getFluid("copper.molten"), ingotCostSmeltery));
			Smeltery.addMelting(getBlock(Info.tinore), i, 400, new FluidStack(getFluid("tin.molten"), ingotCostSmeltery));
			Smeltery.addMelting(getBlock(Info.silverore), i, 400, new FluidStack(getFluid("silver.molten"), ingotCostSmeltery));
			Smeltery.addMelting(getBlock(Info.leadore), i, 400, new FluidStack(getFluid("lead.molten"), ingotCostSmeltery));
			Smeltery.addMelting(getBlock(Info.nickelore), i, 400, new FluidStack(getFluid("nickel.molten"), ingotCostSmeltery));
			Smeltery.addMelting(getBlock(Info.platinumore), i, 400, new FluidStack(getFluid("platinum.molten"), ingotCostSmeltery));
			Smeltery.addMelting(getBlock(Info.aluminumore), i, 400, new FluidStack(getFluid("aluminum.molten"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.cobaltOreBlock, i, 650, new FluidStack(getFluid("cobalt.molten"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.arditeOreBlock, i, 650, new FluidStack(getFluid("ardite.molten"), ingotCostSmeltery));			
			
			if (Configurations.miniSmelting)
			{
				CrucibleRegistry.register(getIDs(Info.ironore), i, ingotCost*2, getFluid("iron.molten"), ingotCost, getBlock(Info.ironore));
				CrucibleRegistry.register(getIDs(Info.goldore), i, ingotCost*2, getFluid("gold.molten"), ingotCost, getBlock(Info.goldore));
				CrucibleRegistry.register(getIDs(Info.copperore), i, ingotCost*2, getFluid("copper.molten"), ingotCost, getBlock(Info.copperore));
				CrucibleRegistry.register(getIDs(Info.tinore), i, ingotCost*2, getFluid("tin.molten"), ingotCost, getBlock(Info.tinore));
				CrucibleRegistry.register(getIDs(Info.silverore), i, ingotCost*2, getFluid("silver.molten"), ingotCost, getBlock(Info.silverore));
				CrucibleRegistry.register(getIDs(Info.leadore), i, ingotCost*2, getFluid("lead.molten"), ingotCost, getBlock(Info.leadore));
				CrucibleRegistry.register(getIDs(Info.nickelore), i, ingotCost*2, getFluid("nickel.molten"), ingotCost, getBlock(Info.nickelore));
				CrucibleRegistry.register(getIDs(Info.platinumore), i, ingotCost*2, getFluid("platinum.molten"), ingotCost, getBlock(Info.platinumore));
				CrucibleRegistry.register(getIDs(Info.aluminumore), i, ingotCost*2, getFluid("aluminum.molten"), ingotCost, getBlock(Info.aluminumore));
				CrucibleRegistry.register(Registries.cobaltOreBlock.blockID, i, ingotCost*2, getFluid("cobalt.molten"), ingotCost, Registries.cobaltOreBlock);
				CrucibleRegistry.register(Registries.arditeOreBlock.blockID, i, ingotCost*2, getFluid("ardite.molten"), ingotCost, Registries.arditeOreBlock);
			}
		}
		
		if (Configurations.allowDustSmelting)
		{
			Smeltery.addMelting(new ItemStack(getItem(Info.irongrav),4,0), getIDs(Info.ironore), 0, 600, new FluidStack(getFluid("iron.molten"), dustCostSmeltery));
			Smeltery.addMelting(new ItemStack(getItem(Info.ironsand),4,0), getIDs(Info.ironore), 1, 600, new FluidStack(getFluid("iron.molten"), dustCostSmeltery));
			Smeltery.addMelting(new ItemStack(getItem(Info.irondust),4,0), getIDs(Info.ironore), 2, 600, new FluidStack(getFluid("iron.molten"), dustCostSmeltery));

			Smeltery.addMelting(new ItemStack(getItem(Info.goldgrav),4,0), getIDs(Info.goldore), 0, 400, new FluidStack(getFluid("gold.molten"), dustCostSmeltery));
			Smeltery.addMelting(new ItemStack(getItem(Info.goldsand),4,0), getIDs(Info.goldore), 1, 400, new FluidStack(getFluid("gold.molten"), dustCostSmeltery));
			Smeltery.addMelting(new ItemStack(getItem(Info.golddust),4,0), getIDs(Info.goldore), 2, 400, new FluidStack(getFluid("gold.molten"), dustCostSmeltery));

			Smeltery.addMelting(new ItemStack(getItem(Info.coppergrav),4,0), getIDs(Info.copperore), 0, 550, new FluidStack(getFluid("copper.molten"), dustCostSmeltery));
			Smeltery.addMelting(new ItemStack(getItem(Info.coppersand),4,0), getIDs(Info.copperore), 1, 550, new FluidStack(getFluid("copper.molten"), dustCostSmeltery));
			Smeltery.addMelting(new ItemStack(getItem(Info.copperdust),4,0), getIDs(Info.copperore), 2, 550, new FluidStack(getFluid("copper.molten"), dustCostSmeltery));

			Smeltery.addMelting(new ItemStack(getItem(Info.tingrav),4,0), getIDs(Info.tinore), 0, 400, new FluidStack(getFluid("tin.molten"), dustCostSmeltery));
			Smeltery.addMelting(new ItemStack(getItem(Info.tinsand),4,0), getIDs(Info.tinore), 1, 400, new FluidStack(getFluid("tin.molten"), dustCostSmeltery));
			Smeltery.addMelting(new ItemStack(getItem(Info.tindust),4,0), getIDs(Info.tinore), 2, 400, new FluidStack(getFluid("tin.molten"), dustCostSmeltery));

			Smeltery.addMelting(new ItemStack(getItem(Info.silvergrav),4,0), getIDs(Info.silverore), 0, 400, new FluidStack(getFluid("silver.molten"), dustCostSmeltery));
			Smeltery.addMelting(new ItemStack(getItem(Info.silversand),4,0), getIDs(Info.silverore), 1, 400, new FluidStack(getFluid("silver.molten"), dustCostSmeltery));
			Smeltery.addMelting(new ItemStack(getItem(Info.silverdust),4,0), getIDs(Info.silverore), 2, 400, new FluidStack(getFluid("silver.molten"), dustCostSmeltery));

			Smeltery.addMelting(new ItemStack(getItem(Info.leadgrav),4,0), getIDs(Info.leadore), 0, 400, new FluidStack(getFluid("lead.molten"), dustCostSmeltery));
			Smeltery.addMelting(new ItemStack(getItem(Info.leadsand),4,0), getIDs(Info.leadore), 1, 400, new FluidStack(getFluid("lead.molten"), dustCostSmeltery));
			Smeltery.addMelting(new ItemStack(getItem(Info.leaddust),4,0), getIDs(Info.leadore), 2, 400, new FluidStack(getFluid("lead.molten"), dustCostSmeltery));

			Smeltery.addMelting(new ItemStack(getItem(Info.nickelgrav),4,0), getIDs(Info.nickelore), 0, 400, new FluidStack(getFluid("nickel.molten"), dustCostSmeltery));
			Smeltery.addMelting(new ItemStack(getItem(Info.nickelsand),4,0), getIDs(Info.nickelore), 1, 400, new FluidStack(getFluid("nickel.molten"), dustCostSmeltery));
			Smeltery.addMelting(new ItemStack(getItem(Info.nickeldust),4,0), getIDs(Info.nickelore), 2, 400, new FluidStack(getFluid("nickel.molten"), dustCostSmeltery));

			Smeltery.addMelting(new ItemStack(getItem(Info.platinumgrav),4,0), getIDs(Info.platinumore), 0, 400, new FluidStack(getFluid("platinum.molten"), dustCostSmeltery));
			Smeltery.addMelting(new ItemStack(getItem(Info.platinumsand),4,0), getIDs(Info.platinumore), 1, 400, new FluidStack(getFluid("platinum.molten"), dustCostSmeltery));
			Smeltery.addMelting(new ItemStack(getItem(Info.platinumdust),4,0), getIDs(Info.platinumore), 2, 400, new FluidStack(getFluid("platinum.molten"), dustCostSmeltery));
			
			Smeltery.addMelting(new ItemStack(getItem(Info.aluminumgrav),4,0), getIDs(Info.aluminumore), 0, 400, new FluidStack(getFluid("aluminum.molten"), dustCostSmeltery));
			Smeltery.addMelting(new ItemStack(getItem(Info.aluminumsand),4,0), getIDs(Info.aluminumore), 1, 400, new FluidStack(getFluid("aluminum.molten"), dustCostSmeltery));
			Smeltery.addMelting(new ItemStack(getItem(Info.aluminumdust),4,0), getIDs(Info.aluminumore), 2, 400, new FluidStack(getFluid("aluminum.molten"), dustCostSmeltery));

			Smeltery.addMelting(new ItemStack(Registries.cobaltOreItem,4,0), Registries.cobaltOreBlock.blockID, 0, 650, new FluidStack(getFluid("cobalt.molten"), dustCostSmeltery));
			Smeltery.addMelting(new ItemStack(Registries.cobaltOreItem,4,1), Registries.cobaltOreBlock.blockID, 1, 650, new FluidStack(getFluid("cobalt.molten"), dustCostSmeltery));
			Smeltery.addMelting(new ItemStack(Registries.cobaltOreItem,4,2), Registries.cobaltOreBlock.blockID, 2, 650, new FluidStack(getFluid("cobalt.molten"), dustCostSmeltery));

			Smeltery.addMelting(new ItemStack(Registries.arditeOreItem,4,0), Registries.arditeOreBlock.blockID, 0, 650, new FluidStack(getFluid("ardite.molten"), dustCostSmeltery));
			Smeltery.addMelting(new ItemStack(Registries.arditeOreItem,4,1), Registries.arditeOreBlock.blockID, 1, 650, new FluidStack(getFluid("ardite.molten"), dustCostSmeltery));
			Smeltery.addMelting(new ItemStack(Registries.arditeOreItem,4,2), Registries.arditeOreBlock.blockID, 2, 650, new FluidStack(getFluid("ardite.molten"), dustCostSmeltery));

			if (Configurations.miniSmelting)
			{
				CrucibleRegistry.register(getItem(Info.irongrav).itemID, 0, dustCostGeneral*2, getFluid("iron.molten"), dustCostGeneral, getBlock(Info.ironore));
				CrucibleRegistry.register(getItem(Info.ironsand).itemID, 0, dustCostGeneral*2, getFluid("iron.molten"), dustCostGeneral, getBlock(Info.ironore));
				CrucibleRegistry.register(getItem(Info.irondust).itemID, 0, dustCostGeneral*2, getFluid("iron.molten"), dustCostGeneral, getBlock(Info.ironore));

				CrucibleRegistry.register(getItem(Info.goldgrav).itemID, 0, dustCostGeneral*2, getFluid("gold.molten"), dustCostGeneral, getBlock(Info.goldore));
				CrucibleRegistry.register(getItem(Info.goldsand).itemID, 0, dustCostGeneral*2, getFluid("gold.molten"), dustCostGeneral, getBlock(Info.goldore));
				CrucibleRegistry.register(getItem(Info.golddust).itemID, 0, dustCostGeneral*2, getFluid("gold.molten"), dustCostGeneral, getBlock(Info.goldore));

				CrucibleRegistry.register(getItem(Info.coppergrav).itemID, 0, dustCostGeneral*2, getFluid("copper.molten"), dustCostGeneral, getBlock(Info.copperore));
				CrucibleRegistry.register(getItem(Info.coppersand).itemID, 0, dustCostGeneral*2, getFluid("copper.molten"), dustCostGeneral, getBlock(Info.copperore));
				CrucibleRegistry.register(getItem(Info.copperdust).itemID, 0, dustCostGeneral*2, getFluid("copper.molten"), dustCostGeneral, getBlock(Info.copperore));

				CrucibleRegistry.register(getItem(Info.tingrav).itemID, 0, dustCostGeneral*2, getFluid("tin.molten"), dustCostGeneral, getBlock(Info.tinore));
				CrucibleRegistry.register(getItem(Info.tinsand).itemID, 0, dustCostGeneral*2, getFluid("tin.molten"), dustCostGeneral, getBlock(Info.tinore));
				CrucibleRegistry.register(getItem(Info.tindust).itemID, 0, dustCostGeneral*2, getFluid("tin.molten"), dustCostGeneral, getBlock(Info.tinore));

				CrucibleRegistry.register(getItem(Info.silvergrav).itemID, 0, dustCostGeneral*2, getFluid("silver.molten"), dustCostGeneral, getBlock(Info.silverore));
				CrucibleRegistry.register(getItem(Info.silversand).itemID, 0, dustCostGeneral*2, getFluid("silver.molten"), dustCostGeneral, getBlock(Info.silverore));
				CrucibleRegistry.register(getItem(Info.silverdust).itemID, 0, dustCostGeneral*2, getFluid("silver.molten"), dustCostGeneral, getBlock(Info.silverore));

				CrucibleRegistry.register(getItem(Info.leadgrav).itemID, 0, dustCostGeneral*2, getFluid("lead.molten"), dustCostGeneral, getBlock(Info.leadore));
				CrucibleRegistry.register(getItem(Info.leadsand).itemID, 0, dustCostGeneral*2, getFluid("lead.molten"), dustCostGeneral, getBlock(Info.leadore));
				CrucibleRegistry.register(getItem(Info.leaddust).itemID, 0, dustCostGeneral*2, getFluid("lead.molten"), dustCostGeneral, getBlock(Info.leadore));

				CrucibleRegistry.register(getItem(Info.nickelgrav).itemID, 0, dustCostGeneral*2, getFluid("nickel.molten"), dustCostGeneral, getBlock(Info.nickelore));
				CrucibleRegistry.register(getItem(Info.nickelsand).itemID, 0, dustCostGeneral*2, getFluid("nickel.molten"), dustCostGeneral, getBlock(Info.nickelore));
				CrucibleRegistry.register(getItem(Info.nickeldust).itemID, 0, dustCostGeneral*2, getFluid("nickel.molten"), dustCostGeneral, getBlock(Info.nickelore));

				CrucibleRegistry.register(getItem(Info.platinumgrav).itemID, 0, dustCostGeneral*2, getFluid("platinum.molten"), dustCostGeneral, getBlock(Info.platinumore));
				CrucibleRegistry.register(getItem(Info.platinumsand).itemID, 0, dustCostGeneral*2, getFluid("platinum.molten"), dustCostGeneral, getBlock(Info.platinumore));
				CrucibleRegistry.register(getItem(Info.platinumdust).itemID, 0, dustCostGeneral*2, getFluid("platinum.molten"), dustCostGeneral, getBlock(Info.platinumore));

				CrucibleRegistry.register(getItem(Info.aluminumgrav).itemID, 0, dustCostGeneral*2, getFluid("aluminum.molten"), dustCostGeneral, getBlock(Info.aluminumore));
				CrucibleRegistry.register(getItem(Info.aluminumsand).itemID, 0, dustCostGeneral*2, getFluid("aluminum.molten"), dustCostGeneral, getBlock(Info.aluminumore));
				CrucibleRegistry.register(getItem(Info.aluminumdust).itemID, 0, dustCostGeneral*2, getFluid("aluminum.molten"), dustCostGeneral, getBlock(Info.aluminumore));
				
				CrucibleRegistry.register(Registries.cobaltOreItem.itemID, 0, dustCostGeneral*2, getFluid("cobalt.molten"), dustCostGeneral, Registries.cobaltOreBlock);
				CrucibleRegistry.register(Registries.cobaltOreItem.itemID, 0, dustCostGeneral*2, getFluid("cobalt.molten"), dustCostGeneral, Registries.cobaltOreBlock);
				CrucibleRegistry.register(Registries.cobaltOreItem.itemID, 0, dustCostGeneral*2, getFluid("cobalt.molten"), dustCostGeneral, Registries.cobaltOreBlock);
				
				CrucibleRegistry.register(Registries.arditeOreItem.itemID, 0, dustCostGeneral*2, getFluid("ardite.molten"), dustCostGeneral, Registries.arditeOreBlock);
				CrucibleRegistry.register(Registries.arditeOreItem.itemID, 0, dustCostGeneral*2, getFluid("ardite.molten"), dustCostGeneral, Registries.arditeOreBlock);
				CrucibleRegistry.register(Registries.arditeOreItem.itemID, 0, dustCostGeneral*2, getFluid("ardite.molten"), dustCostGeneral, Registries.arditeOreBlock);
			}
		}
		
		CrucibleRegistry.register(Block.sand.blockID, 0, 2000, getFluid("glass.molten"), 1000, Block.sand);
		CrucibleRegistry.register(Block.glass.blockID, 0, 2000, getFluid("glass.molten"), 1000, Block.glass);
		CrucibleRegistry.register(getIDs(Info.stones), 0, 2, getFluid("stone.seared"), 2, Block.cobblestone);
	}

	public static void WYNAUT()
	{
		Smeltery.addMelting(new ItemStack(getItem(Info.essences), 1, 0), getIDs(Info.essenceBlock), 0, 800, new FluidStack(getFluid("liquidessence"), 1000));
		Smeltery.addMelting(new ItemStack(getItem(Info.essences), 1, 1), getIDs(Info.essenceBlock), 0, 800, new FluidStack(getFluid("liquidessence"), 1000));
		Smeltery.addMelting(new ItemStack(getItem(Info.essences), 1, 2), getIDs(Info.essenceBlock), 0, 800, new FluidStack(getFluid("liquidessence"), 1000));
		Smeltery.addMelting(new ItemStack(getItem(Info.essences), 1, 3), getIDs(Info.essenceBlock), 0, 800, new FluidStack(getFluid("liquidessence"), 1000));
		Smeltery.addMelting(new ItemStack(getItem(Info.essences), 1, 4), getIDs(Info.essenceBlock), 0, 800, new FluidStack(getFluid("liquidessence"), 1000));
		Smeltery.addMelting(new ItemStack(getItem(Info.essences), 1, 5), getIDs(Info.essenceBlock), 0, 800, new FluidStack(getFluid("liquidessence"), 1000));
		Smeltery.addMelting(new ItemStack(getItem(Info.essences), 1, 6), getIDs(Info.essenceBlock), 0, 800, new FluidStack(getFluid("liquidessence"), 1000));
		Smeltery.addMelting(new ItemStack(getItem(Info.essences), 1, 7), getIDs(Info.essenceBlock), 0, 800, new FluidStack(getFluid("liquidessence"), 1000));
		Smeltery.addMelting(new ItemStack(getItem(Info.essences), 1, 8), getIDs(Info.essenceBlock), 0, 800, new FluidStack(getFluid("liquidessence"), 1000));
		Smeltery.addMelting(new ItemStack(getItem(Info.essences), 1, 9), getIDs(Info.essenceBlock), 0, 800, new FluidStack(getFluid("liquidessence"), 1000));
	}

	public static void addExMetallurgyToSmeltery()
	{
		for (int i = 0; i < 3; i++)
		{
			Smeltery.addMelting(Registries.adamantineOreBlock, i, 550, new FluidStack(getFluid("molten.adamantine"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.alduoriteOreBlock, i, 550, new FluidStack(getFluid("molten.alduorite"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.astralsilverOreBlock, i, 550, new FluidStack(getFluid("molten.astral.silver"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.atlarusOreBlock, i, 550, new FluidStack(getFluid("molten.atlarus"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.carmotOreBlock, i, 550, new FluidStack(getFluid("molten.carmot"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.ceruclaseOreBlock, i, 550, new FluidStack(getFluid("molten.ceruclase"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.deepironOreBlock, i, 550, new FluidStack(getFluid("molten.deep.iron"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.eximiteOreBlock, i, 550, new FluidStack(getFluid("molten.eximite"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.ignatiusOreBlock, i, 550, new FluidStack(getFluid("molten.ignatius"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.infuscoliumOreBlock, i, 550, new FluidStack(getFluid("molten.infuscolium"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.kalendriteOreBlock, i, 550, new FluidStack(getFluid("molten.kalendrite"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.lemuriteOreBlock, i, 550, new FluidStack(getFluid("molten.lemurite"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.manganeseOreBlock, i, 700, new FluidStack(getFluid("molten.manganese"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.meuroiteOreBlock, i, 550, new FluidStack(getFluid("molten.meutoite"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.midasiumOreBlock, i, 550, new FluidStack(getFluid("molten.midasium"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.mithrilOreBlock, i, 550, new FluidStack(getFluid("molten.mithril"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.orichalcumOreBlock, i, 550, new FluidStack(getFluid("molten.orichalcum"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.oureclaseOreBlock, i, 550, new FluidStack(getFluid("molten.oureclase"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.prometheumOreBlock, i, 550, new FluidStack(getFluid("molten.prometheum"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.rubraciumOreBlock, i, 550, new FluidStack(getFluid("molten.rubracium"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.sanguiniteOreBlock, i, 550, new FluidStack(getFluid("molten.sanguinite"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.shadowironOreBlock, i, 550, new FluidStack(getFluid("molten.shadow.iron"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.vulcaniteOreBlock, i, 550, new FluidStack(getFluid("molten.vulcanite"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.vyroxeresOreBlock, i, 550, new FluidStack(getFluid("molten.vyroxeres"), ingotCostSmeltery));
			Smeltery.addMelting(Registries.zincOreBlock, i, 550, new FluidStack(getFluid("molten.zinc"), ingotCostSmeltery));

			if (Configurations.miniSmelting)
			{
				CrucibleRegistry.register(Registries.adamantineOreBlock.blockID, i, ingotCost*2, getFluid("adamantine.molten"), ingotCost, Registries.adamantineOreBlock);
				CrucibleRegistry.register(Registries.alduoriteOreBlock.blockID, i, ingotCost*2, getFluid("molten.alduorite"), ingotCost, Registries.alduoriteOreBlock);
				CrucibleRegistry.register(Registries.astralsilverOreBlock.blockID, i, ingotCost*2, getFluid("molten.astral.silver"), ingotCost, Registries.astralsilverOreBlock);
				CrucibleRegistry.register(Registries.atlarusOreBlock.blockID, i, ingotCost*2, getFluid("molten.atlarus"), ingotCost, Registries.atlarusOreBlock);
				CrucibleRegistry.register(Registries.carmotOreBlock.blockID, i, ingotCost*2, getFluid("molten.carmot"), ingotCost, Registries.carmotOreBlock);
				CrucibleRegistry.register(Registries.ceruclaseOreBlock.blockID, i, ingotCost*2, getFluid("molten.ceruclase"), ingotCost, Registries.ceruclaseOreBlock);
				CrucibleRegistry.register(Registries.deepironOreBlock.blockID, i, ingotCost*2, getFluid("molten.deep.iron"), ingotCost, Registries.deepironOreBlock);
				CrucibleRegistry.register(Registries.eximiteOreBlock.blockID, i, ingotCost*2, getFluid("molten.eximite"), ingotCost, Registries.eximiteOreBlock);
				CrucibleRegistry.register(Registries.ignatiusOreBlock.blockID, i, ingotCost*2, getFluid("molten.ignatius"), ingotCost, Registries.ignatiusOreBlock);
				CrucibleRegistry.register(Registries.infuscoliumOreBlock.blockID, i, ingotCost*2, getFluid("molten.infuscolium"), ingotCost, Registries.infuscoliumOreBlock);
				CrucibleRegistry.register(Registries.kalendriteOreBlock.blockID, i, ingotCost*2, getFluid("molten.kalendrite"), ingotCost, Registries.kalendriteOreBlock);
				CrucibleRegistry.register(Registries.lemuriteOreBlock.blockID, i, ingotCost*2, getFluid("molten.lemurite"), ingotCost, Registries.lemuriteOreBlock);
				CrucibleRegistry.register(Registries.manganeseOreBlock.blockID, i, ingotCost*2, getFluid("molten.manganese"), ingotCost, Registries.manganeseOreBlock);
				CrucibleRegistry.register(Registries.meuroiteOreBlock.blockID, i, ingotCost*2, getFluid("molten.meutoite"), ingotCost, Registries.meuroiteOreBlock);
				CrucibleRegistry.register(Registries.midasiumOreBlock.blockID, i, ingotCost*2, getFluid("molten.midasium"), ingotCost, Registries.midasiumOreBlock);
				CrucibleRegistry.register(Registries.mithrilOreBlock.blockID, i, ingotCost*2, getFluid("molten.mithril"), ingotCost, Registries.mithrilOreBlock);
				CrucibleRegistry.register(Registries.orichalcumOreBlock.blockID, i, ingotCost*2, getFluid("molten.orichalcum"), ingotCost, Registries.orichalcumOreBlock);
				CrucibleRegistry.register(Registries.oureclaseOreBlock.blockID, i, ingotCost*2, getFluid("molten.oureclase"), ingotCost, Registries.oureclaseOreBlock);
				CrucibleRegistry.register(Registries.prometheumOreBlock.blockID, i, ingotCost*2, getFluid("molten.prometheum"), ingotCost, Registries.prometheumOreBlock);
				CrucibleRegistry.register(Registries.rubraciumOreBlock.blockID, i, ingotCost*2, getFluid("molten.rubracium"), ingotCost, Registries.rubraciumOreBlock);
				CrucibleRegistry.register(Registries.sanguiniteOreBlock.blockID, i, ingotCost*2, getFluid("molten.sanguinite"), ingotCost, Registries.sanguiniteOreBlock);
				CrucibleRegistry.register(Registries.vulcaniteOreBlock.blockID, i, ingotCost*2, getFluid("molten.vulcanite"), ingotCost, Registries.vulcaniteOreBlock);
				CrucibleRegistry.register(Registries.vyroxeresOreBlock.blockID, i, ingotCost*2, getFluid("molten.vyroxeres"), ingotCost, Registries.vyroxeresOreBlock);
				CrucibleRegistry.register(Registries.zincOreBlock.blockID, i, ingotCost*2, getFluid("molten.zinc"), ingotCost, Registries.zincOreBlock);
			}

			if (Configurations.allowDustSmelting)
			{
				Smeltery.addMelting(new ItemStack(Registries.adamantineOreItem, 4, i), Registries.adamantineOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.adamantine"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.alduoriteOreItem, 4, i), Registries.alduoriteOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.alduorite"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.astralsilverOreItem, 4, i), Registries.astralsilverOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.astral.silver"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.atlarusOreItem, 4, i), Registries.atlarusOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.atlarus"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.carmotOreItem, 4, i), Registries.carmotOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.carmot"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.ceruclaseOreItem, 4, i), Registries.ceruclaseOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.ceruclase"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.deepironOreItem, 4, i), Registries.deepironOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.deep.iron"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.eximiteOreItem, 4, i), Registries.eximiteOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.eximite"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.ignatiusOreItem, 4, i), Registries.ignatiusOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.ignatius"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.infuscoliumOreItem, 4, i), Registries.infuscoliumOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.infuscolium"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.kalendriteOreItem, 4, i), Registries.kalendriteOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.kalendrite"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.lemuriteOreItem, 4, i), Registries.lemuriteOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.lemurite"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.manganeseOreItem, 4, i), Registries.manganeseOreBlock.blockID, i ,700, new FluidStack(getFluid("molten.manganese"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.meuroiteOreItem, 4, i), Registries.meuroiteOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.meuroite"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.midasiumOreItem, 4, i), Registries.midasiumOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.midasium"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.mithrilOreItem, 4, i), Registries.mithrilOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.mithril"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.orichalcumOreItem, 4, i), Registries.orichalcumOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.orichalcum"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.oureclaseOreItem, 4, i), Registries.oureclaseOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.oureclase"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.prometheumOreItem, 4, i), Registries.prometheumOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.prometheum"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.rubraciumOreItem, 4, i), Registries.rubraciumOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.rubracium"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.sanguiniteOreItem, 4, i), Registries.sanguiniteOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.sanguinite"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.shadowironOreItem, 4, i), Registries.shadowironOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.shadow.iron"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.vulcaniteOreItem, 4, i), Registries.vulcaniteOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.vulcanite"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.vyroxeresOreItem, 4, i), Registries.vyroxeresOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.vyroxeres"), dustCostSmeltery));
				Smeltery.addMelting(new ItemStack(Registries.zincOreItem, 4, i), Registries.zincOreBlock.blockID, i ,550, new FluidStack(getFluid("molten.zinc"), dustCostSmeltery));

				if (Configurations.miniSmelting)
				{
					CrucibleRegistry.register(Registries.adamantineOreItem.itemID, i, dustCostGeneral*2, getFluid("adamantine.molten"), dustCostGeneral, Registries.adamantineOreBlock);
					CrucibleRegistry.register(Registries.alduoriteOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.alduorite"), dustCostGeneral, Registries.alduoriteOreBlock);
					CrucibleRegistry.register(Registries.astralsilverOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.astral.silver"), dustCostGeneral, Registries.astralsilverOreBlock);
					CrucibleRegistry.register(Registries.atlarusOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.atlarus"), dustCostGeneral, Registries.atlarusOreBlock);
					CrucibleRegistry.register(Registries.carmotOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.carmot"), dustCostGeneral, Registries.carmotOreBlock);
					CrucibleRegistry.register(Registries.ceruclaseOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.ceruclase"), dustCostGeneral, Registries.ceruclaseOreBlock);
					CrucibleRegistry.register(Registries.deepironOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.deep.iron"), dustCostGeneral, Registries.deepironOreBlock);
					CrucibleRegistry.register(Registries.eximiteOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.eximite"), dustCostGeneral, Registries.eximiteOreBlock);
					CrucibleRegistry.register(Registries.ignatiusOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.ignatius"), dustCostGeneral, Registries.ignatiusOreBlock);
					CrucibleRegistry.register(Registries.infuscoliumOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.infuscolium"), dustCostGeneral, Registries.infuscoliumOreBlock);
					CrucibleRegistry.register(Registries.kalendriteOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.kalendrite"), dustCostGeneral, Registries.kalendriteOreBlock);
					CrucibleRegistry.register(Registries.lemuriteOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.lemurite"), dustCostGeneral, Registries.lemuriteOreBlock);
					CrucibleRegistry.register(Registries.manganeseOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.manganese"), dustCostGeneral, Registries.manganeseOreBlock);
					CrucibleRegistry.register(Registries.meuroiteOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.meutoite"), dustCostGeneral, Registries.meuroiteOreBlock);
					CrucibleRegistry.register(Registries.midasiumOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.midasium"), dustCostGeneral, Registries.midasiumOreBlock);
					CrucibleRegistry.register(Registries.mithrilOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.mithril"), dustCostGeneral, Registries.mithrilOreBlock);
					CrucibleRegistry.register(Registries.orichalcumOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.orichalcum"), dustCostGeneral, Registries.orichalcumOreBlock);
					CrucibleRegistry.register(Registries.oureclaseOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.oureclase"), dustCostGeneral, Registries.oureclaseOreBlock);
					CrucibleRegistry.register(Registries.prometheumOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.prometheum"), dustCostGeneral, Registries.prometheumOreBlock);
					CrucibleRegistry.register(Registries.rubraciumOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.rubracium"), dustCostGeneral, Registries.rubraciumOreBlock);
					CrucibleRegistry.register(Registries.sanguiniteOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.sanguinite"), dustCostGeneral, Registries.sanguiniteOreBlock);
					CrucibleRegistry.register(Registries.vulcaniteOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.vulcanite"), dustCostGeneral, Registries.vulcaniteOreBlock);
					CrucibleRegistry.register(Registries.vyroxeresOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.vyroxeres"), dustCostGeneral, Registries.vyroxeresOreBlock);
					CrucibleRegistry.register(Registries.zincOreItem.itemID, i, dustCostGeneral*2, getFluid("molten.zinc"), dustCostGeneral, Registries.zincOreBlock);
				}
			}
		}
	}
}
