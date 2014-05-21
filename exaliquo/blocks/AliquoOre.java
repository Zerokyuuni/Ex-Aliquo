package exaliquo.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exaliquo.Registries;
import net.minecraft.block.BlockSand;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class AliquoOre extends BlockSand
{

	@SideOnly(Side.CLIENT)
	private Icon[] icon;
	
	public AliquoOre(int id) {
		super(id);
		setHardness(0.4F);
		setStepSound(soundSandFootstep);
		setCreativeTab(Registries.oretab);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register)
	{
		icon = new Icon[3];
		
		for (int i = 0; i < icon.length; i++)
		{
			icon[i] = register.registerIcon("exaliquo:" + Registries.oreType[i] + "/Block" + this.getUnlocalizedName().substring(5) + Registries.oreType[i]);
		}
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int id, int meta)
	{
		return icon[meta];
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(int id, CreativeTabs tabs, List subItems)
	{
		for (int i = 0; i < 3; i++) {
			subItems.add(new ItemStack(id, 1, i));
		}
	}
	
	@Override
	public int damageDropped (int meta)
	{
		return meta;
	}
}
