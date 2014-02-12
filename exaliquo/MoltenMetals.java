package exaliquo;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import static net.minecraftforge.fluids.FluidRegistry.getFluid;
import net.minecraftforge.fluids.FluidStack;

import static cpw.mods.fml.common.registry.GameRegistry.findItem;
import static cpw.mods.fml.common.registry.GameRegistry.findBlock;

import tconstruct.TConstruct;
import tconstruct.library.crafting.Smeltery;
import exnihilo.registries.CrucibleRegistry;

import static exaliquo.ModIDs.getIDs;
import static exaliquo.ModIDs.getItem;
import exaliquo.ModIDs.Info;

public class MoltenMetals {
	
	public static final int ingotcostSmeltery = TConstruct.ingotLiquidValue * (Configurations.isOre?2:1);
	public static final int ingotcostCrucible = TConstruct.ingotLiquidValue;
	public static final int dustvalue = (Configurations.dustValue?4:6);
	public static final String exnihilo = "crowley.skyblock";
	
	public static void addToSmelting()
	{
		Block IronOre = findBlock(exnihilo, "iron_ore");
		Block GoldOre = findBlock(exnihilo, "gold_ore");
		Block CopperOre = findBlock(exnihilo, "copper_ore");
		Block TinOre = findBlock(exnihilo, "tin_ore");
		Block SilverOre = findBlock(exnihilo, "silver_ore");
		Block LeadOre = findBlock(exnihilo, "lead_ore");
		Block NickelOre = findBlock(exnihilo, "nickel_ore");
		Block PlatinumOre = findBlock(exnihilo, "platinum_ore");
		Block AluminumOre = findBlock(exnihilo, "aluminum_ore");
		
		Smeltery.addMelting(IronOre, 0, 600, new FluidStack(getFluid("iron.molten"), ingotcostSmeltery));
		Smeltery.addMelting(IronOre, 1, 600, new FluidStack(getFluid("iron.molten"), ingotcostSmeltery));
		Smeltery.addMelting(IronOre, 2, 600, new FluidStack(getFluid("iron.molten"), ingotcostSmeltery));
		
		Smeltery.addMelting(GoldOre, 0, 400, new FluidStack(getFluid("gold.molten"), ingotcostSmeltery));
		Smeltery.addMelting(GoldOre, 1, 400, new FluidStack(getFluid("gold.molten"), ingotcostSmeltery));
		Smeltery.addMelting(GoldOre, 2, 400, new FluidStack(getFluid("gold.molten"), ingotcostSmeltery));
		
		Smeltery.addMelting(CopperOre, 0, 550, new FluidStack(getFluid("copper.molten"), ingotcostSmeltery));
		Smeltery.addMelting(CopperOre, 1, 550, new FluidStack(getFluid("copper.molten"), ingotcostSmeltery));
		Smeltery.addMelting(CopperOre, 2, 550, new FluidStack(getFluid("copper.molten"), ingotcostSmeltery));
		
		Smeltery.addMelting(TinOre, 0, 400, new FluidStack(getFluid("tin.molten"), ingotcostSmeltery));
		Smeltery.addMelting(TinOre, 1, 400, new FluidStack(getFluid("tin.molten"), ingotcostSmeltery));
		Smeltery.addMelting(TinOre, 2, 400, new FluidStack(getFluid("tin.molten"), ingotcostSmeltery));
		
		Smeltery.addMelting(SilverOre, 0, 400, new FluidStack(getFluid("silver.molten"), ingotcostSmeltery));
		Smeltery.addMelting(SilverOre, 1, 400, new FluidStack(getFluid("silver.molten"), ingotcostSmeltery));
		Smeltery.addMelting(SilverOre, 2, 400, new FluidStack(getFluid("silver.molten"), ingotcostSmeltery));
		
		Smeltery.addMelting(LeadOre, 0, 400, new FluidStack(getFluid("lead.molten"), ingotcostSmeltery));
		Smeltery.addMelting(LeadOre, 1, 400, new FluidStack(getFluid("lead.molten"), ingotcostSmeltery));
		Smeltery.addMelting(LeadOre, 2, 400, new FluidStack(getFluid("lead.molten"), ingotcostSmeltery));
		
		Smeltery.addMelting(NickelOre, 0, 400, new FluidStack(getFluid("nickel.molten"), ingotcostSmeltery));
		Smeltery.addMelting(NickelOre, 1, 400, new FluidStack(getFluid("nickel.molten"), ingotcostSmeltery));
		Smeltery.addMelting(NickelOre, 2, 400, new FluidStack(getFluid("nickel.molten"), ingotcostSmeltery));
		
		Smeltery.addMelting(PlatinumOre, 0, 400, new FluidStack(getFluid("platinum.molten"), ingotcostSmeltery));
		Smeltery.addMelting(PlatinumOre, 1, 400, new FluidStack(getFluid("platinum.molten"), ingotcostSmeltery));
		Smeltery.addMelting(PlatinumOre, 2, 400, new FluidStack(getFluid("platinum.molten"), ingotcostSmeltery));
		
		Smeltery.addMelting(AluminumOre, 0, 400, new FluidStack(getFluid("aluminum.molten"), ingotcostSmeltery));
		Smeltery.addMelting(AluminumOre, 1, 400, new FluidStack(getFluid("aluminum.molten"), ingotcostSmeltery));
		Smeltery.addMelting(AluminumOre, 2, 400, new FluidStack(getFluid("aluminum.molten"), ingotcostSmeltery));
		if (Configurations.miniSmelting)
		{
			CrucibleRegistry.register(IronOre.blockID, 0, ingotcostCrucible*2, getFluid("iron.molten"), ingotcostCrucible, IronOre);
			CrucibleRegistry.register(IronOre.blockID, 1, ingotcostCrucible*2, getFluid("iron.molten"), ingotcostCrucible, IronOre);
			CrucibleRegistry.register(IronOre.blockID, 2, ingotcostCrucible*2, getFluid("iron.molten"), ingotcostCrucible, IronOre);
			
			CrucibleRegistry.register(GoldOre.blockID, 0, ingotcostCrucible*2, getFluid("gold.molten"), ingotcostCrucible, GoldOre);
			CrucibleRegistry.register(GoldOre.blockID, 1, ingotcostCrucible*2, getFluid("gold.molten"), ingotcostCrucible, GoldOre);
			CrucibleRegistry.register(GoldOre.blockID, 2, ingotcostCrucible*2, getFluid("gold.molten"), ingotcostCrucible, GoldOre);
			
			CrucibleRegistry.register(CopperOre.blockID, 0, ingotcostCrucible*2, getFluid("copper.molten"), ingotcostCrucible, CopperOre);
			CrucibleRegistry.register(CopperOre.blockID, 1, ingotcostCrucible*2, getFluid("copper.molten"), ingotcostCrucible, CopperOre);
			CrucibleRegistry.register(CopperOre.blockID, 2, ingotcostCrucible*2, getFluid("copper.molten"), ingotcostCrucible, CopperOre);
			
			CrucibleRegistry.register(TinOre.blockID, 0, ingotcostCrucible*2, getFluid("tin.molten"), ingotcostCrucible, TinOre);
			CrucibleRegistry.register(TinOre.blockID, 1, ingotcostCrucible*2, getFluid("tin.molten"), ingotcostCrucible, TinOre);
			CrucibleRegistry.register(TinOre.blockID, 2, ingotcostCrucible*2, getFluid("tin.molten"), ingotcostCrucible, TinOre);
			
			CrucibleRegistry.register(SilverOre.blockID, 0, ingotcostCrucible*2, getFluid("silver.molten"), ingotcostCrucible, SilverOre);
			CrucibleRegistry.register(SilverOre.blockID, 1, ingotcostCrucible*2, getFluid("silver.molten"), ingotcostCrucible, SilverOre);
			CrucibleRegistry.register(SilverOre.blockID, 2, ingotcostCrucible*2, getFluid("silver.molten"), ingotcostCrucible, SilverOre);
			
			CrucibleRegistry.register(LeadOre.blockID, 0, ingotcostCrucible*2, getFluid("lead.molten"), ingotcostCrucible, LeadOre);
			CrucibleRegistry.register(LeadOre.blockID, 1, ingotcostCrucible*2, getFluid("lead.molten"), ingotcostCrucible, LeadOre);
			CrucibleRegistry.register(LeadOre.blockID, 2, ingotcostCrucible*2, getFluid("lead.molten"), ingotcostCrucible, LeadOre);
			
			CrucibleRegistry.register(NickelOre.blockID, 0, ingotcostCrucible*2, getFluid("nickel.molten"), ingotcostCrucible, NickelOre);
			CrucibleRegistry.register(NickelOre.blockID, 1, ingotcostCrucible*2, getFluid("nickel.molten"), ingotcostCrucible, NickelOre);
			CrucibleRegistry.register(NickelOre.blockID, 2, ingotcostCrucible*2, getFluid("nickel.molten"), ingotcostCrucible, NickelOre);
			
			CrucibleRegistry.register(PlatinumOre.blockID, 0, ingotcostCrucible*2, getFluid("platinum.molten"), ingotcostCrucible, PlatinumOre);
			CrucibleRegistry.register(PlatinumOre.blockID, 1, ingotcostCrucible*2, getFluid("platinum.molten"), ingotcostCrucible, PlatinumOre);
			CrucibleRegistry.register(PlatinumOre.blockID, 2, ingotcostCrucible*2, getFluid("platinum.molten"), ingotcostCrucible, PlatinumOre);
			
			CrucibleRegistry.register(AluminumOre.blockID, 0, ingotcostCrucible*2, getFluid("aluminum.molten"), ingotcostCrucible, AluminumOre);
			CrucibleRegistry.register(AluminumOre.blockID, 1, ingotcostCrucible*2, getFluid("aluminum.molten"), ingotcostCrucible, AluminumOre);
			CrucibleRegistry.register(AluminumOre.blockID, 2, ingotcostCrucible*2, getFluid("aluminum.molten"), ingotcostCrucible, AluminumOre);
		}
		if (Configurations.allowDustSmelting)
		{
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "iron_broken"),4,0), IronOre.blockID, 0, 600, new FluidStack(getFluid("iron.molten"), ingotcostSmeltery/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "iron_crushed"),4,0), IronOre.blockID, 1, 600, new FluidStack(getFluid("iron.molten"), ingotcostSmeltery/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "iron_pulverized"),4,0), IronOre.blockID, 2, 600, new FluidStack(getFluid("iron.molten"), ingotcostSmeltery/dustvalue));
			
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "gold_broken"),4,0), GoldOre.blockID, 0, 400, new FluidStack(getFluid("gold.molten"), ingotcostSmeltery/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "gold_crushed"),4,0), GoldOre.blockID, 1, 400, new FluidStack(getFluid("gold.molten"), ingotcostSmeltery/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "gold_pulverized"),4,0), GoldOre.blockID, 2, 400, new FluidStack(getFluid("gold.molten"), ingotcostSmeltery/dustvalue));
			
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "copper_broken"),4,0), CopperOre.blockID, 0, 550, new FluidStack(getFluid("copper.molten"), ingotcostSmeltery/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "copper_crushed"),4,0), CopperOre.blockID, 1, 550, new FluidStack(getFluid("copper.molten"), ingotcostSmeltery/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "copper_pulverized"),4,0), CopperOre.blockID, 2, 550, new FluidStack(getFluid("copper.molten"), ingotcostSmeltery/dustvalue));
			
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "tin_broken"),4,0), TinOre.blockID, 0, 400, new FluidStack(getFluid("tin.molten"), ingotcostSmeltery/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "tin_crushed"),4,0), TinOre.blockID, 1, 400, new FluidStack(getFluid("tin.molten"), ingotcostSmeltery/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "tin_pulverized"),4,0), TinOre.blockID, 2, 400, new FluidStack(getFluid("tin.molten"), ingotcostSmeltery/dustvalue));
			
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "silver_broken"),4,0), SilverOre.blockID, 0, 400, new FluidStack(getFluid("silver.molten"), ingotcostSmeltery/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "silver_crushed"),4,0), SilverOre.blockID, 1, 400, new FluidStack(getFluid("silver.molten"), ingotcostSmeltery/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "silver_pulverized"),4,0), SilverOre.blockID, 2, 400, new FluidStack(getFluid("silver.molten"), ingotcostSmeltery/dustvalue));
			
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "lead_broken"),4,0), LeadOre.blockID, 0, 400, new FluidStack(getFluid("lead.molten"), ingotcostSmeltery/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "lead_crushed"),4,0), LeadOre.blockID, 1, 400, new FluidStack(getFluid("lead.molten"), ingotcostSmeltery/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "lead_pulverized"),4,0), LeadOre.blockID, 2, 400, new FluidStack(getFluid("lead.molten"), ingotcostSmeltery/dustvalue));
			
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "nickel_broken"),4,0), NickelOre.blockID, 0, 400, new FluidStack(getFluid("nickel.molten"), ingotcostSmeltery/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "nickel_crushed"),4,0), NickelOre.blockID, 1, 400, new FluidStack(getFluid("nickel.molten"), ingotcostSmeltery/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "nickel_pulverized"),4,0), NickelOre.blockID, 2, 400, new FluidStack(getFluid("nickel.molten"), ingotcostSmeltery/dustvalue));
			
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "platinum_broken"),4,0), PlatinumOre.blockID, 0, 400, new FluidStack(getFluid("platinum.molten"), ingotcostSmeltery/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "platinum_crushed"),4,0), PlatinumOre.blockID, 1, 400, new FluidStack(getFluid("platinum.molten"), ingotcostSmeltery/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "platinum_pulverized"),4,0), PlatinumOre.blockID, 2, 400, new FluidStack(getFluid("platinum.molten"), ingotcostSmeltery/dustvalue));
			
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "aluminum_broken"),4,0), AluminumOre.blockID, 0, 400, new FluidStack(getFluid("aluminum.molten"), ingotcostSmeltery/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "aluminum_crushed"),4,0), AluminumOre.blockID, 1, 400, new FluidStack(getFluid("aluminum.molten"), ingotcostSmeltery/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "aluminum_pulverized"),4,0), AluminumOre.blockID, 2, 400, new FluidStack(getFluid("aluminum.molten"), ingotcostSmeltery/dustvalue));
			
			CrucibleRegistry.register(findItem(exnihilo, "iron_broken").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("iron.molten"), ingotcostCrucible/dustvalue, IronOre);
			CrucibleRegistry.register(findItem(exnihilo, "iron_crushed").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("iron.molten"), ingotcostCrucible/dustvalue, IronOre);
			CrucibleRegistry.register(findItem(exnihilo, "iron_pulverized").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("iron.molten"), ingotcostCrucible/dustvalue, IronOre);
			
			CrucibleRegistry.register(findItem(exnihilo, "gold_broken").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("gold.molten"), ingotcostCrucible/dustvalue, GoldOre);
			CrucibleRegistry.register(findItem(exnihilo, "gold_crushed").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("gold.molten"), ingotcostCrucible/dustvalue, GoldOre);
			CrucibleRegistry.register(findItem(exnihilo, "gold_pulverized").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("gold.molten"), ingotcostCrucible/dustvalue, GoldOre);
			
			CrucibleRegistry.register(findItem(exnihilo, "copper_broken").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("copper.molten"), ingotcostCrucible/dustvalue, CopperOre);
			CrucibleRegistry.register(findItem(exnihilo, "copper_crushed").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("copper.molten"), ingotcostCrucible/dustvalue, CopperOre);
			CrucibleRegistry.register(findItem(exnihilo, "copper_pulverized").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("copper.molten"), ingotcostCrucible/dustvalue, CopperOre);
			
			CrucibleRegistry.register(findItem(exnihilo, "tin_broken").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("tin.molten"), ingotcostCrucible/dustvalue, TinOre);
			CrucibleRegistry.register(findItem(exnihilo, "tin_crushed").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("tin.molten"), ingotcostCrucible/dustvalue, TinOre);
			CrucibleRegistry.register(findItem(exnihilo, "tin_pulverized").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("tin.molten"), ingotcostCrucible/dustvalue, TinOre);
			
			CrucibleRegistry.register(findItem(exnihilo, "silver_broken").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("silver.molten"), ingotcostCrucible/dustvalue, SilverOre);
			CrucibleRegistry.register(findItem(exnihilo, "silver_crushed").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("silver.molten"), ingotcostCrucible/dustvalue, SilverOre);
			CrucibleRegistry.register(findItem(exnihilo, "silver_pulverized").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("silver.molten"), ingotcostCrucible/dustvalue, SilverOre);
			
			CrucibleRegistry.register(findItem(exnihilo, "lead_broken").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("lead.molten"), ingotcostCrucible/dustvalue, LeadOre);
			CrucibleRegistry.register(findItem(exnihilo, "lead_crushed").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("lead.molten"), ingotcostCrucible/dustvalue, LeadOre);
			CrucibleRegistry.register(findItem(exnihilo, "lead_pulverized").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("lead.molten"), ingotcostCrucible/dustvalue, LeadOre);
			
			CrucibleRegistry.register(findItem(exnihilo, "nickel_broken").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("nickel.molten"), ingotcostCrucible/dustvalue, NickelOre);
			CrucibleRegistry.register(findItem(exnihilo, "nickel_crushed").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("nickel.molten"), ingotcostCrucible/dustvalue, NickelOre);
			CrucibleRegistry.register(findItem(exnihilo, "nickel_pulverized").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("nickel.molten"), ingotcostCrucible/dustvalue, NickelOre);
			
			CrucibleRegistry.register(findItem(exnihilo, "platinum_broken").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("platinum.molten"), ingotcostCrucible/dustvalue, PlatinumOre);
			CrucibleRegistry.register(findItem(exnihilo, "platinum_crushed").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("platinum.molten"), ingotcostCrucible/dustvalue, PlatinumOre);
			CrucibleRegistry.register(findItem(exnihilo, "platinum_pulverized").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("platinum.molten"), ingotcostCrucible/dustvalue, PlatinumOre);
			
			CrucibleRegistry.register(findItem(exnihilo, "aluminum_broken").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("aluminum.molten"), ingotcostCrucible/dustvalue, AluminumOre);
			CrucibleRegistry.register(findItem(exnihilo, "aluminum_crushed").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("aluminum.molten"), ingotcostCrucible/dustvalue, AluminumOre);
			CrucibleRegistry.register(findItem(exnihilo, "aluminum_pulverized").itemID, 0, ingotcostCrucible/dustvalue*2, getFluid("aluminum.molten"), ingotcostCrucible/dustvalue, AluminumOre);
		}
		
		CrucibleRegistry.register(Block.sand.blockID, 0, 2000, getFluid("glass.molten"), 1000, Block.sand);
		CrucibleRegistry.register(Block.glass.blockID, 0, 2000, getFluid("glass.molten"), 1000, Block.glass);
		CrucibleRegistry.register(findItem(exnihilo,"stone").itemID, 0, 2, getFluid("stone.seared"), 2, Block.cobblestone);
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
}
