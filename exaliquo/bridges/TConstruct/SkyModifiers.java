package exaliquo.bridges.TConstruct;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.common.Loader;
import tconstruct.library.ActiveToolMod;
import tconstruct.library.tools.AbilityHelper;
import tconstruct.library.tools.ToolCore;
import exnihilo.data.ModData;
import exnihilo.registries.HammerRegistry;
import exnihilo.registries.helpers.Smashable;
import exaliquo.data.ModsLoaded;
import exaliquo.data.ModIDs.Info;
import static exaliquo.data.ModIDs.getIDs;
import static exaliquo.data.ModIDs.getItem;
import static exaliquo.proxy.ForestryReflection.*;

public class SkyModifiers extends ActiveToolMod
{
	
	@Override
	public boolean beforeBlockBreak (ToolCore tool, ItemStack item, int X, int Y, int Z, EntityLivingBase player)
	{
		NBTTagCompound tags = item.getTagCompound().getCompoundTag("InfiTool");
		if (tags.getBoolean("Crooked"))
		{
			World world = player.worldObj;
			int blockID = world.getBlockId(X,Y,Z);
			int meta = world.getBlockMetadata(X, Y, Z);
			boolean validTarget = false;
			boolean extraDropped = false;
	
			Block block = Block.blocksList[blockID];
	
			if (!world.isRemote && block != null && block.isLeaves(world, X, Y, Z))
			{
				if (forestryrefcheck && ModsLoaded.isForestryLoaded)
				{
					ForestryLeaves(world, block, meta, X, Y, Z);
				}
				
				if (!extras)
				{
					block.dropBlockAsItem(world, X, Y, Z, meta, 0);
				}
		
				if (ModData.ALLOW_SILKWORMS && world.rand.nextInt(130) == 0)
				{
					world.spawnEntityInWorld(new EntityItem(world, X + 0.5D, Y + 0.5D, Z + 0.5D, new ItemStack(getItem(Info.silkworm), 1, 0)));
				}
					
				if (blockID == getIDs(Info.silkleaves))
				{
					if (ModData.ALLOW_SILKWORMS && world.rand.nextInt(20) == 0)
					{
						world.spawnEntityInWorld(new EntityItem(world, X + 0.5D, Y + 0.5D, Z + 0.5D, new ItemStack(getItem(Info.silkworm), 1, 0)));
					}
				}
					
				AbilityHelper.damageTool(item, 1, player, false);
			}
			return false;
		}
		if (tags.getBoolean("Hammered"))
		{
		System.out.println("Hammered");
			World world = player.worldObj;
			int blockID = world.getBlockId(X,Y,Z);
			int blockMeta = world.getBlockMetadata(X,Y,Z);
			int fortune = EnchantmentHelper.getFortuneModifier(player);

			ArrayList<Smashable> rewards = HammerRegistry.getRewards(blockID, blockMeta);
			boolean validTarget = false;
			
			if (!rewards.isEmpty())
			{
				Iterator<Smashable> it = rewards.iterator();
				while(it.hasNext())
				{
					Smashable reward = it.next();

					if (!world.isRemote && world.rand.nextFloat() <= reward.chance + (reward.luckMultiplier * fortune))
					{
						EntityItem entityitem = new EntityItem(world, (double)X + 0.5D, (double)Y + 0.5D, (double)Z + 0.5D, new ItemStack(reward.id, 1, reward.meta));

						double f3 = 0.05F;
						entityitem.motionX = world.rand.nextGaussian() * f3;
						entityitem.motionY = (0.2d);
						entityitem.motionZ = world.rand.nextGaussian() * f3;

						world.spawnEntityInWorld(entityitem);
					}

					validTarget = true;
				}

				if (validTarget)
				{
					AbilityHelper.damageTool(item, 1, player, false);
					
					if (!world.isRemote)
					{
						world.destroyBlock(X, Y, Z, false);
					}
				}

				return true;
			}
			else
			{
				return false;
			}
		}
		return false;
	}
	
	@Override
	public int attackDamage (int modDamage, int currentDamage, ToolCore tool, NBTTagCompound tags, NBTTagCompound toolTags, ItemStack stack, EntityLivingBase player, Entity entity)
    {
		if (toolTags.hasKey("Crooked"))
		{
			return 0;
		}
		else return currentDamage;
    }
}