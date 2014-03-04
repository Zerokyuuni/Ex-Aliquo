package exaliquo.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import exaliquo.data.ToolMaterials;
import exaliquo.data.ModIDs.Info;
import static exaliquo.data.ModIDs.getItem;
import exnihilo.items.hammers.ItemHammerBase;

public class ThaumiumHammer extends ItemHammerBase
{
	public ThaumiumHammer(int id, EnumToolMaterial material) {
		super(id, material);
	}
	
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon("exaliquo:HammerThaumium");
	}
	
	public EnumRarity getRarity()
	{
		return EnumRarity.uncommon;
	}
	
	public boolean getIsRepairable(ItemStack tool, ItemStack ingot)
	{
		return ToolMaterials.isOreDict(ingot, "ingotThaumium");
	}
}