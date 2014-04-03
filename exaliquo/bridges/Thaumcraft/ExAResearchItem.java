package exaliquo.bridges.Thaumcraft;

import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchItem;

public class ExAResearchItem extends ResearchItem
{
	public ExAResearchItem(String key, String category, AspectList tags, int col, int row, int complex, ItemStack icon) {
		super(key, category, tags, col, row, complex, icon);
	}
	
    public String getName()
    {
    	return StatCollector.translateToLocal("exa.name." + this.key);
    }
    
    public String getText()
    {
    	return StatCollector.translateToLocal("exa.flavor." + this.key);
    }
}
