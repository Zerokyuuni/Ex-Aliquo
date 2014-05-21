package exaliquo.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import exnihilo.items.ItemCrook;

public class HayCrook extends ItemCrook
{

	public HayCrook(int id)
	{
		super(id, EnumToolMaterial.WOOD);
		this.setMaxDamage(this.getMaxDamage()*8);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return "item.ExAliquo.HayCrook";
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon("exaliquo:CrookHay");
	}
	
	@Override
	public boolean onBlockStartBreak(ItemStack item, int X, int Y, int Z, EntityPlayer player)
	{
		World world = player.worldObj;
		int blockID = world.getBlockId(X,Y,Z);
		int meta = world.getBlockMetadata(X, Y, Z);
		boolean validTarget = false;
		
		Block block = Block.blocksList[blockID];
		
		if (block.isBlockReplaceable(null, 0, 0, 0))
		{
			block.dropBlockAsItem(world, X, Y, Z, meta, 2);
		}
		
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean flag)
	{
		list.add("I said Hay, Hay, Hay crook!");
		list.add("http://youtu.be/eh7lp9umG2I");
	}
}
