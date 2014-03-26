package exaliquo;

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
import tconstruct.library.tools.ToolCore;
import exnihilo.data.ModData;
import exnihilo.registries.HammerRegistry;
import exnihilo.registries.helpers.Smashable;
import exaliquo.data.ModIDs.Info;
import static exaliquo.data.ModIDs.getIDs;
import static exaliquo.data.ModIDs.getItem;

public class SkyModifiers extends ActiveToolMod
{
	//Break leaf block
	@Override
	public boolean beforeBlockBreak (ToolCore tool, ItemStack item, int X, int Y, int Z, EntityLivingBase player)
	{
		NBTTagCompound tags = item.getTagCompound().getCompoundTag("InfiTool");
		
		if (tags.hasKey("Crooked"))
		{
			System.out.println("Crook test 1");
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
					if (Loader.isModLoaded("Forestry"))
					{
						//Forestry, why? Why did you make me have to do this? We could have been friends...
						Class forestryLeafBlock = null;
						try {
							forestryLeafBlock = Class.forName("forestry.arboriculture.gadgets.BlockLeaves");
	
							Method dropStuff = null;
							if (forestryLeafBlock != null)
							{	
								dropStuff = forestryLeafBlock.cast(block).getClass().getDeclaredMethod("spawnLeafDrops", World.class, int.class, int.class, int.class, int.class, float.class, boolean.class);
								dropStuff.setAccessible(true);
							}
	
							if (dropStuff != null)
							{
								//This gets called once here, and then it drops stuff again when it breaks.
								dropStuff.invoke(forestryLeafBlock.cast(block), world, X, Y, Z, meta, 1.0F, true);
								extraDropped = true;
							}
						}
						catch (Exception ex){}
					}
	
					//If the Forestry method didn't work, try the vanilla way.
					if (!extraDropped)
					{
						//Call it once here and it gets called again when it breaks. 
						block.dropBlockAsItem(world, X, Y, Z, meta, 0);
					}
	
	
					//Silkworms
					if (ModData.ALLOW_SILKWORMS && world.rand.nextInt(1) == 0)
					{
						world.spawnEntityInWorld(new EntityItem(world, X + 0.5D, Y + 0.5D, Z + 0.5D, new ItemStack(getItem(Info.silkworm), 1, 0)));
					}
				}
	
				validTarget = true;
			}
	
			if (blockID == getIDs(Info.silkleaves))
			{
				if (!world.isRemote)
				{
					if (ModData.ALLOW_SILKWORMS && world.rand.nextInt(1) == 0)
					{
						world.spawnEntityInWorld(new EntityItem(world, X + 0.5D, Y + 0.5D, Z + 0.5D, new ItemStack(getItem(Info.silkworm), 1, 0)));
						world.getWorldTime();
					}
				}
	
				validTarget = true;
			}
	
			if (validTarget)
			{
				item.damageItem(1, player);
			}
	
			return false;
		}
		if (tags.hasKey("Hammered"))
		{
			World world = player.worldObj;
			int blockID = world.getBlockId(X,Y,Z);
			int blockMeta = world.getBlockMetadata(X,Y,Z);
			int fortune = EnchantmentHelper.getFortuneModifier(player);

			ArrayList<Smashable> rewards = HammerRegistry.getRewards(blockID, blockMeta);
			boolean validTarget = false;

			if (rewards.size() > 0)
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
					item.damageItem(1, player);
					
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
