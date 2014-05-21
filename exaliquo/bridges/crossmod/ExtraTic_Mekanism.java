package exaliquo.bridges.crossmod;

import static exaliquo.data.ModIDs.getBlock;
import static exaliquo.data.ModIDs.getIDs;
import static exaliquo.data.ModIDs.getItem;
import static exaliquo.data.MoltenMetals.*;
import static net.minecraftforge.fluids.FluidRegistry.getFluid;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import tconstruct.library.crafting.Smeltery;
import exaliquo.Registries;
import exaliquo.data.Configurations;
import exaliquo.data.ModIDs.Info;
import exnihilo.registries.CrucibleRegistry;

public class ExtraTic_Mekanism
{

	protected static void SmeltMekanism()
	{
		for (int i = 0; i < 3; i++)
		{
			Smeltery.addMelting(getBlock(Info.osmiumore), i, 550, new FluidStack(getFluid("molten.osmium"), ingotCostSmeltery));
		
			if (Configurations.miniSmelting)
			{
				CrucibleRegistry.register(getIDs(Info.osmiumore), i, ingotCost*2, getFluid("molten.osmium"), ingotCost, getBlock(Info.osmiumore));
			}
		}
		
		if (Configurations.allowDustSmelting)
		{
			Smeltery.addMelting(new ItemStack(getItem(Info.osmiumgrav),4,0), getIDs(Info.osmiumore), 0, 600, new FluidStack(getFluid("molten.osmium"), dustCostSmeltery));
			Smeltery.addMelting(new ItemStack(getItem(Info.osmiumsand),4,0), getIDs(Info.osmiumore), 1, 600, new FluidStack(getFluid("molten.osmium"), dustCostSmeltery));
			Smeltery.addMelting(new ItemStack(getItem(Info.osmiumdust),4,0), getIDs(Info.osmiumore), 2, 600, new FluidStack(getFluid("molten.osmium"), dustCostSmeltery));

			if (Configurations.miniSmelting)
			{
				CrucibleRegistry.register(getItem(Info.osmiumgrav).itemID, 0, dustCostGeneral*2, getFluid("molten.osmium"), dustCostGeneral, getBlock(Info.osmiumore));
				CrucibleRegistry.register(getItem(Info.osmiumsand).itemID, 0, dustCostGeneral*2, getFluid("molten.osmium"), dustCostGeneral, getBlock(Info.osmiumore));
				CrucibleRegistry.register(getItem(Info.osmiumdust).itemID, 0, dustCostGeneral*2, getFluid("molten.osmium"), dustCostGeneral, getBlock(Info.osmiumore));
			}
		}
	}

}
