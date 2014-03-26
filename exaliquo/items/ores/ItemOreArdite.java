package exaliquo.items.ores;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exaliquo.Registries;

public class ItemOreArdite extends Item
{
	private Icon[] icon;
	private String name = this.getClass().getSimpleName().substring(7);
	
	public ItemOreArdite(int id)
	{
		super(id);
		setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack item)
	{
			return "item.ExAliquo."+ name + Registries.oreType[item.getItemDamage()];
	}
	
	public int getMetadata (int meta)
    {
        return meta;
    }
	
	public void registerIcons(IconRegister register)
	{
		icon = new Icon[3];
		
		for (int i = 0; i < icon.length; i++)
		{
			icon[i] = register.registerIcon("exaliquo:" + Registries.oreType[i] + "/Item" + name + Registries.oreType[i]);
		}
	}
	
	public Icon getIconFromDamage(int meta)
	{
		return icon[meta];
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(int id, CreativeTabs tabs, List subItems)
	{
		for (int i = 0; i < 3; i++) {
			subItems.add(new ItemStack(id, 1, i));
		}
	}
}
