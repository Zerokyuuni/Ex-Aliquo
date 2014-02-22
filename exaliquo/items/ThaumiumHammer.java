package exaliquo.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import thaumcraft.api.IRepairable;
import exnihilo.items.hammers.ItemHammerBase;

public class ThaumiumHammer extends ItemHammerBase implements IRepairable
{

	public ThaumiumHammer(int id, EnumToolMaterial material) {
		super(id, material);
	}
	
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon("exaliquo:HammerThaumium");
	}
}