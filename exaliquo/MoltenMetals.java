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

public class MoltenMetals {
	
	public static final int ingotcost = TConstruct.ingotLiquidValue * (Configurations.isOre?2:1);
	public static final int dustvalue = (!Configurations.dustValue?4:6);
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
		
		Smeltery.addMelting(IronOre, 0, 600, new FluidStack(getFluid("iron.molten"), ingotcost));
		Smeltery.addMelting(IronOre, 1, 600, new FluidStack(getFluid("iron.molten"), ingotcost));
		Smeltery.addMelting(IronOre, 2, 600, new FluidStack(getFluid("iron.molten"), ingotcost));
		
		Smeltery.addMelting(GoldOre, 0, 400, new FluidStack(getFluid("gold.molten"), ingotcost));
		Smeltery.addMelting(GoldOre, 1, 400, new FluidStack(getFluid("gold.molten"), ingotcost));
		Smeltery.addMelting(GoldOre, 2, 400, new FluidStack(getFluid("gold.molten"), ingotcost));
		
		Smeltery.addMelting(CopperOre, 0, 550, new FluidStack(getFluid("copper.molten"), ingotcost));
		Smeltery.addMelting(CopperOre, 1, 550, new FluidStack(getFluid("copper.molten"), ingotcost));
		Smeltery.addMelting(CopperOre, 2, 550, new FluidStack(getFluid("copper.molten"), ingotcost));
		
		Smeltery.addMelting(TinOre, 0, 400, new FluidStack(getFluid("tin.molten"), ingotcost));
		Smeltery.addMelting(TinOre, 1, 400, new FluidStack(getFluid("tin.molten"), ingotcost));
		Smeltery.addMelting(TinOre, 2, 400, new FluidStack(getFluid("tin.molten"), ingotcost));
		
		Smeltery.addMelting(SilverOre, 0, 400, new FluidStack(getFluid("silver.molten"), ingotcost));
		Smeltery.addMelting(SilverOre, 1, 400, new FluidStack(getFluid("silver.molten"), ingotcost));
		Smeltery.addMelting(SilverOre, 2, 400, new FluidStack(getFluid("silver.molten"), ingotcost));
		
		Smeltery.addMelting(LeadOre, 0, 400, new FluidStack(getFluid("lead.molten"), ingotcost));
		Smeltery.addMelting(LeadOre, 1, 400, new FluidStack(getFluid("lead.molten"), ingotcost));
		Smeltery.addMelting(LeadOre, 2, 400, new FluidStack(getFluid("lead.molten"), ingotcost));
		
		Smeltery.addMelting(NickelOre, 0, 400, new FluidStack(getFluid("nickel.molten"), ingotcost));
		Smeltery.addMelting(NickelOre, 1, 400, new FluidStack(getFluid("nickel.molten"), ingotcost));
		Smeltery.addMelting(NickelOre, 2, 400, new FluidStack(getFluid("nickel.molten"), ingotcost));
		
		Smeltery.addMelting(PlatinumOre, 0, 400, new FluidStack(getFluid("platinum.molten"), ingotcost));
		Smeltery.addMelting(PlatinumOre, 1, 400, new FluidStack(getFluid("platinum.molten"), ingotcost));
		Smeltery.addMelting(PlatinumOre, 2, 400, new FluidStack(getFluid("platinum.molten"), ingotcost));
		
		if (Configurations.allowDustSmelting)
		{
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "iron_broken"),4,0), IronOre.blockID, 0, 600, new FluidStack(getFluid("iron.molten"), ingotcost/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "iron_crushed"),4,0), IronOre.blockID, 1, 600, new FluidStack(getFluid("iron.molten"), ingotcost/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "iron_pulverized"),4,0), IronOre.blockID, 2, 600, new FluidStack(getFluid("iron.molten"), ingotcost/dustvalue));
			
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "gold_broken"),4,0), GoldOre.blockID, 0, 400, new FluidStack(getFluid("gold.molten"), ingotcost/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "gold_crushed"),4,0), GoldOre.blockID, 1, 400, new FluidStack(getFluid("gold.molten"), ingotcost/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "gold_pulverized"),4,0), GoldOre.blockID, 2, 400, new FluidStack(getFluid("gold.molten"), ingotcost/dustvalue));
			
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "copper_broken"),4,0), CopperOre.blockID, 0, 550, new FluidStack(getFluid("copper.molten"), ingotcost/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "copper_crushed"),4,0), CopperOre.blockID, 1, 550, new FluidStack(getFluid("copper.molten"), ingotcost/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "copper_pulverized"),4,0), CopperOre.blockID, 2, 550, new FluidStack(getFluid("copper.molten"), ingotcost/dustvalue));
			
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "tin_broken"),4,0), TinOre.blockID, 0, 400, new FluidStack(getFluid("tin.molten"), ingotcost/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "tin_crushed"),4,0), TinOre.blockID, 1, 400, new FluidStack(getFluid("tin.molten"), ingotcost/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "tin_pulverized"),4,0), TinOre.blockID, 2, 400, new FluidStack(getFluid("tin.molten"), ingotcost/dustvalue));
			
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "silver_broken"),4,0), SilverOre.blockID, 0, 400, new FluidStack(getFluid("silver.molten"), ingotcost/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "silver_crushed"),4,0), SilverOre.blockID, 1, 400, new FluidStack(getFluid("silver.molten"), ingotcost/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "silver_pulverized"),4,0), SilverOre.blockID, 2, 400, new FluidStack(getFluid("silver.molten"), ingotcost/dustvalue));
			
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "lead_broken"),4,0), LeadOre.blockID, 0, 400, new FluidStack(getFluid("lead.molten"), ingotcost/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "lead_crushed"),4,0), LeadOre.blockID, 1, 400, new FluidStack(getFluid("lead.molten"), ingotcost/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "lead_pulverized"),4,0), LeadOre.blockID, 2, 400, new FluidStack(getFluid("lead.molten"), ingotcost/dustvalue));
			
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "nickel_broken"),4,0), NickelOre.blockID, 0, 400, new FluidStack(getFluid("nickel.molten"), ingotcost/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "nickel_crushed"),4,0), NickelOre.blockID, 1, 400, new FluidStack(getFluid("nickel.molten"), ingotcost/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "nickel_pulverized"),4,0), NickelOre.blockID, 2, 400, new FluidStack(getFluid("nickel.molten"), ingotcost/dustvalue));
			
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "platinum_broken"),4,0), PlatinumOre.blockID, 0, 400, new FluidStack(getFluid("platinum.molten"), ingotcost/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "platinum_crushed"),4,0), PlatinumOre.blockID, 1, 400, new FluidStack(getFluid("platinum.molten"), ingotcost/dustvalue));
			Smeltery.addMelting(new ItemStack(findItem(exnihilo, "platinum_pulverized"),4,0), PlatinumOre.blockID, 2, 400, new FluidStack(getFluid("platinum.molten"), ingotcost/dustvalue));
		}
	}
}
