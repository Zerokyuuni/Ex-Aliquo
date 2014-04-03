package exaliquo.bridges.TConstruct.Modifiers;

import java.util.Arrays;
import java.util.List;

import exaliquo.data.Configurations;

import tconstruct.library.tools.ToolCore;
import tconstruct.modifiers.tools.ModBoolean;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ModHammered extends ModBoolean
{

	static String name = "Hammered";
	static String color = "\u00a79";
	static String tooltip = "Smashing";
	
	public ModHammered(ItemStack[] items, int i)
	{
		super(items, i, name, color, tooltip);
	}
	
	@Override
	protected boolean canModify(ItemStack tool, ItemStack[] input)
	{
		ToolCore toolitem = (ToolCore) tool.getItem();
		if (!validType(toolitem)) return false;
		
		NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
		if (!tags.getBoolean("Lava") && !tags.hasKey("Lapis") && !tags.hasKey("Silk Touch") && !tags.hasKey("Crooked"))
		{
		    return tags.getInteger("Modifiers") > 0 && !tags.getBoolean(key);
		}
		
		return false;
	}
	
	public void modify(ItemStack[] input, ItemStack tool)
	{
		NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
		tags.setBoolean(key, true);
		
		int modifiers = tags.getInteger("Modifiers");
		modifiers -= 1;
		tags.setInteger("Modifiers", modifiers);

		int miningSpeed = tags.getInteger("MiningSpeed");
		miningSpeed -= 400;
		if (miningSpeed < 0)
		    miningSpeed = 0;
		tags.setInteger("MiningSpeed", miningSpeed);
		
		int attack = tags.getInteger("Attack");
		attack += 3;
		tags.setInteger("Attack", attack);

		addToolTip(tool, color + tooltip, color + key);
	}
	
	public boolean validType (ToolCore tool)
	{
		List list = Arrays.asList(tool.toolCategories());
		String name = tool.getToolName();
		
		if (Configurations.dualTools < 0)
		{
			return false;
		}
		else if (Configurations.dualTools == 0)
		{
			return (list.contains("harvest") || list.contains("ammo") && !list.contains("ranged") || tool.getToolName().equals("Scythe"));
		}
		else if (Configurations.dualTools == 1)
		{
			return (list.contains("harvest") || list.contains("ammo") && !list.contains("ranged"));
		}
		else
		{
			return true;
		}
	}
}
