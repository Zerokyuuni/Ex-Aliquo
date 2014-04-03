package exaliquo.bridges.Natura;

import static exaliquo.data.ModIDs.getBlock;
import static exaliquo.data.ModIDs.getItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import exaliquo.data.ModIDs.Info;

public class Recipes
{

	protected static void CraftNatura()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(getBlock(Info.nethersoil), 1, 0), Block.dirt, getItem(Info.witchbucket));
		GameRegistry.addShapelessRecipe(new ItemStack(getBlock(Info.nethersand), 1, 0), Block.sand, getBlock(Info.thornvines), Item.blazePowder);
	}
}
