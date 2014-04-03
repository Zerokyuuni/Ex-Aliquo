package exaliquo.bridges.TConstruct;

import static exaliquo.data.ModIDs.getItem;
import net.minecraft.item.ItemStack;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.client.TConstructClientRegistry;
import tconstruct.library.crafting.ToolBuilder;
import exaliquo.Registries;
import exaliquo.bridges.TConstruct.Modifiers.ModCrooked;
import exaliquo.bridges.TConstruct.Modifiers.ModHammered;
import exaliquo.data.ModIDs.Info;

public class TConstruct
{

	public static void initTConstruct()
	{
		Colors.ColorTConstruct();
		Composting.CompostTConstruct();
		Smelting.SmeltTConstruct();
		Sieving.SieveTConstruct();
		Hammering.HammerTConstruct();
		Heat.HeatTConstruct();
		OreDict.addExTConstructOreDict();
		addModifiers();
	}
	
	static void addModifiers()
	{
		ToolBuilder.instance.registerToolMod(new ModCrooked(new ItemStack[] { new ItemStack(Registries.crookGold, 1, 0) }, 60));
		TConstructClientRegistry.addEffectRenderMapping(60, "exaliquo", "crook", true);
		
		ToolBuilder.instance.registerToolMod(new ModHammered(new ItemStack[] { new ItemStack(getItem(Info.diamondhammer), 1, 0) }, 61));
		TConstructClientRegistry.addEffectRenderMapping(61, "exaliquo", "hammer", true);
		
		TConstructRegistry.registerActiveToolMod(new SkyModifiers());
	}
}
