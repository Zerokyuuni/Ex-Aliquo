package exaliquo;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

import cpw.mods.fml.common.registry.GameRegistry;

import tconstruct.TConstruct;
import tconstruct.library.crafting.FluidType;
import tconstruct.library.crafting.Smeltery;

public class MoltenMetals {
	
	public static final int ingotcost = TConstruct.ingotLiquidValue * (Configurations.isOre?2:1);
	public static final String exnihilo = "crowley.skyblock";
	public static void addToSmelting()
	{
		Block IronOre = GameRegistry.findBlock(exnihilo, "iron_ore");
		Block GoldOre = GameRegistry.findBlock(exnihilo, "gold_ore");
		Block CopperOre = GameRegistry.findBlock(exnihilo, "copper_ore");
		Block TinOre = GameRegistry.findBlock(exnihilo, "tin_ore");
		Block SilverOre = GameRegistry.findBlock(exnihilo, "silver_ore");
		Block LeadOre = GameRegistry.findBlock(exnihilo, "lead_ore");
		Block NickelOre = GameRegistry.findBlock(exnihilo, "nickel_ore");
		Block PlatinumOre = GameRegistry.findBlock(exnihilo, "platinum_ore");
		
		Smeltery.addMelting(IronOre, 0, 600, new FluidStack(FluidRegistry.getFluid("iron.molten"), ingotcost));
		Smeltery.addMelting(IronOre, 1, 600, new FluidStack(FluidRegistry.getFluid("iron.molten"), ingotcost));
		Smeltery.addMelting(IronOre, 2, 600, new FluidStack(FluidRegistry.getFluid("iron.molten"), ingotcost));
		
		Smeltery.addMelting(GoldOre, 0, 400, new FluidStack(FluidRegistry.getFluid("gold.molten"), ingotcost));
		Smeltery.addMelting(GoldOre, 1, 400, new FluidStack(FluidRegistry.getFluid("gold.molten"), ingotcost));
		Smeltery.addMelting(GoldOre, 2, 400, new FluidStack(FluidRegistry.getFluid("gold.molten"), ingotcost));
		
		Smeltery.addMelting(CopperOre, 0, 550, new FluidStack(FluidRegistry.getFluid("copper.molten"), ingotcost));
		Smeltery.addMelting(CopperOre, 1, 550, new FluidStack(FluidRegistry.getFluid("copper.molten"), ingotcost));
		Smeltery.addMelting(CopperOre, 2, 550, new FluidStack(FluidRegistry.getFluid("copper.molten"), ingotcost));
		
		Smeltery.addMelting(TinOre, 0, 400, new FluidStack(FluidRegistry.getFluid("tin.molten"), ingotcost));
		Smeltery.addMelting(TinOre, 1, 400, new FluidStack(FluidRegistry.getFluid("tin.molten"), ingotcost));
		Smeltery.addMelting(TinOre, 2, 400, new FluidStack(FluidRegistry.getFluid("tin.molten"), ingotcost));
		
		Smeltery.addMelting(SilverOre, 0, 400, new FluidStack(FluidRegistry.getFluid("silver.molten"), ingotcost));
		Smeltery.addMelting(SilverOre, 1, 400, new FluidStack(FluidRegistry.getFluid("silver.molten"), ingotcost));
		Smeltery.addMelting(SilverOre, 2, 400, new FluidStack(FluidRegistry.getFluid("silver.molten"), ingotcost));
		
		Smeltery.addMelting(LeadOre, 0, 400, new FluidStack(FluidRegistry.getFluid("lead.molten"), ingotcost));
		Smeltery.addMelting(LeadOre, 1, 400, new FluidStack(FluidRegistry.getFluid("lead.molten"), ingotcost));
		Smeltery.addMelting(LeadOre, 2, 400, new FluidStack(FluidRegistry.getFluid("lead.molten"), ingotcost));
		
		Smeltery.addMelting(NickelOre, 0, 400, new FluidStack(FluidRegistry.getFluid("nickel.molten"), ingotcost));
		Smeltery.addMelting(NickelOre, 1, 400, new FluidStack(FluidRegistry.getFluid("nickel.molten"), ingotcost));
		Smeltery.addMelting(NickelOre, 2, 400, new FluidStack(FluidRegistry.getFluid("nickel.molten"), ingotcost));
		
		Smeltery.addMelting(PlatinumOre, 0, 400, new FluidStack(FluidRegistry.getFluid("platinum.molten"), ingotcost));
		Smeltery.addMelting(PlatinumOre, 1, 400, new FluidStack(FluidRegistry.getFluid("platinum.molten"), ingotcost));
		Smeltery.addMelting(PlatinumOre, 2, 400, new FluidStack(FluidRegistry.getFluid("platinum.molten"), ingotcost));
		
		if (Configurations.allowDustSmelting)
		{
			Item IronDust1 = GameRegistry.findItem(exnihilo, "iron_broken");
			Item IronDust2 = GameRegistry.findItem(exnihilo, "iron_crushed");
			Item IronDust3 = GameRegistry.findItem(exnihilo, "iron_pulverized");
			
			Item GoldDust1 = GameRegistry.findItem(exnihilo, "gold_broken");
			Item GoldDust2 = GameRegistry.findItem(exnihilo, "gold_crushed");
			Item GoldDust3 = GameRegistry.findItem(exnihilo, "gold_pulverized");
			
			Item CopperDust1 = GameRegistry.findItem(exnihilo, "copper_broken");
			Item CopperDust2 = GameRegistry.findItem(exnihilo, "copper_crushed");
			Item CopperDust3 = GameRegistry.findItem(exnihilo, "copper_pulverized");
			
			Item TinDust1 = GameRegistry.findItem(exnihilo, "tin_broken");
			Item TinDust2 = GameRegistry.findItem(exnihilo, "tin_crushed");
			Item TinDust3 = GameRegistry.findItem(exnihilo, "tin_pulverized");
			
			Item SilverDust1 = GameRegistry.findItem(exnihilo, "silver_broken");
			Item SilverDust2 = GameRegistry.findItem(exnihilo, "silver_crushed");
			Item SilverDust3 = GameRegistry.findItem(exnihilo, "silver_pulverized");
			
			Item LeadDust1 = GameRegistry.findItem(exnihilo, "lead_broken");
			Item LeadDust2 = GameRegistry.findItem(exnihilo, "lead_crushed");
			Item LeadDust3 = GameRegistry.findItem(exnihilo, "lead_pulverized");
			
			Item NickelDust1 = GameRegistry.findItem(exnihilo, "nickel_broken");
			Item NickelDust2 = GameRegistry.findItem(exnihilo, "nickel_crushed");
			Item NickelDust3 = GameRegistry.findItem(exnihilo, "nickel_pulverized");
			
			Item PlatinumDust1 = GameRegistry.findItem(exnihilo, "platinum_broken");
			Item PlatinumDust2 = GameRegistry.findItem(exnihilo, "platinum_crushed");
			Item PlatinumDust3 = GameRegistry.findItem(exnihilo, "platinum_pulverized");
			
			Smeltery.addMelting(new ItemStack(IronDust1,4,0), IronOre.blockID, 0, 600, new FluidStack(FluidRegistry.getFluid("iron.molten"), ingotcost/4));
			Smeltery.addMelting(new ItemStack(IronDust2,4,0), IronOre.blockID, 1, 600, new FluidStack(FluidRegistry.getFluid("iron.molten"), ingotcost/4));
			Smeltery.addMelting(new ItemStack(IronDust3,4,0), IronOre.blockID, 2, 600, new FluidStack(FluidRegistry.getFluid("iron.molten"), ingotcost/4));
			
			Smeltery.addMelting(new ItemStack(GoldDust1,4,0), GoldOre.blockID, 0, 400, new FluidStack(FluidRegistry.getFluid("gold.molten"), ingotcost/4));
			Smeltery.addMelting(new ItemStack(GoldDust2,4,0), GoldOre.blockID, 1, 400, new FluidStack(FluidRegistry.getFluid("gold.molten"), ingotcost/4));
			Smeltery.addMelting(new ItemStack(GoldDust3,4,0), GoldOre.blockID, 2, 400, new FluidStack(FluidRegistry.getFluid("gold.molten"), ingotcost/4));
			
			Smeltery.addMelting(new ItemStack(CopperDust1,4,0), CopperOre.blockID, 0, 550, new FluidStack(FluidRegistry.getFluid("copper.molten"), ingotcost/4));
			Smeltery.addMelting(new ItemStack(CopperDust2,4,0), CopperOre.blockID, 1, 550, new FluidStack(FluidRegistry.getFluid("copper.molten"), ingotcost/4));
			Smeltery.addMelting(new ItemStack(CopperDust3,4,0), CopperOre.blockID, 2, 550, new FluidStack(FluidRegistry.getFluid("copper.molten"), ingotcost/4));
			
			Smeltery.addMelting(new ItemStack(TinDust1,4,0), TinOre.blockID, 0, 400, new FluidStack(FluidRegistry.getFluid("tin.molten"), ingotcost/4));
			Smeltery.addMelting(new ItemStack(TinDust2,4,0), TinOre.blockID, 1, 400, new FluidStack(FluidRegistry.getFluid("tin.molten"), ingotcost/4));
			Smeltery.addMelting(new ItemStack(TinDust3,4,0), TinOre.blockID, 2, 400, new FluidStack(FluidRegistry.getFluid("tin.molten"), ingotcost/4));
			
			Smeltery.addMelting(new ItemStack(SilverDust1,4,0), SilverOre.blockID, 0, 400, new FluidStack(FluidRegistry.getFluid("silver.molten"), ingotcost/4));
			Smeltery.addMelting(new ItemStack(SilverDust2,4,0), SilverOre.blockID, 1, 400, new FluidStack(FluidRegistry.getFluid("silver.molten"), ingotcost/4));
			Smeltery.addMelting(new ItemStack(SilverDust3,4,0), SilverOre.blockID, 2, 400, new FluidStack(FluidRegistry.getFluid("silver.molten"), ingotcost/4));
			
			Smeltery.addMelting(new ItemStack(LeadDust1,4,0), LeadOre.blockID, 0, 400, new FluidStack(FluidRegistry.getFluid("lead.molten"), ingotcost/4));
			Smeltery.addMelting(new ItemStack(LeadDust2,4,0), LeadOre.blockID, 1, 400, new FluidStack(FluidRegistry.getFluid("lead.molten"), ingotcost/4));
			Smeltery.addMelting(new ItemStack(LeadDust3,4,0), LeadOre.blockID, 2, 400, new FluidStack(FluidRegistry.getFluid("lead.molten"), ingotcost/4));
			
			Smeltery.addMelting(new ItemStack(NickelDust1,4,0), NickelOre.blockID, 0, 400, new FluidStack(FluidRegistry.getFluid("nickel.molten"), ingotcost/4));
			Smeltery.addMelting(new ItemStack(NickelDust2,4,0), NickelOre.blockID, 1, 400, new FluidStack(FluidRegistry.getFluid("nickel.molten"), ingotcost/4));
			Smeltery.addMelting(new ItemStack(NickelDust3,4,0), NickelOre.blockID, 2, 400, new FluidStack(FluidRegistry.getFluid("nickel.molten"), ingotcost/4));
			
			Smeltery.addMelting(new ItemStack(PlatinumDust1,4,0), PlatinumOre.blockID, 0, 400, new FluidStack(FluidRegistry.getFluid("platinum.molten"), ingotcost/4));
			Smeltery.addMelting(new ItemStack(PlatinumDust2,4,0), PlatinumOre.blockID, 1, 400, new FluidStack(FluidRegistry.getFluid("platinum.molten"), ingotcost/4));
			Smeltery.addMelting(new ItemStack(PlatinumDust3,4,0), PlatinumOre.blockID, 2, 400, new FluidStack(FluidRegistry.getFluid("platinum.molten"), ingotcost/4));
		}
	}
}
