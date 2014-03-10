package exaliquo.items;

import net.minecraft.client.renderer.texture.IconRegister;
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
}
