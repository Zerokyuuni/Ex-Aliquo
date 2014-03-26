package exaliquo.items.blocks;

import exaliquo.Registries;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockOreCobalt extends ItemBlock
{
	private String name = this.getClass().getSimpleName().substring(12);
	
	public ItemBlockOreCobalt(int id)
	{
		super(id);
		setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack item)
	{
			return "block.ExAliquo."+ name + Registries.oreType[item.getItemDamage()];
	}
	
	public int getMetadata (int meta)
    {
        return meta;
    }
}
