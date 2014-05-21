package exaliquo.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import exnihilo.items.ItemCrook;

public class ReedCrook extends ItemCrook
{
	public ReedCrook(int id)
	{
		super(id, EnumToolMaterial.STONE);
		this.setMaxDamage((int)((float)this.getMaxDamage() * 3.1));
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return "item.ExAliquo.ReedCrook";
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon("exaliquo:CrookReed");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean flag)
	{
		list.add("Not to be confused with a snorklecrook");
	}
}
