package exaliquo.items;

import thaumcraft.api.IRepairable;
import cpw.mods.fml.common.Optional.Interface;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import exaliquo.data.OreDict;
import exaliquo.data.ModIDs.Info;
import static exaliquo.data.ModIDs.getItem;
import exnihilo.items.hammers.ItemHammerBase;

@Interface(iface="thaumcraft.api.IRepairable", modid="Thaumcraft")
public class ThaumiumHammer extends ItemHammerBase implements IRepairable
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
		return OreDict.isOreDict(ingot, "ingotThaumium");
	}
}