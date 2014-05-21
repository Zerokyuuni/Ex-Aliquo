package exaliquo.items;

import static exaliquo.data.ModIDs.getIDs;
import static exaliquo.data.ModIDs.getItem;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exaliquo.data.ModIDs.Info;
import exaliquo.data.ModsLoaded;
import exnihilo.data.ModData;
import exnihilo.items.ItemCrook;
import static exaliquo.proxy.ForestryReflection.*;

public class GoldCrook extends ItemCrook
{
	private Class forestryLeafBlock = null;
	private Method drops = null;
	private boolean extras = false;
	private boolean forestryrefcheck = true;
	
	public GoldCrook(int id)
	{
		super(id, EnumToolMaterial.GOLD);
		this.setMaxDamage(this.getMaxDamage()/2-1);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return "item.ExAliquo.GoldCrook";
	}
	
	@Override
	public void registerIcons(IconRegister register)
	{
		this.itemIcon = register.registerIcon("exaliquo:CrookGold");
	}
	
	@Override
	public boolean onBlockStartBreak(ItemStack item, int X, int Y, int Z, EntityPlayer player)
	{
		World world = player.worldObj;
		int blockID = world.getBlockId(X,Y,Z);
		int meta = world.getBlockMetadata(X, Y, Z);
		boolean validTarget = false;
		boolean extraDropped = false;

		Block block = Block.blocksList[blockID];

		if (block.isLeaves(null, 0, 0, 0))
		{
			if (!world.isRemote)
			{
				if (forestryrefcheck && ModsLoaded.isForestryLoaded)
				{
					ForestryLeaves(world, block, meta, X, Y, Z);
					ForestryLeaves(world, block, meta, X, Y, Z);
					ForestryLeaves(world, block, meta, X, Y, Z);
				}

				if (!extras)
				{
					block.dropBlockAsItem(world, X, Y, Z, meta, 0);
					block.dropBlockAsItem(world, X, Y, Z, meta, 0);
					block.dropBlockAsItem(world, X, Y, Z, meta, 0);
				}

				if (ModData.ALLOW_SILKWORMS && world.rand.nextInt(75) == 0)
				{
					world.spawnEntityInWorld(new EntityItem(world, X + 0.5D, Y + 0.5D, Z + 0.5D, new ItemStack(getItem(Info.silkworm), 1, 0)));
				}
			}
		}

		if (blockID == getIDs(Info.silkleaves))
		{
			if (!world.isRemote)
			{
				if (ModData.ALLOW_SILKWORMS && world.rand.nextInt(10) == 0)
				{
					world.spawnEntityInWorld(new EntityItem(world, X + 0.5D, Y + 0.5D, Z + 0.5D, new ItemStack(getItem(Info.silkworm), 1, 0)));
				}
			}
		}
		
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean flag)
	{
		list.add("I am probably a crook");
	}
}
