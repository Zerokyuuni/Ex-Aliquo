package exaliquo.bridges.crossmod;

import static exaliquo.data.ModIDs.getIDs;
import static exaliquo.data.ModIDs.getItem;
import static exaliquo.data.MoltenMetals.*;
import static net.minecraftforge.fluids.FluidRegistry.getFluid;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import tconstruct.library.crafting.Smeltery;
import exaliquo.data.ModIDs.Info;

public class ArsMagica_Tinker
{

	protected static void SmeltArs()
	{
		for (int i = 0; i < 10; i++)
		{
			Smeltery.addMelting(new ItemStack(getItem(Info.essences), 1, i), getIDs(Info.essenceBlock), 0, 800, new FluidStack(getFluid("liquidessence"), 1000));
		}
	}
}
