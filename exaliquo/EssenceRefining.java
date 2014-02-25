package exaliquo;

import static cpw.mods.fml.common.registry.GameRegistry.findItem;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

import static exaliquo.data.ModIDs.getBlock;
import static exaliquo.data.ModIDs.getItem;
import exaliquo.data.ModIDs.Info;

public class EssenceRefining
{
	private static final Item witchwater = findItem("crowley.skyblock","bucket_witchwater");
	
	public static void addNihiloToArs()
	{
		//Temporary until API update
		GameRegistry.addRecipe(new ItemStack(getItem(Info.essenceBucket), 1, 0), "ewe", "wbw","ewe", 'w', witchwater, 'b', Item.bucketEmpty, 'e', Item.emerald);
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(getBlock(Info.witchwood), 4, 0), "ses", "ewe", "ses",  'w', witchwater, 's', "treeSapling", 'e', getItem(Info.essenceBucket)));
		GameRegistry.addRecipe(new ItemStack(getBlock(Info.wakebloom), 4, 0), "lel", "ewe", "lel", 'l', Block.waterlily, 'w', witchwater, 'e', getItem(Info.essenceBucket));
	}
}
