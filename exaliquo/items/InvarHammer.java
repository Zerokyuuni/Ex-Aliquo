package exaliquo.items;

import static exaliquo.data.ModIDs.getItem;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import exaliquo.data.ModIDs.Info;
import exaliquo.data.ToolMaterials;
import exnihilo.items.hammers.ItemHammerBase;

public class InvarHammer extends ItemHammerBase
{
	public InvarHammer(int id, EnumToolMaterial material)
	{
		super(id, material);
	}

	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon("exaliquo:HammerInvar");
	}
	
	public boolean getIsRepairable(ItemStack tool, ItemStack ingot)
	{
		return ToolMaterials.isOreDict(ingot, "ingotInvar");
	}
}
