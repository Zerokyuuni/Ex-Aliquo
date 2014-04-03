package exaliquo.items;

import static exaliquo.data.ModIDs.getIDs;
import static exaliquo.data.ModIDs.getItem;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.Loader;
import exaliquo.data.ModIDs.Info;
import exaliquo.data.ModsLoaded;
import exnihilo.data.ModData;
import exnihilo.items.ItemCrook;

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
	
	private void ForestryLeaves(World world, Block block, int meta, int X, int Y, int Z)
	{
		try
		{
			if ((forestryLeafBlock != null) && (drops != null)) 
			{
					drops.invoke(forestryLeafBlock.cast(block), world, X, Y, Z, meta, 1.0F, true);
					drops.invoke(forestryLeafBlock.cast(block), world, X, Y, Z, meta, 1.0F, true);
					drops.invoke(forestryLeafBlock.cast(block), world, X, Y, Z, meta, 1.0F, true);
			}
			else
			{
				forestryLeafBlock = Class.forName("forestry.arboriculture.gadgets.BlockLeaves");
				
				if (forestryLeafBlock != null)
				{	
					drops = forestryLeafBlock.cast(block).getClass().getDeclaredMethod("spawnLeafDrops", World.class, int.class, int.class, int.class, int.class, float.class, boolean.class);
					drops.setAccessible(true);
					extras = true;
				}
			}
		}
		catch (IllegalAccessException e)
		{
			forestryrefcheck = false;
			e.printStackTrace();
		}
		catch (IllegalArgumentException e)
		{
			forestryrefcheck = false;
			e.printStackTrace();
		}
		catch (InvocationTargetException e)
		{
			forestryrefcheck = false;
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			forestryrefcheck = false;
			e.printStackTrace();
		}
		catch (NoSuchMethodException e)
		{
			forestryrefcheck = false;
			e.printStackTrace();
		}
		catch (SecurityException e)
		{
			forestryrefcheck = false;
			e.printStackTrace();
		}
	}
}
