package exaliquo.items;

import static com.google.common.base.CaseFormat.LOWER_CAMEL;
import static com.google.common.base.CaseFormat.UPPER_CAMEL;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import cpw.mods.fml.common.registry.GameRegistry;
import exaliquo.AliquoRegistry;
import exaliquo.data.OreDict;
import exnihilo.items.hammers.ItemHammerBase;

public class AliquoHammer extends ItemHammerBase
{
	
	private static final List<AliquoHammer> registeredHammers = Lists.newArrayList();
	
	public final String material;
	
	public AliquoHammer(int id, String material)
	{
		super(id, EnumToolMaterial.WOOD);
		this.material = material;
		setUnlocalizedName("ExAliquo." + LOWER_CAMEL.to(UPPER_CAMEL, material) + "Hammer");
	}
	
	public AliquoHammer registerItem()
	{
		GameRegistry.registerItem(this, getUnlocalizedName().substring(5));
		registeredHammers.add(this);
		return this;
	}
	
	public static Iterable<AliquoHammer> registeredHammers()
	{
		return Iterables.unmodifiableIterable(registeredHammers);
	}
	
	
	
	/**
	 * Register the texture according to the tool material enum's preference.
	 * If a preference does not exist, use the default texture.
	 */
	@Override 
	public void registerIcons(IconRegister ir)
	{
		String texture = AliquoRegistry.getHammerTexture(toolMaterial);
		itemIcon = ir.registerIcon(texture != null ? texture
				: "exaliquo:Hammer" + LOWER_CAMEL.to(UPPER_CAMEL, material));
	}
	
	/**
	 * Derive the ingot name to be used in ore dict
	 */
	public String getIngotName()
	{
		return "ingot" + LOWER_CAMEL.to(UPPER_CAMEL, material);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack tool, ItemStack ingot)
	{
		return OreDict.isOreDict(ingot, getIngotName());
	}
	
	
	
	public void setToolMaterial(EnumToolMaterial stat)
	{
		toolMaterial = stat;
		setMaxDamage(stat.getMaxUses());
		efficiencyOnProperMaterial = stat.getEfficiencyOnProperMaterial();
		damageVsEntity = 3 + stat.getDamageVsEntity();
	}
	
	@Override 
	public AliquoHammer setUnlocalizedName(String unlocalized)
	{
		super.setUnlocalizedName(unlocalized);
		return this;
	}
	
}
