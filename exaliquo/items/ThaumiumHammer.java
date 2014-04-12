package exaliquo.items;

import net.minecraft.item.EnumRarity;
import thaumcraft.api.IRepairable;
import cpw.mods.fml.common.Optional.Interface;

@Interface(iface="thaumcraft.api.IRepairable", modid="Thaumcraft")
public class ThaumiumHammer extends AliquoHammer implements IRepairable
{
	
	public ThaumiumHammer(int id)
	{
		super(id, "thaumium");
	}
	
	public EnumRarity getRarity()
	{
		return EnumRarity.uncommon;
	}
	
}