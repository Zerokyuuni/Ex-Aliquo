package exaliquo.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exaliquo.Registries;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class AliquoItemOre extends Item
{
	
	@SideOnly(Side.CLIENT)
	private Icon[] icon;
	//private String name = this.getUnlocalizedName().substring(5);
	
	public AliquoItemOre(int par1) {
		super(par1);
		setHasSubtypes(true);
		setCreativeTab(Registries.oretab);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
			return "item.ExAliquo." + this.getUnlocalizedName().substring(5) + Registries.oreType[item.getItemDamage()];
	}
	
	@Override
	public int getMetadata (int meta)
    {
        return meta;
    }
	
	@Override
	public void registerIcons(IconRegister register)
	{
		icon = new Icon[3];
		
		for (int i = 0; i < icon.length; i++)
		{
			icon[i] = register.registerIcon("exaliquo:" + Registries.oreType[i] + "/Item" + this.getUnlocalizedName().substring(5) + Registries.oreType[i]);
		}
	}
	
	@Override
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